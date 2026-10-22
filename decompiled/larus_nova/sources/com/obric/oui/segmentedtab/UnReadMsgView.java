package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/segmentedtab/UnReadMsgView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "cornerRadius", "", "setCornerRadius", "strokeWidth", "setStrokeWidth", "backgroundColor", "setBackgroundColor", "strokeColor", "setStrokeColor", "", "isRadiusHalfHeight", "setIsRadiusHalfHeight", "isWidthHeightEqual", "setIsWidthHeightEqual", "getBackgroundColor", "getCornerRadius", "getStrokeWidth", "getStrokeColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class UnReadMsgView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientDrawable f402748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f402749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f402750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f402751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f402752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f402753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f402754g;

    public UnReadMsgView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UnReadMsgView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void x() {
        StateListDrawable r100 = new StateListDrawable();
        GradientDrawable r101 = this.f402748a;
        int r102 = this.f402749b;
        int r103 = this.f402752e;
        r101.setColor(r102);
        r101.setCornerRadius(this.f402750c);
        r101.setStroke(this.f402751d, r103);
        r100.addState(new int[]{-16842919}, this.f402748a);
        setBackground(r100);
    }

    public final int getBackgroundColor() {
        return this.f402749b;
    }

    public final int getCornerRadius() {
        return this.f402750c;
    }

    public final int getStrokeColor() {
        return this.f402752e;
    }

    public final int getStrokeWidth() {
        return this.f402751d;
    }

    private final void setCornerRadius(int r100) {
        Resources r101 = getContext().getResources();
        this.f402750c = (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
        x();
    }

    private final void setStrokeWidth(int r100) {
        Resources r101 = getContext().getResources();
        this.f402751d = (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
        x();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        this.f402749b = r100;
        x();
    }

    public final void setIsRadiusHalfHeight(boolean r100) {
        this.f402753f = r100;
        x();
    }

    public final void setIsWidthHeightEqual(boolean r100) {
        this.f402754g = r100;
        x();
    }

    public final void setStrokeColor(int r100) {
        this.f402752e = r100;
        x();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f402754g == true) goto L5;
    L10:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (getWidth() <= 0) goto L10;
        if (getHeight() <= 0) goto L10;
        int r102 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(getWidth(), getHeight()), 1073741824);
        super.onMeasure(r102, r102);
    }

    public UnReadMsgView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402748a = new GradientDrawable();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.mv_backgroundColor, R.attr.mv_cornerRadius, R.attr.mv_isRadiusHalfHeight, R.attr.mv_isWidthHeightEqual, R.attr.mv_strokeColor, R.attr.mv_strokeWidth});
        this.f402749b = r103.getColor(0, 0);
        this.f402750c = r103.getDimensionPixelSize(1, 0);
        this.f402751d = r103.getDimensionPixelSize(5, 0);
        this.f402752e = r103.getColor(4, 0);
        this.f402753f = r103.getBoolean(2, false);
        this.f402754g = r103.getBoolean(3, false);
        r103.recycle();
    }

    public /* synthetic */ UnReadMsgView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f402753f == false) goto L5;
        setCornerRadius(getHeight() / 2);
        return;
    L5:
        x();
    }
}
