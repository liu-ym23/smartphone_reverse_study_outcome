package com.ss.android.lark.widget.quick_sidebar.tipsview;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0014J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0012J\u0010\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b*\u0010,¨\u0006-"}, d2 = {"Lcom/ss/android/lark/widget/quick_sidebar/tipsview/QuickSideBarTipsItemView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCornerRadius", "mBackgroundPath", "Landroid/graphics/Path;", "mBackgroundRect", "Landroid/graphics/RectF;", "mBackgroundPaint", "Landroid/graphics/Paint;", "mText", "", "mIcon", "Landroid/graphics/drawable/Drawable;", "mTextPaint", "mWidth", "mItemHeight", "mTextSize", "", "mTextColor", "mBackgroundColor", "mCenterTextStartX", "mCenterTextStartY", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setText", "text", "setIcon", "icon", "isRtl", "", "()Z", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickSideBarTipsItemView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f448102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f448103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f448104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f448105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f448106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f448107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f448108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f448109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f448110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f448111j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f448112k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f448113l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f448114m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f448115n;

    public QuickSideBarTipsItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public QuickSideBarTipsItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (TextUtils.isEmpty(this.f448106e) == true) goto L5;
    L7:
        r110.drawColor(getResources().getColor(R.color.transparent));
        this.f448104c.set(0.0f, 0.0f, this.f448109h, this.f448110i);
        if (getContext().getResources().getConfiguration().getLayoutDirection() != 1) goto L10;
        boolean r100 = true;
    L12:
        if (r100 == false) goto L14;
        int r101 = this.f448102a;
        float[] r102 = {r101, r101, r101, r101, r101, r101, 0.0f, 0.0f};
    L15:
        this.f448103b.addRoundRect(this.f448104c, r102, Path.Direction.CW);
        Path r103 = this.f448103b;
        Paint r104 = this.f448105d;
        Paint r105 = null;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mBackgroundPaint");
        r104 = null;
    L18:
        r110.drawPath(r103, r104);
        if (TextUtils.isEmpty(this.f448106e) == true) goto L25;
        String r106 = this.f448106e;
        float r107 = this.f448114m;
        float r108 = this.f448115n;
        Paint r109 = this.f448108g;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
    L24:
        r110.drawText(r106, r107, r108, r105);
        goto L25
    L23:
        r105 = r109;
    L25:
        Drawable r111 = this.f448107f;
        if (r111 == null) goto L29;
        r111.getBounds().offsetTo((this.f448109h - r111.getBounds().width()) / 2, (this.f448110i - r111.getBounds().height()) / 2);
        r111.draw(r110);
        return;
    L29:
        return;
    L14:
        int r112 = this.f448102a;
        r102 = new float[]{r112, r112, r112, r112, 0.0f, 0.0f, r112, r112};
        goto L15
    L10:
        r100 = false;
        goto L12
    L5:
        if (this.f448107f != null) goto L7;
    }

    public final void setIcon(Drawable r100) {
        this.f448106e = "";
        this.f448107f = r100;
        invalidate();
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f448106e = r100;
        Paint r101 = null;
        this.f448107f = null;
        Rect r102 = new Rect();
        Paint r103 = this.f448108g;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
    L6:
        String r104 = this.f448106e;
        r101.getTextBounds(r104, 0, r104.length(), r102);
        this.f448114m = (int) (((double) (this.f448109h - r102.width())) * 0.5d);
        this.f448115n = this.f448110i - r102.height();
        invalidate();
        return;
    L5:
        r101 = r103;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        this.f448109h = r102;
        this.f448110i = r102;
        this.f448102a = (int) (((double) r102) * 0.5d);
    }

    public QuickSideBarTipsItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f448103b = new Path();
        this.f448104c = new RectF();
        this.f448106e = "";
        this.f448112k = r100.getResources().getColor(R.color.black);
        this.f448113l = r100.getResources().getColor(R.color.darker_gray);
        this.f448111j = r100.getResources().getDimension(com.larus.nova.R.dimen.textSize_quicksidebartips);
        if (r101 == null) goto L5;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.sidebarBackgroundColor, com.larus.nova.R.attr.sidebarItemHeight, com.larus.nova.R.attr.sidebarTextColor, com.larus.nova.R.attr.sidebarTextColorChoose, com.larus.nova.R.attr.sidebarTextSize, com.larus.nova.R.attr.sidebarTextSizeChoose});
        this.f448112k = r103.getColor(2, this.f448112k);
        this.f448113l = r103.getColor(0, this.f448113l);
        this.f448111j = r103.getDimension(4, this.f448111j);
        r103.recycle();
    L5:
        this.f448105d = new Paint(1);
        this.f448108g = new Paint(1);
        Paint r104 = this.f448105d;
        Paint r105 = null;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mBackgroundPaint");
        r104 = null;
    L8:
        r104.setColor(this.f448113l);
        Paint r106 = this.f448108g;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
        r106 = null;
    L11:
        r106.setColor(this.f448112k);
        Paint r107 = this.f448108g;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
    L15:
        r105.setTextSize(this.f448111j);
        return;
    L14:
        r105 = r107;
        goto L15
    }

    public /* synthetic */ QuickSideBarTipsItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
