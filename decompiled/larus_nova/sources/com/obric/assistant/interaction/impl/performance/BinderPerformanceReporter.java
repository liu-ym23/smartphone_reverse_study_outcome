package com.obric.assistant.interaction.impl.performance;

import android.os.Process;
import android.util.Log;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.obric.assistant.common.utils.FunctionsKt;
import com.obric.assistant.reporter.IObricReporter;
import gd9.i;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/interaction/impl/performance/BinderPerformanceReporter;", "", "<init>", "()V", "TAG", "", "SCENE_BINDER", "STAGE_MAIN_THREAD_TRANSACT", "KEY_TRACE", "KEY_BINDER_CLASS", "KEY_TRANSACTION_CODE", "KEY_FLAGS", "KEY_PID", "KEY_TID", "KEY_PROCESS_NAME", "report", "", "costMs", "", "binderClass", "transactionCode", "", BinderPerformanceReporter.KEY_FLAGS, BinderPerformanceReporter.KEY_TRACE, "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BinderPerformanceReporter {
    public static final BinderPerformanceReporter INSTANCE = null;
    private static final String KEY_BINDER_CLASS = "binder_class";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_PID = "pid";
    private static final String KEY_PROCESS_NAME = "process_name";
    private static final String KEY_TID = "tid";
    private static final String KEY_TRACE = "trace";
    private static final String KEY_TRANSACTION_CODE = "transaction_code";
    private static final String SCENE_BINDER = "binder";
    private static final String STAGE_MAIN_THREAD_TRANSACT = "main_thread_transact";
    private static final String TAG = "BinderPerformanceReporter";

    static {
        INSTANCE = new BinderPerformanceReporter();
    }

    private BinderPerformanceReporter() {
    }

    public static /* synthetic */ Unit a(long r100, String r101, int r102, int r103, int r104, int r105, Throwable r106) {
        return report$lambda$0(r100, r101, r102, r103, r104, r105, r106);
    }

    @JvmStatic
    public static final void report(final long r110, final String r111, final int r112, final int r113, final Throwable r114) {
        Intrinsics.checkNotNullParameter(r111, "binderClass");
        Intrinsics.checkNotNullParameter(r114, KEY_TRACE);
        final int r100 = Process.myPid();
        final int r101 = Process.myTid();
        FunctionsKt.a(new a(r110, r111, r112, r113, r100, r101, r114));
    }

    private static final Unit report$lambda$0(long r110, String r111, int r112, int r113, int r210, int r211, Throwable r212) {
        i r100 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r100);
        String r101 = q0.b(r100.getApplication());
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        FLogger.f375446a.w(TAG, "slow main-thread Binder transaction, costMs=" + r110 + ", binderClass=" + r111 + ", transactionCode=" + r112 + ", flags=" + r113 + ", pid=" + r210 + ", tid=" + r211 + ", processName=" + r101, r212);
        IObricReporter.f391335a.getClass();
        IObricReporter r102 = IObricReporter.a.a();
        if (r102 == null) goto L9;
        r102.h(SCENE_BINDER, STAGE_MAIN_THREAD_TRANSACT, r110, false, MapsKt.mapOf(new Pair[]{TuplesKt.to(KEY_TRACE, Log.getStackTraceString(r212)), TuplesKt.to(KEY_BINDER_CLASS, r111), TuplesKt.to(KEY_TRANSACTION_CODE, String.valueOf(r112)), TuplesKt.to(KEY_FLAGS, String.valueOf(r113)), TuplesKt.to("pid", String.valueOf(r210)), TuplesKt.to("tid", String.valueOf(r211)), TuplesKt.to("process_name", r101)}));
    L9:
        return Unit.INSTANCE;
    }
}
