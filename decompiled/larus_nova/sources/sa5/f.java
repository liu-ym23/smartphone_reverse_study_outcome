package sa5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class f implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f541167a;

    public final boolean a() {
        Iterator r100 = ((ArrayList) this.f541167a).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (((e) r100.next()).j() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public f() {
        this.f541167a = new ArrayList();
    }

    @Override // sa5.o
    public final void Xi(e r100) {
        if (((ArrayList) this.f541167a).contains(r100) == true) goto L6;
        ((ArrayList) this.f541167a).add(r100);
        return;
    }

    @Override // sa5.o
    public final e vb(Class r100) {
        Iterator r101 = ((ArrayList) this.f541167a).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        e r102 = (e) r101.next();
        if (r100.isAssignableFrom(r102.getClass()) == false) goto L4;
        return r102;
    L8:
        return null;
    }
}
