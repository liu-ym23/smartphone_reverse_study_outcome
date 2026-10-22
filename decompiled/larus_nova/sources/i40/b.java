package i40;

import android.content.Context;
import android.view.ViewGroup;
import j40.t0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f488133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<c> f488134b;

    public b(ViewGroup r100) {
        int r101 = t0.f497300a.getValue().intValue();
        if (r101 != 1) goto L5;
        this.f488133a = new g(false);
        return;
    L5:
        if (r101 == 2) goto L7;
        this.f488133a = new a();
        return;
    L7:
        this.f488133a = new f();
        if (r100 == null) goto L13;
        r100.setWillNotDraw(false);
        return;
    }

    public final void b(c r100) {
        if (this.f488134b != null) goto L5;
        this.f488134b = new ArrayList();
    L5:
        this.f488134b.add(r100);
    }

    public boolean a(Context r100, int r101) {
        d r102 = this.f488133a.b(r100, r101);
        if (r102 != null) goto L5;
        return true;
    L5:
        c(r102.f488135a, r102.f488136b);
        return true;
    }

    public final void c(boolean r100, int r101) {
        List<c> r102 = this.f488134b;
        if (r102 == null) goto L8;
        Iterator r103 = ((ArrayList) r102).iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        ((c) r103.next()).X6(r100, r101);
        goto L6
    L10:
        return;
    }
}
