package com.ss.android.lark.keyboard.plugin.tool.voice.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import vob.c;
import vob.d;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f430904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f430905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f430906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f430907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f430908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f430909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f430910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f430911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f430912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f430913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f430914k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f430915l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f430916m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f430917n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f430918o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f430919p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f430920q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final C5116a f430921r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f430922s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f430923t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f430924u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f430925v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f430926w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SmartTabLayout.f f430927x;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.widget.a$a, reason: collision with other inner class name */
    public static class C5116a implements SmartTabLayout.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f430928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f430929b;

        public C5116a() {
        }
    }

    public final void a(Canvas r110) {
        int r100 = getHeight();
        int r101 = getWidth();
        int r111 = getChildCount();
        Object r102 = this.f430927x;
        if (r102 != null) goto L6;
        r102 = this.f430921r;
    L6:
        Object r112 = r102;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        boolean r113 = true;
    L11:
        if (this.f430912i == false) goto L21;
        if (this.f430904a <= 0) goto L17;
        this.f430908e.setColor(this.f430905b);
        r110.drawRect(0, 0.0f, r101, this.f430904a, this.f430908e);
    L17:
        if (this.f430906c <= 0) goto L21;
        this.f430908e.setColor(this.f430907d);
        r110.drawRect(0, r100 - this.f430906c, r101, r100, this.f430908e);
    L21:
        if (r111 <= 0) goto L60;
        View r103 = getChildAt(this.f430924u);
        int r104 = d.d(r103, this.f430910g);
        int r105 = d.a(r103, this.f430910g);
        if (r113 == false) goto L25;
        r104 = r105;
        r105 = r104;
    L25:
        int r106 = this.f430924u;
        C5116a r114 = (C5116a) r112;
        int[] r115 = r114.f430928a;
        int r116 = r115[r106 % r115.length];
        float r117 = this.f430913j;
        if (this.f430925v > 0.0f) goto L28;
    L37:
        float r118 = 1.0f;
    L38:
        int r107 = this.f430913j;
        if (r107 <= 0) goto L62;
        if (this.f430914k == 0) goto L62;
        int r108 = this.f430915l;
        if (r108 != 1) goto L46;
        float r109 = r107;
    L50:
        float r119 = r109 / 2.0f;
    L51:
        float r120 = r117 / 2.0f;
        float r121 = r119 - r120;
        float r122 = r119 + r120;
        this.f430917n.setColor(r116);
        if (this.f430914k != (-1)) goto L54;
        this.f430909f.set(r104, r121, r105, r122);
    L55:
        float r123 = this.f430916m;
        if (r123 <= 0.0f) goto L58;
        r110.drawRoundRect(this.f430909f, r123, r123, this.f430917n);
        goto L62
    L58:
        r110.drawRect(this.f430909f, this.f430917n);
        goto L62
    L54:
        float r124 = (Math.abs(r104 - r105) - this.f430914k) / 2.0f;
        this.f430909f.set(r104 + r124, r121, r105 - r124, r122);
        goto L55
    L46:
        if (r108 == 2) goto L48;
        r119 = r100 - (r107 / 2.0f);
        goto L51
    L48:
        r109 = r100;
    L62:
        if (this.f430912i == false) goto L64;
        float r125 = 0.0f;
    L73:
        if (this.f430918o <= 0) goto L91;
        int r126 = (int) (Math.min(Math.max(r125, this.f430920q), r118) * r100);
        Object r127 = this.f430927x;
        if (r127 != null) goto L79;
        r127 = this.f430921r;
    L79:
        Object r128 = r127;
        int r129 = (r100 - r126) / 2;
        int r130 = r126 + r129;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L82;
        boolean r131 = true;
    L83:
        int r132 = 0;
    L85:
        if (r132 >= (r111 - 1)) goto L95;
        View r133 = getChildAt(r132);
        int r134 = d.a(r133, false);
        int r135 = d.b(r133);
        if (r131 == false) goto L89;
        int r136 = r134 - r135;
    L90:
        Paint r137 = this.f430919p;
        int[] r138 = ((C5116a) r128).f430929b;
        r137.setColor(r138[r132 % r138.length]);
        float r139 = r136;
        r110.drawLine(r139, r129, r139, r130, this.f430919p);
        r132 = r132 + 1;
        goto L85
    L89:
        r136 = r134 + r135;
        goto L90
    L95:
        return;
    L82:
        r131 = false;
        goto L83
    L91:
        return;
    L64:
        if (this.f430904a > 0) goto L66;
        r125 = 0.0f;
    L67:
        int r140 = getWidth();
        if (this.f430906c <= 0) goto L73;
        this.f430908e.setColor(this.f430907d);
        r110.drawRect(0, r100 - this.f430906c, r140, r100, this.f430908e);
        goto L73
    L66:
        this.f430908e.setColor(this.f430905b);
        r125 = 0.0f;
        r110.drawRect(0, 0.0f, r101, this.f430904a, this.f430908e);
        goto L67
    L28:
        if (r106 >= (getChildCount() - 1)) goto L37;
        int r141 = this.f430924u + 1;
        int[] r142 = r114.f430928a;
        int r143 = r142[r141 % r142.length];
        if (r116 == r143) goto L32;
        float r144 = this.f430925v;
        float r145 = 1.0f - r144;
        r116 = Color.rgb((int) ((Color.red(r143) * r144) + (Color.red(r116) * r145)), (int) ((Color.green(r143) * r144) + (Color.green(r116) * r145)), (int) ((Color.blue(r143) * r144) + (Color.blue(r116) * r145)));
    L32:
        float r146 = this.f430926w.a(this.f430925v);
        float r147 = this.f430926w.b(this.f430925v);
        float r148 = this.f430926w.c(this.f430925v);
        View r149 = getChildAt(this.f430924u + 1);
        int r150 = d.d(r149, this.f430910g);
        int r151 = d.a(r149, this.f430910g);
        if (r113 == false) goto L35;
        r118 = 1.0f;
        r104 = (int) ((r151 * r147) + ((1.0f - r147) * r104));
        r105 = (int) ((r150 * r146) + ((1.0f - r146) * r105));
    L36:
        r117 = r117 * r148;
        goto L38
    L35:
        r118 = 1.0f;
        r104 = (int) ((r150 * r146) + ((1.0f - r146) * r104));
        r105 = (int) ((r151 * r147) + ((1.0f - r147) * r105));
        goto L36
    L60:
        r118 = 1.0f;
        goto L62
    L9:
        r113 = false;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
        if (this.f430922s == false) goto L6;
        a(r100);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        if (this.f430922s == true) goto L6;
        a(r100);
        return;
    }

    public a(Context r210, AttributeSet r211) {
        super(r210);
        this.f430909f = new RectF();
        setWillNotDraw(false);
        Resources r100 = getResources();
        float r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
        TypedValue r102 = new TypedValue();
        r210.getTheme().resolveAttribute(R.attr.colorForeground, r102, true);
        int r103 = r102.data;
        float r104 = 0.0f * r101;
        int r105 = b(r103, (byte) 38);
        int r106 = (int) r104;
        int r107 = b(r103, (byte) 38);
        int r108 = b(r103, (byte) 32);
        TypedArray r110 = r210.obtainStyledAttributes(r211, new int[]{com.larus.nova.R.attr.stl_clickable, com.larus.nova.R.attr.stl_customTabTextLayoutId, com.larus.nova.R.attr.stl_customTabTextViewId, com.larus.nova.R.attr.stl_defaultTabBackground, com.larus.nova.R.attr.stl_defaultTabTextAllCaps, com.larus.nova.R.attr.stl_defaultTabTextColor, com.larus.nova.R.attr.stl_defaultTabTextHorizontalPadding, com.larus.nova.R.attr.stl_defaultTabTextMinWidth, com.larus.nova.R.attr.stl_defaultTabTextSize, com.larus.nova.R.attr.stl_distributeEvenly, com.larus.nova.R.attr.stl_dividerColor, com.larus.nova.R.attr.stl_dividerColors, com.larus.nova.R.attr.stl_dividerThickness, com.larus.nova.R.attr.stl_drawDecorationAfterTab, com.larus.nova.R.attr.stl_indicatorAlwaysInCenter, com.larus.nova.R.attr.stl_indicatorColor, com.larus.nova.R.attr.stl_indicatorColors, com.larus.nova.R.attr.stl_indicatorCornerRadius, com.larus.nova.R.attr.stl_indicatorGravity, com.larus.nova.R.attr.stl_indicatorInFront, com.larus.nova.R.attr.stl_indicatorInterpolation, com.larus.nova.R.attr.stl_indicatorThickness, com.larus.nova.R.attr.stl_indicatorWidth, com.larus.nova.R.attr.stl_indicatorWithoutPadding, com.larus.nova.R.attr.stl_overlineColor, com.larus.nova.R.attr.stl_overlineThickness, com.larus.nova.R.attr.stl_titleOffset, com.larus.nova.R.attr.stl_underlineColor, com.larus.nova.R.attr.stl_underlineThickness});
        boolean r111 = r110.getBoolean(14, false);
        boolean r112 = r110.getBoolean(23, false);
        boolean r113 = r110.getBoolean(19, false);
        int r114 = r110.getInt(20, 0);
        int r109 = r110.getInt(18, 0);
        int r115 = r110.getColor(15, -13388315);
        int r116 = r110.getResourceId(16, -1);
        int r117 = r110.getDimensionPixelSize(21, (int) (8.0f * r101));
        int r118 = r110.getLayoutDimension(22, -1);
        float r119 = r110.getDimension(17, r104);
        int r120 = r110.getColor(24, r105);
        int r121 = r110.getDimensionPixelSize(25, r106);
        int r122 = r110.getColor(27, r107);
        int r123 = r110.getDimensionPixelSize(28, (int) (2.0f * r101));
        int r124 = r110.getColor(10, r108);
        int r125 = r110.getResourceId(11, -1);
        int r126 = r110.getDimensionPixelSize(12, (int) (r101 * 1.0f));
        boolean r127 = r110.getBoolean(13, false);
        r110.recycle();
        if (r116 != (-1)) goto L5;
        int r128 = 1;
        int[] r129 = {r115};
    L7:
        if (r125 != (-1)) goto L9;
        int[] r130 = new int[r128];
        r130[0] = r124;
    L10:
        C5116a r131 = new C5116a();
        this.f430921r = r131;
        r131.f430928a = r129;
        r131.f430929b = r130;
        this.f430904a = r121;
        this.f430905b = r120;
        this.f430906c = r123;
        this.f430907d = r122;
        this.f430908e = new Paint(1);
        this.f430911h = r111;
        this.f430910g = r112;
        this.f430912i = r113;
        this.f430913j = r117;
        this.f430914k = r118;
        this.f430917n = new Paint(1);
        this.f430916m = r119;
        this.f430915l = r109;
        this.f430920q = 0.5f;
        Paint r132 = new Paint(1);
        this.f430919p = r132;
        r132.setStrokeWidth(r126);
        this.f430918o = r126;
        this.f430922s = r127;
        if (r114 != 0) goto L13;
        c r133 = c.f556532a;
    L18:
        this.f430926w = r133;
        return;
    L13:
        if (r114 != 1) goto L15;
        r133 = c.f556533b;
        goto L18
    L15:
        c.b r134 = c.f556532a;
        throw new IllegalArgumentException("Unknown id: " + r114);
    L9:
        r130 = getResources().getIntArray(r125);
        goto L10
    L5:
        r128 = 1;
        r129 = getResources().getIntArray(r116);
        goto L7
    }

    public static int b(int r100, byte r101) {
        return Color.argb(r101, Color.red(r100), Color.green(r100), Color.blue(r100));
    }
}
