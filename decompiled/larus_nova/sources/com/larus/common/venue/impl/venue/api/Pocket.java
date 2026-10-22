package com.larus.common.venue.impl.venue.api;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÚ\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\bHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b-\u0010\"R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b.\u0010\"R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001d¨\u0006M"}, d2 = {"Lcom/larus/common/venue/impl/venue/api/Pocket;", "", "pocketId", "", "configName", "iconUrl", EventConstant.Key.RETAIN_PROMPT, "pocketType", "", "pocketTag", "sendMsgPocket", "Lcom/larus/common/venue/impl/venue/api/SendMsgPocket;", "keyboardInputPocket", "Lcom/larus/common/venue/impl/venue/api/KeyboardInputPocket;", "uploadInputPocket", "Lcom/larus/common/venue/impl/venue/api/UploadInputPocket;", "jumpSomewherePocket", "Lcom/larus/common/venue/impl/venue/api/JumpSomewherePocket;", "intentionType", "status", "supportedOSAndVersion", "Lcom/larus/common/venue/impl/venue/api/SupportedOSAndVersion;", "ext", "promptForModel", OnekeyLoginConstants.CU_KEY_OPERATOR, UserInfo.UPDATE_TIME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/common/venue/impl/venue/api/SendMsgPocket;Lcom/larus/common/venue/impl/venue/api/KeyboardInputPocket;Lcom/larus/common/venue/impl/venue/api/UploadInputPocket;Lcom/larus/common/venue/impl/venue/api/JumpSomewherePocket;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/common/venue/impl/venue/api/SupportedOSAndVersion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPocketId", "()Ljava/lang/String;", "getConfigName", "getIconUrl", "getPrompt", "getPocketType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPocketTag", "getSendMsgPocket", "()Lcom/larus/common/venue/impl/venue/api/SendMsgPocket;", "getKeyboardInputPocket", "()Lcom/larus/common/venue/impl/venue/api/KeyboardInputPocket;", "getUploadInputPocket", "()Lcom/larus/common/venue/impl/venue/api/UploadInputPocket;", "getJumpSomewherePocket", "()Lcom/larus/common/venue/impl/venue/api/JumpSomewherePocket;", "getIntentionType", "getStatus", "getSupportedOSAndVersion", "()Lcom/larus/common/venue/impl/venue/api/SupportedOSAndVersion;", "getExt", "getPromptForModel", "getOperator", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/common/venue/impl/venue/api/SendMsgPocket;Lcom/larus/common/venue/impl/venue/api/KeyboardInputPocket;Lcom/larus/common/venue/impl/venue/api/UploadInputPocket;Lcom/larus/common/venue/impl/venue/api/JumpSomewherePocket;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/common/venue/impl/venue/api/SupportedOSAndVersion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/common/venue/impl/venue/api/Pocket;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Pocket {

    @SerializedName("prompt_for_display")
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

    @SerializedName("pocket_tag")
    private final Integer pocketTag;

    @SerializedName("pocket_type")
    private final Integer pocketType;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private final String prompt;

    @SerializedName("prompt_for_chat")
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
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ Pocket copy$default(Pocket r110, String r111, String r112, String r210, String r211, Integer r212, Integer r213, SendMsgPocket r214, KeyboardInputPocket r215, UploadInputPocket r216, JumpSomewherePocket r217, Integer r218, Integer r219, SupportedOSAndVersion r310, String r311, String r312, String r313, String r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.pocketId;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.configName;
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r102 = r110.iconUrl;
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r103 = r110.prompt;
    L19:
        if ((r315 & 16) == 0) goto L21;
        Integer r104 = r110.pocketType;
    L23:
        if ((r315 & 32) == 0) goto L25;
        Integer r105 = r110.pocketTag;
    L27:
        if ((r315 & 64) == 0) goto L29;
        SendMsgPocket r106 = r110.sendMsgPocket;
    L31:
        if ((r315 & 128) == 0) goto L33;
        KeyboardInputPocket r107 = r110.keyboardInputPocket;
    L35:
        if ((r315 & 256) == 0) goto L37;
        UploadInputPocket r113 = r110.uploadInputPocket;
    L39:
        if ((r315 & 512) == 0) goto L41;
        JumpSomewherePocket r114 = r110.jumpSomewherePocket;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        Integer r115 = r110.intentionType;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        Integer r116 = r110.status;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        SupportedOSAndVersion r117 = r110.supportedOSAndVersion;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        String r118 = r110.ext;
    L58:
        String r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        String r119 = r110.promptForModel;
    L62:
        String r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        String r120 = r110.operator;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        String r108 = r110.updateTime;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L62
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

    public final JumpSomewherePocket component10() {
        return this.jumpSomewherePocket;
    }

    public final Integer component11() {
        return this.intentionType;
    }

    public final Integer component12() {
        return this.status;
    }

    public final SupportedOSAndVersion component13() {
        return this.supportedOSAndVersion;
    }

    public final String component14() {
        return this.ext;
    }

    public final String component15() {
        return this.promptForModel;
    }

    public final String component16() {
        return this.operator;
    }

    public final String component17() {
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

    public final Integer component6() {
        return this.pocketTag;
    }

    public final SendMsgPocket component7() {
        return this.sendMsgPocket;
    }

    public final KeyboardInputPocket component8() {
        return this.keyboardInputPocket;
    }

    public final UploadInputPocket component9() {
        return this.uploadInputPocket;
    }

    public final Pocket copy(String r210, String r211, String r212, String r213, Integer r214, Integer r215, SendMsgPocket r216, KeyboardInputPocket r217, UploadInputPocket r218, JumpSomewherePocket r219, Integer r310, Integer r311, SupportedOSAndVersion r312, String r313, String r314, String r315, String r316) {
        return new Pocket(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
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
        if (Intrinsics.areEqual(this.pocketTag, r101.pocketTag) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sendMsgPocket, r101.sendMsgPocket) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.keyboardInputPocket, r101.keyboardInputPocket) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.uploadInputPocket, r101.uploadInputPocket) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.jumpSomewherePocket, r101.jumpSomewherePocket) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.intentionType, r101.intentionType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.supportedOSAndVersion, r101.supportedOSAndVersion) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.promptForModel, r101.promptForModel) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.operator, r101.operator) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L59;
        return false;
    L59:
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
        Integer r116 = this.pocketTag;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        SendMsgPocket r119 = this.sendMsgPocket;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        KeyboardInputPocket r122 = this.keyboardInputPocket;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        UploadInputPocket r125 = this.uploadInputPocket;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        JumpSomewherePocket r128 = this.jumpSomewherePocket;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.intentionType;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.status;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        SupportedOSAndVersion r137 = this.supportedOSAndVersion;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.ext;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.promptForModel;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.operator;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.updateTime;
        if (r149 == null) goto L71;
        r101 = r149.hashCode();
    L71:
        return r148 + r101;
    L65:
        r147 = r146.hashCode();
        goto L66
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
        return "Pocket(pocketId=" + this.pocketId + ", configName=" + this.configName + ", iconUrl=" + this.iconUrl + ", prompt=" + this.prompt + ", pocketType=" + this.pocketType + ", pocketTag=" + this.pocketTag + ", sendMsgPocket=" + this.sendMsgPocket + ", keyboardInputPocket=" + this.keyboardInputPocket + ", uploadInputPocket=" + this.uploadInputPocket + ", jumpSomewherePocket=" + this.jumpSomewherePocket + ", intentionType=" + this.intentionType + ", status=" + this.status + ", supportedOSAndVersion=" + this.supportedOSAndVersion + ", ext=" + this.ext + ", promptForModel=" + this.promptForModel + ", operator=" + this.operator + ", updateTime=" + this.updateTime + ')';
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

    public final Integer getPocketTag() {
        return this.pocketTag;
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

    public Pocket(String r100, String r101, String r102, String r103, Integer r104, Integer r105, SendMsgPocket r106, KeyboardInputPocket r110, UploadInputPocket r111, JumpSomewherePocket r112, Integer r113, Integer r114, SupportedOSAndVersion r115, String r116, String r117, String r118, String r119) {
        this.pocketId = r100;
        this.configName = r101;
        this.iconUrl = r102;
        this.prompt = r103;
        this.pocketType = r104;
        this.pocketTag = r105;
        this.sendMsgPocket = r106;
        this.keyboardInputPocket = r110;
        this.uploadInputPocket = r111;
        this.jumpSomewherePocket = r112;
        this.intentionType = r113;
        this.status = r114;
        this.supportedOSAndVersion = r115;
        this.ext = r116;
        this.promptForModel = r117;
        this.operator = r118;
        this.updateTime = r119;
    }

    public /* synthetic */ Pocket(String r110, String r210, String r211, String r212, Integer r213, Integer r214, SendMsgPocket r215, KeyboardInputPocket r216, UploadInputPocket r217, JumpSomewherePocket r218, Integer r219, Integer r310, SupportedOSAndVersion r311, String r312, String r313, String r314, String r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        SendMsgPocket r106 = null;
    L31:
        if ((r316 & 128) == 0) goto L33;
        KeyboardInputPocket r107 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        UploadInputPocket r111 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        JumpSomewherePocket r112 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        Integer r113 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        Integer r114 = null;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        SupportedOSAndVersion r115 = null;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r116 = null;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        String r109 = null;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r115, r116, r108, r117, r109);
        return;
    L69:
        r109 = r315;
        goto L70
    L65:
        r117 = r314;
        goto L67
    L61:
        r108 = r313;
        goto L63
    L57:
        r116 = r312;
        goto L59
    L53:
        r115 = r311;
        goto L55
    L49:
        r114 = r310;
        goto L51
    L45:
        r113 = r219;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
