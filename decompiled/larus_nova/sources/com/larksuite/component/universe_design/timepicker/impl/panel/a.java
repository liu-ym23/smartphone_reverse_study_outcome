package com.larksuite.component.universe_design.timepicker.impl.panel;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import com.larksuite.component.universe_design.timepicker.impl.helper.TimePickerHelper;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends BaseTimePickerController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f285398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WheelView f285399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WheelView f285400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WheelView f285401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f285402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Calendar f285403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f285404g;

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.timepicker.impl.panel.a$a, reason: collision with other inner class name */
    public static final class C3922a {
    }

    static {
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<PickerBuilder> getPickerBuilderList() {
        ArrayList r100 = new ArrayList();
        int r101 = g18.c.f479624a;
        if (this.f285398a == false) goto L5;
        e18.a r102 = new d18.b(0, 23);
    L6:
        PickerBuilder r103 = new PickerBuilder(r102);
        r103.setShowTwoFigure(true);
        r103.setLoop(true);
        r100.add(r103);
        int r104 = g18.d.f479625a;
        int r105 = this.f285404g;
        PickerBuilder r106 = new PickerBuilder(new d18.b(60 - r105, r105, 0));
        r106.setShowTwoFigure(true);
        r106.setLoop(true);
        r100.add(r106);
        if (this.f285398a == true) goto L9;
        int r107 = g18.a.f479622a;
        Context r108 = getContext();
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.add(new PickerBuilder(new d18.a(new String[]{r108.getResources().getString(R.string.Calendar_StandardTime_AM), r108.getResources().getString(R.string.Calendar_StandardTime_PM)})));
    L9:
        return r100;
    L5:
        r102 = new d18.f();
        goto L6
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<WheelView> getPickerViewList() {
        ArrayList r100 = new ArrayList();
        WheelView r101 = this.f285399b;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        WheelView r102 = this.f285400c;
        if (r102 == null) goto L9;
        r100.add(r102);
    L9:
        if (this.f285398a == true) goto L16;
        WheelView r103 = this.f285401d;
        if (r103 == null) goto L16;
        if (this.f285402e == false) goto L15;
        ListProtector.add(r100, 0, r103);
        goto L16
    L15:
        r100.add(r103);
    L16:
        return r100;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setCurrentDate(Calendar r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedDate");
        this.f285403f = r100;
        if (this.f285398a == false) goto L11;
        WheelView r101 = this.f285399b;
        if (r101 == null) goto L7;
        r101.setCurrentItem(r100.get(11));
    L7:
        WheelView r102 = this.f285400c;
        if (r102 == null) goto L21;
        r102.setCurrentItem(r100.get(12) / this.f285404g);
        return;
    L21:
        return;
    L11:
        WheelView r103 = this.f285399b;
        if (r103 == null) goto L14;
        r103.setCurrentItem(r100.get(10));
    L14:
        WheelView r104 = this.f285400c;
        if (r104 == null) goto L17;
        r104.setCurrentItem(r100.get(12) / this.f285404g);
    L17:
        WheelView r105 = this.f285401d;
        if (r105 == null) goto L22;
        r105.setCurrentItem(r100.get(9));
        return;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemDividerVisibility(boolean r100) {
        if (r100 == false) goto L4;
        WheelView.DividerType r101 = WheelView.DividerType.FILL;
    L5:
        WheelView r102 = this.f285399b;
        if (r102 == null) goto L8;
        r102.setDividerType(r101);
    L8:
        WheelView r103 = this.f285400c;
        if (r103 == null) goto L11;
        r103.setDividerType(r101);
    L11:
        WheelView r104 = this.f285401d;
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
        WheelView r101 = this.f285399b;
        if (r101 == null) goto L5;
        r101.setItemVisible(r100 + 2);
    L5:
        WheelView r102 = this.f285400c;
        if (r102 == null) goto L9;
        r102.setItemVisible(r100 + 2);
        return;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setMinuteWheelInterval(int r100) {
        if (r100 <= 60) goto L5;
        return;
    L5:
        if ((60 % r100) != 0) goto L13;
        this.f285404g = r100;
        WheelView r101 = this.f285400c;
        if (r101 == null) goto L10;
        r101.setAdapter(new d18.b(60 - r100, r100, 0));
    L10:
        setCurrentDate(getPickerPanelDependency().getSelectedDate());
        return;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void create(Context r100, List<PickerBuilder> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "builderList");
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L21;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        PickerBuilder r106 = (PickerBuilder) r104;
        if (r103 != 0) goto L12;
        this.f285399b = TimePickerHelper.INSTANCE.createWheelView(r100, r106);
    L19:
        r103 = r105;
        goto L4
    L12:
        if (r103 != 1) goto L15;
        this.f285400c = TimePickerHelper.INSTANCE.createWheelView(r100, r106);
        goto L19
    L15:
        if (r103 != 2) goto L19;
        if (this.f285398a == true) goto L19;
        this.f285401d = TimePickerHelper.INSTANCE.createWheelView(r100, r106);
        goto L19
    L21:
        if (this.f285399b == null) goto L23;
    L25:
        setItemVisibleNum(getPickerPanelDependency().getPanelStyleData().getVisibleItemNum());
        setItemDividerVisibility(getPickerPanelDependency().getPanelStyleData().getItemDividerVisibility());
        b r107 = new b(this);
        WheelView r108 = this.f285399b;
        if (r108 == null) goto L28;
        r108.setOnItemSelectedListener(r107);
    L28:
        WheelView r109 = this.f285400c;
        if (r109 == null) goto L31;
        r109.setOnItemSelectedListener(r107);
    L31:
        WheelView r110 = this.f285401d;
        if (r110 == null) goto L35;
        r110.setOnItemSelectedListener(r107);
    L35:
        if (this.f285398a == true) goto L52;
        WheelView r111 = this.f285399b;
        if (r111 == null) goto L53;
        WheelView r112 = this.f285401d;
        if (r112 == null) goto L54;
        r111.setLoopChangeListener(new f18.a(r112));
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L23:
        if (this.f285400c != null) goto L25;
    }

    public a(Context r100, BaseTimePickerController.PickerPanelDependency r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pickerPanelDependency");
        super(r100, r101);
        this.f285398a = r102;
        this.f285402e = TimePickerHelper.INSTANCE.isLanguageAMPMAtFront();
        this.f285403f = r101.getSelectedDate();
        this.f285404g = 1;
        setMinuteWheelInterval(r103);
    }
}
