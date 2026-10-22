package n35;

import k25.e0;
import k25.m0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static m0 a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "token");
        m0 r0 = e0.m().A("FakeTokenKeyFromNative", r3, 0);     // Catch: Exception -> L8
        if (r0 == null) goto L6;
        return r0;
    L6:
        return (m0) ay4.b.d("document", 6).getJSONObject("FakeTokenKeyFromNative-" + r3, m0.class);
    L8:
        e = move-exception;
        tt5.a.d("TokenMappingHelper", "getTokenMapping error " + e.getMessage());
        return null;
    }
}
