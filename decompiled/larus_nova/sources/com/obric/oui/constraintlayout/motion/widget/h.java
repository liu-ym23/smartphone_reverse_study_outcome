package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f400046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f400047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f400048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f400049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f400050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f400051k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f400052l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f400053m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f400054n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f400055o;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseIntArray f400056a = null;

        static {
            SparseIntArray r100 = new SparseIntArray();
            f400056a = r100;
            r100.append(4, 1);
            r100.append(2, 2);
            r100.append(11, 3);
            r100.append(0, 4);
            r100.append(1, 5);
            r100.append(8, 6);
            r100.append(9, 7);
            r100.append(3, 9);
            r100.append(10, 8);
            r100.append(7, 11);
            r100.append(6, 12);
            r100.append(5, 10);
        }
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void a(HashMap<String, vla.d> r100) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final d b() {
        h r100 = new h();
        super.c(this);
        r100.f400046f = this.f400046f;
        r100.f400047g = this.f400047g;
        r100.f400048h = this.f400048h;
        r100.f400049i = this.f400049i;
        r100.f400050j = Float.NaN;
        r100.f400051k = this.f400051k;
        r100.f400052l = this.f400052l;
        r100.f400053m = this.f400053m;
        r100.f400054n = this.f400054n;
        return r100;
    }

    public h() {
        this.f400046f = null;
        this.f400047g = -1;
        this.f400048h = 0;
        this.f400049i = Float.NaN;
        this.f400050j = Float.NaN;
        this.f400051k = Float.NaN;
        this.f400052l = Float.NaN;
        this.f400053m = Float.NaN;
        this.f400054n = Float.NaN;
        this.f400055o = 0;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void e(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.curveFit, R.attr.drawPath, R.attr.framePosition, R.attr.keyPositionType, R.attr.motionTarget, R.attr.pathMotionArc, R.attr.percentHeight, R.attr.percentWidth, R.attr.percentX, R.attr.percentY, R.attr.sizePercent, R.attr.transitionEasing});
        SparseIntArray r103 = a.f400056a;
        int r104 = r102.getIndexCount();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L31;
        int r106 = r102.getIndex(r105);
        SparseIntArray r107 = a.f400056a;
        switch(r107.get(r106)) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L6:
        Integer.toHexString(r106);
        r107.get(r106);
    L30:
        r105 = r105 + 1;
        goto L3
    L7:
        this.f400050j = r102.getFloat(r106, this.f400050j);
        goto L30
    L8:
        this.f400049i = r102.getFloat(r106, this.f400049i);
        goto L30
    L9:
        this.f400047g = r102.getInt(r106, this.f400047g);
        goto L30
    L10:
        this.f400055o = r102.getInt(r106, this.f400055o);
        goto L30
    L11:
        float r108 = r102.getFloat(r106, this.f400050j);
        this.f400049i = r108;
        this.f400050j = r108;
        goto L30
    L12:
        this.f400052l = r102.getFloat(r106, this.f400052l);
        goto L30
    L13:
        this.f400051k = r102.getFloat(r106, this.f400051k);
        goto L30
    L14:
        this.f400048h = r102.getInt(r106, this.f400048h);
        goto L30
    L15:
        this.f400057e = r102.getInteger(r106, this.f400057e);
        goto L30
    L20:
        this.f400004a = r102.getInt(r106, this.f400004a);
        goto L30
    L17:
        if (r102.peekValue(r106).type != 3) goto L19;
        this.f400046f = r102.getString(r106);
        goto L30
    L19:
        this.f400046f = tla.c.f546670c[r102.getInteger(r106, 0)];
        goto L30
    L22:
        if (MotionLayout.F2 == false) goto L27;
        int r109 = r102.getResourceId(r106, this.f400005b);
        this.f400005b = r109;
        if (r109 != (-1)) goto L30;
        this.f400006c = r102.getString(r106);
        goto L30
    L27:
        if (r102.peekValue(r106).type != 3) goto L29;
        this.f400006c = r102.getString(r106);
        goto L30
    L29:
        this.f400005b = r102.getResourceId(r106, this.f400005b);
        goto L30
    }

    public final void h(String r100, Object r101) {
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -1812823328: goto L30;
            case -1127236479: goto L26;
            case -1017587252: goto L22;
            case -827014263: goto L18;
            case -200259324: goto L14;
            case 428090547: goto L10;
            case 428090548: goto L6;
            default: goto L33;
        };
    L33:
        switch(r102) {
            case 0: goto L45;
            case 1: goto L44;
            case 2: goto L43;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L53;
        };
    L35:
        this.f400052l = d.g(r101);
        return;
    L36:
        this.f400051k = d.g(r101);
        return;
    L37:
        float r103 = d.g(r101);
        this.f400049i = r103;
        this.f400050j = r103;
        return;
    L43:
        this.f400050j = d.g(r101);
        return;
    L44:
        this.f400049i = d.g(r101);
        return;
    L45:
        this.f400046f = r101.toString();
        return;
    L53:
        return;
    L39:
        if ((r101 instanceof Integer) == false) goto L41;
        int r104 = ((Integer) r101).intValue();
    L42:
        this.f400048h = r104;
        return;
    L41:
        r104 = CastIntegerProtector.parseInt(r101.toString());
        goto L42
    L6:
        if (r100.equals("percentY") == false) goto L33;
        r102 = 6;
        goto L33
    L10:
        if (r100.equals("percentX") == false) goto L33;
        r102 = 5;
        goto L33
    L14:
        if (r100.equals("sizePercent") == false) goto L33;
        r102 = 4;
        goto L33
    L18:
        if (r100.equals("drawPath") == false) goto L33;
        r102 = 3;
        goto L33
    L22:
        if (r100.equals("percentHeight") == false) goto L33;
        r102 = 2;
        goto L33
    L26:
        if (r100.equals("percentWidth") == false) goto L33;
        r102 = 1;
        goto L33
    L30:
        if (r100.equals("transitionEasing") == false) goto L33;
        r102 = 0;
        goto L33
    }
}
