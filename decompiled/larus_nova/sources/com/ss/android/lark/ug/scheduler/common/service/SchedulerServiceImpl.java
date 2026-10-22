package com.ss.android.lark.ug.scheduler.common.service;

import com.bytedance.apm.ApmAgent;
import com.bytedance.lark.pb.ugreach.v1.LocalRule;
import com.bytedance.lark.pb.ugreach.v1.ReachPointEntity;
import com.bytedance.lark.pb.ugreach.v1.ScenarioContext;
import com.ss.android.lark.ug.integrator.UgReachSdkIntegrator;
import com.ss.android.lark.ug.scheduler.common.entity.ReachPointState;
import com.ss.android.lark.ug.scheduler.common.exception.RuleException;
import com.ss.android.lark.ug.scheduler.common.exception.SchedulerException;
import com.ss.android.lark.ug.scheduler.coordinator.entity.DAGraph;
import com.ss.android.lark.ug.scheduler.coordinator.entity.c;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import u9c.d;

/* JADX INFO: loaded from: classes38.dex */
public final class SchedulerServiceImpl implements o9c.b, o9c.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<SchedulerServiceImpl> f444465e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<o9c.a> f444466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f444467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t9c.b f444468d;

    public static final class a {
    }

    static {
        f444465e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SchedulerServiceImpl$Companion$instance$2.INSTANCE);
    }

    @Override // o9c.b
    public final void clear() {
        this.f444467c.getClass();
        ((ConcurrentHashMap) u9c.a.f549221d.f541131a).clear();
        ((ConcurrentHashMap) u9c.a.f549219b).clear();
        com.ss.android.lark.ug.scheduler.coordinator.entity.a r100 = this.f444468d.f545149b;
        monitor-enter(r100);
        DAGraph<c> r101 = r100.f444480a;     // Catch: Throwable -> L7
        ((LinkedHashMap) r101.f444471a).clear();     // Catch: Throwable -> L7
        r101.f444472b.clear();     // Catch: Throwable -> L7
        r100.f444481b.clear();     // Catch: Throwable -> L7
        r100.f444483d.clear();     // Catch: Throwable -> L7
        ((LinkedHashMap) r100.f444482c).clear();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public SchedulerServiceImpl() {
        this.f444466b = new CopyOnWriteArrayList();
        int r100 = u9c.c.f549223a;
        this.f444467c = new d();
        int r101 = t9c.a.f545147a;
        Intrinsics.checkNotNullParameter(this, "onSchedulerCallback");
        this.f444468d = new t9c.b(this);
    }

    @Override // o9c.a
    public final void a(Collection<ReachPointEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "reachPointEntities");
        Iterator<o9c.a> r101 = this.f444466b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a(r100);
        goto L4
    }

    @Override // o9c.b
    public final void c(UgReachSdkIntegrator.e r100) {
        Intrinsics.checkNotNullParameter(r100, "onSchedulerCallback");
        this.f444466b.remove(r100);
    }

    @Override // o9c.a
    public final void e(Collection<ReachPointEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "reachPointEntities");
        Iterator<o9c.a> r101 = this.f444466b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().e(r100);
        goto L4
    }

    @Override // o9c.b
    public final void f(UgReachSdkIntegrator.e r100) {
        Intrinsics.checkNotNullParameter(r100, "onSchedulerCallback");
        this.f444466b.addIfAbsent(r100);
    }

    @Override // o9c.b
    public final void g(ScenarioContext r100) {
        Intrinsics.checkNotNullParameter(r100, "scenarioContext");
        this.f444468d.c(r100);     // Catch: Exception -> L5 SchedulerException -> L7
    L22:
        return;
    L7:
        e = move-exception;
        int r101 = p9c.a.f528333a;
        String r102 = r100.scenario_id;
        Intrinsics.checkNotNullParameter(r102, "scenarioId");
        Intrinsics.checkNotNullParameter(e, "e");
        JSONObject r103 = new JSONObject().put("errorCode", e.getErrorCode());
        JSONObject r104 = new JSONObject().put("scenarioId", r102);
        Map<String, String> r105 = e.getExtraInfo();
        if (r105 == null) goto L16;
        Set<Map.Entry<String, String>> r106 = r105.entrySet();
        if (r106 == null) goto L16;
        Iterator<T> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        Map.Entry r108 = (Map.Entry) r107.next();
        r104.put((String) r108.getKey(), r108.getValue());
    L16:
        ApmAgent.monitorEvent(e.getMetricKey(), r103, null, r104);
        return;
    L5:
        e = move-exception;
        int r109 = p9c.a.f528333a;
        p9c.a.a(r100.scenario_id, "onScenarioEnter: " + e.getMessage());
    }

    @Override // o9c.b
    public final boolean b(q9c.a r100, LocalRule r101) {
        Intrinsics.checkNotNullParameter(r100, "reachPointAction");
        Intrinsics.checkNotNullParameter(r101, "pbLocalRule");
        d r102 = this.f444467c;     // Catch: Exception -> L5 SchedulerException -> L7
        int r103 = com.ss.android.lark.ug.scheduler.rule.entity.a.f444516b;     // Catch: Exception -> L5 SchedulerException -> L7
        return r102.a(r100, com.ss.android.lark.ug.scheduler.rule.entity.a.C5369a.a(r101));
    L7:
        e = move-exception;
        int r104 = p9c.a.f528333a;
        String r105 = r100.f532194a;
        String r106 = r101.rule_id.toString();
        Intrinsics.checkNotNullParameter(r105, "scenarioId");
        Intrinsics.checkNotNullParameter(r106, ControlRule.KEY_RULE_ID);
        Intrinsics.checkNotNullParameter(e, "e");
        JSONObject r107 = new JSONObject().put("errorCode", e.getErrorCode());
        JSONObject r108 = new JSONObject().put("scenarioId", r105).put(ControlRule.KEY_RULE_ID, r106);
        Map<String, String> r109 = e.getExtraInfo();
        if (r109 == null) goto L16;
        Set<Map.Entry<String, String>> r110 = r109.entrySet();
        if (r110 == null) goto L16;
        Iterator<T> r111 = r110.iterator();
    L14:
        if (r111.hasNext() == false) goto L16;
        Map.Entry r112 = (Map.Entry) r111.next();
        r108.put((String) r112.getKey(), r112.getValue());
    L16:
        ApmAgent.monitorEvent(e.getMetricKey(), r107, null, r108);
        return false;
    L5:
        e = move-exception;
        int r113 = p9c.a.f528333a;
        String r114 = r100.f532194a;
        String r115 = r101.rule_id.toString();
        String r116 = "handleEventAction: " + e.getMessage();
        Intrinsics.checkNotNullParameter(r114, "scenarioId");
        Intrinsics.checkNotNullParameter(r115, ControlRule.KEY_RULE_ID);
        ApmAgent.monitorEvent(RuleException.METRIC_KEY, new JSONObject().put("errorCode", "500"), null, new JSONObject().put("scenarioId", r114).put(ControlRule.KEY_RULE_ID, r115).put("errorMsg", r116));
        return false;
    }

    @Override // o9c.b
    public final void d(ReachPointState r100, Collection<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "reachPointState");
        Intrinsics.checkNotNullParameter(r101, "reachPointIds");
        this.f444468d.b(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        int r102 = p9c.a.f528333a;
        p9c.a.a("", "onReachPointUpdate: " + e.getMessage() + ", state: " + r100);
    }
}
