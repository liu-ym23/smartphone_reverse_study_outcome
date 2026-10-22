package pk3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final String a;
    public final Map<String, String> b;

    public a(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "prefetchedUrl");
        this.a = r2;
        this.b = r3;
    }
}
