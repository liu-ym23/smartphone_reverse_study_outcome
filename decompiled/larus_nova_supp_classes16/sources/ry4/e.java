package ry4;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNDestroyData;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamInvoke;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamSendEvent;
import com.bytedance.ee.bear.rn.j;
import com.bytedance.ee.util.io.NonProguard;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends com.bytedance.ee.bear.doc.follow.impl.d {
    public static boolean c;
    public static final py4.e d = null;
    public final b b;

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final String m() {
        return "CCMFollow_RNAdapter";
    }

    @Override // py4.b
    public final void onCallVCFollow(String r1, NonProguard r2, a r3) {
    }

    static {
        d = new py4.e();
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void k() {
        if (c == true) goto L6;
        ((j) org.koin.java.a.a(j.class)).i(this.b);
        c = true;
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [ry4.b] */
    public e() {
        this.b = new b(this);
    }

    @Override // py4.j
    public final py4.e c() {
        return d;
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void n(RNDestroyData r2) {
        onCallVCFollow("vcfollow.destroy", r2);
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void o(RNParamInvoke r2) {
        onCallVCFollow("vcfollow.invoke", r2);
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void q(RNParamSendEvent r2) {
        onCallVCFollow("vcfollow.sendEvent", r2);
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void r(RNParamRegisterEventHandler r2) {
        onCallVCFollow("vcfollow.unRegisterEventHandler", r2);
    }

    @Override // py4.b
    public final void onCallVCFollow(final String r3, final NonProguard r4) {
        Flowable r5 = ((j) org.koin.java.a.a(j.class)).d(new c(r3, r4));
        if (r5 == null) goto L6;
        r5.subscribe();
        return;
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void p(RNParamRegisterEventHandler r1, a r2) {
        onCallVCFollow("vcfollow.registerEventHandler", r1);
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final String l(String r2, String r3, String r4) {
        int r0 = py4.e.d;
        return py4.e.a.a(r2, r3, r4);
    }
}
