package com.ss.android.lark.utils.rxjava;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/utils/rxjava/TracedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "cause", "", "trace", "", "Ljava/lang/StackTraceElement;", "<init>", "(Ljava/lang/Throwable;[Ljava/lang/StackTraceElement;)V", "rxjava-wrapper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class TracedException extends RuntimeException {
    public TracedException(Throwable r100, StackTraceElement[] r101) {
        Intrinsics.checkNotNullParameter(r100, "cause");
        Intrinsics.checkNotNullParameter(r101, "trace");
        super(r100);
        setStackTrace(r101);
    }
}
