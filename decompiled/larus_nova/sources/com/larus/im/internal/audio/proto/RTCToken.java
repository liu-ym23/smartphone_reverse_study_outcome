package com.larus.im.internal.audio.proto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J^\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015¨\u0006("}, d2 = {"Lcom/larus/im/internal/audio/proto/RTCToken;", "Ljava/io/Serializable;", "appId", "", "roomId", "token", "expireDuration", "", "roomIsPreCreated", "", "localStartTime", "localUseTestDomain", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Boolean;JLjava/lang/Boolean;)V", "getAppId", "()Ljava/lang/String;", "getRoomId", "getToken", "getExpireDuration", "()J", "getRoomIsPreCreated", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocalStartTime", "getLocalUseTestDomain", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Boolean;JLjava/lang/Boolean;)Lcom/larus/im/internal/audio/proto/RTCToken;", "equals", "other", "", "hashCode", "", "toString", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RTCToken implements Serializable {

    @SerializedName("app_id")
    private final String appId;

    @SerializedName("expire_duration")
    private final long expireDuration;

    @SerializedName("local_start_time")
    private final long localStartTime;

    @SerializedName("local_use_test")
    private final Boolean localUseTestDomain;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("room_is_pre_created")
    private final Boolean roomIsPreCreated;

    @SerializedName("token")
    private final String token;

    public RTCToken() {
        this(null, null, null, 0, null, 0, null, 127, null);
    }

    public static /* synthetic */ RTCToken copy$default(RTCToken r110, String r111, String r112, String r113, long r114, Boolean r115, long r116, Boolean r117, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.appId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.roomId;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.token;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r103 = r110.expireDuration;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Boolean r104 = r110.roomIsPreCreated;
    L23:
        if ((r210 & 32) == 0) goto L25;
        long r105 = r110.localStartTime;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Boolean r106 = r110.localUseTestDomain;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106);
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.roomId;
    }

    public final String component3() {
        return this.token;
    }

    public final long component4() {
        return this.expireDuration;
    }

    public final Boolean component5() {
        return this.roomIsPreCreated;
    }

    public final long component6() {
        return this.localStartTime;
    }

    public final Boolean component7() {
        return this.localUseTestDomain;
    }

    public final RTCToken copy(String r110, String r111, String r112, long r113, Boolean r114, long r115, Boolean r210) {
        return new RTCToken(r110, r111, r112, r113, r114, r115, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RTCToken) == true) goto L8;
        return false;
    L8:
        RTCToken r101 = (RTCToken) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L18;
        return false;
    L18:
        if (this.expireDuration == r101.expireDuration) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.roomIsPreCreated, r101.roomIsPreCreated) == true) goto L24;
        return false;
    L24:
        if (this.localStartTime == r101.localStartTime) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.localUseTestDomain, r101.localUseTestDomain) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.appId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.roomId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.token;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.expireDuration;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        Boolean r112 = this.roomIsPreCreated;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        long r115 = this.localStartTime;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        Boolean r117 = this.localUseTestDomain;
        if (r117 == null) goto L23;
        r101 = r117.hashCode();
    L23:
        return r116 + r101;
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RTCToken(appId=" + this.appId + ", roomId=" + this.roomId + ", token=" + this.token + ", expireDuration=" + this.expireDuration + ", roomIsPreCreated=" + this.roomIsPreCreated + ", localStartTime=" + this.localStartTime + ", localUseTestDomain=" + this.localUseTestDomain + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final long getExpireDuration() {
        return this.expireDuration;
    }

    public final long getLocalStartTime() {
        return this.localStartTime;
    }

    public final Boolean getLocalUseTestDomain() {
        return this.localUseTestDomain;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Boolean getRoomIsPreCreated() {
        return this.roomIsPreCreated;
    }

    public final String getToken() {
        return this.token;
    }

    public RTCToken(String r100, String r101, String r102, long r103, Boolean r104, long r105, Boolean r106) {
        this.appId = r100;
        this.roomId = r101;
        this.token = r102;
        this.expireDuration = r103;
        this.roomIsPreCreated = r104;
        this.localStartTime = r105;
        this.localUseTestDomain = r106;
    }

    public /* synthetic */ RTCToken(String r110, String r111, String r112, long r113, Boolean r114, long r115, Boolean r116, int r210, DefaultConstructorMarker r211) {
        Boolean r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L14:
        long r104 = -1;
        if ((r210 & 8) == 0) goto L17;
        long r105 = -1;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Boolean r106 = null;
    L23:
        if ((r210 & 32) != 0) goto L27;
        r104 = r115;
    L27:
        if ((r210 & 64) != 0) goto L30;
        r100 = r116;
    L30:
        this(r101, r102, r103, r105, r106, r104, r100);
        return;
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
