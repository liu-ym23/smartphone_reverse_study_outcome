package s67;

import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f540828a;

    public static void a(Throwable r100, String r101) {
        Boolean r102 = f540828a;
        if (r102 != null) goto L5;
    L11:
        EnsureManager.ensureNotReachHere(r100, r101);     // Catch: Throwable -> L9
        f540828a = Boolean.TRUE;     // Catch: Throwable -> L9
        return;
    L9:
        f540828a = Boolean.FALSE;
        return;
    L5:
        if (r102.booleanValue() == true) goto L11;
    }
}
