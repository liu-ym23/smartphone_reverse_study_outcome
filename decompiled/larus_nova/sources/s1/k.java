package s1;

import android.content.Context;
import com.apm.lite.CrashType;
import com.apm.lite.k.r;

/* JADX INFO: loaded from: classes39.dex */
public final class k extends d {
    public k(Context r100, c r101, e r102) {
        super(CrashType.NATIVE, r100, r101, r102);
    }

    @Override // s1.d
    public final k1.a a(int r100, k1.a r101) {
        k1.a r102 = super.a(r100, r101);
        if (r100 != 0) goto L5;
        k1.c r103 = k1.c.a();
        r103.i();
        r102.f(r103);
        r.a(r102, r103, this.f540104a);
    L12:
        return r102;
    L5:
        if (r100 != 1) goto L7;
        k1.c r104 = r102.q();
        r104.j();
        r104.l();
        goto L12
    L7:
        if (r100 != 2) goto L12;
        k1.c.d(r102.q());
        goto L12
    }

    @Override // s1.d
    public final boolean d() {
        return false;
    }

    @Override // s1.d
    public final void e() {
    }

    @Override // s1.d
    public final void f() {
    }
}
