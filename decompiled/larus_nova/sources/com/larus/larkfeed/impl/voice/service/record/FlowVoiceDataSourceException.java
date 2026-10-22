package com.larus.larkfeed.impl.voice.service.record;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/larkfeed/impl/voice/service/record/FlowVoiceDataSourceException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "action", "", "errorCode", "", "message", "cause", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "getAction", "()Ljava/lang/String;", "getErrorCode", "()I", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowVoiceDataSourceException extends IllegalStateException {
    private final String action;
    private final int errorCode;

    public final String getAction() {
        return this.action;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public FlowVoiceDataSourceException(String r100, int r101, String r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r102, "message");
        super(r102, r103);
        this.action = r100;
        this.errorCode = r101;
    }
}
