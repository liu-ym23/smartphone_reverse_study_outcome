package po5;

import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f530070b = null;

    static {
        f530070b = new f();
    }

    public f() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r100, Map r101) {
        a.f530050a.getClass();
        mo5.g r102 = a.C7218a.a(r100, r101);
        if (r102 != null) goto L6;
        tt5.a.k("TtsOpenContentCommand", "handleAction, targetVM not found.");
        return false;
    L6:
        mo5.f r103 = ((mo5.e) org.koin.java.a.c(mo5.e.class, null, null, 6)).V6(false);
        if (r103 == null) goto L11;
        r103.e();
        r103.b();
        r103.f();
        r103.h();
        r103.k().a(r102);
        return true;
    L11:
        return true;
    }
}
