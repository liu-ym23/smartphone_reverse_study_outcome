package com.ss.android.lark.widget.columns.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u000234B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0014J\"\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010\u000f2\u0006\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0011J\u001a\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\u0006\u0010%\u001a\u00020\u000fH\u0002J\u0012\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u00020\u001a2\b\u00102\u001a\u0004\u0018\u00010 H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000Rv\u0010\u0012\u001a^\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/ss/android/lark/widget/columns/view/ColumnsViewLinearLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "columnsView", "Lcom/ss/android/lark/widget/columns/view/ColumnsView;", "mMaxWidthInDp", "", "isColumnsOverMaxCellWidth", "", "mColumnsInfo", "Lcom/ss/android/lark/widget/columns/entity/ColumnsInfo;", "mSpanClickListeners", "Lcom/ss/android/lark/widget/columns/view/ColumnsViewLinearLayout$SpanClickListeners;", "sizeChangedListener", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "w", "h", "oldw", "oldh", "", "getSizeChangedListener", "()Lkotlin/jvm/functions/Function4;", "setSizeChangedListener", "(Lkotlin/jvm/functions/Function4;)V", "innerClickListener", "Landroid/view/View$OnClickListener;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setData", "columnsInfo", "maxWidthInDp", "clickListeners", "setupClickListeners", "dataAdapter", "Lcom/ss/android/lark/widget/columns/view/SimpleColumnsDataAdapter;", "getColumnsCellData", "", "Lcom/ss/android/lark/widget/columns/entity/ColumnsCellData;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "setOnClickListener", "l", "Companion", "SpanClickListeners", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColumnsViewLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColumnsView f445734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f445735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f445736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> f445737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnClickListener f445738e;

    public static final class a {
    }

    static {
    }

    public final Function4<Integer, Integer, Integer, Integer, Unit> getSizeChangedListener() {
        return this.f445737d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        boolean r101 = super.dispatchTouchEvent(r100);
        if (r101 == true) goto L5;
    L9:
        return r101;
    L5:
        if (this.f445738e == null) goto L9;
        if (isClickable() == false) goto L9;
        onTouchEvent(r100);
        goto L9
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        this.f445738e = r100;
        super.setOnClickListener(r100);
    }

    public final void setSizeChangedListener(Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r100) {
        this.f445737d = r100;
    }

    public ColumnsViewLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ColumnsView r102 = new ColumnsView(r100, null);
        this.f445734a = r102;
        addView(r102);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        Log.i("ColumnsViewLinearLayout", "maxWidthInPx = " + r102);
        int r103 = UIUtils.px2dp(getContext(), (float) r102);
        Log.i("ColumnsViewLinearLayout", "newMaxWidthInDp = " + r103);
        if (r103 == this.f445735b) goto L7;
        this.f445735b = r103;
        Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r104 = this.f445737d;
        if (r104 == null) goto L7;
        r104.invoke(Integer.valueOf(r103), 0, 0, 0);
    L7:
        super.onMeasure(r100, r101);
    }
}
