package ts2;

import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.room.state.ContainerScrollLifecycle;
import com.bytedance.android.livesdk.room.state.RoomStateChangeLifecycle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {
    public static final void a(ContainerLifecycle r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onActivityCreated");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != ContainerLifecycle.ON_ACTIVITY_CREATED) goto L6;
        r101.invoke();
        return;
    }

    public static final void b(ContainerLifecycle r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onConfigurationChanged");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != ContainerLifecycle.ON_CONFIGURATION_CHANGED) goto L6;
        r101.invoke();
        return;
    }

    public static final void c(ContainerLifecycle r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onCreateView");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != ContainerLifecycle.ON_CREATE_VIEW) goto L6;
        r101.invoke();
        return;
    }

    public static final void d(ContainerLifecycle r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onDestroy");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != ContainerLifecycle.ON_DESTROY) goto L6;
        r101.invoke();
        return;
    }

    public static final void e(ContainerScrollLifecycle r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onPageScrollStateChanged");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != ContainerScrollLifecycle.ON_PAGE_SCROLL_STATE_CHANGED) goto L6;
        r101.invoke();
        return;
    }

    public static final void f(ContainerScrollLifecycle r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onPageSelected");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != ContainerScrollLifecycle.ON_PAGE_SELECTED) goto L6;
        r101.invoke();
        return;
    }

    public static final void g(ContainerLifecycle r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onPause");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != ContainerLifecycle.ON_PAUSE) goto L6;
        r101.invoke();
        return;
    }

    public static final void h(ContainerLifecycle r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onResume");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != ContainerLifecycle.ON_RESUME) goto L6;
        r101.invoke();
        return;
    }

    public static final void i(ContainerLifecycle r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onStart");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != ContainerLifecycle.ON_START) goto L6;
        r101.invoke();
        return;
    }

    public static final void j(ContainerLifecycle r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onStop");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != ContainerLifecycle.ON_STOP) goto L6;
        r101.invoke();
        return;
    }

    public static final void k(RoomStateChangeLifecycle r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onVisible");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != RoomStateChangeLifecycle.LIVE_PAGE_ON_VISIBLE) goto L6;
        r101.invoke();
        return;
    }
}
