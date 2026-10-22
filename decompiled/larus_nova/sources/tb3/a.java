package tb3;

import com.bytedance.android.shopping.collect.container.CollectYataViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f545246a = 0;

    public a() {
    }

    static {
    }

    public static void a(String r100, Map r101, CollectYataViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r101);
        r103.put("query_type", r100);
        Unit r104 = Unit.INSTANCE;
        r102.doEventAction("collect_list_page_monitor", r103, "collect_list_page_monitor_".concat(r100));
    }
}
