package hp3;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends b {
    public final String b;
    public final Map<String, Object> c;

    @Override // hp3.b
    public final Map<String, Object> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("action_type", this.b), TuplesKt.to("action_params", this.c)});
    }

    public a(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "actionParams");
        super("windowDynamicCardClicked");
        this.b = r2;
        this.c = r3;
    }
}
