package n4a;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes32.dex */
public final class j3 extends h3<k3> {
    public j3(Context r100, Handler r101) {
        super(r100, "cellAge", r101);
    }

    @Override // n4a.h3
    public final long c() {
        return 120000;
    }

    @Override // n4a.h3
    public final long g() {
        return 100;
    }

    @Override // n4a.h3
    public final String d(k3 r100) {
        k3 r101 = r100;
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101.a();
    }

    @Override // n4a.h3
    public final int f(k3 r100) {
        k3 r101 = r100;
        if (r101 != null) goto L6;
        return 99;
    L6:
        return r101.f517449r;
    }

    @Override // n4a.h3
    public final long h(k3 r100) {
        k3 r101 = r100;
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.f517450s;
    }

    @Override // n4a.h3
    public final void a(k3 r100, long r101) {
        k3 r102 = r100;
        if (r102 == null) goto L6;
        r102.f517450s = r101;
        return;
    }
}
