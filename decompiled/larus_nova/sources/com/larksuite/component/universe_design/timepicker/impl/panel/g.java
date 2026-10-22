package com.larksuite.component.universe_design.timepicker.impl.panel;

import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;

/* JADX INFO: loaded from: classes24.dex */
public final class g implements OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f285425a;

    public g(f r100) {
        this.f285425a = r100;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
    public final void onItemSelected(int r100) {
        f.a(this.f285425a);
        this.f285425a.getPickerPanelDependency().onSelected(this.f285425a.f285418c.getCalendar());
    }
}
