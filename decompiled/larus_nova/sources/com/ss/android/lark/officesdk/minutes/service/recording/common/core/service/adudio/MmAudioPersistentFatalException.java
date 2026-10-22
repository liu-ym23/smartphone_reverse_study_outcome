package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/MmAudioPersistentFatalException;", "", "errorMsg", "", "<init>", "(Ljava/lang/String;)V", "getErrorMsg", "()Ljava/lang/String;", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmAudioPersistentFatalException extends Throwable {
    private final String errorMsg;

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public MmAudioPersistentFatalException(String r100) {
        super(r100);
        this.errorMsg = r100;
    }
}
