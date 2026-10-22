package com.ss.cast.source;

import android.content.Context;
import android.media.projection.MediaProjection;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import com.byted.cast.common.BuildConfig;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.Constants;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.DeviceInfoManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.ErrorCode;
import com.byted.cast.common.MainThreadExecutor;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.Utils;
import com.byted.cast.common.api.IAppCommonDataListener;
import com.byted.cast.common.api.IBindSdkInfoListener;
import com.byted.cast.common.api.IBrowseListener;
import com.byted.cast.common.api.ICastSource;
import com.byted.cast.common.api.IConnectListener;
import com.byted.cast.common.api.IGetDeviceInfoListener;
import com.byted.cast.common.api.IHttpNetWork;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.api.IMonitor;
import com.byted.cast.common.api.IPlayerListener;
import com.byted.cast.common.api.IRegisterResultListener;
import com.byted.cast.common.api.IResultListener;
import com.byted.cast.common.api.IServerListener;
import com.byted.cast.common.api.ISurfaceListener;
import com.byted.cast.common.api.IWriteCacheListener;
import com.byted.cast.common.api.MirrorInfo;
import com.byted.cast.common.api.PlayerInfo;
import com.byted.cast.common.api.inner.ConnectCode;
import com.byted.cast.common.api.inner.ErrorCodeUtils;
import com.byted.cast.common.async.ConcurrentSubject;
import com.byted.cast.common.async.Observer;
import com.byted.cast.common.auth.ICastAuth;
import com.byted.cast.common.bean.BytecastBrowseType;
import com.byted.cast.common.bean.DanmakuBean;
import com.byted.cast.common.bean.DeviceInfo;
import com.byted.cast.common.bean.DeviceOfflineDetectSettings;
import com.byted.cast.common.bean.DramaBean;
import com.byted.cast.common.bean.Resolution;
import com.byted.cast.common.bean.SourceDeviceInfo;
import com.byted.cast.common.bean.Speed;
import com.byted.cast.common.bean.Subtitle;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.config.ConfigManager;
import com.byted.cast.common.config.IInitListener;
import com.byted.cast.common.config.IMediaInfoListener;
import com.byted.cast.common.network.NetworkManager;
import com.byted.cast.common.pin.QRPinNetWork;
import com.byted.cast.common.source.IClient;
import com.byted.cast.common.source.IMessageListener;
import com.byted.cast.common.source.IMirrorListener;
import com.byted.cast.common.source.ISendResultListener;
import com.byted.cast.common.source.ISinkDeviceInfoListener;
import com.byted.cast.common.source.ISinkRuntimeInfoListener;
import com.byted.cast.common.source.ServiceInfo;
import com.byted.cast.common.source.SourceModule;
import com.byted.cast.common.source.Statistics;
import com.byted.cast.common.utils.ServiceInfoUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.cast.sourcecommon.monitor.SourceMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class ByteCastSourceImpl implements ICastSource {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static boolean f456478b0;
    public final List<String> A;
    public boolean B;
    public boolean C;
    public final DeviceInfoManager D;
    public ConcurrentSubject<m> E;
    public d F;
    public final Map<String, n> G;
    public final Map<String, m> H;
    public IConnectListener I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public volatile boolean f456479J;
    public final List<IBindSdkInfoListener> K;
    public final ServiceInfo L;
    public boolean M;
    public boolean N;
    public ScheduledExecutorService O;
    public final String P;
    public boolean Q;
    public boolean R;
    public String S;
    public final com.ss.cast.source.g T;
    public final ContextManager.CastContext U;
    public final com.ss.cast.source.j V;
    public final com.ss.cast.source.k W;
    public Long X;
    public IBrowseListener Y;
    public Long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConfigManager f456480a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public ServiceInfo f456481a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CastLogger f456482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CastMonitor f456483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SourceMonitor f456484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TeaEventTrack f456485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ICastSource f456486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ICastSource f456487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ICastSource f456488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ICastSource f456489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ICastSource f456490j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ICastSource f456491k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ICastSource f456492l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ICastSource f456493m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ICastSource f456494n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ICastSource f456495o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final IClient f456496p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final zjc.a f456497q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, ICastSource> f456498r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, ICastSource> f456499s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<String> f456500t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List<String> f456501u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.ss.cast.source.m f456502v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final MainThreadExecutor f456503w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ICastAuth f456504x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Set<String> f456505y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f456506z;

    /* JADX INFO: renamed from: com.ss.cast.source.ByteCastSourceImpl$20, reason: invalid class name */
    class AnonymousClass20 extends HashMap<String, String> {
        final /* synthetic */ ByteCastSourceImpl this$0;

        public AnonymousClass20(ByteCastSourceImpl r100) {
            this.this$0 = r100;
            put("err_code", String.valueOf(17020001));
            put(LocationMonitorConst.ERR_MSG, "Unsupported Device");
            put("protocol", "");
        }
    }

    public class a implements IBrowseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBrowseListener f456507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456508b;

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onBrowseInvalidDevice(int r100, List r101) {
            IBrowseListener.CC.$default$onBrowseInvalidDevice(this, r100, r101);
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onError(int r100, String r101) {
            IBrowseListener.CC.$default$onError(this, r100, r101);
        }

        public a(ByteCastSourceImpl r100, IBrowseListener r101) {
            this.f456508b = r100;
            this.f456507a = r101;
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final void onBrowse(int r100, List<ServiceInfo> r101) {
            if (((ConcurrentSkipListSet) this.f456508b.f456505y).contains("ByteLink") == false) goto L6;
            return;
        L6:
            if (this.f456507a == null) goto L17;
            if (r101 == null) goto L18;
            this.f456508b.f456482b.d("ByteCastSourceImpl", "bytelink onBrowse:" + Arrays.toString(r101.toArray()));
            ByteCastSourceImpl r102 = this.f456508b;
            com.ss.cast.source.m r103 = r102.f456502v;
            String r104 = null;
            if (r103 == null) goto L11;
            List<ServiceInfo> r105 = r103.e(r100, "ByteLink", r101);
        L12:
            this.f456508b.f456482b.d("ByteCastSourceImpl", "ByteLink onBrowse code:" + r100 + ", serviceInfoList:" + r105);
            CastMonitor r106 = this.f456508b.f456483c;
            if (r105 == null) goto L15;
            r104 = r105.toString();
        L15:
            r106.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT, r104);
            this.f456507a.onBrowse(ErrorCodeUtils.generateBrowseErrorCode(r100), r105);
            ByteCastSourceImpl.b(this.f456508b, r105, "ByteLink_v2_deprecated", true);
            return;
        L11:
            r102.f456482b.i("ByteCastSourceImpl", "bytelinkSource serviceInfoManager is null");
            r105 = null;
            goto L12
        L18:
            return;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBrowseListener f456509a;

        public b(IBrowseListener r100) {
            this.f456509a = r100;
        }
    }

    public class c implements IBrowseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBrowseListener f456510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456511b;

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onBrowseInvalidDevice(int r100, List r101) {
            IBrowseListener.CC.$default$onBrowseInvalidDevice(this, r100, r101);
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onError(int r100, String r101) {
            IBrowseListener.CC.$default$onError(this, r100, r101);
        }

        public c(ByteCastSourceImpl r100, IBrowseListener r101) {
            this.f456511b = r100;
            this.f456510a = r101;
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final void onBrowse(int r100, List<ServiceInfo> r101) {
            if (((ConcurrentSkipListSet) this.f456511b.f456505y).contains(SourceModule.WEBOSTV) == false) goto L6;
            return;
        L6:
            if (this.f456510a == null) goto L17;
            if (r101 == null) goto L18;
            this.f456511b.f456482b.d("ByteCastSourceImpl", "webOSTVSource onBrowse:" + Arrays.toString(r101.toArray()));
            ByteCastSourceImpl r102 = this.f456511b;
            com.ss.cast.source.m r103 = r102.f456502v;
            String r104 = null;
            if (r103 == null) goto L11;
            List<ServiceInfo> r105 = r103.e(r100, SourceModule.WEBOSTV, r101);
        L12:
            this.f456511b.f456482b.d("ByteCastSourceImpl", "webOSTVSource onBrowse code:" + r100 + ", serviceInfoList:" + r105);
            CastMonitor r106 = this.f456511b.f456483c;
            if (r105 == null) goto L15;
            r104 = r105.toString();
        L15:
            r106.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT, r104);
            this.f456510a.onBrowse(ErrorCodeUtils.generateBrowseErrorCode(r100), r105);
            ByteCastSourceImpl.b(this.f456511b, r105, "WebOSTV_v2_deprecated", true);
            return;
        L11:
            r102.f456482b.i("ByteCastSourceImpl", "webOSTVSource serviceInfoManager is null");
            r105 = null;
            goto L12
        L18:
            return;
        }
    }

    public class d implements Observer<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f456512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456513b;

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public void call2(m r100) {
            if (r100 != null) goto L6;
            this.f456513b.f456482b.w("ByteCastSourceImpl", "connect callback, callbackInfo is null");
            return;
        L6:
            if (r100.f456531a != 1) goto L90;
            this.f456512a[0] = true;
            this.f456513b.f456482b.i("ByteCastSourceImpl", "parseQRCodeToServiceInfo, onConnect handleConnectCallback success serviceInfo:" + r100.f456532b);
            ByteCastSourceImpl r101 = this.f456513b;
            ServiceInfo r102 = r100.f456532b;
            ServiceInfo r103 = r101.f456481a0;
            if (r103 != null) goto L11;
            r101.f456481a0 = r102;
        L60:
            IConnectListener r104 = this.f456513b.I;
            if (r104 == null) goto L63;
            r104.onConnect(r102, r100.f456534d);
        L63:
            this.f456513b.getClass();
            this.f456513b.getClass();
            this.f456513b.getClass();
            ByteCastSourceImpl r105 = this.f456513b;
            monitor-enter(r105);
            r105.f456482b.d("ByteCastSourceImpl", "in handleConnectCallback:" + r100);     // Catch: Throwable -> L87
            if (((HashMap) r105.H).containsKey(r100.f456532b.types) == false) goto L70;
            r105.f456482b.d("ByteCastSourceImpl", "for " + r100.f456532b.types + ", already connected!");     // Catch: Throwable -> L87
            monitor-exit(r105);
        L86:
            this.f456513b.f456502v.f456601g = r102;
            return;
        L70:
            ((HashMap) r105.H).put(r100.f456532b.types, r100);     // Catch: Throwable -> L87
            Iterator r106 = ((HashMap) r105.G).values().iterator();     // Catch: Throwable -> L87
            long r107 = 0;
        L72:
            if (r106.hasNext() == false) goto L76;
            if (((n) r106.next()).f456537b == false) goto L72;
            r107 = r107 + 1;     // Catch: Throwable -> L87
            goto L72
        L76:
            r105.f456482b.d("ByteCastSourceImpl", "handleConnectCallback: mCachedServices.size:" + ((HashMap) r105.H).size() + ", thresholdSize:" + r107);     // Catch: Throwable -> L87
            if (((HashMap) r105.H).size() >= r107) goto L79;
        L85:
            monitor-exit(r105);
            goto L86
        L79:
            if (r105.I == null) goto L85;
            if (r105.L.protocols.equals("") == true) goto L85;
            r105.f456482b.d("ByteCastSourceImpl", "handleConnectCallback, onConnect:" + r105.L + ", extra:" + r100.f456534d);     // Catch: Throwable -> L87
            ((HashMap) r105.H).clear();     // Catch: Throwable -> L87
            ConcurrentSubject<m> r108 = r105.E;     // Catch: Throwable -> L87
            if (r108 == null) goto L85;
            r108.dispose();     // Catch: Throwable -> L87
        L87:
            th = move-exception;
            throw th;
        L11:
            if (TextUtils.equals(r103.f33719ip, r102.f33719ip) == true) goto L15;
            if (TextUtils.equals(r101.f456481a0.name, r102.name) == false) goto L60;
        L15:
            if (r101.f456481a0.types.contains(r102.types) == true) goto L18;
            StringBuilder r109 = new StringBuilder();
            ServiceInfo r110 = r101.f456481a0;
            r109.append(r110.types);
            r109.append(",");
            r109.append(r102.types);
            r110.types = r109.toString();
            ServiceInfo r111 = r101.f456481a0;
            r111.protocols = r111.types;
        L18:
            if (TextUtils.isEmpty(r101.f456481a0.connectID) == false) goto L21;
            r101.f456481a0.connectID = r102.connectID;
        L21:
            if (TextUtils.isEmpty(r101.f456481a0.castId) == false) goto L23;
            r101.f456481a0.castId = r102.castId;
        L23:
            ServiceInfo r112 = r101.f456481a0;
            if (r112.portMirror > 0) goto L27;
            r112.portMirror = r102.portMirror;
        L27:
            if (r112.port > 0) goto L30;
            r112.port = r102.port;
        L30:
            if (r112.deviceParams.isEmpty() == false) goto L33;
            r101.f456481a0.deviceParams = r102.deviceParams;
        L33:
            if (r101.f456481a0.deviceParams.containsKey(Constants.SINK_USER_CUSTOM_INFO) == true) goto L36;
            r101.f456481a0.deviceParams.put(Constants.SINK_USER_CUSTOM_INFO, null);
        L36:
            if (TextUtils.isEmpty(r101.f456481a0.data) == false) goto L39;
            r101.f456481a0.data = r102.data;
        L39:
            if (TextUtils.isEmpty(r101.f456481a0.manufacture) == false) goto L42;
            r101.f456481a0.manufacture = r102.manufacture;
        L42:
            if (TextUtils.isEmpty(r101.f456481a0.name) == false) goto L45;
            r101.f456481a0.name = r102.name;
        L45:
            if (r102.isSupportPlayList == false) goto L50;
            ServiceInfo r113 = r101.f456481a0;
            if (r113.isSupportPlayList == true) goto L50;
            r113.isSupportPlayList = true;
        L50:
            if (r102.isSupportDetect() == false) goto L55;
            if (r101.f456481a0.isSupportDetect() == true) goto L55;
            r101.f456481a0.setSupportDetect(true);
        L55:
            if (r102.isSupportPing() == true) goto L57;
        L59:
            r102 = r101.f456481a0;
            goto L60
        L57:
            if (r101.f456481a0.isSupportPing() == true) goto L59;
            r101.f456481a0.setSupportPing(true);
            goto L59
        }

        @Override // com.byted.cast.common.async.Observer
        public final void exception(Exception r100) {
            this.f456513b.f456482b.i("ByteCastSourceImpl", "mConnectObserver exception: " + r100.toString());
            if ((r100 instanceof TimeoutException) == true) goto L5;
            return;
        L5:
            if (this.f456512a[0] == true) goto L7;
            this.f456513b.getClass();
            this.f456513b.getClass();
        L7:
            ((HashMap) this.f456513b.H).clear();
            ConcurrentSubject<m> r101 = this.f456513b.E;
            if (r101 == null) goto L12;
            r101.dispose();
            return;
        }

        @Override // com.byted.cast.common.async.Observer
        public /* bridge */ /* synthetic */ void call(m r100) {
            call2(r100);
        }

        public d(ByteCastSourceImpl r100, boolean[] r101) {
            this.f456513b = r100;
            this.f456512a = r101;
        }
    }

    public class e implements IConnectListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456514a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServiceInfo f456515a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f456516b;

            @Override // java.lang.Runnable
            public final void run() {
                ServiceInfo r100 = this.f456515a.deepCopy();     // Catch: Throwable -> L4
                r100.protocols = "BDLink";     // Catch: Throwable -> L4
                r100.port = Constants.BDLINK_DEFAULT_PORT;     // Catch: Throwable -> L4
                this.f456516b.f456514a.f456488h.connect(r100);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(e r100, ServiceInfo r101) {
                this.f456516b = r100;
                this.f456515a = r101;
            }
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final /* synthetic */ void onConnectFailed(ServiceInfo r100, int r101, String r102) {
            IConnectListener.CC.$default$onConnectFailed(this, r100, r101, r102);
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final /* synthetic */ void onConnected(ServiceInfo r100) {
            IConnectListener.CC.$default$onConnected(this, r100);
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final /* synthetic */ void onConnecting(ServiceInfo r100) {
            IConnectListener.CC.$default$onConnecting(this, r100);
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final /* synthetic */ void onDisconnected(ServiceInfo r100, int r101, String r102) {
            IConnectListener.CC.$default$onDisconnected(this, r100, r101, r102);
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final /* synthetic */ void onDisconnecting(ServiceInfo r100) {
            IConnectListener.CC.$default$onDisconnecting(this, r100);
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final /* synthetic */ void onError(ServiceInfo r100, int r101, String r102) {
            IConnectListener.CC.$default$onError(this, r100, r101, r102);
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final /* synthetic */ void onInfo(ServiceInfo r100, int r101, String r102) {
            IConnectListener.CC.$default$onInfo(this, r100, r101, r102);
        }

        public e(ByteCastSourceImpl r100) {
            this.f456514a = r100;
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final void onConnect(ServiceInfo r100, int r101) {
            this.f456514a.f456482b.d("ByteCastSourceImpl", "webOSTVSource onConnect info:" + this.f456514a.f456488h);
            ByteCastSourceImpl r102 = this.f456514a;
            if (r102.f456488h == null) goto L6;
            n r103 = (n) ((HashMap) r102.G).get("BDLink");
            Objects.requireNonNull(r103);
            r103.f456537b = true;
            Dispatcher.getInstance().getByteCastHandler().postDelayed(new a(this, r100), 5000);
            return;
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final void onDisconnect(ServiceInfo r100, int r101, int r102) {
            IConnectListener r103 = this.f456514a.I;
            if (r103 == null) goto L6;
            r103.onDisconnect(r100, r101, r102);
            return;
        }
    }

    public class f implements IBrowseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBrowseListener f456517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456518b;

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onBrowseInvalidDevice(int r100, List r101) {
            IBrowseListener.CC.$default$onBrowseInvalidDevice(this, r100, r101);
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onError(int r100, String r101) {
            IBrowseListener.CC.$default$onError(this, r100, r101);
        }

        public f(ByteCastSourceImpl r100, IBrowseListener r101) {
            this.f456518b = r100;
            this.f456517a = r101;
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final void onBrowse(int r110, List<ServiceInfo> r111) {
            this.f456518b.f456482b.i("ByteCastSourceImpl", "ClientProxy onBrowse, code:" + r110 + ", serviceInfos:" + r111 + ", stopBrowseProtocols:" + this.f456518b.f456505y);
            if (((ConcurrentSkipListSet) this.f456518b.f456505y).contains("BDLink") == false) goto L8;
            if (((ConcurrentSkipListSet) this.f456518b.f456505y).contains("ByteLink") == false) goto L8;
            return;
        L8:
            if (((ConcurrentSkipListSet) this.f456518b.f456505y).contains("BDLink") == false) goto L12;
            if (r110 != 8) goto L12;
            return;
        L12:
            if (this.f456517a == null) goto L110;
            if (r111 != null) goto L15;
            return;
        L15:
            if (r110 == 1) goto L20;
            if (r110 == 5) goto L20;
            if (r110 == 7) goto L20;
            if (r110 == 8) goto L20;
        L41:
            this.f456518b.f456482b.i("ByteCastSourceImpl", "ClientProxy before handleData, onBrowse code:" + r110 + ", serviceInfos:" + r111);
            if (((ConcurrentSkipListSet) this.f456518b.f456505y).contains("ByteLink") == true) goto L54;
            if (r110 == 8) goto L54;
            if (r110 == 5) goto L54;
            ArrayList r100 = new ArrayList();
            Iterator<ServiceInfo> r112 = r111.iterator();
        L47:
            if (r112.hasNext() == false) goto L51;
            ServiceInfo r113 = r112.next();
            if (ServiceInfoUtils.isSupportByteLink(r113) == false) goto L47;
            ServiceInfo r114 = new ServiceInfo();
            r114.name = r113.name;
            r114.f33719ip = r113.f33719ip;
            r114.data = r113.data;
            r114.portMirror = r113.portMirror;
            r114.portInvite = r113.portInvite;
            r114.width = r113.width;
            r114.height = r113.height;
            r114.fps = r113.fps;
            r114.features = r113.features;
            r114.deviceID = r113.deviceID;
            r114.firewall = r113.firewall;
            r114.protocols = "ByteLink";
            r114.deviceParams = r113.deviceParams;
            r114.rtc_appId = r113.rtc_appId;
            r114.rtc_token = r113.rtc_token;
            r114.rtc_roomId = r113.rtc_roomId;
            r114.rtc_userId = r113.rtc_userId;
            r114.bitrate = r113.bitrate;
            r114.micScale = r113.micScale;
            r114.audioSource = r113.audioSource;
            r114.serverMode = r113.serverMode;
            r114.landscape = r113.landscape;
            r114.sinkPC = r113.sinkPC;
            r114.transTypes = r113.transTypes;
            r100.add(r114);
            goto L47
        L51:
            com.ss.cast.source.m r115 = this.f456518b.f456502v;
            if (r115 == null) goto L54;
            List<ServiceInfo> r101 = r115.e(r110, "ByteLink", r100);
        L56:
            if (((ConcurrentSkipListSet) this.f456518b.f456505y).contains("BDLink") == true) goto L73;
            if (r110 == 7) goto L73;
            ArrayList r116 = new ArrayList();
            Iterator<ServiceInfo> r102 = r111.iterator();
        L60:
            if (r102.hasNext() == false) goto L70;
            ServiceInfo r117 = r102.next();
            boolean r118 = ServiceInfoUtils.isSupportBdLink(r117);
            this.f456518b.f456482b.d("ByteCastSourceImpl", "ClientProxy hasDeviceInfo : " + r118);
            if (r118 == false) goto L60;
            ServiceInfo r119 = new ServiceInfo();
            r119.name = r117.name;
            r119.f33719ip = r117.f33719ip;
            r119.data = r117.data;
            r119.port = r117.port;
            r119.width = r117.width;
            r119.height = r117.height;
            r119.deviceID = r117.deviceID;
            r119.protocols = "BDLink";
            r119.deviceParams = r117.deviceParams;
            Map<String, String> r120 = r117.deviceParams;
            if (r120 != null) goto L66;
        L68:
            r116.add(r119);
            goto L60
        L66:
            if (r120.containsKey(Constants.SINK_BDLINK_VERSION_KEY) == false) goto L68;
            boolean r121 = Utils.isSupportPlayList(r117.deviceParams.get(Constants.SINK_BDLINK_VERSION_KEY));
            r117.isSupportPlayList = r121;
            r119.isSupportPlayList = r121;
            r119.setSupportDetect(r117.isSupportDetect());
            r119.setSupportPing(r117.isSupportPing());
            goto L68
        L70:
            com.ss.cast.source.m r103 = this.f456518b.f456502v;
            if (r103 == null) goto L73;
            r101 = r103.e(r110, "BDLink", r116);
        L73:
            this.f456518b.f456482b.i("ByteCastSourceImpl", "ClientProxy, onBrowse code:" + r110 + ", serviceInfoList:" + r101);
            String r104 = "";
            if (r110 == 5) goto L86;
            if (r110 == 7) goto L86;
            if (r110 != 8) goto L82;
            this.f456518b.f456482b.i("ByteCastSourceImpl", "sendSourceEvent, event: ByteCast_Browse_Result, isFromSsdp:true");
            CastMonitor r105 = this.f456518b.f456483c;
            StringBuilder r106 = new StringBuilder();
            if (r101 == null) goto L81;
            r104 = r101.toString();
        L81:
            r106.append(r104);
            r106.append(", isFromSsdp:true");
            r105.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT, r106.toString());
            this.f456517a.onBrowse(ErrorCodeUtils.generateBrowseErrorCode(1), r101);
        L90:
            if (r101 != null) goto L92;
            return;
        L92:
            if (ServiceInfoUtils.hasBdLinkServiceInfo(r101) == false) goto L97;
            ByteCastSourceImpl r107 = this.f456518b;
            if (r107.B == false) goto L97;
            ByteCastSourceImpl.b(r107, r101, "BDLink", true);
        L97:
            if (ServiceInfoUtils.hasByteLinkServiceInfo(r101) == false) goto L113;
            ByteCastSourceImpl r108 = this.f456518b;
            if (r108.C == false) goto L114;
            ByteCastSourceImpl.b(r108, r101, "ByteLink", true);
            return;
        L114:
            return;
        L113:
            return;
        L82:
            CastMonitor r109 = this.f456518b.f456483c;
            StringBuilder r122 = new StringBuilder();
            if (r101 == null) goto L85;
            r104 = r101.toString();
        L85:
            r122.append(r104);
            r122.append(", isFromNsdOrDnssd:true");
            r109.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT, r122.toString());
            this.f456517a.onBrowse(ErrorCodeUtils.generateBrowseErrorCode(r110), r101);
        L86:
            this.f456518b.f456482b.i("ByteCastSourceImpl", "sendSourceEvent, event: ByteCast_Browse_Result, isFromBle:true");
            CastMonitor r123 = this.f456518b.f456483c;
            StringBuilder r124 = new StringBuilder();
            if (r101 == null) goto L89;
            r104 = r101.toString();
        L89:
            r124.append(r104);
            r124.append(", isFromBle:true");
            r123.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT, r124.toString());
            this.f456517a.onBrowse(ErrorCodeUtils.generateBrowseErrorCode(1), r101);
        L54:
            r101 = null;
        L20:
            if (r110 == 5) goto L24;
            if (r110 == 1) goto L24;
            if (r110 == 8) goto L24;
        L31:
            if (r110 == 7) goto L34;
            if (r110 != 1) goto L41;
        L34:
            if (this.f456518b.N == false) goto L41;
            if (r111.size() <= 0) goto L41;
            ServiceInfo r125 = (ServiceInfo) ListProtector.get(r111, 0);
            if (r125.bytelinkEnabled == false) goto L40;
            this.f456518b.f456483c.sendSourceEvent(CastMonitor.BYTELINK_BROWSE_SUCCESS, r125.toString());
        L40:
            this.f456518b.N = false;
        L24:
            if (this.f456518b.M == false) goto L31;
            if (r111.size() <= 0) goto L31;
            ServiceInfo r126 = (ServiceInfo) ListProtector.get(r111, 0);
            if (r126.bdlinkEnabled == false) goto L30;
            this.f456518b.f456483c.sendSourceEvent(CastMonitor.BDLINK_BROWSE_SUCCESS, r126.toString());
        L30:
            this.f456518b.M = false;
            goto L31
        }
    }

    public class g implements IBrowseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBrowseListener f456519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456520b;

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onBrowseInvalidDevice(int r100, List r101) {
            IBrowseListener.CC.$default$onBrowseInvalidDevice(this, r100, r101);
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onError(int r100, String r101) {
            IBrowseListener.CC.$default$onError(this, r100, r101);
        }

        public g(ByteCastSourceImpl r100, IBrowseListener r101) {
            this.f456520b = r100;
            this.f456519a = r101;
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final void onBrowse(int r100, List<ServiceInfo> r101) {
            if (((ConcurrentSkipListSet) this.f456520b.f456505y).contains("BDLink") == false) goto L6;
            return;
        L6:
            if (this.f456519a == null) goto L17;
            if (r101 == null) goto L18;
            ByteCastSourceImpl r102 = this.f456520b;
            com.ss.cast.source.m r103 = r102.f456502v;
            String r104 = null;
            if (r103 == null) goto L11;
            List<ServiceInfo> r105 = r103.e(r100, "BDLink", r101);
        L12:
            this.f456520b.f456482b.d("ByteCastSourceImpl", "BDLink onBrowse code:" + r100 + ", serviceInfoList:" + r105);
            CastMonitor r106 = this.f456520b.f456483c;
            if (r105 == null) goto L15;
            r104 = r105.toString();
        L15:
            r106.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT, r104);
            this.f456519a.onBrowse(ErrorCodeUtils.generateBrowseErrorCode(r100), r105);
            ByteCastSourceImpl.b(this.f456520b, r105, "BDLink", true);
            return;
        L11:
            r102.f456482b.i("ByteCastSourceImpl", "bdlinkSource serviceInfoManager is null");
            r105 = null;
            goto L12
        L18:
            return;
        }
    }

    public class h implements IBrowseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBrowseListener f456521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456522b;

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onBrowseInvalidDevice(int r100, List r101) {
            IBrowseListener.CC.$default$onBrowseInvalidDevice(this, r100, r101);
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onError(int r100, String r101) {
            IBrowseListener.CC.$default$onError(this, r100, r101);
        }

        public h(ByteCastSourceImpl r100, IBrowseListener r101) {
            this.f456522b = r100;
            this.f456521a = r101;
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final void onBrowse(int r100, List<ServiceInfo> r101) {
            if (((ConcurrentSkipListSet) this.f456522b.f456505y).contains(SourceModule.SMARTVIEW) == false) goto L6;
            return;
        L6:
            if (this.f456521a == null) goto L17;
            if (r101 == null) goto L18;
            ByteCastSourceImpl r102 = this.f456522b;
            com.ss.cast.source.m r103 = r102.f456502v;
            String r104 = null;
            if (r103 == null) goto L11;
            List<ServiceInfo> r105 = r103.e(r100, SourceModule.SMARTVIEW, r101);
        L12:
            this.f456522b.f456482b.d("ByteCastSourceImpl", "SmartView onBrowse code:" + r100 + ", serviceInfoList:" + r105);
            CastMonitor r106 = this.f456522b.f456483c;
            if (r105 == null) goto L15;
            r104 = r105.toString();
        L15:
            r106.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT, r104);
            this.f456521a.onBrowse(ErrorCodeUtils.generateBrowseErrorCode(r100), r105);
            ByteCastSourceImpl.b(this.f456522b, r105, SourceModule.SMARTVIEW, true);
            return;
        L11:
            r102.f456482b.i("ByteCastSourceImpl", "smartViewSource serviceInfoManager is null");
            r105 = null;
            goto L12
        L18:
            return;
        }
    }

    public class i implements IBrowseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBrowseListener f456523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456524b;

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onBrowseInvalidDevice(int r100, List r101) {
            IBrowseListener.CC.$default$onBrowseInvalidDevice(this, r100, r101);
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onError(int r100, String r101) {
            IBrowseListener.CC.$default$onError(this, r100, r101);
        }

        public i(ByteCastSourceImpl r100, IBrowseListener r101) {
            this.f456524b = r100;
            this.f456523a = r101;
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final void onBrowse(int r100, List<ServiceInfo> r101) {
            if (((ConcurrentSkipListSet) this.f456524b.f456505y).contains("DIAL") == false) goto L6;
            return;
        L6:
            if (this.f456523a == null) goto L17;
            if (r101 == null) goto L18;
            ByteCastSourceImpl r102 = this.f456524b;
            com.ss.cast.source.m r103 = r102.f456502v;
            String r104 = null;
            if (r103 == null) goto L11;
            List<ServiceInfo> r105 = r103.e(r100, "DIAL", r101);
        L12:
            this.f456524b.f456482b.d("ByteCastSourceImpl", "dial onBrowse code:" + r100 + ", serviceInfoList:" + r105);
            CastMonitor r106 = this.f456524b.f456483c;
            if (r105 == null) goto L15;
            r104 = r105.toString();
        L15:
            r106.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT, r104);
            this.f456523a.onBrowse(ErrorCodeUtils.generateBrowseErrorCode(r100), r105);
            ByteCastSourceImpl.b(this.f456524b, r105, "DIAL", true);
            return;
        L11:
            r102.f456482b.i("ByteCastSourceImpl", "dial serviceInfoManager is null");
            r105 = null;
            goto L12
        L18:
            return;
        }
    }

    public class j implements IBrowseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBrowseListener f456525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456526b;

        public j(ByteCastSourceImpl r100, IBrowseListener r101) {
            this.f456526b = r100;
            this.f456525a = r101;
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final void onBrowse(int r100, List<ServiceInfo> r101) {
            if (((ConcurrentSkipListSet) this.f456526b.f456505y).contains("BDDLNA") == false) goto L8;
            if (r101 == null) goto L8;
            if (r101.isEmpty() == true) goto L8;
            return;
        L8:
            IBrowseListener r102 = this.f456525a;
            String r103 = null;
            if (r102 == null) goto L24;
            if (r101 == null) goto L24;
            ByteCastSourceImpl r104 = this.f456526b;
            if (r104.f456502v != null) goto L14;
            r104.f456482b.i("ByteCastSourceImpl", "_DLNA_SEARCH serviceInfoManager is null");
            List<ServiceInfo> r105 = null;
        L20:
            this.f456526b.f456482b.i("ByteCastSourceImpl", "_DLNA_SEARCH onBrowse code:" + r100 + ", serviceInfoList:" + r105);
            CastMonitor r106 = this.f456526b.f456483c;
            if (r105 == null) goto L23;
            r103 = r105.toString();
        L23:
            r106.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT, r103);
            this.f456525a.onBrowse(ErrorCodeUtils.generateBrowseErrorCode(r100), r105);
            ByteCastSourceImpl.b(this.f456526b, r105, "BDDLNA", true);
            return;
        L14:
            if (r101.isEmpty() == false) goto L16;
        L18:
            r105 = this.f456526b.f456502v.e(r100, "BDDLNA", r101);
            goto L20
        L16:
            if (TextUtils.isEmpty(((ServiceInfo) ListProtector.get(r101, 0)).dialServerUrl) == true) goto L18;
            r105 = this.f456526b.f456502v.e(r100, "DIAL", r101);
        L24:
            if (r102 != null) goto L28;
            this.f456526b.f456482b.i("ByteCastSourceImpl", "_DLNA_SEARCH browse result listener is null");
            this.f456526b.f456483c.getSourceMonitor().sendDlnaBrowseError(ErrorCode.DLNA_SEARCH_LISTENER_NULL, "browse result listener is null", null);
            return;
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final void onBrowseInvalidDevice(int r100, List<ServiceInfo> r101) {
            if (((ConcurrentSkipListSet) this.f456526b.f456505y).contains("BDDLNA") == false) goto L8;
            if (r101 == null) goto L8;
            if (r101.isEmpty() == true) goto L8;
            return;
        L8:
            IBrowseListener r102 = this.f456525a;
            if (r102 == null) goto L12;
            if (r101 == null) goto L12;
            this.f456526b.f456482b.i("ByteCastSourceImpl", "_DLNA_SEARCH onBrowseInvalidDevice onBrowse code:" + r100 + ", serviceInfoList:" + r101);
            this.f456525a.onBrowseInvalidDevice(ErrorCodeUtils.generateBrowseErrorCode(r100), r101);
            ByteCastSourceImpl.b(this.f456526b, r101, "BDDLNA", false);
            return;
        L12:
            if (r102 != null) goto L16;
            this.f456526b.f456482b.d("ByteCastSourceImpl", "_DLNA_SEARCH onBrowseInvalidDevice browse result listener is null");
            return;
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final void onError(int r100, String r101) {
            if (((ConcurrentSkipListSet) this.f456526b.f456505y).contains("BDDLNA") == false) goto L6;
            return;
        L6:
            if (this.f456525a == null) goto L8;
            this.f456526b.f456482b.i("ByteCastSourceImpl", "_DLNA_SEARCH onError onBrowse err:" + r100 + ", errMsg:" + r101);
            this.f456525a.onError(r100, r101);
            return;
        L8:
            this.f456526b.f456482b.d("ByteCastSourceImpl", "_DLNA_SEARCH onError browse result listener is null");
        }
    }

    public class k implements IBrowseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBrowseListener f456527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456528b;

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onBrowseInvalidDevice(int r100, List r101) {
            IBrowseListener.CC.$default$onBrowseInvalidDevice(this, r100, r101);
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onError(int r100, String r101) {
            IBrowseListener.CC.$default$onError(this, r100, r101);
        }

        public k(ByteCastSourceImpl r100, IBrowseListener r101) {
            this.f456528b = r100;
            this.f456527a = r101;
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final void onBrowse(int r100, List<ServiceInfo> r101) {
            if (((ConcurrentSkipListSet) this.f456528b.f456505y).contains("LeLink") == false) goto L6;
            return;
        L6:
            if (this.f456527a == null) goto L12;
            if (r101 == null) goto L13;
            com.ss.cast.source.m r102 = this.f456528b.f456502v;
            if (r102 == null) goto L14;
            List<ServiceInfo> r103 = r102.e(r100, "LeLink", r101);
            this.f456528b.f456482b.d("ByteCastSourceImpl", "LeLink onBrowse code:" + r100 + ", serviceInfoList:" + r103);
            this.f456528b.f456483c.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT, r103.toString());
            this.f456527a.onBrowse(ErrorCodeUtils.generateBrowseErrorCode(r100), r103);
            ByteCastSourceImpl.b(this.f456528b, r103, "LeLink", true);
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    public class l implements IBrowseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBrowseListener f456529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456530b;

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onBrowseInvalidDevice(int r100, List r101) {
            IBrowseListener.CC.$default$onBrowseInvalidDevice(this, r100, r101);
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final /* synthetic */ void onError(int r100, String r101) {
            IBrowseListener.CC.$default$onError(this, r100, r101);
        }

        public l(ByteCastSourceImpl r100, IBrowseListener r101) {
            this.f456530b = r100;
            this.f456529a = r101;
        }

        @Override // com.byted.cast.common.api.IBrowseListener
        public final void onBrowse(int r100, List<ServiceInfo> r101) {
            if (this.f456529a == null) goto L13;
            if (r101 == null) goto L14;
            com.ss.cast.source.m r102 = this.f456530b.f456502v;
            if (r102 == null) goto L15;
            List<ServiceInfo> r103 = r102.e(r100, "ChromeCast", r101);
            this.f456530b.f456482b.d("ByteCastSourceImpl", "chromecast onBrowse code:" + r100 + ", serviceInfoList:" + r103);
            this.f456530b.f456483c.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT, r103.toString());
            if (r100 != 6) goto L10;
            this.f456529a.onError(ErrorCodeUtils.generateBrowseErrorCode(r100), ErrorCodeUtils.generateBrowseErrorMsg(r100));
        L11:
            ByteCastSourceImpl.b(this.f456530b, r103, "ChromeCast", true);
            return;
        L10:
            this.f456529a.onBrowse(ErrorCodeUtils.generateBrowseErrorCode(r100), r103);
            goto L11
        L15:
            return;
        L14:
            return;
        }
    }

    public class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f456531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ServiceInfo f456532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f456533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f456534d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f456535e;

        public m() {
            throw null;
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder();
            ServiceInfo r101 = this.f456532b;
            if (r101 != null) goto L5;
            String r102 = "";
        L6:
            r100.append(r102);
            r100.append(", type=");
            r100.append(this.f456531a);
            r100.append(", what=");
            r100.append(this.f456533c);
            r100.append(", extra=");
            r100.append(this.f456534d);
            r100.append(", msg=");
            r100.append(this.f456535e);
            return r100.toString();
        L5:
            r102 = r101.toString();
            goto L6
        }

        public m(ServiceInfo r100, int r101) {
            this.f456531a = 1;
            this.f456532b = r100;
            this.f456533c = -1;
            this.f456534d = r101;
            this.f456535e = "";
        }
    }

    public class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ICastSource f456536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f456537b;

        public n(ICastSource r100) {
            this.f456536a = r100;
            this.f456537b = false;
        }
    }

    public class o implements IConnectListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f456538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteCastSourceImpl f456539b;

        @Override // com.byted.cast.common.api.IConnectListener
        public final void onConnected(ServiceInfo r100) {
            this.f456539b.f456482b.d("ByteCastSourceImpl", "onConnected, protocol: " + this.f456538a + ", serviceInfo: " + r100);
            a(r100, 0);
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final void onConnecting(ServiceInfo r100) {
            this.f456539b.f456482b.d("ByteCastSourceImpl", "onConnecting, protocol: " + this.f456538a + ", serviceInfo: " + r100);
            ByteCastSourceImpl r101 = this.f456539b;
            IConnectListener r102 = r101.I;
            if (r102 == null) goto L5;
            r102.onConnecting(r100);
            return;
        L5:
            r101.f456482b.d("ByteCastSourceImpl", "mConnectListener is null");
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final void onDisconnecting(ServiceInfo r100) {
            this.f456539b.f456482b.d("ByteCastSourceImpl", "onDisconnecting, protocol: " + this.f456538a + ", serviceInfo: " + r100);
            ByteCastSourceImpl r101 = this.f456539b;
            IConnectListener r102 = r101.I;
            if (r102 == null) goto L5;
            r102.onDisconnecting(r100);
            return;
        L5:
            r101.f456482b.d("ByteCastSourceImpl", "mConnectListener is null");
        }

        public o(ByteCastSourceImpl r100, String r101) {
            this.f456539b = r100;
            this.f456538a = r101;
            byte r102 = -1;
            switch(r101.hashCode()) {
                case -1803213502: goto L30;
                case 2098032: goto L26;
                case 457686803: goto L22;
                case 483315961: goto L18;
                case 559962094: goto L14;
                case 1954424701: goto L10;
                case 1954691932: goto L6;
                default: goto L33;
            };
        L33:
            switch(r102) {
                case 0: goto L34;
                case 1: goto L34;
                case 2: goto L34;
                case 3: goto L34;
                case 4: goto L34;
                case 5: goto L34;
                case 6: goto L34;
                default: goto L34;
            };
        L34:
            return;
        L6:
            if (r101.equals("BDLink") == false) goto L33;
            r102 = 6;
            goto L33
        L10:
            if (r101.equals("BDDLNA") == false) goto L33;
            r102 = 5;
            goto L33
        L14:
            if (r101.equals(SourceModule.SMARTVIEW) == false) goto L33;
            r102 = 4;
            goto L33
        L18:
            if (r101.equals("ChromeCast") == false) goto L33;
            r102 = 3;
            goto L33
        L22:
            if (r101.equals("BDCloud") == false) goto L33;
            r102 = 2;
            goto L33
        L26:
            if (r101.equals("DIAL") == false) goto L33;
            r102 = 1;
            goto L33
        L30:
            if (r101.equals("ByteLink") == false) goto L33;
            r102 = 0;
            goto L33
        }

        public final void a(ServiceInfo r100, int r101) {
            String r102 = "in onConnect, protocol: " + this.f456538a + ", serviceInfo:" + r100 + ", extra:" + r101;
            this.f456539b.f456482b.d("ByteCastSourceImpl", r102);
            String r103 = "";
            if (TextUtils.equals(this.f456538a, "ByteLink") == false) goto L5;
            this.f456539b.f456483c.sendByteCastSourceEvent(CastMonitor.BYTECAST_MIRROR_ON_CONNECT_SUCCESS, "", null, "");
        L5:
            this.f456539b.f456483c.sendByteCastSourceEvent(CastMonitor.BYTECAST_ON_CONNECT_SUCCESS_PROTOCOL_V2, r102, null, "");
            ByteCastSourceImpl r104 = this.f456539b;
            SourceMonitor r105 = r104.f456484d;
            String r106 = this.f456538a;
            Long r107 = r104.Z;
            if (r100 == null) goto L8;
            r103 = r100.castId;
        L8:
            r105.e(r106, r107, r103);
            ByteCastSourceImpl r108 = this.f456539b;
            ConcurrentSubject<m> r109 = r108.E;
            if (r109 == null) goto L11;
            r109.notifyObserver(new m(r100, r101));
        L13:
            if (TextUtils.equals(this.f456538a, "BDLink") == false) goto L18;
            com.ss.cast.source.m r110 = this.f456539b.f456502v;
            if (r110 == null) goto L19;
            r110.f456601g = r100;
            return;
        L19:
            return;
        L18:
            return;
        L11:
            r108.f456482b.d("ByteCastSourceImpl", "mConnectSubject is null");
            goto L13
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final void onConnect(ServiceInfo r100, int r101) {
            this.f456539b.f456482b.d("ByteCastSourceImpl", "onConnect, protocol: " + this.f456538a + ", serviceInfo: " + r100 + ", extra: " + r101);
            a(r100, r101);
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final void onConnectFailed(ServiceInfo r110, int r111, String r112) {
            this.f456539b.f456482b.d("ByteCastSourceImpl", "onConnectFailed, protocol: " + this.f456538a + ", serviceInfo:" + r110 + ", errCode:" + r111 + ", errMsg:" + r112);
            SourceMonitor r100 = this.f456539b.f456484d;
            String r101 = this.f456538a;
            if (r110 == null) goto L5;
            String r102 = r110.castId;
        L6:
            r100.d(r101, "failure", r102, r111, r112);
            ByteCastSourceImpl r103 = this.f456539b;
            IConnectListener r104 = r103.I;
            if (r104 == null) goto L9;
            r104.onConnectFailed(r110, r111, r112);
            return;
        L9:
            r103.f456482b.d("ByteCastSourceImpl", "mConnectListener is null");
            return;
        L5:
            r102 = "";
            goto L6
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final void onDisconnect(ServiceInfo r110, int r111, int r112) {
            String r100 = "onDisconnect, protocol: " + this.f456538a + ", serviceInfo:" + r110 + ",,what:" + r111 + ",extra:" + r112;
            this.f456539b.f456482b.d("ByteCastSourceImpl", r100);
            String r101 = "";
            if (TextUtils.equals(this.f456538a, "ByteLink") == false) goto L5;
            this.f456539b.f456483c.sendByteCastSourceEvent(CastMonitor.BYTECAST_MIRROR_ON_DISCONNECT, "", null, "");
            CastMonitor r102 = this.f456539b.f456483c;
            CastMonitor.WifiP2PType = "";
        L5:
            this.f456539b.f456483c.sendByteCastSourceEvent(CastMonitor.BYTECAST_ON_DISCONNECT_PROTOCOL_V2, r100, null, "");
            SourceMonitor r103 = this.f456539b.f456484d;
            String r104 = this.f456538a;
            if (r110 == null) goto L8;
            r101 = r110.castId;
        L8:
            r103.d(r104, "failure", r101, r111, String.valueOf(r112));
            ByteCastSourceImpl r105 = this.f456539b;
            String.valueOf(r112);
            r105.f456482b.d("ByteCastSourceImpl", "handleDisconnectEvent:" + r110 + ",what:" + r111 + ", extra:-1");
            ((HashMap) r105.H).clear();
            IConnectListener r113 = r105.I;
            if (r113 == null) goto L11;
            r113.onDisconnect(r110, r111, -1);
            return;
        L11:
            r105.f456482b.d("ByteCastSourceImpl", "handleDisconnectEvent mConnectListener is null");
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final void onDisconnected(ServiceInfo r110, int r111, String r112) {
            String r100 = "onDisconnected, protocol: " + this.f456538a + ", serviceInfo:" + r110 + ", errCode:" + r111 + ", errMsg:" + r112;
            this.f456539b.f456482b.d("ByteCastSourceImpl", r100);
            String r101 = "";
            if (TextUtils.equals(this.f456538a, "ByteLink") == false) goto L5;
            this.f456539b.f456483c.sendByteCastSourceEvent(CastMonitor.BYTECAST_MIRROR_ON_DISCONNECT, "", null, "");
            CastMonitor r102 = this.f456539b.f456483c;
            CastMonitor.WifiP2PType = "";
        L5:
            this.f456539b.f456483c.sendByteCastSourceEvent(CastMonitor.BYTECAST_ON_DISCONNECT_PROTOCOL_V2, r100, null, "");
            SourceMonitor r103 = this.f456539b.f456484d;
            String r104 = this.f456538a;
            if (r110 == null) goto L8;
            r101 = r110.castId;
        L8:
            r103.d(r104, "failure", r101, r111, r112);
            ((HashMap) this.f456539b.H).clear();
            ByteCastSourceImpl r105 = this.f456539b;
            IConnectListener r106 = r105.I;
            if (r106 == null) goto L11;
            r106.onDisconnected(r110, r111, r112);
            return;
        L11:
            r105.f456482b.d("ByteCastSourceImpl", "mConnectListener is null");
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final void onError(ServiceInfo r110, int r111, String r112) {
            String r100 = "onDisconnect, protocol: " + this.f456538a + ", serviceInfo:" + r110 + ", errCode:" + r111 + ", errMsg:" + r112;
            this.f456539b.f456482b.d("ByteCastSourceImpl", r100);
            String r101 = "";
            if (TextUtils.equals(this.f456538a, "ByteLink") == false) goto L5;
            this.f456539b.f456483c.sendByteCastSourceEvent(CastMonitor.BYTECAST_MIRROR_ON_DISCONNECT, "", null, "");
            CastMonitor r102 = this.f456539b.f456483c;
            CastMonitor.WifiP2PType = "";
        L5:
            this.f456539b.f456483c.sendByteCastSourceEvent(CastMonitor.BYTECAST_ON_DISCONNECT_PROTOCOL_V2, r100, null, "");
            SourceMonitor r103 = this.f456539b.f456484d;
            String r104 = this.f456538a;
            if (r110 == null) goto L8;
            r101 = r110.castId;
        L8:
            r103.d(r104, "failure", r101, r111, r112);
            ByteCastSourceImpl r105 = this.f456539b;
            r105.f456482b.d("ByteCastSourceImpl", "handleConnectErrorEvent:" + r110 + ",what:" + r111 + ", extra:-1");
            r105.f456482b.w("ByteCastSourceImpl", "handleConnectErrorEvent callbackInfo is null or not error info.");
            ((HashMap) r105.H).clear();
            IConnectListener r106 = r105.I;
            if (r106 == null) goto L11;
            r106.onError(r110, r111, r112);
            return;
        L11:
            r105.f456482b.d("ByteCastSourceImpl", "handleConnectErrorEvent mConnectListener is null");
        }

        @Override // com.byted.cast.common.api.IConnectListener
        public final void onInfo(ServiceInfo r110, int r111, String r112) {
            this.f456539b.f456482b.d("ByteCastSourceImpl", "onInfo, protocol: " + this.f456538a + ", serviceInfo:" + r110 + ", infoCode:" + r111 + ", infoMsg:" + r112);
            SourceMonitor r100 = this.f456539b.f456484d;
            String r101 = this.f456538a;
            if (r110 == null) goto L5;
            String r102 = r110.castId;
        L6:
            r100.d(r101, "info", r102, r111, r112);
            ByteCastSourceImpl r103 = this.f456539b;
            IConnectListener r104 = r103.I;
            if (r104 == null) goto L9;
            r104.onInfo(r110, r111, r112);
            return;
        L9:
            r103.f456482b.d("ByteCastSourceImpl", "mConnectListener is null");
            return;
        L5:
            r102 = "";
            goto L6
        }
    }

    public class p implements ISinkDeviceInfoListener {
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void addDramaList(DramaBean[] r100, String r101, IResultListener r102) {
        ICastSource.CC.$default$addDramaList(this, r100, r101, r102);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void addOutputSurface(Surface r100) {
        ICastSource.CC.$default$addOutputSurface(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void addVolume() {
        ICastSource.CC.$default$addVolume(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void changeCameraID(int r100) {
        ICastSource.CC.$default$changeCameraID(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void changeDanmakuSetting(DanmakuBean r100) {
        ICastSource.CC.$default$changeDanmakuSetting(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void changeResolution(Resolution r100) {
        ICastSource.CC.$default$changeResolution(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void changeSpeed(Speed r100) {
        ICastSource.CC.$default$changeSpeed(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void deleteDramaList(List r100) {
        ICastSource.CC.$default$deleteDramaList(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void destroy() {
        ICastSource.CC.$default$destroy(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ int detect(ServiceInfo r100, int r101, int r102) {
        return ICastSource.CC.$default$detect(this, r100, r101, r102);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void disableQueryPlayState() {
        ICastSource.CC.$default$disableQueryPlayState(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void enableAudio(boolean r100) {
        ICastSource.CC.$default$enableAudio(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void enableFlash(boolean r100) {
        ICastSource.CC.$default$enableFlash(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void enableQueryPlayState() {
        ICastSource.CC.$default$enableQueryPlayState(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ ServiceInfo getCurrentPlayServiceInfo() {
        return ICastSource.CC.$default$getCurrentPlayServiceInfo(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void getDeviceInfo(ServiceInfo r100, IGetDeviceInfoListener r101) {
        ICastSource.CC.$default$getDeviceInfo(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final ServiceInfo getServiceInfo() {
        return null;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ DeviceInfo getSinkDeviceInfo(String r100, int r101) {
        return ICastSource.CC.$default$getSinkDeviceInfo(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void getSinkDeviceInfo(ServiceInfo r100, ISinkDeviceInfoListener r101) {
        ICastSource.CC.$default$getSinkDeviceInfo(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ List getSsdpServiceInfoList() {
        return ICastSource.CC.$default$getSsdpServiceInfoList(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ Statistics getStatistics() {
        return ICastSource.CC.$default$getStatistics(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void getStatusAndMediaInfo(ServiceInfo r100, IResultListener r101) {
        ICastSource.CC.$default$getStatusAndMediaInfo(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void getStatusInfo(ServiceInfo r100, IResultListener r101) {
        ICastSource.CC.$default$getStatusInfo(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void getVolume(IResultListener r100) {
        ICastSource.CC.$default$getVolume(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void onDiskCacheFoundService(ServiceInfo r100) {
        ICastSource.CC.$default$onDiskCacheFoundService(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void onNetworkChangeReady() {
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void onSsdpDeviceOffline(ServiceInfo r100) {
        ICastSource.CC.$default$onSsdpDeviceOffline(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void pause() {
        ICastSource.CC.$default$pause(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ boolean ping(String r100, int r101) {
        return ICastSource.CC.$default$ping(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void play(PlayerInfo r100) {
        ICastSource.CC.$default$play(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void play(PlayerInfo r100, IResultListener r101) {
        ICastSource.CC.$default$play(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void play(ServiceInfo r100, Uri r101, int r102) {
        ICastSource.CC.$default$play(this, r100, r101, r102);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void playDramaList(ServiceInfo r100, List r101, String r102, IResultListener r103) {
        ICastSource.CC.$default$playDramaList(this, r100, r101, r102, r103);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void removeOutputSurface(Surface r100) {
        ICastSource.CC.$default$removeOutputSurface(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void resetConnect(ServiceInfo r100, IResultListener r101) {
        ICastSource.CC.$default$resetConnect(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void resume() {
        ICastSource.CC.$default$resume(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void seekTo(long r100, int r101) {
        ICastSource.CC.$default$seekTo(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void sendData(int r100, byte[] r101, long r102, long r103, long r104, long r105) {
        ICastSource.CC.$default$sendData(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setAudioMixScale(int r100) {
        ICastSource.CC.$default$setAudioMixScale(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setAuthorizationResult(int r100) {
        ICastSource.CC.$default$setAuthorizationResult(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setInheritConfig(int r100, IResultListener r101) {
        ICastSource.CC.$default$setInheritConfig(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setInputSurfaceCallback(ISurfaceListener r100) {
        ICastSource.CC.$default$setInputSurfaceCallback(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setLoopMode(int r100, int r101, IResultListener r102) {
        ICastSource.CC.$default$setLoopMode(this, r100, r101, r102);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setMediaProjection(MediaProjection r100) {
        ICastSource.CC.$default$setMediaProjection(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setMirrorInfo(MirrorInfo r100) {
        ICastSource.CC.$default$setMirrorInfo(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setMirrorListener(IMirrorListener r100) {
        ICastSource.CC.$default$setMirrorListener(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setPlayerListener(IPlayerListener r100) {
        ICastSource.CC.$default$setPlayerListener(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setPlayerListener(com.byted.cast.common.source.IPlayerListener r100) {
        ICastSource.CC.$default$setPlayerListener(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setPrivateChannel(String r100) {
        ICastSource.CC.$default$setPrivateChannel(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setRepeatMode(int r100, IResultListener r101) {
        ICastSource.CC.$default$setRepeatMode(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setServerInfo(PlayerInfo r100) {
        ICastSource.CC.$default$setServerInfo(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setServerListener(IServerListener r100) {
        ICastSource.CC.$default$setServerListener(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setSinkRuntimeInfoListener(ISinkRuntimeInfoListener r100) {
        ICastSource.CC.$default$setSinkRuntimeInfoListener(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setSkip(int r100, IResultListener r101) {
        ICastSource.CC.$default$setSkip(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setSsdpBrowseResultListener(IBrowseListener r100) {
        ICastSource.CC.$default$setSsdpBrowseResultListener(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setSsdpPrivateChannel(String r100) {
        ICastSource.CC.$default$setSsdpPrivateChannel(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setSsdpWriteCacheListener(IWriteCacheListener r100) {
        ICastSource.CC.$default$setSsdpWriteCacheListener(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setStretchMode(int r100, IResultListener r101) {
        ICastSource.CC.$default$setStretchMode(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setSubtitle(Subtitle r100, IResultListener r101) {
        ICastSource.CC.$default$setSubtitle(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setSurfaceFillType(int r100) {
        ICastSource.CC.$default$setSurfaceFillType(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void setVolume(int r100) {
        ICastSource.CC.$default$setVolume(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void startMirror(MirrorInfo r100) {
        ICastSource.CC.$default$startMirror(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void startRecorder() {
        ICastSource.CC.$default$startRecorder(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void startServer(String r100) {
        ICastSource.CC.$default$startServer(this, r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void startSsdpBrowse() {
        ICastSource.CC.$default$startSsdpBrowse(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void stop() {
        ICastSource.CC.$default$stop(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void stopMirror() {
        ICastSource.CC.$default$stopMirror(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void stopRecorder() {
        ICastSource.CC.$default$stopRecorder(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void stopServer() {
        ICastSource.CC.$default$stopServer(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void stopSsdpBrowse() {
        ICastSource.CC.$default$stopSsdpBrowse(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final /* synthetic */ void subVolume() {
        ICastSource.CC.$default$subVolume(this);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void clearDramaList() {
        com.ss.cast.source.k r100 = this.W;
        r100.f456588k.i("PlayerController", "start clearDramaList");
        r100.a();
    }

    public final void d() {
        if (this.f456486f == null) goto L10;
        if (((CopyOnWriteArrayList) this.f456500t).contains("BDDLNA") == true) goto L10;
        if (((CopyOnWriteArrayList) this.f456500t).contains("DIAL") == true) goto L10;
        this.f456486f.destroy();
        this.f456486f = null;
    L10:
        if (this.f456488h == null) goto L17;
        if (((CopyOnWriteArrayList) this.f456500t).contains("BDLink") == true) goto L17;
        if (((CopyOnWriteArrayList) this.f456500t).contains("DIAL") == true) goto L17;
        this.f456488h.destroy();
        this.f456488h = null;
    L17:
        if (this.f456487g == null) goto L24;
        if (((CopyOnWriteArrayList) this.f456500t).contains("LeLink") == true) goto L24;
        if (this.f456501u.contains("LeLink") == true) goto L24;
        this.f456487g.destroy();
        this.f456487g = null;
    L24:
        if (this.f456489i == null) goto L29;
        if (this.f456501u.contains("ByteLink") == true) goto L29;
        this.f456489i.destroy();
        this.f456489i = null;
    L29:
        if (this.f456491k == null) goto L34;
        if (((CopyOnWriteArrayList) this.f456500t).contains("ChromeCast") == true) goto L34;
        this.f456491k.destroy();
        this.f456491k = null;
    L34:
        if (this.f456492l == null) goto L39;
        if (((CopyOnWriteArrayList) this.f456500t).contains("BDCloud") == true) goto L39;
        this.f456492l.destroy();
        this.f456492l = null;
    L39:
        if (this.f456493m == null) goto L44;
        if (((CopyOnWriteArrayList) this.f456500t).contains(SourceModule.SMARTVIEW) == true) goto L44;
        this.f456493m.destroy();
        this.f456493m = null;
    L44:
        if (this.f456494n == null) goto L49;
        if (((CopyOnWriteArrayList) this.f456500t).contains("DIAL") == true) goto L49;
        this.f456494n.destroy();
        this.f456494n = null;
    L49:
        if (this.f456495o != null) goto L51;
        return;
    L51:
        if (((CopyOnWriteArrayList) this.f456500t).contains(SourceModule.WEBOSTV) == true) goto L55;
        this.f456495o.destroy();
        this.f456495o = null;
        return;
    }

    public final void e() {
        this.f456482b.d("ByteCastSourceImpl", "handleModulePriorityImpl thread is " + ThreadMethodProxy.currentThread().getName());
        List<String> r100 = this.f456500t;
        if (r100 != null) goto L5;
    L74:
        this.f456482b.i("ByteCastSourceImpl", "protocols enabled: link:" + this.f456498r.keySet());
        List<String> r101 = this.f456501u;
        if (r101 != null) goto L77;
    L90:
        this.f456482b.i("ByteCastSourceImpl", "protocols enabled: mirror:" + this.f456499s.keySet());
        this.f456502v = new com.ss.cast.source.m(this.U, this.f456500t, this.f456501u);
        this.T.getClass();
        this.W.getClass();
        IClient r102 = this.f456496p;
        if (r102 == null) goto L140;
        r102.setOption(10011, new Object[]{this.f456500t, this.f456501u});
        return;
    L140:
        return;
    L77:
        if (r101.size() <= 0) goto L90;
        Iterator<String> r103 = this.f456501u.iterator();
    L80:
        if (r103.hasNext() == false) goto L90;
        String r104 = r103.next();
        if (r104 == null) goto L80;
        if (r104.equals("ByteLink") == false) goto L80;
        ICastSource r105 = this.f456489i;
        if (r105 == null) goto L80;
        this.f456499s.put("ByteLink", r105);
        goto L80
    L5:
        if (r100.size() <= 0) goto L74;
        Iterator<String> r106 = this.f456500t.iterator();
    L8:
        if (r106.hasNext() == false) goto L73;
        String r107 = r106.next();
        if (r107 == null) goto L8;
        byte r110 = -1;
        switch(r107.hashCode()) {
            case -2023507661: goto L44;
            case -1407073126: goto L40;
            case 2098032: goto L36;
            case 457686803: goto L32;
            case 483315961: goto L28;
            case 559962094: goto L24;
            case 1954424701: goto L20;
            case 1954691932: goto L16;
            default: goto L47;
        };
    L47:
        switch(r110) {
            case 0: goto L70;
            case 1: goto L67;
            case 2: goto L64;
            case 3: goto L61;
            case 4: goto L58;
            case 5: goto L55;
            case 6: goto L52;
            case 7: goto L49;
            default: goto L8;
        };
    L49:
        ICastSource r108 = this.f456488h;
        if (r108 == null) goto L8;
        this.f456498r.put("BDLink", r108);
        goto L8
    L52:
        ICastSource r109 = this.f456486f;
        if (r109 == null) goto L8;
        this.f456498r.put("BDDLNA", r109);
        goto L8
    L55:
        ICastSource r111 = this.f456493m;
        if (r111 == null) goto L8;
        this.f456498r.put(SourceModule.SMARTVIEW, r111);
        goto L8
    L58:
        ICastSource r112 = this.f456491k;
        if (r112 == null) goto L8;
        this.f456498r.put("ChromeCast", r112);
        goto L8
    L61:
        ICastSource r113 = this.f456492l;
        if (r113 == null) goto L8;
        this.f456498r.put("BDCloud", r113);
        goto L8
    L64:
        ICastSource r114 = this.f456494n;
        if (r114 == null) goto L8;
        this.f456498r.put("DIAL", r114);
        goto L8
    L67:
        ICastSource r115 = this.f456495o;
        if (r115 == null) goto L8;
        this.f456498r.put(SourceModule.WEBOSTV, r115);
        goto L8
    L70:
        ICastSource r116 = this.f456487g;
        if (r116 == null) goto L8;
        this.f456498r.put("LeLink", r116);
        goto L8
    L16:
        if (r107.equals("BDLink") == false) goto L47;
        r110 = 7;
        goto L47
    L20:
        if (r107.equals("BDDLNA") == false) goto L47;
        r110 = 6;
        goto L47
    L24:
        if (r107.equals(SourceModule.SMARTVIEW) == false) goto L47;
        r110 = 5;
        goto L47
    L28:
        if (r107.equals("ChromeCast") == false) goto L47;
        r110 = 4;
        goto L47
    L32:
        if (r107.equals("BDCloud") == false) goto L47;
        r110 = 3;
        goto L47
    L36:
        if (r107.equals("DIAL") == false) goto L47;
        r110 = 2;
        goto L47
    L40:
        if (r107.equals(SourceModule.WEBOSTV) == false) goto L47;
        r110 = 1;
        goto L47
    L44:
        if (r107.equals("LeLink") == false) goto L47;
        r110 = 0;
        goto L47
    L73:
        this.f456483c.setProtocols(this.f456500t.toString());
        goto L74
    }

    public final void f() {
        Set<String> r100 = this.f456505y;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.clear();
        this.f456505y.add("LeLink");
        this.f456505y.add("BDDLNA");
        this.f456505y.add("BDLink");
        this.f456505y.add("ChromeCast");
        this.f456505y.add("BDCloud");
        this.f456505y.add(SourceModule.WEBOSTV);
        this.f456505y.add("ByteLink");
        this.f456505y.add(SourceModule.WIFIP2P);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final String getVersion() {
        JSONObject r100 = new JSONObject();
        r100.put(Constants.SOURCE_LINK_VERSION_KEY, BuildConfig.VERSION_NAME);     // Catch: JSONException -> L7
        r100.put(Constants.SOURCE_BDLINK_VERSION_KEY, BuildConfig.VERSION_NAME);     // Catch: JSONException -> L7
        r100.put(Constants.SOURCE_BDDLNA_VERSION_KEY, BuildConfig.VERSION_NAME);     // Catch: JSONException -> L7
        ICastSource r101 = this.f456489i;     // Catch: JSONException -> L7
        if (r101 == null) goto L57;
        r100.put(Constants.SOURCE_BYTELINK_VERSION_KEY, r101.getVersion());     // Catch: JSONException -> L7
    L57:
        ICastSource r102 = this.f456487g;     // Catch: JSONException -> L13
        if (r102 == null) goto L67;
        r100.put(Constants.SOURCE_LELINK_VERSION_KEY, r102.getVersion());     // Catch: JSONException -> L13
    L67:
        ICastSource r103 = this.f456491k;     // Catch: JSONException -> L19
        if (r103 == null) goto L55;
        r100.put(Constants.SOURCE_CHROMECAST_VERSION_KEY, r103.getVersion());     // Catch: JSONException -> L19
    L55:
    L25:
        e = move-exception;
        e.printStackTrace();
    L65:
        ICastSource r104 = this.f456490j;     // Catch: JSONException -> L31
        if (r104 == null) goto L63;
        r100.put(Constants.SOURCE_USBSOURCE_VERSION_KEY, r104.getVersion());     // Catch: JSONException -> L31
    L63:
        ICastSource r105 = this.f456492l;     // Catch: JSONException -> L37
        if (r105 == null) goto L61;
        r100.put(Constants.SOURCE_CLOUD_VERSION_KEY, r105.getVersion());     // Catch: JSONException -> L37
    L61:
        ICastSource r106 = this.f456493m;     // Catch: JSONException -> L43
        if (r106 == null) goto L59;
        r100.put(Constants.SOURCE_CLOUD_VERSION_KEY, r106.getVersion());     // Catch: JSONException -> L43
    L59:
        ICastSource r107 = this.f456494n;     // Catch: JSONException -> L49
        if (r107 == null) goto L51;
        r100.put(Constants.SOURCE_CLOUD_VERSION_KEY, r107.getVersion());     // Catch: JSONException -> L49
    L51:
        this.f456482b.i("ByteCastSourceImpl", "protocols version:" + r100.toString());
        this.f456483c.sendSourceEvent(CastMonitor.BYTECAST_SOURCE_GET_PROTOCOLS_VERSION, r100.toString());
        return r100.toString();
    L49:
        e = move-exception;
        e.printStackTrace();
    L43:
        e = move-exception;
        e.printStackTrace();
    L37:
        e = move-exception;
        e.printStackTrace();
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L63
    L22:
        if (this.f456487g == null) goto L65;
        r100.put(Constants.SOURCE_LELINK_WRAPPER_VERSION_KEY, BuildConfig.VERSION_NAME);     // Catch: JSONException -> L25
    L19:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L57
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void playNextDrama() {
        com.ss.cast.source.k r100 = this.W;
        r100.f456588k.i("PlayerController", "start playNextDrama");
        r100.a();
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void playPreDrama() {
        com.ss.cast.source.k r100 = this.W;
        r100.f456588k.i("PlayerController", "start playPreDrama");
        r100.a();
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void startBrowse() {
        this.f456482b.i("ByteCastSourceImpl", "_SEARCH startBrowse");
        this.X = Long.valueOf(System.currentTimeMillis());
        if (this.f456506z == false) goto L5;
        this.f456483c.sendSourceEvent(CastMonitor.BYTECAST_START_BROWSE_ALL, "");
        this.Q = true;
        this.f456484d.i(BytecastBrowseType.ALL);
        Dispatcher.getInstance().printThreadPool(this.U, "source", "start browse before");
        com.ss.cast.source.m r100 = this.f456502v;
        if (r100 == null) goto L18;
        r100.f456601g = null;
    L18:
        Map<String, ICastSource> r101 = this.f456498r;
        monitor-enter(r101);
        Iterator<String> r102 = this.f456498r.keySet().iterator();     // Catch: Throwable -> L71
        boolean r103 = false;
    L22:
        if (r102.hasNext() == false) goto L34;
        String r104 = r102.next();     // Catch: Throwable -> L71
        ICastSource r105 = this.f456498r.get(r104);     // Catch: Throwable -> L71
        if (r105 == null) goto L32;
        if ("BDDLNA".equals(r104) == false) goto L28;
        r105.setOption(100039, new Object[]{this.S});     // Catch: Throwable -> L71
    L28:
        r105.startBrowse();     // Catch: Throwable -> L71
        ((ConcurrentSkipListSet) this.f456505y).remove(r104);     // Catch: Throwable -> L71
        if ("BDLink".equals(r104) == true) goto L32;
        this.f456484d.k(r104);     // Catch: Throwable -> L71
    L32:
        if ("BDLink".equals(r104) == false) goto L22;
        r103 = true;
        goto L22
    L34:
        monitor-exit(r101);     // Catch: Throwable -> L71
        Map<String, ICastSource> r106 = this.f456499s;
        monitor-enter(r106);
        Iterator<String> r107 = this.f456499s.keySet().iterator();     // Catch: Throwable -> L68
    L39:
        if (r107.hasNext() == false) goto L48;
        String r108 = r107.next();     // Catch: Throwable -> L68
        ICastSource r109 = this.f456499s.get(r108);     // Catch: Throwable -> L68
        if (r109 == null) goto L46;
        r109.startBrowse();     // Catch: Throwable -> L68
        ((ConcurrentSkipListSet) this.f456505y).remove(r108);     // Catch: Throwable -> L68
        if ("ByteLink".equals(r108) == true) goto L46;
        this.f456484d.k(r108);     // Catch: Throwable -> L68
    L46:
        if ("ByteLink".equals(r108) == false) goto L39;
        this.f456484d.k("ByteLink_v2_deprecated");     // Catch: Throwable -> L68
        r103 = true;
        goto L39
    L48:
        monitor-exit(r106);     // Catch: Throwable -> L68
        Dispatcher.getInstance().printThreadPool(this.U, "source", "start browse after");
        if (r103 == true) goto L52;
    L62:
        zjc.a r110 = this.f456497q;
        if (r110 != null) goto L65;
        return;
    L65:
        if (r110.b() == false) goto L89;
        ((ConcurrentSkipListSet) this.f456505y).remove(SourceModule.WIFIP2P);
        return;
    L89:
        return;
    L52:
        if (this.f456498r.containsKey("BDLink") == false) goto L54;
        this.B = true;
        this.f456484d.k("BDLink");
    L56:
        if (this.f456499s.containsKey("ByteLink") == false) goto L58;
        this.C = true;
        this.f456484d.k("ByteLink");
    L59:
        IClient r111 = this.f456496p;
        if (r111 == null) goto L62;
        r111.startBrowse();
        goto L62
    L58:
        this.C = false;
        goto L59
    L54:
        this.B = false;
    L68:
        th = move-exception;
        throw th;
    L71:
        th = move-exception;
        throw th;
    L5:
        if (f456478b0 == false) goto L11;
        ((ConcurrentSkipListSet) this.f456505y).remove("LeLink");
        ICastSource r112 = this.f456498r.get("LeLink");
        if (r112 == null) goto L9;
        r112.startBrowse();
    L9:
        this.Q = true;
        this.f456484d.i(BytecastBrowseType.ALL);
        this.f456484d.k("LeLink");
    L13:
        this.f456482b.w("ByteCastSourceImpl", "_SEARCH startBrowse authVerify is false");
        return;
    L11:
        if (this.Y == null) goto L13;
        SourceMonitor r113 = this.f456484d;
        r113.f456611b.sendCustomEvent(Constants.BYTECAST_DEFAULT_DEVICE_NAME, CastMonitor.BYTECAST_BROWSE_FAILED_AUTH_INVALID, "", null, r113.f456613d);
        this.Y.onBrowse(-1, null);
        goto L13
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void stopBrowse() {
        this.f456482b.i("ByteCastSourceImpl", "_SEARCH stopBrowse : authVerify=" + this.f456506z);
        if (this.f456506z == false) goto L5;
        this.Q = false;
        this.f456483c.sendSourceEvent(CastMonitor.BYTECAST_STOP_BROWSE_ALL, "");
        this.f456484d.j(BytecastBrowseType.ALL);
        Map<String, ICastSource> r100 = this.f456498r;
        monitor-enter(r100);
        Iterator<String> r101 = this.f456498r.keySet().iterator();     // Catch: Throwable -> L43
    L14:
        if (r101.hasNext() == false) goto L18;
        String r102 = r101.next();     // Catch: Throwable -> L43
        ICastSource r103 = this.f456498r.get(r102);     // Catch: Throwable -> L43
        if (r103 == null) goto L14;
        ((ConcurrentSkipListSet) this.f456505y).add(r102);     // Catch: Throwable -> L43
        r103.stopBrowse();     // Catch: Throwable -> L43
        this.f456484d.l(r102);     // Catch: Throwable -> L43
        goto L14
    L18:
        monitor-exit(r100);     // Catch: Throwable -> L43
        Map<String, ICastSource> r104 = this.f456499s;
        monitor-enter(r104);
        Iterator<String> r105 = this.f456499s.keySet().iterator();     // Catch: Throwable -> L40
    L23:
        if (r105.hasNext() == false) goto L27;
        String r106 = r105.next();     // Catch: Throwable -> L40
        ICastSource r107 = this.f456499s.get(r106);     // Catch: Throwable -> L40
        if (r107 == null) goto L23;
        ((ConcurrentSkipListSet) this.f456505y).add(r106);     // Catch: Throwable -> L40
        r107.stopBrowse();     // Catch: Throwable -> L40
        this.f456484d.l(r106);     // Catch: Throwable -> L40
        goto L23
    L27:
        monitor-exit(r104);     // Catch: Throwable -> L40
        com.ss.cast.source.m r108 = this.f456502v;
        if (r108 == null) goto L31;
        ((CopyOnWriteArrayList) r108.f456597c).clear();
        ((CopyOnWriteArrayList) r108.f456598d).clear();
    L31:
        IClient r109 = this.f456496p;
        if (r109 == null) goto L34;
        r109.stopBrowse();
    L34:
        this.M = true;
        this.N = true;
        zjc.a r110 = this.f456497q;
        if (r110 != null) goto L37;
        return;
    L37:
        if (r110.c() == false) goto L63;
        ((ConcurrentSkipListSet) this.f456505y).add(SourceModule.WIFIP2P);
        return;
    L63:
        return;
    L40:
        th = move-exception;
        throw th;
    L43:
        th = move-exception;
        throw th;
    L5:
        if (f456478b0 == false) goto L60;
        ICastSource r111 = this.f456498r.get("LeLink");
        if (r111 == null) goto L61;
        ((ConcurrentSkipListSet) this.f456505y).add("LeLink");
        r111.stopBrowse();
        this.f456484d.l("LeLink");
        this.Q = false;
        this.f456484d.j(BytecastBrowseType.ALL);
        return;
    L61:
        return;
    }

    public ByteCastSourceImpl(ContextManager.CastContext r210) {
        this.f456498r = Collections.synchronizedMap(new LinkedHashMap());
        this.f456499s = Collections.synchronizedMap(new LinkedHashMap());
        this.f456500t = new CopyOnWriteArrayList();
        this.f456501u = new CopyOnWriteArrayList();
        this.f456503w = new MainThreadExecutor();
        this.f456505y = new ConcurrentSkipListSet();
        this.A = new CopyOnWriteArrayList();
        this.B = false;
        this.C = false;
        HashMap r110 = new HashMap();
        this.G = r110;
        this.H = new HashMap();
        this.f456479J = false;
        this.K = new CopyOnWriteArrayList();
        this.L = new ServiceInfo();
        this.M = true;
        this.N = true;
        this.P = "0";
        this.Q = false;
        this.R = false;
        this.S = "";
        this.f456481a0 = null;
        new QRPinNetWork();
        this.U = r210;
        this.f456480a = ContextManager.getConfigManager(r210);
        CastLogger r100 = ContextManager.getLogger(r210);
        this.f456482b = r100;
        this.f456483c = ContextManager.getMonitor(r210);
        this.f456485e = ContextManager.getTeaEventTrack(r210);
        this.f456484d = SourceMonitor.b(r210);
        this.D = ContextManager.getDeviceInfoManager(r210);
        Class r101 = a("com.byted.dlna.source.api.BDDLNASourceWrapper");     // Catch: Throwable -> L9
        String r111 = SourceModule.SMARTVIEW;
        String r112 = "BDCloud";
        ICastSource r102 = (ICastSource) r101.getDeclaredConstructor(new Class[]{ContextManager.CastContext.class}).newInstance(new Object[]{r210});     // Catch: Throwable -> L7
        this.f456486f = r102;     // Catch: Throwable -> L7
        r110.put("BDDLNA", new n(r102));     // Catch: Throwable -> L7
        r100.i("ByteCastSourceImpl", "BDDLNASourceWrapper: " + this.f456486f);     // Catch: Throwable -> L7
    L108:
        ICastSource r103 = (ICastSource) a("com.byted.link.source.impl.BDLinkSourceWrapper").getDeclaredConstructor(new Class[]{ContextManager.CastContext.class}).newInstance(new Object[]{this.U});     // Catch: Throwable -> L94
        this.f456488h = r103;     // Catch: Throwable -> L94
        ((HashMap) this.G).put("BDLink", new n(r103));     // Catch: Throwable -> L94
    L124:
        this.f456487g = (ICastSource) a("com.ss.lelink.source.LelinkSourceWrapper").getDeclaredConstructor(new Class[]{ContextManager.CastContext.class}).newInstance(new Object[]{this.U});     // Catch: Throwable -> L95
        this.f456482b.i("ByteCastSourceImpl", "LelinkSourceWrapper:" + this.f456487g);     // Catch: Throwable -> L95
    L126:
        this.f456489i = (ICastSource) a("com.byted.cast.source.api.BytelinkSourceWrapper").getDeclaredConstructor(new Class[]{ContextManager.CastContext.class}).newInstance(new Object[]{this.U});     // Catch: Throwable -> L96
        this.f456482b.i("ByteCastSourceImpl", "bytelinkSource:" + this.f456489i);     // Catch: Throwable -> L96
        ((HashMap) this.G).put("ByteLink", new n(this.f456489i));     // Catch: Throwable -> L96
    L110:
        ICastSource r104 = (ICastSource) a("com.byted.cast.usbsource.usbdisplaysource.UsbCastSourceWrapper").getDeclaredConstructor(new Class[]{ContextManager.CastContext.class}).newInstance(new Object[]{this.U});     // Catch: Throwable -> L97
        this.f456490j = r104;     // Catch: Throwable -> L97
        this.f456482b.i("ByteCastSourceImpl", "usbCastSource:zhy" + r104);     // Catch: Throwable -> L97
    L114:
        this.f456491k = (ICastSource) a("com.ss.chromecast.source.impl.ChromeCastSourceWrapper").getDeclaredConstructor(new Class[]{ContextManager.CastContext.class}).newInstance(new Object[]{this.U});     // Catch: Throwable -> L98
        this.f456482b.d("ByteCastSourceImpl", "ChromeCastSourceWrapper:" + this.f456491k);     // Catch: Throwable -> L98
        ((HashMap) this.G).put("ChromeCast", new n(this.f456491k));     // Catch: Throwable -> L98
    L128:
        ICastSource r105 = (ICastSource) a("com.byted.cloud.source.api.BDCloudSourceWrapper").getDeclaredConstructor(new Class[]{ContextManager.CastContext.class}).newInstance(new Object[]{this.U});     // Catch: Throwable -> L21
        this.f456492l = r105;     // Catch: Throwable -> L21
        String r106 = r112;
        ((HashMap) this.G).put(r106, new n(r105));     // Catch: Throwable -> L99
    L112:
        ICastSource r107 = (ICastSource) a("com.ss.smartview.source.impl.SmartViewSourceWrapper").getDeclaredConstructor(new Class[]{ContextManager.CastContext.class}).newInstance(new Object[]{this.U});     // Catch: Throwable -> L26
        this.f456493m = r107;     // Catch: Throwable -> L26
        String r108 = r111;
        ((HashMap) this.G).put(r108, new n(r107));     // Catch: Throwable -> L100
    L104:
        ICastSource r109 = (ICastSource) a("com.ss.cast.dialcastsource.api.DIALCastSourceWrapper").getDeclaredConstructor(new Class[]{ContextManager.CastContext.class}).newInstance(new Object[]{this.U});     // Catch: Throwable -> L33
        this.f456494n = r109;     // Catch: Throwable -> L33
        String r113 = "DIAL";
        ((HashMap) this.G).put(r113, new n(r109));     // Catch: Throwable -> L31
    L122:
        ICastSource r114 = (ICastSource) a("com.byted.cast.webostv.api.WebOSTVWrapper").getDeclaredConstructor(new Class[]{ContextManager.CastContext.class}).newInstance(new Object[]{this.U});     // Catch: Throwable -> L101
        this.f456495o = r114;     // Catch: Throwable -> L101
        ((HashMap) this.G).put(SourceModule.WEBOSTV, new n(r114));     // Catch: Throwable -> L101
    L120:
        a("com.byted.cast.wifidirect.WiFiP2PHelper").newInstance();     // Catch: Throwable -> L39
        this.f456497q = new zjc.a(this.U);     // Catch: Throwable -> L39
        this.f456482b.i("ByteCastSourceImpl", "load Wifi-p2p manager success");     // Catch: Throwable -> L39
    L116:
        IClient r115 = (IClient) a("com.ss.cast.discovery.ClientProxy").getConstructor(new Class[]{ContextManager.CastContext.class, ICastSource.class, ICastSource.class}).newInstance(new Object[]{this.U, this.f456488h, this.f456489i});     // Catch: Throwable -> L43
        this.f456496p = r115;     // Catch: Throwable -> L43
        this.f456482b.i("ByteCastSourceImpl", "mClientProxy is " + r115);     // Catch: Throwable -> L43
    L45:
        StringBuilder r116 = new StringBuilder("There is ");
        if (this.f456488h == null) goto L49;
        r116.append("BDLink ");
    L49:
        if (this.f456486f == null) goto L52;
        r116.append("BDDLNA ");
    L52:
        if (this.f456489i == null) goto L55;
        r116.append("ByteLink ");
    L55:
        if (this.f456487g == null) goto L58;
        r116.append("LeLink ");
    L58:
        if (this.f456491k == null) goto L61;
        r116.append("ChromeCast ");
    L61:
        if (this.f456492l == null) goto L64;
        r116.append("BDCloud ");
    L64:
        if (this.f456493m == null) goto L67;
        r116.append("SmartView ");
    L67:
        if (this.f456497q == null) goto L70;
        r116.append("WIFIP2P ");
    L70:
        if (this.f456494n == null) goto L73;
        r116.append("DIAL ");
    L73:
        if (this.f456495o == null) goto L75;
        r116.append("WebOSTV ");
    L75:
        r116.append("in the system.");
        this.f456482b.d("ByteCastSourceImpl", r116.toString());
        new QRPinNetWork(ContextManager.getConfigManager(this.U).getInitConfig().getNetAdapter());
        f();
        com.ss.cast.source.g r117 = new com.ss.cast.source.g(this.U);
        this.T = r117;
        r117.f456574b = this.f456486f;
        r117.f456573a = this.f456488h;
        r117.f456575c = this.f456496p;
        com.ss.cast.source.k r118 = new com.ss.cast.source.k(this.U, this.f456498r, this.f456500t);
        this.W = r118;
        ICastSource r119 = this.f456488h;
        ICastSource r120 = this.f456486f;
        ICastSource r121 = this.f456487g;
        ICastSource r122 = this.f456491k;
        ICastSource r123 = this.f456492l;
        ICastSource r124 = this.f456493m;
        ICastSource r125 = this.f456494n;
        r118.f456578a = r119;
        r118.f456579b = r120;
        r118.f456580c = r121;
        r118.f456581d = r122;
        r118.f456582e = r123;
        r118.f456583f = r124;
        r118.f456584g = r125;
        r118.f456588k = this.f456482b;
        com.ss.cast.source.j r126 = new com.ss.cast.source.j();
        this.V = r126;
        ICastSource r127 = this.f456489i;
        ICastSource r128 = this.f456490j;
        r126.f456576a = r127;
        r126.f456577b = r128;
        this.f456482b.d("MirrorController", "setConnectListener: Stub");
        ICastSource r129 = this.f456488h;
        if (r129 == null) goto L78;
        r129.setConnectListener(new o(this, "BDLink"));
    L78:
        ICastSource r130 = this.f456491k;
        if (r130 == null) goto L81;
        r130.setConnectListener(new o(this, "ChromeCast"));
    L81:
        ICastSource r131 = this.f456492l;
        if (r131 == null) goto L84;
        r131.setConnectListener(new o(this, r106));
    L84:
        ICastSource r132 = this.f456493m;
        if (r132 == null) goto L87;
        r132.setConnectListener(new o(this, r108));
    L87:
        ICastSource r133 = this.f456494n;
        if (r133 == null) goto L90;
        r133.setConnectListener(new o(this, r113));
    L90:
        ICastSource r134 = this.f456486f;
        if (r134 == null) goto L134;
        r134.setConnectListener(new o(this, "BDDLNA"));
        return;
    L134:
        return;
    L43:
        th = move-exception;
        this.f456482b.i("ByteCastSourceImpl", "mClientProxy reflect exception " + th);
    L39:
        th = move-exception;
        this.f456482b.i("ByteCastSourceImpl", "load Wifi-p2p manager throwable:" + th);
    L31:
        th = th;
    L35:
        this.f456482b.e("ByteCastSourceImpl", "dialcastsource err", th);
    L33:
        th = th;
        r113 = "DIAL";
    L26:
        r108 = r111;
    L21:
        r106 = r112;
    L7:
        th = th;
    L11:
        this.f456482b.i("ByteCastSourceImpl", "BDDLNASourceWrapper throwable : " + th);
    L9:
        th = th;
        r111 = SourceModule.SMARTVIEW;
        r112 = "BDCloud";
        goto L11
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final synchronized void connect(ServiceInfo r110) {
        monitor-enter(this);
        if (r110 != null) goto L9;
        this.f456482b.w("ByteCastSourceImpl", "serviceinfo is null");     // Catch: Throwable -> L115
        monitor-exit(this);
        return;
    L9:
        if (this.f456506z == true) goto L13;
        this.f456482b.w("ByteCastSourceImpl", "connect, not auth");     // Catch: Throwable -> L115
        final String r100 = String.valueOf(ConnectCode.ERROR_CODE_BYTECAST_CONNECT_NOT_AUTH);     // Catch: Throwable -> L115
        final String r101 = ConnectCode.ERROR_MSG_BYTECAST_CONNECT_NOT_AUTH;
        final String r111 = r110.protocols;     // Catch: Throwable -> L115
        this.f456485e.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_TROUBLESHOOTING, new Map[]{new AnonymousClass13(this, r100, r101, r111)});     // Catch: Throwable -> L115
        monitor-exit(this);
        return;
    L13:
        this.f456482b.d("ByteCastSourceImpl", "connect:" + r110 + ", gitInfo:1.5ae52f8");     // Catch: Throwable -> L115
        this.Z = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L115
        this.f456481a0 = null;     // Catch: Throwable -> L115
        ConcurrentSubject<m> r102 = this.E;     // Catch: Throwable -> L115
        if (r102 == null) goto L16;
        r102.clearObservers();     // Catch: Throwable -> L115
    L16:
        Iterator r103 = ((HashMap) this.G).values().iterator();     // Catch: Throwable -> L115
    L18:
        if (r103.hasNext() == false) goto L20;
        ((n) r103.next()).f456537b = false;     // Catch: Throwable -> L115
        goto L18
    L20:
        this.F = new d(this, new boolean[]{false});     // Catch: Throwable -> L115
        if (this.E == null) goto L24;
        this.E.setTimeout(ContextManager.getConfigManager(this.U).getInitConfig().getConnectTimeout(), TimeUnit.SECONDS).addObserver(this.F);     // Catch: Throwable -> L115
    L24:
        if (this.f456489i == null) goto L33;
        if (r110.protocols.contains("ByteLink") == false) goto L33;
        List<String> r104 = this.f456501u;     // Catch: Throwable -> L115
        if (r104 == null) goto L33;
        if (((CopyOnWriteArrayList) r104).contains("ByteLink") == false) goto L33;
        n r105 = (n) ((HashMap) this.G).get("ByteLink");     // Catch: Throwable -> L115
        Objects.requireNonNull(r105);     // Catch: Throwable -> L115
        r105.f456537b = true;     // Catch: Throwable -> L115
        this.f456489i.connect(r110);     // Catch: Throwable -> L115
        this.f456484d.d("ByteLink", "start", r110.castId, 0, "");     // Catch: Throwable -> L115
    L33:
        if (this.f456488h == null) goto L45;
        if (r110.protocols.contains("BDLink") == false) goto L45;
        List<String> r106 = this.f456500t;     // Catch: Throwable -> L115
        if (r106 == null) goto L45;
        if (((CopyOnWriteArrayList) r106).contains("BDLink") == false) goto L45;
        n r107 = (n) ((HashMap) this.G).get("BDLink");     // Catch: Throwable -> L115
        Objects.requireNonNull(r107);     // Catch: Throwable -> L115
        r107.f456537b = true;     // Catch: Throwable -> L115
        this.f456488h.connect(r110);     // Catch: Throwable -> L115
        com.ss.cast.source.m r108 = this.f456502v;     // Catch: Throwable -> L115
        if (r108 == null) goto L43;
        r108.f456601g = r110;     // Catch: Throwable -> L115
    L43:
        this.f456484d.d("BDLink", "start", r110.castId, 0, "");     // Catch: Throwable -> L115
    L45:
        if (this.f456491k != null) goto L47;
    L56:
        this.f456482b.d("ByteCastSourceImpl", "linkProtocols: " + this.f456500t);     // Catch: Throwable -> L115
        if (this.f456492l == null) goto L69;
        if (r110.protocols.contains("BDCloud") == false) goto L69;
        List<String> r109 = this.f456500t;     // Catch: Throwable -> L115
        if (r109 == null) goto L69;
        if (((CopyOnWriteArrayList) r109).contains("BDCloud") == false) goto L69;
        n r112 = (n) ((HashMap) this.G).get("BDCloud");     // Catch: Throwable -> L115
        Objects.requireNonNull(r112);     // Catch: Throwable -> L115
        r112.f456537b = true;     // Catch: Throwable -> L115
        this.f456492l.connect(r110);     // Catch: Throwable -> L115
        com.ss.cast.source.m r113 = this.f456502v;     // Catch: Throwable -> L115
        if (r113 == null) goto L67;
        r113.f456601g = r110;     // Catch: Throwable -> L115
    L67:
        this.f456484d.d("BDCloud", "start", r110.castId, 0, "");     // Catch: Throwable -> L115
    L69:
        if (this.f456493m == null) goto L81;
        if (r110.protocols.contains(SourceModule.SMARTVIEW) == false) goto L81;
        List<String> r114 = this.f456500t;     // Catch: Throwable -> L115
        if (r114 == null) goto L81;
        if (((CopyOnWriteArrayList) r114).contains(SourceModule.SMARTVIEW) == false) goto L81;
        n r115 = (n) ((HashMap) this.G).get(SourceModule.SMARTVIEW);     // Catch: Throwable -> L115
        Objects.requireNonNull(r115);     // Catch: Throwable -> L115
        r115.f456537b = true;     // Catch: Throwable -> L115
        this.f456493m.connect(r110);     // Catch: Throwable -> L115
        com.ss.cast.source.m r116 = this.f456502v;     // Catch: Throwable -> L115
        if (r116 == null) goto L79;
        r116.f456601g = r110;     // Catch: Throwable -> L115
    L79:
        this.f456484d.d(SourceModule.SMARTVIEW, "start", r110.castId, 0, "");     // Catch: Throwable -> L115
    L81:
        if (this.f456494n != null) goto L83;
    L92:
        this.f456482b.d("ByteCastSourceImpl", "webOSTVSource Connect info:" + this.f456500t);     // Catch: Throwable -> L115
        if (this.f456495o == null) goto L102;
        if (r110.protocols.contains(SourceModule.WEBOSTV) == false) goto L102;
        List<String> r117 = this.f456500t;     // Catch: Throwable -> L115
        if (r117 == null) goto L102;
        if (((CopyOnWriteArrayList) r117).contains(SourceModule.WEBOSTV) == false) goto L102;
        this.f456495o.setConnectListener(new e(this));     // Catch: Throwable -> L115
        this.f456495o.connect(r110);     // Catch: Throwable -> L115
    L102:
        if (this.f456486f != null) goto L104;
    L113:
        monitor-exit(this);
        return;
    L104:
        if (r110.protocols.contains("BDDLNA") == false) goto L113;
        List<String> r118 = this.f456500t;     // Catch: Throwable -> L115
        if (r118 == null) goto L113;
        if (((CopyOnWriteArrayList) r118).contains("BDDLNA") == false) goto L113;
        n r119 = (n) ((HashMap) this.G).get("BDDLNA");     // Catch: Throwable -> L115
        Objects.requireNonNull(r119);     // Catch: Throwable -> L115
        r119.f456537b = true;     // Catch: Throwable -> L115
        com.ss.cast.source.m r120 = this.f456502v;     // Catch: Throwable -> L115
        if (r120 == null) goto L112;
        r120.f456601g = r110;     // Catch: Throwable -> L115
    L112:
        this.f456484d.d("BDDLNA", "start", r110.castId, 0, "");     // Catch: Throwable -> L115
        this.f456486f.connect(r110);     // Catch: Throwable -> L115
        goto L113
    L83:
        if (r110.protocols.contains("DIAL") == false) goto L92;
        List<String> r121 = this.f456500t;     // Catch: Throwable -> L115
        if (r121 == null) goto L92;
        if (((CopyOnWriteArrayList) r121).contains("DIAL") == false) goto L92;
        n r122 = (n) ((HashMap) this.G).get("DIAL");     // Catch: Throwable -> L115
        Objects.requireNonNull(r122);     // Catch: Throwable -> L115
        r122.f456537b = true;     // Catch: Throwable -> L115
        this.f456494n.connect(r110);     // Catch: Throwable -> L115
        com.ss.cast.source.m r123 = this.f456502v;     // Catch: Throwable -> L115
        if (r123 == null) goto L91;
        r123.f456601g = r110;     // Catch: Throwable -> L115
    L91:
        this.f456484d.d("DIAL", "start", r110.castId, 0, "");     // Catch: Throwable -> L115
        goto L92
    L47:
        if (r110.protocols.contains("ChromeCast") == false) goto L56;
        List<String> r124 = this.f456500t;     // Catch: Throwable -> L115
        if (r124 == null) goto L56;
        if (((CopyOnWriteArrayList) r124).contains("ChromeCast") == false) goto L56;
        n r125 = (n) ((HashMap) this.G).get("ChromeCast");     // Catch: Throwable -> L115
        Objects.requireNonNull(r125);     // Catch: Throwable -> L115
        r125.f456537b = true;     // Catch: Throwable -> L115
        this.f456491k.connect(r110);     // Catch: Throwable -> L115
        com.ss.cast.source.m r126 = this.f456502v;     // Catch: Throwable -> L115
        if (r126 == null) goto L55;
        r126.f456601g = r110;     // Catch: Throwable -> L115
    L55:
        this.f456484d.d("ChromeCast", "start", r110.castId, 0, "");     // Catch: Throwable -> L115
    L115:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final boolean disConnect(ServiceInfo r100) {
        if (this.f456506z == true) goto L5;
        return false;
    L5:
        this.f456482b.d("ByteCastSourceImpl", "disConnect, info:" + r100);
        if (r100 == null) goto L62;
        String r101 = r100.protocols;
        if (r101 == null) goto L62;
        if (this.f456489i == null) goto L21;
        if (r101.contains("ByteLink") == true) goto L17;
        if (r100.protocols.contains(SourceModule.RTCLINK) == false) goto L21;
    L17:
        if (Dispatcher.getInstance().taskIsAlive("ByteLink") == false) goto L19;
        Dispatcher.getInstance().shutdownScheduleService("ByteLink");
    L19:
        this.f456489i.disConnect(r100);
    L21:
        if (this.f456488h == null) goto L28;
        if (r100.protocols.contains("BDLink") == false) goto L28;
        this.f456488h.disConnect(r100);
        com.ss.cast.source.m r102 = this.f456502v;
        if (r102 == null) goto L28;
        r102.f456601g = null;
    L28:
        if (this.f456491k == null) goto L33;
        if (r100.protocols.contains("ChromeCast") == false) goto L33;
        this.f456491k.disConnect(r100);
    L33:
        if (this.f456492l == null) goto L40;
        if (r100.protocols.contains("BDCloud") == false) goto L40;
        this.f456492l.disConnect(r100);
        com.ss.cast.source.m r103 = this.f456502v;
        if (r103 == null) goto L40;
        r103.f456601g = null;
    L40:
        if (this.f456493m == null) goto L47;
        if (r100.protocols.contains(SourceModule.SMARTVIEW) == false) goto L47;
        this.f456493m.disConnect(r100);
        com.ss.cast.source.m r104 = this.f456502v;
        if (r104 == null) goto L47;
        r104.f456601g = null;
    L47:
        if (this.f456494n == null) goto L54;
        if (r100.protocols.contains("DIAL") == false) goto L54;
        this.f456494n.disConnect(r100);
        com.ss.cast.source.m r105 = this.f456502v;
        if (r105 == null) goto L54;
        r105.f456601g = null;
    L54:
        if (this.f456486f != null) goto L56;
        return true;
    L56:
        if (r100.protocols.contains("BDDLNA") == false) goto L64;
        this.f456486f.disConnect(r100);
        com.ss.cast.source.m r106 = this.f456502v;
        if (r106 == null) goto L65;
        r106.f456601g = null;
        return true;
    L65:
        return true;
    L64:
        return true;
    L62:
        return false;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void getMediaInfo(ServiceInfo r100) {
        if (this.f456506z == true) goto L6;
        this.f456482b.w("ByteCastSourceImpl", "not verify auth.");
        return;
    L6:
        com.ss.cast.source.k r101 = this.W;
        r101.f456588k.i("PlayerController", "getMediaInfo");
        if (r100 != null) goto L9;
    L56:
        r101.f456588k.w("PlayerController", "serviceInfo is null or protocols are null.");
        return;
    L9:
        if (TextUtils.isEmpty(r100.protocols) == true) goto L56;
        r101.f456588k.d("PlayerController", "linkProtocols: " + r101.f456586i);
        if (r101.f456578a == null) goto L21;
        if (r100.protocols.contains("BDLink") == false) goto L21;
        List<String> r102 = r101.f456586i;
        if (r102 == null) goto L21;
        if (r102.contains("BDLink") == false) goto L21;
        r101.f456589l.f("BDLink");
        r101.f456578a.getMediaInfo(r100);
    L21:
        if (r101.f456582e == null) goto L30;
        if (r100.protocols.contains("BDCloud") == false) goto L30;
        List<String> r103 = r101.f456586i;
        if (r103 == null) goto L30;
        if (r103.contains("BDCloud") == false) goto L30;
        r101.f456589l.f("BDCloud");
        r101.f456582e.getMediaInfo(r100);
    L30:
        if (r101.f456583f == null) goto L39;
        if (r100.protocols.contains(SourceModule.SMARTVIEW) == false) goto L39;
        List<String> r104 = r101.f456586i;
        if (r104 == null) goto L39;
        if (r104.contains(SourceModule.SMARTVIEW) == false) goto L39;
        r101.f456589l.f(SourceModule.SMARTVIEW);
        r101.f456583f.getMediaInfo(r100);
    L39:
        if (r101.f456584g == null) goto L48;
        if (r100.protocols.contains("DIAL") == false) goto L48;
        List<String> r105 = r101.f456586i;
        if (r105 == null) goto L48;
        if (r105.contains("DIAL") == false) goto L48;
        r101.f456589l.f("DIAL");
        r101.f456584g.getMediaInfo(r100);
    L48:
        if (r101.f456579b != null) goto L50;
        return;
    L50:
        if (r100.protocols.contains("BDDLNA") == false) goto L59;
        List<String> r106 = r101.f456586i;
        if (r106 != null) goto L54;
        return;
    L54:
        if (r106.contains("BDDLNA") == false) goto L61;
        r101.f456589l.f("BDDLNA");
        r101.f456579b.getMediaInfo(r100);
        return;
    L61:
        return;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void setBrowseResultListener(IBrowseListener r100) {
        this.f456482b.d("ByteCastSourceImpl", "setBrowseResultListener listener:" + r100);
        this.Y = r100;
        IClient r101 = this.f456496p;
        if (r101 == null) goto L5;
        r101.setBrowseResultListener(new f(this, r100));
    L5:
        ICastSource r102 = this.f456488h;
        if (r102 == null) goto L8;
        r102.setBrowseResultListener(new g(this, r100));
    L8:
        ICastSource r103 = this.f456493m;
        if (r103 == null) goto L11;
        r103.setBrowseResultListener(new h(this, r100));
    L11:
        ICastSource r104 = this.f456494n;
        if (r104 == null) goto L14;
        r104.setBrowseResultListener(new i(this, r100));
    L14:
        ICastSource r105 = this.f456486f;
        if (r105 == null) goto L18;
        r105.setBrowseResultListener(new j(this, r100));
    L18:
        if (this.f456487g != null) goto L20;
    L24:
        ICastSource r106 = this.f456491k;
        if (r106 == null) goto L27;
        r106.setBrowseResultListener(new l(this, r100));
    L27:
        ICastSource r107 = this.f456489i;
        if (r107 == null) goto L31;
        r107.setBrowseResultListener(new a(this, r100));
    L31:
        if (this.f456497q == null) goto L33;
        new b(r100);
    L33:
        ICastSource r108 = this.f456495o;
        if (r108 == null) goto L37;
        r108.setBrowseResultListener(new c(this, r100));
        return;
    L37:
        return;
    L20:
        if (this.f456480a.getInitConfig().getLocalProtocols() == null) goto L24;
        if (this.f456480a.getInitConfig().getLocalProtocols().contains("LeLink") == false) goto L24;
        this.f456487g.setBrowseResultListener(new k(this, r100));
        goto L24
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void setConnectListener(IConnectListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.I = r100;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void setLibraryLoader(ILibraryLoader r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ICastSource r101 = this.f456489i;
        if (r101 == null) goto L7;
        r101.setLibraryLoader(r100);
    L7:
        IClient r102 = this.f456496p;
        if (r102 == null) goto L11;
        r102.setLibraryLoader(r100);
        return;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void setLogger(ILogger r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f456482b.setLogger(r100);
        ICastSource r101 = this.f456489i;
        if (r101 == null) goto L7;
        r101.setLogger(r100);
    L7:
        IClient r102 = this.f456496p;
        if (r102 == null) goto L11;
        r102.setLogger(r100);
        return;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void setMediaInfoListener(IMediaInfoListener r100) {
        com.ss.cast.source.k r101 = this.W;
        r101.f456587j = r100;
        ICastSource r102 = r101.f456578a;
        if (r102 == null) goto L5;
        r102.setMediaInfoListener(new com.ss.cast.source.k.d(r101, "BDLink"));
    L5:
        ICastSource r103 = r101.f456582e;
        if (r103 == null) goto L8;
        r103.setMediaInfoListener(new com.ss.cast.source.k.d(r101, "BDCloud"));
    L8:
        ICastSource r104 = r101.f456583f;
        if (r104 == null) goto L11;
        r104.setMediaInfoListener(new com.ss.cast.source.k.d(r101, SourceModule.SMARTVIEW));
    L11:
        ICastSource r105 = r101.f456584g;
        if (r105 == null) goto L14;
        r105.setMediaInfoListener(new com.ss.cast.source.k.d(r101, "DIAL"));
    L14:
        ICastSource r106 = r101.f456579b;
        if (r106 == null) goto L18;
        r106.setMediaInfoListener(new com.ss.cast.source.k.d(r101, "BDDLNA"));
        return;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void setMessageListener(IMessageListener r100) {
        ICastSource r101 = this.f456488h;
        if (r101 == null) goto L5;
        r101.setMessageListener(r100);
    L5:
        ICastSource r102 = this.f456489i;
        if (r102 == null) goto L8;
        r102.setMessageListener(r100);
    L8:
        ICastSource r103 = this.f456490j;
        if (r103 == null) goto L11;
        r103.setMessageListener(r100);
    L11:
        ICastSource r104 = this.f456486f;
        if (r104 == null) goto L15;
        r104.setMessageListener(r100);
        return;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void setShouldRestartBrowse(boolean r100) {
        ICastSource r101 = this.f456486f;
        if (r101 == null) goto L6;
        r101.setShouldRestartBrowse(r100);
        return;
    }

    public final boolean c(int r100, Object... r101) {
        if (r100 == 10033) goto L140;
        if (r100 != 10034) goto L7;
        Object r102 = r101[0];
        if ((r102 instanceof IAppCommonDataListener) == false) goto L138;
        this.f456483c.setAppCommonDataListener((IAppCommonDataListener) r102);
        this.f456485e.setAppCommonDataListener((IAppCommonDataListener) r101[0]);
    L138:
        return true;
    L7:
        if (r100 == 10037) goto L132;
        if (r100 == 10038) goto L128;
        if (r100 != 10084) goto L13;
    L125:
        this.f456480a.setOption(r100, r101);
        return true;
    L13:
        if (r100 == 10085) goto L125;
        if (r100 == 10087) goto L122;
        if (r100 == 10088) goto L118;
        switch(r100) {
            case 10000: goto L63;
            case 10018: goto L60;
            case 10020: goto L56;
            case 10024: goto L51;
            case 10043: goto L48;
            case 10072: goto L44;
            case 10074: goto L40;
            case 10090: goto L36;
            case 100039: goto L31;
            case 100042: goto L27;
            case 100073: goto L23;
            default: goto L19;
        };
    L19:
        switch(r100) {
            case 10002: goto L81;
            case 10003: goto L78;
            case 10004: goto L74;
            default: goto L20;
        };
    L20:
        switch(r100) {
            case 10058: goto L106;
            case 10059: goto L102;
            case 10060: goto L98;
            case 10061: goto L94;
            case 10062: goto L90;
            case 10063: goto L86;
            default: goto L21;
        };
    L21:
        switch(r100) {
            case 10080: goto L114;
            case 10081: goto L110;
            case 10082: goto L125;
            default: goto L22;
        };
    L22:
        return false;
    L110:
        if ((r101[0] instanceof Boolean) == false) goto L112;
        this.f456480a.getInitConfig().setEnableBDLinkSSDPCycleSearch((Boolean) r101[0]);
    L112:
        return true;
    L114:
        if ((r101[0] instanceof Boolean) == false) goto L116;
        this.f456480a.getInitConfig().setEnableBDLinkSSDPSwitch((Boolean) r101[0]);
    L116:
        return true;
    L86:
        if ((r101[0] instanceof Boolean) == false) goto L88;
        this.f456480a.getInitConfig().setHasInitByteSync(((Boolean) r101[0]).booleanValue());
    L88:
        return true;
    L90:
        if ((r101[0] instanceof Integer) == false) goto L92;
        this.f456480a.getInitConfig().setServiceId(((Integer) r101[0]).intValue());
    L92:
        return true;
    L94:
        if ((r101[0] instanceof String) == false) goto L96;
        this.f456480a.getInitConfig().setInstallId((String) r101[0]);
    L96:
        return true;
    L98:
        if ((r101[0] instanceof String) == false) goto L100;
        this.f456480a.getInitConfig().setaId((String) r101[0]);
    L100:
        return true;
    L102:
        if ((r101[0] instanceof Integer) == false) goto L104;
        this.f456480a.getInitConfig().setChannelId(((Integer) r101[0]).intValue());
    L104:
        return true;
    L106:
        if ((r101[0] instanceof Object) == false) goto L108;
        this.f456480a.getInitConfig().setWsChannelService(r101[0]);
    L108:
        return true;
    L81:
        Object r103 = r101[0];
        if ((r103 instanceof Integer) == false) goto L84;
        com.ss.cast.source.j r104 = this.V;
        ((Integer) r103).intValue();
        r104.getClass();
    L84:
        return true;
    L74:
        if ((r101[0] instanceof IMonitor) == false) goto L76;
        this.f456480a.getInitConfig().setMonitor((IMonitor) r101[0]);
    L76:
        return true;
    L78:
        if ((r101[0] instanceof IHttpNetWork) == false) goto L80;
        this.f456480a.getInitConfig().setNetAdapter((IHttpNetWork) r101[0]);
    L80:
        return true;
    L23:
        Object r105 = r101[0];
        if ((r105 instanceof Boolean) == false) goto L26;
        boolean r106 = ((Boolean) r105).booleanValue();
        this.f456482b.i("ByteCastSourceImpl", "isWriteLog: " + r106);
    L26:
        return true;
    L27:
        Object r107 = r101[0];
        if ((r107 instanceof ILogger) == false) goto L30;
        ILogger r108 = (ILogger) r107;
        Objects.toString(r108);
        setLogger(r108);
    L30:
        return false;
    L31:
        Object r109 = r101[0];
        if ((r109 instanceof String) == false) goto L34;
        this.S = String.valueOf(r109);
    L34:
        return true;
    L51:
        Object r110 = r101[0];
        if ((r110 instanceof Boolean) == false) goto L54;
        ((Boolean) r110).booleanValue();
        this.f456480a.getInitConfig().setStartUsbServer(true);
    L54:
        return true;
    L63:
        Object r111 = r101[0];
        if ((r111 instanceof IBindSdkInfoListener) == false) goto L72;
        IBindSdkInfoListener r112 = (IBindSdkInfoListener) r111;
        if (r112 == null) goto L69;
        ((CopyOnWriteArrayList) this.K).add(new com.ss.cast.source.f(this, r112));
    L69:
        ICastSource r113 = this.f456487g;
        if (r113 == null) goto L72;
        r113.setOption(r100, r101);
    L72:
        return true;
    L36:
        if ((r101[0] instanceof Boolean) == false) goto L38;
        this.f456480a.getInitConfig().setEnableDlnaNewDeviceOffline((Boolean) r101[0]);
    L38:
        return true;
    L40:
        if ((r101[0] instanceof Boolean) == false) goto L42;
        this.f456480a.getInitConfig().setForceJmDNS((Boolean) r101[0]);
    L42:
        return true;
    L44:
        if ((r101[0] instanceof DeviceOfflineDetectSettings) == false) goto L46;
        this.f456480a.getInitConfig().setDeviceOfflineDetectSettings((DeviceOfflineDetectSettings) r101[0]);
    L46:
        return true;
    L48:
        if ((r101[0] instanceof Boolean) == false) goto L50;
        this.f456480a.getInitConfig().setEnableDLNABroadCast((Boolean) r101[0]);
    L50:
        return true;
    L56:
        if ((r101[0] instanceof Boolean) == false) goto L58;
        this.f456480a.getInitConfig().setEnableBLE((Boolean) r101[0]);
    L58:
        return true;
    L60:
        if ((r101[0] instanceof String) == false) goto L62;
        this.f456480a.getInitConfig().setLocalProtocols(String.valueOf(r101[0]));
    L62:
        return true;
    L118:
        if ((r101[0] instanceof Boolean) == false) goto L120;
        this.f456480a.getInitConfig().setEnableBDLinkSourceBroadcast((Boolean) r101[0]);
    L120:
        return true;
    L122:
        if ((r101[0] instanceof String) == false) goto L124;
        this.f456480a.getInitConfig().setChromeCastId((String) r101[0]);
    L124:
        return true;
    L128:
        if ((r101[0] instanceof Boolean) == false) goto L130;
        this.f456480a.getInitConfig().setEnableDLNASearch((Boolean) r101[0]);
    L130:
        return true;
    L132:
        if ((r101[0] instanceof Boolean) == false) goto L134;
        this.f456480a.getInitConfig().setEnableDLNACache((Boolean) r101[0]);
    L134:
        return true;
    L140:
        if ((r101[0] instanceof Boolean) == false) goto L142;
        this.f456480a.getInitConfig().setForceDnssd((Boolean) r101[0]);
    L142:
        return true;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final Object getOption(int r100, Object... r101) {
        this.f456482b.d("ByteCastSourceImpl", "getOption");
        Map<String, ICastSource> r102 = this.f456498r;
        monitor-enter(r102);
        Iterator<String> r103 = this.f456498r.keySet().iterator();     // Catch: Throwable -> L16
    L6:
        if (r103.hasNext() == false) goto L13;
        String r104 = r103.next();     // Catch: Throwable -> L16
        ICastSource r105 = this.f456498r.get(r104);     // Catch: Throwable -> L16
        if (r105 == null) goto L6;
        this.f456482b.d("ByteCastSourceImpl", r104 + " getOption");     // Catch: Throwable -> L16
        Object r106 = r105.getOption(r100, r101);     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r106;
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void playDramaId(String r100, IResultListener r101) {
        com.ss.cast.source.k r102 = this.W;
        r102.f456588k.i("PlayerController", "start playDramaId, dramaId: " + r100);
        if (TextUtils.isEmpty(r100) == true) goto L7;
        r102.a();
        return;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void register(ServiceInfo r100, IRegisterResultListener r101) {
        com.ss.cast.source.m r102 = this.f456502v;
        if (r102 == null) goto L5;
        com.ss.cast.source.m.a r103 = r102.c(r100);
    L6:
        if (r103 != null) goto L9;
        this.f456482b.d("ByteCastSourceImpl", "subscribe we cannot find device:" + r100);
        return;
    L9:
        Map<String, ICastSource> r104 = this.f456498r;
        monitor-enter(r104);
        Iterator<String> r105 = this.f456498r.keySet().iterator();     // Catch: Throwable -> L26
    L13:
        if (r105.hasNext() == false) goto L24;
        String r106 = r105.next();     // Catch: Throwable -> L26
        if (TextUtils.equals(r106, "BDLink") == false) goto L13;
        if (r100.protocols.contains(r106) == false) goto L13;
        ICastSource r107 = this.f456498r.get(r106);     // Catch: Throwable -> L26
        if (r107 == null) goto L13;
        this.f456482b.d("ByteCastSourceImpl", r106 + " subscribe serviceInfo:" + r103.f456606e);     // Catch: Throwable -> L26
        r107.register(r103.f456606e, r101);     // Catch: Throwable -> L26
        monitor-exit(r104);     // Catch: Throwable -> L26
        return;
    L24:
        monitor-exit(r104);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final String sendSync(ServiceInfo r100, String r101) {
        this.f456482b.d("ByteCastSourceImpl", "sendSync serviceInfo:" + r100 + ", message:" + r101);
        ICastSource r102 = this.f456488h;
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.sendSync(r100, r101);
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void setOption(int r100, Object... r101) {
        if (r100 != 100042) goto L7;
        Object r102 = r101[0];
        if ((r102 instanceof ILogger) == false) goto L7;
        ILogger r103 = (ILogger) r102;
        Objects.toString(r103);
        setLogger(r103);
    L7:
        this.f456482b.i("ByteCastSourceImpl", "setOption, option:" + r100 + ", mirrorCastSourceMap.size:" + this.f456499s.size());
        if (c(r100, r101) == false) goto L10;
        return;
    L10:
        Map<String, ICastSource> r104 = this.f456498r;
        monitor-enter(r104);
        Iterator<String> r105 = this.f456498r.keySet().iterator();     // Catch: Throwable -> L30
    L14:
        if (r105.hasNext() == false) goto L19;
        String r106 = r105.next();     // Catch: Throwable -> L30
        ICastSource r107 = this.f456498r.get(r106);     // Catch: Throwable -> L30
        if (r107 == null) goto L14;
        this.f456482b.d("ByteCastSourceImpl", r106 + " setOption");     // Catch: Throwable -> L30
        r107.setOption(r100, r101);     // Catch: Throwable -> L30
        goto L14
    L19:
        monitor-exit(r104);     // Catch: Throwable -> L30
        if (this.f456489i == null) goto L23;
        this.f456482b.i("ByteCastSourceImpl", "bytelink setOption:" + r100);
        this.f456489i.setOption(r100, r101);
    L23:
        ICastSource r108 = this.f456490j;
        if (r108 == null) goto L26;
        r108.setOption(r100, r101);
    L26:
        IClient r109 = this.f456496p;
        if (r109 == null) goto L41;
        r109.setOption(r100, r101);
        return;
    L41:
        return;
    L30:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void unregister(ServiceInfo r100, IRegisterResultListener r101) {
        com.ss.cast.source.m r102 = this.f456502v;
        if (r102 == null) goto L5;
        com.ss.cast.source.m.a r103 = r102.c(r100);
    L6:
        if (r103 != null) goto L9;
        this.f456482b.d("ByteCastSourceImpl", "unsubscribe we cannot find device:" + r100);
        return;
    L9:
        Map<String, ICastSource> r104 = this.f456498r;
        monitor-enter(r104);
        Iterator<String> r105 = this.f456498r.keySet().iterator();     // Catch: Throwable -> L26
    L13:
        if (r105.hasNext() == false) goto L24;
        String r106 = r105.next();     // Catch: Throwable -> L26
        if (TextUtils.equals(r106, "BDLink") == false) goto L13;
        if (r100.protocols.contains(r106) == false) goto L13;
        ICastSource r107 = this.f456498r.get(r106);     // Catch: Throwable -> L26
        if (r107 == null) goto L13;
        this.f456482b.d("ByteCastSourceImpl", r106 + " unsubscribe serviceInfo:" + r103.f456606e);     // Catch: Throwable -> L26
        r107.unregister(r103.f456606e, r101);     // Catch: Throwable -> L26
        monitor-exit(r104);     // Catch: Throwable -> L26
        return;
    L24:
        monitor-exit(r104);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void getMsg(ServiceInfo r100, String r101, ISendResultListener r102) {
        this.f456482b.d("ByteCastSourceImpl", "getMsg serviceInfo:" + r100 + ", message:" + r101);
        ICastSource r103 = this.f456488h;
        if (r103 == null) goto L6;
        r103.getMsg(r100, r101, r102);
        return;
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void init(Context r210, Config r211, IInitListener r212) {
        Constants.attachAppContext(r210);
        if (r211 != null) goto L7;
        if (r212 == null) goto L183;
        r212.onError(IInitListener.ERROR_CODE_EMPTY_CONFIG, IInitListener.ERROR_MSG_EMPTY_CONFIG);
        return;
    L183:
        return;
    L7:
        this.U.setProjectId(r211.getProjectId());
        this.f456480a.init(r211);
        this.f456483c.initSessionID(r211.getDeviceId(), r211.getAppId(), r211.getProjectId(), "source");
        this.f456483c.init(r210, r211.getDeviceId(), r211.getMonitor());
        this.f456485e.initSessionID(r211.getProjectId());
        this.f456483c.sendByteCastAuthEvent("start", -1);
        this.f456485e.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_AUTH, new Map[]{new AnonymousClass1(this)});
        if (TextUtils.isEmpty(r211.getProjectId()) == false) goto L12;
        if (r212 == null) goto L184;
        r212.onError(IInitListener.ERROR_CODE_INVALID_PARAMS, IInitListener.ERROR_MSG_INVALID_PARAMS);
        return;
    L184:
        return;
    L12:
        NetworkManager.start(Constants.sAppContext, this.U);
        if (TextUtils.isEmpty(r211.getChromeCastId()) == true) goto L15;
        Utils.setChromeCastId(r211.getChromeCastId());
    L15:
        boolean r100 = r211.isEnableDebug();
        this.f456482b.i("ByteCastSourceImpl", "Is debug open? " + r100);
        String r101 = r211.getServiceName();
        this.f456482b.d("ByteCastSourceImpl", "config serviceName is " + r101);
        TextUtils.isEmpty(r101);
        Constants.isDebugMode = r100;
        this.f456482b.setEnable(r100);
        r211.isStartUsbServer();
        String r102 = r211.getLocalProtocols();
        if (TextUtils.isEmpty(r102) == true) goto L78;
        this.f456482b.i("ByteCastSourceImpl", "parseProtocols: " + r102);
        if (TextUtils.isEmpty(r102) == true) goto L78;
        String[] r103 = r102.split(",");
        if (r103 == null) goto L78;
        if (r103.length < 1) goto L78;
        ((CopyOnWriteArrayList) this.A).clear();
        ((CopyOnWriteArrayList) this.f456500t).clear();
        this.f456501u = new CopyOnWriteArrayList();
        int r104 = r103.length;
        int r105 = 0;
    L26:
        if (r105 >= r104) goto L76;
        String r106 = r103[r105];
        if (r106 != null) goto L31;
    L75:
        r105 = r105 + 1;
        r104 = r104;
        goto L26
    L31:
        switch(r106.hashCode()) {
            case -2023507661: goto L66;
            case -1803213502: goto L62;
            case -1407073126: goto L58;
            case 2098032: goto L54;
            case 457686803: goto L50;
            case 483315961: goto L46;
            case 559962094: goto L42;
            case 1954424701: goto L38;
            case 1954691932: goto L34;
            default: goto L69;
        };
    L69:
        byte r110 = -1;
    L70:
        switch(r110) {
            case 0: goto L74;
            case 1: goto L73;
            case 2: goto L72;
            case 3: goto L72;
            case 4: goto L72;
            case 5: goto L72;
            case 6: goto L72;
            case 7: goto L72;
            case 8: goto L72;
            default: goto L75;
        };
    L72:
        ((CopyOnWriteArrayList) this.f456500t).add(r106);
        goto L75
    L73:
        ((CopyOnWriteArrayList) this.f456501u).add(r106);
        goto L75
    L74:
        ((CopyOnWriteArrayList) this.f456500t).add(r106);
        ((CopyOnWriteArrayList) this.f456501u).add(r106);
        goto L75
    L34:
        if (r106.equals("BDLink") == false) goto L69;
        r110 = 8;
        goto L70
    L38:
        if (r106.equals("BDDLNA") == false) goto L69;
        r110 = 7;
        goto L70
    L42:
        if (r106.equals(SourceModule.SMARTVIEW) == false) goto L69;
        r110 = 6;
        goto L70
    L46:
        if (r106.equals("ChromeCast") == false) goto L69;
        r110 = 5;
        goto L70
    L50:
        if (r106.equals("BDCloud") == false) goto L69;
        r110 = 4;
        goto L70
    L54:
        if (r106.equals("DIAL") == false) goto L69;
        r110 = 3;
        goto L70
    L58:
        if (r106.equals(SourceModule.WEBOSTV) == false) goto L69;
        r110 = 2;
        goto L70
    L62:
        if (r106.equals("ByteLink") == false) goto L69;
        r110 = 1;
        goto L70
    L66:
        if (r106.equals("LeLink") == false) goto L69;
        r110 = 0;
        goto L70
    L76:
        ((CopyOnWriteArrayList) this.A).addAll(Arrays.asList(r103));
        this.f456482b.i("ByteCastSourceImpl", "parseProtocols: protocols: " + this.A);
    L78:
        if (r211.isInitialModeBind() == true) goto L97;
        setLogger(r211.getLogger());
        setLibraryLoader(r211.getLibraryLoader());
        IAppCommonDataListener r107 = r211.getCommonDataListener();
        if (r107 == null) goto L83;
        this.f456483c.setAppCommonDataListener(r107);
        this.f456485e.setAppCommonDataListener(r107);
    L83:
        this.S = r211.getDlnaXMLParserKeys();
        if (this.f456479J == true) goto L97;
        if (r211.getBindSdkInfoListeners() == null) goto L97;
        if (r211.getBindSdkInfoListeners().size() <= 0) goto L97;
        Iterator<IBindSdkInfoListener> r108 = r211.getBindSdkInfoListeners().iterator();
    L91:
        if (r108.hasNext() == false) goto L96;
        IBindSdkInfoListener r109 = r108.next();
        if (r109 == null) goto L91;
        ((CopyOnWriteArrayList) this.K).add(new com.ss.cast.source.f(this, r109));
        goto L91
    L96:
        this.f456479J = true;
    L97:
        IClient r111 = this.f456496p;
        if (r111 == null) goto L100;
        r111.init(r210);
    L100:
        this.E = new ConcurrentSubject();
        if (TextUtils.equals(this.P, "1") == true) goto L103;
    L105:
        String r112 = r211.getLocalProtocols();
        if (TextUtils.isEmpty(r112) == false) goto L108;
        Config r113 = r211;
        IInitListener r114 = r212;
    L158:
        ICastSource r115 = this.f456490j;
        if (r115 == null) goto L161;
        r115.init(r210, r113, r114);
    L161:
        this.f456482b.d("ByteCastSourceImpl", "wifi-p2p isEnableWifiP2PSearch:" + this.f456480a.getInitConfig().isEnableWifiP2PSearch() + "，wifiP2PManager：" + this.f456497q);
        zjc.a r116 = this.f456497q;
        if (r116 == null) goto L164;
        r116.a(r210, this.f456502v);
    L164:
        this.f456498r.clear();
        this.f456499s.clear();
        if (r211.isInitialModeBind() == false) goto L167;
        this.f456482b.i("ByteCastSourceImpl", "local verify");
        r211.getDeviceId();
        this.f456482b.i("ByteCastSourceImpl", "setAuthByLocalOption");
        d();
        e();
        this.f456482b.d("ByteCastSourceImpl", "set protocols by local protocols: " + this.A);
        this.f456483c.sendSourceEvent(CastMonitor.BYTECAST_SOURCE_AUTH_LOCAL, "pkg:" + r210.getPackageName() + ",protocols:" + this.A);
        this.f456506z = true;
        this.f456503w.execute(new com.ss.cast.source.b(this, r114));
    L171:
        getVersion();
        SourceDeviceInfo r117 = new SourceDeviceInfo();
        r117.name = r211.getServiceName();
        r117.deviceId = r211.getDeviceId();
        r117.appId = r211.getAppId();
        r117.userId = r211.getUserId();
        r117.sessionId = this.f456485e.sessionID;
        r117.version = BuildConfig.VERSION_NAME;
        r117.ping = 1;
        r117.codecsDetection = r211.getDisPlayTypes();
        this.D.saveLocalSourceDeviceInfo(r210, r117);
        return;
    L167:
        this.f456482b.i("ByteCastSourceImpl", "license verify");
        this.f456482b.i("ByteCastSourceImpl", "authByLicense: projectId: " + r211.getProjectId());
        if (this.f456504x != null) goto L170;
        this.f456504x = ContextManager.getAuthManager(this.U);
    L170:
        this.f456504x.init(r211.getProjectId());
        this.f456504x.verifyLicense(r211.getLicensePath(), new com.ss.cast.source.c(this, r114));
        goto L171
    L108:
        if (this.f456488h != null) goto L110;
    L114:
        r113 = r211;
        r114 = r212;
    L116:
        if (this.f456486f == null) goto L123;
        if (r112.contains("BDDLNA") == false) goto L120;
    L121:
        this.f456486f.init(r210, r113, r114);
        goto L123
    L120:
        if (r112.contains("DIAL") == true) goto L121;
    L123:
        if (this.f456487g == null) goto L128;
        if (r112.contains("LeLink") == false) goto L128;
        this.f456487g.init(r210, r113, new com.ss.cast.source.d(this));
    L128:
        if (this.f456489i == null) goto L133;
        if (r112.contains("ByteLink") == false) goto L133;
        this.f456489i.init(r210, r113, new com.ss.cast.source.e());
    L133:
        if (this.f456491k == null) goto L138;
        if (r112.contains("ChromeCast") == false) goto L138;
        this.f456491k.init(r210, r113, r114);
    L138:
        if (this.f456492l == null) goto L143;
        if (r112.contains("BDCloud") == false) goto L143;
        this.f456492l.init(r210, r113, r114);
    L143:
        if (this.f456493m == null) goto L148;
        if (r112.contains(SourceModule.SMARTVIEW) == false) goto L148;
        this.f456493m.init(r210, r113, r114);
    L148:
        if (this.f456494n == null) goto L153;
        if (r112.contains("DIAL") == false) goto L153;
        this.f456494n.init(r210, r113, r114);
    L153:
        if (this.f456495o == null) goto L158;
        if (r112.contains(SourceModule.WEBOSTV) == false) goto L158;
        this.f456495o.init(r210, r113, r114);
        goto L158
    L110:
        if (r112.contains("BDLink") == false) goto L112;
    L113:
        r113 = r211;
        r114 = r212;
        this.f456488h.init(r210, r113, r114);
        goto L116
    L112:
        if (r112.contains("DIAL") == false) goto L114;
    L103:
        if (this.O != null) goto L105;
        ScheduledExecutorService r118 = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("ByteCastSourceImpl"));
        this.O = r118;
        r118.scheduleAtFixedRate(new com.ss.cast.source.a(this), 0, 1000, TimeUnit.MILLISECONDS);
        goto L105
    }

    @Override // com.byted.cast.common.api.ICastSource
    public final void send(ServiceInfo r100, String r101, ISendResultListener r110) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f456500t).iterator();
    L4:
        if (r102.hasNext() == false) goto L27;
        String r103 = (String) r102.next();
        if (TextUtils.isEmpty(r100.protocols) == true) goto L4;
        if (r100.protocols.contains(r103) == false) goto L4;
        Map<String, ICastSource> r104 = this.f456498r;
        monitor-enter(r104);
        Iterator<String> r105 = this.f456498r.keySet().iterator();     // Catch: Throwable -> L24
    L13:
        if (r105.hasNext() == false) goto L22;
        String r106 = r105.next();     // Catch: Throwable -> L24
        ICastSource r107 = this.f456498r.get(r106);     // Catch: Throwable -> L24
        if (r107 == null) goto L13;
        if (TextUtils.equals(r103, r106) == false) goto L13;
        this.f456482b.d("ByteCastSourceImpl", r106 + " send");     // Catch: Throwable -> L24
        r107.send(r100, r101, r110);     // Catch: Throwable -> L24
        monitor-exit(r104);     // Catch: Throwable -> L24
        return;
    L22:
        monitor-exit(r104);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L27:
        Iterator<String> r108 = this.f456501u.iterator();
    L29:
        if (r108.hasNext() == false) goto L52;
        String r109 = r108.next();
        if (TextUtils.isEmpty(r100.protocols) == true) goto L29;
        if (r100.protocols.contains(r109) == false) goto L29;
        Map<String, ICastSource> r111 = this.f456499s;
        monitor-enter(r111);
        Iterator<String> r112 = this.f456499s.keySet().iterator();     // Catch: Throwable -> L49
    L38:
        if (r112.hasNext() == false) goto L47;
        String r113 = r112.next();     // Catch: Throwable -> L49
        ICastSource r114 = this.f456499s.get(r113);     // Catch: Throwable -> L49
        if (r114 == null) goto L38;
        if (TextUtils.equals(r109, r113) == false) goto L38;
        this.f456482b.d("ByteCastSourceImpl", r113 + " send");     // Catch: Throwable -> L49
        r114.send(r100, r101, r110);     // Catch: Throwable -> L49
        monitor-exit(r111);     // Catch: Throwable -> L49
        return;
    L47:
        monitor-exit(r111);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    }

    public static void b(ByteCastSourceImpl r100, List r110, String r111, boolean r112) {
        r100.getClass();
        if (r110 != null) goto L5;
        return;
    L5:
        if (r110.isEmpty() == true) goto L16;
        String r101 = r110.toString();
        String r102 = ServiceInfoUtils.getDeviceName(r110);
        String r113 = ServiceInfoUtils.getManufacture(r110);
        if (r100.Q == false) goto L11;
        r100.f456484d.h(BytecastBrowseType.ALL, r101, r102, r113, r112, r100.X);
    L11:
        if (r100.R == false) goto L13;
        r100.f456484d.h(BytecastBrowseType.SELECTED, r101, r102, r113, r112, r100.X);
    L13:
        r100.f456484d.c(r111, r101, r102, r113, r112, r100.X);
        r100.X = null;
        return;
    }
}
