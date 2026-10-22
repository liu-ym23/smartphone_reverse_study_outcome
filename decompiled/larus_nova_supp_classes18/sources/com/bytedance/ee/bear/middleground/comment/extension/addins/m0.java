package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m0 implements uv4.c.a {
    public final /* synthetic */ l0 a;
    public final /* synthetic */ l0.b b;
    public final /* synthetic */ ef5.h0 c;

    public final void onCancel() {
        tt5.a.h("Comment#SharePermissionAddin", "SharePermissionShowDialog onCancel():");
        this.c.b.onCancel();
    }

    public final void onClickClose() {
        tt5.a.h("Comment#SharePermissionAddin", "SharePermissionShowDialog onClickClose():");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
        jg5.k.a.a.a();
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        tt5.a.h("Comment#SharePermissionAddin", "SharePermissionShowDialog onClickUser(): uid = ".concat(r3));
        cf5.a r0 = this.a.b();
        if (r0 == null) goto L5;
        gf5.a r1 = r0.a();
    L6:
        if (r1 == null) goto L9;
        r1.e().s0().invoke(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void a(String r6, boolean r7) {
        tt5.a.h("Comment#SharePermissionAddin", "SharePermissionShowDialog onConfirm(): sendToLark = " + r7);
        if (r6 == null) goto L8;
        l0.b r1 = this.b;
        ef5.h0 r2 = this.c;
        l0 r3 = this.a;
        r1.getClass();
        n0 r4 = new n0(r1.a, r2);
        SharePermissionViewModel r5 = r3.c;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("sharePermissionViewModel");
        r5 = null;
    L7:
        r5.k(r6, r7, r4);
    L8:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
        jg5.k.a.a.b(r7);
        uv4.c r8 = this.a.b;
        if (r8 == null) goto L12;
        r8.a();
        return;
    }

    public m0(l0 r1, l0.b r2, ef5.h0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
