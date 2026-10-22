package com.larus.livetutor.impl.rtc.api;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.larus.livetutor.api.idl.AnswerEndMsg;
import com.larus.livetutor.api.idl.AnswerStartMsg;
import com.larus.livetutor.api.idl.ConnectedStatus;
import com.larus.livetutor.api.idl.LiveTutorClientControlMsg;
import com.larus.livetutor.api.idl.LiveTutorRoundEndMsg;
import com.larus.livetutor.api.idl.LiveTutorStartMsg;
import com.larus.livetutor.api.idl.LoadingStartMsg;
import com.larus.livetutor.api.idl.UploadDataMsg;
import com.larus.livetutor.api.idl.UserAsrEndMsg;
import com.larus.livetutor.api.idl.UserAsrStartMsg;
import com.larus.livetutor.api.idl.WaitUserAnswerMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u001a\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001dB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u001a\u001e\u001f !\"#$%&'()*+,-./01234567¨\u00068"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "", "<init>", "()V", "StartConnect", "ConnectSuccess", "ConnectFail", "ConnectTimeOut", "ConnectBreak", "ReceiveServerError", "ReceiveUserAsrEnd", "ReceiveAnswerStart", "ReceiveAnswerEnd", "UserInterrupt", "UserAsrStart", "UserExit", "ReceiveServerLeaveRoom", "ExitRTC", "LoadingStart", "LiveTutorStart", "WaitUserAnswer", "RoundEnd", "PressAsr", "CancelAsr", "SubmitAsr", "AsrEmpty", "Replay", "UploadData", "ClientControl", "MediaFocusChanged", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$AsrEmpty;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$CancelAsr;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$ClientControl;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$ConnectBreak;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$ConnectFail;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$ConnectSuccess;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$ConnectTimeOut;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$ExitRTC;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$LiveTutorStart;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$LoadingStart;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$MediaFocusChanged;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$PressAsr;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$ReceiveAnswerEnd;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$ReceiveAnswerStart;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$ReceiveServerError;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$ReceiveServerLeaveRoom;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$ReceiveUserAsrEnd;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$Replay;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$RoundEnd;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$StartConnect;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$SubmitAsr;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$UploadData;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$UserAsrStart;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$UserExit;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$UserInterrupt;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction$WaitUserAnswer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class RTCAction {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$AsrEmpty;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "lastStatus", "Lcom/larus/livetutor/impl/rtc/api/BusinessConnectedStatus;", "<init>", "(Lcom/larus/livetutor/impl/rtc/api/BusinessConnectedStatus;)V", "getLastStatus", "()Lcom/larus/livetutor/impl/rtc/api/BusinessConnectedStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AsrEmpty extends RTCAction {
        private final ij9.a lastStatus;

        public static /* synthetic */ AsrEmpty copy$default(AsrEmpty r100, ij9.a r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.lastStatus;
        L6:
            return r100.copy(r101);
        }

        public final ij9.a component1() {
            return this.lastStatus;
        }

        public final AsrEmpty copy(ij9.a r100) {
            return new AsrEmpty(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AsrEmpty) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.lastStatus, ((AsrEmpty) r100).lastStatus) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            ij9.a r100 = this.lastStatus;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "AsrEmpty(lastStatus=" + this.lastStatus + ')';
        }

        public final ij9.a getLastStatus() {
            return this.lastStatus;
        }

        public AsrEmpty(ij9.a r100) {
            super(null);
            this.lastStatus = r100;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$CancelAsr;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", ST.UUID_DEVICE, "", "lastStatus", "Lcom/larus/livetutor/impl/rtc/api/BusinessConnectedStatus;", "<init>", "(Ljava/lang/String;Lcom/larus/livetutor/impl/rtc/api/BusinessConnectedStatus;)V", "getUuid", "()Ljava/lang/String;", "getLastStatus", "()Lcom/larus/livetutor/impl/rtc/api/BusinessConnectedStatus;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CancelAsr extends RTCAction {
        private final ij9.a lastStatus;
        private final String uuid;

        public static /* synthetic */ CancelAsr copy$default(CancelAsr r100, String r101, ij9.a r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.uuid;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.lastStatus;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.uuid;
        }

        public final ij9.a component2() {
            return this.lastStatus;
        }

        public final CancelAsr copy(String r100, ij9.a r101) {
            Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
            return new CancelAsr(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof CancelAsr) == true) goto L8;
            return false;
        L8:
            CancelAsr r101 = (CancelAsr) r100;
            if (Intrinsics.areEqual(this.uuid, r101.uuid) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.lastStatus, r101.lastStatus) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r100 = this.uuid.hashCode() * 31;
            ij9.a r101 = this.lastStatus;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "CancelAsr(uuid=" + this.uuid + ", lastStatus=" + this.lastStatus + ')';
        }

        public final ij9.a getLastStatus() {
            return this.lastStatus;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public CancelAsr(String r100, ij9.a r101) {
            Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
            super(null);
            this.uuid = r100;
            this.lastStatus = r101;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$ClientControl;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "controlMsg", "Lcom/larus/livetutor/api/idl/LiveTutorClientControlMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/LiveTutorClientControlMsg;)V", "getControlMsg", "()Lcom/larus/livetutor/api/idl/LiveTutorClientControlMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ClientControl extends RTCAction {
        private final LiveTutorClientControlMsg controlMsg;

        public static /* synthetic */ ClientControl copy$default(ClientControl r100, LiveTutorClientControlMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.controlMsg;
        L6:
            return r100.copy(r101);
        }

        public final LiveTutorClientControlMsg component1() {
            return this.controlMsg;
        }

        public final ClientControl copy(LiveTutorClientControlMsg r100) {
            Intrinsics.checkNotNullParameter(r100, "controlMsg");
            return new ClientControl(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ClientControl) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.controlMsg, ((ClientControl) r100).controlMsg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.controlMsg.hashCode();
        }

        public String toString() {
            return "ClientControl(controlMsg=" + this.controlMsg + ')';
        }

        public final LiveTutorClientControlMsg getControlMsg() {
            return this.controlMsg;
        }

        public ClientControl(LiveTutorClientControlMsg r100) {
            Intrinsics.checkNotNullParameter(r100, "controlMsg");
            super(null);
            this.controlMsg = r100;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$ConnectBreak;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "errorType", "", "errorCode", "", "<init>", "(Ljava/lang/String;I)V", "getErrorType", "()Ljava/lang/String;", "getErrorCode", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConnectBreak extends RTCAction {
        private final int errorCode;
        private final String errorType;

        public static /* synthetic */ ConnectBreak copy$default(ConnectBreak r100, String r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.errorType;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.errorCode;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.errorType;
        }

        public final int component2() {
            return this.errorCode;
        }

        public final ConnectBreak copy(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "errorType");
            return new ConnectBreak(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ConnectBreak) == true) goto L8;
            return false;
        L8:
            ConnectBreak r101 = (ConnectBreak) r100;
            if (Intrinsics.areEqual(this.errorType, r101.errorType) == true) goto L12;
            return false;
        L12:
            if (this.errorCode == r101.errorCode) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.errorType.hashCode() * 31) + this.errorCode;
        }

        public String toString() {
            return "ConnectBreak(errorType=" + this.errorType + ", errorCode=" + this.errorCode + ')';
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorType() {
            return this.errorType;
        }

        public ConnectBreak(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "errorType");
            super(null);
            this.errorType = r100;
            this.errorCode = r101;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$ConnectFail;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "errorType", "", "errorCode", "", "extraInfo", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getErrorType", "()Ljava/lang/String;", "getErrorCode", "()I", "getExtraInfo", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConnectFail extends RTCAction {
        private final int errorCode;
        private final String errorType;
        private final String extraInfo;

        public static /* synthetic */ ConnectFail copy$default(ConnectFail r100, String r101, int r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.errorType;
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
            return this.errorType;
        }

        public final int component2() {
            return this.errorCode;
        }

        public final String component3() {
            return this.extraInfo;
        }

        public final ConnectFail copy(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "errorType");
            return new ConnectFail(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ConnectFail) == true) goto L8;
            return false;
        L8:
            ConnectFail r101 = (ConnectFail) r100;
            if (Intrinsics.areEqual(this.errorType, r101.errorType) == true) goto L12;
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
            int r100 = ((this.errorType.hashCode() * 31) + this.errorCode) * 31;
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
            return "ConnectFail(errorType=" + this.errorType + ", errorCode=" + this.errorCode + ", extraInfo=" + this.extraInfo + ')';
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorType() {
            return this.errorType;
        }

        public final String getExtraInfo() {
            return this.extraInfo;
        }

        public ConnectFail(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "errorType");
            super(null);
            this.errorType = r100;
            this.errorCode = r101;
            this.extraInfo = r102;
        }

        public /* synthetic */ ConnectFail(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$ConnectSuccess;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "startStatus", "Lcom/larus/livetutor/api/idl/ConnectedStatus;", "<init>", "(Lcom/larus/livetutor/api/idl/ConnectedStatus;)V", "getStartStatus", "()Lcom/larus/livetutor/api/idl/ConnectedStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConnectSuccess extends RTCAction {
        private final ConnectedStatus startStatus;

        /* JADX WARN: Multi-variable type inference failed */
        public ConnectSuccess() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ConnectSuccess copy$default(ConnectSuccess r100, ConnectedStatus r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.startStatus;
        L6:
            return r100.copy(r101);
        }

        public final ConnectedStatus component1() {
            return this.startStatus;
        }

        public final ConnectSuccess copy(ConnectedStatus r100) {
            return new ConnectSuccess(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ConnectSuccess) == true) goto L9;
            return false;
        L9:
            if (this.startStatus == ((ConnectSuccess) r100).startStatus) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            ConnectedStatus r100 = this.startStatus;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "ConnectSuccess(startStatus=" + this.startStatus + ')';
        }

        public final ConnectedStatus getStartStatus() {
            return this.startStatus;
        }

        public ConnectSuccess(ConnectedStatus r100) {
            super(null);
            this.startStatus = r100;
        }

        public /* synthetic */ ConnectSuccess(ConnectedStatus r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$ConnectTimeOut;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "errorType", "", "errorCode", "", "<init>", "(Ljava/lang/String;I)V", "getErrorType", "()Ljava/lang/String;", "getErrorCode", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConnectTimeOut extends RTCAction {
        private final int errorCode;
        private final String errorType;

        public static /* synthetic */ ConnectTimeOut copy$default(ConnectTimeOut r100, String r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.errorType;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.errorCode;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.errorType;
        }

        public final int component2() {
            return this.errorCode;
        }

        public final ConnectTimeOut copy(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "errorType");
            return new ConnectTimeOut(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ConnectTimeOut) == true) goto L8;
            return false;
        L8:
            ConnectTimeOut r101 = (ConnectTimeOut) r100;
            if (Intrinsics.areEqual(this.errorType, r101.errorType) == true) goto L12;
            return false;
        L12:
            if (this.errorCode == r101.errorCode) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.errorType.hashCode() * 31) + this.errorCode;
        }

        public String toString() {
            return "ConnectTimeOut(errorType=" + this.errorType + ", errorCode=" + this.errorCode + ')';
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorType() {
            return this.errorType;
        }

        public ConnectTimeOut(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "errorType");
            super(null);
            this.errorType = r100;
            this.errorCode = r101;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$ExitRTC;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ExitRTC extends RTCAction {
        public static final ExitRTC INSTANCE = null;

        static {
            INSTANCE = new ExitRTC();
        }

        private ExitRTC() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$LiveTutorStart;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "msg", "Lcom/larus/livetutor/api/idl/LiveTutorStartMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/LiveTutorStartMsg;)V", "getMsg", "()Lcom/larus/livetutor/api/idl/LiveTutorStartMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LiveTutorStart extends RTCAction {
        private final LiveTutorStartMsg msg;

        public static /* synthetic */ LiveTutorStart copy$default(LiveTutorStart r100, LiveTutorStartMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.msg;
        L6:
            return r100.copy(r101);
        }

        public final LiveTutorStartMsg component1() {
            return this.msg;
        }

        public final LiveTutorStart copy(LiveTutorStartMsg r100) {
            return new LiveTutorStart(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LiveTutorStart) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.msg, ((LiveTutorStart) r100).msg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            LiveTutorStartMsg r100 = this.msg;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "LiveTutorStart(msg=" + this.msg + ')';
        }

        public final LiveTutorStartMsg getMsg() {
            return this.msg;
        }

        public LiveTutorStart(LiveTutorStartMsg r100) {
            super(null);
            this.msg = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$LoadingStart;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "msg", "Lcom/larus/livetutor/api/idl/LoadingStartMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/LoadingStartMsg;)V", "getMsg", "()Lcom/larus/livetutor/api/idl/LoadingStartMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadingStart extends RTCAction {
        private final LoadingStartMsg msg;

        public static /* synthetic */ LoadingStart copy$default(LoadingStart r100, LoadingStartMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.msg;
        L6:
            return r100.copy(r101);
        }

        public final LoadingStartMsg component1() {
            return this.msg;
        }

        public final LoadingStart copy(LoadingStartMsg r100) {
            return new LoadingStart(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LoadingStart) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.msg, ((LoadingStart) r100).msg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            LoadingStartMsg r100 = this.msg;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "LoadingStart(msg=" + this.msg + ')';
        }

        public final LoadingStartMsg getMsg() {
            return this.msg;
        }

        public LoadingStart(LoadingStartMsg r100) {
            super(null);
            this.msg = r100;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$MediaFocusChanged;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "isPause", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MediaFocusChanged extends RTCAction {
        private final boolean isPause;

        public static /* synthetic */ MediaFocusChanged copy$default(MediaFocusChanged r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.isPause;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.isPause;
        }

        public final MediaFocusChanged copy(boolean r100) {
            return new MediaFocusChanged(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof MediaFocusChanged) == true) goto L9;
            return false;
        L9:
            if (this.isPause == ((MediaFocusChanged) r100).isPause) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            if (this.isPause == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public String toString() {
            return "MediaFocusChanged(isPause=" + this.isPause + ')';
        }

        public final boolean isPause() {
            return this.isPause;
        }

        public MediaFocusChanged(boolean r100) {
            super(null);
            this.isPause = r100;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$PressAsr;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", ST.UUID_DEVICE, "", "<init>", "(Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PressAsr extends RTCAction {
        private final String uuid;

        public static /* synthetic */ PressAsr copy$default(PressAsr r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.uuid;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.uuid;
        }

        public final PressAsr copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
            return new PressAsr(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PressAsr) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.uuid, ((PressAsr) r100).uuid) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.uuid.hashCode();
        }

        public String toString() {
            return "PressAsr(uuid=" + this.uuid + ')';
        }

        public final String getUuid() {
            return this.uuid;
        }

        public PressAsr(String r100) {
            Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
            super(null);
            this.uuid = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$ReceiveAnswerEnd;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "msg", "Lcom/larus/livetutor/api/idl/AnswerEndMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/AnswerEndMsg;)V", "getMsg", "()Lcom/larus/livetutor/api/idl/AnswerEndMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReceiveAnswerEnd extends RTCAction {
        private final AnswerEndMsg msg;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveAnswerEnd() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ReceiveAnswerEnd copy$default(ReceiveAnswerEnd r100, AnswerEndMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.msg;
        L6:
            return r100.copy(r101);
        }

        public final AnswerEndMsg component1() {
            return this.msg;
        }

        public final ReceiveAnswerEnd copy(AnswerEndMsg r100) {
            return new ReceiveAnswerEnd(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ReceiveAnswerEnd) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.msg, ((ReceiveAnswerEnd) r100).msg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            AnswerEndMsg r100 = this.msg;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "ReceiveAnswerEnd(msg=" + this.msg + ')';
        }

        public final AnswerEndMsg getMsg() {
            return this.msg;
        }

        public ReceiveAnswerEnd(AnswerEndMsg r100) {
            super(null);
            this.msg = r100;
        }

        public /* synthetic */ ReceiveAnswerEnd(AnswerEndMsg r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$ReceiveAnswerStart;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "msg", "Lcom/larus/livetutor/api/idl/AnswerStartMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/AnswerStartMsg;)V", "getMsg", "()Lcom/larus/livetutor/api/idl/AnswerStartMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReceiveAnswerStart extends RTCAction {
        private final AnswerStartMsg msg;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveAnswerStart() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ReceiveAnswerStart copy$default(ReceiveAnswerStart r100, AnswerStartMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.msg;
        L6:
            return r100.copy(r101);
        }

        public final AnswerStartMsg component1() {
            return this.msg;
        }

        public final ReceiveAnswerStart copy(AnswerStartMsg r100) {
            return new ReceiveAnswerStart(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ReceiveAnswerStart) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.msg, ((ReceiveAnswerStart) r100).msg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            AnswerStartMsg r100 = this.msg;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "ReceiveAnswerStart(msg=" + this.msg + ')';
        }

        public final AnswerStartMsg getMsg() {
            return this.msg;
        }

        public ReceiveAnswerStart(AnswerStartMsg r100) {
            super(null);
            this.msg = r100;
        }

        public /* synthetic */ ReceiveAnswerStart(AnswerStartMsg r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$ReceiveServerError;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "errorType", "", "errorCode", "", "<init>", "(Ljava/lang/String;I)V", "getErrorType", "()Ljava/lang/String;", "getErrorCode", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReceiveServerError extends RTCAction {
        private final int errorCode;
        private final String errorType;

        public static /* synthetic */ ReceiveServerError copy$default(ReceiveServerError r100, String r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.errorType;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.errorCode;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.errorType;
        }

        public final int component2() {
            return this.errorCode;
        }

        public final ReceiveServerError copy(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "errorType");
            return new ReceiveServerError(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ReceiveServerError) == true) goto L8;
            return false;
        L8:
            ReceiveServerError r101 = (ReceiveServerError) r100;
            if (Intrinsics.areEqual(this.errorType, r101.errorType) == true) goto L12;
            return false;
        L12:
            if (this.errorCode == r101.errorCode) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.errorType.hashCode() * 31) + this.errorCode;
        }

        public String toString() {
            return "ReceiveServerError(errorType=" + this.errorType + ", errorCode=" + this.errorCode + ')';
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorType() {
            return this.errorType;
        }

        public ReceiveServerError(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "errorType");
            super(null);
            this.errorType = r100;
            this.errorCode = r101;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$ReceiveServerLeaveRoom;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "errorType", "", "errorCode", "", "<init>", "(Ljava/lang/String;I)V", "getErrorType", "()Ljava/lang/String;", "getErrorCode", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReceiveServerLeaveRoom extends RTCAction {
        private final int errorCode;
        private final String errorType;

        public static /* synthetic */ ReceiveServerLeaveRoom copy$default(ReceiveServerLeaveRoom r100, String r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.errorType;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.errorCode;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.errorType;
        }

        public final int component2() {
            return this.errorCode;
        }

        public final ReceiveServerLeaveRoom copy(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "errorType");
            return new ReceiveServerLeaveRoom(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ReceiveServerLeaveRoom) == true) goto L8;
            return false;
        L8:
            ReceiveServerLeaveRoom r101 = (ReceiveServerLeaveRoom) r100;
            if (Intrinsics.areEqual(this.errorType, r101.errorType) == true) goto L12;
            return false;
        L12:
            if (this.errorCode == r101.errorCode) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.errorType.hashCode() * 31) + this.errorCode;
        }

        public String toString() {
            return "ReceiveServerLeaveRoom(errorType=" + this.errorType + ", errorCode=" + this.errorCode + ')';
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorType() {
            return this.errorType;
        }

        public ReceiveServerLeaveRoom(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "errorType");
            super(null);
            this.errorType = r100;
            this.errorCode = r101;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$ReceiveUserAsrEnd;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "msg", "Lcom/larus/livetutor/api/idl/UserAsrEndMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/UserAsrEndMsg;)V", "getMsg", "()Lcom/larus/livetutor/api/idl/UserAsrEndMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReceiveUserAsrEnd extends RTCAction {
        private final UserAsrEndMsg msg;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveUserAsrEnd() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ReceiveUserAsrEnd copy$default(ReceiveUserAsrEnd r100, UserAsrEndMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.msg;
        L6:
            return r100.copy(r101);
        }

        public final UserAsrEndMsg component1() {
            return this.msg;
        }

        public final ReceiveUserAsrEnd copy(UserAsrEndMsg r100) {
            return new ReceiveUserAsrEnd(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ReceiveUserAsrEnd) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.msg, ((ReceiveUserAsrEnd) r100).msg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            UserAsrEndMsg r100 = this.msg;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "ReceiveUserAsrEnd(msg=" + this.msg + ')';
        }

        public final UserAsrEndMsg getMsg() {
            return this.msg;
        }

        public ReceiveUserAsrEnd(UserAsrEndMsg r100) {
            super(null);
            this.msg = r100;
        }

        public /* synthetic */ ReceiveUserAsrEnd(UserAsrEndMsg r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$Replay;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Replay extends RTCAction {
        public static final Replay INSTANCE = null;

        static {
            INSTANCE = new Replay();
        }

        private Replay() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$RoundEnd;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "msg", "Lcom/larus/livetutor/api/idl/LiveTutorRoundEndMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/LiveTutorRoundEndMsg;)V", "getMsg", "()Lcom/larus/livetutor/api/idl/LiveTutorRoundEndMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RoundEnd extends RTCAction {
        private final LiveTutorRoundEndMsg msg;

        public static /* synthetic */ RoundEnd copy$default(RoundEnd r100, LiveTutorRoundEndMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.msg;
        L6:
            return r100.copy(r101);
        }

        public final LiveTutorRoundEndMsg component1() {
            return this.msg;
        }

        public final RoundEnd copy(LiveTutorRoundEndMsg r100) {
            return new RoundEnd(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RoundEnd) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.msg, ((RoundEnd) r100).msg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            LiveTutorRoundEndMsg r100 = this.msg;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "RoundEnd(msg=" + this.msg + ')';
        }

        public final LiveTutorRoundEndMsg getMsg() {
            return this.msg;
        }

        public RoundEnd(LiveTutorRoundEndMsg r100) {
            super(null);
            this.msg = r100;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$StartConnect;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StartConnect extends RTCAction {
        public static final StartConnect INSTANCE = null;

        static {
            INSTANCE = new StartConnect();
        }

        private StartConnect() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$SubmitAsr;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", ST.UUID_DEVICE, "", "<init>", "(Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SubmitAsr extends RTCAction {
        private final String uuid;

        public static /* synthetic */ SubmitAsr copy$default(SubmitAsr r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.uuid;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.uuid;
        }

        public final SubmitAsr copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
            return new SubmitAsr(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SubmitAsr) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.uuid, ((SubmitAsr) r100).uuid) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.uuid.hashCode();
        }

        public String toString() {
            return "SubmitAsr(uuid=" + this.uuid + ')';
        }

        public final String getUuid() {
            return this.uuid;
        }

        public SubmitAsr(String r100) {
            Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
            super(null);
            this.uuid = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$UploadData;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "uploadDataMsg", "Lcom/larus/livetutor/api/idl/UploadDataMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/UploadDataMsg;)V", "getUploadDataMsg", "()Lcom/larus/livetutor/api/idl/UploadDataMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UploadData extends RTCAction {
        private final UploadDataMsg uploadDataMsg;

        public static /* synthetic */ UploadData copy$default(UploadData r100, UploadDataMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.uploadDataMsg;
        L6:
            return r100.copy(r101);
        }

        public final UploadDataMsg component1() {
            return this.uploadDataMsg;
        }

        public final UploadData copy(UploadDataMsg r100) {
            Intrinsics.checkNotNullParameter(r100, "uploadDataMsg");
            return new UploadData(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof UploadData) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.uploadDataMsg, ((UploadData) r100).uploadDataMsg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.uploadDataMsg.hashCode();
        }

        public String toString() {
            return "UploadData(uploadDataMsg=" + this.uploadDataMsg + ')';
        }

        public final UploadDataMsg getUploadDataMsg() {
            return this.uploadDataMsg;
        }

        public UploadData(UploadDataMsg r100) {
            Intrinsics.checkNotNullParameter(r100, "uploadDataMsg");
            super(null);
            this.uploadDataMsg = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$UserAsrStart;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "msg", "Lcom/larus/livetutor/api/idl/UserAsrStartMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/UserAsrStartMsg;)V", "getMsg", "()Lcom/larus/livetutor/api/idl/UserAsrStartMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserAsrStart extends RTCAction {
        private final UserAsrStartMsg msg;

        /* JADX WARN: Multi-variable type inference failed */
        public UserAsrStart() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ UserAsrStart copy$default(UserAsrStart r100, UserAsrStartMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.msg;
        L6:
            return r100.copy(r101);
        }

        public final UserAsrStartMsg component1() {
            return this.msg;
        }

        public final UserAsrStart copy(UserAsrStartMsg r100) {
            return new UserAsrStart(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof UserAsrStart) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.msg, ((UserAsrStart) r100).msg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            UserAsrStartMsg r100 = this.msg;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "UserAsrStart(msg=" + this.msg + ')';
        }

        public final UserAsrStartMsg getMsg() {
            return this.msg;
        }

        public UserAsrStart(UserAsrStartMsg r100) {
            super(null);
            this.msg = r100;
        }

        public /* synthetic */ UserAsrStart(UserAsrStartMsg r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$UserExit;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserExit extends RTCAction {
        public static final UserExit INSTANCE = null;

        static {
            INSTANCE = new UserExit();
        }

        private UserExit() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$UserInterrupt;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserInterrupt extends RTCAction {
        public static final UserInterrupt INSTANCE = null;

        static {
            INSTANCE = new UserInterrupt();
        }

        private UserInterrupt() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCAction$WaitUserAnswer;", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "msg", "Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;)V", "getMsg", "()Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WaitUserAnswer extends RTCAction {
        private final WaitUserAnswerMsg msg;

        public static /* synthetic */ WaitUserAnswer copy$default(WaitUserAnswer r100, WaitUserAnswerMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.msg;
        L6:
            return r100.copy(r101);
        }

        public final WaitUserAnswerMsg component1() {
            return this.msg;
        }

        public final WaitUserAnswer copy(WaitUserAnswerMsg r100) {
            return new WaitUserAnswer(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof WaitUserAnswer) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.msg, ((WaitUserAnswer) r100).msg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            WaitUserAnswerMsg r100 = this.msg;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "WaitUserAnswer(msg=" + this.msg + ')';
        }

        public final WaitUserAnswerMsg getMsg() {
            return this.msg;
        }

        public WaitUserAnswer(WaitUserAnswerMsg r100) {
            super(null);
            this.msg = r100;
        }
    }

    private RTCAction() {
    }

    public /* synthetic */ RTCAction(DefaultConstructorMarker r100) {
        this();
    }
}
