package tqb;

import com.ss.android.lark.lynxkit.host.LarkLynxHostOptions;
import com.ss.android.lark.lynxkit.host.LarkLynxHostParams;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, d> f547248a = null;

    public f() {
    }

    static {
        f547248a = new ConcurrentHashMap();
    }

    public static d a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return null;
    L12:
        return f547248a.get(r100);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static void c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        f547248a.remove(r100);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static String b(LarkLynxHostParams r100, LarkLynxHostOptions r101, boolean r102, g r103) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "options");
        String r104 = UUID.randomUUID().toString();
        f547248a.put(r104, new d(r100, r101, r102, r103));
        return r104;
    }
}
