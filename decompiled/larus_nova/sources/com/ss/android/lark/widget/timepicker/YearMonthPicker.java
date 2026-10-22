package com.ss.android.lark.widget.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.timepicker.impl.data.PanelStyleData;
import com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/widget/timepicker/YearMonthPicker;", "Lcom/larksuite/component/universe_design/timepicker/UDTimePicker;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "yearMonthChange", "Lcom/ss/android/lark/widget/timepicker/YearMonthPicker$IYearMonthChange;", "getYearMonthChange", "()Lcom/ss/android/lark/widget/timepicker/YearMonthPicker$IYearMonthChange;", "setYearMonthChange", "(Lcom/ss/android/lark/widget/timepicker/YearMonthPicker$IYearMonthChange;)V", "initView", "", "IYearMonthChange", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class YearMonthPicker extends UDTimePicker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f448984a;

    public interface a {
        void a(CalendarDate r100);
    }

    public static final class b implements BaseTimePickerController.PickerPanelDependency {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PanelStyleData f448985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ YearMonthPicker f448986b;

        @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController.PickerPanelDependency
        public final Calendar getSelectedDate() {
            return this.f448986b.getSelectedCalendar();
        }

        @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController.PickerPanelDependency
        public final PanelStyleData getPanelStyleData() {
            return this.f448985a;
        }

        @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController.PickerPanelDependency
        public final void onSelected(Calendar r100) {
            Intrinsics.checkNotNullParameter(r100, "selectedDate");
            this.f448986b.setSelectedCalendar(r100);
            CalendarDate r101 = new CalendarDate(r100);
            a r102 = this.f448986b.getYearMonthChange();
            if (r102 == null) goto L6;
            r102.a(r101);
            return;
        }

        public b(PanelStyleData r100, YearMonthPicker r101) {
            this.f448985a = r100;
            this.f448986b = r101;
        }
    }

    public final void a() {
        PanelStyleData r100 = new PanelStyleData(0, 0, false, false, 15, null);
        r100.setItemDividerVisibility(true);
        r100.setVisibleItemNum(5);
        setPanelController(new n(getContext(), new b(r100, this)));
    }

    public final a getYearMonthChange() {
        return this.f448984a;
    }

    public YearMonthPicker(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        a();
    }

    public final void setYearMonthChange(a r100) {
        this.f448984a = r100;
    }

    public YearMonthPicker(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        a();
    }

    public YearMonthPicker(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a();
    }
}
