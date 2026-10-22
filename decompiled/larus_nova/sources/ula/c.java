package ula;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public class c extends ConstraintWidget {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f550644x0;

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void F() {
        this.f550644x0.clear();
        super.F();
    }

    public void T() {
        ArrayList<ConstraintWidget> r100 = this.f550644x0;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        ConstraintWidget r103 = (ConstraintWidget) ListProtector.get(this.f550644x0, r102);
        if ((r103 instanceof c) == false) goto L10;
        ((c) r103).T();
    L10:
        r102 = r102 + 1;
        goto L6
    }

    public c() {
        this.f550644x0 = new ArrayList();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void I(rla.a r100) {
        super.I(r100);
        int r101 = this.f550644x0.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((ConstraintWidget) ListProtector.get(this.f550644x0, r102)).I(r100);
        r102 = r102 + 1;
        goto L3
    }
}
