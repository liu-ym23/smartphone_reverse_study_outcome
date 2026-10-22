package ep3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements c {
    public final Map<String, Function1<String, Object>> a;

    public a() {
        this.a = new LinkedHashMap();
    }

    @Override // ep3.c
    public final Object a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Function1 r0 = (Function1) ((LinkedHashMap) this.a).get(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.invoke(r2);
    }

    public final void b(String r2, Function1<? super String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.put(r2, r3);
    }
}
