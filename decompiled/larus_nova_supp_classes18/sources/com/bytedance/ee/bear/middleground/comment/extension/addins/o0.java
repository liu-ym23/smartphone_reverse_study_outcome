package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBottomPopupData;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o0 implements com.bytedance.ee.bear.lark.dependency.c0.a {
    public final /* synthetic */ l0 a;
    public final /* synthetic */ CommentBottomPopupData b;
    public final /* synthetic */ l0.b c;
    public final /* synthetic */ ef5.h0 d;

    public final void onCancel() {
        bf5.b r0 = this.d.b;
        if (r0 == null) goto L6;
        r0.onCancel();
        return;
    }

    public final void onConfirm() {
        SharePermissionViewModel r0 = this.a.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sharePermissionViewModel");
        r0 = null;
    L5:
        String r1 = this.b.getUserId();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        l0.b r2 = this.c;
        ef5.h0 r3 = this.d;
        r2.getClass();
        r0.k(r1, true, new n0(r2.a, r3));
    }

    public o0(l0 r1, CommentBottomPopupData r2, l0.b r3, ef5.h0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
