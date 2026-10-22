package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\f\u0012\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010@\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010B\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010E\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0013\u0010F\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\fHÆ\u0003J\u0013\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\fHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010J\u001a\u0004\u0018\u00010\u001bHÆ\u0003Jþ\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\f2\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020\u00132\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\u000fHÖ\u0001J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R \u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R \u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b6\u0010/R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006Q"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuMode;", "", "modeId", "", "name", "icon", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "darkModeIcon", "activeIcon", "activeDarkModeIcon", "subTitleName", "tagList", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemTag;", "showTaskTools", "", "agentMode", "selectedName", "needLogin", "", "defaultModel", "Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;", "supportModels", "conversationModeList", "defaultConversationMode", "showReasoningEffort", "modelList", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;)V", "getModeId", "()Ljava/lang/String;", "getName", "getIcon", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "getDarkModeIcon", "getActiveIcon", "getActiveDarkModeIcon", "getSubTitleName", "getTagList", "()Ljava/util/List;", "getShowTaskTools", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAgentMode", "getSelectedName", "getNeedLogin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDefaultModel", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;", "getSupportModels", "getConversationModeList", "getDefaultConversationMode", "getShowReasoningEffort", "getModelList", "()Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;)Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuMode;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReplySwitchMenuMode {

    @SerializedName("active_dark_mode_icon")
    private final DefaultReplyMenuItemIcon activeDarkModeIcon;

    @SerializedName("active_icon")
    private final DefaultReplyMenuItemIcon activeIcon;

    @SerializedName("agent_mode")
    private final Integer agentMode;

    @SerializedName("conversation_mode_list")
    private final List<String> conversationModeList;

    @SerializedName("dark_mode_icon")
    private final DefaultReplyMenuItemIcon darkModeIcon;

    @SerializedName("default_conversation_mode")
    private final String defaultConversationMode;

    @SerializedName("default_model")
    private final DefaultReplyModelItemIndex defaultModel;

    @SerializedName("icon")
    private final DefaultReplyMenuItemIcon icon;

    @SerializedName("mode_id")
    private final String modeId;

    @SerializedName("model_list")
    private final DefaultReplySwitchMenuConfig modelList;

    @SerializedName("name")
    private final String name;

    @SerializedName("need_login")
    private final Boolean needLogin;

    @SerializedName("selected_name")
    private final String selectedName;

    @SerializedName("show_reasoning_effort")
    private final Boolean showReasoningEffort;

    @SerializedName("show_task_tools")
    private final Integer showTaskTools;

    @SerializedName("sub_title_name")
    private final String subTitleName;

    @SerializedName("support_models")
    private final List<DefaultReplyModelItemIndex> supportModels;

    @SerializedName("tag_list")
    private final List<DefaultReplyMenuItemTag> tagList;

    public DefaultReplySwitchMenuMode() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplySwitchMenuMode copy$default(DefaultReplySwitchMenuMode r110, String r111, String r112, DefaultReplyMenuItemIcon r210, DefaultReplyMenuItemIcon r211, DefaultReplyMenuItemIcon r212, DefaultReplyMenuItemIcon r213, String r214, List r215, Integer r216, Integer r217, String r218, Boolean r219, DefaultReplyModelItemIndex r310, List r311, List r312, String r313, Boolean r314, DefaultReplySwitchMenuConfig r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = r110.modeId;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r316 & 4) == 0) goto L13;
        DefaultReplyMenuItemIcon r102 = r110.icon;
    L15:
        if ((r316 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r103 = r110.darkModeIcon;
    L19:
        if ((r316 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r104 = r110.activeIcon;
    L23:
        if ((r316 & 32) == 0) goto L25;
        DefaultReplyMenuItemIcon r105 = r110.activeDarkModeIcon;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = r110.subTitleName;
    L31:
        if ((r316 & 128) == 0) goto L33;
        List r107 = r110.tagList;
    L35:
        if ((r316 & 256) == 0) goto L37;
        Integer r113 = r110.showTaskTools;
    L39:
        if ((r316 & 512) == 0) goto L41;
        Integer r114 = r110.agentMode;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r115 = r110.selectedName;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        Boolean r116 = r110.needLogin;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        DefaultReplyModelItemIndex r117 = r110.defaultModel;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        List r118 = r110.supportModels;
    L58:
        List r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        List r119 = r110.conversationModeList;
    L62:
        List r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        String r120 = r110.defaultConversationMode;
    L66:
        String r320 = r120;
        if ((r316 & 65536) == 0) goto L69;
        Boolean r121 = r110.showReasoningEffort;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        DefaultReplySwitchMenuConfig r108 = r110.modelList;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r318, r319, r320, r121, r108);
    L73:
        r108 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L66
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
        return this.modeId;
    }

    public final Integer component10() {
        return this.agentMode;
    }

    public final String component11() {
        return this.selectedName;
    }

    public final Boolean component12() {
        return this.needLogin;
    }

    public final DefaultReplyModelItemIndex component13() {
        return this.defaultModel;
    }

    public final List<DefaultReplyModelItemIndex> component14() {
        return this.supportModels;
    }

    public final List<String> component15() {
        return this.conversationModeList;
    }

    public final String component16() {
        return this.defaultConversationMode;
    }

    public final Boolean component17() {
        return this.showReasoningEffort;
    }

    public final DefaultReplySwitchMenuConfig component18() {
        return this.modelList;
    }

    public final String component2() {
        return this.name;
    }

    public final DefaultReplyMenuItemIcon component3() {
        return this.icon;
    }

    public final DefaultReplyMenuItemIcon component4() {
        return this.darkModeIcon;
    }

    public final DefaultReplyMenuItemIcon component5() {
        return this.activeIcon;
    }

    public final DefaultReplyMenuItemIcon component6() {
        return this.activeDarkModeIcon;
    }

    public final String component7() {
        return this.subTitleName;
    }

    public final List<DefaultReplyMenuItemTag> component8() {
        return this.tagList;
    }

    public final Integer component9() {
        return this.showTaskTools;
    }

    public final DefaultReplySwitchMenuMode copy(String r210, String r211, DefaultReplyMenuItemIcon r212, DefaultReplyMenuItemIcon r213, DefaultReplyMenuItemIcon r214, DefaultReplyMenuItemIcon r215, String r216, List<DefaultReplyMenuItemTag> r217, Integer r218, Integer r310, String r311, Boolean r312, DefaultReplyModelItemIndex r313, List<DefaultReplyModelItemIndex> r314, List<String> r315, String r316, Boolean r317, DefaultReplySwitchMenuConfig r318) {
        return new DefaultReplySwitchMenuMode(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultReplySwitchMenuMode) == true) goto L8;
        return false;
    L8:
        DefaultReplySwitchMenuMode r101 = (DefaultReplySwitchMenuMode) r100;
        if (Intrinsics.areEqual(this.modeId, r101.modeId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.darkModeIcon, r101.darkModeIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.activeIcon, r101.activeIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.activeDarkModeIcon, r101.activeDarkModeIcon) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.subTitleName, r101.subTitleName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.showTaskTools, r101.showTaskTools) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.agentMode, r101.agentMode) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.selectedName, r101.selectedName) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.needLogin, r101.needLogin) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.defaultModel, r101.defaultModel) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.supportModels, r101.supportModels) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.conversationModeList, r101.conversationModeList) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.defaultConversationMode, r101.defaultConversationMode) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.showReasoningEffort, r101.showReasoningEffort) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.modelList, r101.modelList) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public int hashCode() {
        String r100 = this.modeId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        DefaultReplyMenuItemIcon r107 = this.icon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        DefaultReplyMenuItemIcon r110 = this.darkModeIcon;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        DefaultReplyMenuItemIcon r113 = this.activeIcon;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        DefaultReplyMenuItemIcon r116 = this.activeDarkModeIcon;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.subTitleName;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<DefaultReplyMenuItemTag> r122 = this.tagList;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.showTaskTools;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.agentMode;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.selectedName;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.needLogin;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        DefaultReplyModelItemIndex r137 = this.defaultModel;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        List<DefaultReplyModelItemIndex> r140 = this.supportModels;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        List<String> r143 = this.conversationModeList;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.defaultConversationMode;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.showReasoningEffort;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        DefaultReplySwitchMenuConfig r152 = this.modelList;
        if (r152 == null) goto L75;
        r101 = r152.hashCode();
    L75:
        return r151 + r101;
    L69:
        r150 = r149.hashCode();
        goto L70
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
        return "DefaultReplySwitchMenuMode(modeId=" + this.modeId + ", name=" + this.name + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", activeIcon=" + this.activeIcon + ", activeDarkModeIcon=" + this.activeDarkModeIcon + ", subTitleName=" + this.subTitleName + ", tagList=" + this.tagList + ", showTaskTools=" + this.showTaskTools + ", agentMode=" + this.agentMode + ", selectedName=" + this.selectedName + ", needLogin=" + this.needLogin + ", defaultModel=" + this.defaultModel + ", supportModels=" + this.supportModels + ", conversationModeList=" + this.conversationModeList + ", defaultConversationMode=" + this.defaultConversationMode + ", showReasoningEffort=" + this.showReasoningEffort + ", modelList=" + this.modelList + ')';
    }

    public final DefaultReplyMenuItemIcon getActiveDarkModeIcon() {
        return this.activeDarkModeIcon;
    }

    public final DefaultReplyMenuItemIcon getActiveIcon() {
        return this.activeIcon;
    }

    public final Integer getAgentMode() {
        return this.agentMode;
    }

    public final List<String> getConversationModeList() {
        return this.conversationModeList;
    }

    public final DefaultReplyMenuItemIcon getDarkModeIcon() {
        return this.darkModeIcon;
    }

    public final String getDefaultConversationMode() {
        return this.defaultConversationMode;
    }

    public final DefaultReplyModelItemIndex getDefaultModel() {
        return this.defaultModel;
    }

    public final DefaultReplyMenuItemIcon getIcon() {
        return this.icon;
    }

    public final String getModeId() {
        return this.modeId;
    }

    public final DefaultReplySwitchMenuConfig getModelList() {
        return this.modelList;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getNeedLogin() {
        return this.needLogin;
    }

    public final String getSelectedName() {
        return this.selectedName;
    }

    public final Boolean getShowReasoningEffort() {
        return this.showReasoningEffort;
    }

    public final Integer getShowTaskTools() {
        return this.showTaskTools;
    }

    public final String getSubTitleName() {
        return this.subTitleName;
    }

    public final List<DefaultReplyModelItemIndex> getSupportModels() {
        return this.supportModels;
    }

    public final List<DefaultReplyMenuItemTag> getTagList() {
        return this.tagList;
    }

    public DefaultReplySwitchMenuMode(String r100, String r101, DefaultReplyMenuItemIcon r102, DefaultReplyMenuItemIcon r103, DefaultReplyMenuItemIcon r104, DefaultReplyMenuItemIcon r105, String r106, List<DefaultReplyMenuItemTag> r110, Integer r111, Integer r112, String r113, Boolean r114, DefaultReplyModelItemIndex r115, List<DefaultReplyModelItemIndex> r116, List<String> r117, String r118, Boolean r119, DefaultReplySwitchMenuConfig r210) {
        this.modeId = r100;
        this.name = r101;
        this.icon = r102;
        this.darkModeIcon = r103;
        this.activeIcon = r104;
        this.activeDarkModeIcon = r105;
        this.subTitleName = r106;
        this.tagList = r110;
        this.showTaskTools = r111;
        this.agentMode = r112;
        this.selectedName = r113;
        this.needLogin = r114;
        this.defaultModel = r115;
        this.supportModels = r116;
        this.conversationModeList = r117;
        this.defaultConversationMode = r118;
        this.showReasoningEffort = r119;
        this.modelList = r210;
    }

    public /* synthetic */ DefaultReplySwitchMenuMode(String r210, String r211, DefaultReplyMenuItemIcon r212, DefaultReplyMenuItemIcon r213, DefaultReplyMenuItemIcon r214, DefaultReplyMenuItemIcon r215, String r216, List r217, Integer r218, Integer r219, String r310, Boolean r311, DefaultReplyModelItemIndex r312, List r313, List r314, String r315, Boolean r316, DefaultReplySwitchMenuConfig r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        DefaultReplyMenuItemIcon r102 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r103 = null;
    L19:
        if ((r318 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r104 = null;
    L23:
        if ((r318 & 32) == 0) goto L25;
        DefaultReplyMenuItemIcon r105 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r318 & 128) == 0) goto L33;
        List r107 = null;
    L35:
        if ((r318 & 256) == 0) goto L37;
        Integer r110 = null;
    L39:
        if ((r318 & 512) == 0) goto L41;
        Integer r111 = null;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        Boolean r113 = null;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        DefaultReplyModelItemIndex r114 = null;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        List r115 = null;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        List r108 = null;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        Boolean r117 = null;
    L71:
        if ((r318 & 131072) == 0) goto L73;
        DefaultReplySwitchMenuConfig r109 = null;
    L74:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r108 = r314;
        goto L63
    L57:
        r115 = r313;
        goto L59
    L53:
        r114 = r312;
        goto L55
    L49:
        r113 = r311;
        goto L51
    L45:
        r112 = r310;
        goto L47
    L41:
        r111 = r219;
        goto L43
    L37:
        r110 = r218;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
