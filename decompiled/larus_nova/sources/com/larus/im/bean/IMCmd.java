package com.larus.im.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tc9.e;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0001DB\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0092\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0005HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R,\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010!R\"\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006E"}, d2 = {"Lcom/larus/im/bean/IMCmd;", "", "localMessageId", "", "cmdType", "", "upCmdType", "cmdIndex", "", "conversationId", "messageId", "ext", "", "createTime", UserInfo.UPDATE_TIME, "inAppBannerNotify", "Lcom/larus/im/bean/InAppBannerNotify;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/im/bean/InAppBannerNotify;)V", "getLocalMessageId", "()Ljava/lang/String;", "setLocalMessageId", "(Ljava/lang/String;)V", "getCmdType", "()Ljava/lang/Integer;", "setCmdType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUpCmdType", "setUpCmdType", "getCmdIndex", "()Ljava/lang/Long;", "setCmdIndex", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getConversationId", "setConversationId", "getMessageId", "setMessageId", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getCreateTime", "setCreateTime", "getUpdateTime", "setUpdateTime", "getInAppBannerNotify", "()Lcom/larus/im/bean/InAppBannerNotify;", "setInAppBannerNotify", "(Lcom/larus/im/bean/InAppBannerNotify;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/im/bean/InAppBannerNotify;)Lcom/larus/im/bean/IMCmd;", "equals", "", "other", "hashCode", "toString", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMCmd {
    public static final int CMD_TYPE_ACCOUNT_BANNED = 31;
    public static final int CMD_TYPE_ACCOUNT_LIFT_BANNED = 32;
    public static final int CMD_TYPE_ACTION_BAR_CHANGE = 10000;
    public static final int CMD_TYPE_APP_FRAMEWORK_SIDEBAR_REFRESH_PUSH = 92001;
    public static final int CMD_TYPE_APP_FRAMEWORK_TASK_CENTER_TASK_RUNTIME_CHANGE_NOTIFY = 91001;
    public static final int CMD_TYPE_APP_FRAMEWORK_TASK_CENTER_TASK_RUNTIME_CHANGE_PUSH = 91002;
    public static final int CMD_TYPE_AUDIO_TTS_SUBSCRIPTION = 91;
    public static final int CMD_TYPE_AUTO_ADD_CREATION = 10001;
    public static final int CMD_TYPE_CONVERSATION_ADD = 12;
    public static final int CMD_TYPE_CONVERSATION_CHANGED = 15;
    public static final int CMD_TYPE_CONVERSATION_DELETE = 11;
    public static final int CMD_TYPE_CONVERSATION_READ = 16;
    public static final int CMD_TYPE_CREATE_SECTION = 13;
    public static final int CMD_TYPE_IN_APP_NOTIFICATION = 80004;
    public static final int CMD_TYPE_MSG_DELETE = 1;
    public static final int CMD_TYPE_MSG_DISLIKE = 3;
    public static final int CMD_TYPE_MSG_LIKE = 2;
    public static final int CMD_TYPE_MSG_NOT_COMPLIANT = 5;
    public static final int CMD_TYPE_NEW_UNREAD_NOTIFICATION_TAB = 92;
    public static final int CMD_TYPE_ONBOARDING_BEGIN = 21;
    public static final int CMD_TYPE_ONBOARDING_CANCEL = 23;
    public static final int CMD_TYPE_ONBOARDING_FAIL = 22;
    public static final int CMD_TYPE_ONBOARDING_NEED_START = 26;
    public static final int CMD_TYPE_REPORT_LOCATION = 51;
    public static final int CMD_TYPE_RISK_TOAST = 60;
    public static final int CMD_TYPE_USER_CONFIG_UPDATE = 41;
    public static final int CMD_TYPE_USER_MUTE = 101;
    public static final int CMD_TYPE_USER_MUTE_RELEASE = 102;
    public static final a Companion = null;
    public static final int UP_CMD_CVS_IN = 1;
    public static final int UP_CMD_CVS_OUT = 2;

    @SerializedName("index")
    private Long cmdIndex;

    @SerializedName("cmd_type")
    private Integer cmdType;

    @SerializedName("conversation_id")
    private String conversationId;

    @SerializedName("create_time")
    private Long createTime;

    @SerializedName("ext")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private Map<String, String> ext;

    @SerializedName("in_app_banner_notify")
    private e inAppBannerNotify;

    @SerializedName("local_message_id")
    private String localMessageId;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private String messageId;

    @SerializedName("up_cmd_type")
    private Integer upCmdType;

    @SerializedName("update_time")
    private Long updateTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public IMCmd() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMCmd copy$default(IMCmd r110, String r111, Integer r112, Integer r113, Long r114, String r115, String r116, Map r117, Long r118, Long r210, e r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.localMessageId;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Integer r101 = r110.cmdType;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Integer r102 = r110.upCmdType;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Long r103 = r110.cmdIndex;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.conversationId;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.messageId;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Map r106 = r110.ext;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Long r107 = r110.createTime;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Long r119 = r110.updateTime;
    L39:
        if ((r212 & 512) == 0) goto L41;
        e r108 = r110.inAppBannerNotify;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
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
        return this.localMessageId;
    }

    public final e component10() {
        return this.inAppBannerNotify;
    }

    public final Integer component2() {
        return this.cmdType;
    }

    public final Integer component3() {
        return this.upCmdType;
    }

    public final Long component4() {
        return this.cmdIndex;
    }

    public final String component5() {
        return this.conversationId;
    }

    public final String component6() {
        return this.messageId;
    }

    public final Map<String, String> component7() {
        return this.ext;
    }

    public final Long component8() {
        return this.createTime;
    }

    public final Long component9() {
        return this.updateTime;
    }

    public final IMCmd copy(String r110, Integer r111, Integer r112, Long r113, String r114, String r115, Map<String, String> r116, Long r210, Long r211, e r212) {
        return new IMCmd(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IMCmd) == true) goto L8;
        return false;
    L8:
        IMCmd r101 = (IMCmd) r100;
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cmdType, r101.cmdType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.upCmdType, r101.upCmdType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cmdIndex, r101.cmdIndex) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.inAppBannerNotify, r101.inAppBannerNotify) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.localMessageId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.cmdType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.upCmdType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.cmdIndex;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.conversationId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.messageId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, String> r119 = this.ext;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.createTime;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.updateTime;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        e r128 = this.inAppBannerNotify;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
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
        return "IMCmd(localMessageId=" + this.localMessageId + ", cmdType=" + this.cmdType + ", upCmdType=" + this.upCmdType + ", cmdIndex=" + this.cmdIndex + ", conversationId=" + this.conversationId + ", messageId=" + this.messageId + ", ext=" + this.ext + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", inAppBannerNotify=" + this.inAppBannerNotify + ')';
    }

    public final Long getCmdIndex() {
        return this.cmdIndex;
    }

    public final Integer getCmdType() {
        return this.cmdType;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final e getInAppBannerNotify() {
        return this.inAppBannerNotify;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final Integer getUpCmdType() {
        return this.upCmdType;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final void setCmdIndex(Long r100) {
        this.cmdIndex = r100;
    }

    public final void setCmdType(Integer r100) {
        this.cmdType = r100;
    }

    public final void setConversationId(String r100) {
        this.conversationId = r100;
    }

    public final void setCreateTime(Long r100) {
        this.createTime = r100;
    }

    public final void setExt(Map<String, String> r100) {
        this.ext = r100;
    }

    public final void setInAppBannerNotify(e r100) {
        this.inAppBannerNotify = r100;
    }

    public final void setLocalMessageId(String r100) {
        this.localMessageId = r100;
    }

    public final void setMessageId(String r100) {
        this.messageId = r100;
    }

    public final void setUpCmdType(Integer r100) {
        this.upCmdType = r100;
    }

    public final void setUpdateTime(Long r100) {
        this.updateTime = r100;
    }

    public IMCmd(String r100, Integer r101, Integer r102, Long r103, String r104, String r105, Map<String, String> r106, Long r107, Long r108, e r110) {
        this.localMessageId = r100;
        this.cmdType = r101;
        this.upCmdType = r102;
        this.cmdIndex = r103;
        this.conversationId = r104;
        this.messageId = r105;
        this.ext = r106;
        this.createTime = r107;
        this.updateTime = r108;
        this.inAppBannerNotify = r110;
    }

    public /* synthetic */ IMCmd(String r110, Integer r111, Integer r112, Long r113, String r114, String r115, Map r210, Long r211, Long r212, e r213, int r214, DefaultConstructorMarker r215) {
        e r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Integer r102 = 0;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r103 = 0;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Long r104 = 0L;
    L18:
        String r105 = "";
        if ((r214 & 16) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r214 & 32) != 0) goto L27;
        r105 = r115;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Map r116 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Long r117 = 0L;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Long r107 = 0L;
    L39:
        if ((r214 & 512) != 0) goto L42;
        r100 = r213;
    L42:
        this(r101, r102, r103, r104, r106, r105, r116, r117, r107, r100);
        return;
    L37:
        r107 = r212;
        goto L39
    L33:
        r117 = r211;
        goto L35
    L29:
        r116 = r210;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
