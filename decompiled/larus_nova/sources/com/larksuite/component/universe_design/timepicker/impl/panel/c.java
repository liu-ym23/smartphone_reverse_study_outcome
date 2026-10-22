package com.larksuite.component.universe_design.timepicker.impl.panel;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends BaseTimePickerController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f285406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f285407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f285408c;

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<PickerBuilder> getPickerBuilderList() {
        ArrayList r100 = new ArrayList();
        List<PickerBuilder> r101 = this.f285407b.getPickerBuilderList();
        if ((!r101.isEmpty()) == false) goto L5;
        ((PickerBuilder) ListProtector.get(r101, 0)).getLayoutParams().f285394a = 2.0f;
    L5:
        r100.addAll(r101);
        r100.addAll(this.f285408c.getPickerBuilderList());
        return r100;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<WheelView> getPickerViewList() {
        ArrayList r100 = new ArrayList();
        r100.addAll(this.f285407b.getPickerViewList());
        r100.addAll(this.f285408c.getPickerViewList());
        return r100;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setCurrentDate(Calendar r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedDate");
        this.f285407b.setCurrentDate(r100);
        this.f285408c.setCurrentDate(r100);
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemDividerVisibility(boolean r100) {
        this.f285407b.setItemDividerVisibility(r100);
        this.f285408c.setItemDividerVisibility(r100);
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemVisibleNum(int r100) {
        this.f285407b.setItemVisibleNum(r100);
        this.f285408c.setItemVisibleNum(r100);
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setMinuteWheelInterval(int r100) {
        this.f285408c.setMinuteWheelInterval(r100);
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void create(Context r100, List<PickerBuilder> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "builderList");
        this.f285407b.create(r100, CollectionsKt.listOf(ListProtector.get(r101, 0)));
        if (this.f285406a == false) goto L5;
        List<PickerBuilder> r102 = r101.subList(1, 3);
    L6:
        this.f285408c.create(r100, r102);
        return;
    L5:
        r102 = r101.subList(1, 4);
        goto L6
    }

    public c(Context r100, BaseTimePickerController.PickerPanelDependency r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pickerPanelDependency");
        super(r100, r101);
        this.f285406a = r102;
        int r103 = d.f285409e;
        this.f285407b = d.a.a(r100, r101);
        this.f285408c = new a(r100, r101, r102, r101.getPanelStyleData().getMinuteInterval());
    }
}
