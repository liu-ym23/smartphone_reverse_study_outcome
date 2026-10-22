package tb3;

import com.bytedance.android.shopping.base.event.EventActionImpl;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventActionImpl f545247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f545248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f545249c;

    public b() {
        this.f545247a = new EventActionImpl();
        this.f545248b = new LinkedHashSet();
        this.f545249c = MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI), TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("page_name", "collect_list_page")});
    }
}
