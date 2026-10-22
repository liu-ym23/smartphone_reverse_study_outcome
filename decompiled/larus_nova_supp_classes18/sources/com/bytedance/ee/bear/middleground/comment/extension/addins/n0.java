package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n0 implements bf5.b {
    public final /* synthetic */ l0 a;
    public final /* synthetic */ ef5.h0 b;

    @Override // bf5.b
    public final void c() {
    }

    @Override // bf5.b
    public final void onCancel() {
        this.b.b.onCancel();
    }

    @Override // bf5.b
    public final void b(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "throwable");
        this.b.b.b(r5);
    L10:
        e = move-exception;
        Toast.showFailureText(LarkContext.getApplication(), com.bytedance.ee.util.ui.n.x(LarkContext.getApplication(), 2131887802));
        tt5.a.e("Comment#SharePermissionAddin", "onRequestFail", e, false);
        return;
    L4:
        if ((r5 instanceof NetService.ServerErrorException) == true) goto L6;
    L8:
        Toast.showFailureText(LarkContext.getApplication(), com.bytedance.ee.util.ui.n.x(LarkContext.getApplication(), 2131887802));     // Catch: Exception -> L10
    L13:
        return;
    L6:
        if (((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().h(((NetService.ServerErrorException) r5).getData()) == false) goto L8;
        Toast.showFailureText(LarkContext.getApplication(), com.bytedance.ee.util.ui.n.x(LarkContext.getApplication(), 2131888739));     // Catch: Exception -> L10
        goto L13
    }

    @Override // bf5.b
    public final void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        cf5.a r0 = this.a.b();
        if (r0 == null) goto L5;
        gf5.a r1 = r0.a();
    L6:
        if (r1 == null) goto L8;
        Toast.showSuccessText(r1.getConfig().getActivity(), com.bytedance.ee.util.ui.n.x(r1.getConfig().getActivity(), 2131887560));
    L8:
        this.b.b.d(r4);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public n0(l0 r1, ef5.h0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
