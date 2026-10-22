package iu7;

import com.flow.performance.quality.appinit.AppLaunchTracer;
import com.larus.init.task.InitALogTask;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f495802a = 0;

    static {
    }

    @JvmStatic
    public static final void a(AppLaunchTracer r100) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        ku7.a r101 = ku7.a.f506216a;
        monitor-enter(r101);
        ku7.a.f506218c = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void b(InitALogTask.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        ku7.a r101 = ku7.a.f506216a;
        monitor-enter(r101);
        ku7.a.f506217b = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void c(boolean r100) {
        ku7.a r101 = ku7.a.f506216a;
        monitor-enter(r101);
        ku7.a.f506219d = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
