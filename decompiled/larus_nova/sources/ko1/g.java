package ko1;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import jc1.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f504402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f504403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f504404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f504405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f504406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f504407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f504408g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f504409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f504410i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f504411j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f504412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f504413l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f504414m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f504415n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f504416o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f504417p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f504418q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f504419r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f504420s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f504421t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ViewGroup f504422u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.android.live.platformplayer.layout.c f504423v;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return true;
    }

    public final void a(float r100) {
        this.f504421t.setTranslationX(r100);
        com.bytedance.android.live.platformplayer.layout.c r101 = this.f504423v;
        if (r101 == null) goto L6;
        r101.setTranslationX(r100);
        return;
    }

    public final void b(float r100) {
        this.f504421t.setTranslationY(r100);
        com.bytedance.android.live.platformplayer.layout.c r101 = this.f504423v;
        if (r101 == null) goto L6;
        r101.setTranslationY(r100);
        return;
    }

    public final void c(float r100) {
        float r101 = 0;
        if (r100 >= r101) goto L7;
        if (Math.abs(this.f504403b + r100) >= this.f504414m) goto L7;
    L10:
        float r102 = this.f504403b + r100;
        this.f504403b = r102;
        a(r102);
        return;
    L7:
        if (r100 > r101) goto L9;
    L11:
        if (r100 >= r101) goto L15;
        float r103 = Math.abs(this.f504403b + r100);
        float r104 = this.f504414m;
        if (r103 <= r104) goto L15;
        this.f504403b = -r104;
        a(-r104);
        return;
    L15:
        if (r100 <= r101) goto L22;
        float r105 = this.f504403b + r100;
        float r106 = this.f504416o;
        if (r105 <= r106) goto L23;
        this.f504403b = r106;
        a(r106);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        if ((this.f504403b + r100) >= this.f504416o) goto L11;
        goto L10
    }

    public final void d(float r100) {
        float r101 = 0;
        if (r100 >= r101) goto L7;
        if (Math.abs(this.f504404c + r100) >= this.f504415n) goto L7;
    L10:
        float r102 = this.f504404c + r100;
        this.f504404c = r102;
        b(r102);
        return;
    L7:
        if (r100 > r101) goto L9;
    L11:
        if (r100 >= r101) goto L15;
        float r103 = Math.abs(this.f504404c + r100);
        float r104 = this.f504415n;
        if (r103 <= r104) goto L15;
        this.f504404c = -r104;
        b(-r104);
        return;
    L15:
        if (r100 <= r101) goto L22;
        float r105 = this.f504404c + r100;
        float r106 = this.f504417p;
        if (r105 <= r106) goto L23;
        this.f504404c = r106;
        b(r106);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        if ((this.f504404c + r100) >= this.f504417p) goto L11;
        goto L10
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if (this.f504409h == true) goto L5;
        this.f504409h = true;
        this.f504414m = this.f504421t.getLeft();
        this.f504415n = this.f504421t.getTop();
        this.f504416o = this.f504422u.getWidth() - this.f504421t.getRight();
        this.f504417p = this.f504422u.getHeight() - this.f504421t.getBottom();
        this.f504410i = this.f504421t.getWidth();
        int r101 = this.f504421t.getHeight();
        this.f504411j = r101;
        int r102 = this.f504410i;
        this.f504407f = r102;
        this.f504408g = r101;
        this.f504405d = r102;
        this.f504406e = r101;
        this.f504412k = this.f504422u.getWidth();
        this.f504413l = this.f504422u.getHeight();
    L5:
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        float r101 = 0.0f;
        if (this.f504405d <= this.f504412k) goto L5;
        float r102 = 0.0f;
    L7:
        if (this.f504406e > this.f504413l) goto L10;
        r101 = this.f504421t.getTop() - ((this.f504406e - this.f504411j) / 2);
    L10:
        float r103 = this.f504405d;
        int r104 = this.f504412k;
        if (r103 <= r104) goto L13;
        float r105 = r104;
    L14:
        float r106 = this.f504406e;
        int r107 = this.f504413l;
        if (r106 <= r107) goto L17;
        float r108 = r107;
    L19:
        if (new RectF(r102, r101, r105, r108).contains(r100.getX(), r100.getY()) == false) goto L22;
        this.f504421t.performClick();
    L22:
        return super.onSingleTapUp(r100);
    L17:
        r108 = this.f504422u.getHeight() - ((this.f504422u.getHeight() - this.f504421t.getBottom()) - ((this.f504406e - this.f504411j) / 2));
        goto L19
    L13:
        r105 = this.f504422u.getWidth() - ((this.f504422u.getWidth() - this.f504421t.getRight()) - ((this.f504405d - this.f504410i) / 2));
        goto L14
    L5:
        r102 = this.f504421t.getLeft() - ((this.f504405d - this.f504410i) / 2);
        goto L7
    }

    public g(View r100, ViewGroup r101, com.bytedance.android.live.platformplayer.layout.c r102) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "viewGroup");
        this.f504421t = r100;
        this.f504422u = r101;
        this.f504423v = r102;
        this.f504402a = 1.0f;
        this.f504419r = 1.0f;
        this.f504420s = 1.0f;
    }

    @Override // jc1.l, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        float r104 = -r102;
        float r105 = -r103;
        if (this.f504418q == true) goto L9;
        if (this.f504402a > 1) goto L9;
        c(r104);
        d(r105);
    L15:
        return super.onScroll(r100, r101, r104, r105);
    L9:
        if (this.f504405d <= this.f504412k) goto L12;
        c(r104);
    L12:
        if (this.f504406e <= this.f504413l) goto L15;
        d(r105);
        goto L15
    }
}
