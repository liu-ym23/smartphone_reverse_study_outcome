package mb3;

import com.bytedance.android.shopping.collect.util.c;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final List<Pair<String, j>> a;

    public a(com.bytedance.android.shopping.collect.controller.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = CollectionsKt.listOf(TuplesKt.to("productsCleanUp", new c(r2).a));
    }
}
