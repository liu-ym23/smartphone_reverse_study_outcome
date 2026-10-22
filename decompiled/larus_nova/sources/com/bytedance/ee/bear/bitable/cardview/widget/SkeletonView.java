package com.bytedance.ee.bear.bitable.cardview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u000e\u0010'\u001a\u00020(2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0014J\b\u0010<\u001a\u00020\rH\u0002J\b\u0010=\u001a\u00020\rH\u0002J\b\u0010>\u001a\u00020\rH\u0002J\b\u0010?\u001a\u00020\rH\u0002J\u000e\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020\u001aJ\u0010\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020DH\u0014J \u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020\r2\u0006\u0010C\u001a\u00020DH\u0002J8\u0010H\u001a\u00020(2\u0006\u0010C\u001a\u00020D2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\r2\u0006\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\u0007H\u0002J8\u0010N\u001a\u00020(2\u0006\u0010C\u001a\u00020D2\u0006\u0010O\u001a\u00020\r2\u0006\u0010F\u001a\u00020\r2\u0006\u0010P\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010M\u001a\u00020\u0007H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010 R\u0014\u0010%\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010 R\u0014\u0010)\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010 R\u000e\u0010+\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/bitable/cardview/widget/SkeletonView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "imageSize", "", "imageMarginRight", "imageRadius", "titleHeight", "titleWightFactor", "subTitleMarginTop", "subTitleHeight", "subTitleWidthFactor", "itemMarginTop", "itemHeight", "itemHorizontalSpace", "itemVerticalSpace", "enableBorder", "", "borderWidth", "getBorderWidth", "()F", "titleColor", "getTitleColor", "()I", "summaryColor", "getSummaryColor", "itemColor", "getItemColor", "borderColor", "getBorderColor", "setEnableBorder", "", "backgroudColor", "getBackgroudColor", "BORDER_RADIUS", "borderRect", "Landroid/graphics/RectF;", "itemRowCount", "titleEnable", "subTitleEnable", "imageEnable", "itemEnable", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "getImageSpaceHeight", "getTitleSpaceHeight", "getSuTitleSpaceHeight", "getItemSpaceHeight", "onImageEnableChange", "enabled", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawItem", "startX", "itemY", "drawReat", "x", "y", "size", "radius", "color", "drawHorizontalLineCompat", "lineWidth", "startY", "lineLength", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SkeletonView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f209280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f209281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f209282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f209283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f209284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f209285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f209286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f209287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f209288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f209289j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f209290k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f209291l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f209292m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f209293n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f209294o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f209295p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f209296q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f209297r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f209298s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f209299t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f209300u;

    private final int getBorderColor() {
        if (this.f209292m == false) goto L9;
        if (isSelected() == true) goto L9;
        return getContext().getResources().getColor(R.color.line_border_card);
    L9:
        return getContext().getResources().getColor(R.color.primary_pri_500);
    }

    private final float getImageSpaceHeight() {
        if (this.f209298s == true) goto L5;
        return 0.0f;
    L5:
        return this.f209280a;
    }

    private final float getItemSpaceHeight() {
        if (this.f209299t == true) goto L5;
        return 0.0f;
    L5:
        return ((this.f209289j * 2) + this.f209291l) + this.f209288i;
    }

    private final Paint getPaint() {
        return (Paint) this.f209300u.getValue();
    }

    private final float getSuTitleSpaceHeight() {
        if (this.f209297r == true) goto L5;
        return 0.0f;
    L5:
        return this.f209285f + this.f209286g;
    }

    private final float getTitleSpaceHeight() {
        if (this.f209296q == true) goto L5;
        return 0.0f;
    L5:
        return this.f209283d;
    }

    private final int getBackgroudColor() {
        return getContext().getResources().getColor(R.color.bg_body);
    }

    private final float getBorderWidth() {
        if (isSelected() == false) goto L5;
        int r100 = 2;
    L7:
        return n.d(r100);
    L5:
        r100 = 1;
        goto L7
    }

    private final int getItemColor() {
        Resources r100 = getContext().getResources();
        if (isSelected() == false) goto L5;
        int r101 = R.color.ud_B200;
    L7:
        return r100.getColor(r101);
    L5:
        r101 = R.color.ud_N300;
        goto L7
    }

    private final int getSummaryColor() {
        Resources r100 = getContext().getResources();
        if (isSelected() == false) goto L5;
        int r101 = R.color.ud_B200;
    L7:
        return r100.getColor(r101);
    L5:
        r101 = R.color.ud_N300;
        goto L7
    }

    private final int getTitleColor() {
        Resources r100 = getContext().getResources();
        if (isSelected() == false) goto L5;
        int r101 = R.color.ud_B400;
    L7:
        return r100.getColor(r101);
    L5:
        r101 = R.color.ud_N400;
        goto L7
    }

    public SkeletonView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, -1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = getPaddingLeft();
        float r101 = getPaddingTop();
        getPaint().setStrokeWidth(getBorderWidth());
        getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        getPaint().setColor(getBackgroudColor());
        RectF r102 = this.f209294o;
        float r103 = this.f209293n;
        r110.drawRoundRect(r102, r103, r103, getPaint());
        if (isSelected() == false) goto L5;
    L6:
        getPaint().setStrokeWidth(getBorderWidth());
        getPaint().setStyle(Paint.Style.STROKE);
        getPaint().setColor(getBorderColor());
        RectF r104 = this.f209294o;
        float r105 = this.f209293n;
        r110.drawRoundRect(r104, r105, r105, getPaint());
    L8:
        if (this.f209298s == false) goto L11;
        float r106 = this.f209280a;
        float r107 = this.f209282c;
        int r108 = getItemColor();
        getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        getPaint().setColor(r108);
        r110.drawRoundRect(r100, r101, r100 + r106, r101 + r106, r107, r107, getPaint());
        r100 = r100 + (this.f209280a + this.f209281b);
    L11:
        if (this.f209296q == false) goto L14;
        float r111 = 2;
        float r109 = r101 + (this.f209283d / r111);
        float r112 = r100;
        a(r110, this.f209283d, r112, r109, ((getWidth() - getPaddingLeft()) - getPaddingRight()) * this.f209284e, getTitleColor());
        r101 = r109 + (this.f209283d / r111);
    L14:
        if (this.f209297r == false) goto L17;
        float r113 = 2;
        float r114 = (r101 + this.f209285f) + (this.f209286g / r113);
        float r115 = r100;
        a(r110, this.f209286g, r115, r114, ((getWidth() - getPaddingLeft()) - getPaddingRight()) * this.f209287h, getSummaryColor());
        r101 = r114 + (this.f209286g / r113);
    L17:
        if (this.f209299t == false) goto L20;
        float r116 = 2;
        float r117 = ((r101 + (this.f209286g / r116)) + this.f209288i) + (this.f209289j / r116);
        b(r100, r117, r110);
        b(r100, r117 + (this.f209289j + this.f209291l), r110);
        return;
    L20:
        return;
    L5:
        if (this.f209292m == false) goto L8;
        goto L6
    }

    public final void setEnableBorder(boolean r100) {
        this.f209292m = r100;
    }

    public SkeletonView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, -1);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        float r102 = (getPaddingTop() + Math.max((getTitleSpaceHeight() + getSuTitleSpaceHeight()) + getItemSpaceHeight(), getImageSpaceHeight())) + getPaddingBottom();
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec((int) r102, 1073741824));
        this.f209294o.left = getBorderWidth();
        this.f209294o.top = getBorderWidth();
        this.f209294o.right = View.MeasureSpec.getSize(r100) - getBorderWidth();
        this.f209294o.bottom = r102 - getBorderWidth();
    }

    public SkeletonView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f209280a = n.d(16);
        this.f209281b = n.d(6);
        this.f209282c = n.d(4);
        this.f209283d = n.d(4);
        this.f209284e = 0.5f;
        this.f209285f = n.d(5);
        this.f209286g = n.d(4);
        this.f209287h = 0.4f;
        this.f209288i = n.d(5);
        this.f209289j = n.d(4);
        this.f209290k = n.d(4);
        this.f209291l = n.d(4);
        this.f209293n = n.d(6);
        this.f209294o = new RectF();
        this.f209300u = LazyKt.lazy(SkeletonView$paint$2.INSTANCE);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.imageEnabled, R.attr.itemEnabled, R.attr.rowCount, R.attr.sutitleEnabled, R.attr.titleEnabled}, 0, 0);
        this.f209295p = r103.getInt(2, 3);
        this.f209296q = r103.getBoolean(4, true);
        this.f209297r = r103.getBoolean(3, true);
        this.f209298s = r103.getBoolean(0, true);
        this.f209299t = r103.getBoolean(1, true);
        r103.recycle();
    }

    public final void b(float r110, float r111, Canvas r112) {
        float r100 = (getWidth() - r110) - getPaddingRight();
        int r101 = this.f209295p;
        float r102 = (r100 - ((r101 - 1) * this.f209290k)) / r101;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        a(r112, this.f209289j, r110, r111, r102, getItemColor());
        r110 = r110 + (this.f209290k + r102);
        r103 = r103 + 1;
        goto L3
    }

    public final void a(Canvas r100, float r101, float r102, float r110, float r111, int r112) {
        getPaint().setStyle(Paint.Style.STROKE);
        getPaint().setStrokeWidth(r101);
        getPaint().setColor(r112);
        float r103 = r101 / 2;
        r100.drawLine(r102 + r103, r110, (r102 + r111) - r103, r110, getPaint());
    }
}
