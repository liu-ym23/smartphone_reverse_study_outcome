package com.ss.android.lark.chat.chatwindow.chat.scroll;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;

/* JADX INFO: loaded from: classes35.dex */
public class GravitySmoothScroller extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f413517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f413518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f413519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f413520d;

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int getVerticalSnapPreference() {
        int r100 = this.f413518b;
        if (r100 != 48) goto L7;
        return -1;
    L7:
        if (r100 != 80) goto L10;
        return 1;
    L10:
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics r100) {
        int r101 = this.f413520d;
        if (r101 == (-1)) goto L9;
        if (r101 <= 0) goto L9;
        return 1.0f / r101;
    L9:
        return super.calculateSpeedPerPixel(r100);
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateTimeForScrolling(int r100) {
        if (this.f413519c == false) goto L5;
        int r101 = 1;
    L7:
        return super.calculateTimeForScrolling(r101);
    L5:
        r101 = Math.max(500, Math.min(r100, 1500));
        goto L7
    }

    public GravitySmoothScroller(Context r100, int r101) {
        super(r100);
        this.f413520d = -1;
        this.f413517a = r101;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
        int r105 = this.f413518b;
        if (r105 == 48) goto L16;
        if (r105 != 17) goto L10;
        if (Math.abs(r101 - r100) > Math.abs(r103 - r102)) goto L16;
    L10:
        if (this.f413518b != 80) goto L14;
        return r103 - r101;
    L14:
        return (r102 + ((r103 - r102) / 2)) - (r100 + ((r101 - r100) / 2));
    L16:
        return (r102 - r100) + this.f413517a;
    }
}
