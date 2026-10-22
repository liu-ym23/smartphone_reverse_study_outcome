package com.bytedance.dux.picker;

import android.content.Context;
import android.view.VelocityTracker;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends OverScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f205424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f205425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f205426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f205427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VelocityTracker f205428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.dux.picker.a f205429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f205430g;

    public static final class a {
    }

    static {
    }

    public final int b() {
        int r100 = this.f205424a.getItemHeightPx();
        int r101 = this.f205424a.getItemSize();
        if (r101 != 0) goto L6;
        return -1;
    L6:
        int r102 = this.f205425b;
        if (r102 >= 0) goto L9;
        int r103 = (r102 - (r100 / 2)) / r100;
    L10:
        int r104 = r103 % r101;
        if (this.f205424a.f205419p == true) goto L14;
        if (r103 < r101) goto L14;
        r104 = r101 - 1;
    L14:
        if (r104 < 0) goto L16;
        return r104;
    L16:
        return r104 + r101;
    L9:
        r103 = (r102 + (r100 / 2)) / r100;
        goto L10
    }

    public final void c() {
        int r100 = this.f205424a.getItemHeightPx();
        int r101 = this.f205425b % r100;
        if (r101 != 0) goto L8;
        com.bytedance.dux.picker.a r102 = this.f205429f;
        if (r102 == null) goto L8;
        r102.a(this.f205430g);
    L8:
        if (r101 <= 0) goto L13;
        if (r101 >= (r100 / 2)) goto L13;
        this.f205427d = true;
        startScroll(0, this.f205425b, 0, -r101, 200);
        this.f205424a.invalidate();
        return;
    L13:
        if (r101 < (r100 / 2)) goto L15;
        this.f205427d = true;
        startScroll(0, this.f205425b, 0, r100 - r101, 200);
        this.f205424a.invalidate();
        return;
    L15:
        if (r101 < 0) goto L17;
    L19:
        int r103 = -r100;
        if (r101 > (r103 / 2)) goto L26;
        this.f205427d = true;
        startScroll(0, this.f205425b, 0, r103 - r101, 200);
        this.f205424a.invalidate();
        return;
    L26:
        return;
    L17:
        if (r101 <= ((-r100) / 2)) goto L19;
        this.f205427d = true;
        startScroll(0, this.f205425b, 0, -r101, 200);
        this.f205424a.invalidate();
    }

    public final void a(int r100) {
        this.f205425b += r100;
        WheelView r101 = this.f205424a;
        if (r101.f205419p == true) goto L10;
        int r102 = (r101.getItemSize() - 1) * this.f205424a.getItemHeightPx();
        int r103 = (int) (((double) this.f205424a.getItemHeightPx()) * 0.4d);
        int r104 = this.f205425b;
        int r105 = -r103;
        if (r104 >= r105) goto L7;
        this.f205425b = r105;
        goto L10
    L7:
        int r106 = r102 + r103;
        if (r104 <= r106) goto L10;
        this.f205425b = r106;
    L10:
        int r107 = this.f205430g;
        int r108 = b();
        if (r107 == r108) goto L16;
        this.f205430g = r108;
        this.f205424a.performHapticFeedback(1, 2);
        com.bytedance.dux.picker.a r109 = this.f205429f;
        if (r109 == null) goto L17;
        r109.onChanged();
        return;
    L17:
        return;
    }

    public b(Context r100, WheelView r101) {
        Intrinsics.checkNotNullParameter(r101, "mWheelView");
        super(r100, new LinearInterpolator());
        this.f205424a = r101;
        this.f205430g = -1;
    }

    public final void d(int r100, boolean r101) {
        int r102 = r100 * this.f205424a.getItemHeightPx();
        int r103 = this.f205425b;
        int r104 = r102 - r103;
        if (r104 != 0) goto L5;
        return;
    L5:
        if (r101 == false) goto L7;
        this.f205427d = true;
        startScroll(0, r103, 0, r104, 200);
        this.f205424a.invalidate();
        return;
    L7:
        a(r104);
        this.f205424a.invalidate();
    }
}
