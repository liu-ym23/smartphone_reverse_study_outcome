package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0002\b\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/DefaultCallStatusErrorHandler;", "", "()V", "reporter", "Lcom/bytedance/lark/lark_markdown_render_android/UnhandledExceptionReporter;", "getReporter", "()Lcom/bytedance/lark/lark_markdown_render_android/UnhandledExceptionReporter;", "setReporter", "(Lcom/bytedance/lark/lark_markdown_render_android/UnhandledExceptionReporter;)V", "report", "Lcom/bytedance/lark/lark_markdown_render_android/UnhandledException;", "e", "report$lark_markdown_render_android_release", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public final UnhandledException report$lark_markdown_render_android_release(UnhandledException r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        UnhandledExceptionReporter r0 = reporter;
        if (r0 != null) goto L5;
        return r2;
    L5:
        r0.report(r2);
        return r2;
    }

    public final void setReporter(UnhandledExceptionReporter r1) {
        reporter = r1;
    }
}
