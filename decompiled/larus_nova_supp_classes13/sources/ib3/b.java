package ib3;

import com.bytedance.android.shopping.cart_common.repo.CartCommonRepository;
import com.bytedance.kmp.ec.yata.event.common.j;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements j {
    public b() {
    }

    public final Map<String, Object> a(List<? extends com.bytedance.kmp.ec.yata.store.node.c> r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "nodeList");
        Intrinsics.checkNotNullParameter(r3, "params");
        Object r4 = r3.get("current_word");
        if ((r4 instanceof String) == true) goto L5;
        r4 = null;
    L5:
        String r5 = (String) r4;
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        return MapsKt.mapOf(TuplesKt.to("new_history_words", CartCommonRepository.a(r5)));
    }
}
