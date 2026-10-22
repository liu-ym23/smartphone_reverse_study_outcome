package mf6;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends b {
    @Override // mf6.a
    public final void d(float r100) {
    }

    @Override // mf6.a
    public final void a(float r100) {
        if (((ArrayList) this.f513641d).size() == 0) goto L17;
        Iterator r101 = ((ArrayList) this.f513641d).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        if (((a) r101.next()).b() == true) goto L6;
        boolean r102 = false;
    L11:
        if (r102 == true) goto L22;
        Iterator r103 = ((ArrayList) this.f513641d).iterator();
    L15:
        if (r103.hasNext() == false) goto L23;
        ((a) r103.next()).a(r100);
        goto L15
    L23:
        return;
    L22:
        return;
    L10:
        r102 = true;
        this.f513642e = true;
        c();
        goto L11
    }

    public c(long r100, Function0 r101) {
        super(r100, r101);
    }
}
