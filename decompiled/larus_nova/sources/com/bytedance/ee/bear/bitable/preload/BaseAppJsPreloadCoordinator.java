package com.bytedance.ee.bear.bitable.preload;

import android.os.Looper;
import com.bytedance.ee.bear.bitable.jsapi.SettingsBitableConfig;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.l7;
import com.bytedance.ee.bear.document.y7;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class BaseAppJsPreloadCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BaseAppJsPreloadCoordinator f214951a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f214952b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.ee.bear.bitable.preload.c f214953c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f214954d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f214955e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f214956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f214957g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f214958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f214959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f214960c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f214958a == r101.f214958a) goto L12;
            return false;
        L12:
            if (this.f214959b == r101.f214959b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f214960c, r101.f214960c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f214958a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f214959b;
            return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f214960c.hashCode();
        }

        public final String toString() {
            return "RequestMeta(createdAtMs=" + this.f214958a + ", expireAtMs=" + this.f214959b + ", from=" + this.f214960c + ')';
        }

        public a(long r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "from");
            this.f214958a = r100;
            this.f214959b = r101;
            this.f214960c = r102;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f214961a = null;

        static {
            f214961a = new b();
        }

        public b() {
        }

        public static void a() {
            BaseAppJsPreloadCoordinator r100 = BaseAppJsPreloadCoordinator.f214951a;
            r100.getClass();
            if (com.bytedance.ee.bear.bitable.c.f() == true) goto L6;
            tt5.a.h("BaseAppJsPreloadCoordinator", "requestByBehavior skipped, js preload fg disabled");
            return;
        L6:
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.app_mode.mobile.behavior_js_preload") == true) goto L8;
            tt5.a.h("BaseAppJsPreloadCoordinator", "requestByBehavior skipped, behavior fg disabled");
            return;
        L8:
            BaseAppOpenBehaviorStore r101 = BaseAppOpenBehaviorStore.f214964a;
            long r102 = System.currentTimeMillis();
            r101.getClass();
            long r103 = ((Number) ((ml5.b) BaseAppOpenBehaviorStore.f214965b.getValue()).a("last_open_at_ms", 0L)).longValue();
            Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L24
            SettingsBitableConfig r111 = (SettingsBitableConfig) SettingManager.getInstance().get(SettingsBitableConfig.class);     // Catch: Throwable -> L24
            if (r111 != null) goto L12;
            r111 = new SettingsBitableConfig();     // Catch: Throwable -> L24
        L12:
            long r112 = r111.c().a();     // Catch: Throwable -> L24
            Long r113 = Long.valueOf(r112);     // Catch: Throwable -> L24
            if (r113.longValue() <= 0) goto L15;
            boolean r114 = true;
        L16:
            if (r114 == true) goto L19;
            r113 = null;
        L19:
            if (r113 == null) goto L21;
            long r104 = r113.longValue();     // Catch: Throwable -> L24
        L22:
            tt5.a.h("BaseAppOpenBehaviorStore", "getRecentOpenValidDays success, settingValue=" + r112 + ", validDays=" + r104);     // Catch: Throwable -> L24
            Object r105 = Result.m9449constructorimpl(Long.valueOf(r104));     // Catch: Throwable -> L24
        L26:
            Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
            if (r106 == null) goto L30;
            tt5.a.e("BaseAppOpenBehaviorStore", "getRecentOpenValidDays failed", r106, false);
            tt5.a.h("BaseAppOpenBehaviorStore", "use default recent open valid days, validDays=14");
            r105 = 14L;
        L30:
            long r107 = ((Number) r105).longValue() * 86400000;
            long r115 = r102 - r103;
            if (r103 > 0) goto L33;
        L37:
            boolean r116 = false;
        L38:
            tt5.a.h("BaseAppOpenBehaviorStore", "hasRecentOpen recent=" + r116 + " lastOpenAtMs=" + r103 + " nowMs=" + r102 + " elapsedMs=" + r115 + " validWindowMs=" + r107);
            if (r116 == true) goto L41;
            tt5.a.h("BaseAppJsPreloadCoordinator", "requestByBehavior skipped, recent base_app open not matched");
            return;
        L41:
            tt5.a.h("BaseAppJsPreloadCoordinator", "requestByBehavior start");
            r100.h("booted_recent_open");
            return;
        L33:
            if (r115 < 0) goto L37;
            if (r115 > r107) goto L37;
            r116 = true;
            goto L38
        L21:
            r104 = 14;
            goto L22
        L15:
            r114 = false;
        L24:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L26
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f214962a;

        public c(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f214962a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f214962a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f214963a = null;

        static {
            f214963a = new d();
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseAppJsPreloadCoordinator.a(BaseAppJsPreloadCoordinator.f214951a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public BaseAppJsPreloadCoordinator() {
    }

    static {
        f214951a = new BaseAppJsPreloadCoordinator();
        f214952b = new Object();
        f214953c = new com.bytedance.ee.bear.bitable.preload.c();
        f214954d = d.f214963a;
        f214955e = b.f214961a;
    }

    public static void g() {
        Object r100 = f214952b;
        monitor-enter(r100);
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L19
        f214951a.getClass();     // Catch: Throwable -> L19
        c(r101);     // Catch: Throwable -> L19
        com.bytedance.ee.bear.bitable.preload.c r102 = f214953c;     // Catch: Throwable -> L19
        com.bytedance.ee.bear.bitable.preload.a r103 = r102.f214984b;     // Catch: Throwable -> L19
        DocBridgeWebViewV2 r104 = null;
        if (r103 != null) goto L8;
    L11:
        monitor-exit(r100);
        if (r104 != null) goto L15;
        return;
    L15:
        if (r104.N("base_app") == true) goto L17;
        return;
    L17:
        f(r104);
        return;
    L8:
        if (r103.f214979a <= r101) goto L11;
        r104 = e(r103, r102.d(), BaseAppJsPreloadCoordinator$getAliveInflightLocked$1.INSTANCE);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static void i() {
        d r100 = f214954d;
        com.bytedance.ee.util.ui.j.e(r100);
        Object r101 = f214952b;
        monitor-enter(r101);
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L61
        f214951a.getClass();     // Catch: Throwable -> L61
        c(r102);     // Catch: Throwable -> L61
        Long r103 = null;
        boolean r104 = true;
        if (f214956f != null) goto L7;
    L20:
        Long r105 = null;
    L21:
        com.bytedance.ee.bear.bitable.preload.c r106 = f214953c;     // Catch: Throwable -> L61
        com.bytedance.ee.bear.bitable.preload.a r107 = r106.f214984b;     // Catch: Throwable -> L61
        if (r107 != null) goto L24;
    L40:
        com.bytedance.ee.bear.bitable.preload.a r108 = r106.f214986d;     // Catch: Throwable -> L61
        if (r108 != null) goto L43;
    L55:
        if (r105 == null) goto L57;
        r103 = Long.valueOf(RangesKt.coerceAtLeast(r105.longValue() - r102, 0));     // Catch: Throwable -> L61
    L57:
        monitor-exit(r101);
        if (r103 == null) goto L66;
        com.bytedance.ee.util.ui.j.d(r100, r103.longValue());
        return;
    L66:
        return;
    L43:
        if (r108.f214979a > r102) goto L46;
        r104 = false;
    L46:
        if (r104 == true) goto L49;
        r108 = null;
    L49:
        if (r108 == null) goto L55;
        long r109 = r108.f214979a;     // Catch: Throwable -> L61
        if (r105 == null) goto L54;
        r109 = Math.min(r105.longValue(), r109);     // Catch: Throwable -> L61
    L54:
        r105 = Long.valueOf(r109);     // Catch: Throwable -> L61
        goto L55
    L24:
        if (r107.f214979a <= r102) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == true) goto L30;
        r107 = null;
    L30:
        if (r107 == null) goto L40;
        long r111 = 100 + r102;     // Catch: Throwable -> L61
        if (r105 == null) goto L35;
        r111 = Math.min(r105.longValue(), r111);     // Catch: Throwable -> L61
    L35:
        Long r112 = Long.valueOf(r111);     // Catch: Throwable -> L61
        long r113 = r107.f214979a;     // Catch: Throwable -> L61
        if (r112 == null) goto L39;
        r113 = Math.min(r112.longValue(), r113);     // Catch: Throwable -> L61
    L39:
        r105 = Long.valueOf(r113);     // Catch: Throwable -> L61
        goto L40
    L26:
        r110 = false;
        goto L27
    L7:
        if (d(r102) != null) goto L20;
        com.bytedance.ee.bear.bitable.preload.c r114 = f214953c;     // Catch: Throwable -> L61
        com.bytedance.ee.bear.bitable.preload.a r115 = r114.f214984b;     // Catch: Throwable -> L61
        if (r115 != null) goto L12;
    L13:
        DocBridgeWebViewV2 r116 = null;
    L15:
        if (r116 == null) goto L17;
        boolean r117 = true;
    L18:
        if (r117 == true) goto L20;
        r105 = Long.valueOf(500 + r102);     // Catch: Throwable -> L61
        goto L21
    L17:
        r117 = false;
        goto L18
    L12:
        if (r115.f214979a <= r102) goto L13;
        r116 = e(r115, r114.d(), BaseAppJsPreloadCoordinator$getAliveInflightLocked$1.INSTANCE);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        throw th;
    }

    public static void j() {
        if (com.bytedance.ee.bear.bitable.c.f() == true) goto L5;
        return;
    L5:
        Object r100 = f214952b;
        monitor-enter(r100);
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L53
        f214951a.getClass();     // Catch: Throwable -> L53
        c(r101);     // Catch: Throwable -> L53
        final a r102 = null;
        if (d(r101) == null) goto L10;
        f214956f = null;     // Catch: Throwable -> L53
    L23:
        monitor-exit(r100);
        if (r102 != null) goto L26;
        return;
    L26:
        final com.bytedance.ee.bear.bitable.preload.a r103 = new com.bytedance.ee.bear.bitable.preload.a(System.currentTimeMillis() + 15000, "base_app_preload#" + r102.f214958a, r102.f214960c);
        l7 r104 = y7.f222541j;
        y7 r105 = y7.a.f222551a;
        final DocBridgeWebViewV2 r106 = r105.s(r103.f214980b);
        if (r106 != null) goto L29;
        return;
    L29:
        Function0<Boolean> r107 = new BaseAppJsPreloadCoordinator$tryDispatchOnMainThread$acceptDispatch$1(r102, r106, r103);
        if (r106.N("base_app") == true) goto L32;
        String r108 = r102.f214960c;     // Catch: Throwable -> L50
        i05.e r109 = r106.f218503a3;     // Catch: Throwable -> L50
        if (r109 == null) goto L41;
        r109.c("base_app", r108);     // Catch: Throwable -> L50
    L41:
        if (r107.invoke().booleanValue() == true) goto L44;
        r105.f(r103.f214980b);
        return;
    L44:
        r106.setReadyCallback(new com.bytedance.ee.bear.bitable.preload.b(r106));
        if (r106.N("base_app") == false) goto L48;
        tt5.a.h("BaseAppJsPreloadCoordinator", "dispatch callback hit ready base_app webView=" + r106.hashCode() + ", from=" + r102.f214960c);
        f(r106);
        return;
    L48:
        tt5.a.h("BaseAppJsPreloadCoordinator", "dispatch base_app preload webView=" + r106.hashCode() + ", from=" + r102.f214960c);
        return;
    L50:
        th = move-exception;
        tt5.a.l("BaseAppJsPreloadCoordinator", "dispatch base_app preload failed, from=" + r102.f214960c, th);
        y7.a.f222551a.f(r103.f214980b);
        return;
    L32:
        if (r107.invoke().booleanValue() == true) goto L35;
        r105.f(r103.f214980b);
        return;
    L35:
        tt5.a.h("BaseAppJsPreloadCoordinator", "dispatch hit ready base_app webView=" + r106.hashCode() + ", from=" + r102.f214960c);
        f(r106);
        return;
    L10:
        com.bytedance.ee.bear.bitable.preload.c r110 = f214953c;     // Catch: Throwable -> L53
        com.bytedance.ee.bear.bitable.preload.a r111 = r110.f214984b;     // Catch: Throwable -> L53
        if (r111 != null) goto L14;
    L15:
        DocBridgeWebViewV2 r112 = null;
    L17:
        if (r112 == null) goto L19;
        boolean r113 = true;
    L20:
        if (r113 == true) goto L23;
        r102 = f214956f;     // Catch: Throwable -> L53
        goto L23
    L19:
        r113 = false;
        goto L20
    L14:
        if (r111.f214979a <= r101) goto L15;
        r112 = e(r111, r110.d(), BaseAppJsPreloadCoordinator$getAliveInflightLocked$1.INSTANCE);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    }

    public static final void a(BaseAppJsPreloadCoordinator r110) {
        r110.getClass();
        Object r111 = f214952b;
        monitor-enter(r111);
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L34
        f214951a.getClass();     // Catch: Throwable -> L34
        c(r100);     // Catch: Throwable -> L34
        ArrayList r101 = new ArrayList(2);     // Catch: Throwable -> L34
        com.bytedance.ee.bear.bitable.preload.c r102 = f214953c;     // Catch: Throwable -> L34
        com.bytedance.ee.bear.bitable.preload.a r103 = r102.f214984b;     // Catch: Throwable -> L34
        boolean r104 = false;
        com.bytedance.ee.bear.bitable.preload.a r105 = null;
        if (r103 != null) goto L7;
    L18:
        com.bytedance.ee.bear.bitable.preload.a r106 = r102.f214986d;     // Catch: Throwable -> L34
        if (r106 != null) goto L21;
    L27:
        monitor-exit(r111);
        Iterator r112 = r101.iterator();
    L30:
        if (r112.hasNext() == false) goto L32;
        String r107 = (String) r112.next();
        l7 r108 = y7.f222541j;
        y7.a.f222551a.f(r107);
        goto L30
    L32:
        g();
        j();
        i();
        return;
    L21:
        if (r106.f214979a > r100) goto L23;
        r104 = true;
    L23:
        if (r104 == false) goto L25;
        r105 = r106;
    L25:
        if (r105 == null) goto L27;
        r101.add(r105.f214980b);     // Catch: Throwable -> L34
        r102.b();     // Catch: Throwable -> L34
        goto L27
    L7:
        if (r103.f214979a > r100) goto L9;
        boolean r109 = true;
    L10:
        if (r109 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L18;
        DocBridgeWebViewV2 r113 = r102.d();     // Catch: Throwable -> L34
        if (r113 == null) goto L17;
        r113.setReadyCallback(null);     // Catch: Throwable -> L34
    L17:
        r101.add(r103.f214980b);     // Catch: Throwable -> L34
        r102.a();     // Catch: Throwable -> L34
        goto L18
    L9:
        r109 = false;
    L34:
        th = move-exception;
        throw th;
    }

    public static String b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "fallbackSeed");
        if (com.bytedance.ee.bear.bitable.c.f() == true) goto L5;
        return r110;
    L5:
        Object r100 = f214952b;
        monitor-enter(r100);
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L33
        f214951a.getClass();     // Catch: Throwable -> L33
        c(r101);     // Catch: Throwable -> L33
        com.bytedance.ee.bear.bitable.preload.c r102 = f214953c;     // Catch: Throwable -> L33
        com.bytedance.ee.bear.bitable.preload.a r103 = r102.f214986d;     // Catch: Throwable -> L33
        String r104 = null;
        if (r103 != null) goto L11;
    L16:
        String r105 = null;
    L17:
        if (r105 != null) goto L30;
        com.bytedance.ee.bear.bitable.preload.a r106 = r102.f214984b;     // Catch: Throwable -> L33
        if (r106 == null) goto L26;
        DocBridgeWebViewV2 r107 = e(r106, r102.d(), BaseAppJsPreloadCoordinator$consumeAliveInflightTagLocked$candidate$1.INSTANCE);     // Catch: Throwable -> L33
        if (r106.f214979a <= r101) goto L26;
        if (r107 == null) goto L26;
        r107.setReadyCallback(null);     // Catch: Throwable -> L33
        f214956f = null;     // Catch: Throwable -> L33
        r102.a();     // Catch: Throwable -> L33
        r104 = r106.f214980b;     // Catch: Throwable -> L33
    L26:
        if (r104 != null) goto L29;
        r105 = "base_app_preload#attach#" + r110;     // Catch: Throwable -> L33
        goto L30
    L29:
        r105 = r104;
    L30:
        monitor-exit(r100);
        tt5.a.h("BaseAppJsPreloadCoordinator", "acquireAttachTag attachTag=" + r105);
        i();
        return r105;
    L11:
        if (r103.f214979a <= r101) goto L16;
        if (e(r103, r102.c(), BaseAppJsPreloadCoordinator$consumeAliveWarmTagLocked$1.INSTANCE) == null) goto L16;
        f214956f = null;     // Catch: Throwable -> L33
        r102.b();     // Catch: Throwable -> L33
        r105 = r103.f214980b;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    public static void c(long r100) {
        a r101 = f214956f;
        if (r101 != null) goto L5;
    L10:
        r101 = null;
    L11:
        f214956f = r101;
        com.bytedance.ee.bear.bitable.preload.c r102 = f214953c;
        com.bytedance.ee.bear.bitable.preload.a r103 = r102.f214984b;
        if (r103 == null) goto L14;
        BaseAppJsPreloadCoordinator r104 = f214951a;
        DocBridgeWebViewV2 r105 = r102.d();
        BaseAppJsPreloadCoordinator$cleanupLocked$2$1 r106 = BaseAppJsPreloadCoordinator$cleanupLocked$2$1.INSTANCE;
        r104.getClass();
        e(r103, r105, r106);
    L14:
        com.bytedance.ee.bear.bitable.preload.a r107 = r102.f214986d;
        if (r107 == null) goto L18;
        BaseAppJsPreloadCoordinator r108 = f214951a;
        DocBridgeWebViewV2 r109 = r102.c();
        BaseAppJsPreloadCoordinator$cleanupLocked$3$1 r110 = BaseAppJsPreloadCoordinator$cleanupLocked$3$1.INSTANCE;
        r108.getClass();
        e(r107, r109, r110);
        return;
    L18:
        return;
    L5:
        if (r101.f214959b <= r100) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == false) goto L10;
    L7:
        r111 = false;
        goto L8
    }

    public static DocBridgeWebViewV2 d(long r100) {
        com.bytedance.ee.bear.bitable.preload.c r101 = f214953c;
        com.bytedance.ee.bear.bitable.preload.a r102 = r101.f214986d;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.f214979a > r100) goto L9;
        return null;
    L9:
        return e(r102, r101.c(), BaseAppJsPreloadCoordinator$getAliveWarmLocked$1.INSTANCE);
    }

    public static void f(DocBridgeWebViewV2 r110) {
        final String r100 = null;
        r110.setReadyCallback(null);
        long r101 = System.currentTimeMillis();
        Object r102 = f214952b;
        monitor-enter(r102);
        f214951a.getClass();     // Catch: Throwable -> L44
        c(r101);     // Catch: Throwable -> L44
        com.bytedance.ee.bear.bitable.preload.c r103 = f214953c;     // Catch: Throwable -> L44
        com.bytedance.ee.bear.bitable.preload.a r104 = r103.f214984b;     // Catch: Throwable -> L44
        if (r104 == null) goto L18;
        boolean r105 = true;
        if (r104.f214979a > r101) goto L19;
        Intrinsics.checkNotNullParameter(r110, "webView");     // Catch: Throwable -> L44
        WeakReference<DocBridgeWebViewV2> r106 = r103.f214983a;     // Catch: Throwable -> L44
        if (r106 == null) goto L12;
        DocBridgeWebViewV2 r107 = r106.get();     // Catch: Throwable -> L44
    L13:
        if (r107 == r110) goto L16;
        r105 = false;
    L16:
        if (r105 == false) goto L18;
        r103.a();     // Catch: Throwable -> L44
        com.bytedance.ee.bear.bitable.preload.a r108 = null;
        r100 = r104.f214980b;     // Catch: Throwable -> L44
    L32:
        monitor-exit(r102);
        if (r100 == null) goto L40;
        Function0<Unit> r111 = new BaseAppJsPreloadCoordinator$releaseReservation$1(r100);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L37;
        r111.invoke();
    L38:
        i();
        return;
    L37:
        com.bytedance.ee.util.ui.j.c(new c(r111));
        goto L38
    L40:
        if (r108 != null) goto L42;
        return;
    L42:
        tt5.a.h("BaseAppJsPreloadCoordinator", "onBaseAppReady webView=" + r110.hashCode() + ", from=" + r108.f214981c);
        i();
        return;
    L12:
        r107 = null;
        goto L13
    L19:
        Intrinsics.checkNotNullParameter(r110, "webView");     // Catch: Throwable -> L44
        r108 = r103.f214984b;     // Catch: Throwable -> L44
        if (r108 == null) goto L18;
        Intrinsics.checkNotNullParameter(r110, "webView");     // Catch: Throwable -> L44
        WeakReference<DocBridgeWebViewV2> r109 = r103.f214983a;     // Catch: Throwable -> L44
        if (r109 == null) goto L25;
        DocBridgeWebViewV2 r112 = r109.get();     // Catch: Throwable -> L44
    L26:
        if (r112 == r110) goto L29;
        r105 = false;
    L29:
        if (r105 == false) goto L18;
        r103.f214985c = new WeakReference(r110);     // Catch: Throwable -> L44
        r103.f214986d = r108;     // Catch: Throwable -> L44
        r103.a();     // Catch: Throwable -> L44
        goto L32
    L25:
        r112 = null;
    L18:
        r108 = null;
    L44:
        th = move-exception;
        throw th;
    }

    public final void h(String r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        if (com.bytedance.ee.bear.bitable.c.f() == true) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis();
        Object r101 = f214952b;
        monitor-enter(r101);
        f214951a.getClass();     // Catch: Throwable -> L35
        c(r100);     // Catch: Throwable -> L35
        DocBridgeWebViewV2 r102 = null;
        if (d(r100) == null) goto L12;
        f214956f = null;     // Catch: Throwable -> L35
        monitor-exit(r101);
        return;
    L12:
        com.bytedance.ee.bear.bitable.preload.c r103 = f214953c;     // Catch: Throwable -> L35
        com.bytedance.ee.bear.bitable.preload.a r104 = r103.f214984b;     // Catch: Throwable -> L35
        if (r104 != null) goto L16;
    L19:
        if (r102 == null) goto L21;
        boolean r105 = true;
    L22:
        if (r105 == false) goto L25;
        monitor-exit(r101);
        return;
    L25:
        a r106 = f214956f;     // Catch: Throwable -> L35
        if (r106 != null) goto L28;
        r106 = new a(r100, 15000 + r100, r110);     // Catch: Throwable -> L35
    L28:
        f214956f = r106;     // Catch: Throwable -> L35
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r101);
        BaseAppJsPreloadCoordinator$request$2 r112 = new BaseAppJsPreloadCoordinator$request$2(this);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L33;
        r112.invoke();
        return;
    L33:
        com.bytedance.ee.util.ui.j.c(new c(r112));
        return;
    L21:
        r105 = false;
        goto L22
    L16:
        if (r104.f214979a <= r100) goto L19;
        r102 = e(r104, r103.d(), BaseAppJsPreloadCoordinator$getAliveInflightLocked$1.INSTANCE);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    }

    public static DocBridgeWebViewV2 e(com.bytedance.ee.bear.bitable.preload.a r100, DocBridgeWebViewV2 r101, Function0 r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        l7 r103 = y7.f222541j;
        if (y7.a.f222551a.j(r100.f214980b) == r101) goto L9;
        r101.setReadyCallback(null);
        r102.invoke();
        return null;
    L9:
        return r101;
    }
}
