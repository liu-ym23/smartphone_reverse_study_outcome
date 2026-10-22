package x75;

import com.bytedance.ee.drive.render.j;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final ConcurrentHashMap<String, j> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final j a(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return null;
    L12:
        return a.get(r1);
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @JvmStatic
    public static final String b(j r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        String r0 = UUID.randomUUID().toString();
        a.put(r0, r2);
        return r0;
    }
}
