package g93;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final HashMap<String, Boolean> a = null;

    /* JADX INFO: renamed from: g93.a$a, reason: collision with other inner class name */
    public static final class C0198a {
    }

    public a() {
    }

    static {
        a = new HashMap();
    }

    public static boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "id");
        return !Intrinsics.areEqual(a.get(r1), Boolean.FALSE);
    }

    public static void b(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "id");
        a.put(r1, Boolean.valueOf(r2));
    }
}
