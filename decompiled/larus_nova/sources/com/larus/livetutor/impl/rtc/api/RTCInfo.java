package com.larus.livetutor.impl.rtc.api;

import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JL\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006$"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCInfo;", "", "rtcAppId", "", "roomID", "botID", "rtcCallId", "", "tutorId", b.C, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;)V", "getRtcAppId", "()Ljava/lang/String;", "getRoomID", "getBotID", "getRtcCallId", "()J", "getTutorId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSdkVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;)Lcom/larus/livetutor/impl/rtc/api/RTCInfo;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RTCInfo {
    private final String botID;
    private final String roomID;
    private final String rtcAppId;
    private final long rtcCallId;
    private final String sdkVersion;
    private final Long tutorId;

    public static /* synthetic */ RTCInfo copy$default(RTCInfo r100, String r101, String r102, String r103, long r104, Long r110, String r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.rtcAppId;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.roomID;
    L8:
        String r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.botID;
    L11:
        String r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r104 = r100.rtcCallId;
    L14:
        long r106 = r104;
        if ((r112 & 16) == 0) goto L17;
        r110 = r100.tutorId;
    L17:
        Long r107 = r110;
        if ((r112 & 32) == 0) goto L20;
        r111 = r100.sdkVersion;
    L20:
        String r108 = r101;
        return r100.copy(r108, r114, r105, r106, r107, r111);
    }

    public final String component1() {
        return this.rtcAppId;
    }

    public final String component2() {
        return this.roomID;
    }

    public final String component3() {
        return this.botID;
    }

    public final long component4() {
        return this.rtcCallId;
    }

    public final Long component5() {
        return this.tutorId;
    }

    public final String component6() {
        return this.sdkVersion;
    }

    public final RTCInfo copy(String r110, String r111, String r112, long r113, Long r114, String r115) {
        Intrinsics.checkNotNullParameter(r110, "rtcAppId");
        Intrinsics.checkNotNullParameter(r111, "roomID");
        Intrinsics.checkNotNullParameter(r112, "botID");
        Intrinsics.checkNotNullParameter(r115, b.C);
        return new RTCInfo(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RTCInfo) == true) goto L8;
        return false;
    L8:
        RTCInfo r101 = (RTCInfo) r100;
        if (Intrinsics.areEqual(this.rtcAppId, r101.rtcAppId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomID, r101.roomID) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botID, r101.botID) == true) goto L18;
        return false;
    L18:
        if (this.rtcCallId == r101.rtcCallId) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tutorId, r101.tutorId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sdkVersion, r101.sdkVersion) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.rtcAppId.hashCode() * 31) + this.roomID.hashCode()) * 31) + this.botID.hashCode()) * 31;
        long r101 = this.rtcCallId;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Long r103 = this.tutorId;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.sdkVersion.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public String toString() {
        return "RTCInfo(rtcAppId=" + this.rtcAppId + ", roomID=" + this.roomID + ", botID=" + this.botID + ", rtcCallId=" + this.rtcCallId + ", tutorId=" + this.tutorId + ", sdkVersion=" + this.sdkVersion + ')';
    }

    public final String getBotID() {
        return this.botID;
    }

    public final String getRoomID() {
        return this.roomID;
    }

    public final String getRtcAppId() {
        return this.rtcAppId;
    }

    public final long getRtcCallId() {
        return this.rtcCallId;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final Long getTutorId() {
        return this.tutorId;
    }

    public RTCInfo(String r100, String r101, String r102, long r103, Long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "rtcAppId");
        Intrinsics.checkNotNullParameter(r101, "roomID");
        Intrinsics.checkNotNullParameter(r102, "botID");
        Intrinsics.checkNotNullParameter(r105, b.C);
        this.rtcAppId = r100;
        this.roomID = r101;
        this.botID = r102;
        this.rtcCallId = r103;
        this.tutorId = r104;
        this.sdkVersion = r105;
    }
}
