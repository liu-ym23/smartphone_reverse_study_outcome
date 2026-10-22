package hu8;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f487259a = null;

    static {
        f487259a = Keva.getRepo("boot_protector_repo", 1);
    }

    public static int a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return f487259a.getInt(r100, r101);
    }

    public static void b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        f487259a.storeInt(r100, r101);
    }

    public static void c(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        String r102 = new Gson().toJson(r101);     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Exception -> L5
        f487259a.storeString(r100, r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        String r103 = e.getMessage();
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        nu8.a.e("BootProtectorRepo", r103);
    }
}
