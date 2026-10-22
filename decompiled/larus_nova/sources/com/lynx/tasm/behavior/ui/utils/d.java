package com.lynx.tasm.behavior.ui.utils;

import a7a.k;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.LynxContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public abstract class d<T extends a7a.k> extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f383133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f383134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f383135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f383136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final T f383137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LynxContext f383138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f383139g;

    public abstract T a();

    public final RectF b() {
        float r100 = this.f383133a.a(1);
        float r101 = this.f383133a.a(3);
        float r102 = this.f383133a.a(0);
        float r103 = this.f383133a.a(2);
        Rect r104 = getBounds();
        float r105 = r102 + r103;
        if (r105 > r104.width()) goto L5;
    L7:
        float r106 = r100 + r101;
        if (r106 <= r104.height()) goto L13;
        if (r104.height() < 1) goto L13;
        float r107 = r104.height() / r106;
        r100 = r100 * r107;
        r101 = r101 * r107;
    L13:
        return new RectF(r102, r100, r103, r101);
    L5:
        if (r104.width() < 1) goto L7;
        float r108 = r104.width() / r105;
        r102 = r102 * r108;
        r103 = r103 * r108;
        goto L7
    }

    public final void e() {
        Rect r100 = getBounds();
        this.f383135c.set(r100.left, r100.top, r100.right, r100.bottom);
        RectF r101 = b();
        Rect r102 = this.f383135c;
        int r103 = (int) (r102.left + r101.left);
        r102.left = r103;
        int r104 = (int) (r102.top + r101.top);
        r102.top = r104;
        int r105 = (int) (r102.right - r101.right);
        r102.right = r105;
        int r106 = (int) (r102.bottom - r101.bottom);
        r102.bottom = r106;
        this.f383136d.set(r103, r104, r105, r106);
        Rect r107 = this.f383136d;
        float r108 = r107.top;
        float[] r109 = this.f383134b;
        r107.top = (int) (r108 + r109[0]);
        r107.right = (int) (r107.right - r109[1]);
        r107.bottom = (int) (r107.bottom - r109[2]);
        r107.left = (int) (r107.left + r109[3]);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        Iterator r101 = ((ArrayList) this.f383137e.f2094a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a7a.d) r101.next()).g(r100.width(), r100.height());
        goto L4
    L6:
        e();
    }

    public d(LynxContext r100, float r101) {
        this.f383135c = new Rect();
        this.f383136d = new Rect();
        this.f383137e = null;
        this.f383138f = r100;
        this.f383139g = r101;
        this.f383137e = (T) a();
        float[] r102 = new float[4];
        this.f383134b = r102;
        Arrays.fill(r102, 0.0f);
        if (r100.getCssAlignWithLegacyW3c() == false) goto L5;
        this.f383133a = new k(3.0f);
        return;
    L5:
        this.f383133a = new k();
    }

    public boolean c(int r100, float r101) {
        return this.f383133a.b(r100, r101);
    }

    public boolean d(float r100, float r101, float r102, float r103) {
        boolean r104 = false;
        if (com.lynx.tasm.utils.b.a(this.f383134b[0], r100) == true) goto L6;
        this.f383134b[0] = r100;
        r104 = true;
    L6:
        if (com.lynx.tasm.utils.b.a(this.f383134b[1], r101) == true) goto L9;
        this.f383134b[1] = r101;
        r104 = true;
    L9:
        if (com.lynx.tasm.utils.b.a(this.f383134b[2], r102) == true) goto L12;
        this.f383134b[2] = r102;
        r104 = true;
    L12:
        if (com.lynx.tasm.utils.b.a(this.f383134b[3], r103) == true) goto L15;
        this.f383134b[3] = r103;
        return true;
    L15:
        return r104;
    }
}
