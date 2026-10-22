package ra5;

import com.bytedance.ee.bear.basesdk.IDocInit;
import com.bytedance.ee.bear.basesdk.apisupport.w;
import com.bytedance.ee.bear.contract.h0;
import io.reactivex.Flowable;
import on4.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends com.bytedance.ee.bear.basesdk.apiimpl.a {
    public a(com.bytedance.ee.bear.basesdk.a r1) {
        super(r1);
    }

    public final void onLoginStatusChangedEvent(int r5) {
        com.bytedance.ee.bear.basesdk.a r0 = ((com.bytedance.ee.bear.basesdk.apiimpl.a) this).a;
        r0.getClass();
        tt5.a.h("DocInit", "onLoginStatusChangedEvent()... event: " + r5);
        if (w.c() == false) goto L17;
        IDocInit.LoginEvent r1 = IDocInit.LoginEvent.Logout;
        if (r5 != r1.ordinal()) goto L9;
        ((h0) org.koin.java.a.a(h0.class)).e5().subscribe(new on4.b(r0), new on4.f());
    L9:
        if (r5 != IDocInit.LoginEvent.BeforeLogout.ordinal()) goto L11;
    L14:
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().x();
    L15:
        Flowable.just("").subscribeOn(fo5.d.b()).map(new on4.g()).doOnNext(new on4.h(r5)).subscribe(new on4.i(), new j());
        return;
    L11:
        if (r5 == IDocInit.LoginEvent.SwitchTenantStart.ordinal()) goto L14;
        if (r5 != r1.ordinal()) goto L15;
    }
}
