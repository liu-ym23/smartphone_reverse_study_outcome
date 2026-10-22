package com.larus.im.internal.network.chunk.exception;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.x;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/network/chunk/exception/ReceiveChunkTimeoutException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "coroutine", "Lkotlinx/coroutines/Job;", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "(Ljava/lang/String;)V", "createCopy", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReceiveChunkTimeoutException extends CancellationException implements x<ReceiveChunkTimeoutException> {
    public final Job coroutine;

    @Override // kotlinx.coroutines.x
    public ReceiveChunkTimeoutException createCopy() {
        String r100 = getMessage();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        ReceiveChunkTimeoutException r101 = new ReceiveChunkTimeoutException(r100, this.coroutine);
        r101.initCause(this);
        return r101;
    }

    @Override // kotlinx.coroutines.x
    public /* bridge */ /* synthetic */ Throwable createCopy() {
        return createCopy();
    }

    public ReceiveChunkTimeoutException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this(r100, null);
    }

    public ReceiveChunkTimeoutException(String r100, Job r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
        this.coroutine = r101;
    }
}
