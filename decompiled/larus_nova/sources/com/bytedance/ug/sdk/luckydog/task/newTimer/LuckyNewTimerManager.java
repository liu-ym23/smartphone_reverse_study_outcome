package com.bytedance.ug.sdk.luckydog.task.newTimer;

import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.task.n;
import com.bytedance.ug.sdk.luckydog.task.newTimer.counter.pendant.LuckyDogCounterPendantViewWrapper;
import com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.LuckyDogPendantViewWrapper;
import com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.i;
import com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.o;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTaskSourceType;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTaskStatus;
import com.google.gson.Gson;
import il7.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import wm7.h;
import ym7.j;
import ym7.l;
import zm7.k;

/* JADX INFO: loaded from: classes3.dex */
public final class LuckyNewTimerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f271935a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f271936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f271937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static tk7.g f271938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static k f271939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static xm7.f f271940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CopyOnWriteArraySet<String> f271941g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f271942h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f271943i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f271944j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f271945k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f271946l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f271947m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f271948n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f271949o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f271950p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final LuckyNewTimerManager f271951q = null;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a implements xm7.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f271952a;

        public a(String r100) {
            this.f271952a = r100;
        }

        @Override // xm7.e
        public final void a(bm7.a r100) {
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "onSuccess() 任务创建成功，crossToken = " + this.f271952a);
            LuckyNewTimerManager.f271940f = r100;
            if (r100 == null) goto L6;
            r100.a(new com.bytedance.ug.sdk.luckydog.task.newTimer.a(this));
            return;
        }

        @Override // xm7.e
        public final void onError(int r100, String r101) {
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "onError() 创建任务错误，crossToken = " + this.f271952a + ", errorCode = " + r100 + ", errorMsg = " + r101);
            if (r100 != 19000) goto L5;
        L10:
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "token不再消费，移除掉");
            KProperty[] r102 = LuckyNewTimerManager.f271935a;
            CopyOnWriteArraySet<String> r103 = LuckyNewTimerManager.f271941g;
            r103.remove(this.f271952a);
            m.a().h(this.f271952a);
            n.c(r103);
            return;
        L5:
            if (r100 == 5) goto L10;
            if (r100 == 6) goto L10;
            if (r100 == 10) goto L10;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class b implements zm7.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f271953a;

        public b(String r100) {
            this.f271953a = r100;
        }

        @Override // zm7.e
        public final void a(dm7.a r100) {
            Gson r101 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
            JSONObject r102 = null;
            com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "onSuccess() 计时任务创建成功", MapsKt.mapOf(TuplesKt.to("crossToken", this.f271953a)), null);
            LuckyNewTimerManager.f271939e = r100;
            if (r100 == null) goto L5;
            wm7.g.b(k.class, r100);
        L5:
            k r103 = LuckyNewTimerManager.f271939e;
            if (r103 == null) goto L9;
            r103.b(new com.bytedance.ug.sdk.luckydog.task.newTimer.b(this));
        L9:
            if (Intrinsics.areEqual(LuckyNewTimerManager.f271950p, this.f271953a) == false) goto L18;
            LuckyNewTimerManager.f271950p = null;
            k r104 = LuckyNewTimerManager.f271939e;
            if (r104 == null) goto L17;
            zm7.m r105 = r104.a();
            if (r105 == null) goto L17;
            String r106 = r105.b();
            if (r106 == null) goto L17;
            r102 = new JSONObject(r106);
        L17:
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "onCreate handleCrossOverGuide");
            cl7.c.f24113l.a(r102, LuckyNewTimerManager.f271938d);
        L18:
            CopyOnWriteArrayList<wm7.e> r107 = h.f560361a;
            if (r107.isEmpty() == true) goto L25;
            Iterator<wm7.e> r108 = r107.iterator();
        L23:
            if (r108.hasNext() == false) goto L25;
            r108.next().a();
        L25:
            h.f560362b.set(true);
        }

        @Override // zm7.e
        public final void onError(int r100, String r101) {
            CopyOnWriteArrayList<wm7.e> r102 = h.f560361a;
            if (r102.isEmpty() == true) goto L9;
            Iterator<wm7.e> r103 = r102.iterator();
        L7:
            if (r103.hasNext() == false) goto L9;
            r103.next().b();
        L9:
            Gson r104 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
            com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "onError() 创建计时任务错误", MapsKt.mapOf(new Pair[]{TuplesKt.to("crossToken", this.f271953a), TuplesKt.to("errorCode", Integer.valueOf(r100)), TuplesKt.to("errorMsg", r101)}), null);
            if (r100 != 19000) goto L12;
        L17:
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "token非法过期，移除掉");
            CopyOnWriteArraySet<String> r105 = LuckyNewTimerManager.f271941g;
            r105.remove(this.f271953a);
            n.c(r105);
            return;
        L12:
            if (r100 == 5) goto L17;
            if (r100 == 6) goto L17;
            if (r100 == 10) goto L17;
        }
    }

    public LuckyNewTimerManager() {
    }

    public static fm7.d c() {
        Lazy r100 = f271943i;
        KProperty r101 = f271935a[1];
        return (fm7.d) r100.getValue();
    }

    public static fm7.f d() {
        Lazy r100 = f271942h;
        KProperty r101 = f271935a[0];
        return (fm7.f) r100.getValue();
    }

    static {
        f271935a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LuckyNewTimerManager.class), "timerRuleOnTeenMode", "getTimerRuleOnTeenMode()Lcom/bytedance/ug/sdk/luckydog/task/newTimer/time/impl/LuckyTimerRuleOnTeenMode;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LuckyNewTimerManager.class), "timerRuleOnBasicMode", "getTimerRuleOnBasicMode()Lcom/bytedance/ug/sdk/luckydog/task/newTimer/time/impl/LuckyTimerRuleOnBasicMode;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LuckyNewTimerManager.class), "timerRuleOnLogin", "getTimerRuleOnLogin()Lcom/bytedance/ug/sdk/luckydog/task/newTimer/time/impl/LuckyTimerRuleOnLogin;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LuckyNewTimerManager.class), "pendantRuleOnBasicMode", "getPendantRuleOnBasicMode()Lcom/bytedance/ug/sdk/luckydog/task/newTimer/pendant/LuckyPendantRuleOnBasicMode;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LuckyNewTimerManager.class), "pendantRuleOnTeenMode", "getPendantRuleOnTeenMode()Lcom/bytedance/ug/sdk/luckydog/task/newTimer/pendant/LuckyPendantRuleOnTeenMode;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LuckyNewTimerManager.class), "pendantRuleOnLogin", "getPendantRuleOnLogin()Lcom/bytedance/ug/sdk/luckydog/task/newTimer/pendant/LuckyPendantRuleOnLogin;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LuckyNewTimerManager.class), "timerRuleOnBackground", "getTimerRuleOnBackground()Lcom/bytedance/ug/sdk/luckydog/task/newTimer/time/impl/LuckyTimerRuleOnBackground;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LuckyNewTimerManager.class), "pendantRuleOnBackground", "getPendantRuleOnBackground()Lcom/bytedance/ug/sdk/luckydog/task/newTimer/pendant/LuckyPendantRuleOnBackground;"))};
        f271951q = new LuckyNewTimerManager();
        f271941g = new CopyOnWriteArraySet();
        f271942h = LazyKt.lazy(LuckyNewTimerManager$timerRuleOnTeenMode$2.INSTANCE);
        f271943i = LazyKt.lazy(LuckyNewTimerManager$timerRuleOnBasicMode$2.INSTANCE);
        Lazy r100 = LazyKt.lazy(LuckyNewTimerManager$timerRuleOnLogin$2.INSTANCE);
        f271944j = r100;
        Lazy r101 = LazyKt.lazy(LuckyNewTimerManager$pendantRuleOnBasicMode$2.INSTANCE);
        f271945k = r101;
        Lazy r102 = LazyKt.lazy(LuckyNewTimerManager$pendantRuleOnTeenMode$2.INSTANCE);
        f271946l = r102;
        Lazy r103 = LazyKt.lazy(LuckyNewTimerManager$pendantRuleOnLogin$2.INSTANCE);
        f271947m = r103;
        Lazy r104 = LazyKt.lazy(LuckyNewTimerManager$timerRuleOnBackground$2.INSTANCE);
        f271948n = r104;
        Lazy r105 = LazyKt.lazy(LuckyNewTimerManager$pendantRuleOnBackground$2.INSTANCE);
        f271949o = r105;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "init() called;");
        wm7.g.b(j.class, new com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.n());
        wm7.g.b(l.class, new o());
        wm7.g.b(ym7.g.class, new com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.k());
        wm7.g.b(ym7.d.class, new com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.c());
        wm7.g.b(zm7.b.class, new c());
        wm7.g.b(xm7.g.class, new bm7.c());
        wm7.g.b(zm7.j.class, new fm7.g());
        wm7.g.b(zm7.d.class, new fm7.a());
        zm7.j r106 = (zm7.j) wm7.g.a(zm7.j.class);
        if (r106 == null) goto L5;
        d().getClass();
        r106.a("teen_mode", d());
    L5:
        zm7.j r107 = (zm7.j) wm7.g.a(zm7.j.class);
        if (r107 == null) goto L8;
        c().getClass();
        r107.a("basic_mode", c());
    L8:
        zm7.j r108 = (zm7.j) wm7.g.a(zm7.j.class);
        if (r108 == null) goto L11;
        ((fm7.e) r100.getValue()).getClass();
        r108.a("login", (fm7.e) r100.getValue());
    L11:
        zm7.j r109 = (zm7.j) wm7.g.a(zm7.j.class);
        if (r109 == null) goto L14;
        ((fm7.c) r104.getValue()).getClass();
        r109.a("background", (fm7.c) r104.getValue());
    L14:
        j r110 = (j) wm7.g.a(j.class);
        if (r110 == null) goto L17;
        r110.a(LuckyDogPendantViewWrapper.class);
    L17:
        j r111 = (j) wm7.g.a(j.class);
        if (r111 == null) goto L20;
        r111.b(LuckyDogCounterPendantViewWrapper.class);
    L20:
        ym7.g r112 = (ym7.g) wm7.g.a(ym7.g.class);
        if (r112 == null) goto L23;
        r112.b((com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.h) r101.getValue());
    L23:
        ym7.g r113 = (ym7.g) wm7.g.a(ym7.g.class);
        if (r113 == null) goto L26;
        r113.b((com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.j) r102.getValue());
    L26:
        ym7.g r114 = (ym7.g) wm7.g.a(ym7.g.class);
        if (r114 == null) goto L29;
        r114.b((i) r103.getValue());
    L29:
        ym7.g r115 = (ym7.g) wm7.g.a(ym7.g.class);
        if (r115 == null) goto L32;
        r115.b((com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.g) r105.getValue());
    L32:
        CopyOnWriteArraySet<String> r116 = (CopyOnWriteArraySet) n.b();
        f271941g = r116;
        if (r116.isEmpty() == false) goto L52;
    L37:
        String r117 = "";
    L38:
        f271937c = m.a().e("last_activity_id", "");
        if (TextUtils.isEmpty(r117) == true) goto L54;
        f271936b = r117;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "reCreateTask() lastCrossToken = " + f271936b + ", isEnableNewTimer = " + bl7.d.a());
        if (Intrinsics.areEqual("ack_count_type", m.a().e(r117, "")) == false) goto L46;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "createCountTask() called; ");
        String r118 = f271936b;
        if (r118 != null) goto L45;
        Intrinsics.throwNpe();
    L45:
        a(r118, f271937c, LuckyCounterTaskSourceType.RECOVERY);
        return;
    L46:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "createTask() called; ");
        String r119 = f271936b;
        if (r119 != null) goto L49;
        Intrinsics.throwNpe();
    L49:
        b(r119, f271937c);
        return;
    L54:
        return;
    L52:
        r117 = (String) r116.toArray()[0];     // Catch: Exception -> L51
        goto L38
    }

    public static void b(String r100, String r101) {
        if (bl7.d.a() == true) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "createTask is LuckyNewTimerAB.isEnableNewTimer() = false");
        return;
    L6:
        JSONObject r102 = new JSONObject();
        r102.put("activity_id", r101);     // Catch: Throwable -> L9
        r102.put("cross_token", r100);     // Catch: Throwable -> L9
    L11:
        zm7.b r103 = (zm7.b) wm7.g.a(zm7.b.class);
        if (r103 == null) goto L17;
        r103.a("cross", r100, r102, new b(r100));
        return;
    L17:
        return;
    L9:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", th.getLocalizedMessage());
        goto L11
    }

    public static void e(tk7.g r100, String r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "setCrossToken() called; ");
        String r102 = r100.f546564c;
        f271950p = r102;
        f271938d = r100;
        if (r102 == null) goto L25;
        m.a().k(r102, r101);
        if (Intrinsics.areEqual(r102, f271936b) == false) goto L8;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "setCrossToken() crossToken没有发生变化，return");
        return;
    L8:
        String r103 = f271936b;
        if (r103 == null) goto L16;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "setCrossToken() 之前的crossToken不为空，移除任务 ");
        zm7.b r104 = (zm7.b) wm7.g.a(zm7.b.class);
        if (r104 == null) goto L13;
        r104.b(r103, false);
    L13:
        xm7.g r105 = (xm7.g) wm7.g.a(xm7.g.class);
        if (r105 == null) goto L16;
        r105.b(r103, LuckyCounterTaskStatus.TASK_STATUS_FAILED);
    L16:
        f271936b = r102;
        String r106 = r100.f546562a;
        if (r106 != null) goto L20;
        r106 = "";
    L20:
        f271937c = r106;
        m.a().k("last_activity_id", f271937c);
        CopyOnWriteArraySet<String> r107 = f271941g;
        r107.clear();
        r107.add(r102);
        n.c(r107);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "setCrossToken() 新的crossToken = ".concat(r102));
        if (Intrinsics.areEqual("ack_count_type", r101) == false) goto L23;
        LuckyNewTimerManager r108 = f271951q;
        String r109 = f271937c;
        LuckyCounterTaskSourceType r110 = LuckyCounterTaskSourceType.SCHEMA;
        r108.getClass();
        a(r102, r109, r110);
        return;
    L23:
        LuckyNewTimerManager r111 = f271951q;
        String r112 = f271937c;
        r111.getClass();
        b(r102, r112);
        return;
    }

    public static void a(String r100, String r101, LuckyCounterTaskSourceType r102) {
        JSONObject r103 = new JSONObject();
        r103.put("activity_id", r101);     // Catch: Throwable -> L5
        r103.put("cross_token", r100);     // Catch: Throwable -> L5
    L7:
        xm7.g r104 = (xm7.g) wm7.g.a(xm7.g.class);
        if (r104 == null) goto L13;
        r104.c(r100, r103, r102, new a(r100));
        return;
    L13:
        return;
    L5:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", th.getLocalizedMessage());
        goto L7
    }
}
