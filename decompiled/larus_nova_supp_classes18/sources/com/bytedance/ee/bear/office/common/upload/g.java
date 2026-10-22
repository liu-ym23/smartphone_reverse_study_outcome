package com.bytedance.ee.bear.office.common.upload;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g {
    public final View a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public int g;

    public final void a(int r5) {
        if (this.g != r5) goto L5;
        return;
    L5:
        this.g = r5;
        this.a.setPadding(this.c, this.d + r5, this.e, this.f);
    }

    public g(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "contentTarget");
        this.a = r2;
        this.b = r3;
        this.c = r2.getPaddingLeft();
        this.d = r2.getPaddingTop();
        this.e = r2.getPaddingRight();
        this.f = r2.getPaddingBottom();
    }
}
