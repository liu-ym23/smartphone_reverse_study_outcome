package com.bytedance.android.shopping.orderlist.common.widgets.bubble;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public BubbleOrientation a;
    public final Rect b;
    public final Point c;
    public final Context d;
    public final View e;
    public final View f;
    public final BubbleOrientation g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final View n;

    public final Point a() {
        int[] r1 = new int[2];
        this.f.getLocationInWindow(r1);
        return new Point(r1[0] + (this.f.getWidth() / 2), (r1[1] + this.f.getHeight()) - this.m);
    }

    public final Point b() {
        int[] r1 = new int[2];
        this.f.getLocationInWindow(r1);
        return new Point(r1[0] + (this.f.getWidth() / 2), r1[1] - this.m);
    }

    public final Context getContext() {
        return this.d;
    }

    public b(Context r6, View r7, View r8, BubbleOrientation r9, int r10, int r11, int r12, View r13, int r14) {
        if ((r14 & 64) == 0) goto L5;
        r12 = com.bytedance.android.shopping.extensions.b.b(8);
    L5:
        int r2 = 0;
        if ((r14 & 128) == 0) goto L8;
        int r0 = com.bytedance.android.shopping.extensions.b.b(12);
    L10:
        if ((r14 & 256) == 0) goto L12;
        int r3 = com.bytedance.android.shopping.extensions.b.b(8);
    L14:
        if ((r14 & 512) == 0) goto L17;
        r2 = com.bytedance.android.shopping.extensions.b.b(8);
    L17:
        if ((r14 & 1024) == 0) goto L19;
        r13 = null;
    L19:
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "contentView");
        Intrinsics.checkNotNullParameter(r8, "anchorView");
        Intrinsics.checkNotNullParameter(r9, "defaultOrientation");
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r0;
        this.l = r3;
        this.m = r2;
        this.n = r13;
        this.a = r9;
        this.b = new Rect();
        this.c = new Point();
        return;
    L12:
        r3 = 0;
        goto L14
    L8:
        r0 = 0;
        goto L10
    }
}
