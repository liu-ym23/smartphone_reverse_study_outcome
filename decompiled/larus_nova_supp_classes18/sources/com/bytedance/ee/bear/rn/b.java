package com.bytedance.ee.bear.rn;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.s2;
import com.bytedance.ee.bear.jsbridge.Message;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IChameleonApi;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kd5.c2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import z45.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Singleton
public final class b implements j {

    public static final class a {
    }

    static {
    }

    @Inject
    public b() {
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final dx4.a g() {
        RnSyncManager r0 = RnSyncManager.a;
        return (dx4.a) RnSyncManager.y.getValue();
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final boolean h() {
        RnSyncManager r0 = RnSyncManager.a;
        return RnSyncManager.v;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final boolean isInit() {
        return RnSyncManager.f.get();
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void m() {
        if (RnSyncManager.e == null) goto L6;
        tt5.a.h("DefaultRnManager", "initWithResource, baseAbsolutePath exists");
        init(false);
        return;
    L6:
        s2 r0 = s2.c;
        s2 r1 = s2.a.a();
        if (r1 == null) goto L13;
        ResConfig r2 = r1.a;
        if (r2 == null) goto L13;
        ChameleonConfig r3 = new ChameleonConfig.Builder().bizName(ChameleonBizType.BIZ_DOCS.getType()).resConfig(r2).build();
        Chameleon r4 = Chameleon.a;
        c r5 = new c(this);
        Intrinsics.checkNotNullParameter(r3, "chameleonConfig");
        Intrinsics.checkNotNullParameter(r5, "callback");
        ((IChameleonApi) Chameleon.b.getValue()).loadResource(r3, r5);
        return;
    L13:
        tt5.a.d("DefaultRnManager", "initWithResource, sharedConfig is null");
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        RnSyncManager r1 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(r3, "message");
        Message r0 = new Message();
        r0.c = r3;
        wl5.f r4 = RnSyncManager.j;
        if (r4 == null) goto L6;
        r4.d(r0.b());
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void b(c2.g r3) {
        Intrinsics.checkNotNullParameter(r3, "iRnConnectStatus");
        RnSyncManager r1 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(r3, "iRnConnectStatus");
        RnSyncManager.u.add(r3);
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final Flowable<String> d(Function0<? extends Flowable<String>> r2) {
        Intrinsics.checkNotNullParameter(r2, "apply");
        return yl5.b.b(r2);
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void e(final j0.c r3) {
        Intrinsics.checkNotNullParameter(r3, "iSendDataCallback");
        RnSyncManager r1 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(r3, "iSendDataCallback");
        Flowable<String> r4 = yl5.b.b(new RnSyncManager$unRegistSendDataCallback$1(r3));
        if (r4 == null) goto L6;
        r4.subscribe();
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        RnSyncManager.k(r2);
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void i(com.bytedance.ee.bear.contract.n.d r2) {
        Intrinsics.checkNotNullParameter(r2, "iSendDataCallback");
        RnSyncManager r0 = RnSyncManager.a;
        RnSyncManager.f(r2);
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void init(boolean r5) {
        RnSyncManager r0 = RnSyncManager.a;
        monitor-enter(RnSyncManager.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (eu5.b.a != null) goto L9;
        tt5.a.h("RnSyncManager", " init=============ContextUtils.baseApplication = null");     // Catch: Throwable -> L23
        monitor-exit(RnSyncManager.class);
        return;
    L9:
        if (r5 == false) goto L17;
        tt5.a.h("RnSyncManager", " init=============isReload: " + r5);     // Catch: Throwable -> L23
        if (RnSyncManager.h != null) goto L13;
        tt5.a.d("RnSyncManager", "mApplication == null, can't reload");     // Catch: Throwable -> L23
        goto L17
    L13:
        RnSyncManager r6 = RnSyncManager.a;     // Catch: Throwable -> L23
        RnSyncManager.i();     // Catch: Throwable -> L23
        monitor-exit(RnSyncManager.class);
        return;
    L17:
        if (RnSyncManager.f.get() == false) goto L20;
        monitor-exit(RnSyncManager.class);
        return;
    L20:
        tt5.a.h("RnSyncManager", " init=============start");     // Catch: Throwable -> L23
        RnSyncManager.d = System.currentTimeMillis();     // Catch: Throwable -> L23
        RnSyncManager.h = eu5.b.a;     // Catch: Throwable -> L23
        RnSyncManager.p = (b0) org.koin.java.a.c(b0.class, null, null, 6);     // Catch: Throwable -> L23
        RnSyncManager.q = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);     // Catch: Throwable -> L23
        ((h0) org.koin.java.a.c(h0.class, null, null, 6)).Pe(new n());     // Catch: Throwable -> L23
        o r1 = o.a;     // Catch: Throwable -> L23
        RnSyncManager.k = new tb5.p();     // Catch: Throwable -> L23
        p r2 = p.a;     // Catch: Throwable -> L23
        RnSyncManager.l = new ub5.a();     // Catch: Throwable -> L23
        RnSyncManager.m = new tl5.l();     // Catch: Throwable -> L23
        RnSyncManager.n = new tl5.l();     // Catch: Throwable -> L23
        RnSyncManager.o = new tl5.h();     // Catch: Throwable -> L23
        RnSyncManager r7 = RnSyncManager.a;     // Catch: Throwable -> L23
        RnSyncManager.g("biz.util.sendMessageToWebview", RnSyncManager.m);     // Catch: Throwable -> L23
        RnSyncManager.g("biz.comment.postMessage", RnSyncManager.n);     // Catch: Throwable -> L23
        RnSyncManager.g("biz.util.sendDataToNative", RnSyncManager.o);     // Catch: Throwable -> L23
        ((dx4.a) RnSyncManager.y.getValue()).init(RnSyncManager.h);     // Catch: Throwable -> L23
        RnSyncManager.d();     // Catch: Throwable -> L23
        tt5.a.h("RnSyncManager", " init=============end");     // Catch: Throwable -> L23
        monitor-exit(RnSyncManager.class);
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void j(tb5.m r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        RnSyncManager r1 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        tl5.l r0 = RnSyncManager.m;
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void k(tb5.m r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        RnSyncManager r1 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        tl5.l r0 = RnSyncManager.n;
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void l(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        RnSyncManager r1 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(r3, "message");
        wl5.f r0 = RnSyncManager.j;
        if (r0 == null) goto L6;
        r0.d(r3.b());
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void n(VFSPath r1) {
        RnSyncManager.e = r1;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void o(tb5.m r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        RnSyncManager r1 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        tl5.l r0 = RnSyncManager.n;
        if (r0 == null) goto L6;
        r0.c(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void p(tb5.m r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        RnSyncManager r1 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        tl5.l r0 = RnSyncManager.m;
        if (r0 == null) goto L6;
        r0.c(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void c(String r2, tb5.i<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "handlerName");
        RnSyncManager r0 = RnSyncManager.a;
        RnSyncManager.g(r2, r3);
    }
}
