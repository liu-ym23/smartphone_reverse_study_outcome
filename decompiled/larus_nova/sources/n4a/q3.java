package n4a;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes32.dex */
public final class q3 extends h3<v2> {
    public q3(Context r100, Handler r101) {
        super(r100, "wifiAgee", r101);
    }

    @Override // n4a.h3
    public final long c() {
        return 60000;
    }

    @Override // n4a.h3
    public final long g() {
        return 1000;
    }

    @Override // n4a.h3
    public final String d(v2 r100) {
        v2 r101 = r100;
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101.f517826h + "#" + r101.f517819a;
    }

    @Override // n4a.h3
    public final int f(v2 r100) {
        v2 r101 = r100;
        if (r101 != null) goto L6;
        return -113;
    L6:
        return r101.f517821c;
    }

    @Override // n4a.h3
    public final long h(v2 r100) {
        v2 r101 = r100;
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.f517824f;
    }

    @Override // n4a.h3
    public final void a(v2 r100, long r101) {
        v2 r102 = r100;
        if (r102 == null) goto L6;
        r102.f517824f = r101;
        return;
    }
}
