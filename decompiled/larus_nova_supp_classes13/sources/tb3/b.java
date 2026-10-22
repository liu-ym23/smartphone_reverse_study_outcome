package tb3;

import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final EventActionImpl a;
    public final Set<String> b;
    public final Map<String, String> c;

    public b() {
        this.a = new EventActionImpl();
        this.b = new LinkedHashSet();
        this.c = MapsKt.mapOf(new Pair[]{TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "collect_list_page")});
    }
}
