package com.bytedance.sysoptimizer.suppress;

/* JADX INFO: loaded from: classes22.dex */
public interface JniExceptionCallback {
    boolean onJavaException(Throwable r100);

    boolean onUnsatisfiedLinkError(Throwable r100);
}
