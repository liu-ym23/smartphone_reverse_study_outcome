package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class StreamResetException extends IOException {
    public final ErrorCode errorCode;

    public StreamResetException(ErrorCode r100) {
        super("stream was reset: " + r100);
        this.errorCode = r100;
    }
}
