package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ug.sdk.luckydog.task.newTimer.LuckyNewTimerManager;
import com.bytedance.ug.sdk.luckyhost.api.api.timer.LuckyTimerStatus;
import com.google.gson.Gson;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements ym7.c, ym7.f, ym7.b, ym7.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ym7.h f272124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f272125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f272126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ym7.n f272127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f272128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f272129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f272130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f272131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f272132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f272133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final zm7.m f272134k;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (this.f272130g == false) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "releasePendant() 已经release释放掉了");
        return;
    L6:
        this.f272130g = true;
        ym7.h r100 = this.f272124a;
        if (r100 == null) goto L9;
        r100.d();
    L9:
        ym7.d r101 = (ym7.d) wm7.g.a(ym7.d.class);
        if (r101 == null) goto L12;
        r101.c(this);
    L12:
        ym7.l r102 = (ym7.l) wm7.g.a(ym7.l.class);
        if (r102 == null) goto L15;
        r102.e(this);
    L15:
        ym7.g r103 = (ym7.g) wm7.g.a(ym7.g.class);
        if (r103 == null) goto L19;
        r103.e(this);
        return;
    }

    @Override // ym7.i
    public final void l() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "tryReleasePendant() called; 具体view通知helper进行释放");
        b();
    }

    @Override // ym7.b
    public final String getTaskKey() {
        return this.f272133j;
    }

    public final void c(LuckyTimerStatus r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "updateTimerStatus() called; status = " + r100);
        if (this.f272130g == false) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "updateTimerStatus() 已经销毁释放了");
        return;
    L6:
        ym7.h r101 = this.f272124a;
        if (r101 == null) goto L9;
        r101.h(r100);
    L9:
        int r102 = e.f272135a[r100.ordinal()];
        if (r102 != 1) goto L12;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "updateTimerStatus() 内部计时上报失败了，不需要重试");
        return;
    L12:
        if (r102 != 2) goto L14;
    L25:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "updateTimerStatus() 任务过期，或者失败，释放挂件");
        b();
        return;
    L14:
        if (r102 == 3) goto L25;
        if (r102 == 4) goto L18;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "updateTimerStatus() 其他状态");
        return;
    L18:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "updateTimerStatus() 任务完成，延迟释放挂件");
        zm7.n r103 = this.f272134k.c();
        if (r103 == null) goto L23;
        int r104 = r103.c();
        if (r104 <= 0) goto L23;
    L24:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "delayReleasePendant() 延迟释放导量挂件； exitDuration = " + r104);
        this.f272131h.postDelayed(new f(this), ((long) r104) * 1000);
        return;
    L23:
        r104 = 60;
        goto L24
    }

    @Override // ym7.f
    public final void d(String r100) {
        Gson r101 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        Unit r102 = null;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "onRuleChanged onCall; 规则发生变化，重新判断规则，也需要走互斥逻辑", MapsKt.mapOf(new Pair[]{TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, this.f272133j), TuplesKt.to(ControlRule.KEY_RULE_ID, r100)}), null);
        String r103 = this.f272126c;
        if (r103 == null) goto L9;
        ym7.d r104 = (ym7.d) wm7.g.a(ym7.d.class);
        if (r104 == null) goto L7;
        r104.b(r103, this.f272127d, this.f272133j);
        r102 = Unit.INSTANCE;
    L7:
        if (r102 == null) goto L9;
        return;
    L9:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "onRuleChanged() lastScene为空了");
        Unit r105 = Unit.INSTANCE;
    }

    @Override // ym7.b
    public final boolean j(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "canShowPendant() called;");
        if (Intrinsics.areEqual("old_pendant", r100) == true) goto L18;
        if (Intrinsics.areEqual(r100, "task_pendant") == true) goto L18;
        zm7.n r101 = this.f272134k.c();
        if (r101 == null) goto L14;
        List<String> r102 = r101.j();
        if (r102 == null) goto L14;
        boolean r103 = r102.contains(r100);
        boolean r104 = true;
        if (r103 != true) goto L14;
    L15:
        this.f272129f = r104;
        return r104;
    L14:
        r104 = false;
    L18:
        return this.f272129f;
    }

    public d(zm7.m r100, JSONObject r101) {
        this.f272134k = r100;
        this.f272131h = new Handler(Looper.getMainLooper());
        String r102 = r100.e();
        this.f272133j = r102;
        zm7.n r103 = r100.c();
        if (r103 == null) goto L7;
        String r104 = r103.h();
        if (r104 == null) goto L7;
    L8:
        ym7.j r105 = (ym7.j) wm7.g.a(ym7.j.class);
        if (r105 == null) goto L11;
        ym7.h r106 = r105.d(r104);
    L12:
        this.f272124a = r106;
        if (r106 == null) goto L15;
        r106.k(r100, r101, this);
    L15:
        Gson r107 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "LuckyPendantHelper init onCall", MapsKt.mapOf(TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, r102)), null);
        ym7.d r108 = (ym7.d) wm7.g.a(ym7.d.class);
        if (r108 == null) goto L18;
        r108.a(this);
    L18:
        zm7.n r109 = r100.c();
        if (r109 == null) goto L21;
        List<String> r110 = r109.j();
    L22:
        this.f272125b = r110;
        if (r110 != null) goto L25;
    L44:
        this.f272132i = il7.m.a().f("timer_quit_scene_robust", Boolean.FALSE);
        return;
    L25:
        if ((!r110.isEmpty()) != true) goto L44;
        ym7.l r111 = (ym7.l) wm7.g.a(ym7.l.class);
        if (r111 == null) goto L29;
        r111.a(this, r110);
    L29:
        Iterator<T> r112 = r110.iterator();
    L31:
        if (r112.hasNext() == false) goto L44;
        String r113 = (String) r112.next();
        zm7.n r114 = this.f272134k.c();
        if (r114 == null) goto L37;
        Map<String, List<String>> r115 = r114.g();
        if (r115 == null) goto L37;
        List<String> r116 = r115.get(r113);
    L38:
        if (r116 == null) goto L31;
        if ((!r116.isEmpty()) != true) goto L31;
        ym7.g r117 = (ym7.g) wm7.g.a(ym7.g.class);
        if (r117 == null) goto L31;
        r117.c(this, r116);
    L37:
        r116 = null;
        goto L38
    L21:
        r110 = null;
        goto L22
    L11:
        r106 = null;
    L7:
        r104 = "";
        goto L8
    }

    @Override // ym7.b
    public final void a(String r110, ym7.n r111) {
        zm7.n r100 = this.f272134k.c();
        if (r100 == null) goto L50;
        List<String> r101 = r100.j();
        if (r101 == null) goto L50;
        if (r101.contains(r110) != true) goto L50;
        Gson r102 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "handleRuleList onCall, 命中任务场景", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", r110), TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, this.f272133j)}), null);
        zm7.m r103 = this.f272134k;
        if (r103 == null) goto L19;
        zm7.n r104 = r103.c();
        if (r104 == null) goto L19;
        Map<String, List<String>> r105 = r104.g();
        if (r105 == null) goto L19;
        List<String> r106 = r105.get(r110);
        if (r106 == null) goto L19;
        ym7.g r107 = (ym7.g) wm7.g.a(ym7.g.class);
        if (r107 == null) goto L19;
        List<ym7.e> r108 = r107.d(r106);
    L20:
        if (r108 != null) goto L22;
    L30:
        boolean r109 = true;
    L31:
        if (r109 == false) goto L47;
        ym7.h r112 = this.f272124a;
        if (r112 == null) goto L36;
        r112.a(r110, r111);
    L36:
        if (this.f272128e == true) goto L60;
        this.f272128e = true;
        LuckyNewTimerManager.f271951q.getClass();
        CopyOnWriteArraySet<String> r113 = LuckyNewTimerManager.f271941g;
        if (r113 != null) goto L41;
    L45:
        String r114 = "";
    L46:
        il7.g.f("show_pendant", "show_pendant", r114, this.f272134k.e(), "cross");
        return;
    L41:
        if (r113.isEmpty() == true) goto L45;
        r114 = (String) r113.toArray()[0];     // Catch: Exception -> L52
    L60:
        return;
    L47:
        ym7.h r115 = this.f272124a;
        if (r115 == null) goto L58;
        r115.g(r111);
        return;
    L58:
        return;
    L22:
        if ((!r108.isEmpty()) != true) goto L30;
        Iterator<ym7.e> r116 = r108.iterator();
        r109 = true;
    L25:
        if (r116.hasNext() == false) goto L31;
        ym7.e r117 = r116.next();
        boolean r118 = r117.b();
        if (r118 == false) goto L28;
        r109 = r118;
        goto L25
    L28:
        Gson r119 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "handleRuleList onCall, 展示挂件被规则拦截", MapsKt.mapOf(new Pair[]{TuplesKt.to(com.heytap.mcssdk.constant.b.f276366p, r117.getClass().getSimpleName()), TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, this.f272133j)}), null);
        r109 = r118;
    L19:
        r108 = null;
    L50:
        Gson r120 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "handleRuleList onCall, 进入的场景任务未配置", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", r110), TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, this.f272133j)}), null);
    }

    @Override // ym7.b
    public final void f(String r100, ym7.n r101) {
        Gson r102 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "removePendant onCall, 互斥处理后, 不能展示当前挂件, 移除当前挂件", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", r100), TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, this.f272133j), TuplesKt.to("extra", r101)}), null);
        ym7.h r103 = this.f272124a;
        if (r103 == null) goto L6;
        r103.g(r101);
        return;
    }

    @Override // ym7.c
    public final void k(String r100, ym7.n r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "onQuitScene() called; scene = " + r100);
        if ((!Intrinsics.areEqual(this.f272126c, r100)) == false) goto L13;
        JSONObject r102 = new JSONObject();
        r102.put("last_scene", this.f272126c);     // Catch: Throwable -> L7
        r102.put("quit_scene", r100);     // Catch: Throwable -> L7
        com.bytedance.ug.sdk.luckydog.api.log.b.a("general_timer_quit_error", r102);     // Catch: Throwable -> L7
    L10:
        if (this.f272132i == false) goto L13;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "当前场景不是要quit的场景，直接return");
        return;
    L7:
        th = move-exception;
        th.getLocalizedMessage();
    L13:
        zm7.n r103 = this.f272134k.c();
        if (r103 == null) goto L25;
        List<String> r104 = r103.j();
        if (r104 != null) goto L18;
        return;
    L18:
        if (r104.contains(r100) != true) goto L27;
        Gson r105 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "onQuitScene onCall, 匹配场景退出, 隐藏挂件", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", r100), TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, this.f272133j)}), null);
        this.f272126c = null;
        ym7.h r106 = this.f272124a;
        if (r106 == null) goto L28;
        r106.g(r101);
        return;
    L28:
        return;
    L27:
        return;
    }

    @Override // ym7.c
    public final void m(String r100, ym7.n r101) {
        Gson r102 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "onEnterScene onCall", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", r100), TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, this.f272133j), TuplesKt.to("extra", r101)}), null);
        this.f272126c = r100;
        this.f272127d = r101;
        ym7.d r103 = (ym7.d) wm7.g.a(ym7.d.class);
        if (r103 == null) goto L6;
        r103.b(r100, r101, this.f272133j);
        return;
    }
}
