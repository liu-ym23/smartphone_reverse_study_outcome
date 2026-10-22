package com.larksuite.component.universe_design.timepicker.impl.panel;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import com.larksuite.component.universe_design.timepicker.impl.helper.TimePickerHelper;
import com.larksuite.component.universe_design.timepicker.impl.helper.UtcDates;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d extends BaseTimePickerController {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f285409e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CalendarDate f285410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CalendarDate f285411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WheelView f285412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CalendarDate f285413d;

    public static final class a {
        public a() {
        }

        public static d a(Context r110, BaseTimePickerController.PickerPanelDependency r111) {
            int r100 = d.f285409e;
            UtcDates r101 = UtcDates.INSTANCE;
            CalendarDate r102 = new CalendarDate(r101.getCalendar(2010, 1, 1, 0, 0, 0));
            CalendarDate r103 = new CalendarDate(r101.getCalendar(2100, 1, 1, 0, 0, 0));
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "pickerPanelDependency");
            Intrinsics.checkNotNullParameter(r102, "beginCalendar");
            Intrinsics.checkNotNullParameter(r103, "endCalendar");
            if (r103.getJulianDay() >= r102.getJulianDay()) goto L6;
            r102 = new CalendarDate(r101.getCalendar(2010, 1, 1, 0, 0, 0));
            r103 = new CalendarDate(r101.getCalendar(2100, 1, 1, 0, 0, 0));
        L6:
            return new d(r110, r111, r102, r103);
        }
    }

    static {
        new a();
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<PickerBuilder> getPickerBuilderList() {
        ArrayList r100 = new ArrayList();
        int r101 = g18.b.f479623a;
        Context r102 = getContext();
        CalendarDate r103 = this.f285410a;
        CalendarDate r104 = this.f285411b;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "beginCalendar");
        if (r104 == null) goto L5;
        int r105 = r104.getJulianDay();
    L6:
        int r106 = r103.getJulianDay();
        if (r105 <= r106) goto L9;
        int r107 = r105 - r106;
    L10:
        PickerBuilder r108 = new PickerBuilder(new d18.c(r102, r103, r107, r102.getResources().getStringArray(R.array.ud_timePicker_weeks)));
        r108.setShowTwoFigure(true);
        r100.add(r108);
        return r100;
    L9:
        r107 = 22000;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<WheelView> getPickerViewList() {
        ArrayList r100 = new ArrayList();
        WheelView r101 = this.f285412c;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        return r100;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setCurrentDate(Calendar r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedDate");
        CalendarDate r101 = new CalendarDate(r100);
        this.f285413d = r101;
        WheelView r102 = this.f285412c;
        if (r102 == null) goto L6;
        r102.setCurrentItem(r101.getJulianDay() - this.f285410a.getJulianDay());
        return;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemDividerVisibility(boolean r100) {
        if (r100 == false) goto L4;
        WheelView.DividerType r101 = WheelView.DividerType.FILL;
    L5:
        WheelView r102 = this.f285412c;
        if (r102 == null) goto L9;
        r102.setDividerType(r101);
        return;
    L9:
        return;
    L4:
        r101 = WheelView.DividerType.NONE;
        goto L5
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemVisibleNum(int r100) {
        WheelView r101 = this.f285412c;
        if (r101 == null) goto L5;
        r101.setItemVisible(r100 + 2);
    L5:
        WheelView r102 = this.f285412c;
        if (r102 == null) goto L9;
        r102.invalidate();
        return;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void create(Context r100, List<PickerBuilder> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "builderList");
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        PickerBuilder r102 = (PickerBuilder) ListProtector.get(r101, 0);
        this.f285412c = TimePickerHelper.INSTANCE.createWheelView(r100, r102);
        setItemVisibleNum(getPickerPanelDependency().getPanelStyleData().getVisibleItemNum());
        setItemDividerVisibility(getPickerPanelDependency().getPanelStyleData().getItemDividerVisibility());
        e r103 = new e(this);
        WheelView r104 = this.f285412c;
        if (r104 == null) goto L9;
        r104.setOnItemSelectedListener(r103);
        return;
    }

    public d(Context r100, BaseTimePickerController.PickerPanelDependency r101, CalendarDate r102, CalendarDate r103) {
        super(r100, r101);
        this.f285410a = r102;
        this.f285411b = r103;
        this.f285413d = new CalendarDate(r101.getSelectedDate());
    }
}
