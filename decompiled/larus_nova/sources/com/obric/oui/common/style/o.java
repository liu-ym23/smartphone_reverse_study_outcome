package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.shadow.ShadowTokenCore;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f399583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f399584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f399585c;

    public static final class a {
    }

    static {
        new ola.a();
    }

    public final j a() {
        j r100 = this.f399585c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOUIEffectHelper");
        return null;
    L6:
        return r100;
    }

    public final void b(View r210) {
        Intrinsics.checkNotNullParameter(r210, "owner");
        l r100 = this.f399583a;
        r100.getClass();
        Resources r101 = r210.getResources();
        float r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        r100.O = new WeakReference(r210);
        int r103 = ContextCompat.getColor(r100.f399547a, R.color.oui_line_2);
        r100.f399558i = r103;
        r100.f399565n = r103;
        int r104 = ContextCompat.getColor(r100.f399547a, R.color.oui_line_2);
        r100.f399577x = r104;
        r100.f399572s = r104;
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r105 = new Paint();
        r100.B = r105;
        r105.setAntiAlias(true);
        Resources.Theme r106 = r100.f399547a.getTheme();
        if (m.f399580a != null) goto L6;
        m.f399580a = new TypedValue();
    L6:
        if (r106.resolveAttribute(R.attr.oui_general_shadow_alpha, m.f399580a, true) == true) goto L8;
        float r107 = -1.0f;
    L10:
        if (r107 <= 0.0f) goto L12;
        r100.U = r107;
    L12:
        r100.K = new RectF();
        int r108 = 0;
        if (r100.V0 == false) goto L15;
    L22:
        TypedArray r109 = r100.f399547a.obtainStyledAttributes(r100.H0, new int[]{android.R.attr.maxWidth, android.R.attr.maxHeight, android.R.attr.minWidth, android.R.attr.minHeight, R.attr.oui_bottomDividerColor, R.attr.oui_bottomDividerHeight, R.attr.oui_bottomDividerInsetLeft, R.attr.oui_bottomDividerInsetRight, R.attr.oui_bottomLeft_radius, R.attr.oui_bottomRight_radius, R.attr.oui_firstOffsetX, R.attr.oui_firstOffsetY, R.attr.oui_firstShadowBlur, R.attr.oui_firstShadowColor, R.attr.oui_firstShadowSpread, R.attr.oui_layout_borderColor, R.attr.oui_layout_borderWidth, R.attr.oui_leftDividerColor, R.attr.oui_leftDividerInsetBottom, R.attr.oui_leftDividerInsetTop, R.attr.oui_leftDividerWidth, R.attr.oui_outerNormalColor, R.attr.oui_outlineExcludePadding, R.attr.oui_outlineInsetBottom, R.attr.oui_outlineInsetLeft, R.attr.oui_outlineInsetRight, R.attr.oui_outlineInsetTop, R.attr.oui_radius, R.attr.oui_rightDividerColor, R.attr.oui_rightDividerInsetBottom, R.attr.oui_rightDividerInsetTop, R.attr.oui_rightDividerWidth, R.attr.oui_secondOffsetX, R.attr.oui_secondOffsetY, R.attr.oui_secondShadowBlur, R.attr.oui_secondShadowColor, R.attr.oui_secondShadowSpread, R.attr.oui_shadow, R.attr.oui_shadowAlpha, R.attr.oui_shadowCornerRadius, R.attr.oui_shadowElevation, R.attr.oui_shadow_style, R.attr.oui_showBorderOnlyBeforeL, R.attr.oui_support_image_mirroring, R.attr.oui_topDividerColor, R.attr.oui_topDividerHeight, R.attr.oui_topDividerInsetLeft, R.attr.oui_topDividerInsetRight, R.attr.oui_topLeft_radius, R.attr.oui_topRight_radius, R.attr.oui_useThemeGeneralShadowElevation}, r100.L0, r100.P0);
        int r110 = r109.getIndexCount();
        int r111 = 0;
        int r112 = 0;
        boolean r113 = false;
        int r114 = 0;
    L23:
        if (r111 >= r110) goto L138;
        int r115 = r109.getIndex(r111);
        if (r115 != 0) goto L27;
        r100.f399548b = r109.getDimensionPixelSize(r115, r100.f399548b);
    L129:
        if (r115 != 8) goto L132;
        r100.G = r109.getDimensionPixelSize(r115, 0);
    L132:
        if (r115 != 9) goto L135;
        r100.H = r109.getDimensionPixelSize(r115, 0);
    L135:
        if (r115 != 49) goto L137;
        r100.F = r109.getDimensionPixelSize(r115, 0);
    L137:
        r111 = r111 + 1;
        goto L23
    L27:
        if (r115 != 1) goto L30;
        r100.f399550c = r109.getDimensionPixelSize(r115, r100.f399550c);
        goto L129
    L30:
        if (r115 != 2) goto L33;
        r100.f399551d = r109.getDimensionPixelSize(r115, r100.f399551d);
        goto L129
    L33:
        if (r115 != 3) goto L36;
        r100.f399552e = r109.getDimensionPixelSize(r115, r100.f399552e);
        goto L129
    L36:
        if (r115 != 44) goto L39;
        r100.f399558i = r109.getColor(r115, r100.f399558i);
        goto L129
    L39:
        if (r115 != 45) goto L42;
        r100.f399553f = r109.getDimensionPixelSize(r115, r100.f399553f);
        goto L129
    L42:
        if (r115 != 46) goto L45;
        r100.f399554g = r109.getDimensionPixelSize(r115, r100.f399554g);
        goto L129
    L45:
        if (r115 != 47) goto L48;
        r100.f399556h = r109.getDimensionPixelSize(r115, r100.f399556h);
        goto L129
    L48:
        if (r115 != 4) goto L51;
        r100.f399565n = r109.getColor(r115, r100.f399565n);
        goto L129
    L51:
        if (r115 != 5) goto L54;
        r100.f399560k = r109.getDimensionPixelSize(r115, r100.f399560k);
        goto L129
    L54:
        if (r115 != 6) goto L57;
        r100.f399563l = r109.getDimensionPixelSize(r115, r100.f399563l);
        goto L129
    L57:
        if (r115 != 7) goto L60;
        r100.f399564m = r109.getDimensionPixelSize(r115, r100.f399564m);
        goto L129
    L60:
        if (r115 != 17) goto L63;
        r100.f399572s = r109.getColor(r115, r100.f399572s);
        goto L129
    L63:
        if (r115 != 20) goto L66;
        r100.f399567p = r109.getDimensionPixelSize(r115, r100.f399567p);
        goto L129
    L66:
        if (r115 != 19) goto L69;
        r100.f399570q = r109.getDimensionPixelSize(r115, r100.f399570q);
        goto L129
    L69:
        if (r115 != 18) goto L72;
        r100.f399571r = r109.getDimensionPixelSize(r115, r100.f399571r);
        goto L129
    L72:
        if (r115 != 28) goto L75;
        r100.f399577x = r109.getColor(r115, r100.f399577x);
        goto L129
    L75:
        if (r115 != 31) goto L78;
        r100.f399574u = r109.getDimensionPixelSize(r115, r100.f399574u);
        goto L129
    L78:
        if (r115 != 30) goto L81;
        r100.f399575v = r109.getDimensionPixelSize(r115, r100.f399575v);
        goto L129
    L81:
        if (r115 != 29) goto L84;
        r100.f399576w = r109.getDimensionPixelSize(r115, r100.f399576w);
        goto L129
    L84:
        if (r115 != 15) goto L87;
        r100.L = r109.getColor(r115, r100.L);
        goto L129
    L87:
        if (r115 != 16) goto L90;
        r100.M = r109.getDimensionPixelSize(r115, r100.M);
        goto L129
    L90:
        if (r115 != 27) goto L93;
        r114 = r109.getDimensionPixelSize(r115, 0);
        goto L129
    L93:
        if (r115 != 21) goto L96;
        r100.N = r109.getColor(r115, r100.N);
        goto L129
    L96:
        if (r115 != 42) goto L99;
        r100.S = r109.getBoolean(r115, r100.S);
        goto L129
    L99:
        if (r115 != 40) goto L102;
        r112 = r109.getDimensionPixelSize(r115, r112);
        goto L129
    L102:
        if (r115 != 38) goto L105;
        r100.U = r109.getFloat(r115, r100.U);
        goto L129
    L105:
        if (r115 != 50) goto L108;
        r113 = r109.getBoolean(r115, false);
        goto L129
    L108:
        if (r115 != 24) goto L111;
        r100.Y = r109.getDimensionPixelSize(r115, 0);
        goto L129
    L111:
        if (r115 != 25) goto L114;
        r100.Z = r109.getDimensionPixelSize(r115, 0);
        goto L129
    L114:
        if (r115 != 26) goto L117;
        r100.f399561k0 = r109.getDimensionPixelSize(r115, 0);
        goto L129
    L117:
        if (r115 != 23) goto L120;
        r100.f399568p0 = r109.getDimensionPixelSize(r115, 0);
        goto L129
    L120:
        if (r115 != 22) goto L123;
        r100.P = r109.getBoolean(r115, false);
        goto L129
    L123:
        if (r115 != 43) goto L126;
        r109.getBoolean(r115, false);
        goto L129
    L126:
        if (r115 != 48) goto L129;
        r100.E = r109.getDimensionPixelSize(r115, 0);
        goto L129
    L138:
        com.obric.oui.shadow.b[] r116 = ShadowTokenCore.parse(r109.getString(37));
        if (r116 == null) goto L143;
        r100.f399549b1.d(r116[0], r102);
        if (r116.length <= 1) goto L147;
        r100.f399555g1.d(r116[1], r102);
    L147:
        r100.f399557h1.update(r100.f399549b1);
        r100.f399562k1.update(r100.f399555g1);
        r100.f399569p1 = r109.getDimension(39, 0.0f);
        r109.recycle();
        int r117 = r114;
    L148:
        if (r112 != 0) goto L158;
        if (r113 == false) goto L158;
        Context r118 = r100.f399547a;
        if (m.f399580a != null) goto L154;
        m.f399580a = new TypedValue();
    L154:
        if (r118.getTheme().resolveAttribute(R.attr.oui_general_shadow_elevation, m.f399580a, true) == false) goto L157;
        int r119 = m.f399580a.data;
        Resources r120 = r118.getResources();
        r108 = TypedValue.complexToDimensionPixelSize(r119, WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics()));
    L157:
        r112 = r108;
    L158:
        r100.y(r117, r112, r100.U);
        h r121 = this.f399584b;
        r121.getClass();
        r121.f399507a = new WeakReference(r210);
        r121.c(r210);
        this.f399585c = new j(r210);
        return;
    L143:
        int r122 = r109.getResourceId(41, 0);
        if (r122 == 0) goto L146;
        r100.a(r100.f399547a, r122);
        goto L147
    L146:
        q r123 = r100.f399549b1;
        int r124 = com.obric.oui.shadow.a.f402800g;
        r123.c(com.obric.oui.shadow.a.C4679a.a(r109, 13, 12, 10, 11, 14));
        r100.f399555g1.c(com.obric.oui.shadow.a.C4679a.a(r109, 35, 34, 32, 33, 36));
        goto L147
    L15:
        if (r100.H0 != null) goto L22;
        if (r100.L0 != 0) goto L22;
        if (r100.P0 != 0) goto L22;
        r117 = 0;
        r112 = 0;
        r113 = false;
        goto L148
    L8:
        r107 = m.f399580a.getFloat();
        goto L10
    }

    public o(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f399583a = new l(r100, r101, r102, r103);
        this.f399584b = new h(r100, r101, r102, r103);
    }
}
