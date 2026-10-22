package gb3;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final Map<String, Object> a;
    public final Set<String> b;
    public final EventActionImpl c;

    public a(String r4, String r5) {
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        if (r4 != null) goto L5;
        r4 = "product_card_list_page";
    L5:
        r0[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r4);
        r0[2] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        if (r5 != null) goto L8;
        r5 = "none";
    L8:
        r0[3] = TuplesKt.to("page_type", r5);
        this.a = MapsKt.mutableMapOf(r0);
        this.b = new LinkedHashSet();
        this.c = new EventActionImpl();
    }

    public final void a(String r2, Map<String, ? extends Object> r3, PageFinder r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "params");
        if (k.c(r5) == true) goto L5;
    L7:
        if (r5 == null) goto L9;
        this.b.add(r5);
    L9:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.putAll(this.a);
        r6.putAll(r3);
        this.c.doEventAction(r2, r4, r6);
        return;
    L5:
        if (CollectionsKt.contains(this.b, r5) == false) goto L7;
    }
}
