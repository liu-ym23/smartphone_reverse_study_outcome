package m35;

import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import com.bytedance.ee.util.ui.m;
import com.ss.android.lark.chameleon.AbsChameleonService;
import f25.c;
import f25.f;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends AbsChameleonService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f511714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f511715b;

    public a(String r100) {
        this.f511715b = r100;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        tt5.a.h("FetchWebService", "==openDocs==fetch== FetchWebService onAttachToWeb");
        f r101 = new f(getContext());
        this.f511714a = r101;
        r101.f475157h = this.f511715b;
        tt5.a.h(r101.f475150a, "==openDocs==fetch== mFetchCheckKey is " + r101.f475157h);
        bindBridgeHandlerAutoUnbind(JsBridgeConstants.BIZ_UTIL_FETCH, this.f511714a);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a, vv4.m
    public final void onDetachFromWeb(k r100) {
        tt5.a.h("FetchWebService", "==openDocs==fetch== FetchWebService onDetachFromWeb");
        f r101 = this.f511714a;
        if (r101 == null) goto L9;
        tt5.a.h(r101.f475150a, "==openDocs==fetch== destroy: ");
        if (r101.f475156g == null) goto L9;
        if (r101.f475158i == null) goto L9;
        m.a(new c(r101));
    L9:
        super.onDetachFromWeb(r100);
    }

    @Override // vv4.a, vv4.m
    public final void onUserVisibleChanged(k r100, boolean r101) {
        super.onUserVisibleChanged(r100, r101);
        if (r101 == true) goto L6;
        this.f511714a.a();
        return;
    }
}
