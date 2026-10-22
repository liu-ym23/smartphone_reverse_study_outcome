package com.ixigua.lib.list.block;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/ixigua/lib/list/block/BlockContainer;", "Landroid/view/ViewGroup;", "", "defaultHeight", "", "setDefaultHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liblist_release"}, k = 1, mv = {1, 4, 0})
public final class BlockContainer extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f278509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f278510b;

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        this.f278510b = true;
        super.removeAllViews();
    }

    public BlockContainer(Context r100) {
        super(r100);
        this.f278510b = true;
    }

    public final void a(List<? extends View> r100) {
        Iterator r101 = ((ArrayList) r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        View r102 = (View) r101.next();
        addViewInLayout(r102, -1, r102.getLayoutParams(), true);
        goto L4
    L6:
        this.f278510b = false;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    public final void setDefaultHeight(int r100) {
        this.f278509a = r100;
    }

    public BlockContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f278510b = true;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f278510b == true) goto L5;
    L7:
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = getChildCount();
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r104 >= r103) goto L17;
        View r106 = getChildAt(r104);
        if (r106.getVisibility() == 8) goto L16;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L15;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        measureChild(r106, View.MeasureSpec.makeMeasureSpec((r102 - r108.leftMargin) - r108.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        r105 = r105 + ((r106.getMeasuredHeight() + r108.topMargin) + r108.bottomMargin);
        goto L16
    L15:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L16:
        r104 = r104 + 1;
        goto L8
    L17:
        setMeasuredDimension(r102, r105);
        return;
    L5:
        if (this.f278509a <= 0) goto L7;
        setMeasuredDimension(View.MeasureSpec.getSize(r100), this.f278509a);
    }

    public BlockContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f278510b = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r106 >= r105) goto L12;
        View r108 = getChildAt(r106);
        if (r108.getVisibility() == 8) goto L11;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L10;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
        int r111 = r108.getMeasuredWidth();
        int r112 = r108.getMeasuredHeight();
        int r113 = r107 + r110.topMargin;
        int r114 = r110.leftMargin;
        int r115 = r112 + r113;
        r108.layout(r114, r113, r111 + r114, r115);
        r107 = r115 + r110.bottomMargin;
        goto L11
    L10:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L11:
        r106 = r106 + 1;
        goto L3
    }
}
