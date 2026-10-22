package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class SearchFilterViewV2 extends View {
    public static final Rect U = null;
    public Rect A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f461000J;
    public String K;
    public boolean L;
    public List<Bitmap> M;
    public int N;
    public float O;
    public float P;
    public float Q;
    public RectF R;
    public RectF S;
    public a T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f461001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f461002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f461003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f461004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f461005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f461006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f461007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f461008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f461009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f461010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f461011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f461012l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f461013m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f461014n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f461015o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Paint f461016p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Paint f461017q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Paint f461018r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Paint f461019s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Paint f461020t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f461021u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f461022v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f461023w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f461024x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Drawable f461025y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f461026z;

    public interface a {
        void onClick();
    }

    private int getContentHeight() {
        Rect r100 = this.A;
        int r101 = (r100.top + 0) + r100.bottom;
        if (TextUtils.isEmpty(this.f461000J) == true) goto L5;
        Paint.FontMetrics r102 = this.f461017q.getFontMetrics();
        float r103 = (r102.bottom - r102.top) + r102.leading;
    L7:
        if (CollectionUtils.isEmpty(this.M) == true) goto L10;
        r103 = Math.max(r103, this.E + (this.G * 2.0f));
    L10:
        return (int) (r101 + r103);
    L5:
        r103 = 0.0f;
        goto L7
    }

    private int getContentWidth() {
        Rect r100 = this.A;
        int r101 = (r100.left + 0) + r100.right;
        if (TextUtils.isEmpty(this.f461000J) == true) goto L6;
        float r102 = this.f461017q.measureText(this.f461000J);
        this.P = r102;
        r101 = (int) (r101 + r102);
    L6:
        if (CollectionUtils.isEmpty(this.M) == true) goto L11;
        int r103 = this.N;
        if (r103 <= 0) goto L11;
        int r104 = (int) (r101 + this.C);
        int r105 = Math.min(r103, this.M.size());
        float r106 = ((this.E + (this.G * 2.0f)) * r105) - (this.F * (r105 - 1));
        this.Q = r106;
        r101 = (int) (r104 + r106);
    L11:
        if (TextUtils.isEmpty(this.K) == true) goto L14;
        r101 = (int) (((int) (r101 + this.C)) + this.f461017q.measureText(this.K));
    L14:
        if (this.f461003c == false) goto L21;
        float r107 = r101;
        if (this.f461001a == false) goto L18;
        float r108 = this.D;
    L19:
        r101 = this.H + ((int) (r107 + r108));
        goto L21
    L18:
        r108 = this.C;
    L21:
        if (this.f461002b == false) goto L23;
        int r109 = this.I;
        this.O = r109 + this.B;
        return r101 + r109;
    L23:
        this.O = 0.0f;
        return r101;
    }

    static {
        UIHelper.getColor(R.color.function_info_fill_solid_02);
        UIHelper.getColor(R.color.function_info_fill_solid_02);
        UIHelper.getColor(R.color.bg_float_overlay);
        UIHelper.getColor(R.color.bg_float_overlay);
        UIHelper.getColor(R.color.primary_fill_default);
        UIHelper.getColor(R.color.text_title);
        U = new Rect(12, 6, 12, 6);
    }

    public SearchFilterViewV2(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f461001a == false) goto L5;
        Paint r100 = this.f461012l;
        Paint r101 = this.f461011k;
    L6:
        float r102 = this.G;
        RectF r103 = new RectF(r102, r102, r110.getWidth() - this.G, r110.getHeight() - this.G);
        float r104 = this.f461013m;
        r110.drawRoundRect(r103, r104, r104, r101);
        if (this.f461004d == false) goto L10;
        float r105 = this.f461013m;
        r110.drawRoundRect(r103, r105, r105, r100);
    L10:
        if (this.f461002b == false) goto L14;
        int r106 = this.A.left;
        int r107 = r110.getHeight() / 2;
        int r108 = this.I;
        int r109 = r107 - (r108 / 2);
        this.f461026z.setBounds(r106, r109, r106 + r108, r108 + r109);
        this.f461026z.draw(r110);
    L14:
        if (TextUtils.isEmpty(this.f461000J) == true) goto L22;
        if (this.f461001a == false) goto L19;
        this.f461018r = this.f461017q;
    L20:
        Paint.FontMetrics r111 = this.f461018r.getFontMetrics();
        float r112 = r110.getHeight() / 2;
        float r113 = r111.bottom;
        float r114 = (r112 + ((r113 - r111.top) / 2.0f)) - r113;
        r110.drawText(this.f461000J, this.A.left + this.O, r114, this.f461018r);
        goto L22
    L19:
        this.f461018r = this.f461016p;
    L22:
        if (CollectionUtils.isEmpty(this.M) == true) goto L32;
        float r115 = (this.A.left + this.P) + this.C;
        float r116 = (r110.getHeight() / 2) - ((this.E + this.G) / 2.0f);
        int r117 = Math.min(this.M.size(), 1) - 1;
    L25:
        if (r117 < 0) goto L32;
        int r118 = r110.saveLayer(0.0f, 0.0f, r110.getWidth(), r110.getHeight(), null, 31);
        Bitmap r119 = (Bitmap) ListProtector.get(this.M, r117);
        if (r119 == null) goto L30;
        float r120 = this.E + (this.G * 2.0f);
        this.R.set(r115, r116, r115 + r120, r120 + r116);
        this.f461020t.setXfermode(null);
        r110.drawOval(this.R, this.f461020t);
        this.f461020t.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r110.drawBitmap(r119, null, this.R, this.f461020t);
        this.f461020t.setXfermode(null);
        r110.restoreToCount(r118);
        r110.drawOval(this.R, this.f461019s);
        r115 = r115 + ((this.E + (this.G * 2.0f)) - this.F);
    L30:
        r117 = r117 - 1;
    L32:
        if (TextUtils.isEmpty(this.K) == true) goto L40;
        if (this.f461001a == false) goto L37;
        this.f461018r = this.f461017q;
    L38:
        Paint.FontMetrics r121 = this.f461018r.getFontMetrics();
        float r122 = r110.getHeight() / 2;
        float r123 = r121.bottom;
        float r124 = (r122 + ((r123 - r121.top) / 2.0f)) - r123;
        r110.drawText(this.K, (((this.A.left + this.O) + this.P) + (this.C * 2.0f)) + this.Q, r124, this.f461018r);
        goto L40
    L37:
        this.f461018r = this.f461016p;
    L40:
        if (this.f461003c == false) goto L51;
        int r125 = (r110.getWidth() - this.A.right) - this.H;
        int r126 = r110.getHeight() / 2;
        int r127 = this.H;
        int r128 = r126 - (r127 / 2);
        this.S.set(r125, r128, r125 + r127, r127 + r128);
        if (this.f461001a == false) goto L45;
        this.f461025y = this.f461023w;
    L46:
        Drawable r129 = this.f461025y;
        int r130 = this.H;
        r129.setBounds(r125, r128, r125 + r130, r130 + r128);
        this.f461025y.draw(r110);
        return;
    L45:
        this.f461025y = this.f461024x;
        goto L46
    L51:
        return;
    L5:
        r100 = this.f461010j;
        r101 = this.f461009i;
        goto L6
    }

    public void setBgBorderVisibility(boolean r100) {
        this.f461004d = r100;
    }

    public void setCancelClickListener(a r100) {
        this.T = r100;
    }

    public void setDisplayAvatarLimit(int r100) {
        this.N = Math.max(0, r100);
        requestLayout();
        invalidate();
    }

    public void setItemSelectedBgBorderColor(int r100) {
        this.f461012l.setColor(UIUtils.getColor(getContext(), r100));
        invalidate();
    }

    public void setItemSelectedBgColor(int r100) {
        this.f461011k.setColor(UIUtils.getColor(getContext(), r100));
        invalidate();
    }

    public void setItemUnSelectedBgBorderColor(int r100) {
        this.f461010j.setColor(UIUtils.getColor(getContext(), r100));
        invalidate();
    }

    public void setItemUnSelectedBgColor(int r100) {
        this.f461009i.setColor(UIUtils.getColor(getContext(), r100));
        invalidate();
    }

    public void setLogoAvatarDrawable(Drawable r100) {
        if (r100 == null) goto L4;
        boolean r101 = true;
    L5:
        this.f461002b = r101;
        this.f461026z = r100;
        requestLayout();
        invalidate();
        return;
    L4:
        r101 = false;
        goto L5
    }

    public void setLogoAvatarVisible(boolean r100) {
        this.f461002b = r100;
    }

    public void setPaddingRect(Rect r100) {
        this.A = r100;
    }

    public void setRightArrowVisibility(boolean r100) {
        this.f461003c = r100;
    }

    public void setSelectedArrowColor(int r100) {
        this.f461023w = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_close_bold_outlined, UIUtils.getColor(getContext(), r100));
        invalidate();
    }

    public void setSelectedTextColor(int r100) {
        this.f461017q.setColor(UIUtils.getColor(getContext(), r100));
        invalidate();
    }

    public void setSimpleMultiCount(boolean r100) {
        this.L = r100;
    }

    public void setUnSelectedArrowColor(int r100) {
        this.f461024x = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_down_bold_outlined, UIUtils.getColor(getContext(), r100));
        invalidate();
    }

    public void setUnSelectedText(String r100) {
        this.f461001a = false;
        this.f461000J = r100;
        this.M = null;
        this.K = "";
        requestLayout();
        invalidate();
    }

    public void setUnSelectedTextColor(int r100) {
        this.f461016p.setColor(UIUtils.getColor(getContext(), r100));
        invalidate();
    }

    public SearchFilterViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getContentWidth();
        int r103 = getContentHeight();
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getMode(r100);
        int r106 = View.MeasureSpec.getSize(r101);
        int r107 = View.MeasureSpec.getMode(r101);
        if (r105 == Integer.MIN_VALUE) goto L6;
        if (r105 == 0) goto L7;
        r102 = r104;
    L7:
        if (r107 == Integer.MIN_VALUE) goto L10;
        if (r107 == 0) goto L11;
        r103 = r106;
    L11:
        setMeasuredDimension(r102, r103);
        return;
    L10:
        r103 = Math.min(r103, r106);
        goto L11
    L6:
        r102 = Math.min(r102, r104);
        goto L7
    }

    public SearchFilterViewV2(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f461001a = false;
        this.f461002b = false;
        this.f461003c = true;
        this.f461004d = false;
        this.f461005e = UIHelper.getColor(R.color.bg_filler);
        this.f461006f = UIHelper.getColor(R.color.bg_filler);
        this.f461007g = UIHelper.getColor(R.color.primary_fill_solid_02);
        this.f461008h = UIHelper.getColor(R.color.primary_fill_solid_02);
        this.f461015o = UIHelper.getColor(R.color.text_title);
        int r100 = UIHelper.getColor(R.color.primary_fill_default);
        this.f461021u = UIHelper.getColor(R.color.icon_n2);
        this.f461022v = UIHelper.getColor(R.color.primary_fill_default);
        this.N = 1;
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.filterCornerRadius});
        this.f461013m = r113.getDimensionPixelSize(0, 6);
        r113.recycle();
        UIUtils.getColor(r110, R.color.bg_filler);
        this.f461005e = UIUtils.getColor(r110, R.color.bg_filler);
        this.f461006f = UIUtils.getColor(r110, R.color.bg_filler);
        this.f461007g = UIUtils.getColor(r110, R.color.primary_fill_solid_02);
        this.f461008h = UIUtils.getColor(r110, R.color.primary_fill_solid_02);
        this.f461015o = UIUtils.getColor(r110, R.color.text_title);
        this.f461022v = UIUtils.getColor(r110, R.color.primary_fill_default);
        this.f461021u = UIUtils.getColor(r110, R.color.icon_n2);
        this.f461022v = UIUtils.getColor(r110, R.color.primary_fill_default);
        Context r114 = getContext();
        Rect r115 = U;
        this.A = new Rect(UIUtils.dp2px(r114, r115.left), UIUtils.dp2px(getContext(), r115.top), UIUtils.dp2px(getContext(), r115.right), UIUtils.dp2px(getContext(), r115.bottom));
        this.C = UIUtils.dp2px(getContext(), 4.0f);
        this.D = UIUtils.dp2px(getContext(), 8.0f);
        this.B = UIUtils.dp2px(getContext(), 4.0f);
        this.E = UIUtils.dp2px(getContext(), 16.0f);
        this.F = UIUtils.dp2px(getContext(), 6.0f);
        this.G = UIUtils.dp2px(getContext(), 1.0f);
        this.H = UIUtils.dp2px(getContext(), 10.0f);
        this.I = UIUtils.dp2px(getContext(), 16.0f);
        this.f461009i = new Paint();
        this.f461010j = new Paint();
        this.f461011k = new Paint();
        this.f461012l = new Paint();
        this.f461009i.setAntiAlias(true);
        this.f461009i.setStyle(Paint.Style.FILL);
        this.f461009i.setColor(this.f461005e);
        this.f461010j.setAntiAlias(true);
        this.f461010j.setStyle(Paint.Style.STROKE);
        this.f461010j.setStrokeWidth(this.G);
        this.f461010j.setColor(this.f461006f);
        this.f461011k.setAntiAlias(true);
        this.f461011k.setStyle(Paint.Style.FILL);
        this.f461011k.setColor(this.f461007g);
        this.f461012l.setAntiAlias(true);
        this.f461012l.setStyle(Paint.Style.STROKE);
        this.f461012l.setStrokeWidth(this.G);
        this.f461012l.setColor(this.f461008h);
        this.f461016p = new Paint();
        this.f461017q = new Paint();
        this.f461014n = UIUtils.sp2px(getContext(), 14.0f);
        this.f461016p.setAntiAlias(true);
        this.f461016p.setTextSize(this.f461014n);
        this.f461017q.setAntiAlias(true);
        this.f461017q.setTextSize(this.f461014n);
        this.f461016p.setColor(this.f461015o);
        this.f461017q.setColor(r100);
        this.f461019s = new Paint();
        this.f461020t = new Paint();
        this.f461019s.setColor(this.f461008h);
        this.f461019s.setAntiAlias(true);
        this.f461019s.setStyle(Paint.Style.STROKE);
        this.f461019s.setStrokeWidth(this.G);
        this.f461020t.setAntiAlias(true);
        this.f461023w = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_close_bold_outlined, this.f461022v);
        this.f461024x = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_down_bold_outlined, this.f461021u);
        this.R = new RectF();
        this.S = new RectF();
        setOnTouchListener(new dpc.a(this));
    }
}
