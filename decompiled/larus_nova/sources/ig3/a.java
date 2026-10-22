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

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, a> f489718h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OrderCommonFirstScreenMonitor f489719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OrderCommonFpsMonitor f489720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OrderCommonBusinessMonitor f489721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public hg3.b f489722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OrderCommonSkeletonMonitor f489723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f489724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f489725g;

    /* JADX INFO: renamed from: ig3.a$a, reason: collision with other inner class name */
    public static final class C6262a {
        public static a a(String r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            return (a) ((LinkedHashMap) a.f489718h).get(r100);
        }

        public static a b(String r100, String r101, MonitorScenes r102, Uri r103) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            Intrinsics.checkNotNullParameter("ies_ecommerce_fe_custom_log", "durationBusiness");
            Intrinsics.checkNotNullParameter(r101, "yataBizCode");
            Intrinsics.checkNotNullParameter(r102, "fpsMonitorScenes");
            Intrinsics.checkNotNullParameter(r103, "uri");
            a r104 = new a(r101, r102, r103);
            a.f489718h.put(r100, r104);
            return r104;
        }
    }

    static {
        f489718h = new LinkedHashMap();
    }

    public a(String r100, MonitorScenes r101, Uri r102) {
        this.f489719a = new OrderCommonFirstScreenMonitor(r100, r102);
        this.f489720b = new OrderCommonFpsMonitor(r101);
    }
}
