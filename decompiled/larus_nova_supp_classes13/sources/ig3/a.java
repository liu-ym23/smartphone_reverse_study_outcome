package ig3;

import android.net.Uri;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.error.c;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.fps.OrderCommonFpsMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.skeleton.OrderCommonSkeletonMonitor;
import hg3.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final Map<String, a> h = null;
    public final OrderCommonFirstScreenMonitor a;
    public final OrderCommonFpsMonitor b;
    public OrderCommonBusinessMonitor c;
    public hg3.b d;
    public OrderCommonSkeletonMonitor e;
    public c f;
    public d g;

    /* JADX INFO: renamed from: ig3.a$a, reason: collision with other inner class name */
    public static final class C0206a {
        public static a a(String r1) {
            if (r1 != null) goto L5;
            return null;
        L5:
            return (a) ((LinkedHashMap) a.h).get(r1);
        }

        public static a b(String r2, String r3, MonitorScenes r4, Uri r5) {
            Intrinsics.checkNotNullParameter(r2, "sessionId");
            Intrinsics.checkNotNullParameter("ies_ecommerce_fe_custom_log", "durationBusiness");
            Intrinsics.checkNotNullParameter(r3, "yataBizCode");
            Intrinsics.checkNotNullParameter(r4, "fpsMonitorScenes");
            Intrinsics.checkNotNullParameter(r5, "uri");
            a r0 = new a(r3, r4, r5);
            a.h.put(r2, r0);
            return r0;
        }
    }

    static {
        h = new LinkedHashMap();
    }

    public a(String r2, MonitorScenes r3, Uri r4) {
        this.a = new OrderCommonFirstScreenMonitor(r2, r4);
        this.b = new OrderCommonFpsMonitor(r3);
    }
}
