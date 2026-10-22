package ev0;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;
import com.bytedance.android.live.profit.taskcenter.panel.trace.LiveTaskPanelTraceMonitor;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f474195f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f474196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityQueue<PanelInfo> f474197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ev0.b> f474198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ev0.a> f474199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HybridDialog f474200e;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((PanelInfo) r101).f89047f), Integer.valueOf(((PanelInfo) r100).f89047f));
        }
    }

    public static final class b {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        StringBuilder r100 = new StringBuilder("showNextPanel start currentPanel.state=");
        PanelInfo r101 = this.f474197b.peek();
        HybridDialog r102 = null;
        if (r101 == null) goto L7;
        PropertyOwner r103 = r101.f89043b;
        if (r103 == null) goto L7;
        PanelInfo.State r104 = (PanelInfo.State) r103.f64752a;
    L8:
        r100.append(r104);
        a(r100.toString());
        PanelInfo r105 = this.f474197b.peek();
        if (r105 != null) goto L12;
        return;
    L12:
        if (((PanelInfo.State) r105.f89043b.f64752a) != PanelInfo.State.WAITING) goto L42;
        a("checkMutexStrategy");
        List<ev0.b> r106 = this.f474198c;
        if ((r106 instanceof Collection) == true) goto L16;
    L18:
        Iterator r107 = ((ArrayList) r106).iterator();
    L20:
        if (r107.hasNext() == false) goto L24;
        if (((ev0.b) r107.next()).c(r105) == true) goto L20;
        boolean r108 = false;
    L25:
        if (r108 == false) goto L43;
        r105.a(PanelInfo.State.READY, null);
        a("showNextPanel showHybridDialog");
        StringBuilder r109 = new StringBuilder("showHybridDialog start curState=");
        PropertyOwner r110 = r105.f89043b;
        if (r110 == null) goto L29;
        PanelInfo.State r111 = (PanelInfo.State) r110.f64752a;
    L30:
        r109.append(r111);
        a(r109.toString());
        Map r112 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("panel_info", String.valueOf(r105))});
        if (x40.h.a().booleanValue() == false) goto L33;
        com.bytedance.android.livesdk.chatroom.monitor.d r113 = new com.bytedance.android.livesdk.chatroom.monitor.d();
        r113.f107005c = r105.f89045d;
        r113.d("OPEN_CONTAINER_START");
    L34:
        IBrowserService r114 = (IBrowserService) k.f(IBrowserService.class);
        if (r114 == null) goto L37;
        r102 = r114.showHybridDialog(r105.getContext(), r105.f89045d, new h(r105, r113, this, r112), r105.f89046e, null);
    L37:
        this.f474200e = r102;
        return;
    L33:
        r113 = null;
        goto L34
    L29:
        r111 = null;
        goto L30
    L43:
        return;
    L24:
        r108 = true;
        goto L25
    L16:
        if (((ArrayList) r106).isEmpty() == false) goto L18;
    L42:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public c() {
        this.f474196a = new CompositeDisposable();
        this.f474197b = new PriorityQueue(11, new a());
        this.f474198c = new ArrayList();
        this.f474199d = new ArrayList();
    }

    public static void a(String r100) {
        ALogger.i("TaskPanelManager", r100);
    }

    public static String c(Uri r100) {
        if (r100 != null) goto L28;
    L25:
        return "";
    L28:
        Intrinsics.checkNotNullParameter(r100, "baseUri");     // Catch: Exception -> L27
        LinkedHashMap r101 = new LinkedHashMap();     // Catch: Exception -> L27
        if (r100.isHierarchical() == false) goto L9;
        Iterator<T> r102 = UriProtector.getQueryParameterNames(r100).iterator();     // Catch: Exception -> L27
    L7:
        if (r102.hasNext() == false) goto L9;
        String r103 = (String) r102.next();     // Catch: Exception -> L27
        String r104 = UriProtector.getQueryParameter(r100, r103);     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L27
        r101.put(r103, r104);     // Catch: Exception -> L27
    L9:
        Intrinsics.checkNotNullParameter("url", "key");     // Catch: Exception -> L27
        Object r105 = r101.get("url");     // Catch: Exception -> L27
        if ((r105 instanceof x0) == false) goto L13;
        x0 r106 = (x0) r105;     // Catch: Exception -> L27
    L20:
        if (r106 == null) goto L25;
        Uri r107 = r106.c();     // Catch: Exception -> L27
        if (r107 == null) goto L25;
        String r108 = r107.getPath();     // Catch: Exception -> L27
        if (r108 == null) goto L25;
        return r108;
    L13:
        if ((r105 instanceof String) == false) goto L18;
        int r109 = com.bytedance.revenue.platform.api.core.e.f267507a;     // Catch: Exception -> L27
        Uri r110 = com.bytedance.revenue.platform.api.core.e.a((String) r105);     // Catch: Exception -> L27
        if (r110.isHierarchical() == false) goto L17;
        r106 = new x0(r110);     // Catch: Exception -> L27
    L19:
        r101.put("url", r106);     // Catch: Exception -> L27
        goto L20
    L17:
        r106 = new x0(Uri.EMPTY);     // Catch: Exception -> L27
        goto L19
    L18:
        int r111 = com.bytedance.revenue.platform.api.core.e.f267507a;     // Catch: Exception -> L27
        r106 = new x0(Uri.EMPTY);     // Catch: Exception -> L27
        goto L19
    }

    public static void d(String r100, Map r101) {
        int r102 = LiveTaskPanelTraceMonitor.f89052a;
        LiveTaskPanelTraceMonitor.a(LiveTaskPanelTraceMonitor.EventName.TTLIVE_TASK_PANEL_MANAGE.getEventName(), r100, r101);
    }

    public final void b(Context r210, Uri r211, Bundle r212, com.bytedance.android.live.profit.taskcenter.b r213) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "uri");
        Intrinsics.checkNotNullParameter(r212, "bundle");
        Intrinsics.checkNotNullParameter(r213, "callBack");
        if (this.f474196a.isDisposed() == false) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r211, "uri");
        String r100 = UriProtector.getQueryParameter(r211, "priority_level");
        Dialog r101 = null;
        if (r100 == null) goto L8;
        Integer r102 = Integer.valueOf(CastIntegerProtector.parseInt(r100));
    L9:
        boolean r110 = true;
        if (r102 == null) goto L12;
        int r111 = r102.intValue();
    L13:
        a("addPanel uri=" + r211 + " priority=" + r111);
        Intrinsics.checkNotNullParameter(r211, "uri");
        String r103 = UriProtector.getQueryParameter(r211, "scene");
        if (r103 != null) goto L16;
        String r112 = "";
    L17:
        String r104 = UriProtector.getQueryParameter(r211, "daily_limit");
        if (r104 == null) goto L20;
        int r113 = CastIntegerProtector.parseInt(r104);
    L21:
        String r105 = UriProtector.getQueryParameter(r211, "lifetime_limit");
        if (r105 == null) goto L24;
        int r114 = CastIntegerProtector.parseInt(r105);
    L25:
        String r106 = UriProtector.getQueryParameter(r211, "activity_id");
        if (r106 != null) goto L28;
        String r115 = "";
    L29:
        String r107 = UriProtector.getQueryParameter(r211, "min_interval");
        if (r107 == null) goto L32;
        int r116 = CastIntegerProtector.parseInt(r107);
    L33:
        fv0.a r108 = new fv0.a(r112, r113, r114, r115, r116);
        a("checkFrequencyStrategy");
        List<ev0.a> r109 = this.f474199d;
        if ((r109 instanceof Collection) == true) goto L36;
    L38:
        Iterator r117 = ((ArrayList) r109).iterator();
    L40:
        if (r117.hasNext() == false) goto L44;
        if (((ev0.a) r117.next()).b(r108) == true) goto L40;
        boolean r118 = false;
    L45:
        Boolean r119 = Boolean.valueOf(r118);
        if (r119.booleanValue() == true) goto L49;
        r119 = null;
    L49:
        if (r119 == null) goto L60;
        r119.booleanValue();
        PanelInfo r120 = new PanelInfo(r210, r211, r212, r111, r108, r213);
        d(LiveTaskPanelTraceMonitor.Step.CREATE_PANEL_INFO.getStep(), MapsKt.mapOf(TuplesKt.to("panel_info", r120.toString())));
        a("observePanelState curState=" + ((PanelInfo.State) r120.f89043b.f64752a));
        Map r121 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cur_state", r120.f89043b.f64752a), TuplesKt.to("panel_info", r120.toString())});
        d(LiveTaskPanelTraceMonitor.Step.OBSERVE_PANEL_STATE.getStep(), r121);
        RxUtilKt.c(r120.f89043b.subscribe(new g(this, r120, r121)), this.f474196a);
        if (r111 != 10) goto L58;
        PanelInfo r122 = this.f474197b.peek();
        if (r122 == null) goto L59;
        PanelInfo.State r123 = PanelInfo.State.DISMISSED;
        HybridDialog r124 = this.f474200e;
        if (r124 == null) goto L57;
        r101 = r124.getDialog();
    L57:
        r122.a(r123, r101);
    L59:
        e();
    L61:
        int r125 = hv0.a.f487275a;
        String r126 = c(r211);
        int r127 = this.f474197b.size();
        HashMap r128 = hv0.a.a();
        r128.put("path", r126);
        r128.put("priority", String.valueOf(r111));
        if (r110 == false) goto L64;
        String r129 = "1";
    L65:
        r128.put("is_frequency_pass", r129);
        r128.put("queue_size", String.valueOf(r127));
        n r130 = new n();
        Map<String, String> r131 = r130.f516447a;
        Intrinsics.checkNotNullParameter(r131, "map");
        Intrinsics.checkNotNullParameter(r128, "map");
        r131.putAll(r128);
        m r132 = new m();
        r132.b(LogCommon.ROOM);
        r132.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r130.f516448b).addAll(r132.f516446a);
        cy0.e.f465759a.getClass();
        j r133 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r134 = com.bytedance.android.scope.m.b(r133).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r134);
        ((i) ((f80.a) r134)).w3("livesdk_task_add_panel", r130.f516447a, r130.f516448b);
        return;
    L64:
        r129 = "0";
        goto L65
    L58:
        this.f474197b.add(r120);
        goto L59
    L60:
        a("checkFrequency false");
        r110 = false;
    L44:
        r118 = true;
        goto L45
    L36:
        if (((ArrayList) r109).isEmpty() == false) goto L38;
    L32:
        r116 = 0;
        goto L33
    L28:
        r115 = r106;
        goto L29
    L24:
        r114 = 0;
        goto L25
    L20:
        r113 = 0;
        goto L21
    L16:
        r112 = r103;
        goto L17
    L12:
        r111 = 1;
        goto L13
    L8:
        r102 = null;
        goto L9
    }
}
