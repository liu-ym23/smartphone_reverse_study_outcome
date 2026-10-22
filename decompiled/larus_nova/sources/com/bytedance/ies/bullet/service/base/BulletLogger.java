package com.bytedance.ies.bullet.service.base;

import android.os.Handler;
import bolts.Task;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.huawei.hms.api.FailedBinderCallBack;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.agilelogger.ALog;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "该类已经废弃，请使用HybridLogger进行日志打印")
public final class BulletLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f247763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f247764b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f247765c = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f247766a = null;

        static {
            int[] r100 = new int[LogLevel.values().length];
            r100[LogLevel.E.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f247766a = r100;
        }
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f247767a;

        public b(Function0<Unit> r100) {
            this.f247767a = r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f247767a.invoke();
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f247768a;

        public c(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f247768a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f247768a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public BulletLogger() {
    }

    static {
        f247763a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("/BulletLogger"));
        f247764b = true;
        f247765c = LazyKt.lazy(BulletLogger$logHandler$2.INSTANCE);
    }

    public static void a(Function0 r100) {
        if (f247764b == false) goto L5;
        ((Handler) f247765c.getValue()).post(new c(r100));
        return;
    L5:
        Task.call(new b(r100), f247763a);
    }

    public static /* synthetic */ void d(String r100) {
        c(r100, LogLevel.I);
    }

    public static void n(String r100) {
        LogLevel r101 = LogLevel.I;
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "logLevel");
        Intrinsics.checkNotNullParameter("", "subModule");
        j(r100, r101, "");
    }

    public static String b(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        boolean r103 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        r102.append("[bulletSession-unknown]");
    L13:
        if (r101 != null) goto L15;
    L18:
        if (r103 == true) goto L21;
        r102.append("[resourceSession-" + r101 + ']');
    L21:
        return r102.toString();
    L15:
        if (r101.length() == 0) goto L18;
        r103 = false;
        goto L18
    L12:
        r102.append("[bulletSession-" + r100 + ']');
        goto L13
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L10
    }

    public static void c(final String r100, final LogLevel r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "level");
        HybridLogger r102 = HybridLogger.f246343a;
        if (HybridLogger.c("BulletLog", r100, r101) == false) goto L5;
        return;
    L5:
        a(new BulletLogger$onLog$1(r101, r100));
    }

    public static void e(final Throwable r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Intrinsics.checkNotNullParameter(r101, "extraMsg");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        a(new BulletLogger$onReject$1$1(r100, r101));     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void j(String r100, LogLevel r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "logLevel");
        Intrinsics.checkNotNullParameter(r102, "subModule");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        if (r102.length() <= 0) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L9;
        r100 = "[" + r102 + "] " + r100;     // Catch: Throwable -> L11
    L9:
        c(r100, r101);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L6:
        r104 = false;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void l(Throwable r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "subModule");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        if (r102.length() <= 0) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L9;
        r101 = "[" + r102 + "] " + r101;     // Catch: Throwable -> L11
    L9:
        e(r100, r101);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L6:
        r104 = false;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void f(String r100, String r101, String r102, LogLevel r103) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "subModule");
        Intrinsics.checkNotNullParameter(r103, "logLevel");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L18
        boolean r105 = false;
        if (r102.length() <= 0) goto L6;
        boolean r106 = true;
    L7:
        if (r106 == false) goto L9;
        r101 = "[" + r102 + "] " + r101;     // Catch: Throwable -> L18
    L9:
        if (r100 != null) goto L11;
    L12:
        r105 = true;
    L13:
        if (r105 == false) goto L15;
        String r107 = "[bulletSession-unknown]-[Core] " + r101;     // Catch: Throwable -> L18
    L16:
        c(r107, r103);     // Catch: Throwable -> L18
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
        return;
    L15:
        r107 = "[bulletSession-" + r100 + "]-[Core] " + r101;     // Catch: Throwable -> L18
        goto L16
    L11:
        if (r100.length() != 0) goto L13;
    L6:
        r106 = false;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static /* synthetic */ void g(String r100, String r101, String r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r103 & 8) == 0) goto L8;
        LogLevel r104 = LogLevel.I;
    L9:
        f(r100, r101, r102, r104);
        return;
    L8:
        r104 = null;
        goto L9
    }

    public static /* synthetic */ void i(String r100, String r101, String r102, Throwable r103) {
        h(r100, r101, r102, r103, LogLevel.W);
    }

    public static /* synthetic */ void k(String r100, LogLevel r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = LogLevel.I;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = "";
    L8:
        j(r100, r101, r102);
    }

    public static void h(String r100, String r101, String r110, Throwable r111, LogLevel r112) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r110, "subModule");
        Intrinsics.checkNotNullParameter(r111, "tr");
        Intrinsics.checkNotNullParameter(r112, "logLevel");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L29
        boolean r103 = false;
        if (r110.length() <= 0) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L9;
        r101 = "[" + r110 + "] " + r101;     // Catch: Throwable -> L29
    L9:
        if (r100 != null) goto L11;
    L12:
        r103 = true;
    L13:
        if (r103 == false) goto L15;
        String r105 = "[bulletSession-unknown]-[Core] " + r101;     // Catch: Throwable -> L29
    L18:
        if (a.f247766a[r112.ordinal()] != 1) goto L23;
        UGLogger.c r106 = UGLogger.f270252a;     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter("BulletLog", "tag");     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r105, "msg");     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r111, "tr");     // Catch: Throwable -> L29
        HybridLogger r107 = HybridLogger.f246343a;     // Catch: Throwable -> L29
        if (HybridLogger.c("BulletLog", r105, LogLevel.E) == true) goto L27;
        ALog.e("BulletLog", r105, r111);     // Catch: Throwable -> L29
    L27:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
        return;
    L23:
        UGLogger.c r108 = UGLogger.f270252a;     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter("BulletLog", "tag");     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r105, "msg");     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r111, "tr");     // Catch: Throwable -> L29
        HybridLogger r109 = HybridLogger.f246343a;     // Catch: Throwable -> L29
        if (HybridLogger.c("BulletLog", r105, LogLevel.W) == true) goto L27;
        ALog.w("BulletLog", r105, r111);     // Catch: Throwable -> L29
        goto L27
    L15:
        r105 = "[bulletSession-" + r100 + "]-[Core] " + r101;     // Catch: Throwable -> L29
        goto L18
    L11:
        if (r100.length() != 0) goto L13;
    L6:
        r104 = false;
    L29:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void m(String r100, Map r101, LogLevel r110, String r111, String r112, int r113) {
        JSONObject r102 = null;
        if ((r113 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r113 & 4) == 0) goto L8;
        r110 = LogLevel.I;
    L8:
        String r103 = "";
        if ((r113 & 8) == 0) goto L12;
        r111 = "";
    L12:
        if ((r113 & 32) == 0) goto L14;
        String r104 = "";
    L16:
        if ((r113 & 64) == 0) goto L18;
        String r114 = "";
    L19:
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r110, "logLevel");
        Intrinsics.checkNotNullParameter(r111, "subModule");
        Intrinsics.checkNotNullParameter(r104, "rlSessionId");
        Intrinsics.checkNotNullParameter(r114, FailedBinderCallBack.CALLER_ID);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L43
        if (r101 == null) goto L24;
        r102 = new JSONObject(r101);     // Catch: Throwable -> L43
    L24:
        boolean r106 = true;
        if (r114.length() <= 0) goto L27;
        boolean r107 = true;
    L28:
        if (r107 == false) goto L31;
        if (r102 == null) goto L31;
        r102.put(FailedBinderCallBack.CALLER_ID, r114);     // Catch: Throwable -> L43
    L31:
        if (r102 == null) goto L34;
        r103 = "xContent:" + r102;     // Catch: Throwable -> L43
    L34:
        String r108 = "xMsg:" + r100 + '|' + r103;     // Catch: Throwable -> L43
        String r109 = b(r112, r104);     // Catch: Throwable -> L43
        if (r111.length() > 0) goto L38;
        r106 = false;
    L38:
        if (r106 == false) goto L40;
        String r115 = r109 + '[' + r111 + "] " + r108;     // Catch: Throwable -> L43
    L41:
        c(r115, r110);     // Catch: Throwable -> L43
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L43
        return;
    L40:
        r115 = r109 + r108;     // Catch: Throwable -> L43
        goto L41
    L27:
        r107 = false;
    L43:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L18:
        r114 = null;
        goto L19
    L14:
        r104 = null;
        goto L16
    }
}
