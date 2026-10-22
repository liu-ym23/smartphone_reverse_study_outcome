package com.bytedance.applet.task;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.KeepAliveRequester;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.applet.aibridge.navi.NavigationPageFrom;
import com.bytedance.applet.aibridge.permission.PermissionEnum;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.business.multitask_management.api.IMultiTaskService;
import com.larus.common.apphost.AppHost;
import com.larus.lbs.trace.api.model.LbsTraceLevel;
import com.larus.multitask_management.api.data.TaskDisplayStatus;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kl9.l0;
import kl9.p0;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class NavigationMultitaskCard {
    public static final NavigationMultitaskCard a = null;
    public static final CoroutineScope b = null;
    public static volatile long c;
    public static volatile String d;
    public static final NavigationCardSessionState e = null;
    public static final Object f = null;
    public static a g;
    public static b h;
    public static volatile boolean i;
    public static volatile b0 j;
    public static volatile x k;
    public static FragmentManager l;
    public static final s m = null;
    public static volatile a0 n;
    public static Job o;

    public static final class a {
        public final WeakReference<AppletApplication> a;
        public final boolean b;

        public a() {
            this(null, false);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            WeakReference<AppletApplication> r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L11:
            return r2 + r3;
        L9:
            r3 = 1237;
            goto L11
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "MapAppletPresentationState(appReference=" + this.a + ", presented=" + this.b + ')';
        }

        public final AppletApplication a() {
            WeakReference<AppletApplication> r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get();
        }

        public a(WeakReference<AppletApplication> r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public /* synthetic */ b() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "UpdateData(title=" + this.a + ", content=" + this.b + ", iconUrl=" + this.c + ", darkIconUrl=" + this.d + ')';
        }

        public b(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NavigationPageFrom.values().length];
            r0[NavigationPageFrom.TASK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[NavigationPageFrom.NOTIFICATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public NavigationMultitaskCard() {
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.bytedance.applet.task.s] */
    static {
        a = new NavigationMultitaskCard();
        b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        e = new NavigationCardSessionState();
        f = new Object();
        g = new a(null, false);
        i = true;
        m = new s();
    }

    public static void i() {
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r0 = AppletAppManagerService.a("db_1GFLTGc");
        if (r0 != null) goto L6;
        com.larus.navigation.api.c.d("nav_multitask_map", "releaseNavigationKeepAlive: nothing to release for db_1GFLTGc (findInstalledApp returned null)");
        return;
    L6:
        r0.F(KeepAliveRequester.NAVIGATION);
        com.larus.navigation.api.c.d("nav_multitask_map", "releaseNavigationKeepAlive: releaseKeepAlive(NAVIGATION) for db_1GFLTGc");
    }

    public final NavigationCardSessionState.a f() {
        NavigationCardSessionState r0 = e;
        monitor-enter(r0);
        NavigationCardSessionState.Phase r1 = r0.c;     // Catch: Throwable -> L21
        NavigationCardSessionState.Phase r2 = NavigationCardSessionState.Phase.STARTING;     // Catch: Throwable -> L21
        if (r1 != r2) goto L7;
    L12:
        monitor-exit(r0);
        NavigationCardSessionState.a r3 = null;
    L14:
        if (r3 != null) goto L16;
        return null;
    L16:
        Job r4 = o;
        if (r4 == null) goto L19;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
        o = null;
        com.larus.navigation.api.c.d("nav_multitask_map", "quick-restart fallback cancelled: new session took over the card");
    L19:
        b r8 = new b("导航中", "正在规划路线", null, null);
        CoroutineScope r5 = b;
        BuildersKt.launch$default(r5, null, null, new NavigationMultitaskCard$enqueueCardUpdate$1(r3, true, true, r8, null), 3, null);
        BuildersKt.launch$default(r5, null, null, new NavigationMultitaskCard$prepareNavigationStart$1(r3, null), 3, null);
        return r3;
    L7:
        if (r1 == NavigationCardSessionState.Phase.ACTIVE) goto L12;
        long r6 = r0.a + 1;     // Catch: Throwable -> L21
        r0.a = r6;     // Catch: Throwable -> L21
        r3 = new NavigationCardSessionState.a(r6, null);     // Catch: Throwable -> L21
        r0.b = r3;     // Catch: Throwable -> L21
        r0.c = r2;     // Catch: Throwable -> L21
        monitor-exit(r0);
    L21:
        th = move-exception;
        throw th;
    }

    public static final void a(NavigationMultitaskCard r2) {
        r2.getClass();
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r3 = AppletAppManagerService.a("db_1GFLTGc");
        if (r3 != null) goto L5;
        com.larus.navigation.api.c.b("nav_multitask_map", "acquireNavigationKeepAlive: findInstalledApp returned null for db_1GFLTGc — keep-alive NOT acquired, nav may be reclaimed under memory pressure");
        return;
    L5:
        r3.b(KeepAliveRequester.NAVIGATION);
        com.larus.navigation.api.c.d("nav_multitask_map", "acquireNavigationKeepAlive: acquireKeepAlive(NAVIGATION) for db_1GFLTGc");
    }

    public static void c(AppletAppActivity r3) {
        if (r3 == null) goto L5;
        FragmentManager r1 = r3.getSupportFragmentManager();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (l != r1) goto L11;
        return;
    L11:
        n(null);
        l = r1;
        r1.addOnBackStackChangedListener(m);
        String r0 = d;
        if (r0 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == true) goto L20;
        h("page_listener_bound");
    L20:
        int r4 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "bindPageStackListener: bound activity#" + System.identityHashCode(r3));
        return;
    L14:
        if (r0.length() == 0) goto L17;
        r2 = false;
        goto L18
    L5:
        r1 = null;
        goto L6
    }

    public static a g(AppletApplication r6) {
        gd9.i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        AppletAppActivity r1 = r0.a().e();
        boolean r2 = true;
        if (r1 == null) goto L9;
        if (r6 == null) goto L6;
        AppletAppActivity r3 = r6.d;
    L7:
        if (r1 == r3) goto L9;
        boolean r4 = true;
    L10:
        Object r5 = f;
        monitor-enter(r5);
        a r7 = g;     // Catch: Throwable -> L53
        monitor-exit(r5);
        if (r6 != null) goto L17;
        return r7;
    L17:
        if (r7.a() != r6) goto L34;
        if (r4 == true) goto L20;
    L33:
        return r7;
    L20:
        if (r7.b == false) goto L33;
        monitor-enter(r5);
        a r8 = g;     // Catch: Throwable -> L30
        if (r8.a() == r6) goto L26;
    L28:
        monitor-exit(r5);
        return r8;
    L26:
        if (r8.b == false) goto L28;
        r8 = new a(r8.a, false);     // Catch: Throwable -> L30
        g = r8;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L34:
        Activity r9 = r6.d;
        gd9.i r10 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r10);
        Activity r11 = r10.a().e();
        if (r9 == null) goto L39;
        if (r11 == null) goto L40;
        if (r11 != r9) goto L39;
    L40:
        a r12 = new a(new WeakReference(r6), r2);
        monitor-enter(r5);
        a r13 = g;     // Catch: Throwable -> L50
        if (r13.a() == r6) goto L46;
        if (r13 != r7) goto L46;
        g = r12;     // Catch: Throwable -> L50
    L48:
        monitor-exit(r5);
        return r12;
    L46:
        r12 = r13;
    L50:
        th = move-exception;
        throw th;
    L39:
        r2 = false;
    L53:
        th = move-exception;
        throw th;
    L6:
        r3 = null;
    L9:
        r4 = false;
        goto L10
    }

    public static void h(String r5) {
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r0 = AppletAppManagerService.a("db_1GFLTGc");
        if (r0 != null) goto L7;
        m(true);
        int r1 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "refreshVisibility: reason=" + r5 + " app unavailable, fallback visible=true");
        return;
    L7:
        if (r0.m() == true) goto L10;
        m(true);
        int r2 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "refreshVisibility: reason=" + r5 + " app not resumed, fallback visible=true");
        return;
    L10:
        Boolean r3 = d(r0, r5);
        if (r3 != null) goto L14;
        m(true);
        int r4 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "refreshVisibility: reason=" + r5 + " page state unknown, fallback visible=true");
        return;
    L14:
        m(true ^ r3.booleanValue());
        int r6 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "refreshVisibility: reason=" + r5 + " isNavigationPage=" + r3 + " visible=" + i);
    }

    public static il9.a k(String r2) {
        il9.a r0 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r0 != null) goto L5;
        int r1 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("nav_multitask_map", r2.concat(": IMultiTaskManager service unavailable"));
    L5:
        return r0;
    }

    public static void m(boolean r10) {
        if (i != r10) goto L5;
        return;
    L5:
        i = r10;
        String r0 = d;
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return;
    L14:
        il9.a r3 = k("visible setter");
        if (r3 != null) goto L17;
        return;
    L17:
        int r4 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "visible changed to " + r10);
        if (i == false) goto L20;
        TaskDisplayStatus r5 = TaskDisplayStatus.DISPLAYED;
    L21:
        r3.P(new p0(r0, null, new l0(null, r5, null, null, 4093)), false);
        return;
    L20:
        r5 = TaskDisplayStatus.HIDDEN;
        goto L21
    L8:
        if (r0.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public static void n(AppletAppActivity r1) {
        FragmentManager r0 = l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r1 != null) goto L7;
    L9:
        r0.removeOnBackStackChangedListener(m);
        l = null;
        com.larus.navigation.api.c.d("nav_multitask_map", "unbindPageStackListener: unbound");
        return;
    L7:
        if (r0 == r1.getSupportFragmentManager()) goto L9;
    }

    public final void l(NavigationCardSessionState.a r15) {
        Intrinsics.checkNotNullParameter(r15, "owner");
        NavigationCardSessionState r0 = e;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r15, "expected");     // Catch: Throwable -> L24
        if (Intrinsics.areEqual(r0.b, r15) == true) goto L7;
    L12:
        monitor-exit(r0);
        NavigationCardSessionState.a r1 = null;
    L14:
        if (r1 != null) goto L16;
        return;
    L16:
        int r16 = com.larus.navigation.api.c.a;
        String r2 = d;
        if (r2 != null) goto L19;
        r2 = "null";
    L19:
        com.larus.navigation.api.c.d("nav_multitask_map", "retainForQuickRestart: taskId=".concat(r2));
        b r7 = new b("导航中", "正在切换路线", null, null);
        CoroutineScope r17 = b;
        BuildersKt.launch$default(r17, null, null, new NavigationMultitaskCard$enqueueCardUpdate$1(r1, true, true, r7, null), 3, null);
        Job r3 = o;
        if (r3 == null) goto L22;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L22:
        o = BuildersKt.launch$default(r17, null, null, new NavigationMultitaskCard$retainForQuickRestart$1(r1, null), 3, null);
        return;
    L7:
        if (r0.c != NavigationCardSessionState.Phase.ACTIVE) goto L12;
        long r4 = r0.a + 1;     // Catch: Throwable -> L24
        r0.a = r4;     // Catch: Throwable -> L24
        r1 = new NavigationCardSessionState.a(r4, r15.b);     // Catch: Throwable -> L24
        r0.b = r1;     // Catch: Throwable -> L24
        r0.c = NavigationCardSessionState.Phase.WAITING_FOR_START;     // Catch: Throwable -> L24
        monitor-exit(r0);
    L24:
        th = move-exception;
        throw th;
    }

    public static NavigationCardSessionState.a b(NavigationCardSessionState.a r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "navigationId");
        NavigationCardSessionState r0 = e;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r3, "expected");     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r4, "navigationId");     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(r0.b, r3) == true) goto L7;
    L17:
        monitor-exit(r0);
        return null;
    L7:
        if (r0.c != NavigationCardSessionState.Phase.STARTING) goto L17;
        if (r4.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L17;
        NavigationCardSessionState.a r5 = new NavigationCardSessionState.a(r3.a, r4);     // Catch: Throwable -> L20
        r0.b = r5;     // Catch: Throwable -> L20
        r0.c = NavigationCardSessionState.Phase.ACTIVE;     // Catch: Throwable -> L20
        monitor-exit(r0);
        return r5;
    L11:
        r1 = false;
    L20:
        th = move-exception;
        throw th;
    }

    public static Boolean d(AppletApplication r7, String r8) {
        Object r9 = r7.h().d().f();
        if (Result.isFailure-impl(r9) == false) goto L5;
        Object r0 = null;
    L6:
        List r1 = (List) r0;
        if (r1 != null) goto L14;
        int r2 = com.larus.navigation.api.c.a;
        StringBuilder r3 = new StringBuilder("isTopNavigationPage: reason=");
        r3.append(r8);
        r3.append(" getCurrentPages failed: ");
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L11;
        String r11 = r10.getMessage();
    L12:
        r3.append(r11);
        com.larus.navigation.api.c.b("nav_multitask_map", r3.toString());
        return null;
    L11:
        r11 = null;
        goto L12
    L14:
        String r12 = (String) CollectionsKt.lastOrNull(r1);
        if (r12 == null) goto L28;
        String r13 = StringsKt.substringBefore$default(r12, '?', null, 2, null);
        if (r13 == null) goto L28;
        String r14 = StringsKt.substringBefore$default(r13, '#', null, 2, null);
        if (r14 == null) goto L28;
        boolean r4 = true;
        String r15 = StringsKt.trim(r14, new char[]{'/'});
        if (r15 == null) goto L28;
        if (r15.length() > 0) goto L26;
        r4 = false;
    L26:
        if (r4 == false) goto L28;
    L29:
        if (r15 != null) goto L32;
        int r16 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "isTopNavigationPage: reason=" + r8 + " topRoute unknown");
        return null;
    L32:
        boolean r5 = Intrinsics.areEqual(r15, "navigation_page");
        int r6 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "isTopNavigationPage: reason=" + r8 + " topRoute=" + r15 + " result=" + r5);
        return Boolean.valueOf(r5);
    L28:
        r15 = null;
        goto L29
    L5:
        r0 = r9;
        goto L6
    }

    public static void e(String r19, NavigationPageFrom r20) {
        Intrinsics.checkNotNullParameter(r19, "clickSource");
        Intrinsics.checkNotNullParameter(r20, "from");
        NavigationCardSessionState r2 = e;
        monitor-enter(r2);
        NavigationCardSessionState.Phase r0 = r2.c;     // Catch: Throwable -> L139
        if (r0 == NavigationCardSessionState.Phase.WAITING_FOR_START) goto L10;
        if (r0 == NavigationCardSessionState.Phase.STARTING) goto L10;
        boolean r1 = false;
    L11:
        monitor-exit(r2);
        if (r1 == false) goto L15;
        com.larus.navigation.api.c.d("nav_multitask_map", "openNavigationDetail: consume click during navigation transition");
        return;
    L15:
        int r3 = c.a[r20.ordinal()];
        if (r3 == 1) goto L20;
        if (r3 == 2) goto L19;
        String r4 = "other";
    L21:
        String r14 = r4;
        Object r5 = com.bytedance.applet.aibridge.navigation.l.a;
        com.larus.navigation.api.x r6 = com.bytedance.applet.aibridge.navigation.l.e;
        Activity r16 = null;
        if (r6 != null) goto L24;
        ci9.a r7 = null;
    L25:
        com.larus.lbs.trace.api.a r15 = new com.larus.lbs.trace.api.a(r7, "lbs_client_doubao_open_navi_page");
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r8 = AppletAppManagerService.a("db_1GFLTGc");
        if (r8 == null) goto L28;
        AppletAppActivity r9 = r8.d;
    L29:
        int r10 = com.larus.navigation.api.c.a;
        StringBuilder r11 = new StringBuilder("openNavigationDetail(");
        r11.append(r19);
        r11.append("): enter visible=");
        r11.append(i);
        r11.append(" appletActivityAlive=");
        if (r9 == null) goto L32;
        boolean r12 = true;
    L33:
        r11.append(r12);
        r11.append(" detailPageDataCached=");
        com.bytedance.applet.aibridge.navigation.l.a r13 = com.bytedance.applet.aibridge.navigation.l.c;
        if (r13 == null) goto L36;
        rv3.i r17 = r13.b;
    L37:
        if (r17 == null) goto L39;
        boolean r18 = true;
    L40:
        r11.append(r18);
        r11.append(" taskId=");
        String r21 = d;
        if (r21 != null) goto L43;
        r21 = "null";
    L43:
        r11.append(r21);
        com.larus.navigation.api.c.d("nav_multitask_map", r11.toString());
        if (r8 == null) goto L50;
        com.bytedance.ai.applet.app.foundation.j r22 = r8.h().e();
        IMultiTaskService r23 = (IMultiTaskService) ServiceManager.get().getService(IMultiTaskService.class);
        if (r23 == null) goto L48;
        String r24 = r23.i();
    L49:
        r22.b = r24;
        goto L50
    L48:
        r24 = null;
    L50:
        a r25 = g(r8);
        if (r25.b == true) goto L53;
    L56:
        boolean r26 = false;
    L57:
        if (r26 == false) goto L59;
        Boolean r27 = d(r8, "open_navigation_detail_" + r19);
    L60:
        if (r26 == true) goto L63;
    L61:
        String r28 = "relaunch";
    L62:
        String r29 = r28;
        com.larus.navigation.api.c.d("nav_multitask_map", "openNavigationDetail(" + r19 + "): isMapAppletPresented=" + r26 + " isNavigationPageOnTop=" + r27 + " routeMode=" + r29);
        Intrinsics.checkNotNullParameter(r20, "from");
        Intrinsics.checkNotNullParameter(r29, "routeMode");
        com.bytedance.applet.aibridge.navigation.l.a r30 = com.bytedance.applet.aibridge.navigation.l.c;
        if (r30 == null) goto L72;
        rv3.i r31 = r30.b;
    L73:
        if (r31 != null) goto L76;
        String r110 = r29;
    L75:
        String r32 = null;
    L88:
        if (r32 != null) goto L90;
    L93:
        boolean r33 = true;
    L94:
        if (r33 == false) goto L96;
        String r34 = "relaunch";
    L97:
        if (r32 != null) goto L99;
    L102:
        boolean r35 = true;
    L103:
        if (r35 == true) goto L105;
        com.larus.navigation.api.c.d("nav_multitask_map", "openNavigationDetail(" + r19 + "): using cached detailUrl (from=" + r20 + ", routeMode=" + r110 + ')');
        String r36 = r32;
    L106:
        com.larus.navigation.api.c.d("nav_multitask_map", "openNavigationDetail(" + r19 + "): SmartRouter targetUrlLen=" + r36.length());
        AppHost.Companion r37 = AppHost.a;
        f09.a r38 = r37.a();
        if (r38 == null) goto L109;
        r16 = r38.getCurrentActivity();
    L109:
        if (r16 != null) goto L111;
        Context r39 = r37.getApplication();
    L112:
        if (r16 == null) goto L114;
        String r40 = "currentActivity=".concat(r16.getClass().getSimpleName());
    L115:
        com.larus.navigation.api.c.d("nav_multitask_map", "openNavigationDetail(" + r19 + "): using context " + r40);
        SmartRouter.buildRoute(r39, r36).d();     // Catch: RuntimeException -> L136
        com.larus.navigation.api.c.d("nav_multitask_map", "openNavigationDetail(" + r19 + "): SmartRouter.open() issued via " + r40);     // Catch: RuntimeException -> L136
        if (r32 != null) goto L119;
    L122:
        boolean r41 = true;
    L123:
        if (r41 == true) goto L125;
        boolean r42 = true;
    L126:
        Pair[] r43 = new Pair[4];     // Catch: RuntimeException -> L136
        r43[0] = TuplesKt.to("page_route_mode", r34);     // Catch: RuntimeException -> L136
        r43[1] = TuplesKt.to("entry_source", r14);     // Catch: RuntimeException -> L136
        r43[2] = TuplesKt.to("is_success", Boolean.valueOf(r42));     // Catch: RuntimeException -> L136
        if (r42 == false) goto L129;
        String r44 = "";
    L130:
        r43[3] = TuplesKt.to("error_msg", r44);     // Catch: RuntimeException -> L136
        Map r45 = MapsKt.mapOf(r43);     // Catch: RuntimeException -> L136
        if (r42 == false) goto L133;
        LbsTraceLevel r46 = LbsTraceLevel.INFO;     // Catch: RuntimeException -> L136
    L134:
        r15.a(r45, r46);     // Catch: RuntimeException -> L136
        return;
    L133:
        r46 = LbsTraceLevel.ERROR;     // Catch: RuntimeException -> L136
        goto L134
    L129:
        r44 = "navigation_detail_url_unavailable";
        goto L130
    L125:
        r42 = false;
        goto L126
    L119:
        if (r32.length() == 0) goto L122;
        r41 = false;
    L136:
        e = move-exception;
        r15.a(MapsKt.mapOf(new Pair[]{TuplesKt.to("page_route_mode", r34), TuplesKt.to("entry_source", r14), TuplesKt.to("is_success", Boolean.FALSE), TuplesKt.to("error_msg", "smart_router_exception:".concat(e.getClass().getSimpleName()))}), LbsTraceLevel.ERROR);
        int r47 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("nav_multitask_map", "openNavigationDetail(" + r19 + "): SmartRouter error type=" + e.getClass().getSimpleName());
        return;
    L114:
        r40 = "Application(no foreground activity)";
        goto L115
    L111:
        r39 = r16;
        goto L112
    L105:
        r36 = "sslocal://doubao_apps?app_id=db_1GFLTGc&env_version=release&route_mode=relaunch";
        com.larus.navigation.api.c.d("nav_multitask_map", "openNavigationDetail(" + r19 + "): no detailPageData cached, falling back to root URL with routeMode=relaunch");
        goto L106
    L99:
        if (r32.length() == 0) goto L102;
        r35 = false;
        goto L103
    L96:
        r34 = r110;
        goto L97
    L90:
        if (r32.length() == 0) goto L93;
        r33 = false;
        goto L94
    L76:
        com.larus.navigation.api.x r48 = com.bytedance.applet.aibridge.navigation.l.e;
        r110 = r29;
        rv3.i r49 = rv3.i.a(r31, null, null, r20, r29, null, 4194279);     // Catch: RuntimeException -> L86
        Gson r50 = rv3.k.a;     // Catch: RuntimeException -> L86
        if (r48 == null) goto L80;
        String r51 = r48.b;     // Catch: RuntimeException -> L86
    L81:
        if (r48 == null) goto L83;
        String r52 = r48.d;     // Catch: RuntimeException -> L86
    L84:
        r32 = rv3.k.a(r49, r110, r51, r52);     // Catch: RuntimeException -> L86
        com.larus.navigation.api.c.d("nav_protocol_trace", "[H5_OUT/sslocal/task_click] fromEnum=" + r20 + " | routeMode=" + r110 + " uriLen=" + r32.length());     // Catch: RuntimeException -> L86
        goto L88
    L83:
        r52 = null;
        goto L84
    L80:
        r51 = null;
    L86:
        e = move-exception;
        int r53 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("nav_jsb_helper", "buildDetailUrlForTaskClick error: type=".concat(e.getClass().getSimpleName()));
        goto L75
    L72:
        r31 = null;
        goto L73
    L63:
        if (r27 == null) goto L61;
        if (r27.booleanValue() == false) goto L68;
        r28 = "redirect";
        goto L62
    L68:
        r28 = "navigate";
        goto L62
    L59:
        r27 = null;
        goto L60
    L53:
        if (r25.a() != r8) goto L56;
        if (r9 == null) goto L56;
        r26 = true;
        goto L57
    L39:
        r18 = false;
        goto L40
    L36:
        r17 = null;
        goto L37
    L32:
        r12 = false;
        goto L33
    L28:
        r9 = null;
        goto L29
    L24:
        r7 = new ci9.a(r6.a, r6.b, r6.c, r6.d);
        goto L25
    L19:
        r4 = PermissionEnum.NOTIFICATION;
        goto L21
    L20:
        r4 = "navigation_float_window";
    L10:
        r1 = true;
    L139:
        th = move-exception;
        throw th;
    }

    public static void j(String r10, NavigationCardSessionState.a r11) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        NavigationCardSessionState r0 = e;
        monitor-enter(r0);
        if (r11 != null) goto L21;
    L10:
        long r2 = r0.a + 1;     // Catch: Throwable -> L18
        r0.a = r2;     // Catch: Throwable -> L18
        r0.b = null;     // Catch: Throwable -> L18
        r0.c = NavigationCardSessionState.Phase.IDLE;     // Catch: Throwable -> L18
        Long r12 = Long.valueOf(r2);     // Catch: Throwable -> L18
        monitor-exit(r0);
    L12:
        if (r12 == null) goto L23;
        long r3 = r12.longValue();
        Job r13 = o;
        if (r13 == null) goto L16;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L16:
        o = null;
        BuildersKt.launch$default(b, null, null, new NavigationMultitaskCard$removeNavigationCard$1(r10, r3, null), 3, null);
        return;
    L23:
        return;
    L18:
        th = move-exception;
        throw th;
    L21:
        if (Intrinsics.areEqual(r0.b, r11) == true) goto L10;
        monitor-exit(r0);
        r12 = null;
        goto L12
    }

    public static Job o(NavigationCardSessionState.a r10, b r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r11, "data");
        return BuildersKt.launch$default(b, null, null, new NavigationMultitaskCard$enqueueCardUpdate$1(r10, false, r12, r11, null), 3, null);
    }
}
