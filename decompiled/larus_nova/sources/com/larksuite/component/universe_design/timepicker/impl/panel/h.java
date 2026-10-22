package com.larksuite.component.universe_design.timepicker.impl.panel;

import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;

/* JADX INFO: loaded from: classes24.dex */
public final class h implements OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f285426a;

    public h(f r100) {
        this.f285426a = r100;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
    public final void onItemSelected(int r100) {
        int r101 = this.f285426a.f285416a.getYear();
        WheelView r102 = this.f285426a.f285419d;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.getCurrentItem();
    L6:
        int r105 = r101 + r104;
        f r106 = this.f285426a;
        int r107 = r106.f285423h;
        WheelView r108 = r106.f285420e;
        if (r108 == null) goto L9;
        r103 = r108.getCurrentItem();
    L9:
        f r109 = this.f285426a;
        r109.c(r105, r107 + r103);
        f.a(this.f285426a);
        this.f285426a.getPickerPanelDependency().onSelected(this.f285426a.f285418c.getCalendar());
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
