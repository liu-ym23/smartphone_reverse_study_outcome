package gy7;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<q, q> f483352a = null;

    static {
        LinkedHashMap r100 = new LinkedHashMap();
        q r101 = r.f483351a;
        r100.put(r101, r101);
        f483352a = r100;
    }

    public static q a(q r100) {
        Intrinsics.checkNotNullParameter(r100, "userSession");
        return (q) ((LinkedHashMap) f483352a).get(r100);
    }
}
