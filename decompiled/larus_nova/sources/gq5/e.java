package gq5;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class e {
    public static final String a(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return du5.b.g(r100);
    }

    public static final void c(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).u(r100, r101);
    }

    public static final <T> void b(JSONObject r100, String r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 == null) goto L6;
        r100.put(r101, r102);
        return;
    }
}
