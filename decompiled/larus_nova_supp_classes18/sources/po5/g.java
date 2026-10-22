package po5;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements a {
    public static final g b = null;

    static {
        b = new g();
    }

    public g() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r3, Map r4) {
        boolean r5 = false;
        mo5.f r6 = ((mo5.e) org.koin.java.a.c(mo5.e.class, null, null, 6)).V6(false);
        if (r6 == null) goto L13;
        List r1 = (List) r6.k().b().getValue();
        if (r1 != null) goto L7;
    L8:
        r5 = true;
    L9:
        if (r5 == false) goto L12;
        r6.j();
        return true;
    L12:
        r6.e();
        r6.f();
        r6.c();
        r6.d();
        goto L13
    L7:
        if (r1.isEmpty() == false) goto L9;
    L13:
        return true;
    }
}
