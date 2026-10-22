package ok3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.v;
import com.bytedance.android.shopping.store.tabkit.model.y;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitSwitchTabPref;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.q1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Map<Long, TabkitFirstFramePref> e = null;
    public final ConcurrentHashMap<Integer, TabkitSwitchTabPref> a;
    public boolean b;
    public final TabKitViewModel c;
    public final TabkitFirstFramePref d;

    /* JADX INFO: renamed from: ok3.a$a, reason: collision with other inner class name */
    public static final class C0149a {
        public static TabkitFirstFramePref a(long r1) {
            Map<Long, TabkitFirstFramePref> r0 = a.e;
            LinkedHashMap r2 = (LinkedHashMap) r0;
            return (TabkitFirstFramePref) r2.get(Long.valueOf(r1));
        }
    }

    public static final class b extends q1 {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Integer c;

        public final void onLoadSuccess() {
            super.onLoadSuccess();
            if (this.b == false) goto L5;
            this.a.d.getTimer().cancel();
            return;
        L5:
            this.a.c(this.c.intValue()).getTimer().cancel();
        }

        public final void onTimingSetup(Map<String, Object> r1) {
            super.onTimingSetup(r1);
        }

        public b(a r1, boolean r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onTimingUpdate(Map<String, Object> r5, Map<String, Long> r6, String r7) {
            boolean r8 = false;
            if (r6 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L21;
            if (r5 != null) goto L12;
        L13:
            r8 = true;
        L14:
            if (r8 == true) goto L23;
            Long r9 = r6.get("draw_end");
            if (this.b == false) goto L19;
            this.a.d.recordTime("t_page_show", r9);
            this.a.e(1, r5, r6);
            return;
        L19:
            this.a.c(this.c.intValue()).recordTime("t_page_show", r9);
            this.a.f(this.c.intValue(), 1, r5, r6);
            return;
        L23:
            return;
        L12:
            if (r5.isEmpty() == false) goto L14;
        L21:
            return;
        L5:
            if (r6.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    public static final class c extends TimerTask {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (this.b == false) goto L5;
            this.a.e(4, null, null);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            this.a.f(this.c, 4, null, null);     // Catch: Throwable -> L7
            goto L12
        }

        public c(a r1, boolean r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        e = new LinkedHashMap();
    }

    public final void b(l r5) {
        Intrinsics.checkNotNullParameter(r5, "compent");
        int r0 = bj3.a.a;
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("biz_tag", this.c.getRouterParams().getBizTag());
        y r2 = (y) this.c.getCurrentTab().getValue();
        if (r2 == null) goto L7;
        k r3 = r2.a;
        if (r3 == null) goto L7;
        Integer r4 = r3.n();
    L8:
        r1[1] = TuplesKt.to("tab_id", String.valueOf(com.bytedance.android.shopping.extensions.k.f(r4)));
        Map r6 = MapsKt.mapOf(r1);
        Intrinsics.checkNotNullParameter(r5, "target");
        Intrinsics.checkNotNullParameter(r6, "values");
        int r7 = com.bytedance.android.ec.core.hybrid.c.a;
        Intrinsics.checkNotNullParameter(r5, "target");
        Intrinsics.checkNotNullParameter(r6, "values");
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final TabkitSwitchTabPref c(int r3) {
        ConcurrentHashMap<Integer, TabkitSwitchTabPref> r0 = this.a;
        Integer r4 = Integer.valueOf(r3);
        TabkitSwitchTabPref r1 = r0.get(r4);
        if (r1 != null) goto L9;
        r1 = new TabkitSwitchTabPref();
        TabkitSwitchTabPref r5 = r0.putIfAbsent(r4, r1);
        if (r5 == null) goto L9;
        r1 = r5;
    L9:
        return r1;
    }

    public a(TabKitViewModel r2, TabkitFirstFramePref r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "firstFrame");
        this.c = r2;
        this.d = r3;
        this.a = new ConcurrentHashMap();
    }

    public final void g(int r5, boolean r6) {
        if (r6 == false) goto L4;
        TabkitFramePref r0 = this.d;
    L9:
        r0.getTimer().schedule(new c(this, r6, r5), 5000);     // Catch: Exception -> L7
        return;
    L7:
        ECExceptionMonitor.c("tabkit timer already cancel biz_tag:" + this.c.getRouterParams().getBizTag() + " tab_id:" + r5 + " is_landing_tab:" + r6);
        return;
    L4:
        r0 = c(r5);
        goto L9
    }

    public final void a(l r2, Integer r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "compent");
        if (r3 == null) goto L6;
        r3.intValue();
        int r0 = bj3.a.a;
        b r1 = new b(this, r4, r3);
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r1, "client");
        int r5 = com.bytedance.android.ec.core.hybrid.c.a;
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r1, "lynxClient");
        return;
    }

    public final void e(int r9, Map<String, Object> r10, Map<String, Long> r11) {
        if (this.b == false) goto L5;
        return;
    L5:
        TabkitFirstFramePref r0 = this.d;
        r0.getTimer().cancel();
        if (r0.containsKey("t_tab_click_time") == true) goto L8;
        r0.put("t_tab_click_time", 0L);
    L8:
        y r1 = (y) this.c.getCurrentTab().getValue();
        if (r1 == null) goto L11;
        k r2 = r1.a;
    L12:
        k r4 = r2;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<Map.Entry<String, Long>> r5 = r0.entrySet().iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        Map.Entry<String, Long> r6 = r5.next();
        r3.put(r6.getKey(), Long.valueOf(r6.getValue().longValue()));
        goto L14
    L16:
        d(r3, r4, r9, r10, r11);
        g.a.logV3("ec_perf_duration_tabkit", new JSONObject(r3));
        this.b = true;
        return;
    L11:
        r2 = null;
        goto L12
    }

    public final void f(int r8, int r9, Map<String, Object> r10, Map<String, Long> r11) {
        y r0 = (y) this.c.getCurrentTab().getValue();
        if (r0 == null) goto L17;
        k r3 = r0.a;
        if (r3 == null) goto L18;
        TabkitSwitchTabPref r12 = c(r8);
        if (r12.getReported() == false) goto L10;
        return;
    L10:
        r12.getTimer().cancel();
        r12.setReported(true);
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, Long>> r13 = r12.entrySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        Map.Entry<String, Long> r2 = r13.next();
        r1.put(r2.getKey(), Long.valueOf(r2.getValue().longValue()));
        goto L12
    L14:
        d(r1, r3, r9, r10, r11);
        g.a.logV3("ec_perf_duration_tabkit_switchtab", new JSONObject(r1));
        return;
    L18:
        return;
    }

    public final void d(Map<Object, Object> r5, k r6, int r7, Map<String, Object> r8, Map<String, Long> r9) {
        if (r8 == null) goto L10;
        Iterator<Map.Entry<String, Object>> r10 = r8.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        Map.Entry<String, Object> r1 = r10.next();
        if ((!Intrinsics.areEqual(r1.getKey(), "update_timings")) == false) goto L6;
        r5.put("lynx_timing_" + r1.getKey(), r1.getValue());
    L10:
        if (r9 == null) goto L12;
        r5.put("t_update_timing", r9);
    L12:
        Iterator<Map.Entry<String, String>> r11 = this.c.getRouterParams().getParamsMap().entrySet().iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        Map.Entry<String, String> r12 = r11.next();
        r5.put(r12.getKey(), String.valueOf(r12.getValue()));
        goto L14
    L16:
        r5.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r5.put("biz_tag", this.c.getRouterParams().getBizTag());
        String r13 = this.c.getRouterParams().getPreviousPage();
        String r14 = "";
        if (r13 != null) goto L19;
        r13 = "";
    L19:
        r5.put("entrance_location", r13);
        r5.put("page_modal", Integer.valueOf(com.bytedance.android.shopping.extensions.k.f(this.c.getRouterParams().getPageModal())));
        Integer r15 = null;
        if (r6 == null) goto L24;
        s r2 = r6.f();
        if (r2 == null) goto L24;
        Integer r3 = r2.c();
    L25:
        r5.put("container_type", Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r3, -1)));
        if (r6 == null) goto L30;
        s r4 = r6.f();
        if (r4 == null) goto L30;
        Integer r16 = r4.d();
    L31:
        r5.put("hybrid_container_type", Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r16, 0)));
        r5.put("tab_load_status", Integer.valueOf(r7));
        if (r6 == null) goto L34;
        Integer r17 = r6.n();
    L35:
        r5.put("tab_id", Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r17, -1)));
        String r18 = this.c.getRouterParams().getBizCustomCategory();
        if (r18 == null) goto L39;
        r14 = r18;
    L39:
        r5.put("biz_custom_category", r14);
        r5.put("biz_mode", Integer.valueOf(com.bytedance.android.shopping.extensions.k.f(Integer.valueOf(this.c.getRouterParams().getBizMode()))));
        r5.put("enable_pre_create_annie", Boolean.valueOf(this.c.getAbilityConfig().b("enable_anniex_async_create")));
        TabKitViewModel r19 = this.c;
        if (r6 == null) goto L42;
        r15 = r6.n();
    L42:
        v r20 = r19.getTabState(r15);
        if (r20 != null) goto L45;
    L47:
        String r21 = "0";
    L48:
        r5.put("anniex_force", r21);
        return;
    L45:
        if (r20.f != true) goto L47;
        r21 = CommentScene.COMMENTSCENE_NO_AWEME;
        goto L48
    L34:
        r17 = null;
    L30:
        r16 = null;
    L24:
        r3 = null;
        goto L25
    }
}
