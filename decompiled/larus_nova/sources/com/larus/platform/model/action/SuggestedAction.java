package com.larus.platform.model.action;

import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B±\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0013\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\rHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0017\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0017\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0003J³\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0001J\u0013\u00109\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(¨\u0006>"}, d2 = {"Lcom/larus/platform/model/action/SuggestedAction;", "Ljava/io/Serializable;", "suggestedActionKey", "", "suggestedActionType", "", SlcFlexDirection.FLEX_ROW, CommonConstant.KEY_DISPLAY_NAME, "displayHighlight", "", "promptReplacementCfg", "Lcom/larus/platform/model/action/PromptReplacementCfg;", "displayExtList", "", "chatAbility", "ext", "Lcom/larus/platform/model/action/SuggestedExt;", "eventExtra", "", "redirectionCfg", "Lcom/larus/platform/model/action/RedirectionCfg;", "msgExt", "<init>", "(Ljava/lang/String;IILjava/lang/String;ZLcom/larus/platform/model/action/PromptReplacementCfg;Ljava/util/List;Ljava/lang/String;Lcom/larus/platform/model/action/SuggestedExt;Ljava/util/Map;Lcom/larus/platform/model/action/RedirectionCfg;Ljava/util/Map;)V", "getSuggestedActionKey", "()Ljava/lang/String;", "getSuggestedActionType", "()I", "getRow", "getDisplayName", "getDisplayHighlight", "()Z", "getPromptReplacementCfg", "()Lcom/larus/platform/model/action/PromptReplacementCfg;", "getDisplayExtList", "()Ljava/util/List;", "getChatAbility", "getExt", "()Lcom/larus/platform/model/action/SuggestedExt;", "getEventExtra", "()Ljava/util/Map;", "getRedirectionCfg", "()Lcom/larus/platform/model/action/RedirectionCfg;", "getMsgExt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SuggestedAction implements Serializable {

    @SerializedName("chat_ability")
    private final String chatAbility;

    @SerializedName("display_ext_list")
    private final List<String> displayExtList;

    @SerializedName("display_highlight")
    private final boolean displayHighlight;

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private final String displayName;

    @SerializedName("event_extra")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> eventExtra;

    @SerializedName("extra")
    private final SuggestedExt ext;

    @SerializedName(ChatDraftItem.TYPE_MSG_EXT)
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> msgExt;

    @SerializedName("prompt_replacement_cfg")
    private final PromptReplacementCfg promptReplacementCfg;

    @SerializedName("redirection_cfg")
    private final RedirectionCfg redirectionCfg;

    @SerializedName(SlcFlexDirection.FLEX_ROW)
    private final int row;

    @SerializedName("suggested_action_key")
    private final String suggestedActionKey;

    @SerializedName("suggested_action_type")
    private final int suggestedActionType;

    public SuggestedAction() {
        this(null, 0, 0, null, false, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuggestedAction copy$default(SuggestedAction r110, String r111, int r112, int r113, String r114, boolean r115, PromptReplacementCfg r116, List r210, String r211, SuggestedExt r212, Map r213, RedirectionCfg r214, Map r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.suggestedActionKey;
    L7:
        if ((r216 & 2) == 0) goto L9;
        int r101 = r110.suggestedActionType;
    L11:
        if ((r216 & 4) == 0) goto L13;
        int r102 = r110.row;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.displayName;
    L19:
        if ((r216 & 16) == 0) goto L21;
        boolean r104 = r110.displayHighlight;
    L23:
        if ((r216 & 32) == 0) goto L25;
        PromptReplacementCfg r105 = r110.promptReplacementCfg;
    L27:
        if ((r216 & 64) == 0) goto L29;
        List r106 = r110.displayExtList;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.chatAbility;
    L35:
        if ((r216 & 256) == 0) goto L37;
        SuggestedExt r117 = r110.ext;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Map r118 = r110.eventExtra;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        RedirectionCfg r119 = r110.redirectionCfg;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Map r108 = r110.msgExt;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
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
        return this.suggestedActionKey;
    }

    public final Map<String, String> component10() {
        return this.eventExtra;
    }

    public final RedirectionCfg component11() {
        return this.redirectionCfg;
    }

    public final Map<String, String> component12() {
        return this.msgExt;
    }

    public final int component2() {
        return this.suggestedActionType;
    }

    public final int component3() {
        return this.row;
    }

    public final String component4() {
        return this.displayName;
    }

    public final boolean component5() {
        return this.displayHighlight;
    }

    public final PromptReplacementCfg component6() {
        return this.promptReplacementCfg;
    }

    public final List<String> component7() {
        return this.displayExtList;
    }

    public final String component8() {
        return this.chatAbility;
    }

    public final SuggestedExt component9() {
        return this.ext;
    }

    public final SuggestedAction copy(String r110, int r111, int r112, String r113, boolean r114, PromptReplacementCfg r210, List<String> r211, String r212, SuggestedExt r213, Map<String, String> r214, RedirectionCfg r215, Map<String, String> r216) {
        return new SuggestedAction(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SuggestedAction) == true) goto L8;
        return false;
    L8:
        SuggestedAction r101 = (SuggestedAction) r100;
        if (Intrinsics.areEqual(this.suggestedActionKey, r101.suggestedActionKey) == true) goto L12;
        return false;
    L12:
        if (this.suggestedActionType == r101.suggestedActionType) goto L15;
        return false;
    L15:
        if (this.row == r101.row) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.displayName, r101.displayName) == true) goto L21;
        return false;
    L21:
        if (this.displayHighlight == r101.displayHighlight) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.promptReplacementCfg, r101.promptReplacementCfg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.displayExtList, r101.displayExtList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.chatAbility, r101.chatAbility) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.eventExtra, r101.eventExtra) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.redirectionCfg, r101.redirectionCfg) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.msgExt, r101.msgExt) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.suggestedActionKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.suggestedActionType) * 31) + this.row) * 31;
        String r104 = this.displayName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.displayHighlight == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        PromptReplacementCfg r109 = this.promptReplacementCfg;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        List<String> r112 = this.displayExtList;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.chatAbility;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        SuggestedExt r118 = this.ext;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        Map<String, String> r121 = this.eventExtra;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        RedirectionCfg r124 = this.redirectionCfg;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        Map<String, String> r127 = this.msgExt;
        if (r127 == null) goto L43;
        r101 = r127.hashCode();
    L43:
        return r126 + r101;
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SuggestedAction(suggestedActionKey=" + this.suggestedActionKey + ", suggestedActionType=" + this.suggestedActionType + ", row=" + this.row + ", displayName=" + this.displayName + ", displayHighlight=" + this.displayHighlight + ", promptReplacementCfg=" + this.promptReplacementCfg + ", displayExtList=" + this.displayExtList + ", chatAbility=" + this.chatAbility + ", ext=" + this.ext + ", eventExtra=" + this.eventExtra + ", redirectionCfg=" + this.redirectionCfg + ", msgExt=" + this.msgExt + ')';
    }

    public final String getChatAbility() {
        return this.chatAbility;
    }

    public final List<String> getDisplayExtList() {
        return this.displayExtList;
    }

    public final boolean getDisplayHighlight() {
        return this.displayHighlight;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Map<String, String> getEventExtra() {
        return this.eventExtra;
    }

    public final SuggestedExt getExt() {
        return this.ext;
    }

    public final Map<String, String> getMsgExt() {
        return this.msgExt;
    }

    public final PromptReplacementCfg getPromptReplacementCfg() {
        return this.promptReplacementCfg;
    }

    public final RedirectionCfg getRedirectionCfg() {
        return this.redirectionCfg;
    }

    public final int getRow() {
        return this.row;
    }

    public final String getSuggestedActionKey() {
        return this.suggestedActionKey;
    }

    public final int getSuggestedActionType() {
        return this.suggestedActionType;
    }

    public SuggestedAction(String r100, int r101, int r102, String r103, boolean r104, PromptReplacementCfg r105, List<String> r106, String r107, SuggestedExt r108, Map<String, String> r110, RedirectionCfg r111, Map<String, String> r112) {
        this.suggestedActionKey = r100;
        this.suggestedActionType = r101;
        this.row = r102;
        this.displayName = r103;
        this.displayHighlight = r104;
        this.promptReplacementCfg = r105;
        this.displayExtList = r106;
        this.chatAbility = r107;
        this.ext = r108;
        this.eventExtra = r110;
        this.redirectionCfg = r111;
        this.msgExt = r112;
    }

    public /* synthetic */ SuggestedAction(String r110, int r111, int r112, String r113, boolean r114, PromptReplacementCfg r115, List r210, String r211, SuggestedExt r212, Map r213, RedirectionCfg r214, Map r215, int r216, DefaultConstructorMarker r217) {
        RedirectionCfg r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L6:
        boolean r102 = false;
        if ((r216 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r216 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r216 & 16) != 0) goto L23;
        r102 = r114;
    L23:
        if ((r216 & 32) == 0) goto L25;
        PromptReplacementCfg r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        SuggestedExt r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Map r117 = new LinkedHashMap();
    L43:
        if ((r216 & 1024) != 0) goto L47;
        r100 = r214;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Map r109 = new LinkedHashMap();
    L50:
        this(r101, r103, r104, r105, r102, r106, r107, r108, r116, r117, r100, r109);
        return;
    L49:
        r109 = r215;
        goto L50
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
