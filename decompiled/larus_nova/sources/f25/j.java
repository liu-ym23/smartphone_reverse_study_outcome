package f25;

import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;

/* JADX INFO: loaded from: classes16.dex */
public final class j extends vv4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f475171a;

    public j() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(vv4.k r100) {
        super.onAttachToWeb(r100);
        f r101 = new f(getContext());
        this.f475171a = r101;
        bindBridgeHandlerAutoUnbind(JsBridgeConstants.BIZ_UTIL_FETCH, r101);
    }

    @Override // vv4.a, vv4.m
    public final void onDetachFromWeb(vv4.k r100) {
        f r101 = this.f475171a;
        if (r101 == null) goto L9;
        tt5.a.h(r101.f475150a, "==openDocs==fetch== destroy: ");
        if (r101.f475156g == null) goto L9;
        if (r101.f475158i == null) goto L9;
        com.bytedance.ee.util.ui.m.a(new c(r101));
    L9:
        super.onDetachFromWeb(r100);
    }

    @Override // vv4.a, vv4.m
    public final void onUserVisibleChanged(vv4.k r100, boolean r101) {
        super.onUserVisibleChanged(r100, r101);
        if (r101 == true) goto L6;
        this.f475171a.a();
        return;
    }
}
