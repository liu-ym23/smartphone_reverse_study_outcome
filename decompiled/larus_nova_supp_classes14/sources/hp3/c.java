package hp3;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends b {
    public final long b;
    public final long c;
    public final String d;

    @Override // hp3.b
    public final Map<String, Object> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("sort_type", Long.valueOf(this.b)), TuplesKt.to("sort", Long.valueOf(this.c)), TuplesKt.to("name", this.d)});
    }

    public c(long r2, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "name");
        super("sortBarClicked");
        this.b = r2;
        this.c = r4;
        this.d = r6;
    }
}
