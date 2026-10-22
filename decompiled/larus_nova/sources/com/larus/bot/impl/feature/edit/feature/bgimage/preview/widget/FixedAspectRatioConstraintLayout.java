package com.larus.bot.impl.feature.edit.feature.bgimage.preview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.larus.utils.w0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0014J\"\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\nH\u0002R\u001a\u0010\f\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/widget/FixedAspectRatioConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aspectRatio", "", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "radiusHeightRatio", "getRadiusHeightRatio", "setRadiusHeightRatio", "layoutHeight", "getLayoutHeight", "()I", "setLayoutHeight", "(I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "initAttrs", "setupRadius", "height", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FixedAspectRatioConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f319036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f319037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f319038c;

    public final float getAspectRatio() {
        return this.f319036a;
    }

    public final int getLayoutHeight() {
        return this.f319038c;
    }

    public final float getRadiusHeightRatio() {
        return this.f319037b;
    }

    public FixedAspectRatioConstraintLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        R5(r100, null, 0);
    }

    private final void setupRadius(int r100) {
        float r101 = this.f319037b;
        if (r101 <= 0.0f) goto L6;
        w0.e(this, (int) ((r101 * r100) + 0.5f));
        return;
    }

    public final void setAspectRatio(float r100) {
        this.f319036a = r100;
    }

    public final void setLayoutHeight(int r100) {
        this.f319038c = r100;
    }

    public final void setRadiusHeightRatio(float r100) {
        this.f319037b = r100;
    }

    public FixedAspectRatioConstraintLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        R5(r100, r101, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r101);
        this.f319038c = r102;
        setupRadius(r102);
        float r103 = this.f319036a;
        if (r103 <= 0.0f) goto L5;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) ((this.f319038c * r103) + 0.5f), 1073741824), r101);
        return;
    L5:
        super.onMeasure(r100, r101);
    }

    public FixedAspectRatioConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        R5(r100, r101, r102);
    }

    public final void R5(Context r100, AttributeSet r101, int r102) {
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_aspect_ratio, R.attr.larus_radius_height_ratio}, r102, r102);
        this.f319036a = r103.getFloat(0, this.f319036a);
        this.f319037b = r103.getFloat(1, this.f319037b);
        r103.recycle();
    }
}
