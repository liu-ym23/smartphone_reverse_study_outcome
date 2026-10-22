package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0011\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001cB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0011\u001d\u001e\u001f !\"#$%&'()*+,-¨\u0006."}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "", "errorCode", "", "errorMsg", "", "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "TypeDisMatch", "AlreadyRecording", "RecordingStarting", "CreateRecordingRequestFailed", "AudioPermissionDenied", "RtcServiceNotAvailable", "RecordingNotFound", "StateError", "PhoneCallBusy", "NoQuota", "BusyTooManyUsers", "TooManyUnfinishedRecording", "RecordingRtcError", "NoLocalStorageError", "MaxLimitTimeError", "InternalError", "PriorityActionFailed", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$AlreadyRecording;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$AudioPermissionDenied;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$BusyTooManyUsers;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$CreateRecordingRequestFailed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$InternalError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$MaxLimitTimeError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$NoLocalStorageError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$NoQuota;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$PhoneCallBusy;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$PriorityActionFailed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingNotFound;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingRtcError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingStarting;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RtcServiceNotAvailable;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$StateError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$TooManyUnfinishedRecording;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$TypeDisMatch;", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MmRecordingError extends Throwable {
    private final int errorCode;
    private final String errorMsg;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$AlreadyRecording;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AlreadyRecording extends MmRecordingError {
        public static final AlreadyRecording INSTANCE = null;

        static {
            INSTANCE = new AlreadyRecording();
        }

        private AlreadyRecording() {
            super(-10001, "already recording", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$AudioPermissionDenied;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AudioPermissionDenied extends MmRecordingError {
        public static final AudioPermissionDenied INSTANCE = null;

        static {
            INSTANCE = new AudioPermissionDenied();
        }

        private AudioPermissionDenied() {
            super(-10003, "audio permission denied", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$BusyTooManyUsers;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BusyTooManyUsers extends MmRecordingError {
        public static final BusyTooManyUsers INSTANCE = null;

        static {
            INSTANCE = new BusyTooManyUsers();
        }

        private BusyTooManyUsers() {
            super(220206, "busy too many users", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$CreateRecordingRequestFailed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CreateRecordingRequestFailed extends MmRecordingError {
        public static final CreateRecordingRequestFailed INSTANCE = null;

        static {
            INSTANCE = new CreateRecordingRequestFailed();
        }

        private CreateRecordingRequestFailed() {
            super(-10002, "create recording request failed", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$InternalError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InternalError extends MmRecordingError {
        public static final InternalError INSTANCE = null;

        static {
            INSTANCE = new InternalError();
        }

        private InternalError() {
            super(-10005, "internal error", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$MaxLimitTimeError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MaxLimitTimeError extends MmRecordingError {
        public static final MaxLimitTimeError INSTANCE = null;

        static {
            INSTANCE = new MaxLimitTimeError();
        }

        private MaxLimitTimeError() {
            super(-10008, "max limit time error", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$NoLocalStorageError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NoLocalStorageError extends MmRecordingError {
        public static final NoLocalStorageError INSTANCE = null;

        static {
            INSTANCE = new NoLocalStorageError();
        }

        private NoLocalStorageError() {
            super(-10007, "no local storage error", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$NoQuota;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NoQuota extends MmRecordingError {
        public static final NoQuota INSTANCE = null;

        static {
            INSTANCE = new NoQuota();
        }

        private NoQuota() {
            super(220202, "vc no quota", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$PhoneCallBusy;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PhoneCallBusy extends MmRecordingError {
        public static final PhoneCallBusy INSTANCE = null;

        static {
            INSTANCE = new PhoneCallBusy();
        }

        private PhoneCallBusy() {
            super(OfficeSDKPluginErrorCode.LOAD_FAILED, "phone call busy", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$PriorityActionFailed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "code", "", "detail", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getDetail", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PriorityActionFailed extends MmRecordingError {
        private final int code;
        private final String detail;

        public static /* synthetic */ PriorityActionFailed copy$default(PriorityActionFailed r100, int r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.code;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.detail;
        L9:
            return r100.copy(r101, r102);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.detail;
        }

        public final PriorityActionFailed copy(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "detail");
            return new PriorityActionFailed(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PriorityActionFailed) == true) goto L8;
            return false;
        L8:
            PriorityActionFailed r101 = (PriorityActionFailed) r100;
            if (this.code == r101.code) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.detail, r101.detail) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.code * 31) + this.detail.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "PriorityActionFailed(code=" + this.code + ", detail=" + this.detail + ')';
        }

        public final int getCode() {
            return this.code;
        }

        public final String getDetail() {
            return this.detail;
        }

        public PriorityActionFailed(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "detail");
            super(r100, r101, null);
            this.code = r100;
            this.detail = r101;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingNotFound;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "equals", "", "other", "hashCode", "", "toString", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecordingNotFound extends MmRecordingError {
        public static final RecordingNotFound INSTANCE = null;

        static {
            INSTANCE = new RecordingNotFound();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RecordingNotFound) == true) goto L9;
            return false;
        L9:
            RecordingNotFound r101 = (RecordingNotFound) r100;
            return true;
        }

        public int hashCode() {
            return -793623046;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "RecordingNotFound";
        }

        private RecordingNotFound() {
            super(OfficeSDKPluginErrorCode.DOWNLOAD_FAILED, "recording not found", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingRtcError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecordingRtcError extends MmRecordingError {
        public static final RecordingRtcError INSTANCE = null;

        static {
            INSTANCE = new RecordingRtcError();
        }

        private RecordingRtcError() {
            super(-10006, "recording rtc error", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingStarting;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecordingStarting extends MmRecordingError {
        public static final RecordingStarting INSTANCE = null;

        static {
            INSTANCE = new RecordingStarting();
        }

        private RecordingStarting() {
            super(-10009, "recording starting", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RtcServiceNotAvailable;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RtcServiceNotAvailable extends MmRecordingError {
        public static final RtcServiceNotAvailable INSTANCE = null;

        static {
            INSTANCE = new RtcServiceNotAvailable();
        }

        private RtcServiceNotAvailable() {
            super(-10004, "rtc service not available", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$StateError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StateError extends MmRecordingError {
        public static final StateError INSTANCE = null;

        static {
            INSTANCE = new StateError();
        }

        private StateError() {
            super(OfficeSDKPluginErrorCode.INSTALL_FAILED, "state error", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$TooManyUnfinishedRecording;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TooManyUnfinishedRecording extends MmRecordingError {
        public static final TooManyUnfinishedRecording INSTANCE = null;

        static {
            INSTANCE = new TooManyUnfinishedRecording();
        }

        private TooManyUnfinishedRecording() {
            super(220207, "too many unfinished recording", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$TypeDisMatch;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TypeDisMatch extends MmRecordingError {
        public static final TypeDisMatch INSTANCE = null;

        static {
            INSTANCE = new TypeDisMatch();
        }

        private TypeDisMatch() {
            super(-10000, "type dis match", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public MmRecordingError(int r100, String r101, DefaultConstructorMarker r102) {
        super(r101);
        this.errorCode = r100;
        this.errorMsg = r101;
    }
}
