package hg3;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final Map<String, Object> a;

    /* JADX INFO: renamed from: hg3.a$a, reason: collision with other inner class name */
    public static final class C0204a {
    }

    static {
    }

    public a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "desc");
        this.a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "COMMON_LOG"), TuplesKt.to("desc", r5)});
    }
}
