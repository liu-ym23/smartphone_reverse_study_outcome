package com.obric.miniapp.lynx;

import com.obric.oui.calendar.ODatePickerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class i2 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxOUIDatePickerViewUI f398147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ODatePickerView f398148b;

    public /* synthetic */ i2(LynxOUIDatePickerViewUI r100, ODatePickerView r101) {
        this.f398147a = r100;
        this.f398148b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        LynxOUIDatePickerViewUI r101 = this.f398147a;
        ODatePickerView r102 = this.f398148b;
        ((Long) r100).longValue();
        int r103 = LynxOUIDatePickerViewUI.f397901w;
        r101.N(r102, false);
        return Unit.INSTANCE;
    }
}
