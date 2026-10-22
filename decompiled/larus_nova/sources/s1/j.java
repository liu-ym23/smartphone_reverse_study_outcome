package s1;

import android.content.Context;
import com.apm.lite.CrashType;
import com.apm.lite.k.r;

/* JADX INFO: loaded from: classes39.dex */
public final class j extends d {
    public j(Context r100, c r101, e r102) {
        super(CrashType.LAUNCH, r100, r101, r102);
    }

    @Override // s1.d
    public final k1.a a(int r100, k1.a r101) {
        k1.a r102 = super.a(r100, r101);
        if (r100 != 0) goto L5;
        k1.c r103 = k1.c.a();
        r103.i();
        r102.f(r103);
        r.a(r102, r103, this.f540104a);
    L17:
        return r102;
    L5:
        if (r100 != 1) goto L7;
        k1.c r104 = r102.q();
        r104.j();
        r104.l();
        goto L17
    L7:
        if (r100 != 2) goto L9;
        k1.c.d(r102.q());
        r102.q().f501337a.put("launch_did", n1.a.a(this.f540105b));     // Catch: Throwable -> L18
        goto L17
    L9:
        if (r100 != 5) goto L17;
        k1.c.f(r102.q());
        goto L17
    }
}
