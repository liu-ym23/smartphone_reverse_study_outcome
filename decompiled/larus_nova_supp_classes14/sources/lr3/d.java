package lr3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public final int a;
    public Map<String, String> b;
    public final Object c;

    public d(int r2, Map<String, String> r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "header");
        this.a = r2;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.b = r3;
        this.c = r4;
    }
}
