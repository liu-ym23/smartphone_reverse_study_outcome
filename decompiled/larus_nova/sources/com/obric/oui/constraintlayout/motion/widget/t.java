package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes34.dex */
public final class t {
    public static final float[][] E = null;
    public static final float[][] F = null;
    public float A;
    public float B;
    public int C;
    public int D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f400199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f400200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f400201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f400202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f400203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f400204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f400205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f400206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f400207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f400208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f400209k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f400210l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f400211m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f400212n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int[] f400213o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f400214p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f400215q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MotionLayout f400216r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f400217s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f400218t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f400219u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f400220v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f400221w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f400222x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f400223y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f400224z;

    static {
        E = new float[][]{new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        F = new float[][]{new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    }

    public final String toString() {
        if (Float.isNaN(this.f400209k) == false) goto L6;
        return "rotation";
    L6:
        return this.f400209k + " , " + this.f400210l;
    }

    public final void c(boolean r100) {
        float[][] r101 = E;
        float[][] r102 = F;
        if (r100 == false) goto L5;
        r102[4] = r102[3];
        r102[5] = r102[2];
        r101[5] = r101[2];
        r101[6] = r101[1];
    L6:
        float[] r103 = r101[this.f400199a];
        this.f400206h = r103[0];
        this.f400205g = r103[1];
        int r104 = this.f400200b;
        if (r104 < 6) goto L9;
        return;
    L9:
        float[] r105 = r102[r104];
        this.f400209k = r105[0];
        this.f400210l = r105[1];
        return;
    L5:
        r102[4] = r102[2];
        r102[5] = r102[3];
        r101[5] = r101[1];
        r101[6] = r101[2];
        goto L6
    }

    public final RectF a(MotionLayout r100, RectF r101) {
        int r102 = this.f400204f;
        if (r102 != (-1)) goto L5;
        return null;
    L5:
        View r103 = r100.findViewById(r102);
        if (r103 != null) goto L8;
        return null;
    L8:
        r101.set(r103.getLeft(), r103.getTop(), r103.getRight(), r103.getBottom());
        return r101;
    }

    public final RectF b(ViewGroup r100, RectF r101) {
        int r102 = this.f400203e;
        if (r102 != (-1)) goto L5;
        return null;
    L5:
        View r103 = r100.findViewById(r102);
        if (r103 != null) goto L8;
        return null;
    L8:
        r101.set(r103.getLeft(), r103.getTop(), r103.getRight(), r103.getBottom());
        return r101;
    }

    public t(Context r100, MotionLayout r101, XmlPullParser r110) {
        this.f400199a = 0;
        this.f400200b = 0;
        this.f400201c = 0;
        this.f400202d = -1;
        this.f400203e = -1;
        this.f400204f = -1;
        this.f400205g = 0.5f;
        this.f400206h = 0.5f;
        this.f400207i = -1;
        this.f400208j = false;
        this.f400209k = 0.0f;
        this.f400210l = 1.0f;
        this.f400211m = false;
        this.f400212n = new float[2];
        this.f400213o = new int[2];
        this.f400217s = 4.0f;
        this.f400218t = 1.2f;
        this.f400219u = true;
        this.f400220v = 1.0f;
        this.f400221w = 0;
        this.f400222x = 10.0f;
        this.f400223y = 10.0f;
        this.f400224z = 1.0f;
        this.A = Float.NaN;
        this.B = Float.NaN;
        this.C = 0;
        this.D = 0;
        this.f400216r = r101;
        TypedArray r102 = r100.obtainStyledAttributes(Xml.asAttributeSet(r110), new int[]{R.attr.autoCompleteMode, R.attr.dragDirection, R.attr.dragScale, R.attr.dragThreshold, R.attr.limitBoundsTo, R.attr.maxAcceleration, R.attr.maxVelocity, R.attr.moveWhenScrollAtTop, R.attr.nestedScrollFlags, R.attr.onTouchUp, R.attr.rotationCenterId, R.attr.springBoundary, R.attr.springDamping, R.attr.springMass, R.attr.springStiffness, R.attr.springStopThreshold, R.attr.touchAnchorId, R.attr.touchAnchorSide, R.attr.touchRegionId});
        int r103 = r102.getIndexCount();
        int r111 = 0;
    L3:
        if (r111 >= r103) goto L62;
        int r104 = r102.getIndex(r111);
        if (r104 != 16) goto L8;
        this.f400202d = r102.getResourceId(r104, this.f400202d);
    L61:
        r111 = r111 + 1;
        goto L3
    L8:
        if (r104 != 17) goto L11;
        int r105 = r102.getInt(r104, this.f400199a);
        this.f400199a = r105;
        float[] r106 = E[r105];
        this.f400206h = r106[0];
        this.f400205g = r106[1];
        goto L61
    L11:
        if (r104 != 1) goto L16;
        int r107 = r102.getInt(r104, this.f400200b);
        this.f400200b = r107;
        if (r107 >= 6) goto L15;
        float[] r108 = F[r107];
        this.f400209k = r108[0];
        this.f400210l = r108[1];
        goto L61
    L15:
        this.f400210l = Float.NaN;
        this.f400209k = Float.NaN;
        this.f400208j = true;
        goto L61
    L16:
        if (r104 != 6) goto L19;
        this.f400217s = r102.getFloat(r104, this.f400217s);
        goto L61
    L19:
        if (r104 != 5) goto L22;
        this.f400218t = r102.getFloat(r104, this.f400218t);
        goto L61
    L22:
        if (r104 != 7) goto L24;
        this.f400219u = r102.getBoolean(r104, this.f400219u);
        goto L61
    L24:
        if (r104 != 2) goto L27;
        this.f400220v = r102.getFloat(r104, this.f400220v);
        goto L61
    L27:
        if (r104 != 3) goto L30;
        this.f400222x = r102.getFloat(r104, this.f400222x);
        goto L61
    L30:
        if (r104 != 18) goto L33;
        this.f400203e = r102.getResourceId(r104, this.f400203e);
        goto L61
    L33:
        if (r104 != 9) goto L36;
        this.f400201c = r102.getInt(r104, this.f400201c);
        goto L61
    L36:
        if (r104 != 8) goto L39;
        this.f400221w = r102.getInteger(r104, 0);
        goto L61
    L39:
        if (r104 != 4) goto L42;
        this.f400204f = r102.getResourceId(r104, 0);
        goto L61
    L42:
        if (r104 != 10) goto L45;
        this.f400207i = r102.getResourceId(r104, this.f400207i);
        goto L61
    L45:
        if (r104 != 12) goto L48;
        this.f400223y = r102.getFloat(r104, this.f400223y);
        goto L61
    L48:
        if (r104 != 13) goto L51;
        this.f400224z = r102.getFloat(r104, this.f400224z);
        goto L61
    L51:
        if (r104 != 14) goto L54;
        this.A = r102.getFloat(r104, this.A);
        goto L61
    L54:
        if (r104 != 15) goto L57;
        this.B = r102.getFloat(r104, this.B);
        goto L61
    L57:
        if (r104 != 11) goto L59;
        this.C = r102.getInt(r104, this.C);
        goto L61
    L59:
        if (r104 != 0) goto L61;
        this.D = r102.getInt(r104, this.D);
        goto L61
    L62:
        r102.recycle();
    }
}
