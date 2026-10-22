package s1;

import android.content.Context;
import com.apm.lite.CrashType;
import com.apm.lite.k.r;

/* JADX INFO: loaded from: classes39.dex */
public final class i extends d {
    public i(Context r100, c r101, e r102) {
        super(CrashType.JAVA, r100, r101, r102);
    }

    @Override // s1.d
    public final k1.a a(int r100, k1.a r101) {
        k1.a r102 = super.a(r100, r101);
        if (r100 == 0) goto L13;
        if (r100 != 1) goto L6;
        k1.c r103 = r102.q();
        r103.j();
        r103.l();
    L14:
        return r102;
    L6:
        if (r100 != 2) goto L8;
        k1.c.d(r102.q());
        goto L14
    L8:
        if (r100 != 5) goto L14;
        k1.c.f(r102.q());
        goto L14
    L13:
        r102.b("app_count", 1);
        r102.b("magic_tag", "ss_app_log");
        k1.c r104 = k1.c.a();
        r104.i();
        r102.f(r104);
        r.a(r102, r104, this.f540104a);
        goto L14
    }
}
