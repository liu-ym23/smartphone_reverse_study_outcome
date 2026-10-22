package com.bytedance.flow_audio.impl.business.tts;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/flow_audio/impl/business/tts/FlowTtsSessionTimeoutException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "sessionId", "", "timeoutMs", "", "<init>", "(Ljava/lang/String;J)V", "getSessionId", "()Ljava/lang/String;", "getTimeoutMs", "()J", "flow_audio_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowTtsSessionTimeoutException extends Exception {
    private final String sessionId;
    private final long timeoutMs;

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public FlowTtsSessionTimeoutException(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        super("FlowTtsSession synthesize timeout, sessionId=" + r100 + ", timeoutMs=" + r101);
        this.sessionId = r100;
        this.timeoutMs = r101;
    }
}
