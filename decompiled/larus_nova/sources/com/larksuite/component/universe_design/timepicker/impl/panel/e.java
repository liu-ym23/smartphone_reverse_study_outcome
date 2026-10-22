package com.larksuite.component.universe_design.timepicker.impl.panel;

import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.util.CalendarDate;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f285414a;

    public e(d r100) {
        this.f285414a = r100;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
    public final void onItemSelected(int r100) {
        d r101 = this.f285414a;
        WheelView r102 = r101.f285412c;
        if (r102 == null) goto L6;
        CalendarDate r103 = new CalendarDate(r101.f285410a);
        r103.setMonthDay(r103.getMonthDay() + r102.getCurrentItem());
        r101.f285413d.setYear(r103.getYear());
        r101.f285413d.setMonth(r103.getMonth());
        r101.f285413d.setMonthDay(r103.getMonthDay());
    L6:
        this.f285414a.getPickerPanelDependency().onSelected(this.f285414a.f285413d.getCalendar());
    }
}
