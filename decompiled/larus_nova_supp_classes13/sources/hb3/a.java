package hb3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final Map<String, Map<String, Object>> a;

    /* JADX INFO: renamed from: hb3.a$a, reason: collision with other inner class name */
    public static final class C0202a {
    }

    static {
    }

    public a() {
        this.a = new LinkedHashMap();
    }

    public final void a(Object r5) {
        Intrinsics.checkNotNullParameter("counter_active", "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r0.next();
        if (((Map) r2.getValue()).containsKey("counter_active") == false) goto L4;
        ((Map) r2.getValue()).put("counter_active", r5);
        goto L4
    }
}
