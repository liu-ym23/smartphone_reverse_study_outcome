package n4a;

import android.content.Context;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class c5 extends l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f517216b;

    public c5(Context r100) {
        this.f517216b = r100;
    }

    @Override // n4a.l1
    public final void a() {
        Iterator<File> r100 = com.loc.u.c(com.loc.u.h(this.f517216b)).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        File r101 = r100.next();
        com.loc.u.a(this.f517216b, r101.getName());
        goto L4
    L6:
        com.loc.u.d(this.f517216b);
    }
}
