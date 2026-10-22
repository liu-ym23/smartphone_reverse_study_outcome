package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.custom.repeat.widget.childview.ControlChildViewClickableLayout;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;

/* JADX INFO: loaded from: classes35.dex */
public class CustomRepeatBottomContainer_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CustomRepeatBottomContainer f420353a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        CustomRepeatBottomContainer r100 = this.f420353a;
        if (r100 == null) goto L7;
        this.f420353a = null;
        r100.mCustomRepeatWeekly = null;
        r100.mCustomRepeatMonthly = null;
        r100.mSwitchDate = null;
        r100.mSwitchWeek = null;
        r100.mMonthlyTabContainer = null;
        r100.mRepeatWeekNoWheelView = null;
        r100.mRepeatWeeksWheelView = null;
        r100.mChooseRepeatWeeksViewGroup = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public CustomRepeatBottomContainer_ViewBinding(CustomRepeatBottomContainer r100, View r101) {
        this.f420353a = r100;
        r100.mCustomRepeatWeekly = (GridView) Utils.findRequiredViewAsType(r101, R.id.custom_repeat_weekly, "field 'mCustomRepeatWeekly'", GridView.class);
        r100.mCustomRepeatMonthly = (GridView) Utils.findRequiredViewAsType(r101, R.id.custom_repeat_monthly, "field 'mCustomRepeatMonthly'", GridView.class);
        r100.mSwitchDate = (TextView) Utils.findRequiredViewAsType(r101, R.id.switch_date, "field 'mSwitchDate'", TextView.class);
        r100.mSwitchWeek = (TextView) Utils.findRequiredViewAsType(r101, R.id.switch_week, "field 'mSwitchWeek'", TextView.class);
        r100.mMonthlyTabContainer = Utils.findRequiredView(r101, R.id.monthly_tab_container, "field 'mMonthlyTabContainer'");
        r100.mRepeatWeekNoWheelView = (WheelView) Utils.findRequiredViewAsType(r101, R.id.wheel_repeat_week_no, "field 'mRepeatWeekNoWheelView'", WheelView.class);
        r100.mRepeatWeeksWheelView = (WheelView) Utils.findRequiredViewAsType(r101, R.id.wheel_repeat_weeks, "field 'mRepeatWeeksWheelView'", WheelView.class);
        r100.mChooseRepeatWeeksViewGroup = (ControlChildViewClickableLayout) Utils.findRequiredViewAsType(r101, R.id.choose_repeat_weeks_container, "field 'mChooseRepeatWeeksViewGroup'", ControlChildViewClickableLayout.class);
    }
}
