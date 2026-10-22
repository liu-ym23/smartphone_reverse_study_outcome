package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
@MainDex
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean mCrashAfterReport;
    private boolean mHandlingException;
    private final Thread.UncaughtExceptionHandler mParent;

    public interface Natives {
        void reportJavaException(boolean r100, Throwable r101);

        void reportJavaStackTrace(String r100);
    }

    static {
    }

    private static void installHandler(boolean r100) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), r100));
    }

    public static void reportException(Throwable r100) {
        JavaExceptionReporterJni.get().reportJavaException(false, r100);
    }

    public static void reportStackTrace(String r100) {
        JavaExceptionReporterJni.get().reportJavaStackTrace(PiiElider.sanitizeStacktrace(r100));
    }

    private JavaExceptionReporter(Thread.UncaughtExceptionHandler r100, boolean r101) {
        this.mParent = r100;
        this.mCrashAfterReport = r101;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r100, Throwable r101) {
        if (this.mHandlingException == true) goto L5;
        this.mHandlingException = true;
        JavaExceptionReporterJni.get().reportJavaException(this.mCrashAfterReport, r101);
    L5:
        Thread.UncaughtExceptionHandler r102 = this.mParent;
        if (r102 == null) goto L9;
        r102.uncaughtException(r100, r101);
        return;
    }
}
