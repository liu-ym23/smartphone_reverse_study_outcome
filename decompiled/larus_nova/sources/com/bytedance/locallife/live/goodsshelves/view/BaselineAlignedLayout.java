package com.bytedance.locallife.live.goodsshelves.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/view/BaselineAlignedLayout;", "Landroid/view/ViewGroup;", "", "getBaseline", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class BaselineAlignedLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f260135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f260136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f260137c;

    public static final class a {
    }

    static {
    }

    public BaselineAlignedLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaselineAlignedLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f260137c;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ViewGroup.MarginLayoutParams(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = getPaddingLeft() + getPaddingRight();
        int r101 = getPaddingTop() + getPaddingBottom();
        int r102 = getChildCount();
        int r103 = 0;
        int r104 = r100;
        int r112 = r101;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
    L4:
        if (r113 >= r102) goto L13;
        View r116 = getChildAt(r113);
        if (r116.getVisibility() == 8) goto L11;
        ViewGroup.LayoutParams r105 = r116.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r105;
        measureChildWithMargins(r116, r110, 0, r111, 0);
        if (this.f260135a != 0) goto L10;
        r104 = r104 + ((r116.getMeasuredWidth() + r117.leftMargin) + r117.rightMargin);
        r115 = Math.max(r115, (r116.getMeasuredHeight() + r117.topMargin) + r117.bottomMargin);
        goto L11
    L10:
        r112 = r112 + ((r116.getMeasuredHeight() + r117.topMargin) + r117.bottomMargin);
        r114 = Math.max(r114, (r116.getMeasuredWidth() + r117.leftMargin) + r117.rightMargin);
    L11:
        r113 = r113 + 1;
        goto L4
    L13:
        if (this.f260135a != 0) goto L15;
        r112 = (getPaddingTop() + getPaddingBottom()) + r115;
    L16:
        setMeasuredDimension(ViewGroup.resolveSize(r104, r110), ViewGroup.resolveSize(r112, r111));
        this.f260137c = -1;
        int r106 = this.f260136b;
        if (r106 >= 0) goto L19;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == false) goto L39;
        View r108 = getChildAt(r106);
        if (r108.getVisibility() == 8) goto L48;
        int r109 = r108.getBaseline();
        if (r109 != (-1)) goto L28;
        return;
    L28:
        if (this.f260135a != 0) goto L30;
        this.f260137c = getPaddingTop() + r109;
        return;
    L30:
        int r118 = getPaddingTop();
        int r119 = getChildCount();
    L31:
        if (r103 >= r119) goto L52;
        View r120 = getChildAt(r103);
        if (r120.getVisibility() == 8) goto L38;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) r121;
        int r123 = r118 + r122.topMargin;
        if (r103 == r106) goto L36;
        r118 = r123 + (r120.getMeasuredHeight() + r122.bottomMargin);
        goto L38
    L36:
        this.f260137c = r123 + r109;
        return;
    L38:
        r103 = r103 + 1;
        goto L31
    L52:
        return;
    L48:
        return;
    L39:
        return;
    L19:
        if (r106 >= getChildCount()) goto L21;
        r107 = true;
        goto L22
    L15:
        r104 = (getPaddingLeft() + getPaddingRight()) + r114;
        goto L16
    }

    public BaselineAlignedLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f260136b = -1;
        this.f260137c = -1;
        if (r101 == null) goto L6;
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.baselineAlignedChildIndex, R.attr.baselineOrientation}, r102, 0);
        this.f260135a = r103.getInt(1, 0);
        this.f260136b = r103.getInt(0, -1);
        r103.recycle();
        return;
    }

    public /* synthetic */ BaselineAlignedLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r110, int r111, int r112) {
        int r113 = 0;
        if (this.f260135a != 0) goto L19;
        int r102 = getPaddingLeft();
        int r114 = this.f260137c;
        int r103 = getChildCount();
    L5:
        if (r113 >= r103) goto L25;
        View r104 = getChildAt(r113);
        if (r104.getVisibility() == 8) goto L18;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        int r107 = r102 + r106.leftMargin;
        if (r114 != (-1)) goto L11;
    L13:
        int r108 = getPaddingTop();
        int r109 = (getMeasuredHeight() - getPaddingBottom()) - r108;
        int r115 = r104.getMeasuredHeight();
        if (r109 <= 0) goto L16;
        int r116 = r109 - r115;
        int r117 = r106.topMargin;
        int r118 = (r108 + (((r116 - r117) - r106.bottomMargin) / 2)) + r117;
    L17:
        r104.layout(r107, r118, r104.getMeasuredWidth() + r107, r104.getMeasuredHeight() + r118);
        r102 = (r107 + r104.getMeasuredWidth()) + r106.rightMargin;
        goto L18
    L16:
        r118 = getPaddingTop() + r106.topMargin;
        goto L17
    L11:
        if (r104.getBaseline() == (-1)) goto L13;
        r118 = r114 - r104.getBaseline();
    L18:
        r113 = r113 + 1;
        goto L5
    L25:
        return;
    L19:
        int r119 = getPaddingTop();
        int r120 = getChildCount();
    L20:
        if (r113 >= r120) goto L32;
        View r121 = getChildAt(r113);
        if (r121.getVisibility() == 8) goto L24;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r122;
        int r124 = r119 + r123.topMargin;
        int r125 = getPaddingLeft() + r123.leftMargin;
        r121.layout(r125, r124, r121.getMeasuredWidth() + r125, r121.getMeasuredHeight() + r124);
        r119 = (r124 + r121.getMeasuredHeight()) + r123.bottomMargin;
    L24:
        r113 = r113 + 1;
        goto L20
    }
}
