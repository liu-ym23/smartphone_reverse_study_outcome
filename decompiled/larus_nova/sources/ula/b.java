package ula;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.analyzer.h;
import com.obric.oui.constraintlayout.core.widgets.analyzer.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public class b extends ConstraintWidget implements a {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public ConstraintWidget[] f550642x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f550643y0;

    public void a() {
    }

    @Override // ula.a
    public final void removeAllIds() {
        this.f550643y0 = 0;
        Arrays.fill(this.f550642x0, null);
    }

    public b() {
        this.f550642x0 = new ConstraintWidget[4];
        this.f550643y0 = 0;
    }

    @Override // ula.a
    public final void b(ConstraintWidget r100) {
        if (r100 == this) goto L10;
        if (r100 == null) goto L11;
        int r101 = this.f550643y0 + 1;
        ConstraintWidget[] r102 = this.f550642x0;
        if (r101 <= r102.length) goto L8;
        this.f550642x0 = (ConstraintWidget[]) Arrays.copyOf(r102, r102.length * 2);
    L8:
        ConstraintWidget[] r103 = this.f550642x0;
        int r104 = this.f550643y0;
        r103[r104] = r100;
        this.f550643y0 = r104 + 1;
        return;
    L11:
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void i(ConstraintWidget r100, HashMap<ConstraintWidget, ConstraintWidget> r101) {
        super.i(r100, r101);
        b r102 = (b) r100;
        int r103 = 0;
        this.f550643y0 = 0;
        int r104 = r102.f550643y0;
    L3:
        if (r103 >= r104) goto L5;
        b(r101.get(r102.f550642x0[r103]));
        r103 = r103 + 1;
        goto L3
    }

    public final void T(ArrayList<n> r100, int r101, n r102) {
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= this.f550643y0) goto L7;
        r102.a(this.f550642x0[r104]);
        r104 = r104 + 1;
    L7:
        if (r103 >= this.f550643y0) goto L9;
        h.a(this.f550642x0[r103], r101, r100, r102);
        r103 = r103 + 1;
        goto L7
    }
}
