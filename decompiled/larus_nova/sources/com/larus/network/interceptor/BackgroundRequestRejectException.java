package com.larus.network.interceptor;

import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0002\u0010\tB\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/larus/network/interceptor/BackgroundRequestRejectException;", "Ljava/io/IOException;", "<init>", "()V", "message", "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BackgroundRequestRejectException extends IOException {
    public BackgroundRequestRejectException() {
    }

    public BackgroundRequestRejectException(String r100) {
        super(r100);
    }

    public BackgroundRequestRejectException(Throwable r100) {
        super(r100);
    }

    public BackgroundRequestRejectException(String r100, Throwable r101) {
        super(r100, r101);
    }
}
