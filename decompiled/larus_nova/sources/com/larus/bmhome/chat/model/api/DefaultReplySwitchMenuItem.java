package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.actionbar.model.u1;
import com.larus.bmhome.actionbar.model.z1;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b=\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001a\u0012\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\b\u0010A\u001a\u00020\u0003H\u0007J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010,J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010J\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010.J\u0013\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010N\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010O\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001aHÆ\u0003J\u0013\u0010R\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0010HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u009c\u0002\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001a2\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u00152\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\u0003HÖ\u0001J\t\u0010[\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b+\u0010,R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b3\u0010,R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$R&\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R \u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00101R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010$R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006\\"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuItem;", "", "itemId", "", "name", "", "icon", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "darkModeIcon", "activeIcon", "activeDarkModeIcon", "subTitleName", "showTaskTools", "redDotVersion", "", "tagList", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemTag;", "selectedName", "agentMode", "needLogin", "", "subscribeConfig", "Lcom/larus/bmhome/actionbar/model/SubscribeConfig;", "modelItemKey", "modelExtraParams", "", "conversationModeList", "defaultConversationMode", "defaultMode", "reasoningEffortConfig", "Lcom/larus/bmhome/actionbar/model/ReasoningEffortConfig;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/bmhome/actionbar/model/SubscribeConfig;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ReasoningEffortConfig;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getIcon", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "getDarkModeIcon", "getActiveIcon", "getActiveDarkModeIcon", "getSubTitleName", "getShowTaskTools", "()Ljava/lang/Integer;", "getRedDotVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTagList", "()Ljava/util/List;", "getSelectedName", "getAgentMode", "getNeedLogin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSubscribeConfig", "()Lcom/larus/bmhome/actionbar/model/SubscribeConfig;", "getModelItemKey", "getModelExtraParams", "()Ljava/util/Map;", "getConversationModeList", "getDefaultConversationMode", "getDefaultMode", "getReasoningEffortConfig", "()Lcom/larus/bmhome/actionbar/model/ReasoningEffortConfig;", "getDeprecatedItemId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/bmhome/actionbar/model/SubscribeConfig;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ReasoningEffortConfig;)Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuItem;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReplySwitchMenuItem {

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

    @SerializedName("default_mode")
    private final String defaultMode;

    @SerializedName("icon")
    private final DefaultReplyMenuItemIcon icon;

    @SerializedName("item_id")
    private final Integer itemId;

    @SerializedName("model_extra_params")
    private final Map<String, String> modelExtraParams;

    @SerializedName("model_item_key")
    private final String modelItemKey;

    @SerializedName("name")
    private final String name;

    @SerializedName("need_login")
    private final Boolean needLogin;

    @SerializedName("reasoning_effort_config")
    private final u1 reasoningEffortConfig;

    @SerializedName("red_dot_version")
    private final Long redDotVersion;

    @SerializedName("selected_name")
    private final String selectedName;

    @SerializedName("show_task_tools")
    private final Integer showTaskTools;

    @SerializedName("sub_title_name")
    private final String subTitleName;

    @SerializedName("subscribe_config")
    private final z1 subscribeConfig;

    @SerializedName("tag_list")
    private final List<DefaultReplyMenuItemTag> tagList;

    public DefaultReplySwitchMenuItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    private final Integer component1() {
        return this.itemId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplySwitchMenuItem copy$default(DefaultReplySwitchMenuItem r110, Integer r111, String r112, DefaultReplyMenuItemIcon r210, DefaultReplyMenuItemIcon r211, DefaultReplyMenuItemIcon r212, DefaultReplyMenuItemIcon r213, String r214, Integer r215, Long r216, List r217, String r218, Integer r219, Boolean r310, z1 r311, String r312, Map r313, List r314, String r315, String r316, u1 r317, int r318, Object r319) {
        if ((r318 & 1) == 0) goto L5;
        Integer r100 = r110.itemId;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r318 & 4) == 0) goto L13;
        DefaultReplyMenuItemIcon r102 = r110.icon;
    L15:
        if ((r318 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r103 = r110.darkModeIcon;
    L19:
        if ((r318 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r104 = r110.activeIcon;
    L23:
        if ((r318 & 32) == 0) goto L25;
        DefaultReplyMenuItemIcon r105 = r110.activeDarkModeIcon;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = r110.subTitleName;
    L31:
        if ((r318 & 128) == 0) goto L33;
        Integer r107 = r110.showTaskTools;
    L35:
        if ((r318 & 256) == 0) goto L37;
        Long r113 = r110.redDotVersion;
    L39:
        if ((r318 & 512) == 0) goto L41;
        List r114 = r110.tagList;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r115 = r110.selectedName;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        Integer r116 = r110.agentMode;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        Boolean r117 = r110.needLogin;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        z1 r118 = r110.subscribeConfig;
    L58:
        z1 r320 = r118;
        if ((r318 & 16384) == 0) goto L61;
        String r119 = r110.modelItemKey;
    L62:
        String r321 = r119;
        if ((r318 & 32768) == 0) goto L65;
        Map r120 = r110.modelExtraParams;
    L66:
        Map r322 = r120;
        if ((r318 & 65536) == 0) goto L69;
        List r121 = r110.conversationModeList;
    L70:
        List r323 = r121;
        if ((r318 & 131072) == 0) goto L73;
        String r122 = r110.defaultConversationMode;
    L74:
        String r324 = r122;
        if ((r318 & 262144) == 0) goto L77;
        String r123 = r110.defaultMode;
    L79:
        if ((r318 & 524288) == 0) goto L81;
        u1 r108 = r110.reasoningEffortConfig;
    L83:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r123, r108);
    L81:
        r108 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
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

    public final List<DefaultReplyMenuItemTag> component10() {
        return this.tagList;
    }

    public final String component11() {
        return this.selectedName;
    }

    public final Integer component12() {
        return this.agentMode;
    }

    public final Boolean component13() {
        return this.needLogin;
    }

    public final z1 component14() {
        return this.subscribeConfig;
    }

    public final String component15() {
        return this.modelItemKey;
    }

    public final Map<String, String> component16() {
        return this.modelExtraParams;
    }

    public final List<String> component17() {
        return this.conversationModeList;
    }

    public final String component18() {
        return this.defaultConversationMode;
    }

    public final String component19() {
        return this.defaultMode;
    }

    public final String component2() {
        return this.name;
    }

    public final u1 component20() {
        return this.reasoningEffortConfig;
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

    public final Integer component8() {
        return this.showTaskTools;
    }

    public final Long component9() {
        return this.redDotVersion;
    }

    public final DefaultReplySwitchMenuItem copy(Integer r210, String r211, DefaultReplyMenuItemIcon r212, DefaultReplyMenuItemIcon r213, DefaultReplyMenuItemIcon r214, DefaultReplyMenuItemIcon r215, String r216, Integer r310, Long r311, List<DefaultReplyMenuItemTag> r312, String r313, Integer r314, Boolean r315, z1 r316, String r317, Map<String, String> r318, List<String> r319, String r410, String r411, u1 r412) {
        return new DefaultReplySwitchMenuItem(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultReplySwitchMenuItem) == true) goto L8;
        return false;
    L8:
        DefaultReplySwitchMenuItem r101 = (DefaultReplySwitchMenuItem) r100;
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L12;
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
        if (Intrinsics.areEqual(this.showTaskTools, r101.showTaskTools) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.redDotVersion, r101.redDotVersion) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.selectedName, r101.selectedName) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.agentMode, r101.agentMode) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.needLogin, r101.needLogin) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.subscribeConfig, r101.subscribeConfig) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.modelItemKey, r101.modelItemKey) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.modelExtraParams, r101.modelExtraParams) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.conversationModeList, r101.conversationModeList) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.defaultConversationMode, r101.defaultConversationMode) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.defaultMode, r101.defaultMode) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.reasoningEffortConfig, r101.reasoningEffortConfig) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.itemId;
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
        Integer r122 = this.showTaskTools;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.redDotVersion;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        List<DefaultReplyMenuItemTag> r128 = this.tagList;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.selectedName;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.agentMode;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.needLogin;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        z1 r140 = this.subscribeConfig;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.modelItemKey;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Map<String, String> r146 = this.modelExtraParams;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        List<String> r149 = this.conversationModeList;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.defaultConversationMode;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.defaultMode;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        u1 r158 = this.reasoningEffortConfig;
        if (r158 == null) goto L83;
        r101 = r158.hashCode();
    L83:
        return r157 + r101;
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
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
        return "DefaultReplySwitchMenuItem(itemId=" + this.itemId + ", name=" + this.name + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", activeIcon=" + this.activeIcon + ", activeDarkModeIcon=" + this.activeDarkModeIcon + ", subTitleName=" + this.subTitleName + ", showTaskTools=" + this.showTaskTools + ", redDotVersion=" + this.redDotVersion + ", tagList=" + this.tagList + ", selectedName=" + this.selectedName + ", agentMode=" + this.agentMode + ", needLogin=" + this.needLogin + ", subscribeConfig=" + this.subscribeConfig + ", modelItemKey=" + this.modelItemKey + ", modelExtraParams=" + this.modelExtraParams + ", conversationModeList=" + this.conversationModeList + ", defaultConversationMode=" + this.defaultConversationMode + ", defaultMode=" + this.defaultMode + ", reasoningEffortConfig=" + this.reasoningEffortConfig + ')';
    }

    @Deprecated(message = "use model_item_key instead")
    public final int getDeprecatedItemId() {
        Integer r100 = this.itemId;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
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

    public final String getDefaultMode() {
        return this.defaultMode;
    }

    public final DefaultReplyMenuItemIcon getIcon() {
        return this.icon;
    }

    public final Map<String, String> getModelExtraParams() {
        return this.modelExtraParams;
    }

    public final String getModelItemKey() {
        return this.modelItemKey;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getNeedLogin() {
        return this.needLogin;
    }

    public final u1 getReasoningEffortConfig() {
        return this.reasoningEffortConfig;
    }

    public final Long getRedDotVersion() {
        return this.redDotVersion;
    }

    public final String getSelectedName() {
        return this.selectedName;
    }

    public final Integer getShowTaskTools() {
        return this.showTaskTools;
    }

    public final String getSubTitleName() {
        return this.subTitleName;
    }

    public final z1 getSubscribeConfig() {
        return this.subscribeConfig;
    }

    public final List<DefaultReplyMenuItemTag> getTagList() {
        return this.tagList;
    }

    public DefaultReplySwitchMenuItem(Integer r100, String r101, DefaultReplyMenuItemIcon r102, DefaultReplyMenuItemIcon r103, DefaultReplyMenuItemIcon r104, DefaultReplyMenuItemIcon r105, String r106, Integer r110, Long r111, List<DefaultReplyMenuItemTag> r112, String r113, Integer r114, Boolean r115, z1 r116, String r117, Map<String, String> r118, List<String> r119, String r210, String r211, u1 r212) {
        this.itemId = r100;
        this.name = r101;
        this.icon = r102;
        this.darkModeIcon = r103;
        this.activeIcon = r104;
        this.activeDarkModeIcon = r105;
        this.subTitleName = r106;
        this.showTaskTools = r110;
        this.redDotVersion = r111;
        this.tagList = r112;
        this.selectedName = r113;
        this.agentMode = r114;
        this.needLogin = r115;
        this.subscribeConfig = r116;
        this.modelItemKey = r117;
        this.modelExtraParams = r118;
        this.conversationModeList = r119;
        this.defaultConversationMode = r210;
        this.defaultMode = r211;
        this.reasoningEffortConfig = r212;
    }

    public /* synthetic */ DefaultReplySwitchMenuItem(Integer r210, String r211, DefaultReplyMenuItemIcon r212, DefaultReplyMenuItemIcon r213, DefaultReplyMenuItemIcon r214, DefaultReplyMenuItemIcon r215, String r216, Integer r217, Long r310, List r311, String r312, Integer r313, Boolean r314, z1 r315, String r316, Map r317, List r318, String r319, String r410, u1 r411, int r412, DefaultConstructorMarker r413) {
        if ((r412 & 1) == 0) goto L5;
        Integer r100 = null;
    L6:
        String r101 = "";
        if ((r412 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r412 & 4) == 0) goto L13;
        DefaultReplyMenuItemIcon r103 = null;
    L15:
        if ((r412 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r104 = null;
    L19:
        if ((r412 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r105 = null;
    L23:
        if ((r412 & 32) == 0) goto L25;
        DefaultReplyMenuItemIcon r106 = null;
    L27:
        if ((r412 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r412 & 128) == 0) goto L33;
        Integer r110 = null;
    L35:
        if ((r412 & 256) == 0) goto L37;
        Long r111 = null;
    L39:
        if ((r412 & 512) == 0) goto L41;
        List r112 = null;
    L43:
        if ((r412 & 1024) != 0) goto L47;
        r101 = r312;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        Integer r113 = null;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        Boolean r114 = null;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        z1 r115 = null;
    L59:
        if ((r412 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r412 & 32768) == 0) goto L65;
        Map r116 = null;
    L67:
        if ((r412 & 65536) == 0) goto L69;
        List r117 = null;
    L71:
        if ((r412 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r412 & 262144) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r412 & 524288) == 0) goto L81;
        u1 r109 = null;
    L82:
        this(r100, r102, r103, r104, r105, r106, r107, r110, r111, r112, r101, r113, r114, r115, r108, r116, r117, r118, r119, r109);
        return;
    L81:
        r109 = r411;
        goto L82
    L77:
        r119 = r410;
        goto L79
    L73:
        r118 = r319;
        goto L75
    L69:
        r117 = r318;
        goto L71
    L65:
        r116 = r317;
        goto L67
    L61:
        r108 = r316;
        goto L63
    L57:
        r115 = r315;
        goto L59
    L53:
        r114 = r314;
        goto L55
    L49:
        r113 = r313;
        goto L51
    L41:
        r112 = r311;
        goto L43
    L37:
        r111 = r310;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L29:
        r107 = r216;
        goto L31
    L25:
        r106 = r215;
        goto L27
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L6
    }
}
