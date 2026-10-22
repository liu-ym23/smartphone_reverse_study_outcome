package n83;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final String a;
    public final HashMap<String, String> b;

    public d(String r2, HashMap<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "newSchema");
        this.a = r2;
        this.b = r3;
    }
}
