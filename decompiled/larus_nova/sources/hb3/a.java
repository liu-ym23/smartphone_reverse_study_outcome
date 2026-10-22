package hb3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f484485a;

    /* JADX INFO: renamed from: hb3.a$a, reason: collision with other inner class name */
    public static final class C6122a {
    }

    static {
    }

    public a() {
        this.f484485a = new LinkedHashMap();
    }

    public final void a(Object r100) {
        Intrinsics.checkNotNullParameter("counter_active", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        Iterator r101 = ((LinkedHashMap) this.f484485a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (((Map) r102.getValue()).containsKey("counter_active") == false) goto L4;
        ((Map) r102.getValue()).put("counter_active", r100);
        goto L4
    }
}
