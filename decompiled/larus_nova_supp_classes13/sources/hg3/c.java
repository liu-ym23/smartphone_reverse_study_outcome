package hg3;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final Map<String, String> a;

    public static final class a {
    }

    static {
    }

    public c(WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "reporter");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("desc", "order_list_preload");
        r4.put("type", "COMMON_LOG");
        Unit r0 = Unit.INSTANCE;
        this.a = r4;
    }
}
