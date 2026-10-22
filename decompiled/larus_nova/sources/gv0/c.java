package gv0;

import com.bytedance.android.live.profit.taskcenter.i;
import com.bytedance.android.live.profit.taskcenter.panel.trace.LiveTaskPanelTraceMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements ev0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f482815a = null;

    public c() {
    }

    static {
        f482815a = new c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ev0.a
    public final void a(fv0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frequencyParams");
        String r101 = r100.f478951d;
        com.bytedance.tools.kcp.spongepreference.runtime.a r102 = i.f89030c;
        KProperty<?>[] r103 = i.f89028a;
        String r104 = (String) ((HashMap) r102.getValue(null, r103[1])).get(r101);
        if (r104 == null) goto L5;
        int r105 = CastIntegerProtector.parseInt(r104);
    L6:
        HashMap r106 = (HashMap) r102.getValue(null, r103[1]);
        r106.put(r101, String.valueOf(r105 + 1));
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r102.setValue(null, r103[1], r106);
        return;
    L5:
        r105 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ev0.a
    public final boolean b(fv0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frequencyParams");
        int r101 = r100.f478950c;
        String r102 = r100.f478951d;
        String r103 = (String) ((HashMap) i.f89030c.getValue(null, i.f89028a[1])).get(r102);
        if (r103 == null) goto L5;
        int r104 = CastIntegerProtector.parseInt(r103);
    L7:
        if (by0.b.a(r102) == false) goto L12;
        if (r101 <= 0) goto L12;
        if (r104 <= r101) goto L12;
        boolean r105 = false;
    L13:
        Map r106 = MapsKt.mapOf(new Pair[]{TuplesKt.to("lifetime_limit", String.valueOf(r101)), TuplesKt.to("activityId", r102), TuplesKt.to("show_count_sp", String.valueOf(r104)), TuplesKt.to("result", Boolean.valueOf(r105))});
        int r107 = LiveTaskPanelTraceMonitor.f89052a;
        LiveTaskPanelTraceMonitor.a(LiveTaskPanelTraceMonitor.EventName.TTLIVE_TASK_PANEL_MANAGE.getEventName(), LiveTaskPanelTraceMonitor.Step.CHECK_FREQUENCY_LIFETIME.getStep(), r106);
        return true;
    L12:
        r105 = true;
        goto L13
    L5:
        r104 = 0;
        goto L7
    }
}
