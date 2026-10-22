package g93;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Boolean> f480506a = null;

    /* JADX INFO: renamed from: g93.a$a, reason: collision with other inner class name */
    public static final class C5995a {
    }

    public a() {
    }

    static {
        f480506a = new HashMap();
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return !Intrinsics.areEqual(f480506a.get(r100), Boolean.FALSE);
    }

    public static void b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        f480506a.put(r100, Boolean.valueOf(r101));
    }
}
