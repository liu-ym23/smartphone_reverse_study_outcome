package com.larus.bmhome.notification.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0014J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/notification/view/AutoChangeLineLayout;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "spacingHorizontal", "", "spacingVertical", "init", "", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoChangeLineLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f313497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f313498b;

    public AutoChangeLineLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        a(r100, null);
    }

    public AutoChangeLineLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        a(r100, r101);
    }

    public final void a(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_spacing_horizontal, R.attr.larus_spacing_vertical});
        this.f313498b = r102.getDimension(1, this.f313498b);
        this.f313497a = r102.getDimension(0, this.f313497a);
        r102.recycle();
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = (r100 - getPaddingLeft()) - getPaddingRight();
        int r102 = getChildCount();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 1;
    L3:
        if (r103 >= r102) goto L9;
        View r107 = getChildAt(r103);
        measureChild(r107, r110, r111);
        int r108 = r107.getMeasuredWidth();
        int r109 = r107.getMeasuredHeight();
        int r112 = r105 + r108;
        if (r112 <= r101) goto L7;
        r106 = r106 + 1;
    L8:
        r105 = ((int) this.f313497a) + r108;
        r104 = (((r109 * r106) + ((r106 - 1) * ((int) this.f313498b))) + getPaddingTop()) + getPaddingBottom();
        r103 = r103 + 1;
        goto L3
    L7:
        r108 = r112;
        goto L8
    L9:
        setMeasuredDimension(r100, r104);
    }

    public AutoChangeLineLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a(r100, r101);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        int r112 = (r110 - r101) - getPaddingRight();
        int r103 = getPaddingLeft();
        int r104 = getChildCount();
        int r105 = 1;
        int r113 = 0;
    L3:
        if (r113 >= r104) goto L8;
        View r106 = getChildAt(r113);
        int r107 = r106.getMeasuredWidth();
        int r108 = r106.getMeasuredHeight();
        int r109 = r103 + r107;
        if (r109 <= r112) goto L7;
        r109 = getPaddingLeft() + r107;
        r105 = r105 + 1;
    L7:
        int r114 = ((r105 * r108) + ((r105 - 1) * ((int) this.f313498b))) + getPaddingTop();
        r106.layout(r109 - r107, r114 - r108, r109, r114);
        r103 = r109 + ((int) this.f313497a);
        r113 = r113 + 1;
        goto L3
    }
}
