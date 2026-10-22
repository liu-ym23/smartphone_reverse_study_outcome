package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0016R*\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010#\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012¨\u0006$"}, d2 = {"Lcom/obric/oui/indicator/IndicatorImageDotView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/obric/oui/indicator/e;", "", "width", "", "setWidth", "horizontalMargin", "setHorizontalMargin", GXTemplateKey.FLEXBOX_MARGIN, "setStartMargin", "setEndMargin", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getDotColor", "()I", "setDotColor", "(I)V", "dotColor", "", "b", FaceService.girlLabel, "getCornerRadius", "()F", "setCornerRadius", "(F)V", "cornerRadius", "c", "getStrokeWidth", "setStrokeWidth", "strokeWidth", "d", "getStrokeColor", "setStrokeColor", "strokeColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class IndicatorImageDotView extends AppCompatImageView implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f401172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f401173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f401174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f401175d;

    public float getCornerRadius() {
        return this.f401173b;
    }

    public int getDotColor() {
        return this.f401172a;
    }

    public int getStrokeColor() {
        return this.f401175d;
    }

    public float getStrokeWidth() {
        return this.f401174c;
    }

    @Override // com.obric.oui.indicator.e
    public void setCornerRadius(float r100) {
        this.f401173b = r100;
    }

    @Override // com.obric.oui.indicator.e
    public void setDotColor(int r100) {
        if (this.f401172a == r100) goto L5;
        this.f401172a = r100;
    L5:
        setColorFilter(r100);
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
        this.f401175d = r100;
    }

    @Override // com.obric.oui.indicator.e
    public void setStrokeWidth(float r100) {
        this.f401174c = r100;
    }

    public void setWidth(int r100) {
        d.c(this, r100);
    }

    public IndicatorImageDotView(Context r100, Drawable r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f401172a = FakePickerAvatarCreator.GRAY;
        setImageDrawable(r101);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
}
