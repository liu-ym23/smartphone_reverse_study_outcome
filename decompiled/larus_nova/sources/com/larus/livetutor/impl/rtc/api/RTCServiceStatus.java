package com.larus.livetutor.impl.rtc.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus;", "", "<init>", "()V", "Initial", "Connecting", "Connected", "Error", "Disconnecting", "Terminated", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Connected;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Connecting;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Disconnecting;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Error;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Initial;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Terminated;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class RTCServiceStatus {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Connected;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus;", "<init>", "()V", "businessState", "Lcom/larus/livetutor/impl/rtc/api/BusinessConnectedStatus;", "getBusinessState", "()Lcom/larus/livetutor/impl/rtc/api/BusinessConnectedStatus;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class Connected extends RTCServiceStatus {
        public Connected() {
            super(null);
        }

        public abstract ij9.a getBusinessState();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Connecting;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Connecting extends RTCServiceStatus {
        public static final Connecting INSTANCE = null;

        static {
            INSTANCE = new Connecting();
        }

        private Connecting() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Disconnecting;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Disconnecting extends RTCServiceStatus {
        public static final Disconnecting INSTANCE = null;

        static {
            INSTANCE = new Disconnecting();
        }

        private Disconnecting() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Error;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus;", "message", "", "errorCode", "", "extraInfo", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getErrorCode", "()I", "getExtraInfo", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Error extends RTCServiceStatus {
        private final int errorCode;
        private final String extraInfo;
        private final String message;

        public static /* synthetic */ Error copy$default(Error r100, String r101, int r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.message;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.errorCode;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.extraInfo;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.message;
        }

        public final int component2() {
            return this.errorCode;
        }

        public final String component3() {
            return this.extraInfo;
        }

        public final Error copy(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "message");
            return new Error(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Error) == true) goto L8;
            return false;
        L8:
            Error r101 = (Error) r100;
            if (Intrinsics.areEqual(this.message, r101.message) == true) goto L12;
            return false;
        L12:
            if (this.errorCode == r101.errorCode) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.message.hashCode() * 31) + this.errorCode) * 31;
            String r101 = this.extraInfo;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "Error(message=" + this.message + ", errorCode=" + this.errorCode + ", extraInfo=" + this.extraInfo + ')';
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getExtraInfo() {
            return this.extraInfo;
        }

        public final String getMessage() {
            return this.message;
        }

        public Error(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(null);
            this.message = r100;
            this.errorCode = r101;
            this.extraInfo = r102;
        }

        public /* synthetic */ Error(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 2) == 0) goto L6;
            r101 = -1;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Initial;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Initial extends RTCServiceStatus {
        public static final Initial INSTANCE = null;

        static {
            INSTANCE = new Initial();
        }

        private Initial() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Terminated;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Terminated extends RTCServiceStatus {
        public static final Terminated INSTANCE = null;

        static {
            INSTANCE = new Terminated();
        }

        private Terminated() {
            super(null);
        }
    }

    private RTCServiceStatus() {
    }

    public /* synthetic */ RTCServiceStatus(DefaultConstructorMarker r100) {
        this();
    }
}
