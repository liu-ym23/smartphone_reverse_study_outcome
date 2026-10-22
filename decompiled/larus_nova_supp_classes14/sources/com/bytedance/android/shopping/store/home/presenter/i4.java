package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i4 {
    public int[] a;
    public int[] b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final View k;
    public final View l;

    public final void a() {
        this.a = wg.a.c(this.k);
        this.b = wg.a.c(this.l);
        this.c = this.k.getWidth();
        this.d = this.k.getHeight();
        this.e = this.l.getWidth();
        this.f = this.l.getHeight();
        int[] r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("originLocationInScreen");
    L5:
        this.g = r0[0] + (this.c / 2);
        int[] r1 = this.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("originLocationInScreen");
    L8:
        this.h = r1[1] - (this.d / 2);
        int[] r2 = this.b;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("targetLocationInScreen");
    L11:
        this.i = r2[0] + (this.e / 2);
        int[] r3 = this.b;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("targetLocationInScreen");
    L14:
        this.j = r3[1] - (this.f / 2);
        AppCompatTextView r4 = this.k;
        if ((r4 instanceof AppCompatTextView) == false) goto L17;
        r4.getTextSize();
    L17:
        AppCompatTextView r5 = this.l;
        if ((r5 instanceof AppCompatTextView) == false) goto L21;
        r5.getTextSize();
        return;
    }

    public i4(View r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "originView");
        Intrinsics.checkNotNullParameter(r3, "targetView");
        this.k = r2;
        this.l = r3;
        a();
    }
}
