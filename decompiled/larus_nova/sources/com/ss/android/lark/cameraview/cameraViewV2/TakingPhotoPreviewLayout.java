package com.ss.android.lark.cameraview.cameraViewV2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.byted.cast.common.CastMonitor;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0014J0\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0014J(\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0002J(\u0010#\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0002R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ss/android/lark/cameraview/cameraViewV2/TakingPhotoPreviewLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "dp4", "dp10", "dp16", "dp20", "dp32", "dp42", "dp190", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "phoneHeightWidthRatioSmallerThan209", "parentWidth", "parentHeight", "padOrPhoneHeightWidthRatioBiggerThan209", "cameraview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TakingPhotoPreviewLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f410931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f410932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f410933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f410934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f410935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f410936g;

    public TakingPhotoPreviewLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public TakingPhotoPreviewLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        measureChildren(r100, r101);
        super.onMeasure(r100, r101);
    }

    public TakingPhotoPreviewLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f410930a = UIUtils.dp2px(getContext(), 4.0f);
        this.f410931b = UIUtils.dp2px(getContext(), 10.0f);
        this.f410932c = UIUtils.dp2px(getContext(), 16.0f);
        this.f410933d = UIUtils.dp2px(getContext(), 20.0f);
        this.f410934e = UIUtils.dp2px(getContext(), 32.0f);
        this.f410935f = UIUtils.dp2px(getContext(), 42.0f);
        this.f410936g = UIUtils.dp2px(getContext(), 190.0f);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r210, int r211, int r212, int r213) {
        if (getChildCount() == 3) goto L5;
        return;
    L5:
        ViewParent r100 = getParent();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getMeasuredWidth();
        int r103 = r101.getMeasuredHeight();
        float r104 = r103 / (r102 + 0.0f);
        boolean r105 = DeviceUtils.isPad();
        boolean r106 = false;
        if (r104 > 2.2222223f) goto L9;
        if (r105 == true) goto L9;
        View r107 = getChildAt(0);
        View r108 = getChildAt(1);
        View r109 = getChildAt(2);
        int r111 = r107.getMeasuredWidth();
        int r112 = r107.getMeasuredHeight();
        int r113 = r109.getMeasuredWidth();
        int r114 = r109.getMeasuredHeight();
        int r115 = r108.getMeasuredWidth();
        int r116 = r108.getMeasuredHeight();
        int r117 = ((r102 - r111) / 2) + r210;
        int r118 = r112 + r211;
        r107.layout(r117, r211, r111 + r117, r118);
        int r119 = Math.min(this.f410930a + r118, r103 - r114);
        r109.layout(r210, r119, r113 + r210, r114 + r119);
        int r120 = this.f410933d;
        int r121 = Math.min(r118 - r120, r119 - r120);
        r108.layout(r210, r121 - r116, r115 + r210, r121);
        return;
    L9:
        View r122 = getChildAt(0);
        View r123 = getChildAt(1);
        View r124 = getChildAt(2);
        int r125 = r122.getMeasuredWidth();
        int r126 = r122.getMeasuredHeight();
        int r127 = r124.getMeasuredWidth();
        int r128 = r124.getMeasuredHeight();
        int r129 = r123.getMeasuredWidth();
        int r130 = r123.getMeasuredHeight();
        int r131 = (r211 + ((r103 - r126) / 2)) + r126;
        int r132 = ((r102 - r125) / 2) + r210;
        r122.layout(r132, r131 - r126, r125 + r132, r131);
        int r133 = this.f410931b;
        int r134 = this.f410936g;
        int r135 = r103 - r131;
        if (r133 > r135) goto L13;
        if (r135 > r134) goto L13;
        r106 = true;
    L13:
        if (r106 == false) goto L15;
        int r136 = r131 - this.f410934e;
    L16:
        int r137 = r136 - r128;
        r124.layout(r210, r137, r210 + r127, r136);
        int r138 = r137 - this.f410932c;
        r123.layout(r210, r138 - r130, r210 + r129, r138);
        return;
    L15:
        r136 = r103 - this.f410935f;
        goto L16
    }
}
