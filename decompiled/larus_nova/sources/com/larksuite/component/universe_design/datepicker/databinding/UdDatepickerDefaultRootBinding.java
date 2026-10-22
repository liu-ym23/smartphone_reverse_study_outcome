package com.larksuite.component.universe_design.datepicker.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.larksuite.component.universe_design.datepicker.impl.MonthViewPager;
import com.larksuite.component.universe_design.datepicker.impl.header.MonthPickerDefaultHead;
import com.larksuite.component.universe_design.datepicker.impl.week.WeekIndicator;

/* JADX INFO: loaded from: classes24.dex */
public final class UdDatepickerDefaultRootBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f284781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MonthPickerDefaultHead f284782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeekIndicator f284783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MonthViewPager f284784d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f284781a;
    }

    public UdDatepickerDefaultRootBinding(View r100, MonthPickerDefaultHead r101, WeekIndicator r102, MonthViewPager r103) {
        this.f284781a = r100;
        this.f284782b = r101;
        this.f284783c = r102;
        this.f284784d = r103;
    }
}
