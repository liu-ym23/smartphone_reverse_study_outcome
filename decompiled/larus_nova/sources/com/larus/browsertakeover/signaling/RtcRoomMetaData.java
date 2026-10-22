package com.larus.browsertakeover.signaling;

import com.google.gson.annotations.SerializedName;
import com.larus.im.internal.jni.bean.RoomMeta;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/larus/browsertakeover/signaling/RtcRoomMetaData;", "", "appId", "", "roomId", "userId", "token", "expireTimeMs", "", "sessionId", "useTestDomain", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Z)V", "getAppId", "()Ljava/lang/String;", "getRoomId", "getUserId", "getToken", "getExpireTimeMs", "()J", "getSessionId", "getUseTestDomain", "()Z", "toRoomMeta", "Lcom/larus/im/internal/jni/bean/RoomMeta;", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RtcRoomMetaData {

    @SerializedName("rtc_app_id")
    private final String appId;

    @SerializedName("expire_time_ms")
    private final long expireTimeMs;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("session_id")
    private final String sessionId;

    @SerializedName("token")
    private final String token;

    @SerializedName("use_rtc_test_domain")
    private final boolean useTestDomain;

    @SerializedName("rtc_user_id")
    private final String userId;

    public RtcRoomMetaData() {
        this(null, null, null, null, 0, null, false, 127, null);
    }

    public String toString() {
        return "RtcRoomMetaData(redacted)";
    }

    public final RoomMeta toRoomMeta() {
        return new RoomMeta(this.appId, this.roomId, this.userId, this.token, this.expireTimeMs, this.sessionId, this.useTestDomain, null, 128, null);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final long getExpireTimeMs() {
        return this.expireTimeMs;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getToken() {
        return this.token;
    }

    public final boolean getUseTestDomain() {
        return this.useTestDomain;
    }

    public final String getUserId() {
        return this.userId;
    }

    public RtcRoomMetaData(String r100, String r101, String r102, String r103, long r104, String r105, boolean r106) {
        this.appId = r100;
        this.roomId = r101;
        this.userId = r102;
        this.token = r103;
        this.expireTimeMs = r104;
        this.sessionId = r105;
        this.useTestDomain = r106;
    }

    public /* synthetic */ RtcRoomMetaData(String r100, String r110, String r111, String r112, long r113, String r114, boolean r115, int r116, DefaultConstructorMarker r117) {
        String r101 = null;
        if ((r116 & 1) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r116 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r116 & 16) == 0) goto L21;
        long r106 = 0;
    L23:
        if ((r116 & 32) != 0) goto L27;
        r101 = r114;
    L27:
        if ((r116 & 64) == 0) goto L29;
        boolean r107 = false;
    L30:
        this(r102, r103, r104, r105, r106, r101, r107);
        return;
    L29:
        r107 = r115;
        goto L30
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
