package po5;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f530071b = null;

    static {
        f530071b = new g();
    }

    public g() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r100, Map r101) {
        boolean r102 = false;
        mo5.f r103 = ((mo5.e) org.koin.java.a.c(mo5.e.class, null, null, 6)).V6(false);
        if (r103 == null) goto L13;
        List r104 = (List) r103.k().b().getValue();
        if (r104 != null) goto L7;
    L8:
        r102 = true;
    L9:
        if (r102 == false) goto L12;
        r103.j();
        return true;
    L12:
        r103.e();
        r103.f();
        r103.c();
        r103.d();
        goto L13
    L7:
        if (r104.isEmpty() == false) goto L9;
    L13:
        return true;
    }
}
