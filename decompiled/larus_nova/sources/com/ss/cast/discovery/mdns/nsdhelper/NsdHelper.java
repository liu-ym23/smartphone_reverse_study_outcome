package com.ss.cast.discovery.mdns.nsdhelper;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.Constants;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.StringUtil;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.threadpool.CastThreadExecutorsUtils;
import com.byted.cast.common.threadpool.CastThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.cast.discovery.mdns.INsdHelper;
import com.ss.cast.discovery.mdns.NsdListener;
import com.ss.cast.discovery.mdns.NsdService;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class NsdHelper implements INsdHelper, com.ss.cast.discovery.mdns.b.InterfaceC5461b {
    private static final int MESSAGE_DISCOVERY = 1;
    public static final String MONITOR_ROLE = "nsdmanager";
    private static final String PERMISSION_WIFI_MULTICAST_STATE = "android.permission.CHANGE_WIFI_MULTICAST_STATE";
    private static final String TAG = "NsdHelper";
    private static boolean bLocked = false;
    public static final String errorCodeKey = "errorCode";
    public static final String errorMsgKey = "errorMsg";
    private static final Object mLock = null;
    private static NsdManager mNsdManager = null;
    private static final ExecutorService sExecutor = null;
    private static final Object sMultiCastAcquireLock = null;
    public static final String serviceInfoKey = "serviceInfo";
    public static final String serviceTypeKey = "serviceType";
    private static WifiManager.MulticastLock wifiLock;
    private Map<String, com.ss.cast.discovery.mdns.a> mBuriPointInfos;
    private final ContextManager.CastContext mCastContext;
    private Config mConfig;
    private Map<String, g> mDiscoveryListeners;
    private final Object mDiscoveryLock;
    private long mDiscoveryTimeout;
    private com.ss.cast.discovery.mdns.b mDiscoveryTimer;
    private Handler mHandler;
    private String mLinkName;
    private boolean mLogEnabled;
    private CastLogger mLogger;
    private CastMonitor mMonitor;
    private NsdListener mNsdListener;
    private Map<String, h> mRegistrationListeners;
    private Map<String, i> mResolveListeners;
    private final Object mServiceLock;
    private TeaEventTrack mTeaEventTrack;

    public class NsdHandler extends Handler {
        WeakReference<NsdHelper> mNsdHelper;
        final /* synthetic */ NsdHelper this$0;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            if (this.mNsdHelper.get() != null) goto L5;
            return;
        L5:
            int r101 = r100.what;
        }

        public NsdHandler(NsdHelper r100, WeakReference<NsdHelper> r101, Looper r102) {
            this.this$0 = r100;
            super(r102);
            this.mNsdHelper = r101;
        }
    }

    public static /* synthetic */ void a(NsdHelper r100, h r101, String r102) {
        r100.lambda$unregisterService$1(r101, r102);
    }

    public static /* synthetic */ void b(NsdHelper r100, NsdListener r101, NsdServiceInfo r102, h r103) {
        r100.lambda$registerService$0(r101, r102, r103);
    }

    public static /* synthetic */ void c(NsdHelper r100, NsdServiceInfo r101, boolean r102, NsdListener r103, String r104) {
        r100.lambda$handleFoundService$4(r101, r102, r103, r104);
    }

    public static /* synthetic */ void d(NsdHelper r100, NsdListener r101, String r102, g r103) {
        r100.lambda$startDiscovery$2(r101, r102, r103);
    }

    public static /* synthetic */ void e(NsdHelper r100, g r101, String r102) {
        r100.lambda$stopDiscovery$3(r101, r102);
    }

    public static /* synthetic */ void f(NsdHelper r100, NsdServiceInfo r101, i r102, String r103) {
        r100.lambda$onNsdResolveFailed$5(r101, r102, r103);
    }

    @Override // com.ss.cast.discovery.mdns.INsdHelper
    public int getNsdHelperType() {
        return 1;
    }

    @Override // com.ss.cast.discovery.mdns.b.InterfaceC5461b
    public void onNsdDiscoveryTimeout() {
    }

    @Override // com.ss.cast.discovery.mdns.INsdHelper
    public final /* synthetic */ void setLibraryLoader(ILibraryLoader r100) {
        INsdHelper.CC.$default$setLibraryLoader(this, r100);
    }

    @Override // com.ss.cast.discovery.mdns.INsdHelper
    public void setNsdListener(NsdListener r100) {
    }

    static {
        sExecutor = CastThreadExecutorsUtils.newSingleThreadExecutor(new CastThreadFactory(TAG));
        mLock = new Object();
        bLocked = false;
        sMultiCastAcquireLock = new Object();
    }

    public void finalize() throws Throwable {
        Object r100 = mLock;
        monitor-enter(r100);
        r100.notify();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        super.finalize();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public boolean isLogEnabled() {
        return this.mLogEnabled;
    }

    private void ensureNsdManagerInitialized(NsdListener r100) {
        CastLogger r101 = this.mLogger;
        StringBuilder r102 = new StringBuilder("ensureNsdManagerInitialized: mNsdManager is null: ");
        if (mNsdManager != null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r101.i(TAG, r102.toString());
        if (mNsdManager != null) goto L15;
        mNsdManager = (NsdManager) Constants.sAppContext.getSystemService("servicediscovery");     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        onError(r100, 272145, "NsdManager: getSystemService error: " + e.getMessage());
        return;
    L15:
        return;
    L5:
        r103 = false;
        goto L6
    }

    private void handleBuriPointInfo(NsdServiceInfo r110) {
        String r100 = new NsdService(r110, this.mConfig).toString();
        this.mLogger.d(TAG, "onNsdServiceResolved:" + r100 + ", buri size:" + this.mBuriPointInfos.size());
        String r111 = r110.getServiceType();
        if (r111.endsWith(".") == true) goto L6;
        r111 = r111.concat(".");
    L6:
        if (r111.startsWith(".") == false) goto L8;
        r111 = r111.substring(1);
    L8:
        Iterator<Map.Entry<String, com.ss.cast.discovery.mdns.a>> r101 = this.mBuriPointInfos.entrySet().iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        Map.Entry<String, com.ss.cast.discovery.mdns.a> r102 = r101.next();
        this.mLogger.d(TAG, "onNsdServiceResolved, key:" + r102.getKey() + ", value:" + r102.getValue());
        goto L10
    L12:
        com.ss.cast.discovery.mdns.a r103 = this.mBuriPointInfos.get(r111);
        this.mLogger.i(TAG, "onNsdServiceResolved, buriPointInfo:" + r103 + ", serviceType:" + r111);
        if (r103 != null) goto L15;
        return;
    L15:
        if (r103.f456267a == true) goto L17;
        return;
    L17:
        if (r103.f456268b == true) goto L32;
        r103.f456268b = true;
        this.mLogger.d(TAG, "sendCustomEvent, onNsdServiceResolved");
        this.mMonitor.getSourceMonitor().trackBrowseEvent(MONITOR_ROLE, CastMonitor.NSD_SERVICE_RESOLVED, r100);     // Catch: Exception -> L23
    L27:
        this.mMonitor.getSourceMonitor().trackBrowseEvent(MONITOR_ROLE, CastMonitor.NSD_SERVICE_RESOLVED_EXT, r100);     // Catch: Exception -> L24
    L21:
        this.mLogger.d(TAG, "already found one, send NSD_SERVICE_RESOLVED_EXT");
        return;
    }

    @Override // com.ss.cast.discovery.mdns.INsdHelper
    public void setDiscoveryTimeout(int r100) {
        if (r100 < 0) goto L11;
        if (r100 != 0) goto L5;
        this.mDiscoveryTimeout = SieveCacheKt.NodeLinkMask;
    L6:
        com.ss.cast.discovery.mdns.b r101 = this.mDiscoveryTimer;
        if (r101 == null) goto L12;
        r101.f456271b = this.mDiscoveryTimeout;
        r101.f456272c.removeMessages(0);
        return;
    L12:
        return;
    L5:
        this.mDiscoveryTimeout = r100;
        goto L6
    L11:
        throw new IllegalArgumentException("Timeout has to be greater or equal 0!");
    }

    @Override // com.ss.cast.discovery.mdns.INsdHelper
    public void setLogEnabled(boolean r100) {
        this.mLogEnabled = r100;
    }

    @Override // com.ss.cast.discovery.mdns.INsdHelper
    public void stopDiscovery(final String r110) {
        final g r100 = this.mDiscoveryListeners.get(r110);
        if (r100 != null) goto L6;
        this.mLogger.w(TAG, "stopDiscovery, disListener is null");
        return;
    L6:
        this.mDiscoveryTimer.f456272c.removeMessages(0);
        String r101 = r100.f456304h;
        com.ss.cast.discovery.mdns.a r102 = this.mBuriPointInfos.get(r101);
        this.mLogger.i(TAG, "stopDiscovery, buriInfo:" + r102);
        this.mBuriPointInfos.remove(r101);
        this.mMonitor.getSourceMonitor().trackBrowseEvent(MONITOR_ROLE, CastMonitor.NSD_STOP_DISCOVERY, r101);     // Catch: Exception -> L35
        TeaEventTrack r103 = this.mTeaEventTrack;     // Catch: Exception -> L35
        if (r103 == null) goto L10;
        r103.trackMdnsStopDiscovery("start", MONITOR_ROLE, "", "");     // Catch: Exception -> L35
    L10:
        sExecutor.submit(new e(this, r100, r110));
        Object r111 = sMultiCastAcquireLock;
        monitor-enter(r111);
        WifiManager.MulticastLock r104 = wifiLock;     // Catch: Throwable -> L32
        if (r104 != null) goto L15;
    L20:
        monitor-exit(r111);     // Catch: Throwable -> L32
        Object r105 = mLock;
        monitor-enter(r105);
        r105.notify();     // Catch: Throwable -> L29
        monitor-exit(r105);     // Catch: Throwable -> L29
        Handler r112 = this.mHandler;
        if (r112 == null) goto L44;
        r112.removeCallbacksAndMessages(null);
        return;
    L44:
        return;
    L29:
        th = move-exception;
        throw th;
    L15:
        if (bLocked == false) goto L20;
        bLocked = false;     // Catch: Exception -> L18 Throwable -> L32
        r104.release();     // Catch: Exception -> L18 Throwable -> L32
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L32
        onError(r100.f456303g, 272150, "release wifi lock error: stopDiscovery: " + e.getMessage());     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.cast.discovery.mdns.INsdHelper
    public void unregisterService(final String r100) {
        this.mLogger.i(TAG, "unregisterService, listenerId:" + r100);
        trackMdnsUnregisterEvent("start", "", "");
        this.mMonitor.getSourceMonitor().trackBrowseEvent(MONITOR_ROLE, CastMonitor.NSD_UNREGISTER_SERVICE, r100);     // Catch: Exception -> L5
    L6:
        final h r101 = this.mRegistrationListeners.get(r100);
        if (r101 == null) goto L9;
        sExecutor.submit(new d(this, r101, r100));
    L9:
        Object r102 = sMultiCastAcquireLock;
        monitor-enter(r102);
        WifiManager.MulticastLock r103 = wifiLock;     // Catch: Throwable -> L23
        if (r103 != null) goto L14;
    L21:
        monitor-exit(r102);     // Catch: Throwable -> L23
        return;
    L14:
        if (bLocked == false) goto L21;
        r103.release();     // Catch: Throwable -> L17
        bLocked = false;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L23
        if (r101 == null) goto L21;
        onError(r101.f456308c, 272148, "release wifi lock error: unregister service: " + th.getMessage());     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$stopDiscovery$3(g r100, String r101) {
        Object r102 = this.mDiscoveryLock;
        monitor-enter(r102);
        mNsdManager.stopServiceDiscovery(r100);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
    L10:
        NsdListener r103 = r100.f456303g;     // Catch: Throwable -> L6
        if (r103 == null) goto L13;
        r103.onNsdDiscoveryFinished();     // Catch: Throwable -> L6
    L13:
        this.mDiscoveryListeners.remove(r101);     // Catch: Throwable -> L6
        monitor-exit(r102);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        this.mLogger.w(TAG, "stopDiscovery error:" + e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$unregisterService$1(h r100, String r101) {
        Object r102 = this.mServiceLock;     // Catch: Exception -> L12
        monitor-enter(r102);     // Catch: Exception -> L12
        NsdManager r103 = mNsdManager;     // Catch: Throwable -> L9
        if (r103 == null) goto L7;
        r103.unregisterService(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
    L14:
        this.mRegistrationListeners.remove(r101);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        this.mLogger.w(TAG, "unregisterService:" + e);
        trackMdnsUnregisterEvent("failure", String.valueOf(1), e.toString());
        goto L14
    }

    public void onNsdServiceFound(NsdServiceInfo r100, String r101) {
        com.ss.cast.discovery.mdns.b r102 = this.mDiscoveryTimer;
        if (r102 == null) goto L5;
        r102.f456272c.removeMessages(0);
        r102.f456272c.sendEmptyMessageDelayed(0, r102.f456271b);
    L5:
        g r103 = this.mDiscoveryListeners.get(r101);
        if (r103 == null) goto L11;
        NsdListener r104 = r103.f456303g;
        if (r104 == null) goto L12;
        r104.onNsdServiceFound(new NsdService(r100, this.mConfig));
        handleFoundService(r100, r104, r101, false);
        return;
    L12:
        return;
    }

    @Override // com.ss.cast.discovery.mdns.INsdHelper
    public void stopDiscovery(ContextManager.CastContext r100, String r101) {
        stopDiscovery(r101);
    }

    private /* synthetic */ void lambda$onNsdResolveFailed$5(NsdServiceInfo r100, i r101, String r102) {
        handleFoundService(r100, r101.f456313d, r102, true);
    }

    private /* synthetic */ void lambda$registerService$0(NsdListener r100, NsdServiceInfo r101, h r102) {
        Object r103 = this.mServiceLock;
        monitor-enter(r103);
        ensureNsdManagerInitialized(r100);     // Catch: Throwable -> L9
        NsdManager r104 = mNsdManager;     // Catch: Throwable -> L9
        if (r104 == null) goto L7;
        r104.registerService(r101, 1, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r103);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$startDiscovery$2(NsdListener r100, String r101, g r102) {
        Object r103 = this.mDiscoveryLock;
        monitor-enter(r103);
        ensureNsdManagerInitialized(r100);     // Catch: Throwable -> L9
        NsdManager r104 = mNsdManager;     // Catch: Throwable -> L9
        if (r104 == null) goto L7;
        r104.discoverServices(r101, 1, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r103);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onError(NsdListener r100, int r101, String r102) {
        this.mLogger.e(TAG, "errorCode:" + r101 + ", errorMsg:" + r102);
        if (r100 == null) goto L8;
        r100.onNsdError(r102, r101, TAG);
    L8:
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L7
        r103.put("errorCode", r101);     // Catch: Exception -> L7
        r103.put("errorMsg", r102);     // Catch: Exception -> L7
        r103.put(serviceInfoKey, "");     // Catch: Exception -> L7
        this.mMonitor.getSourceMonitor().trackBrowseEvent(MONITOR_ROLE, CastMonitor.NSD_ONERROR, r103.toString());     // Catch: Exception -> L7
        return;
    }

    private void trackMdnsRegisterEvent(String r100, String r101, String r102) {
        TeaEventTrack r103 = this.mTeaEventTrack;
        if (r103 == null) goto L6;
        r103.trackMdnsRegisterEvent(r100, MONITOR_ROLE, r101, r102);
        return;
    }

    private void trackMdnsUnregisterEvent(String r100, String r101, String r102) {
        TeaEventTrack r103 = this.mTeaEventTrack;
        if (r103 == null) goto L6;
        r103.trackMdnsUnregisterEvent(r100, MONITOR_ROLE, r101, r102);
        return;
    }

    @Override // com.ss.cast.discovery.mdns.INsdHelper
    public String startDiscovery(final String r110, String r111, final NsdListener r112) {
        this.mMonitor.getSourceMonitor().trackBrowseEvent(MONITOR_ROLE, CastMonitor.NSD_START_DISCOVERY, String.format(Locale.SIMPLIFIED_CHINESE, "name:%s, type:%s", new Object[]{r111, r110}));     // Catch: Exception -> L27
        TeaEventTrack r100 = this.mTeaEventTrack;     // Catch: Exception -> L27
        if (r100 == null) goto L6;
        r100.trackMdnsDiscovery("start", MONITOR_ROLE, "", "");     // Catch: Exception -> L27
    L6:
        this.mBuriPointInfos.put(r110, new com.ss.cast.discovery.mdns.a(r110));
        this.mLogger.i(TAG, "startDiscovery, type:" + r110 + ", name:" + r111 + ", buri size:" + this.mBuriPointInfos.size());
        com.ss.cast.discovery.mdns.b r113 = this.mDiscoveryTimer;
        r113.f456272c.sendEmptyMessageDelayed(0, r113.f456271b);
        Object r114 = sMultiCastAcquireLock;
        monitor-enter(r114);
        WifiManager.MulticastLock r101 = wifiLock;     // Catch: Throwable -> L24
        if (r101 != null) goto L11;
    L21:
        monitor-exit(r114);     // Catch: Throwable -> L24
        final g r115 = new g(this.mCastContext, this, r112, r110);
        this.mDiscoveryListeners.put(r115.f456302f, r115);
        sExecutor.submit(new c(this, r112, r110, r115));
        return r115.f456302f;
    L11:
        if (bLocked == true) goto L21;
        r101.acquire();     // Catch: Throwable -> L14
        bLocked = true;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
        onError(r112, 272149, "acquire wifi lock error: startDiscovery: " + th.getMessage());     // Catch: Throwable -> L24
        TeaEventTrack r116 = this.mTeaEventTrack;     // Catch: Throwable -> L24
        if (r116 == null) goto L19;
        r116.trackMdnsDiscovery("failure", MONITOR_ROLE, String.valueOf(1), "");     // Catch: Throwable -> L24
    L19:
        return null;
    L24:
        th = move-exception;
        throw th;
    }

    private NsdHelper(Context r100, ContextManager.CastContext r101, NsdListener r110, String r111) {
        this.mLinkName = "";
        this.mServiceLock = new Object();
        this.mDiscoveryTimeout = 15;
        this.mDiscoveryLock = new Object();
        this.mBuriPointInfos = new ConcurrentHashMap();
        this.mRegistrationListeners = new ConcurrentHashMap();
        this.mDiscoveryListeners = new ConcurrentHashMap();
        this.mResolveListeners = new ConcurrentHashMap();
        boolean r102 = false;
        this.mLogEnabled = false;
        this.mNsdListener = r110;
        this.mCastContext = r101;
        this.mMonitor = ContextManager.getMonitor(r101);
        this.mLogger = ContextManager.getLogger(r101);
        this.mTeaEventTrack = ContextManager.getTeaEventTrack(r101);
        this.mConfig = ContextManager.getConfigManager(r101).getInitConfig();
        this.mDiscoveryTimer = new com.ss.cast.discovery.mdns.b(this, this.mDiscoveryTimeout);
        if (this.mHandler != null) goto L5;
        this.mHandler = new NsdHandler(this, new WeakReference(this), Dispatcher.getInstance().getByteCastThreadLooper());
    L5:
        Object r103 = sMultiCastAcquireLock;
        monitor-enter(r103);
        String[] r104 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 4096).requestedPermissions;     // Catch: Throwable -> L18 PackageManager.NameNotFoundException -> L20
        if (r104 != null) goto L11;
    L22:
        if (r102 == true) goto L24;
    L26:
        monitor-exit(r103);     // Catch: Throwable -> L18
        if (mNsdManager != null) goto L30;
        mNsdManager = (NsdManager) r100.getSystemService("servicediscovery");
    L30:
        this.mLinkName = r111;
        return;
    L24:
        if (wifiLock != null) goto L26;
        WifiManager.MulticastLock r112 = ((WifiManager) r100.getApplicationContext().getSystemService("wifi")).createMulticastLock("localWifi");     // Catch: Throwable -> L18
        wifiLock = r112;     // Catch: Throwable -> L18
        r112.setReferenceCounted(true);     // Catch: Throwable -> L18
        goto L26
    L11:
        if (r104.length <= 0) goto L22;
        int r105 = r104.length;     // Catch: Throwable -> L18 PackageManager.NameNotFoundException -> L20
        int r106 = 0;
    L13:
        if (r106 >= r105) goto L22;
        if (PERMISSION_WIFI_MULTICAST_STATE.equals(r104[r106]) == true) goto L16;
        r106 = r106 + 1;
        goto L13
    L16:
        r102 = true;
        goto L22
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        onError(r110, 272151, "get multicast lock failed:" + e.getMessage());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static NsdHelper createInstance(Context r100, ContextManager.CastContext r101, NsdListener r102, String r103) {
        return new NsdHelper(r100, r101, r102, r103);
    }

    private void handleFoundService(final NsdServiceInfo r100, final NsdListener r110, final String r111, final boolean r112) {
        sExecutor.submit(new a(this, r100, r112, r110, r111));
    }

    private /* synthetic */ void lambda$handleFoundService$4(NsdServiceInfo r110, boolean r111, NsdListener r112, String r113) {
        this.mMonitor.getSourceMonitor().trackBrowseEvent(MONITOR_ROLE, CastMonitor.NSD_START_RESOLVE, r110.toString());     // Catch: Exception -> L20
        TeaEventTrack r100 = this.mTeaEventTrack;     // Catch: Exception -> L20
        if (r100 == null) goto L5;
        r100.trackMdnsResolve("start", MONITOR_ROLE, "", "", r111);     // Catch: Exception -> L20
    L5:
        Object r101 = mLock;
        monitor-enter(r101);
        i r102 = new i(this.mCastContext, this, r112, r113, r111);     // Catch: Throwable -> L17
        this.mResolveListeners.put(r102.f456312c, r102);     // Catch: Throwable -> L17
        NsdManager r114 = mNsdManager;     // Catch: Throwable -> L17
        if (r114 == null) goto L25;
        r114.resolveService(r110, r102);     // Catch: Throwable -> L17
    L25:
        r101.wait(1000);     // Catch: InterruptedException -> L13 Throwable -> L17
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L17
        this.mLogger.i(TAG, "finished resolving service name:" + r110.getServiceName() + ", type:" + r110.getServiceType() + ", port:" + r110.getPort() + "...");
        return;
    L13:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public void onNsdServiceResolved(NsdServiceInfo r110, String r111, String r112, boolean r210) {
        Object r100 = mLock;
        monitor-enter(r100);
        r100.notify();     // Catch: Throwable -> L28
        monitor-exit(r100);     // Catch: Throwable -> L28
        i r101 = this.mResolveListeners.get(r111);
        if (r101 != null) goto L12;
        this.mLogger.w(TAG, "onNsdServiceResolved, resolveListener is null");
        TeaEventTrack r102 = this.mTeaEventTrack;
        if (r102 == null) goto L33;
        r102.trackMdnsResolve("failure", MONITOR_ROLE, String.valueOf(2), "", r210);
        return;
    L33:
        return;
    L12:
        g r103 = this.mDiscoveryListeners.get(r112);
        if (r103 == null) goto L15;
        r103.f456305i = 0;
    L15:
        handleBuriPointInfo(r110);
        com.ss.cast.discovery.mdns.b r104 = this.mDiscoveryTimer;
        if (r104 == null) goto L18;
        r104.f456272c.removeMessages(0);
        r104.f456272c.sendEmptyMessageDelayed(0, r104.f456271b);
    L18:
        NsdListener r105 = r101.f456313d;
        if (r105 == null) goto L23;
        r105.onNsdServiceResolved(new NsdService(r110, this.mConfig));
        TeaEventTrack r106 = this.mTeaEventTrack;
        if (r106 == null) goto L26;
        r106.trackMdnsResolve("success", MONITOR_ROLE, "", "", r210);
    L26:
        this.mResolveListeners.remove(r111);
        return;
    L23:
        TeaEventTrack r113 = this.mTeaEventTrack;
        if (r113 == null) goto L26;
        r113.trackMdnsResolve("failure", MONITOR_ROLE, String.valueOf(3), "", r210);
    L28:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.cast.discovery.mdns.INsdHelper
    public String startDiscovery(ContextManager.CastContext r100, String r101, String r102, NsdListener r103) {
        return startDiscovery(r101, r102, r103);
    }

    public void onNsdResolveFailed(final NsdServiceInfo r110, String r111, final String r112, int r113, boolean r114) {
        Object r100 = mLock;
        monitor-enter(r100);
        r100.notify();     // Catch: Throwable -> L23
        monitor-exit(r100);     // Catch: Throwable -> L23
        final i r101 = this.mResolveListeners.get(r111);
        if (r101 != null) goto L12;
        this.mLogger.w(TAG, "onNsdResolveFailed, resolveListener is null");
        TeaEventTrack r102 = this.mTeaEventTrack;
        if (r102 == null) goto L31;
        r102.trackMdnsResolve("failure", MONITOR_ROLE, String.valueOf(2), String.valueOf(r113), r114);
        return;
    L31:
        return;
    L12:
        g r103 = this.mDiscoveryListeners.get(r112);
        if (r103 == null) goto L32;
        int r104 = r103.f456305i + 1;
        r103.f456305i = r104;
        if (r104 <= 4) goto L21;
        r103.f456305i = 0;
        this.mResolveListeners.remove(r111);
        JSONObject r115 = new JSONObject();     // Catch: Exception -> L26
        r115.put("errorCode", r113);     // Catch: Exception -> L26
        r115.put(serviceInfoKey, r110);     // Catch: Exception -> L26
        this.mMonitor.getSourceMonitor().trackBrowseEvent(MONITOR_ROLE, CastMonitor.NSD_SERVICE_RESOLVE_FAILURE, r115.toString());     // Catch: Exception -> L26
        TeaEventTrack r105 = this.mTeaEventTrack;     // Catch: Exception -> L26
        if (r105 == null) goto L33;
        r105.trackMdnsResolve("failure", MONITOR_ROLE, String.valueOf(1), String.valueOf(r113), r114);     // Catch: Exception -> L26
        return;
    L33:
        return;
    L35:
        return;
    L21:
        this.mResolveListeners.remove(r111);
        this.mHandler.postDelayed(new b(this, r110, r101, r112), 200);
        return;
    L32:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.cast.discovery.mdns.INsdHelper
    public String registerService(String r110, String r111, int r112, Map<String, String> r210, final NsdListener r211) {
        this.mLogger.i(TAG, "registerService, serviceType:" + r111 + ", attrs:" + StringUtil.transMapToString(r210));
        trackMdnsRegisterEvent("start", "", "");
        if (TextUtils.isEmpty(r110) == false) goto L33;
        onError(r211, 272146, "service name cannot empty");
        trackMdnsRegisterEvent("failure", String.valueOf(1), "");
        return null;
    L33:
        this.mMonitor.getSourceMonitor().trackBrowseEvent(MONITOR_ROLE, CastMonitor.NSD_REGISTER_SERVICE, String.format(Locale.SIMPLIFIED_CHINESE, "name:%s, type:%s, port:%d, attrs:%s", new Object[]{r110, r111, Integer.valueOf(r112), StringUtil.transMapToString(r210)}));     // Catch: Exception -> L30
    L8:
        Object r100 = sMultiCastAcquireLock;
        monitor-enter(r100);
        WifiManager.MulticastLock r101 = wifiLock;     // Catch: Throwable -> L27
        if (r101 != null) goto L13;
    L20:
        monitor-exit(r100);     // Catch: Throwable -> L27
        final NsdServiceInfo r102 = new NsdServiceInfo();
        r102.setServiceName(r110);
        r102.setServiceType(r111);
        r102.setPort(r112);
        Iterator<Map.Entry<String, String>> r103 = r210.entrySet().iterator();
    L23:
        if (r103.hasNext() == false) goto L25;
        Map.Entry<String, String> r104 = r103.next();
        r102.setAttribute(r104.getKey(), r104.getValue());
        goto L23
    L25:
        final h r105 = new h(this, r211, this.mTeaEventTrack);
        this.mRegistrationListeners.put(r105.f456307b, r105);
        this.mLogger.i(TAG, "registerService, regInfo:" + new NsdService(r102, this.mConfig));
        sExecutor.submit(new f(this, r211, r102, r105));
        return r105.f456307b;
    L13:
        if (bLocked == true) goto L20;
        r101.acquire();     // Catch: Throwable -> L16
        bLocked = true;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L27
        onError(r211, 272147, "acquire wifi lock error: register service: " + th.getMessage());     // Catch: Throwable -> L27
        trackMdnsRegisterEvent("failure", String.valueOf(2), "");     // Catch: Throwable -> L27
        return null;
    L27:
        th = move-exception;
        throw th;
    }
}
