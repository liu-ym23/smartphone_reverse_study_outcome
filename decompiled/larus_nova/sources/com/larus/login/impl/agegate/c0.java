package com.larus.login.impl.agegate;

import com.larus.common_ui.widget.RectangleButton;
import com.larus.common_ui.widget.datepicker.DatePicker;
import com.larus.login.impl.databinding.LarusFragmentAgeGateScrollBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class c0 implements DatePicker.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AgeGateScrollFragment f357330a;

    @Override // com.larus.common_ui.widget.datepicker.DatePicker.b
    public final void a() {
        LarusFragmentAgeGateScrollBinding r100 = this.f357330a.f357304h;
        if (r100 == null) goto L8;
        RectangleButton r101 = r100.f357527c;
        if (r101 == null) goto L9;
        r101.a(true);
        return;
    L9:
        return;
    }

    public c0(AgeGateScrollFragment r100) {
        this.f357330a = r100;
    }
}
