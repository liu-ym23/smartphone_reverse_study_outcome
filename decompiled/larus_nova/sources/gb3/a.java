package gb3;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.extensions.k;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f480676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f480677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EventActionImpl f480678c;

    public a(String r100, String r101) {
        Pair[] r102 = new Pair[4];
        r102[0] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        if (r100 != null) goto L5;
        r100 = "product_card_list_page";
    L5:
        r102[1] = TuplesKt.to("page_name", r100);
        r102[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        if (r101 != null) goto L8;
        r101 = "none";
    L8:
        r102[3] = TuplesKt.to("page_type", r101);
        this.f480676a = MapsKt.mutableMapOf(r102);
        this.f480677b = new LinkedHashSet();
        this.f480678c = new EventActionImpl();
    }

    public final void a(String r100, Map<String, ? extends Object> r101, PageFinder r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (k.c(r103) == true) goto L5;
    L7:
        if (r103 == null) goto L9;
        this.f480677b.add(r103);
    L9:
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(this.f480676a);
        r104.putAll(r101);
        this.f480678c.doEventAction(r100, r102, r104);
        return;
    L5:
        if (CollectionsKt.contains(this.f480677b, r103) == false) goto L7;
    }
}
