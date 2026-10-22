package m35;

import com.bytedance.ee.util.ui.m;
import com.ss.android.lark.chameleon.AbsChameleonService;
import f25.c;
import f25.f;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends AbsChameleonService {
    public f a;
    public final String b;

    public a(String r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachToWeb(k r4) {
        super.onAttachToWeb(r4);
        tt5.a.h("FetchWebService", "==openDocs==fetch== FetchWebService onAttachToWeb");
        f r5 = new f(getContext());
        this.a = r5;
        r5.h = this.b;
        tt5.a.h(r5.a, "==openDocs==fetch== mFetchCheckKey is " + r5.h);
        bindBridgeHandlerAutoUnbind("biz.util.fetch", this.a);
    }

    public final void onDetachFromWeb(k r4) {
        tt5.a.h("FetchWebService", "==openDocs==fetch== FetchWebService onDetachFromWeb");
        f r0 = this.a;
        if (r0 == null) goto L9;
        tt5.a.h(r0.a, "==openDocs==fetch== destroy: ");
        if (r0.g == null) goto L9;
        if (r0.i == null) goto L9;
        m.a(new c(r0));
    L9:
        super.onDetachFromWeb(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onUserVisibleChanged(k r1, boolean r2) {
        super/*vv4.a*/.onUserVisibleChanged(r1, r2);
        if (r2 == true) goto L6;
        this.a.a();
        return;
    }
}
