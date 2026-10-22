package pc7;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        b(4, r100, r101, null);
    }

    public static void b(int r100, String r101, String r102, Throwable r103) {
        if (r100 != 2) goto L5;
        tb7.a.f545271a.b(2, "UCTwiceVerify", r101 + ": " + r102, null);
        return;
    L5:
        if (r100 != 4) goto L7;
        tb7.a.d("UCTwiceVerify", r101 + ": " + r102);
        return;
    L7:
        if (r100 != 5) goto L9;
        tb7.a.f("UCTwiceVerify", r101 + ": " + r102, r103);
        return;
    L9:
        if (r100 == 6) goto L11;
        tb7.a.a("UCTwiceVerify", r101 + ": " + r102);
        return;
    L11:
        tb7.a.c("UCTwiceVerify", r101 + ": " + r102, r103);
    }
}
