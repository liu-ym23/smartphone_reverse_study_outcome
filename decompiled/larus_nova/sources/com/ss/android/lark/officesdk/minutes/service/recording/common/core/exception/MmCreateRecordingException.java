package com.ss.android.lark.officesdk.minutes.service.recording.common.core.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException;", "", "message", "", "<init>", "(Ljava/lang/String;)V", "MmRecordingOccupiedException", "MmRecordingNoQuotaException", "MmRecordingCreateFailedException", "MmRecordingOtherException", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException$MmRecordingCreateFailedException;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException$MmRecordingNoQuotaException;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException$MmRecordingOccupiedException;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException$MmRecordingOtherException;", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MmCreateRecordingException extends Throwable {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException$MmRecordingCreateFailedException;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException;", "<init>", "()V", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MmRecordingCreateFailedException extends MmCreateRecordingException {
        public MmRecordingCreateFailedException() {
            super("create recording failed", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException$MmRecordingNoQuotaException;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException;", "<init>", "()V", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MmRecordingNoQuotaException extends MmCreateRecordingException {
        public MmRecordingNoQuotaException() {
            super("no quota", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException$MmRecordingOccupiedException;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException;", "<init>", "()V", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MmRecordingOccupiedException extends MmCreateRecordingException {
        public MmRecordingOccupiedException() {
            super("recording occupied", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException$MmRecordingOtherException;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/exception/MmCreateRecordingException;", "errorCode", "", "errorMsg", "", "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MmRecordingOtherException extends MmCreateRecordingException {
        private final int errorCode;
        private final String errorMsg;

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public MmRecordingOtherException(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMsg");
            super("errorCode:" + r100 + ", errorMsg:" + r101, null);
            this.errorCode = r100;
            this.errorMsg = r101;
        }
    }

    public MmCreateRecordingException(String r100, DefaultConstructorMarker r101) {
        super(r100);
    }
}
