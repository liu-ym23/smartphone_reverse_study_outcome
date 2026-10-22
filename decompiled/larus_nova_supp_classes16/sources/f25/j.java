package f25;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j extends vv4.a {
    public f a;

    public j() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(vv4.k r2) {
        super.onAttachToWeb(r2);
        f r3 = new f(getContext());
        this.a = r3;
        bindBridgeHandlerAutoUnbind("biz.util.fetch", r3);
    }

    @Override // vv4.a, vv4.m
    public final void onDetachFromWeb(vv4.k r4) {
        f r0 = this.a;
        if (r0 == null) goto L9;
        tt5.a.h(r0.a, "==openDocs==fetch== destroy: ");
        if (r0.g == null) goto L9;
        if (r0.i == null) goto L9;
        com.bytedance.ee.util.ui.m.a(new c(r0));
    L9:
        super.onDetachFromWeb(r4);
    }

    @Override // vv4.a, vv4.m
    public final void onUserVisibleChanged(vv4.k r1, boolean r2) {
        super.onUserVisibleChanged(r1, r2);
        if (r2 == true) goto L6;
        this.a.a();
        return;
    }
}
