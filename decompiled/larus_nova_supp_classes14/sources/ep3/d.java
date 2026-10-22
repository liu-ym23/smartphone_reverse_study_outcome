package ep3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements c {
    public final Map<String, Object> a;

    public d(Map<String, ? extends Object> r2) {
        LinkedHashMap r0 = new LinkedHashMap();
        this.a = r0;
        r0.putAll(r2);
    }

    @Override // ep3.c
    public final Object a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return ((LinkedHashMap) this.a).get(r2);
    }
}
