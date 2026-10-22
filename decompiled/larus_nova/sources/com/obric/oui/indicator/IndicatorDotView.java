package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.obric.oui.common.style.r;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0016R*\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R*\u0010\u001f\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00188\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001e¨\u0006+"}, d2 = {"Lcom/obric/oui/indicator/IndicatorDotView;", "Landroid/view/View;", "Lcom/obric/oui/indicator/e;", "", "width", "", "setWidth", "horizontalMargin", "setHorizontalMargin", GXTemplateKey.FLEXBOX_MARGIN, "setStartMargin", "setEndMargin", "value", "e", "I", "getDotColor", "()I", "setDotColor", "(I)V", "dotColor", "f", "getStrokeColor", "setStrokeColor", "strokeColor", "", ce.f26391f, FaceService.girlLabel, "getStrokeWidth", "()F", "setStrokeWidth", "(F)V", "strokeWidth", "h", "getCornerRadius", "setCornerRadius", "cornerRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class IndicatorDotView extends View implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f401157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f401158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f401159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f401160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f401161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f401162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f401163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f401164h;

    public IndicatorDotView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IndicatorDotView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public float getCornerRadius() {
        return this.f401164h;
    }

    public int getDotColor() {
        return this.f401161e;
    }

    public int getStrokeColor() {
        return this.f401162f;
    }

    public float getStrokeWidth() {
        return this.f401163g;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f401157a.set(0.0f, 0.0f, getWidth(), getHeight());
        r.e(r100, this.f401157a, getCornerRadius(), this.f401159c);
        if (getStrokeWidth() <= 0.0f) goto L6;
        float r101 = 2;
        this.f401158b.set(getStrokeWidth() / r101, getStrokeWidth() / r101, getWidth() - (getStrokeWidth() / r101), getHeight() - (getStrokeWidth() / r101));
        r.e(r100, this.f401158b, getCornerRadius(), this.f401160d);
        return;
    }

    @Override // com.obric.oui.indicator.e
    public void setCornerRadius(float r100) {
        this.f401164h = r100;
    }

    @Override // com.obric.oui.indicator.e
    public void setDotColor(int r100) {
        if (this.f401161e == r100) goto L5;
        this.f401161e = r100;
    L5:
        this.f401159c.setColor(r100);
    }

    @Override // com.obric.oui.indicator.e
    public void setEndMargin(int r100) {
        ViewGroup.LayoutParams r101 = getLayoutParams();
        ViewGroup.LayoutParams r102 = null;
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r103 == null) goto L9;
        r103.setMarginEnd(r100);
        requestLayout();
        r102 = r103;
    L9:
        setLayoutParams(r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.obric.oui.indicator.e
    public void setHorizontalMargin(int r100) {
        d.a(this, r100);
    }

    @Override // com.obric.oui.indicator.e
    public void setStartMargin(int r100) {
        ViewGroup.LayoutParams r101 = getLayoutParams();
        ViewGroup.LayoutParams r102 = null;
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r103 == null) goto L9;
        r103.setMarginStart(r100);
        requestLayout();
        r102 = r103;
    L9:
        setLayoutParams(r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.obric.oui.indicator.e
    public void setStrokeColor(int r100) {
        if (this.f401162f == r100) goto L5;
        this.f401162f = r100;
    L5:
        this.f401160d.setColor(r100);
    }

    @Override // com.obric.oui.indicator.e
    public void setStrokeWidth(float r100) {
        if (this.f401163g != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        this.f401163g = r100;
    L8:
        this.f401160d.setStrokeWidth(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setWidth(int r100) {
        d.c(this, r100);
    }

    public IndicatorDotView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f401157a = new RectF();
        this.f401158b = new RectF();
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.FILL);
        this.f401159c = r103;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.STROKE);
        this.f401160d = r104;
        this.f401161e = FakePickerAvatarCreator.GRAY;
    }

    public /* synthetic */ IndicatorDotView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
