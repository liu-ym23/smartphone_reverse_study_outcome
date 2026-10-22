package com.larksuite.component.universe_design.timepicker.impl.panel;

import android.content.Context;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import com.larksuite.component.universe_design.timepicker.impl.helper.TimePickerHelper;
import com.larksuite.component.universe_design.timepicker.impl.single.YearPicker;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f extends BaseTimePickerController {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f285415j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CalendarDate f285416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CalendarDate f285417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CalendarDate f285418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WheelView f285419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WheelView f285420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WheelView f285421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String[] f285422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f285423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f285424i;

    public static final class a {
        public static f a(Context r210, BaseTimePickerController.PickerPanelDependency r211, CalendarDate r212, CalendarDate r213) {
            Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r211, "pickerPanelDependency");
            Intrinsics.checkNotNullParameter(r212, "beginCalendar");
            Intrinsics.checkNotNullParameter(r213, "endCalendar");
            if (r213.getJulianDay() >= r212.getJulianDay()) goto L5;
            CalendarDate r100 = new CalendarDate(1900, 1, 1, 0, 0, 0);
            CalendarDate r101 = new CalendarDate(2100, 12, 31, 0, 0, 0);
        L7:
            return new f(r210, r211, r100, r101);
        L5:
            r100 = r212;
            r101 = r213;
            goto L7
        }
    }

    static {
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<PickerBuilder> getPickerBuilderList() {
        ArrayList r100 = new ArrayList();
        PickerBuilder r101 = YearPicker.INSTANCE.getPickerBuilder(this.f285416a.getYear(), this.f285417b.getYear(), true);
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        Context r102 = getContext();
        CalendarDate r103 = this.f285416a;
        CalendarDate r104 = this.f285417b;
        int r105 = this.f285418c.getYear();
        int r106 = g18.f.f479627a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "startCalendar");
        Intrinsics.checkNotNullParameter(r104, "endCalendar");
        d18.e r107 = g18.f.a(r102, r103, r104, r105);
        if (r107 != null) goto L8;
        PickerBuilder r108 = null;
    L9:
        if (r108 == null) goto L11;
        r100.add(r108);
    L11:
        boolean r110 = getPickerPanelDependency().getPanelStyleData().getShowDayInfo();
        int r109 = g18.e.f479626a;
        Context r111 = getContext();
        CalendarDate r112 = this.f285418c;
        String[] r113 = this.f285422g;
        if (r113 != null) goto L15;
        Context r114 = getContext();
        int r115 = h18.b.f483538a;
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        r113 = r114.getResources().getStringArray(R.array.ud_timePicker_weeks);
        this.f285422g = r113;
    L15:
        String[] r116 = r113;
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "chooseCalendarDate");
        Intrinsics.checkNotNullParameter(r116, "weekArray");
        int r117 = r112.getYear();
        int r118 = r112.getMonth();
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r116, "weekArray");
        PickerBuilder r119 = new PickerBuilder(new d18.d(r111, r117, r118, r116, r110));
        r119.setLoop(true);
        r100.add(r119);
        return r100;
    L8:
        PickerBuilder r120 = new PickerBuilder(r107);
        r120.setLoop(true);
        r108 = r120;
        goto L9
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<WheelView> getPickerViewList() {
        ArrayList r100 = new ArrayList();
        WheelView r101 = this.f285419d;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        WheelView r102 = this.f285420e;
        if (r102 == null) goto L8;
        r100.add(r102);
    L8:
        WheelView r103 = this.f285421f;
        if (r103 == null) goto L11;
        r100.add(r103);
    L11:
        return r100;
    }

    public static final void a(f r100) {
        WheelView r101 = r100.f285419d;
        if (r101 == null) goto L5;
        r100.f285418c.setYear(r100.f285416a.getYear() + r101.getCurrentItem());
    L5:
        WheelView r102 = r100.f285420e;
        if (r102 == null) goto L8;
        r100.f285418c.setMonth(r100.f285423h + r102.getCurrentItem());
    L8:
        WheelView r103 = r100.f285421f;
        if (r103 == null) goto L12;
        r100.f285418c.setMonthDay(r100.f285424i + r103.getCurrentItem());
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(int r100) {
        WheelView r101 = this.f285420e;
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = this.f285423h + r101.getCurrentItem();
        d18.e r103 = g18.f.a(getContext(), this.f285416a, this.f285417b, r100);
        if (r103 != null) goto L8;
        return;
    L8:
        this.f285423h = r103.f466437b;
        r101.setAdapter(r103);
        int r104 = r103.getItemsCount() - 1;
        int r105 = this.f285423h;
        if (r102 <= (r104 + r105)) goto L11;
        r102 = r103.getItemsCount() - 1;
    L13:
        r101.setCurrentItem(r102 - this.f285423h);
        return;
    L11:
        if (r102 >= r105) goto L13;
        r102 = r105;
        goto L13
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setCurrentDate(Calendar r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedDate");
        CalendarDate r101 = new CalendarDate(r100);
        int r102 = r101.getJulianDay();
        int r103 = this.f285416a.getJulianDay();
        int r104 = this.f285417b.getJulianDay();
        if (r102 >= r103) goto L5;
        r101.setJulianDay(r103);
    L7:
        this.f285418c = r101;
        int r105 = r101.getYear();
        int r106 = r101.getMonth();
        int r107 = r101.getMonthDay();
        WheelView r108 = this.f285419d;
        if (r108 == null) goto L10;
        r108.setCurrentItem(r105 - this.f285416a.getYear());
    L10:
        b(r105);
        WheelView r109 = this.f285420e;
        if (r109 == null) goto L13;
        r109.setCurrentItem(r106 - this.f285423h);
    L13:
        c(r105, r106);
        WheelView r110 = this.f285421f;
        if (r110 == null) goto L17;
        r110.setCurrentItem(r107 - this.f285424i);
        return;
    L17:
        return;
    L5:
        if (r102 <= r104) goto L7;
        r101.setJulianDay(r104);
        goto L7
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemDividerVisibility(boolean r100) {
        if (r100 == false) goto L4;
        WheelView.DividerType r101 = WheelView.DividerType.FILL;
    L5:
        WheelView r102 = this.f285419d;
        if (r102 == null) goto L8;
        r102.setDividerType(r101);
    L8:
        WheelView r103 = this.f285420e;
        if (r103 == null) goto L11;
        r103.setDividerType(r101);
    L11:
        WheelView r104 = this.f285421f;
        if (r104 == null) goto L15;
        r104.setDividerType(r101);
        return;
    L15:
        return;
    L4:
        r101 = WheelView.DividerType.NONE;
        goto L5
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemVisibleNum(int r100) {
        WheelView r101 = this.f285419d;
        if (r101 == null) goto L5;
        r101.setItemVisible(r100 + 2);
    L5:
        WheelView r102 = this.f285420e;
        if (r102 == null) goto L8;
        r102.setItemVisible(r100 + 2);
    L8:
        WheelView r103 = this.f285421f;
        if (r103 == null) goto L12;
        r103.setItemVisible(r100 + 2);
        return;
    }

    public final void c(int r110, int r111) {
        WheelView r100 = this.f285421f;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.getCurrentItem();
        boolean r102 = getPickerPanelDependency().getPanelStyleData().getShowDayInfo();
        int r103 = g18.e.f479626a;
        Context r104 = getContext();
        String[] r105 = this.f285422g;
        if (r105 != null) goto L9;
        Context r106 = getContext();
        int r107 = h18.b.f483538a;
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        r105 = r106.getResources().getStringArray(R.array.ud_timePicker_weeks);
        this.f285422g = r105;
    L9:
        String[] r108 = r105;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r108, "weekArray");
        d18.d r109 = new d18.d(r104, r110, r111, r108, r102);
        r100.setAdapter(r109);
        if (r101 <= (r109.getItemsCount() - 1)) goto L12;
        r101 = r109.getItemsCount() - 1;
    L12:
        r100.setCurrentItem(r101);
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void create(Context r100, List<PickerBuilder> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "builderList");
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L28;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        PickerBuilder r106 = (PickerBuilder) r104;
        if (r103 != 0) goto L11;
        this.f285419d = TimePickerHelper.INSTANCE.createWheelView(r100, r106);
    L27:
        r103 = r105;
        goto L4
    L11:
        if (r103 != 1) goto L13;
        WheelView r107 = TimePickerHelper.INSTANCE.createWheelView(r100, r106);
        this.f285420e = r107;
        d18.b r108 = null;
        if (r107 == null) goto L19;
        e18.a<? extends Object> r109 = r107.getAdapter();
    L21:
        if ((r109 instanceof d18.b) == false) goto L23;
        r108 = (d18.b) r109;
    L23:
        if (r108 == null) goto L27;
        this.f285423h = r108.f466417a;
        goto L27
    L19:
        r109 = null;
        goto L21
    L13:
        if (r103 != 2) goto L27;
        this.f285421f = TimePickerHelper.INSTANCE.createWheelView(r100, r106);
        goto L27
    L28:
        WheelView r110 = this.f285419d;
        if (r110 == null) goto L31;
        r110.setLabel(h18.b.a(getContext(), R.string.Calendar_StandardTime_YearOnlyString, BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, ""));
    L31:
        setItemVisibleNum(getPickerPanelDependency().getPanelStyleData().getVisibleItemNum());
        setItemDividerVisibility(getPickerPanelDependency().getPanelStyleData().getItemDividerVisibility());
        i r111 = new i(this);
        h r112 = new h(this);
        g r113 = new g(this);
        WheelView r114 = this.f285419d;
        if (r114 == null) goto L34;
        r114.setOnItemSelectedListener(r111);
    L34:
        WheelView r115 = this.f285420e;
        if (r115 == null) goto L37;
        r115.setOnItemSelectedListener(r112);
    L37:
        WheelView r116 = this.f285421f;
        if (r116 == null) goto L47;
        r116.setOnItemSelectedListener(r113);
        return;
    }

    public f(Context r100, BaseTimePickerController.PickerPanelDependency r101, CalendarDate r102, CalendarDate r103) {
        super(r100, r101);
        this.f285416a = r102;
        this.f285417b = r103;
        CalendarDate r104 = new CalendarDate(r101.getSelectedDate());
        this.f285418c = r104;
        this.f285423h = 1;
        this.f285424i = 1;
        int r105 = r104.getJulianDay();
        int r106 = r102.getJulianDay();
        int r107 = r103.getJulianDay();
        if (r105 >= r106) goto L5;
        r104.setJulianDay(r106);
        return;
    L5:
        if (r105 <= r107) goto L9;
        r104.setJulianDay(r107);
        return;
    }
}
