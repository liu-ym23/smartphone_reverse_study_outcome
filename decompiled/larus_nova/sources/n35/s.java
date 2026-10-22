package n35;

import k25.e0;
import k25.m0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f516973a = 0;

    static {
    }

    public static m0 a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        m0 r101 = e0.m().A("FakeTokenKeyFromNative", r100, 0);     // Catch: Exception -> L8
        if (r101 == null) goto L6;
        return r101;
    L6:
        return (m0) ay4.b.d("document", 6).getJSONObject("FakeTokenKeyFromNative-" + r100, m0.class);
    L8:
        e = move-exception;
        tt5.a.d("TokenMappingHelper", "getTokenMapping error " + e.getMessage());
        return null;
    }
}
