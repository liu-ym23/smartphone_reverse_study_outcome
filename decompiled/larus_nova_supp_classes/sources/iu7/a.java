package iu7;

import com.flow.performance.quality.appinit.AppLaunchTracer;
import com.larus.init.task.InitALogTask;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(AppLaunchTracer r1) {
        Intrinsics.checkNotNullParameter(r1, "logger");
        ku7.a r0 = ku7.a.a;
        monitor-enter(r0);
        ku7.a.c = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void b(InitALogTask.a r1) {
        Intrinsics.checkNotNullParameter(r1, "reporter");
        ku7.a r0 = ku7.a.a;
        monitor-enter(r0);
        ku7.a.b = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void c(boolean r1) {
        ku7.a r0 = ku7.a.a;
        monitor-enter(r0);
        ku7.a.d = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
