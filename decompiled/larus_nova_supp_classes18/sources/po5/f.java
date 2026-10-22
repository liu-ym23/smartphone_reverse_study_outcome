package po5;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements a {
    public static final f b = null;

    static {
        b = new f();
    }

    public f() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r4, Map r5) {
        a.a.getClass();
        mo5.g r6 = a.C0291a.a(r4, r5);
        if (r6 != null) goto L6;
        tt5.a.k("TtsOpenContentCommand", "handleAction, targetVM not found.");
        return false;
    L6:
        mo5.f r7 = ((mo5.e) org.koin.java.a.c(mo5.e.class, null, null, 6)).V6(false);
        if (r7 == null) goto L11;
        r7.e();
        r7.b();
        r7.f();
        r7.h();
        r7.k().a(r6);
        return true;
    L11:
        return true;
    }
}
