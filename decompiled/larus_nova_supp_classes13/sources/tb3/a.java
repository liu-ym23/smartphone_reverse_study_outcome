package tb3;

import com.bytedance.android.shopping.collect.container.CollectYataViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static void a(String r1, Map r2, CollectYataViewModel r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r2);
        r0.put("query_type", r1);
        Unit r4 = Unit.INSTANCE;
        r3.doEventAction("collect_list_page_monitor", r0, "collect_list_page_monitor_".concat(r1));
    }
}
