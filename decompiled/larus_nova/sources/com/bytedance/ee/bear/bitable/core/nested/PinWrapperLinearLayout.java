package com.bytedance.ee.bear.bitable.core.nested;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.byted.cast.common.CastMonitor;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002)*B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014J0\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0014J\u0006\u0010\u0016\u001a\u00020\u000bJ\u0019\u0010\u0017\u001a\u00020\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00060\u001bR\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0014J\b\u0010\u001f\u001a\u00020\u000bH\u0014J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rH\u0014J\u0012\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u000e\u0010&\u001a\b\u0018\u00010'R\u00020\u0000H\u0014J\u0018\u0010(\u001a\b\u0018\u00010'R\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010(\u001a\b\u0018\u00010'R\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010%H\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/nested/PinWrapperLinearLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onOffsetChangedListener", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "resetOffset", "applyOffset", "offset", "(Ljava/lang/Integer;)V", "getViewOffsetHelper", "Lcom/bytedance/ee/bear/bitable/core/nested/PinWrapperLinearLayout$VerticalViewOffsetHelper;", "view", "Landroid/view/View;", "onAttachedToWindow", "onDetachedFromWindow", "getChildDrawingOrder", "childCount", RXScreenCaptureService.KEY_INDEX, "checkLayoutParams", "p", "Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "Lcom/bytedance/ee/bear/bitable/core/nested/PinWrapperLinearLayout$LayoutParams;", "generateLayoutParams", "LayoutParams", "VerticalViewOffsetHelper", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PinWrapperLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f210579b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f210580a;

    public final class a extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f210581a;

        public a() {
            super(-1, -1);
        }

        public a(ViewGroup.LayoutParams r100) {
            super(r100);
        }

        public a(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101);
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.pin});
            this.f210581a = r102.getBoolean(0, false);
            r102.recycle();
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f210582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f210583b;

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f210582a = r100;
        }
    }

    public static final class c implements AppBarLayout.OnOffsetChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinWrapperLinearLayout f210584a;

        public c(PinWrapperLinearLayout r100) {
            this.f210584a = r100;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout r100, int r101) {
            PinWrapperLinearLayout r102 = this.f210584a;
            Integer r103 = Integer.valueOf(r101);
            int r104 = PinWrapperLinearLayout.f210579b;
            r102.a(r103);
        }
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        return (r100 - r101) - 1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object r100 = getParent();
        if ((r100 instanceof AppBarLayout) == false) goto L9;
        ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) r100));
        if (this.f210580a != null) goto L7;
        this.f210580a = new c(this);
    L7:
        ((AppBarLayout) r100).addOnOffsetChangedListener(this.f210580a);
        ViewCompat.requestApplyInsets(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ViewParent r100 = getParent();
        c r101 = this.f210580a;
        if (r101 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if ((r100 instanceof AppBarLayout) == false) goto L7;
        ((AppBarLayout) r100).removeOnOffsetChangedListener(r101);
        goto L7
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    public PinWrapperLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(Integer r110) {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L22;
        View r102 = getChildAt(r101);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        b r104 = null;
        if ((r103 instanceof a) == false) goto L7;
        a r105 = (a) r103;
    L8:
        if (r105 == null) goto L21;
        Object r106 = r102.getTag(R.id.view_offset_helper);
        if ((r106 instanceof b) == false) goto L12;
        r104 = (b) r106;
    L12:
        if (r104 != null) goto L15;
        r104 = new b(r102);
        r102.setTag(R.id.view_offset_helper, r104);
    L15:
        if (r105.f210581a == false) goto L21;
        if (r110 == null) goto L20;
        int r107 = RangesKt.coerceAtLeast((-r110.intValue()) - getTop(), 0);
        if (r104.f210583b == r107) goto L21;
        r104.f210583b = r107;
        View r108 = r104.f210582a;
        ViewCompat.offsetTopAndBottom(r108, r107 - r108.getTop());
        goto L21
    L20:
        View r109 = r104.f210582a;
        ViewCompat.offsetTopAndBottom(r109, r104.f210583b - r109.getTop());
    L21:
        r101 = r101 + 1;
        goto L3
    L7:
        r105 = null;
        goto L8
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof a;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new a(getContext(), r100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new a(getContext(), r100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new a(r100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new a(r100);
    }

    public PinWrapperLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setChildrenDrawingOrderEnabled(true);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        View r104 = getChildAt(r103);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.core.nested.PinWrapperLinearLayout.LayoutParams");
        if (((a) r105).f210581a == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        setMinimumHeight(r104.getMeasuredHeight());
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        a(null);
    }
}
