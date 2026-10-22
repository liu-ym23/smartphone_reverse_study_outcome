package f18;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import e18.b;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelView f475076a;

    @Override // e18.b
    public final void a() {
        if (this.f475076a.getCurrentItem() != 0) goto L5;
        int r100 = 1;
    L6:
        this.f475076a.setCurrentItem(r100);
        return;
    L5:
        r100 = 0;
        goto L6
    }

    public a(WheelView r100) {
        this.f475076a = r100;
    }
}
