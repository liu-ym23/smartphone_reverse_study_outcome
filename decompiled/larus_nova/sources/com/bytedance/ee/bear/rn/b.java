package com.bytedance.ee.bear.rn;

import com.bytedance.android.livesdk.chatroom.model.interact.e1;
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

/* JADX INFO: loaded from: classes18.dex */
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
        RnSyncManager r100 = RnSyncManager.f236496a;
        return (dx4.a) RnSyncManager.f236520y.getValue();
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final boolean h() {
        RnSyncManager r100 = RnSyncManager.f236496a;
        return RnSyncManager.f236517v;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final boolean isInit() {
        return RnSyncManager.f236501f.get();
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void m() {
        if (RnSyncManager.f236500e == null) goto L6;
        tt5.a.h("DefaultRnManager", "initWithResource, baseAbsolutePath exists");
        init(false);
        return;
    L6:
        s2 r100 = s2.f221500c;
        s2 r101 = s2.a.a();
        if (r101 == null) goto L13;
        ResConfig r102 = r101.f221501a;
        if (r102 == null) goto L13;
        ChameleonConfig r103 = new ChameleonConfig.Builder().bizName(ChameleonBizType.BIZ_DOCS.getType()).resConfig(r102).build();
        Chameleon r104 = Chameleon.f411115a;
        c r105 = new c(this);
        Intrinsics.checkNotNullParameter(r103, "chameleonConfig");
        Intrinsics.checkNotNullParameter(r105, "callback");
        ((IChameleonApi) Chameleon.f411116b.getValue()).loadResource(r103, r105);
        return;
    L13:
        tt5.a.d("DefaultRnManager", "initWithResource, sharedConfig is null");
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        RnSyncManager r101 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(r100, "message");
        Message r102 = new Message();
        r102.f227152c = r100;
        wl5.f r103 = RnSyncManager.f236505j;
        if (r103 == null) goto L6;
        r103.d(r102.b());
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void b(c2.g r100) {
        Intrinsics.checkNotNullParameter(r100, "iRnConnectStatus");
        RnSyncManager r101 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(r100, "iRnConnectStatus");
        RnSyncManager.f236516u.add(r100);
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final Flowable<String> d(Function0<? extends Flowable<String>> r100) {
        Intrinsics.checkNotNullParameter(r100, e1.REPLY_ACTION_APPLY);
        return yl5.b.b(r100);
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void e(final j0.c r100) {
        Intrinsics.checkNotNullParameter(r100, "iSendDataCallback");
        RnSyncManager r101 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(r100, "iSendDataCallback");
        Flowable<String> r102 = yl5.b.b(new RnSyncManager$unRegistSendDataCallback$1(r100));
        if (r102 == null) goto L6;
        r102.subscribe();
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        RnSyncManager.k(r100);
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void i(com.bytedance.ee.bear.contract.n.d r100) {
        Intrinsics.checkNotNullParameter(r100, "iSendDataCallback");
        RnSyncManager r101 = RnSyncManager.f236496a;
        RnSyncManager.f(r100);
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void init(boolean r100) {
        RnSyncManager r101 = RnSyncManager.f236496a;
        monitor-enter(RnSyncManager.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (eu5.b.f474075a != null) goto L9;
        tt5.a.h("RnSyncManager", " init=============ContextUtils.baseApplication = null");     // Catch: Throwable -> L23
        monitor-exit(RnSyncManager.class);
        return;
    L9:
        if (r100 == false) goto L17;
        tt5.a.h("RnSyncManager", " init=============isReload: " + r100);     // Catch: Throwable -> L23
        if (RnSyncManager.f236503h != null) goto L13;
        tt5.a.d("RnSyncManager", "mApplication == null, can't reload");     // Catch: Throwable -> L23
        goto L17
    L13:
        RnSyncManager r102 = RnSyncManager.f236496a;     // Catch: Throwable -> L23
        RnSyncManager.i();     // Catch: Throwable -> L23
        monitor-exit(RnSyncManager.class);
        return;
    L17:
        if (RnSyncManager.f236501f.get() == false) goto L20;
        monitor-exit(RnSyncManager.class);
        return;
    L20:
        tt5.a.h("RnSyncManager", " init=============start");     // Catch: Throwable -> L23
        RnSyncManager.f236499d = System.currentTimeMillis();     // Catch: Throwable -> L23
        RnSyncManager.f236503h = eu5.b.f474075a;     // Catch: Throwable -> L23
        RnSyncManager.f236511p = (b0) org.koin.java.a.c(b0.class, null, null, 6);     // Catch: Throwable -> L23
        RnSyncManager.f236512q = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);     // Catch: Throwable -> L23
        ((h0) org.koin.java.a.c(h0.class, null, null, 6)).Pe(new n());     // Catch: Throwable -> L23
        o r103 = o.f236628a;     // Catch: Throwable -> L23
        RnSyncManager.f236506k = new tb5.p();     // Catch: Throwable -> L23
        p r104 = p.f236629a;     // Catch: Throwable -> L23
        RnSyncManager.f236507l = new ub5.a();     // Catch: Throwable -> L23
        RnSyncManager.f236508m = new tl5.l();     // Catch: Throwable -> L23
        RnSyncManager.f236509n = new tl5.l();     // Catch: Throwable -> L23
        RnSyncManager.f236510o = new tl5.h();     // Catch: Throwable -> L23
        RnSyncManager r105 = RnSyncManager.f236496a;     // Catch: Throwable -> L23
        RnSyncManager.g("biz.util.sendMessageToWebview", RnSyncManager.f236508m);     // Catch: Throwable -> L23
        RnSyncManager.g("biz.comment.postMessage", RnSyncManager.f236509n);     // Catch: Throwable -> L23
        RnSyncManager.g("biz.util.sendDataToNative", RnSyncManager.f236510o);     // Catch: Throwable -> L23
        ((dx4.a) RnSyncManager.f236520y.getValue()).init(RnSyncManager.f236503h);     // Catch: Throwable -> L23
        RnSyncManager.d();     // Catch: Throwable -> L23
        tt5.a.h("RnSyncManager", " init=============end");     // Catch: Throwable -> L23
        monitor-exit(RnSyncManager.class);
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void j(tb5.m r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        RnSyncManager r101 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        tl5.l r102 = RnSyncManager.f236508m;
        if (r102 == null) goto L6;
        r102.a(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void k(tb5.m r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        RnSyncManager r101 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        tl5.l r102 = RnSyncManager.f236509n;
        if (r102 == null) goto L6;
        r102.a(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void l(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        RnSyncManager r101 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(r100, "message");
        wl5.f r102 = RnSyncManager.f236505j;
        if (r102 == null) goto L6;
        r102.d(r100.b());
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void n(VFSPath r100) {
        RnSyncManager.f236500e = r100;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void o(tb5.m r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        RnSyncManager r101 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        tl5.l r102 = RnSyncManager.f236509n;
        if (r102 == null) goto L6;
        r102.c(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void p(tb5.m r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        RnSyncManager r101 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        tl5.l r102 = RnSyncManager.f236508m;
        if (r102 == null) goto L6;
        r102.c(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.j
    public final void c(String r100, tb5.i<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        RnSyncManager r102 = RnSyncManager.f236496a;
        RnSyncManager.g(r100, r101);
    }
}
