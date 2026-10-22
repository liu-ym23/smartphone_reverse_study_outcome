package com.ss.android.lark.widget.timepicker;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import com.larksuite.component.universe_design.timepicker.impl.helper.TimePickerHelper;
import com.larksuite.component.universe_design.timepicker.impl.helper.UtcDates;
import com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController;
import com.larksuite.component.universe_design.timepicker.impl.single.YearPicker;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Calendar;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class n extends BaseTimePickerController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CalendarDate f449053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CalendarDate f449054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WheelView f449055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WheelView f449056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CalendarDate f449057e;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f449058a;

        public b(n r100) {
            this.f449058a = r100;
        }

        @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
        public final void onItemSelected(int r100) {
            int r101 = this.f449058a.f449053a.getYear() + r100;
            WheelView r102 = this.f449058a.f449056d;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("monthWheelView");
            r102 = null;
        L5:
            int r103 = r102.getCurrentItem() + 1;
            int r104 = this.f449058a.f449057e.getMonthDay();
            int r105 = com.larksuite.framework.utils.e.d(r101, r103);
            if (r104 <= r105) goto L9;
            r104 = r105;
        L9:
            this.f449058a.getPickerPanelDependency().onSelected(UtcDates.INSTANCE.getCalendar(r101, r103, r104));
        }
    }

    public static final class c implements OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f449059a;

        public c(n r100) {
            this.f449059a = r100;
        }

        @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
        public final void onItemSelected(int r100) {
            int r101 = this.f449059a.f449057e.getYear();
            int r102 = r100 + 1;
            int r103 = this.f449059a.f449057e.getMonthDay();
            int r104 = com.larksuite.framework.utils.e.d(r101, r102);
            if (r103 <= r104) goto L6;
            r103 = r104;
        L6:
            this.f449059a.getPickerPanelDependency().onSelected(UtcDates.INSTANCE.getCalendar(r101, r102, r103));
        }
    }

    static {
        new a();
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<WheelView> getPickerViewList() {
        WheelView[] r100 = new WheelView[2];
        WheelView r101 = this.f449055c;
        WheelView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("yearWheelView");
        r101 = null;
    L5:
        r100[0] = r101;
        WheelView r103 = this.f449056d;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("monthWheelView");
    L9:
        r100[1] = r102;
        return CollectionsKt.listOf(r100);
    L8:
        r102 = r103;
        goto L9
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<PickerBuilder> getPickerBuilderList() {
        PickerBuilder r100 = YearPicker.INSTANCE.getPickerBuilder(this.f449053a.getYear(), this.f449054b.getYear(), false);
        if (r100 == null) goto L27;
        Context r101 = getContext();
        CalendarDate r102 = this.f449053a;
        CalendarDate r103 = this.f449054b;
        int r104 = this.f449057e.getYear();
        int r105 = com.ss.android.lark.widget.timepicker.a.f448987a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "startCalendar");
        Intrinsics.checkNotNullParameter(r103, "endCalendar");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "startCalendar");
        Intrinsics.checkNotNullParameter(r103, "endCalendar");
        int r106 = r102.getYear();
        int r107 = r103.getYear();
        if (r106 > r104) goto L8;
        if (r104 > r107) goto L8;
        boolean r108 = true;
    L9:
        PickerBuilder r110 = null;
        if (r108 == true) goto L13;
        com.ss.android.lark.widget.timepicker.b r109 = null;
    L18:
        if (r109 == null) goto L21;
        r110 = new PickerBuilder(r109);
        r110.setLoop(false);
    L21:
        if (r110 == null) goto L25;
        return CollectionsKt.listOf(new PickerBuilder[]{r100, r110});
    L25:
        throw new IllegalArgumentException(("startMonth = " + this.f449053a.getMonth() + ", endYear = " + this.f449054b.getMonth()).toString());
    L13:
        if (r104 != r106) goto L15;
        r109 = new com.ss.android.lark.widget.timepicker.b(r102.getMonth(), 12);
        goto L18
    L15:
        if (r104 != r107) goto L17;
        r109 = new com.ss.android.lark.widget.timepicker.b(1, r103.getMonth());
        goto L18
    L17:
        r109 = new com.ss.android.lark.widget.timepicker.b(1, 12);
    L8:
        r108 = false;
        goto L9
    L27:
        throw new IllegalArgumentException(("startYear = " + this.f449053a.getYear() + ", endYear = " + this.f449054b.getYear()).toString());
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setCurrentDate(Calendar r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedDate");
        CalendarDate r101 = new CalendarDate(r100);
        this.f449057e = r101;
        WheelView r102 = this.f449055c;
        WheelView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("yearWheelView");
        r102 = null;
    L5:
        r102.setCurrentItem(r101.getYear() - this.f449053a.getYear());
        WheelView r104 = this.f449056d;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("monthWheelView");
    L9:
        r103.setCurrentItem(r101.getMonth() - 1);
        return;
    L8:
        r103 = r104;
        goto L9
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemDividerVisibility(boolean r100) {
        if (r100 == false) goto L4;
        WheelView.DividerType r101 = WheelView.DividerType.FILL;
    L5:
        WheelView r102 = this.f449055c;
        WheelView r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("yearWheelView");
        r102 = null;
    L8:
        r102.setDividerType(r101);
        WheelView r104 = this.f449056d;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("monthWheelView");
    L12:
        r103.setDividerType(r101);
        return;
    L11:
        r103 = r104;
        goto L12
    L4:
        r101 = WheelView.DividerType.NONE;
        goto L5
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemVisibleNum(int r100) {
        WheelView r101 = this.f449055c;
        WheelView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("yearWheelView");
        r101 = null;
    L5:
        int r103 = r100 + 2;
        r101.setItemVisible(r103);
        WheelView r104 = this.f449056d;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("monthWheelView");
    L9:
        r102.setItemVisible(r103);
        return;
    L8:
        r102 = r104;
        goto L9
    }

    public n(Context r110, YearMonthPicker.b r111) {
        CalendarDate r100 = new CalendarDate(1970, 1, 1, 0, 0, 0);
        CalendarDate r101 = new CalendarDate(2100, 12, 31, 0, 0, 0);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "pickerPanelDependency");
        Intrinsics.checkNotNullParameter(r100, "beginCalendar");
        Intrinsics.checkNotNullParameter(r101, "endCalendar");
        super(r110, r111);
        this.f449053a = r100;
        this.f449054b = r101;
        this.f449057e = new CalendarDate(r111.getSelectedDate());
        if (r101.getJulianDay() >= r100.getJulianDay()) goto L6;
        this.f449053a = new CalendarDate(1970, 1, 1, 0, 0, 0);
        this.f449054b = new CalendarDate(2100, 12, 31, 0, 0, 0);
        return;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void create(Context r100, List<PickerBuilder> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "builderList");
        TimePickerHelper r102 = TimePickerHelper.INSTANCE;
        WheelView r103 = r102.createWheelView(r100, (PickerBuilder) ListProtector.get(r101, 0));
        this.f449055c = r103;
        WheelView r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("yearWheelView");
        r103 = null;
    L5:
        r103.setOnItemSelectedListener(new b(this));
        WheelView r105 = r102.createWheelView(r100, (PickerBuilder) ListProtector.get(r101, 1));
        this.f449056d = r105;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("monthWheelView");
    L9:
        r104.setOnItemSelectedListener(new c(this));
        setItemVisibleNum(getPickerPanelDependency().getPanelStyleData().getVisibleItemNum());
        return;
    L8:
        r104 = r105;
        goto L9
    }
}
