package com.ss.android.lark.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0007H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/widget/layout/DynamicLinearLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mIsStretchToParent", "", "mVerticalSpace", "mHorizontalSpace", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "completeLayoutParam", "orientation", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DynamicLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f445939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f445940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f445941c;

    public static final class a {
    }

    static {
    }

    public DynamicLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public DynamicLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public DynamicLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = getChildCount();
        int r101 = View.MeasureSpec.getSize(r110);
        int r102 = View.MeasureSpec.makeMeasureSpec(r101, 0);
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r100) goto L9;
        View r105 = getChildAt(r103);
        if (r105 == null) goto L8;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r107 = (LinearLayout.LayoutParams) r106;
        r105.measure(r102, r111);
        r104 = r104 + ((r105.getMeasuredWidth() + r107.leftMargin) + r107.rightMargin);
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        Log.i("DynamicLinearLayout", "onMeasure totalWidth=" + r104 + " real widthSize=" + r101);
        boolean r108 = true;
        if (r104 <= r101) goto L12;
        int r109 = 1;
    L13:
        int r112 = getChildCount();
        if (r109 == 1) goto L17;
        r108 = false;
    L17:
        int r113 = 0;
    L18:
        if (r113 >= r112) goto L31;
        View r114 = getChildAt(r113);
        if (r114 == null) goto L30;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r116 = (LinearLayout.LayoutParams) r115;
        if (r113 == (r112 - 1)) goto L26;
        if (r108 == false) goto L25;
        r116.bottomMargin = this.f445940b;
        r116.rightMargin = 0;
        goto L26
    L25:
        r116.rightMargin = this.f445941c;
        r116.bottomMargin = 0;
    L26:
        if (r108 == false) goto L30;
        if (this.f445939a == false) goto L30;
        r116.width = -1;
    L30:
        r113 = r113 + 1;
        goto L18
    L31:
        setOrientation(r109);
        super.onMeasure(r110, r111);
        return;
    L12:
        r109 = 0;
        goto L13
    }

    public DynamicLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        if (r101 == null) goto L12;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.enableAutoStretch, R.attr.horizontalSpace, R.attr.verticalSpace});
        this.f445939a = r104.getBoolean(0, false);
        this.f445940b = r104.getDimensionPixelSize(2, this.f445940b);
        this.f445941c = r104.getDimensionPixelSize(1, this.f445941c);
        r104.recycle();
        return;
    }
}
