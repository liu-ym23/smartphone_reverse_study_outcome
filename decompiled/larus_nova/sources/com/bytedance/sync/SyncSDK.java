package com.bytedance.sync;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.crash.Npth;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.sync.v2.WsMonitor;
import com.bytedance.sync.v2.e;
import com.bytedance.sync.v2.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.videoarch.strategy.log.StrategyCenterLogger;
import hg7.h;
import hg7.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import xf7.c;
import xf7.d;
import xf7.g;
import xf7.i;
import xf7.l;
import xf7.o;
import xf7.q;
import xf7.s;
import xf7.t;
import xf7.u;
import xf7.v;
import xf7.w;
import xf7.x;
import yf7.j;
import yf7.n;

/* JADX INFO: loaded from: classes3.dex */
public class SyncSDK {
    private static Context application;
    private static g configuration;
    private static final i executor = null;
    private static final c sCaches = null;
    private static final l sInitObservable = null;
    private static final AtomicBoolean sInited = null;
    private static volatile yf7.i service;

    /* JADX INFO: loaded from: classes22.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WsChannelMsg f270348a;

        @Override // java.lang.Runnable
        public final void run() {
            yf7.i r100 = SyncSDK.access$000();     // Catch: Throwable -> L4
            WsChannelMsg r101 = this.f270348a;     // Catch: Throwable -> L4
            u r102 = (u) r100;     // Catch: Throwable -> L4
            r102.f563506i.b(new Object[0]).post(new w(r102, r101));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(WsChannelMsg r100) {
            this.f270348a = r100;
        }
    }

    public static class b implements n {
        public b() {
        }

        @Override // yf7.n
        public final void a(j.a r100) {
            if (r100 == null) goto L8;
            byte[] r101 = r100.f567450a;
            if (r101 == null) goto L9;
            zf7.b.d("recv mock data:".concat(new String(r101)));
            return;
        L9:
            return;
        }
    }

    public SyncSDK() {
    }

    static {
        sInited = new AtomicBoolean(false);
        sCaches = new c();
        executor = new i();
        sInitObservable = new l();
        SDKMonitor r100 = t.f563496a;
        Npth.registerSdk("4119", "1.0.2-rc.30-doubao");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static boolean hasInit() {
        if (sInited.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (service == null) goto L7;
        return true;
    }

    private static void registerSyncBusiness() {
        com.bytedance.sync.a.C3779a r100 = new com.bytedance.sync.a.C3779a(1);
        r100.a(cg7.b.c(application));
        com.bytedance.sync.a r101 = r100.b();
        ((u) service).a(r101);
        Iterator<Long> r102 = q.f563493a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Long r103 = r102.next();
        yf7.i r104 = service;
        com.bytedance.sync.a.C3779a r105 = new com.bytedance.sync.a.C3779a(r103.longValue());
        r105.a(new b());
        u r106 = (u) r104;
        r106.a(r105.b());
        goto L4
    }

    public static Collection<o> getRegisteredBusinesses() {
        if (hasInit() == true) goto L6;
        return null;
    L6:
        d r100 = ((u) service).f563499b;
        r100.getClass();
        ArrayList r101 = new ArrayList(((ConcurrentHashMap) r100.f563450b).values());
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        o r103 = (o) r102.next();
        if (r103 == null) goto L8;
        if (r103.f563486a.f270349a != 1) goto L8;
        r102.remove();
        goto L8
    L14:
        return r101;
    }

    public static void trySyncDataFromServer() {
        if (hasInit() == false) goto L8;
        u r100 = (u) service;
        if (r100.f563505h.get() == false) goto L9;
        r100.f563506i.b(new Object[0]).post(new x(r100));
        return;
    L9:
        return;
    }

    public static /* synthetic */ yf7.i access$000() {
        return service;
    }

    public static void addInitObserver(Observer r100) {
        monitor-enter(SyncSDK.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (hasInit() == false) goto L9;
        r100.update(sInitObservable, null);     // Catch: Throwable -> L12
        monitor-exit(SyncSDK.class);     // Catch: Throwable -> L12
        return;
    L9:
        sInitObservable.addObserver(r100);     // Catch: Throwable -> L12
        monitor-exit(SyncSDK.class);     // Catch: Throwable -> L12
    }

    public static List<j.a> getHistoryData(gg7.c r100) {
        if (hasInit() == true) goto L5;
        return null;
    L5:
        throw null;
    }

    public static void onReceiveWsEvent(WsChannelMsg r100) {
        zf7.b.d("onReceiveWsEvent");
        if (r100 != null) goto L5;
    L9:
        zf7.b.d("onReceiveWsEvent not process. serviceId isn't 20032");
        return;
    L5:
        if (r100.getService() != 20032) goto L9;
        executor.b(new a(r100));
    }

    public static j registerBusiness(com.bytedance.sync.a r100) {
        if (r100.f270349a != 1) goto L7;
        zf7.b.b("inner business,not allow to register");
        return null;
    L7:
        if (hasInit() == true) goto L11;
        c r101 = sCaches;
        r101.getClass();
        c.a r102 = new c.a();
        r101.f563446a.b(new xf7.b(r102, r100));
        return r102;
    L11:
        return ((u) service).a(r100);
    }

    public static void removeInitObserver(Observer r100) {
        sInitObservable.deleteObserver(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void runAfterStart(Runnable r100) {
        executor.b(r100);
    }

    public static void init(Context r100, g r101) {
        monitor-enter(SyncSDK.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (hasInit() == false) goto L8;
        monitor-exit(SyncSDK.class);     // Catch: Throwable -> L17
        return;
    L8:
        zf7.b.a("init " + r101 + ", sdk version = 1.0.2-rc.30-doubao");     // Catch: Throwable -> L17
        application = r100;     // Catch: Throwable -> L17
        r101.getClass();     // Catch: Throwable -> L17
        configuration = r101;     // Catch: Throwable -> L17
        service = new u(r100, r101);     // Catch: Throwable -> L17
        boolean r102 = true;
        sInited.set(true);     // Catch: Throwable -> L17
        monitor-exit(SyncSDK.class);     // Catch: Throwable -> L17
        l r103 = sInitObservable;
        r103.a();
        r103.deleteObservers();
        c r104 = sCaches;
        if (((LinkedList) r104.f563446a.f563481a).size() > 0) goto L14;
        r102 = false;
    L14:
        if (r102 == false) goto L21;
        TTExecutors.getCPUThreadPool().submit(new xf7.a(r104));
        return;
    }

    public static j registerBusiness(int r100, n r101) {
        com.bytedance.sync.a.C3779a r102 = new com.bytedance.sync.a.C3779a(r100);
        r102.a(r101);
        return registerBusiness(r102.b());
    }

    public static void start(String r100, String r101) {
        zf7.b.d("#start, did = " + r100 + ", iid = " + r101);
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L57:
        zf7.b.c("#start#ignore, did or iid is null");
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L57;
        if (hasInit() == false) goto L56;
        zf7.b.a("#start");
        Context r102 = application;
        g r103 = configuration;
        SDKMonitor r104 = t.f563496a;
        if (TextUtils.isEmpty(r103.f563461h) == true) goto L31;
        t.f563497b = true;
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L29
        r105.put("device_id", r100);     // Catch: JSONException -> L16 Exception -> L29
        r105.put("host_aid", r103.f563454a);     // Catch: JSONException -> L16 Exception -> L29
        r105.put("sdk_version", "1.0.2-rc.30-doubao");     // Catch: JSONException -> L16 Exception -> L29
    L18:
        SDKMonitorUtils.setDefaultReportUrl("4119", CollectionsKt.listOf(r103.f563461h + StrategyCenterLogger.SLARDAR_REPORT_LOG_API_PATH));     // Catch: Exception -> L29
        SDKMonitorUtils.setConfigUrl("4119", CollectionsKt.listOf(r103.f563461h + StrategyCenterLogger.SLARDAR_FETCH_CONFIG_API_PATH));     // Catch: Exception -> L29
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L29
    L25:
        if (r102 != null) goto L27;
        Intrinsics.throwNpe();     // Catch: Exception -> L29
    L27:
        SDKMonitorUtils.initMonitor(r102, "4119", r105, new s(r103));     // Catch: Exception -> L29
        t.f563496a = SDKMonitorUtils.getInstance("4119");     // Catch: Exception -> L29
        goto L31
    L20:
        if (r103.f563463j == false) goto L25;
        r105.put("channel", r103.f563455b.getCommonParams().get("channel"));     // Catch: Exception -> L23
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        t.f563497b = false;
    L31:
        u r106 = (u) service;
        monitor-enter(r106);
        yf7.c r107 = (yf7.c) rgc.b.a(yf7.c.class);     // Catch: Throwable -> L52
        r107.k0(r100);     // Catch: Throwable -> L52
        if (r106.f563505h.compareAndSet(false, true) == false) goto L42;
        r107.E();     // Catch: Throwable -> L52
        WsMonitor r108 = new WsMonitor();     // Catch: Throwable -> L52
        r108.f270383a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L52
        m r109 = (m) rgc.b.a(m.class);     // Catch: Throwable -> L52
        if (r109.a() == false) goto L38;
        r108.a(0);     // Catch: Throwable -> L52
        goto L42
    L38:
        r109.o0(new e(r108, r109));     // Catch: Throwable -> L52
        f r110 = new f(r108);     // Catch: Throwable -> L52
        if (Looper.getMainLooper() != Looper.myLooper()) goto L41;
        r110.run();     // Catch: Throwable -> L52
        goto L42
    L41:
        new Handler(Looper.getMainLooper()).post(r110);     // Catch: Throwable -> L52
    L42:
        com.bytedance.sync.v2.d r111 = r106.f563504g;     // Catch: Throwable -> L52
        if (r111 != null) goto L45;
    L48:
        com.bytedance.sync.v2.d r112 = new com.bytedance.sync.v2.d(r106.f563498a);     // Catch: Throwable -> L52
        r106.f563504g = r112;     // Catch: Throwable -> L52
        r112.b();     // Catch: Throwable -> L52
        ((h) rgc.b.a(h.class)).w0();     // Catch: Throwable -> L52
        r106.f563506i.b(new Object[0]).postDelayed(new v(r106), TimeUnit.MINUTES.toMillis(2));     // Catch: Throwable -> L52
        monitor-exit(r106);
        executor.a();
        registerSyncBusiness();
        return;
    L45:
        if (r111.f270432c == null) goto L47;
        ((yf7.c) rgc.b.a(yf7.c.class)).x0(r111.f270432c);     // Catch: Throwable -> L52
    L47:
        r111.f270431b.removeCallbacksAndMessages(null);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;
    L56:
        throw new IllegalStateException("please init first");
    }

    public static void subscribeTopic(ag7.b r100, yf7.a<Void> r101) {
        og7.c r102 = ((u) service).f563503f;
        og7.d r103 = new og7.d(r100, "subscribe", r101);
        r102.getClass();
        dg7.a.d r104 = ((yf7.c) rgc.b.a(yf7.c.class)).getDeviceInfo();
        String r105 = r100.b();
        boolean r106 = true;
        if (r105 != null) goto L5;
    L8:
        boolean r107 = true;
    L9:
        if (r107 == false) goto L11;
        r100.d(r104.f468523a);
    L11:
        String r108 = r100.c();
        if (r108 != null) goto L14;
    L17:
        if (r106 == false) goto L19;
        r100.e(r104.f468524b);
    L19:
        zf7.b.a("do subscribeTopic. topic = " + r100);
        TTExecutors.getIOThreadPool().submit(new og7.a(r100, r103));
        return;
    L14:
        if (r108.length() == 0) goto L17;
        r106 = false;
        goto L17
    L5:
        if (r105.length() == 0) goto L8;
        r107 = false;
        goto L9
    }

    public static void unsubscribeTopic(ag7.b r100, yf7.a<Void> r101) {
        og7.c r102 = ((u) service).f563503f;
        og7.d r103 = new og7.d(r100, "unsubscribe", r101);
        r102.getClass();
        zf7.b.a("do unsubscribeTopic. topic = " + r100);
        dg7.a.d r104 = ((yf7.c) rgc.b.a(yf7.c.class)).getDeviceInfo();
        String r105 = r100.b();
        boolean r106 = true;
        if (r105 != null) goto L5;
    L8:
        boolean r107 = true;
    L9:
        if (r107 == false) goto L11;
        r100.d(r104.f468523a);
    L11:
        String r108 = r100.c();
        if (r108 != null) goto L14;
    L17:
        if (r106 == false) goto L19;
        r100.e(r104.f468524b);
    L19:
        TTExecutors.getIOThreadPool().submit(new og7.b(r100, r103));
        return;
    L14:
        if (r108.length() == 0) goto L17;
        r106 = false;
        goto L17
    L5:
        if (r105.length() == 0) goto L8;
        r107 = false;
        goto L9
    }
}
