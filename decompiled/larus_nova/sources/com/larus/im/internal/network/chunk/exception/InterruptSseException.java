package com.larus.im.internal.network.chunk.exception;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/network/chunk/exception/InterruptSseException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "token", "", "logId", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getLogId", "()Ljava/lang/String;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InterruptSseException extends CancellationException {
    private final String logId;

    public final String getLogId() {
        return this.logId;
    }

    public InterruptSseException(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "logId");
        super("Interrupt message stream for token(" + r100 + "), logId(" + r101 + ')');
        this.logId = r101;
        initCause(r102);
    }
}
