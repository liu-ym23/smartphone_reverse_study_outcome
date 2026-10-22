package com.ss.cast.discovery.nsd;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.MainThreadExecutor;
import com.byted.cast.common.NetworkUtil;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.api.IBrowseListener;
import com.byted.cast.common.api.ICastSource;
import com.byted.cast.common.api.IConnectListener;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.api.IPlayerListener;
import com.byted.cast.common.api.IWriteCacheListener;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.network.NetworkMonitor;
import com.byted.cast.common.source.IClient;
import com.byted.cast.common.source.SearchType;
import com.byted.cast.common.source.ServiceInfo;
import com.byted.cast.common.threadpool.CastThreadFactory;
import com.byted.cast.common.threadpool.CastThreadPoolExecutor;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.cast.discovery.mdns.INsdHelper;
import com.ss.cast.discovery.mdns.NsdFactory;
import com.ss.cast.discovery.mdns.NsdListener;
import com.ss.cast.discovery.mdns.NsdService;
import com.ss.cast.discovery.mdns.NsdType;
import com.ss.cast.discovery.mdns.NsdUtils;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes40.dex */
public final class NsdClient implements IClient {
    public boolean A;
    public ILogger B;
    public String C;
    public final Object D;
    public CastThreadPoolExecutor E;
    public final b F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f456316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContextManager.CastContext f456317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CastLogger f456318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CastMonitor f456319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TeaEventTrack f456320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f456321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MainThreadExecutor f456322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IConnectListener f456323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IBrowseListener f456324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IPlayerListener f456325j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public INsdHelper f456326k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f456327l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f456328m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f456329n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<String> f456330o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, NsdService> f456331p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, ServiceInfo> f456332q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public IWriteCacheListener f456333r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ICastSource f456334s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ICastSource f456335t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ILibraryLoader f456336u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public NetworkMonitor f456337v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f456338w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f456339x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f456340y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f456341z;

    public static final enum NsdInfoType extends Enum<NsdInfoType> {
        public static final NsdInfoType NSD_LOST = null;
        public static final NsdInfoType NSD_RESOLVED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NsdInfoType[] f456342a = null;

        static {
            NsdInfoType r100 = new NsdInfoType("NSD_RESOLVED", 0);
            NSD_RESOLVED = r100;
            NsdInfoType r101 = new NsdInfoType("NSD_LOST", 1);
            NSD_LOST = r101;
            f456342a = new NsdInfoType[]{r100, r101};
        }

        public static NsdInfoType[] values() {
            return (NsdInfoType[]) f456342a.clone();
        }

        public static NsdInfoType valueOf(String r100) {
            return (NsdInfoType) r27.a.a(NsdInfoType.class, r100);
        }

        public NsdInfoType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements NetworkMonitor.INetworkChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NsdClient f456343a;

        public a(NsdClient r100) {
            this.f456343a = r100;
        }

        @Override // com.byted.cast.common.network.NetworkMonitor.INetworkChangeListener
        public final void onLost(NetworkUtil.NetworkType r100) {
            NsdClient r101 = this.f456343a;
            if (r101.f456341z == false) goto L8;
            r101.f456318c.i("NsdClient", "onLost, clear all browse list!");
            if (r101.f456339x == false) goto L9;
            r101.stopBrowse();
            r101.f456339x = true;
            return;
        L9:
            return;
        }

        @Override // com.byted.cast.common.network.NetworkMonitor.INetworkChangeListener
        public final void onAvailable(NetworkUtil.NetworkType r100, NetworkUtil.NetworkType r101) {
            NsdClient r102 = this.f456343a;
            if (r102.f456341z == false) goto L8;
            r102.f456318c.i("NsdClient", "onAvailable:" + r102.f456339x);
            if (r102.f456339x == false) goto L9;
            Dispatcher.getInstance().getByteCastHandler().postDelayed(new h(r102), 200);
            return;
        L9:
            return;
        }
    }

    public class b implements NsdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NsdClient f456344a;

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdRegistered(NsdService r100) {
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdUnRegistered(NsdService r100) {
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdDiscoveryFinished() {
            this.f456344a.f456318c.i("NsdClient", "onNsdDiscoveryFinished");
            this.f456344a.f456322g.execute(new i(this));
        }

        public b(NsdClient r100) {
            this.f456344a = r100;
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdServiceFound(NsdService r100) {
            this.f456344a.f456318c.i("NsdClient", "onNsdServiceFound: " + r100);
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdServiceLost(NsdService r100) {
            ((ConcurrentHashMap) this.f456344a.f456331p).remove(r100.getName());
            this.f456344a.f456318c.i("NsdClient", "onNsdServiceLost:" + r100 + ", size:" + ((ConcurrentHashMap) this.f456344a.f456331p).size());
            this.f456344a.b(r100);
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdServiceResolved(NsdService r100) {
            ((ConcurrentHashMap) this.f456344a.f456331p).put(r100.getName(), r100);
            this.f456344a.f456318c.i("NsdClient", "onNsdServiceResolved:" + r100 + ", size:" + ((ConcurrentHashMap) this.f456344a.f456331p).size());
            NsdClient r101 = this.f456344a;
            Object r102 = r101.D;
            monitor-enter(r102);
            CastThreadPoolExecutor r103 = r101.E;     // Catch: Throwable -> L12
            if (r103 != null) goto L9;
            r101.f456318c.i("NsdClient", "handleResolvedService: mNsdExecutor is null");     // Catch: Throwable -> L12
            monitor-exit(r102);     // Catch: Throwable -> L12
            return;
        L9:
            r103.submit(new k(r101, r100));     // Catch: Throwable -> L12
            monitor-exit(r102);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdError(String r100, int r101, String r102) {
            this.f456344a.f456318c.w("NsdClient", "onNsdError, errorMessage:" + r100 + ", errorCode:" + r101 + ", errorSource:" + r102);
            IPlayerListener r103 = this.f456344a.f456325j;
            if (r103 == null) goto L5;
            r103.onError(IPlayerListener.MDNS_ERROR, r101);
        L5:
            this.f456344a.f456322g.execute(new j(this));
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NsdService f456345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NsdClient f456346b;

        public final void a() {
            this.f456346b.f456318c.i("NsdClient", "lost, NsdService:" + this.f456345a);
            Iterator r100 = ((ConcurrentHashMap) this.f456346b.f456332q).entrySet().iterator();
        L4:
            if (r100.hasNext() == false) goto L8;
            Map.Entry r101 = (Map.Entry) r100.next();
            if (TextUtils.equals(((ServiceInfo) r101.getValue()).name, this.f456345a.getName()) == false) goto L4;
            ((ConcurrentHashMap) this.f456346b.f456332q).remove(r101.getKey());
            this.f456346b.d(CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_LOST);
            goto L4
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(NsdClient r100, NsdService r101) {
            this.f456346b = r100;
            this.f456345a = r101;
        }
    }

    @Override // com.byted.cast.common.source.IClient
    public final void setBrowseTime(int r100) {
    }

    @Override // com.byted.cast.common.source.IClient
    public final void destroy() {
        this.f456318c.i("NsdClient", MapMonitorConst.EVENT_DESTROY);
        if (this.f456338w == true) goto L6;
        this.f456318c.w("NsdClient", "destroy, not inited!");
        return;
    L6:
        Object r100 = this.D;
        monitor-enter(r100);
        CastThreadPoolExecutor r101 = this.E;     // Catch: Throwable -> L11
        if (r101 == null) goto L13;
        r101.shutdownNow();     // Catch: Throwable -> L11
        this.E = null;     // Catch: Throwable -> L11
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L11
        NetworkMonitor r102 = this.f456337v;
        if (r102 == null) goto L17;
        r102.stop();
    L17:
        this.f456338w = false;
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.common.source.IClient
    public final synchronized void startBrowse() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (DLNAOptionUtils.isEnableMdnsSearch(this.f456317b) == true) goto L9;
        this.f456318c.d("NsdClient", "startBrowse, isEnableMdnsSearch is false");     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L9:
        this.f456318c.i("NsdClient", "startBrowse, mServiceType:" + this.f456328m);     // Catch: Throwable -> L23
        INsdHelper r100 = this.f456326k;     // Catch: Throwable -> L23
        if (r100 == null) goto L14;
        String r101 = this.C;     // Catch: Throwable -> L23
        if (r101 == null) goto L14;
        r100.stopDiscovery(this.f456317b, r101);     // Catch: Throwable -> L23
        this.f456326k = null;     // Catch: Throwable -> L23
    L14:
        boolean r102 = NsdUtils.isDnssdEnabledFromGrayConfig(this.f456317b);     // Catch: Throwable -> L23
        boolean r103 = NsdUtils.isDnssdEnabledFromLocalConfig(this.f456317b);     // Catch: Throwable -> L23
        NsdFactory.Type r104 = NsdUtils.getNsdType(this.f456317b);     // Catch: Throwable -> L23
        this.f456318c.i("NsdClient", "startBrowse, enableDnssd:" + r102 + ", forceDnssd: " + r103 + ", type:" + r104);     // Catch: Throwable -> L23
        INsdHelper r105 = NsdFactory.createNsdHelper(r104, this.f456316a, this.f456317b, this.F, "NsdClient", this.f456336u);     // Catch: Throwable -> L23
        this.f456326k = r105;     // Catch: Throwable -> L23
        if (r105 == null) goto L18;
        r105.setDiscoveryTimeout(0);     // Catch: Throwable -> L23
        this.f456326k.setLogEnabled(this.f456321f);     // Catch: Throwable -> L23
        this.C = this.f456326k.startDiscovery(this.f456317b, this.f456328m, "BDLink", this.F);     // Catch: Throwable -> L23
        this.f456318c.i("NsdClient", "mNsdHelper.startDiscovery, mDiscoveryId:" + this.C);     // Catch: Throwable -> L23
    L18:
        if (((ConcurrentHashMap) this.f456332q).isEmpty() == true) goto L20;
        d("cache");     // Catch: Throwable -> L23
    L20:
        this.f456339x = true;     // Catch: Throwable -> L23
        monitor-exit(this);
    }

    @Override // com.byted.cast.common.source.IClient
    public final synchronized void stopBrowse() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (DLNAOptionUtils.isEnableMdnsSearch(this.f456317b) == true) goto L9;
        this.f456318c.d("NsdClient", "stopBrowse, isEnableMdnsSearch is false");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L9:
        this.f456318c.i("NsdClient", "stopBrowse, mServiceType: " + this.f456328m);     // Catch: Throwable -> L17
        INsdHelper r100 = this.f456326k;     // Catch: Throwable -> L17
        if (r100 == null) goto L14;
        String r101 = this.C;     // Catch: Throwable -> L17
        if (r101 == null) goto L14;
        r100.stopDiscovery(this.f456317b, r101);     // Catch: Throwable -> L17
        this.f456318c.i("NsdClient", "mNsdHelper.stopDiscovery, mDiscoveryId: " + this.C);     // Catch: Throwable -> L17
        this.f456326k = null;     // Catch: Throwable -> L17
    L14:
        ((ConcurrentHashMap) this.f456331p).clear();     // Catch: Throwable -> L17
        ((ConcurrentHashMap) this.f456332q).clear();     // Catch: Throwable -> L17
        d("stop");     // Catch: Throwable -> L17
        this.f456339x = false;     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public final int a(byte[] r100) {
        if (r100 != null) goto L11;
        this.f456318c.i("NsdClient", "fromByteArray, bytes is null");
        return 0;
    L11:
        int r101 = CastIntegerProtector.parseInt(new String(r100));     // Catch: Exception -> L8
        this.f456318c.i("NsdClient", "fromByteArray, length:" + r100.length + ", ret:" + r101);     // Catch: Exception -> L8
        return r101;
    L8:
        e = move-exception;
        this.f456318c.i("NsdClient", "fromByteArray, exception: " + e);
        return 0;
    }

    public final void b(NsdService r100) {
        if (r100 != null) goto L5;
        this.f456318c.i("NsdClient", "handNsdServiceLost: nsdService is null");
        return;
    L5:
        Object r101 = this.D;
        monitor-enter(r101);
        CastThreadPoolExecutor r102 = this.E;     // Catch: Throwable -> L15
        if (r102 != null) goto L12;
        this.f456318c.w("NsdClient", "handNsdServiceLost: mNsdExecutor is null");     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L12:
        r102.submit(new c(this, r100));     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final boolean c(ServiceInfo r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        this.f456318c.i("NsdClient", "hasSameDevice: serviceInfo:" + r100);
        Iterator r101 = ((ConcurrentHashMap) this.f456332q).values().iterator();
    L7:
        if (r101.hasNext() == false) goto L17;
        ServiceInfo r102 = (ServiceInfo) r101.next();
        if (r102 == null) goto L7;
        this.f456318c.v("NsdClient", "hasSameDevice: serviceInfo in list:" + r102);
        if (TextUtils.equals(r102.f33719ip, r100.f33719ip) == false) goto L7;
        if (r102.port != r100.port) goto L7;
        return true;
    L17:
        return false;
    }

    public final void d(String r100) {
        this.f456319d.getSourceMonitor().trackNsdBrowseSuccessEvent(r100);
        this.f456322g.execute(new g(this));
    }

    @Override // com.byted.cast.common.source.IClient
    public final List<ServiceInfo> getDeviceList(SearchType r100) {
        return new ArrayList(((ConcurrentHashMap) this.f456332q).values());
    }

    @Override // com.byted.cast.common.source.IClient
    public final void init(Context r110) {
        this.f456318c.i("NsdClient", "init");
        if (this.f456338w == false) goto L6;
        this.f456318c.w("NsdClient", "init, already inited");
        return;
    L6:
        this.f456316a = r110;
        Config r111 = ContextManager.getConfigManager(this.f456317b).getInitConfig();
        this.f456321f = r111.isEnableDebug();
        this.f456340y = r111.isEnableBdlinkSourceMdnsIpv6();
        setPrivateChannel(r111.getPrivateChannel());
        String r112 = r111.getLocalProtocols();
        boolean r100 = false;
        if (TextUtils.isEmpty(r112) == false) goto L9;
    L13:
        boolean r101 = false;
    L14:
        this.f456341z = r101;
        if (TextUtils.isEmpty(r112) == false) goto L17;
    L19:
        this.A = r100;
        if (this.f456337v != null) goto L22;
        this.f456337v = new NetworkMonitor(this.f456317b, 1, new a(this));
    L22:
        this.E = new CastThreadPoolExecutor(4, 32, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(64), new CastThreadFactory("NsdClient"));
        NetworkMonitor r113 = this.f456337v;
        if (r113 == null) goto L25;
        r113.start();
    L25:
        this.f456338w = true;
        return;
    L17:
        if (r112.contains("BDLink") == false) goto L19;
        r100 = true;
        goto L19
    L9:
        if (r112.contains("BDLink") == false) goto L11;
    L12:
        r101 = true;
        goto L14
    L11:
        if (r112.contains("ByteLink") == false) goto L13;
        goto L12
    }

    @Override // com.byted.cast.common.source.IClient
    public final void onAppendBDLinkInfoSuccess(ServiceInfo r100) {
        NsdService r101 = new NsdService(r100.name, this.f456327l, r100.f33719ip, "", r100.port, null);
        r100.setSupportDetect(true);
        r100.setPrivateChannel(this.f456327l);
        Map<String, NsdService> r102 = this.f456331p;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(r101.getName(), r101);
        Map<String, ServiceInfo> r104 = this.f456332q;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(r100.name, r100);
        d("append");
    }

    @Override // com.byted.cast.common.source.IClient
    public final void onDeviceOffline(ServiceInfo r100) {
        if (DLNAOptionUtils.isEnableMdnsSearch(this.f456317b) == true) goto L6;
        this.f456318c.d("NsdClient", "onDeviceOffline, isEnableMdnsSearch is false");
        return;
    L6:
        monitor-enter(this);
        INsdHelper r101 = this.f456326k;     // Catch: Throwable -> L24
        if (r101 != null) goto L12;
        this.f456318c.w("NsdClient", "onDeviceOffline, mNsdHelper is null");     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L12:
        int r102 = r101.getNsdHelperType();     // Catch: Throwable -> L24
        if (r102 != 1) goto L16;
        this.f456319d.getSourceMonitor().trackBrowseEvent(NsdHelper.MONITOR_ROLE, CastMonitor.NSD_SERVICE_OFFLINE, r100.toString());     // Catch: Throwable -> L24
    L21:
        monitor-exit(this);     // Catch: Throwable -> L24
        NsdService r103 = (NsdService) ((ConcurrentHashMap) this.f456331p).get(r100.name);
        ((ConcurrentHashMap) this.f456331p).remove(r100.name);
        this.f456318c.i("NsdClient", "onDeviceOffline:" + r100 + "offlineService " + r103 + ", size:" + ((ConcurrentHashMap) this.f456331p).size());
        b(r103);
        return;
    L16:
        if (r102 != 2) goto L19;
        this.f456319d.getSourceMonitor().trackBrowseEvent("dnssd", CastMonitor.NSD_SERVICE_OFFLINE, r100.toString());     // Catch: Throwable -> L24
        goto L21
    L19:
        if (r102 != 3) goto L21;
        this.f456319d.getSourceMonitor().trackBrowseEvent("jmdns", CastMonitor.NSD_SERVICE_OFFLINE, r100.toString());     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.common.source.IClient
    public final void onDiskCacheFoundService(ServiceInfo r100) {
        if (DLNAOptionUtils.isEnableMdnsSearch(this.f456317b) == true) goto L6;
        this.f456318c.d("NsdClient", "onDiskCacheFoundService, isEnableMdnsSearch is false");
        return;
    L6:
        r100.portMirror = 0;
        if (c(r100) == true) goto L10;
        NsdService r101 = new NsdService(r100.name, this.f456327l, r100.f33719ip, "", r100.port, null);
        Map<String, NsdService> r102 = this.f456331p;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(r101.getName(), r101);
        Map<String, ServiceInfo> r104 = this.f456332q;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(r100.name, r100);
        d("diskCache");
        return;
    }

    @Override // com.byted.cast.common.source.IClient
    public final void setBrowseResultListener(IBrowseListener r100) {
        this.f456324i = r100;
    }

    @Override // com.byted.cast.common.source.IClient
    public final void setConnectListener(IConnectListener r100) {
        this.f456323h = r100;
    }

    @Override // com.byted.cast.common.source.IClient
    public final void setLibraryLoader(ILibraryLoader r100) {
        this.f456336u = r100;
    }

    @Override // com.byted.cast.common.source.IClient
    public final void setLogger(ILogger r100) {
        this.B = r100;
    }

    @Override // com.byted.cast.common.source.IClient
    public final void setPlayerListener(IPlayerListener r100) {
        this.f456325j = r100;
    }

    @Override // com.byted.cast.common.source.IClient
    public final void setPrivateChannel(String r100) {
        this.f456318c.i("NsdClient", "setPrivateChannel: " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f456327l = "BDLink";
        this.f456328m = NsdType.BDLINK;
        return;
    L5:
        this.f456327l = r100;
        this.f456328m = String.format(NsdType.PRIVATE, new Object[]{r100});
    }

    @Override // com.byted.cast.common.source.IClient
    public final void setWriteCacheListener(IWriteCacheListener r100) {
        this.f456333r = r100;
    }

    @Override // com.byted.cast.common.source.IClient
    public final void setOption(int r100, Object... r101) {
        if (r100 == 10011) goto L12;
        switch(r100) {
            case 100041: goto L9;
            case 100042: goto L6;
            default: goto L24;
        };
    L6:
        Object r102 = r101[0];
        if ((r102 instanceof ILogger) == false) goto L18;
        ILogger r103 = (ILogger) r102;
        this.B = r103;
        Objects.toString(r103);
        return;
    L18:
        return;
    L9:
        Object r104 = r101[0];
        if ((r104 instanceof ILibraryLoader) == false) goto L20;
        this.f456336u = (ILibraryLoader) r104;
        this.f456318c.i("NsdClient", "OPTION_SET_LIBRARY_LOADER:" + this.f456336u);
        return;
    L20:
        return;
    L24:
        return;
    L12:
        Object r105 = r101[0];
        if ((r105 instanceof List) == false) goto L22;
        Object r106 = r101[1];
        if ((r106 instanceof List) == false) goto L23;
        this.f456329n = (List) r105;
        this.f456330o = (List) r106;
        this.f456318c.i("NsdClient", "OPTION_PROTOCOLS_ENABLED, link:" + this.f456329n + ", mirror:" + this.f456330o);
        return;
    L23:
        return;
    }

    public NsdClient(ContextManager.CastContext r100, ICastSource r101, ICastSource r102) {
        this.f456321f = false;
        this.f456322g = new MainThreadExecutor();
        this.f456327l = "BDLink";
        this.f456328m = NsdType.BDLINK;
        this.f456331p = new ConcurrentHashMap();
        this.f456332q = new ConcurrentHashMap();
        this.f456338w = false;
        this.f456339x = false;
        this.f456340y = false;
        this.f456341z = false;
        this.A = false;
        this.D = new Object();
        this.F = new b(this);
        this.f456317b = r100;
        this.f456318c = ContextManager.getLogger(r100);
        this.f456319d = ContextManager.getMonitor(r100);
        this.f456320e = ContextManager.getTeaEventTrack(r100);
        this.f456334s = r101;
        this.f456335t = r102;
    }
}
