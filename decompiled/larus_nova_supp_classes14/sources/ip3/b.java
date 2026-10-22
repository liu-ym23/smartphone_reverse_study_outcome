package ip3;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends hp3.b {
    public final a b;

    @Override // hp3.b
    public final Map<String, Object> a() {
        a r0 = this.b;
        boolean r3 = false;
        Map<String, Object> r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("item_type", Integer.valueOf(r0.a)), TuplesKt.to("unique_id", r0.b), TuplesKt.to("category_id", r0.e), TuplesKt.to("nearest_dynamic_insert_distance", Integer.valueOf(r0.f))});
        if ((!r0.c.isEmpty()) == false) goto L6;
        r1.put("dynamic_insert_data", r0.c);
    L6:
        if (r0.d.length() <= 0) goto L8;
        r3 = true;
    L8:
        if (r3 == false) goto L10;
        r1.put("surrounded_product_ids", r0.d);
    L10:
        return r1;
    }

    public b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "bean");
        super("windowCardClicked");
        this.b = r2;
    }
}
