package rv3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppLifecycleCallbacks;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.larus.navigation.api.NavigationServiceDelegate;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n {
    public static final Handler a = null;
    public static boolean b;
    public static volatile a c;
    public static volatile String d;
    public static boolean e;
    public static volatile AppletApplication f;
    public static FragmentManager g;
    public static final m h = null;
    public static final c i = null;

    public static final class a {
        public final String a;
        public final String b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PendingPrewarmSession(outlinkId=" + this.a + ", locationIdentifier=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "outlinkId");
            Intrinsics.checkNotNullParameter(r3, "locationIdentifier");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements Function0<Unit> {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        public final Object invoke() {
            Handler r0 = n.a;     // Catch: RuntimeException -> L4
            n.c(this.a);     // Catch: RuntimeException -> L4
        L7:
            return Unit.INSTANCE;
        L4:
            e = move-exception;
            int r1 = com.larus.navigation.api.c.a;
            com.larus.navigation.api.c.c("nav_prewarm_page", "clear failed: " + e.getMessage(), e);
            goto L7
        }
    }

    public static final class c implements AppLifecycleCallbacks {
        public c() {
        }

        public final void onAppAttached(AppletApplication r2) {
            Intrinsics.checkNotNullParameter(r2, "app");
        }

        public final void onAppDestroyed(AppletApplication r3) {
            Intrinsics.checkNotNullParameter(r3, "app");
            if (Intrinsics.areEqual(r3.getAppId(), "db_1GFLTGc") == true) goto L5;
            return;
        L5:
            if (n.c != null) goto L7;
            return;
        L7:
            if (n.f != r3) goto L13;
            Handler r4 = n.a;
            n.f("light_navigation_runtime_destroyed_before_start");
            return;
        }

        public final void onAppCreated(AppletApplication r3, Context r4) {
            Intrinsics.checkNotNullParameter(r3, "app");
            Intrinsics.checkNotNullParameter(r4, "context");
            if (Intrinsics.areEqual(r3.getAppId(), "db_1GFLTGc") == true) goto L5;
            return;
        L5:
            if (n.c == null) goto L17;
            AppletAppManagerService.INSTANCE.getClass();
            if (AppletAppManagerService.a("db_1GFLTGc") == r3) goto L10;
            return;
        L10:
            Handler r0 = n.a;
            n.f = r3;
            Handler r5 = n.a;
            if ((r4 instanceof AppletAppActivity) == false) goto L13;
            AppletAppActivity r6 = (AppletAppActivity) r4;
        L14:
            n.a(r6);
            n.d();
            return;
        L13:
            r6 = null;
            goto L14
        }

        public final void onAppDestroyView(AppletApplication r3, Context r4) {
            Intrinsics.checkNotNullParameter(r3, "app");
            Intrinsics.checkNotNullParameter(r4, "context");
            if (Intrinsics.areEqual(r3.getAppId(), "db_1GFLTGc") == true) goto L5;
            return;
        L5:
            if (n.c != null) goto L7;
            return;
        L7:
            if (n.f == r3) goto L10;
            return;
        L10:
            if ((r4 instanceof AppletAppActivity) == false) goto L12;
            AppletAppActivity r5 = (AppletAppActivity) r4;
        L13:
            if (r5 != null) goto L15;
        L20:
            Handler r6 = n.a;
            n.h(r5);
            return;
        L15:
            if (r5.isFinishing() == false) goto L20;
            if (n.g != r5.getSupportFragmentManager()) goto L20;
            Handler r7 = n.a;
            n.f("light_navigation_page_exited_before_start");
            return;
        L12:
            r5 = null;
            goto L13
        }

        public final void onAppResumed(AppletApplication r3, Context r4) {
            Intrinsics.checkNotNullParameter(r3, "app");
            Intrinsics.checkNotNullParameter(r4, "context");
            if (Intrinsics.areEqual(r3.getAppId(), "db_1GFLTGc") == true) goto L5;
            return;
        L5:
            if (n.c == null) goto L17;
            AppletAppManagerService.INSTANCE.getClass();
            if (AppletAppManagerService.a("db_1GFLTGc") == r3) goto L10;
            return;
        L10:
            Handler r0 = n.a;
            n.f = r3;
            Handler r5 = n.a;
            if ((r4 instanceof AppletAppActivity) == false) goto L13;
            AppletAppActivity r6 = (AppletAppActivity) r4;
        L14:
            n.a(r6);
            n.d();
            return;
        L13:
            r6 = null;
            goto L14
        }

        public final void onAppStopped(AppletApplication r1, Context r2) {
            AppLifecycleCallbacks.a.a(r1, r2);
        }

        public final void onAppTaskBackground(AppletApplication r2, Context r3) {
            Intrinsics.checkNotNullParameter(r2, "app");
            Intrinsics.checkNotNullParameter(r3, "context");
        }

        public final void onAppTaskForeground(AppletApplication r1, Context r2) {
            AppLifecycleCallbacks.a.b(r1, r2);
        }
    }

    public static final class d implements Function0<Unit> {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final Object invoke() {
            Handler r0 = n.a;     // Catch: RuntimeException -> L4
            n.c(this.a.a);     // Catch: RuntimeException -> L4
        L7:
            return Unit.INSTANCE;
        L4:
            e = move-exception;
            int r1 = com.larus.navigation.api.c.a;
            com.larus.navigation.api.c.c("nav_prewarm_page", "start_navigation_requested failed: " + e.getMessage(), e);
            goto L7
        }
    }

    public n() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [rv3.m] */
    static {
        a = new Handler(Looper.getMainLooper());
        h = new m();
        i = new c();
    }

    public static void d() {
        a r0 = c;
        if (r0 != null) goto L5;
        return;
    L5:
        AppletApplication r1 = f;
        if (r1 != null) goto L8;
        return;
    L8:
        AppletAppManagerService.INSTANCE.getClass();
        if (AppletAppManagerService.a("db_1GFLTGc") == r1) goto L11;
        return;
    L11:
        Object r2 = r1.h().d().f();
        if (Result.isFailure-impl(r2) == false) goto L14;
        r2 = null;
    L14:
        List r3 = (List) r2;
        if (r3 != null) goto L17;
        return;
    L17:
        String r4 = (String) CollectionsKt.lastOrNull(r3);
        if (r4 != null) goto L20;
        return;
    L20:
        boolean r8 = false;
        String r5 = StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringBefore$default(r4, '?', null, 2, null), '#', null, 2, null), new char[]{'/'});
        if (r5.length() <= 0) goto L23;
        boolean r6 = true;
    L24:
        if (r6 == true) goto L27;
        r5 = null;
    L27:
        if (r5 != null) goto L30;
        return;
    L30:
        if (Intrinsics.areEqual(r5, "navigation_page") == true) goto L32;
    L34:
        if (r8 == false) goto L37;
        e = true;
        return;
    L37:
        if (e == false) goto L41;
        f("light_navigation_page_exited_before_start");
        return;
    L41:
        return;
    L32:
        if (StringsKt.contains$default(r4, r0.a, false, 2, null) == false) goto L34;
        r8 = true;
        goto L34
    L23:
        r6 = false;
        goto L24
    }

    public static final void a(AppletAppActivity r1) {
        if (r1 == null) goto L11;
        FragmentManager r2 = r1.getSupportFragmentManager();
        if (r2 != null) goto L7;
        return;
    L7:
        if (g == r2) goto L13;
        h(null);
        g = r2;
        r2.addOnBackStackChangedListener(h);
        return;
    L13:
        return;
    }

    public static void b(String r2) {
        if (r2 != null) goto L9;
        a r3 = c;
        if (r3 == null) goto L6;
        r2 = r3.a;
    L7:
        if (r2 != null) goto L9;
        return;
    L6:
        r2 = null;
    L9:
        b r0 = new b(r2);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L12;
        r0.invoke();
        return;
    L12:
        a.post(new o(r0));
    }

    public static void c(String r3) {
        a r0 = c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
    L9:
        c = null;
        if (Intrinsics.areEqual(d, r0.b) == false) goto L12;
        d = null;
    L12:
        e = false;
        f = null;
        h(null);
        int r4 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_prewarm_page", "watch cleared: outlinkId=" + r0.a);
        return;
    L7:
        if (Intrinsics.areEqual(r0.a, r3) == true) goto L9;
    }

    public static a e(e3.d r3) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        a r0 = c;
        if (r0 != null) goto L5;
        return null;
    L5:
        d3.a0 r4 = r3.getContainerContext();
        if (r4 == null) goto L8;
        String r5 = r4.getAppletId();
    L9:
        if (r5 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
    L19:
        return r0;
    L17:
        if (Intrinsics.areEqual(r5, "db_1GFLTGc") == true) goto L19;
        return null;
    L11:
        if (StringsKt.isBlank(r5) == true) goto L14;
        r2 = false;
        goto L15
    L8:
        r5 = null;
        goto L9
    }

    public static void f(String r4) {
        a r0 = c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(d, r0.b) == false) goto L9;
        c(r0.a);
        int r1 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_prewarm_page", "ignore prewarm cleanup after start request: reason=".concat(r4));
        return;
    L9:
        NavigationServiceDelegate r2 = NavigationServiceDelegate.b;
        c(r0.a);
        r2.o(r4, r0.b);
        int r3 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_prewarm_page", "stopped pending prewarm: reason=" + r4 + " identifier=" + r0.b);
    }

    public static a g(e3.d r3) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        a r4 = e(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(c, r4) == true) goto L8;
        return null;
    L8:
        d = r4.b;
        d r0 = new d(r4);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L11;
        r0.invoke();
    L12:
        return r4;
    L11:
        a.post(new o(r0));
        goto L12
    }

    public static void h(AppletAppActivity r1) {
        FragmentManager r0 = g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r1 != null) goto L7;
    L9:
        r0.removeOnBackStackChangedListener(h);
        g = null;
        return;
    L7:
        if (r0 == r1.getSupportFragmentManager()) goto L9;
    }
}
