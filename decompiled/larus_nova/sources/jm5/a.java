package jm5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public int A;
    public int B;
    public float[] C;
    public boolean D;
    public final RectF E;
    public int F;
    public int G;
    public int H;
    public final WeakReference<View> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f499639J;
    public final Path K;
    public boolean L;
    public int M;
    public float N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f499640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f499641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f499642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f499643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f499644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f499645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f499646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f499647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f499648i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f499649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f499650k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f499651l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f499652m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f499653n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f499654o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f499655p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f499656q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f499657r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f499658s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f499659t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f499660u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f499661v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f499662w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f499663x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Paint f499664y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Paint f499665z;

    /* JADX INFO: renamed from: jm5.a$a, reason: collision with other inner class name */
    public class C6461a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f499666a;

        public C6461a(a r100) {
            this.f499666a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r110, Outline r111) {
            int r100 = r110.getWidth();
            int r101 = r110.getHeight();
            if (r100 == 0) goto L35;
            if (r101 == 0) goto L37;
            int r102 = this.f499666a.a();
            a r103 = this.f499666a;
            if (r103.D == false) goto L24;
            int r112 = r103.B;
            if (r112 != 4) goto L13;
            int r104 = 0 - r102;
            int r105 = r100;
            int r106 = r101;
        L11:
            int r107 = 0;
        L22:
            r111.setRoundRect(r104, r107, r105, r106, r102);
            return;
        L13:
            if (r112 != 1) goto L16;
            r107 = 0 - r102;
            r105 = r100;
            r106 = r101;
            r104 = 0;
            goto L22
        L16:
            if (r112 != 2) goto L19;
            r100 = r100 + r102;
        L21:
            r105 = r100;
            r106 = r101;
            r104 = 0;
            goto L11
        L19:
            if (r112 != 3) goto L21;
            r101 = r101 + r102;
            goto L21
        L24:
            int r108 = r103.R;
            int r109 = Math.max(r108 + 1, r101 - r103.S);
            a r113 = this.f499666a;
            int r114 = r113.P;
            int r115 = r100 - r113.Q;
            if (r113.f499639J == false) goto L27;
            r114 = r114 + r110.getPaddingLeft();
            r108 = r108 + r110.getPaddingTop();
            r115 = Math.max(r114 + 1, r115 - r110.getPaddingRight());
            r109 = Math.max(r108 + 1, r109 - r110.getPaddingBottom());
        L27:
            int r116 = r115;
            int r117 = r109;
            int r118 = r108;
            int r119 = r114;
            a r120 = this.f499666a;
            float r121 = r120.N;
            if (r120.M != 0) goto L30;
            r121 = 1.0f;
        L30:
            r111.setAlpha(r121);
            if (r102 > 0) goto L33;
            r111.setRect(r119, r118, r116, r117);
            return;
        L33:
            r111.setRoundRect(r119, r118, r116, r117, r102);
            return;
        L37:
            return;
        }
    }

    public final int a() {
        View r100 = this.I.get();
        if (r100 == null) goto L5;
        int r101 = this.A;
        if (r101 != (-1)) goto L10;
        return r100.getHeight() / 2;
    L10:
        if (r101 == (-2)) goto L12;
        return r101;
    L12:
        return r100.getWidth() / 2;
    L5:
        return this.A;
    }

    public a(Context r110, AttributeSet r111, int r112, View r113) {
        this.f499640a = 0;
        this.f499641b = 0;
        this.f499642c = 0;
        this.f499643d = 0;
        this.f499644e = 0;
        this.f499645f = 0;
        this.f499646g = 0;
        this.f499648i = 255;
        this.f499649j = 0;
        this.f499650k = 0;
        this.f499651l = 0;
        this.f499653n = 255;
        this.f499654o = 0;
        this.f499655p = 0;
        this.f499656q = 0;
        this.f499658s = 255;
        this.f499659t = 0;
        this.f499660u = 0;
        this.f499661v = 0;
        this.f499663x = 255;
        this.B = 0;
        this.F = 0;
        this.G = 1;
        this.H = 0;
        this.f499639J = false;
        this.K = new Path();
        this.L = true;
        this.M = 0;
        this.O = -16777216;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.I = new WeakReference(r113);
        int r114 = ContextCompat.getColor(r110, R.color.lkui_N300);
        this.f499647h = r114;
        this.f499652m = r114;
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r115 = new Paint();
        this.f499665z = r115;
        r115.setAntiAlias(true);
        this.N = 0.17f;
        this.E = new RectF();
        if (r111 != null) goto L6;
        if (r112 != 0) goto L6;
        int r100 = 0;
        int r101 = 0;
    L111:
        int r102 = this.B;
        float r103 = this.N;
        b(r100, r102, r101, this.O, r103);
        return;
    L6:
        TypedArray r116 = r110.obtainStyledAttributes(r111, new int[]{android.R.attr.maxWidth, android.R.attr.maxHeight, android.R.attr.minWidth, android.R.attr.minHeight, R.attr.borderColor, R.attr.borderWidth, R.attr.bottomDividerColor, R.attr.bottomDividerHeight, R.attr.bottomDividerInsetLeft, R.attr.bottomDividerInsetRight, R.attr.clickable, R.attr.hideRadiusSide, R.attr.hl_angle, R.attr.hl_centerColor, R.attr.hl_cornerRadius, R.attr.hl_cornerRadius_leftBottom, R.attr.hl_cornerRadius_leftTop, R.attr.hl_cornerRadius_rightBottom, R.attr.hl_cornerRadius_rightTop, R.attr.hl_endColor, R.attr.hl_layoutBackground, R.attr.hl_layoutBackground_clickFalse, R.attr.hl_layoutBackground_selected, R.attr.hl_shadowColor, R.attr.hl_shadowHidden, R.attr.hl_shadowHiddenBottom, R.attr.hl_shadowHiddenLeft, R.attr.hl_shadowHiddenRight, R.attr.hl_shadowHiddenTop, R.attr.hl_shadowLimit, R.attr.hl_shadowOffsetX, R.attr.hl_shadowOffsetY, R.attr.hl_shadowSymmetry, R.attr.hl_shapeMode, R.attr.hl_startColor, R.attr.hl_strokeColor, R.attr.hl_strokeColor_true, R.attr.hl_strokeWith, R.attr.hl_stroke_dashGap, R.attr.hl_stroke_dashWidth, R.attr.leftDividerColor, R.attr.leftDividerInsetBottom, R.attr.leftDividerInsetTop, R.attr.leftDividerWidth, R.attr.outerNormalColor, R.attr.outlineExcludePadding, R.attr.outlineInsetBottom, R.attr.outlineInsetLeft, R.attr.outlineInsetRight, R.attr.outlineInsetTop, R.attr.radius, R.attr.rightDividerColor, R.attr.rightDividerInsetBottom, R.attr.rightDividerInsetTop, R.attr.rightDividerWidth, R.attr.shadowAlpha, R.attr.shadowElevation, R.attr.showBorderOnlyBeforeL, R.attr.topDividerColor, R.attr.topDividerHeight, R.attr.topDividerInsetLeft, R.attr.topDividerInsetRight, R.attr.useThemeGeneralShadowElevation, R.attr.ux_shadow_color, R.attr.ux_shadow_offset_x, R.attr.ux_shadow_offset_y, R.attr.ux_shadow_radius, R.attr.ux_shadow_size, R.attr.ux_shadow_strokeWidth}, r112, 0);
        int r117 = r116.getIndexCount();
        int r118 = 0;
        int r119 = 0;
        int r104 = 0;
    L7:
        if (r118 >= r117) goto L110;
        int r105 = r116.getIndex(r118);
        if (r105 != 0) goto L11;
        this.f499640a = r116.getDimensionPixelSize(r105, this.f499640a);
    L109:
        r118 = r118 + 1;
        goto L7
    L11:
        if (r105 != 1) goto L14;
        this.f499641b = r116.getDimensionPixelSize(r105, this.f499641b);
        goto L109
    L14:
        if (r105 != 2) goto L17;
        this.f499642c = r116.getDimensionPixelSize(r105, this.f499642c);
        goto L109
    L17:
        if (r105 != 3) goto L20;
        this.f499643d = r116.getDimensionPixelSize(r105, this.f499643d);
        goto L109
    L20:
        if (r105 != 58) goto L23;
        this.f499647h = r116.getColor(r105, this.f499647h);
        goto L109
    L23:
        if (r105 != 59) goto L26;
        this.f499644e = r116.getDimensionPixelSize(r105, this.f499644e);
        goto L109
    L26:
        if (r105 != 60) goto L29;
        this.f499645f = r116.getDimensionPixelSize(r105, this.f499645f);
        goto L109
    L29:
        if (r105 != 61) goto L32;
        this.f499646g = r116.getDimensionPixelSize(r105, this.f499646g);
        goto L109
    L32:
        if (r105 != 6) goto L35;
        this.f499652m = r116.getColor(r105, this.f499652m);
        goto L109
    L35:
        if (r105 != 7) goto L38;
        this.f499649j = r116.getDimensionPixelSize(r105, this.f499649j);
        goto L109
    L38:
        if (r105 != 8) goto L41;
        this.f499650k = r116.getDimensionPixelSize(r105, this.f499650k);
        goto L109
    L41:
        if (r105 != 9) goto L44;
        this.f499651l = r116.getDimensionPixelSize(r105, this.f499651l);
        goto L109
    L44:
        if (r105 != 40) goto L47;
        this.f499657r = r116.getColor(r105, this.f499657r);
        goto L109
    L47:
        if (r105 != 43) goto L50;
        this.f499654o = r116.getDimensionPixelSize(r105, this.f499654o);
        goto L109
    L50:
        if (r105 != 42) goto L53;
        this.f499655p = r116.getDimensionPixelSize(r105, this.f499655p);
        goto L109
    L53:
        if (r105 != 41) goto L56;
        this.f499656q = r116.getDimensionPixelSize(r105, this.f499656q);
        goto L109
    L56:
        if (r105 != 51) goto L59;
        this.f499662w = r116.getColor(r105, this.f499662w);
        goto L109
    L59:
        if (r105 != 54) goto L62;
        this.f499659t = r116.getDimensionPixelSize(r105, this.f499659t);
        goto L109
    L62:
        if (r105 != 53) goto L65;
        this.f499660u = r116.getDimensionPixelSize(r105, this.f499660u);
        goto L109
    L65:
        if (r105 != 52) goto L68;
        this.f499661v = r116.getDimensionPixelSize(r105, this.f499661v);
        goto L109
    L68:
        if (r105 != 4) goto L71;
        this.F = r116.getColor(r105, this.F);
        goto L109
    L71:
        if (r105 != 5) goto L74;
        this.G = r116.getDimensionPixelSize(r105, this.G);
        goto L109
    L74:
        if (r105 != 50) goto L77;
        r119 = r116.getDimensionPixelSize(r105, 0);
        goto L109
    L77:
        if (r105 != 44) goto L80;
        this.H = r116.getColor(r105, this.H);
        goto L109
    L80:
        if (r105 != 11) goto L83;
        this.B = r116.getInt(r105, this.B);
        goto L109
    L83:
        if (r105 != 57) goto L86;
        this.L = r116.getBoolean(r105, this.L);
        goto L109
    L86:
        if (r105 != 56) goto L89;
        r104 = r116.getDimensionPixelSize(r105, r104);
        goto L109
    L89:
        if (r105 != 55) goto L92;
        this.N = r116.getFloat(r105, this.N);
        goto L109
    L92:
        if (r105 != 62) goto L95;
        r116.getBoolean(r105, false);
        goto L109
    L95:
        if (r105 != 47) goto L98;
        this.P = r116.getDimensionPixelSize(r105, 0);
        goto L109
    L98:
        if (r105 != 48) goto L101;
        this.Q = r116.getDimensionPixelSize(r105, 0);
        goto L109
    L101:
        if (r105 != 49) goto L104;
        this.R = r116.getDimensionPixelSize(r105, 0);
        goto L109
    L104:
        if (r105 != 46) goto L107;
        this.S = r116.getDimensionPixelSize(r105, 0);
        goto L109
    L107:
        if (r105 != 45) goto L109;
        this.f499639J = r116.getBoolean(r105, false);
        goto L109
    L110:
        r116.recycle();
        r100 = r119;
        r101 = r104;
        goto L111
    }

    public final void b(int r100, int r101, int r102, int r103, float r110) {
        View r104 = this.I.get();
        if (r104 != null) goto L5;
        return;
    L5:
        this.A = r100;
        this.B = r101;
        boolean r105 = false;
        if (r100 == (-1)) goto L9;
        if (r100 == (-2)) goto L9;
        if (r100 > 0) goto L9;
    L11:
        boolean r106 = false;
    L12:
        this.D = r106;
        this.M = r102;
        this.N = r110;
        this.O = r103;
        if (r102 == 0) goto L17;
        if (r106 == true) goto L17;
        r104.setElevation(r102);
    L18:
        int r107 = this.O;
        if (Build.VERSION.SDK_INT < 28) goto L24;
        View r108 = this.I.get();
        if (r108 == null) goto L24;
        r108.setOutlineAmbientShadowColor(r107);
        r108.setOutlineSpotShadowColor(r107);
    L24:
        r104.setOutlineProvider(new C6461a(this));
        int r109 = this.A;
        if (r109 == (-2)) goto L28;
        if (r109 == (-1)) goto L28;
        if (r109 > 0) goto L28;
    L29:
        r104.setClipToOutline(r105);
        r104.invalidate();
        return;
    L28:
        r105 = true;
    L17:
        r104.setElevation(0.0f);
    L9:
        if (r101 == 0) goto L11;
        r106 = true;
        goto L12
    }
}
