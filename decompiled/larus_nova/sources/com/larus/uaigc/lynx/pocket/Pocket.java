package com.larus.uaigc.lynx.pocket;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00108\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010>\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÎ\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\bHÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b+\u0010!R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b,\u0010!R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001c¨\u0006J"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/Pocket;", "", "pocketId", "", "configName", "iconUrl", EventConstant.Key.RETAIN_PROMPT, "pocketType", "", "sendMsgPocket", "Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;", "keyboardInputPocket", "Lcom/larus/uaigc/lynx/pocket/KeyboardInputPocket;", "uploadInputPocket", "Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;", "jumpSomewherePocket", "Lcom/larus/uaigc/lynx/pocket/JumpSomewherePocket;", "intentionType", "status", "supportedOSAndVersion", "Lcom/larus/uaigc/lynx/pocket/SupportedOSAndVersion;", "ext", "promptForModel", OnekeyLoginConstants.CU_KEY_OPERATOR, UserInfo.UPDATE_TIME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;Lcom/larus/uaigc/lynx/pocket/KeyboardInputPocket;Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;Lcom/larus/uaigc/lynx/pocket/JumpSomewherePocket;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/uaigc/lynx/pocket/SupportedOSAndVersion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPocketId", "()Ljava/lang/String;", "getConfigName", "getIconUrl", "getPrompt", "getPocketType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSendMsgPocket", "()Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;", "getKeyboardInputPocket", "()Lcom/larus/uaigc/lynx/pocket/KeyboardInputPocket;", "getUploadInputPocket", "()Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;", "getJumpSomewherePocket", "()Lcom/larus/uaigc/lynx/pocket/JumpSomewherePocket;", "getIntentionType", "getStatus", "getSupportedOSAndVersion", "()Lcom/larus/uaigc/lynx/pocket/SupportedOSAndVersion;", "getExt", "getPromptForModel", "getOperator", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;Lcom/larus/uaigc/lynx/pocket/KeyboardInputPocket;Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;Lcom/larus/uaigc/lynx/pocket/JumpSomewherePocket;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/uaigc/lynx/pocket/SupportedOSAndVersion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/uaigc/lynx/pocket/Pocket;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Pocket {

    @SerializedName("config_name")
    private final String configName;

    @SerializedName("ext")
    private final String ext;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("intention_type")
    private final Integer intentionType;

    @SerializedName("jump_somewhere_pocket")
    private final JumpSomewherePocket jumpSomewherePocket;

    @SerializedName("keyboard_input_pocket")
    private final KeyboardInputPocket keyboardInputPocket;

    @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
    private final String operator;

    @SerializedName("pocket_id")
    private final String pocketId;

    @SerializedName("pocket_type")
    private final Integer pocketType;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private final String prompt;

    @SerializedName("prompt_for_model")
    private final String promptForModel;

    @SerializedName("send_msg_pocket")
    private final SendMsgPocket sendMsgPocket;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("supported_systems_and_versions")
    private final SupportedOSAndVersion supportedOSAndVersion;

    @SerializedName("update_time")
    private final String updateTime;

    @SerializedName("upload_input_pocket")
    private final UploadInputPocket uploadInputPocket;

    public Pocket() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public static /* synthetic */ Pocket copy$default(Pocket r110, String r111, String r112, String r210, String r211, Integer r212, SendMsgPocket r213, KeyboardInputPocket r214, UploadInputPocket r215, JumpSomewherePocket r216, Integer r217, Integer r218, SupportedOSAndVersion r219, String r310, String r311, String r312, String r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.pocketId;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.configName;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = r110.iconUrl;
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r103 = r110.prompt;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Integer r104 = r110.pocketType;
    L23:
        if ((r314 & 32) == 0) goto L25;
        SendMsgPocket r105 = r110.sendMsgPocket;
    L27:
        if ((r314 & 64) == 0) goto L29;
        KeyboardInputPocket r106 = r110.keyboardInputPocket;
    L31:
        if ((r314 & 128) == 0) goto L33;
        UploadInputPocket r107 = r110.uploadInputPocket;
    L35:
        if ((r314 & 256) == 0) goto L37;
        JumpSomewherePocket r113 = r110.jumpSomewherePocket;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Integer r114 = r110.intentionType;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        Integer r115 = r110.status;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        SupportedOSAndVersion r116 = r110.supportedOSAndVersion;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r117 = r110.ext;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        String r118 = r110.promptForModel;
    L58:
        String r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        String r119 = r110.operator;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r108 = r110.updateTime;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.pocketId;
    }

    public final Integer component10() {
        return this.intentionType;
    }

    public final Integer component11() {
        return this.status;
    }

    public final SupportedOSAndVersion component12() {
        return this.supportedOSAndVersion;
    }

    public final String component13() {
        return this.ext;
    }

    public final String component14() {
        return this.promptForModel;
    }

    public final String component15() {
        return this.operator;
    }

    public final String component16() {
        return this.updateTime;
    }

    public final String component2() {
        return this.configName;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final String component4() {
        return this.prompt;
    }

    public final Integer component5() {
        return this.pocketType;
    }

    public final SendMsgPocket component6() {
        return this.sendMsgPocket;
    }

    public final KeyboardInputPocket component7() {
        return this.keyboardInputPocket;
    }

    public final UploadInputPocket component8() {
        return this.uploadInputPocket;
    }

    public final JumpSomewherePocket component9() {
        return this.jumpSomewherePocket;
    }

    public final Pocket copy(String r110, String r210, String r211, String r212, Integer r213, SendMsgPocket r214, KeyboardInputPocket r215, UploadInputPocket r216, JumpSomewherePocket r217, Integer r218, Integer r219, SupportedOSAndVersion r310, String r311, String r312, String r313, String r314) {
        return new Pocket(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Pocket) == true) goto L8;
        return false;
    L8:
        Pocket r101 = (Pocket) r100;
        if (Intrinsics.areEqual(this.pocketId, r101.pocketId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.configName, r101.configName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prompt, r101.prompt) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pocketType, r101.pocketType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sendMsgPocket, r101.sendMsgPocket) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.keyboardInputPocket, r101.keyboardInputPocket) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.uploadInputPocket, r101.uploadInputPocket) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.jumpSomewherePocket, r101.jumpSomewherePocket) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.intentionType, r101.intentionType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.supportedOSAndVersion, r101.supportedOSAndVersion) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.promptForModel, r101.promptForModel) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.operator, r101.operator) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r100 = this.pocketId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.configName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.iconUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.prompt;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.pocketType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        SendMsgPocket r116 = this.sendMsgPocket;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        KeyboardInputPocket r119 = this.keyboardInputPocket;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        UploadInputPocket r122 = this.uploadInputPocket;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        JumpSomewherePocket r125 = this.jumpSomewherePocket;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.intentionType;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.status;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        SupportedOSAndVersion r134 = this.supportedOSAndVersion;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.ext;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.promptForModel;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.operator;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.updateTime;
        if (r146 == null) goto L67;
        r101 = r146.hashCode();
    L67:
        return r145 + r101;
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
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
        return "Pocket(pocketId=" + this.pocketId + ", configName=" + this.configName + ", iconUrl=" + this.iconUrl + ", prompt=" + this.prompt + ", pocketType=" + this.pocketType + ", sendMsgPocket=" + this.sendMsgPocket + ", keyboardInputPocket=" + this.keyboardInputPocket + ", uploadInputPocket=" + this.uploadInputPocket + ", jumpSomewherePocket=" + this.jumpSomewherePocket + ", intentionType=" + this.intentionType + ", status=" + this.status + ", supportedOSAndVersion=" + this.supportedOSAndVersion + ", ext=" + this.ext + ", promptForModel=" + this.promptForModel + ", operator=" + this.operator + ", updateTime=" + this.updateTime + ')';
    }

    public final String getConfigName() {
        return this.configName;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final Integer getIntentionType() {
        return this.intentionType;
    }

    public final JumpSomewherePocket getJumpSomewherePocket() {
        return this.jumpSomewherePocket;
    }

    public final KeyboardInputPocket getKeyboardInputPocket() {
        return this.keyboardInputPocket;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final String getPocketId() {
        return this.pocketId;
    }

    public final Integer getPocketType() {
        return this.pocketType;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getPromptForModel() {
        return this.promptForModel;
    }

    public final SendMsgPocket getSendMsgPocket() {
        return this.sendMsgPocket;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final SupportedOSAndVersion getSupportedOSAndVersion() {
        return this.supportedOSAndVersion;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final UploadInputPocket getUploadInputPocket() {
        return this.uploadInputPocket;
    }

    public Pocket(String r100, String r101, String r102, String r103, Integer r104, SendMsgPocket r105, KeyboardInputPocket r106, UploadInputPocket r110, JumpSomewherePocket r111, Integer r112, Integer r113, SupportedOSAndVersion r114, String r115, String r116, String r117, String r118) {
        this.pocketId = r100;
        this.configName = r101;
        this.iconUrl = r102;
        this.prompt = r103;
        this.pocketType = r104;
        this.sendMsgPocket = r105;
        this.keyboardInputPocket = r106;
        this.uploadInputPocket = r110;
        this.jumpSomewherePocket = r111;
        this.intentionType = r112;
        this.status = r113;
        this.supportedOSAndVersion = r114;
        this.ext = r115;
        this.promptForModel = r116;
        this.operator = r117;
        this.updateTime = r118;
    }

    public /* synthetic */ Pocket(String r110, String r111, String r210, String r211, Integer r212, SendMsgPocket r213, KeyboardInputPocket r214, UploadInputPocket r215, JumpSomewherePocket r216, Integer r217, Integer r218, SupportedOSAndVersion r219, String r310, String r311, String r312, String r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        SendMsgPocket r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        KeyboardInputPocket r106 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        UploadInputPocket r107 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        JumpSomewherePocket r112 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Integer r113 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        Integer r114 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        SupportedOSAndVersion r115 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r116 = null;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        String r117 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r109 = null;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r117, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
