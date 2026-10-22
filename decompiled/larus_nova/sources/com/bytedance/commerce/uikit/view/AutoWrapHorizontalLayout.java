package com.bytedance.commerce.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/commerce/uikit/view/AutoWrapHorizontalLayout;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defaultStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uikit_release"}, k = 1, mv = {1, 4, 0})
public final class AutoWrapHorizontalLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f202955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f202956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f202957c;

    public AutoWrapHorizontalLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AutoWrapHorizontalLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r110) {
        int r101 = View.MeasureSpec.getSize(r100);
        measureChildren(r100, r110);
        int r102 = getChildCount();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r103 >= r102) goto L20;
        View r107 = getChildAt(r103);
        int r108 = r107.getMeasuredWidth();
        int r109 = r107.getMeasuredHeight();
        int r111 = r108 + this.f202955a;
        r104 = r104 + r111;
        if (r104 < r101) goto L10;
        if (r104 > r101) goto L9;
        r111 = 0;
    L9:
        r106 = r106 + 1;
        r104 = r111;
    L10:
        if (r104 <= 0) goto L17;
        if (r103 != (r102 - 1)) goto L17;
        if (r106 < 2) goto L17;
        r106 = r106 + 1;
    L17:
        if (r106 >= this.f202957c) goto L20;
        r105 = ((r106 + 1) * r109) + (this.f202956b * r106);
        r103 = r103 + 1;
    L20:
        setMeasuredDimension(r101, r105);
    }

    public AutoWrapHorizontalLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.horizontalDivider, R.attr.maxLines, R.attr.verticalDivider});
        this.f202955a = r103.getDimensionPixelSize(0, 8);
        this.f202956b = r103.getDimensionPixelSize(2, 8);
        this.f202957c = r103.getInteger(1, 1);
        r103.recycle();
    }

    public /* synthetic */ AutoWrapHorizontalLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        int r103 = getChildCount();
        int r112 = r110 - r101;
        int r104 = 0;
        int r113 = 0;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r104 >= r103) goto L8;
        View r107 = getChildAt(r104);
        int r108 = r107.getMeasuredWidth();
        int r109 = r107.getMeasuredHeight();
        if ((r113 + r108) <= r112) goto L7;
        r105 = r105 + 1;
        int r114 = this.f202956b * r105;
        r106 = r114 + (r105 * r109);
        r113 = 0;
    L7:
        int r115 = r108 + r113;
        r107.layout(r113, r106, r115, r109 + r106);
        r113 = this.f202955a + r115;
        r104 = r104 + 1;
        goto L3
    }
}
