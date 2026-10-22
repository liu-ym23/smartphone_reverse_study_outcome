package sa5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class f implements o {
    public final List<e> a;

    public final boolean a() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((e) r0.next()).j() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public f() {
        this.a = new ArrayList();
    }

    @Override // sa5.o
    public final void Xi(e r2) {
        if (((ArrayList) this.a).contains(r2) == true) goto L6;
        ((ArrayList) this.a).add(r2);
        return;
    }

    @Override // sa5.o
    public final e vb(Class r4) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        e r1 = (e) r0.next();
        if (r4.isAssignableFrom(r1.getClass()) == false) goto L4;
        return r1;
    L8:
        return null;
    }
}
