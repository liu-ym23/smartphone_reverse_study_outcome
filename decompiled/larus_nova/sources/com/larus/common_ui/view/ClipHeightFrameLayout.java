package com.larus.common_ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/common_ui/view/ClipHeightFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "minHeight", "", "maxHeight", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClipHeightFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f328182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328183b;

    public ClipHeightFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public ClipHeightFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxHeight, R.attr.minHeight});
        this.f328182a = r102.getDimensionPixelSize(1, 0);     // Catch: Throwable -> L6
        this.f328183b = r102.getDimensionPixelSize(0, Integer.MAX_VALUE);     // Catch: Throwable -> L6
        r102.recycle();
        return;
    L6:
        th = move-exception;
        r102.recycle();
        throw th;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r101), 0));
        if (getMeasuredHeight() <= this.f328183b) goto L6;
        setMeasuredDimension(getMeasuredWidth(), this.f328183b);
        return;
    L6:
        if (getMeasuredHeight() >= this.f328182a) goto L10;
        setMeasuredDimension(getMeasuredWidth(), this.f328182a);
        return;
    }
}
