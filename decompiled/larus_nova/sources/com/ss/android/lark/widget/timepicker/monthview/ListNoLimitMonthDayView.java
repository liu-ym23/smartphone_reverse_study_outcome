package com.ss.android.lark.widget.timepicker.monthview;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$DateState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$MonthState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$OptionalState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$SelectState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vec.e;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ0\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/widget/timepicker/monthview/ListNoLimitMonthDayView;", "Lcom/ss/android/lark/widget/timepicker/monthview/ListMonthDayView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "renderDate", "", "monthState", "Lcom/ss/android/lark/widget/timepicker/monthview/constants/MonthViewAttr$MonthState;", "selectState", "Lcom/ss/android/lark/widget/timepicker/monthview/constants/MonthViewAttr$SelectState;", "dateState", "Lcom/ss/android/lark/widget/timepicker/monthview/constants/MonthViewAttr$DateState;", "optionalState", "Lcom/ss/android/lark/widget/timepicker/monthview/constants/MonthViewAttr$OptionalState;", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListNoLimitMonthDayView extends e {
    public ListNoLimitMonthDayView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public ListNoLimitMonthDayView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public ListNoLimitMonthDayView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // vec.e, vec.d
    public final void b(MonthViewAttr$MonthState r100, MonthViewAttr$SelectState r101, MonthViewAttr$DateState r102, MonthViewAttr$OptionalState r103) {
        if (r103 != MonthViewAttr$OptionalState.NOT_OPTIONAL) goto L7;
        e();
        return;
    L7:
        if (r100 != MonthViewAttr$MonthState.CURRENT_MONTH) goto L9;
        d(r101, r102);
        return;
    L9:
        f(r102);
    }
}
