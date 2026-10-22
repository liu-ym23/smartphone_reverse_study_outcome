package x6a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.PropBundle;

/* JADX INFO: loaded from: classes32.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f562740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Point f562741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f562742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PlatformRendererContext f562743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f562744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f562745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f562746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LynxBaseUI f562747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f562748i;

    public void f() {
    }

    public void j(PropBundle r100) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        if (this.f562746g != null) goto L5;
        return;
    L5:
        LynxBaseUI r100 = this.f562747h;
        if (r100 != null) goto L8;
    L10:
        View r101 = this.f562746g.getView();
        if ((r101 instanceof ViewGroup) == true) goto L13;
        return;
    L13:
        ViewGroup r102 = (ViewGroup) r101;
        int r103 = 0;
    L15:
        if (r103 >= r102.getChildCount()) goto L23;
        View r104 = r102.getChildAt(r103);
        if ((r104 instanceof e) == false) goto L22;
        i r105 = ((e) r104).getRenderer();
        if (r105 == null) goto L22;
        Rect r106 = r105.f562740a;
        r104.layout(r106.left, r106.top, r106.right, r106.bottom);
    L22:
        r103 = r103 + 1;
        goto L15
    L23:
        return;
    L8:
        if (r100.isFlatten() == false) goto L10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i() {
        if (this.f562746g != null) goto L5;
        return;
    L5:
        LynxBaseUI r100 = this.f562747h;
        if (r100 != null) goto L8;
    L10:
        View r101 = this.f562746g.getView();
        if ((r101 instanceof ViewGroup) == true) goto L13;
        return;
    L13:
        ViewGroup r102 = (ViewGroup) r101;
        int r103 = 0;
    L15:
        if (r103 >= r102.getChildCount()) goto L23;
        View r104 = r102.getChildAt(r103);
        if ((r104 instanceof e) == false) goto L22;
        i r105 = ((e) r104).getRenderer();
        if (r105 == null) goto L22;
        Rect r106 = r105.f562740a;
        r104.measure(View.MeasureSpec.makeMeasureSpec(r106.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(r106.height(), 1073741824));
    L22:
        r103 = r103 + 1;
        goto L15
    L23:
        return;
    L8:
        if (r100.isFlatten() == false) goto L10;
    }

    public static Matrix d(float[] r100) {
        Matrix r101 = new Matrix();
        r101.setValues(new float[]{r100[0], r100[4], r100[12], r100[1], r100[5], r100[13], r100[3], r100[7], r100[15]});
        return r101;
    }

    public final void a(Canvas r100) {
        c r101 = this.f562744e;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.c(r100);
        c r102 = this.f562744e;
        r102.f562726q = 0;
        r102.f562727r = 0;
        r102.f562728s = 0;
        r102.f562729t = 0;
        r102.f562731v.clear();
    }

    public final void c(Canvas r100) {
        c r101 = this.f562744e;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.c(r100);
    }

    public final void e(int r100) {
        e r101 = this.f562746g;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.invalidateForRenderer();
        if ((r100 & 1) == 0) goto L13;
        if (this.f562746g.getView() == null) goto L13;
        if ((this.f562746g.getView().getParent() instanceof View) == false) goto L13;
        ((View) this.f562746g.getView().getParent()).invalidate();
    L13:
        if ((r100 & 2) == 0) goto L16;
        this.f562748i = 2;
        return;
    }

    public void g(Canvas r110) {
        if (this.f562748i != 2) goto L18;
        PlatformRendererContext r100 = this.f562743d;
        int r101 = this.f562742c;
        b r111 = this.f562745f;
        if (r111 != null) goto L7;
        r100.getClass();
        goto L18
    L7:
        if (r100.f382183h == true) goto L18;
        long r102 = r100.f382181f;
        if (r102 == 0) goto L18;
        int[] r103 = r100.nativeGetDisplayListLengths(r102, r101);
        if (r103 == null) goto L18;
        if (r103.length != 3) goto L18;
        int r104 = r103[0];
        int r105 = r103[1];
        int r106 = r103[2];
        int[] r107 = new int[r104];
        r111.f562707a = r107;
        int[] r108 = new int[r105];
        r111.f562708b = r108;
        float[] r109 = new float[r106];
        r111.f562709c = r109;
        r100.nativeGetDisplayListData(r100.f382181f, r101, r107, r108, r109);
    L18:
        c r112 = this.f562744e;
        if (r112 != null) goto L21;
        this.f562744e = new c(this.f562745f, this.f562743d, this.f562746g);
    L22:
        this.f562748i = 1;
        return;
    L21:
        b r113 = this.f562745f;
        r112.j(r113);
        r112.f562710a = r113;
        r112.f562726q = 0;
        r112.f562727r = 0;
        r112.f562728s = 0;
        r112.f562729t = 0;
        r112.f562731v.clear();
        goto L22
    }

    public i(PlatformRendererContext r100, int r101) {
        this.f562740a = new Rect();
        this.f562741b = new Point();
        this.f562744e = null;
        this.f562745f = new b();
        this.f562748i = 2;
        this.f562743d = r100;
        this.f562742c = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Canvas r100, View r101) {
        c r102 = this.f562744e;
        if (r102 != null) goto L6;
        r100.save();
        return;
    L6:
        r102.c(r100);
        r100.save();
        if ((r101 instanceof e) == false) goto L12;
        i r103 = ((e) r101).getRenderer();
        if (r103 == null) goto L13;
        Point r104 = r103.f562741b;
        r100.translate(-r104.x, -r104.y);
        return;
    L13:
        return;
    }
}
