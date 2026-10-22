package s1;

import android.content.Context;
import com.apm.lite.CrashType;
import com.apm.lite.k.r;

/* JADX INFO: loaded from: classes39.dex */
public final class a extends d {
    public a(Context r100, c r101, e r102) {
        super(CrashType.ANR, r100, r101, r102);
    }

    @Override // s1.d
    public final k1.a b(k1.a r100) {
        k1.c r101 = k1.c.a();
        k1.c.d(r101);
        k1.c.f(r101);
        r101.i();
        r101.j();
        r101.l();
        r100.f(r101);
        r100.b("process_name", com.apm.lite.k.a.i());
        r.a(r100, r101, this.f540104a);
        return r100;
    }
}
