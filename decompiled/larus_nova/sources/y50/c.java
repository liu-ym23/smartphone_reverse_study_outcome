package y50;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.livesdk.chatroom.utils.g4;
import com.bytedance.android.livesdk.config.b0;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements com.bytedance.android.livesdk.chatroom.utils.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f566205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, q> f566206b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PriorityQueue<r> f566207c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f566208d = null;

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f566209a = null;

        static {
            f566209a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((r) r101).f566228a - ((r) r100).f566228a;
        }
    }

    public c() {
    }

    static {
        f566208d = new c();
        f566206b = new HashMap();
        f566207c = new PriorityQueue(100, a.f566209a);
    }

    public static void d() {
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L5;
        return;
    L5:
        Map<String, WidgetCostModule> r100 = WidgetPerfManager.getInstance().getWidgetMap();
        f566207c.clear();
        Iterator<Map.Entry<String, WidgetCostModule>> r101 = r100.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<String, WidgetCostModule> r102 = r101.next();
        r r103 = new r(r102.getKey(), r102.getValue());
        if (r103.f566228a >= 9999) goto L7;
        f566207c.offer(r103);
        goto L7
    L11:
        int r104 = Math.min(f566207c.size(), 10);
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L17;
        r r106 = f566207c.poll();
        if (r106 == null) goto L15;
        HashMap<String, q> r107 = f566206b;
        String r108 = "widget_main_cost_" + r106.f566229b;
        q r109 = new q();
        r109.f566226c = r106.f566228a;
        Unit r110 = Unit.INSTANCE;
        r107.put(r108, r109);
        r105 = r105 + 1;
        goto L12
    L15:
        return;
    L17:
        f566207c.clear();
    }

    public static void e() {
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L5;
        return;
    L5:
        LiveMonitor.a r100 = new LiveMonitor.a("ttlive_anchor_inter_biz_cost_monitor", LiveTracingMonitor.EventModule.OPEN_LIVE);
        r100.l(0);
        r100.f64904g = true;
        r100.f64903f = true;
        c(r100);
        Iterator<Map.Entry<String, q>> r101 = f566206b.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<String, q> r102 = r101.next();
        if (r102.getValue().f566226c <= 0) goto L7;
        r100.g(r102.getKey(), r102.getValue().f566226c);
        goto L7
    L11:
        r100.a().report();
        f566206b.clear();
    }

    public static void c(LiveMonitor.a r100) {
        r100.c("live");
        float r101 = z0.b(true);
        if (r101 < 8.0d) goto L6;
        String r102 = "1";
    L12:
        r100.e("is_continue_room", m2.b(f566205a));
        r100.e("device_score", r102);
        r100.e("load_opt_config", m2.b(b0.a()));
        return;
    L6:
        if (r101 < 6.0f) goto L9;
        r102 = "2";
        goto L12
    L9:
        if (r101 <= 0) goto L11;
        r102 = "3";
        goto L12
    L11:
        r102 = "0";
        goto L12
    }

    public static void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ALogger.i("RoomContextInitError", r100);
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L6;
        return;
    L6:
        if (b0.a() == true) goto L8;
        return;
    L8:
        LiveMonitor.a r101 = new LiveMonitor.a("ttlive_anchor_inter_biz_error_monitor", LiveTracingMonitor.EventModule.OPEN_LIVE);
        r101.l(0);
        r101.f64904g = true;
        r101.f64903f = true;
        r101.e(IPerformanceManager.Params.is_anchor, m2.b(b0.f119832a));
        r101.e("error_type", r100);
        r101.i("error_reason", r100);
        c(r101);
        r101.a().report();
        SafetyGuard.a(null, new Exception("RoomContextInitError"), "RoomContextInitError ".concat(r100));
    }

    public static long g(String r110) {
        Intrinsics.checkNotNullParameter(r110, "name");
        long r100 = -1;
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L5;
        return -1;
    L5:
        HashMap<String, q> r101 = f566206b;
        q r102 = r101.get("inter_load_total");
        if (r102 != null) goto L8;
    L24:
        return r100;
    L8:
        if (r102.f566224a > 0) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 != true) goto L24;
        if (r101.get(r110) != null) goto L18;
        r101.put(r110, new q());
    L18:
        r100 = System.currentTimeMillis();
        q r104 = r101.get(r110);
        if (r104 == null) goto L21;
        r104.f566224a = r100;
    L21:
        q r111 = r101.get(r110);
        if (r111 == null) goto L24;
        r111.f566227d = r100;
        goto L24
    L10:
        if (r102.f566225b != 0) goto L12;
        r103 = true;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.h
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L5;
        return;
    L5:
        q r101 = f566206b.get(r100);
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.f566224a == 0) goto L12;
        long r102 = System.currentTimeMillis();
        r101.f566225b = r102;
        r101.f566226c = r102 - r101.f566224a;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.h
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L6;
        return;
    L6:
        if (g4.f114481a != null) goto L8;
        g4.f114481a = this;
    L8:
        f566206b.put(r100, new q());
    }

    public static void h(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L5;
        return;
    L5:
        if (r101 == (-1)) goto L27;
        HashMap<String, q> r102 = f566206b;
        q r103 = r102.get("inter_load_total");
        if (r103 != null) goto L10;
        return;
    L10:
        if (r103.f566224a > 0) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 != true) goto L28;
        q r105 = r102.get(r100);
        if (r105 != null) goto L20;
        return;
    L20:
        if (r105.f566227d != r101) goto L26;
        long r106 = System.currentTimeMillis();
        r105.f566225b = r106;
        r105.f566226c += r106 - r105.f566224a;
        return;
    L26:
        return;
    L28:
        return;
    L12:
        if (r103.f566225b != 0) goto L14;
        r104 = true;
        goto L15
    }
}
