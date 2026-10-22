package com.larus.nova;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.EventsUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks;
import com.larus.applog.api.IApplog;
import com.larus.commercecredit.api.ICommerceCreditService;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import mm9.j;
import mm9.k;
import mm9.l;
import org.xmlpull.v1.XmlPullParser;
import rx9.a;
import rx9.b;
import rx9.e;
import rx9.g;
import rx9.m;
import rx9.q;
import v19.a7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000f\n\u0002\u0010\u0001\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u001c\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010.\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010/\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00101\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00102\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u00103\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\u0006\u00104\u001a\u00020-H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J \u00106\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0016H\u0016J\"\u0010<\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J*\u0010=\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010>\u001a\u00020?2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0018\u0010@\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010A\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010B\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010C\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010D\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010E\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u000e\u0010F\u001a\u00020\u0006*\u0004\u0018\u00010'H\u0002J\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H*\u0004\u0018\u00010+H\u0002J\b\u0010J\u001a\u00020!H\u0002J\b\u0010K\u001a\u00020!H\u0002J\b\u0010L\u001a\u00020!H\u0002J\b\u0010M\u001a\u00020!H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/larus/nova/LifecycleMonitor;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "DELAY_MILLIS", XmlPullParser.NO_NAMESPACE, "EVENT_ENTER_FOREGROUND", "EVENT_ENTER_BACKGROUND", "EVENT_ACTIVITY_STACK_CREATED", "EVENT_ACTIVITY_STACK_DESTROYED", "processStartMillis", "firstCreated", XmlPullParser.NO_NAMESPACE, "createdCount", XmlPullParser.NO_NAMESPACE, "startedCount", "background", "destroyed", "appContext", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "delayStopRunnable", "Ljava/lang/Runnable;", "delayDestroyRunnable", "onAppAttachBaseContext", XmlPullParser.NO_NAMESPACE, "app", "Landroid/app/Application;", "onAppCreate", "log", "target", XmlPullParser.NO_NAMESPACE, "msg", "onActivityPreCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "onFragmentAttached", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "context", "onFragmentCreated", "onFragmentViewCreated", "v", "Landroid/view/View;", "onFragmentStarted", "onFragmentResumed", "onFragmentStopped", "onFragmentViewDestroyed", "onFragmentDestroyed", "onFragmentDetached", "simpleName", "from", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "onAppForeground", "onAppBackground", "onActivityStackCreated", "onActivityStackDestroyed", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class LifecycleMonitor extends FragmentManager$FragmentLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public static final LifecycleMonitor a = null;
    public static long b;
    public static boolean c;
    public static int d;
    public static int e;
    public static boolean f;
    public static boolean g;
    public static Context h;
    public static final Lazy i = null;
    public static final k j = null;
    public static final l k = null;

    /* JADX WARN: Type inference failed for: r0v4, types: [mm9.k] */
    /* JADX WARN: Type inference failed for: r0v5, types: [mm9.l] */
    static {
        a = new LifecycleMonitor();
        c = true;
        f = true;
        g = true;
        i = LazyKt.lazy(new j());
        j = new k();
        k = new l();
    }

    private LifecycleMonitor() {
    }

    public final String b(Object r3) {
        if (r3 != null) goto L5;
        return "null";
    L5:
        return r3.getClass().getSimpleName() + '@' + Integer.toHexString(r3.hashCode());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        a(r4, "onActivityDestroyed");
        int r5 = d - 1;
        d = r5;
        if (r5 == 0) goto L5;
        return;
    L5:
        if (g == true) goto L9;
        ((Handler) i.getValue()).postDelayed(k, 300);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        a(r2, "onActivityPaused");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        a(r2, "onActivityResumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        a(r7, "onActivityStarted");
        int r8 = e + 1;
        e = r8;
        if (r8 == 1) goto L5;
        return;
    L5:
        if (f == false) goto L21;
        f = false;
        a(h, "onAppForeground");
        AtomicBoolean r1 = a.a;
        if ((SystemClock.elapsedRealtime() - a.d) <= a.c) goto L12;
        Lazy r2 = q.a;
        b r3 = a.e;
        if (r3 == null) goto L12;
        q.a(new m(r3));
    L12:
        a.f = false;
        if (a.a.get() == false) goto L20;
        g r9 = a.b;
        if (r9 == null) goto L20;
        if (r9.c.compareAndSet(1, 2) == false) goto L20;
        Lazy r0 = g.k;
        g.a.a(0, new e(r9));
    L20:
        IApplog.a.o("flow_enter_foreground");
        return;
    L21:
        ((Handler) i.getValue()).removeCallbacks(j);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        a(r4, "onActivityStopped");
        int r5 = e - 1;
        e = r5;
        if (r5 == 0) goto L5;
        return;
    L5:
        if (f == true) goto L9;
        ((Handler) i.getValue()).postDelayed(j, 300);
        return;
    }

    public final void a(Object r3, String r4) {
        Map<String, eu7.b> r0 = bu7.a.a;
        bu7.a.b("[" + b(r3) + "] " + r4, XmlPullParser.NO_NAMESPACE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        com.larus.init.task.m.a.getClass();
        if (com.larus.init.task.m.a() == false) goto L5;
        com.larus.init.task.m.b();
    L5:
        int r1 = d + 1;
        d = r1;
        if (r1 == 1) goto L8;
    L11:
        if (r9 == null) goto L13;
        boolean r10 = true;
    L14:
        String r2 = r8.getClass().getSimpleName();
        String r5 = "normal create";
        if (c == false) goto L20;
        c = false;
        if (r10 == false) goto L19;
        r5 = "maybe app recreate";
    L19:
        long r3 = b;
        Lazy r0 = com.larus.init.task.base.a.a;
        new Handler(Looper.getMainLooper()).post(new bg9.b(r3));
        com.larus.init.task.base.a.a("process", r10, r2);
    L23:
        StringBuilder r11 = new StringBuilder("onActivityCreated, refer:");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L30
        if (Build.VERSION.SDK_INT < 22) goto L27;
        Object r6 = r8.getReferrer();     // Catch: Throwable -> L30
    L28:
        Object r7 = Result.m49constructorimpl(r6);     // Catch: Throwable -> L30
    L32:
        FragmentActivity r12 = null;
        if (Result.m55isFailureimpl(r7) == false) goto L35;
        r7 = null;
    L35:
        Object r13 = (Comparable) r7;
        if (r13 != null) goto L38;
        r13 = "unknown_null";
    L38:
        r11.append(r13);
        r11.append(", ");
        r11.append(r5);
        a(r8, r11.toString());
        if ((r8 instanceof FragmentActivity) == false) goto L41;
        r12 = (FragmentActivity) r8;
    L41:
        if (r12 == null) goto L48;
        FragmentManager r14 = r12.getSupportFragmentManager();
        if (r14 == null) goto L49;
        r14.registerFragmentLifecycleCallbacks(this, true);
        return;
    L49:
        return;
    L48:
        return;
    L27:
        r6 = "unknown_low_api_22";
    L30:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r7 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L32
    L20:
        if (r10 == false) goto L22;
        r5 = "maybe activity recreate";
    L22:
        com.larus.init.task.base.a.a("activity", r10, r2);
        goto L23
    L13:
        r10 = false;
        goto L14
    L8:
        if (g == false) goto L10;
        g = false;
        a(h, "onActivityStackCreated");
        IApplog.a.o("flow_activity_stack_created");
        goto L11
    L10:
        ((Handler) i.getValue()).removeCallbacks(k);
        goto L11
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        a(r1, "onActivityPreCreated");
        com.larus.init.task.m.a.getClass();
        if (com.larus.init.task.m.a() == false) goto L5;
        com.larus.init.task.m.b();
    L5:
        a7.a(r1, "ActivityLifecycleCallbacks");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
        a(r2, "onActivitySaveInstanceState");
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void onFragmentDestroyed(FragmentManager r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        a(r3, "onFragmentDestroyed");
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void onFragmentDetached(FragmentManager r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        a(r3, "onFragmentDetached");
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void onFragmentResumed(FragmentManager r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        a(r3, "onFragmentResumed");
        ICommerceCreditService.a.getClass();
        ICommerceCreditService r4 = ICommerceCreditService.a.a();
        if (r4 == null) goto L6;
        r4.c(r3);
        return;
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void onFragmentStarted(FragmentManager r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        a(r3, "onFragmentStarted");
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void onFragmentStopped(FragmentManager r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        a(r3, "onFragmentStopped");
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void onFragmentViewDestroyed(FragmentManager r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        a(r3, "onFragmentViewDestroyed");
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void onFragmentAttached(FragmentManager r2, Fragment r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        Intrinsics.checkNotNullParameter(r4, "context");
        a(r3, "onFragmentAttached, hostActivity:" + b(r3.getActivity()) + ", parentFragment:" + b(r3.getParentFragment()));
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void onFragmentCreated(FragmentManager r2, Fragment r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        if (r4 != null) goto L5;
        String r5 = "=";
    L6:
        a(r3, "onFragmentCreated, savedInstanceState" + r5 + "null");
        return;
    L5:
        r5 = "!=";
        goto L6
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void onFragmentViewCreated(FragmentManager r1, Fragment r2, View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r1, "fm");
        Intrinsics.checkNotNullParameter(r2, "f");
        Intrinsics.checkNotNullParameter(r3, "v");
        a(r2, "onFragmentViewCreated");
    }
}
