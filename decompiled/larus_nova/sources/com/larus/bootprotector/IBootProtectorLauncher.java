package com.larus.bootprotector;

import android.content.Context;
import au8.e;
import com.google.gson.JsonArray;
import com.larus.init.task.anr.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&¨\u0006\u001f"}, d2 = {"Lcom/larus/bootprotector/IBootProtectorLauncher;", "", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "checkBootProtectorEffect", "baseContext", "checkToCleanFileSilent", "isBootProtectorEnabled", "", "shouldEnterBootProtectorPage", "updateBootProtectorSettings", "initNpthMonitor", "initAnrMonitor", "startBootProtectorLandingPage", "getBootProtectorDependency", "Lcom/larus/bootprotector/BootProtectorDependency;", "executeCmdArray", "ctx", "cmds", "Lcom/google/gson/JsonArray;", "executeCmds", "", "onAppRestartAfterCrash", "clearBootProtectorData", "registerANRListener", "listener", "Lcom/larus/bootprotector/anr/FlowAnrListener;", "unregisterANRListener", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBootProtectorLauncher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f317602a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f317603a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<IBootProtectorLauncher> f317604b = null;

        public a() {
        }

        static {
            f317603a = new a();
            f317604b = LazyKt.lazy(new e());
        }

        public static IBootProtectorLauncher c() {
            return f317604b.getValue();
        }

        public static BootProtectorDependency b() {
            IBootProtectorLauncher r100 = c();
            if (r100 == null) goto L7;
            BootProtectorDependency r101 = r100.b();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return new BootProtectorDependencyDefault();
        }

        public static void a(Context r100, JsonArray r101) {
            Intrinsics.checkNotNullParameter(r100, "ctx");
            Intrinsics.checkNotNullParameter(r101, "cmds");
            IBootProtectorLauncher r102 = c();
            if (r102 == null) goto L6;
            r102.e(r100, r101);
            return;
        }
    }

    static {
        f317602a = a.f317603a;
    }

    void a(c r100);

    BootProtectorDependency b();

    boolean c(Context r100);

    void d(Context r100);

    void e(Context r100, JsonArray r101);

    void f();

    void g(Context r100);

    void h(Context r100);

    void i(Context r100);

    void init(Context r100);

    void j(Context r100);

    void k();
}
