package com.ss.android.lark.insets;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.Insets;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f427750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f427751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f427752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f427753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f427754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f427755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f427756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f427757h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f427758i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f427759j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f427760k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f427761l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f427762m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f427763n;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public g() {
        this.f427750a = new Paint();
        this.f427759j = true;
        this.f427760k = true;
        this.f427761l = true;
        this.f427762m = true;
        this.f427763n = new Rect();
    }

    public final void a(Insets r100) {
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.top;
    L6:
        this.f427751b = r102;
        if (r100 == null) goto L9;
        int r103 = r100.bottom;
    L10:
        this.f427752c = r103;
        if (r100 == null) goto L13;
        int r104 = r100.left;
    L14:
        this.f427753d = r104;
        if (r100 == null) goto L17;
        r101 = r100.right;
    L17:
        this.f427754e = r101;
        return;
    L13:
        r104 = 0;
        goto L14
    L9:
        r103 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Rect r101 = getBounds();
        if (this.f427751b <= 0) goto L10;
        if (this.f427755f == 0) goto L10;
        if (this.f427759j == false) goto L10;
        this.f427763n.setEmpty();
        this.f427763n.set(0, 0, r101.width(), this.f427751b);
        this.f427750a.setColor(this.f427755f);
        r100.drawRect(this.f427763n, this.f427750a);
    L10:
        if (this.f427752c <= 0) goto L22;
        if (this.f427756g == 0) goto L22;
        if (this.f427760k == false) goto L22;
        this.f427763n.setEmpty();
        this.f427763n.set(0, 0, r101.width(), this.f427752c);
        this.f427750a.setColor(this.f427756g);
        float r102 = r101.height() - this.f427752c;
        int r103 = r100.save();
        r100.translate(0.0f, r102);
        r100.drawRect(this.f427763n, this.f427750a);     // Catch: Throwable -> L18
        r100.restoreToCount(r103);
    L18:
        th = move-exception;
        r100.restoreToCount(r103);
        throw th;
    L22:
        if (this.f427753d <= 0) goto L29;
        if (this.f427757h == 0) goto L29;
        if (this.f427761l == false) goto L29;
        this.f427763n.setEmpty();
        this.f427763n.set(0, 0, this.f427753d, r101.height());
        this.f427750a.setColor(this.f427757h);
        r100.drawRect(this.f427763n, this.f427750a);
    L29:
        if (this.f427754e > 0) goto L31;
        return;
    L31:
        if (this.f427758i != 0) goto L33;
        return;
    L33:
        if (this.f427762m == false) goto L46;
        this.f427763n.setEmpty();
        this.f427763n.set(0, 0, this.f427754e, r101.height());
        this.f427750a.setColor(this.f427758i);
        float r104 = r101.width() - this.f427754e;
        int r105 = r100.save();
        r100.translate(r104, 0.0f);
        r100.drawRect(this.f427763n, this.f427750a);     // Catch: Throwable -> L37
        r100.restoreToCount(r105);
        return;
    L37:
        th = move-exception;
        r100.restoreToCount(r105);
        throw th;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f427750a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f427750a.setColorFilter(r100);
    }
}
