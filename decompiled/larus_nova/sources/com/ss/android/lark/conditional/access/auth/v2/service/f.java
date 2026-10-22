package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.model.ResponseType;
import com.bytedance.lark.policy.model.b0;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.auth.v2.y;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import i8b.p;
import i8b.q;
import i8b.r;
import i8b.s;
import i8b.v;
import i8b.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f extends i8b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PthreadTimer f417900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f417901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, i> f417902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f417903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f417904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ScheduledExecutorService f417905g;

    public final class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f417906a;

        public final void a() {
            ArrayList<String> r100 = com.ss.android.lark.conditional.access.utils.c.f418483a;
            com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_DelayCleanupService", "Clean up execute", true);
            ArrayList r101 = new ArrayList();
            long r102 = System.currentTimeMillis();
            f r103 = this.f417906a;
            Iterator<Map.Entry<String, i>> r104 = r103.f417902d.entrySet().iterator();
        L3:
            int r105 = 0;
            if (r104.hasNext() == false) goto L15;
            Map.Entry<String, i> r106 = r104.next();
            String r107 = r106.getKey();
            i r108 = r106.getValue();
            if (r108.f417909a == false) goto L3;
            Long r110 = r108.f417910b;
            if (r110 != null) goto L11;
        L13:
            if (r105 == 0) goto L3;
            r101.add(r107);
            r108.f417910b = null;
            goto L3
        L11:
            if ((r102 - r110.longValue()) < r103.f417904f) goto L13;
            r105 = 1;
            goto L13
        L15:
            int r109 = ScsLogger.f440428a;
            ScsLogger.a("SecurityPolicy_DelayCleanupService", "IpInfo will clean: " + this.f417906a.f417902d);
            Iterator<Map.Entry<String, i>> r111 = this.f417906a.f417902d.entrySet().iterator();
        L17:
            if (r111.hasNext() == false) goto L21;
            if (r111.next().getValue().f417910b == null) goto L17;
            r105 = r105 + 1;
            goto L17
        L21:
            if (r105 >= 1) goto L24;
            f r112 = this.f417906a;
            r112.f417905g.execute(new g(r112));
        L24:
            if ((true ^ r101.isEmpty()) == false) goto L39;
            ScsLogger.d("SecurityPolicy_DelayCleanupService", "notifyEvent RemoveResultEvent");
            this.f417906a.c(new s(r101));
            return;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
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

        public a(f r100) {
            this.f417906a = r100;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
        this.f417905g.execute(new g(this));
        this.f417902d.clear();
    }

    public final int e() {
        Iterator<Map.Entry<String, i>> r100 = this.f417902d.entrySet().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L8;
        if (r100.next().getValue().f417909a == false) goto L4;
        r101 = r101 + 1;
        goto L4
    L8:
        return r101;
    }

    public f(q r100) {
        Intrinsics.checkNotNullParameter(r100, "mManager");
        super(r100);
        this.f417902d = new ConcurrentHashMap();
        this.f417903e = w4c.c.a().a0() * 1000;
        this.f417904f = w4c.c.a().b0() * 1000;
        this.f417905g = CoreThreadPool.getDefault().getSingleScheduledThreadPool("security_delay_clean_thread");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof w) == false) goto L22;
        ScsLogger.d("SecurityPolicy_DelayCleanupService", "handleEvent ValidateUpdateEvent");
        Map<String, b0> r101 = ((v) ((w) r100).f440413a).f488734b;
        ScsLogger.a("SecurityPolicy_DelayCleanupService", "updateClearInfo taskID: " + r101 + ", " + this.f417902d);
        Iterator<Map.Entry<String, i>> r102 = this.f417902d.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L19;
        Map.Entry<String, i> r103 = r102.next();
        String r104 = r103.getKey();
        i r105 = r103.getValue();
        if (r105.f417909a == false) goto L6;
        if (r105.f417910b == null) goto L6;
        b0 r106 = r101.get(r104);
        if (r106 == null) goto L6;
        if (r106.c() != null) goto L6;
        if (r106.getType() == ResponseType.DOWNGRADE) goto L6;
        r105.f417910b = null;
        goto L6
    L19:
        if (e() >= 1) goto L43;
        this.f417905g.execute(new g(this));
        return;
    L43:
        return;
    L22:
        if ((r100 instanceof p) == false) goto L25;
        f(((IPConfig) ((p) r100).f440413a).getIpConfigInfo());
        return;
    L25:
        if ((r100 instanceof r) == true) goto L27;
        return;
    L27:
        if (((r) r100).f440413a != FileAuthMonitor.UpdateTrigger.NetworkChange) goto L47;
        ScsLogger.d("SecurityPolicy_DelayCleanupService", "handleEvent LifeCycleEvent.data == NetworkChange");
        this.f417905g.execute(new h(this));
        return;
    }

    public final void f(Map<String, Boolean> r100) {
        int r101 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_DelayCleanupService", "updateIPConfig, ipConfigMap is " + com.ss.android.lark.security.compliance.infra.util.f.c(r100));
        Iterator<Map.Entry<String, Boolean>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, Boolean> r103 = r102.next();
        String r104 = r103.getKey();
        boolean r105 = r103.getValue().booleanValue();
        i r106 = this.f417902d.get(r104);
        if (r106 == null) goto L8;
        Long r107 = r106.f417910b;
    L9:
        if (r107 == null) goto L13;
        if (r105 == false) goto L13;
        this.f417902d.put(r104, new i(true, r106.f417910b));
    L13:
        this.f417902d.put(r104, new i(r105, null));
        goto L4
    L8:
        r107 = null;
        goto L9
    }

    @Override // i8b.a
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "tenantId");
        com.ss.android.lark.storage.kv.repo.a r102 = y.f417932a;
        com.ss.android.lark.storage.kv.repo.a r103 = y.f417932a;
        if (r103 == null) goto L5;
        IPConfig r104 = (IPConfig) r103.getJSONObject("FileAuthIPConfig", IPConfig.class);
    L6:
        if (r104 != null) goto L8;
        Map<String, Boolean> r105 = new HashMap();
    L9:
        f(r105);
        this.f417905g.execute(new h(this));
        return;
    L8:
        r105 = r104.getIpConfigInfo();
        goto L9
    L5:
        r104 = null;
        goto L6
    }
}
