package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class SearchFilterView extends View {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Rect f460952z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f460953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f460954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f460955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f460956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f460957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f460958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f460959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f460960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f460961i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f460962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f460963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f460964l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f460965m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Paint f460966n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Paint f460967o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Paint f460968p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Paint f460969q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Rect f460970r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f460971s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f460972t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f460973u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f460974v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f460975w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List<Bitmap> f460976x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f460977y;

    private int getContentHeight() {
        Rect r100 = this.f460970r;
        int r101 = (r100.top + 0) + r100.bottom;
        if (TextUtils.isEmpty(this.f460975w) == true) goto L5;
        Paint.FontMetrics r102 = this.f460967o.getFontMetrics();
        float r103 = (r102.bottom - r102.top) + r102.leading;
    L7:
        if (CollectionUtils.isEmpty(this.f460976x) == true) goto L10;
        r103 = Math.max(r103, this.f460972t + (this.f460974v * 2.0f));
    L10:
        return (int) (r101 + r103);
    L5:
        r103 = 0.0f;
        goto L7
    }

    private int getContentWidth() {
        Rect r100 = this.f460970r;
        int r101 = (r100.left + 0) + r100.right;
        if (TextUtils.isEmpty(this.f460975w) == true) goto L6;
        r101 = (int) (r101 + this.f460967o.measureText(this.f460975w));
    L6:
        if (CollectionUtils.isEmpty(this.f460976x) == true) goto L11;
        int r102 = this.f460977y;
        if (r102 <= 0) goto L12;
        int r103 = (int) (r101 + this.f460971s);
        int r104 = Math.min(r102, this.f460976x.size());
        return (int) (r103 + (((this.f460972t + (this.f460974v * 2.0f)) * r104) - (this.f460973u * (r104 - 1))));
    L12:
        return r101;
    L11:
        return r101;
    }

    public final void a() {
        Context r100 = getContext();
        Rect r101 = f460952z;
        this.f460970r = new Rect(UIUtils.dp2px(r100, r101.left), UIUtils.dp2px(getContext(), r101.top), UIUtils.dp2px(getContext(), r101.right), UIUtils.dp2px(getContext(), r101.bottom));
        this.f460971s = UIUtils.dp2px(getContext(), 2.0f);
        this.f460972t = UIUtils.dp2px(getContext(), 16.0f);
        this.f460973u = UIUtils.dp2px(getContext(), 6.0f);
        this.f460974v = UIUtils.dp2px(getContext(), 1.0f);
        this.f460962j = UIUtils.dp2px(getContext(), 6.0f);
        this.f460958f = new Paint();
        this.f460959g = new Paint();
        this.f460960h = new Paint();
        this.f460961i = new Paint();
        this.f460958f.setAntiAlias(true);
        this.f460958f.setStyle(Paint.Style.FILL);
        this.f460958f.setColor(this.f460954b);
        this.f460959g.setAntiAlias(true);
        this.f460959g.setStyle(Paint.Style.STROKE);
        this.f460959g.setStrokeWidth(this.f460974v);
        this.f460959g.setColor(this.f460955c);
        this.f460960h.setAntiAlias(true);
        this.f460960h.setStyle(Paint.Style.FILL);
        this.f460960h.setColor(this.f460956d);
        this.f460961i.setAntiAlias(true);
        this.f460961i.setStyle(Paint.Style.STROKE);
        this.f460961i.setStrokeWidth(this.f460974v);
        this.f460961i.setColor(this.f460957e);
        this.f460966n = new Paint();
        this.f460967o = new Paint();
        this.f460963k = UIUtils.sp2px(getContext(), 14.0f);
        this.f460966n.setAntiAlias(true);
        this.f460966n.setTextSize(this.f460963k);
        this.f460967o.setAntiAlias(true);
        this.f460967o.setTextSize(this.f460963k);
        this.f460966n.setColor(this.f460964l);
        this.f460967o.setColor(this.f460965m);
        this.f460968p = new Paint();
        this.f460969q = new Paint();
        this.f460968p.setColor(this.f460957e);
        this.f460968p.setAntiAlias(true);
        this.f460968p.setStyle(Paint.Style.STROKE);
        this.f460968p.setStrokeWidth(this.f460974v);
        this.f460969q.setAntiAlias(true);
    }

    static {
        UIHelper.getColor(R.color.function_info_fill_solid_02);
        UIHelper.getColor(R.color.function_info_fill_solid_02);
        UIHelper.getColor(R.color.bg_float_overlay);
        UIHelper.getColor(R.color.bg_float_overlay);
        UIHelper.getColor(R.color.primary_fill_default);
        UIHelper.getColor(R.color.text_title);
        f460952z = new Rect(16, 6, 16, 6);
    }

    public SearchFilterView(Context r100) {
        super(r100);
        this.f460953a = false;
        this.f460954b = UIHelper.getColor(R.color.bg_float_overlay);
        this.f460955c = UIHelper.getColor(R.color.bg_float_overlay);
        this.f460956d = UIHelper.getColor(R.color.function_info_fill_solid_02);
        this.f460957e = UIHelper.getColor(R.color.function_info_fill_solid_02);
        this.f460964l = UIHelper.getColor(R.color.text_title);
        this.f460965m = UIHelper.getColor(R.color.primary_fill_default);
        this.f460977y = 3;
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f460953a == false) goto L5;
        Paint r100 = this.f460961i;
        Paint r101 = this.f460960h;
    L6:
        float r102 = this.f460974v;
        RectF r103 = new RectF(r102, r102, r110.getWidth() - this.f460974v, r110.getHeight() - this.f460974v);
        float r104 = this.f460962j;
        r110.drawRoundRect(r103, r104, r104, r101);
        float r105 = this.f460962j;
        r110.drawRoundRect(r103, r105, r105, r100);
        if (TextUtils.isEmpty(this.f460975w) == true) goto L15;
        if (this.f460953a == false) goto L12;
        Paint r106 = this.f460967o;
    L13:
        Paint.FontMetrics r107 = r106.getFontMetrics();
        float r108 = r110.getHeight() / 2;
        float r109 = r107.bottom;
        r110.drawText(this.f460975w, this.f460970r.left, (r108 + ((r109 - r107.top) / 2.0f)) - r109, r106);
        goto L15
    L12:
        r106 = this.f460966n;
    L15:
        if (CollectionUtils.isEmpty(this.f460976x) == true) goto L25;
        float r111 = ((r110.getWidth() - this.f460970r.right) - this.f460972t) - (this.f460974v * 2.0f);
        float r112 = (r110.getHeight() / 2) - ((this.f460972t + this.f460974v) / 2.0f);
        int r113 = Math.min(this.f460976x.size(), 3);
    L18:
        r113 = r113 - 1;
        if (r113 < 0) goto L29;
        int r114 = r110.saveLayer(0.0f, 0.0f, r110.getWidth(), r110.getHeight(), null, 31);
        Bitmap r115 = (Bitmap) ListProtector.get(this.f460976x, r113);
        if (r115 != null) goto L23;
        float r116 = this.f460972t + (this.f460974v * 2.0f);
        float r117 = this.f460973u;
    L24:
        r111 = r111 - (r116 - r117);
        goto L18
    L23:
        float r118 = this.f460972t + (this.f460974v * 2.0f);
        RectF r119 = new RectF(r111, r112, r111 + r118, r118 + r112);
        this.f460969q.setXfermode(null);
        r110.drawOval(r119, this.f460969q);
        this.f460969q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r110.drawBitmap(r115, null, r119, this.f460969q);
        this.f460969q.setXfermode(null);
        r110.restoreToCount(r114);
        r110.drawOval(r119, this.f460968p);
        r116 = this.f460972t + (this.f460974v * 2.0f);
        r117 = this.f460973u;
        goto L24
    L29:
        return;
    L25:
        return;
    L5:
        r100 = this.f460959g;
        r101 = this.f460958f;
        goto L6
    }

    public void setDisplayIconLimit(int r100) {
        this.f460977y = Math.max(0, r100);
        requestLayout();
    }

    public void setItemUnSelectedBgBorderColor(int r100) {
        this.f460959g.setColor(UIHelper.getColor(r100));
        invalidate();
    }

    public void setItemUnSelectedBgColor(int r100) {
        this.f460958f.setColor(UIHelper.getColor(r100));
        invalidate();
    }

    public void setPaddingRect(Rect r100) {
        this.f460970r = r100;
    }

    public void setUnSelectedText(String r100) {
        this.f460953a = false;
        this.f460975w = r100;
        this.f460976x = null;
        requestLayout();
    }

    public SearchFilterView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f460953a = false;
        this.f460954b = UIHelper.getColor(R.color.bg_float_overlay);
        this.f460955c = UIHelper.getColor(R.color.bg_float_overlay);
        this.f460956d = UIHelper.getColor(R.color.function_info_fill_solid_02);
        this.f460957e = UIHelper.getColor(R.color.function_info_fill_solid_02);
        this.f460964l = UIHelper.getColor(R.color.text_title);
        this.f460965m = UIHelper.getColor(R.color.primary_fill_default);
        this.f460977y = 3;
        a();
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

    public SearchFilterView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f460953a = false;
        this.f460954b = UIHelper.getColor(R.color.bg_float_overlay);
        this.f460955c = UIHelper.getColor(R.color.bg_float_overlay);
        this.f460956d = UIHelper.getColor(R.color.function_info_fill_solid_02);
        this.f460957e = UIHelper.getColor(R.color.function_info_fill_solid_02);
        this.f460964l = UIHelper.getColor(R.color.text_title);
        this.f460965m = UIHelper.getColor(R.color.primary_fill_default);
        this.f460977y = 3;
        a();
    }
}
