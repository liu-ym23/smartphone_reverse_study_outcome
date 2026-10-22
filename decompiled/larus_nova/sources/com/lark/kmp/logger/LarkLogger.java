package com.lark.kmp.logger;

import com.ss.android.rust.molten.ffi.LogConfig;
import com.ss.android.rust.molten.ffi.MoltenLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: classes7.dex */
public final class LarkLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LarkLogger f278603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f278604b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile LogConfig f278605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Function0<Boolean> f278606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile MoltenLogger f278607e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f278608a = null;

        static {
            int[] r100 = new int[LogLevel.values().length];
            r100[LogLevel.STUB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[LogLevel.VERB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[LogLevel.DEBUG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[LogLevel.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[LogLevel.WARN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[LogLevel.ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[LogLevel.FATAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f278608a = r100;
        }
    }

    public LarkLogger() {
    }

    static {
        f278603a = new LarkLogger();
        f278604b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(w1.a(1, "KMP-Rust-Logger-Thread")));
        f278606d = LarkLogger$isNativeLoaded$1.INSTANCE;
    }

    public static void e(String r100) {
        Intrinsics.checkNotNullParameter("sdk", "tag");
        LogLevel r101 = LogLevel.WARN;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        d(r101, "sdk", r100);
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        LogLevel r102 = LogLevel.DEBUG;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        d(r102, r100, r101);
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        LogLevel r102 = LogLevel.ERROR;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        d(r102, r100, r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        LogLevel r102 = LogLevel.INFO;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        d(r102, r100, r101);
    }

    public static void d(LogLevel r110, String r111, String r112) {
        String r100 = "kmp:".concat(r112);
        switch(a.f278608a[r110.ordinal()]) {
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        String r101 = ThreadMethodProxy.currentThread().getName();
        BuildersKt.launch$default(f278604b, null, null, new LarkLogger$log$1(r110, r100, r111, r101, null), 3, null);
        return;
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
