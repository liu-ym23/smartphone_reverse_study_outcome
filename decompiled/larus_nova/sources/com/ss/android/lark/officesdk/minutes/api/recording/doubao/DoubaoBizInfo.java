package com.ss.android.lark.officesdk.minutes.api.recording.doubao;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001c\u001a\u00020\u0000J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Jw\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u00060"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/DoubaoBizInfo;", "Ljava/io/Serializable;", "userId", "", "conversationId", "messageId", "replyMessageId", "bizId", "appId", "tenantId", "deviceId", "recordingId", "doubaoAppVersion", "doubaoRecorderExtra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getConversationId", "getMessageId", "getReplyMessageId", "getBizId", "getAppId", "getTenantId", "getDeviceId", "getRecordingId", "getDoubaoAppVersion", "getDoubaoRecorderExtra", "withHostAppVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoBizInfo implements Serializable {

    @SerializedName("AppID")
    private final String appId;

    @SerializedName("BizID")
    private final String bizId;

    @SerializedName("ConversationID")
    private final String conversationId;

    @SerializedName("DeviceID")
    private final String deviceId;

    @SerializedName("DoubaoAppVersion")
    private final String doubaoAppVersion;

    @SerializedName("DoubaoRecorderExtra")
    private final String doubaoRecorderExtra;

    @SerializedName("MessageID")
    private final String messageId;

    @SerializedName("RecordingIDV2")
    private final String recordingId;

    @SerializedName("ReplyMessageID")
    private final String replyMessageId;

    @SerializedName("TenantID")
    private final String tenantId;

    @SerializedName("UserID")
    private final String userId;

    public static /* synthetic */ DoubaoBizInfo copy$default(DoubaoBizInfo r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, String r211, String r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.userId;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.conversationId;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.messageId;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.replyMessageId;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.bizId;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.appId;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.tenantId;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.deviceId;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.recordingId;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.doubaoAppVersion;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.doubaoRecorderExtra;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
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
        return this.userId;
    }

    public final String component10() {
        return this.doubaoAppVersion;
    }

    public final String component11() {
        return this.doubaoRecorderExtra;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final String component3() {
        return this.messageId;
    }

    public final String component4() {
        return this.replyMessageId;
    }

    public final String component5() {
        return this.bizId;
    }

    public final String component6() {
        return this.appId;
    }

    public final String component7() {
        return this.tenantId;
    }

    public final String component8() {
        return this.deviceId;
    }

    public final String component9() {
        return this.recordingId;
    }

    public final DoubaoBizInfo copy(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        Intrinsics.checkNotNullParameter(r112, "messageId");
        Intrinsics.checkNotNullParameter(r113, "replyMessageId");
        Intrinsics.checkNotNullParameter(r114, "bizId");
        Intrinsics.checkNotNullParameter(r115, "appId");
        Intrinsics.checkNotNullParameter(r210, "tenantId");
        Intrinsics.checkNotNullParameter(r211, "deviceId");
        Intrinsics.checkNotNullParameter(r212, "recordingId");
        Intrinsics.checkNotNullParameter(r213, "doubaoAppVersion");
        Intrinsics.checkNotNullParameter(r214, "doubaoRecorderExtra");
        return new DoubaoBizInfo(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoubaoBizInfo) == true) goto L8;
        return false;
    L8:
        DoubaoBizInfo r101 = (DoubaoBizInfo) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.replyMessageId, r101.replyMessageId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bizId, r101.bizId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tenantId, r101.tenantId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.recordingId, r101.recordingId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.doubaoAppVersion, r101.doubaoAppVersion) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.doubaoRecorderExtra, r101.doubaoRecorderExtra) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((this.userId.hashCode() * 31) + this.conversationId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.replyMessageId.hashCode()) * 31) + this.bizId.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.tenantId.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.recordingId.hashCode()) * 31) + this.doubaoAppVersion.hashCode()) * 31) + this.doubaoRecorderExtra.hashCode();
    }

    public String toString() {
        return "DoubaoBizInfo(userId=" + this.userId + ", conversationId=" + this.conversationId + ", messageId=" + this.messageId + ", replyMessageId=" + this.replyMessageId + ", bizId=" + this.bizId + ", appId=" + this.appId + ", tenantId=" + this.tenantId + ", deviceId=" + this.deviceId + ", recordingId=" + this.recordingId + ", doubaoAppVersion=" + this.doubaoAppVersion + ", doubaoRecorderExtra=" + this.doubaoRecorderExtra + ')';
    }

    public final DoubaoBizInfo withHostAppVersion() {
        String r100 = OfficeSDKManager.getHostAppVersion();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r110 = StringsKt.removePrefix(r100, "doubao:");
        String r101 = this.userId;
        if (r101 != null) goto L8;
        String r102 = "";
    L9:
        String r103 = this.conversationId;
        if (r103 != null) goto L12;
        String r104 = "";
    L13:
        String r105 = this.messageId;
        if (r105 != null) goto L16;
        String r106 = "";
    L17:
        String r107 = this.replyMessageId;
        if (r107 != null) goto L20;
        String r108 = "";
    L21:
        String r109 = this.bizId;
        if (r109 != null) goto L24;
        String r111 = "";
    L25:
        String r112 = this.appId;
        if (r112 != null) goto L28;
        String r113 = "";
    L29:
        String r114 = this.tenantId;
        if (r114 != null) goto L32;
        String r115 = "";
    L33:
        String r116 = this.deviceId;
        if (r116 != null) goto L36;
        String r117 = "";
    L37:
        String r118 = this.recordingId;
        if (r118 != null) goto L40;
        String r119 = "";
    L41:
        String r120 = this.doubaoRecorderExtra;
        if (r120 != null) goto L44;
        String r121 = "";
    L46:
        return new DoubaoBizInfo(r102, r104, r106, r108, r111, r113, r115, r117, r119, r110, r121);
    L44:
        r121 = r120;
        goto L46
    L40:
        r119 = r118;
        goto L41
    L36:
        r117 = r116;
        goto L37
    L32:
        r115 = r114;
        goto L33
    L28:
        r113 = r112;
        goto L29
    L24:
        r111 = r109;
        goto L25
    L20:
        r108 = r107;
        goto L21
    L16:
        r106 = r105;
        goto L17
    L12:
        r104 = r103;
        goto L13
    L8:
        r102 = r101;
        goto L9
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getBizId() {
        return this.bizId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDoubaoAppVersion() {
        return this.doubaoAppVersion;
    }

    public final String getDoubaoRecorderExtra() {
        return this.doubaoRecorderExtra;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getRecordingId() {
        return this.recordingId;
    }

    public final String getReplyMessageId() {
        return this.replyMessageId;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public DoubaoBizInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "messageId");
        Intrinsics.checkNotNullParameter(r103, "replyMessageId");
        Intrinsics.checkNotNullParameter(r104, "bizId");
        Intrinsics.checkNotNullParameter(r105, "appId");
        Intrinsics.checkNotNullParameter(r106, "tenantId");
        Intrinsics.checkNotNullParameter(r107, "deviceId");
        Intrinsics.checkNotNullParameter(r110, "recordingId");
        Intrinsics.checkNotNullParameter(r111, "doubaoAppVersion");
        Intrinsics.checkNotNullParameter(r112, "doubaoRecorderExtra");
        this.userId = r100;
        this.conversationId = r101;
        this.messageId = r102;
        this.replyMessageId = r103;
        this.bizId = r104;
        this.appId = r105;
        this.tenantId = r106;
        this.deviceId = r107;
        this.recordingId = r110;
        this.doubaoAppVersion = r111;
        this.doubaoRecorderExtra = r112;
    }

    public /* synthetic */ DoubaoBizInfo(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, int r217, DefaultConstructorMarker r218) {
        if ((r217 & 256) == 0) goto L5;
        String r114 = "";
    L7:
        if ((r217 & 512) == 0) goto L9;
        String r115 = "";
    L11:
        if ((r217 & 1024) == 0) goto L13;
        String r116 = "";
    L14:
        this(r110, r111, r112, r113, r210, r211, r212, r213, r114, r115, r116);
        return;
    L13:
        r116 = r216;
        goto L14
    L9:
        r115 = r215;
        goto L11
    L5:
        r114 = r214;
        goto L7
    }
}
