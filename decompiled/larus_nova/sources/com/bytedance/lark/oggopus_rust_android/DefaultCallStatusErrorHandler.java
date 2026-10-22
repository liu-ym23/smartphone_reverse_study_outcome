package com.bytedance.lark.oggopus_rust_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0002\b\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/lark/oggopus_rust_android/DefaultCallStatusErrorHandler;", "", "()V", "reporter", "Lcom/bytedance/lark/oggopus_rust_android/UnhandledExceptionReporter;", "getReporter", "()Lcom/bytedance/lark/oggopus_rust_android/UnhandledExceptionReporter;", "setReporter", "(Lcom/bytedance/lark/oggopus_rust_android/UnhandledExceptionReporter;)V", "report", "Lcom/bytedance/lark/oggopus_rust_android/UnhandledException;", "e", "report$oggopus_rust_android_release", "oggopus_rust_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DefaultCallStatusErrorHandler {
    public static final DefaultCallStatusErrorHandler INSTANCE = null;
    private static UnhandledExceptionReporter reporter;

    static {
        INSTANCE = new DefaultCallStatusErrorHandler();
    }

    private DefaultCallStatusErrorHandler() {
    }

    public final UnhandledExceptionReporter getReporter() {
        return reporter;
    }

    public final UnhandledException report$oggopus_rust_android_release(UnhandledException r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        UnhandledExceptionReporter r101 = reporter;
        if (r101 != null) goto L5;
        return r100;
    L5:
        r101.report(r100);
        return r100;
    }

    public final void setReporter(UnhandledExceptionReporter r100) {
        reporter = r100;
    }
}
