package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends ViewOutlineProvider {
    public final /* synthetic */ Rect a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r9, Outline r10) {
        if (r10 == null) goto L5;
        Rect r11 = this.a;
        r10.setRoundRect(r11.left + this.b, r11.top + this.c, r11.right + this.d, r11.bottom + this.e, this.f);
        return;
    }

    public a(Rect r1, int r2, int r3, int r4, int r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
