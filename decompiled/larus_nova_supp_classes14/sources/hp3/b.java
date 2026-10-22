package hp3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b {
    public final String a;

    public abstract Map<String, Object> a();

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        this.a = r2;
    }
}
