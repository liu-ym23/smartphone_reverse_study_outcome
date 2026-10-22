package hp3;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends b {
    public final String b;

    @Override // hp3.b
    public final Map<String, Object> a() {
        return MapsKt.mapOf(TuplesKt.to("current", this.b));
    }

    public d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "current");
        super("windowTabSwitch");
        this.b = r2;
    }
}
