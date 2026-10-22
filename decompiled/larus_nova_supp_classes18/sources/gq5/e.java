package gq5;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final String a(String r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return du5.b.g(r0);
    }

    public static final void c(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).u(r3, r4);
    }

    public static final <T> void b(JSONObject r1, String r2, T r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 == null) goto L6;
        r1.put(r2, r3);
        return;
    }
}
