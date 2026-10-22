package com.larksuite.component.universe_design.timepicker.impl.panel;

import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f285405a;

    public b(a r100) {
        this.f285405a = r100;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
    public final void onItemSelected(int r100) {
        a r101 = this.f285405a;
        WheelView r102 = r101.f285399b;
        if (r102 == null) goto L11;
        WheelView r103 = r101.f285401d;
        if (r101.f285398a == true) goto L10;
        if (r103 == null) goto L10;
        int r104 = r102.getCurrentItem() + (r103.getCurrentItem() * 12);
        r101.f285403f.set(11, r104);
    L10:
        r101.f285403f.set(11, r102.getCurrentItem());
    L11:
        WheelView r105 = r101.f285400c;
        if (r105 == null) goto L14;
        int r106 = r105.getCurrentItem() * r101.f285404g;
        r101.f285403f.set(12, r106);
    L14:
        this.f285405a.getPickerPanelDependency().onSelected(this.f285405a.f285403f);
    }
}
