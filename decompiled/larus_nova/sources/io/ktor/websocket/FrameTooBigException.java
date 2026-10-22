package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.x;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0000H\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lio/ktor/websocket/FrameTooBigException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlinx/coroutines/x;", "createCopy", "", "frameSize", "J", "getFrameSize", "()J", "", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(J)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
public final class FrameTooBigException extends Exception implements x<FrameTooBigException> {
    private final long frameSize;

    @Override // kotlinx.coroutines.x
    public FrameTooBigException createCopy() {
        FrameTooBigException r100 = new FrameTooBigException(this.frameSize);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(this, "cause");
        r100.initCause(this);
        return r100;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Frame is too big: " + this.frameSize;
    }

    public final long getFrameSize() {
        return this.frameSize;
    }

    @Override // kotlinx.coroutines.x
    public /* bridge */ /* synthetic */ Throwable createCopy() {
        return createCopy();
    }

    public FrameTooBigException(long r100) {
        this.frameSize = r100;
    }
}
