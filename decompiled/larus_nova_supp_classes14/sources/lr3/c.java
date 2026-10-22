package lr3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public final String a;
    public final String b;
    public final Boolean c;
    public final Map<String, String> d;
    public final Map<String, String> e;
    public final Object f;

    public c(String r3, String r4, Map r5, Object r6, int r7) {
        if ((r7 & 16) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 32) == 0) goto L8;
        r6 = null;
    L8:
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "method");
        this.a = r3;
        this.b = r4;
        this.c = null;
        this.d = null;
        this.e = r5;
        this.f = r6;
    }
}
