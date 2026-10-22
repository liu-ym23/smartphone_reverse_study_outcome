package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.z1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010#\u001a\u0004\u0018\u00010$J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010&J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u0013\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¢\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItem;", "", "itemId", "", "name", "", "subTitleName", "icon", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "darkModeIcon", "tagList", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemTag;", "selectedName", "subscribeConfig", "Lcom/larus/bmhome/actionbar/model/SubscribeConfig;", "modelItemKey", "conversationModeList", "defaultConversationMode", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/util/List;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/SubscribeConfig;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getSubTitleName", "getIcon", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "getDarkModeIcon", "getTagList", "()Ljava/util/List;", "getSelectedName", "getSubscribeConfig", "()Lcom/larus/bmhome/actionbar/model/SubscribeConfig;", "getConversationModeList", "getDefaultConversationMode", "getIdentity", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/util/List;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/SubscribeConfig;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItem;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReplyMenuItem {

    @SerializedName("conversation_mode_list")
    private final List<String> conversationModeList;

    @SerializedName("dark_mode_icon")
    private final DefaultReplyMenuItemIcon darkModeIcon;

    @SerializedName("default_conversation_mode")
    private final String defaultConversationMode;

    @SerializedName("icon")
    private final DefaultReplyMenuItemIcon icon;

    @SerializedName("item_id")
    private final Integer itemId;

    @SerializedName("model_item_key")
    private final String modelItemKey;

    @SerializedName("name")
    private final String name;

    @SerializedName("selected_name")
    private final String selectedName;

    @SerializedName("sub_title_name")
    private final String subTitleName;

    @SerializedName("subscribe_config")
    private final z1 subscribeConfig;

    @SerializedName("tag_list")
    private final List<DefaultReplyMenuItemTag> tagList;

    public DefaultReplyMenuItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    private final Integer component1() {
        return this.itemId;
    }

    private final String component9() {
        return this.modelItemKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplyMenuItem copy$default(DefaultReplyMenuItem r110, Integer r111, String r112, String r113, DefaultReplyMenuItemIcon r114, DefaultReplyMenuItemIcon r115, List r116, String r117, z1 r210, String r211, List r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        Integer r100 = r110.itemId;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.subTitleName;
    L15:
        if ((r214 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r103 = r110.icon;
    L19:
        if ((r214 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r104 = r110.darkModeIcon;
    L23:
        if ((r214 & 32) == 0) goto L25;
        List r105 = r110.tagList;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.selectedName;
    L31:
        if ((r214 & 128) == 0) goto L33;
        z1 r107 = r110.subscribeConfig;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.modelItemKey;
    L39:
        if ((r214 & 512) == 0) goto L41;
        List r119 = r110.conversationModeList;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.defaultConversationMode;
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

    public final List<String> component10() {
        return this.conversationModeList;
    }

    public final String component11() {
        return this.defaultConversationMode;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.subTitleName;
    }

    public final DefaultReplyMenuItemIcon component4() {
        return this.icon;
    }

    public final DefaultReplyMenuItemIcon component5() {
        return this.darkModeIcon;
    }

    public final List<DefaultReplyMenuItemTag> component6() {
        return this.tagList;
    }

    public final String component7() {
        return this.selectedName;
    }

    public final z1 component8() {
        return this.subscribeConfig;
    }

    public final DefaultReplyMenuItem copy(Integer r110, String r111, String r112, DefaultReplyMenuItemIcon r113, DefaultReplyMenuItemIcon r114, List<DefaultReplyMenuItemTag> r115, String r210, z1 r211, String r212, List<String> r213, String r214) {
        return new DefaultReplyMenuItem(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultReplyMenuItem) == true) goto L8;
        return false;
    L8:
        DefaultReplyMenuItem r101 = (DefaultReplyMenuItem) r100;
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subTitleName, r101.subTitleName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.darkModeIcon, r101.darkModeIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.selectedName, r101.selectedName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.subscribeConfig, r101.subscribeConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.modelItemKey, r101.modelItemKey) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.conversationModeList, r101.conversationModeList) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.defaultConversationMode, r101.defaultConversationMode) == true) goto L41;
        return false;
    L41:
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
        String r107 = this.subTitleName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        DefaultReplyMenuItemIcon r110 = this.icon;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        DefaultReplyMenuItemIcon r113 = this.darkModeIcon;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<DefaultReplyMenuItemTag> r116 = this.tagList;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.selectedName;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        z1 r122 = this.subscribeConfig;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.modelItemKey;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        List<String> r128 = this.conversationModeList;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.defaultConversationMode;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
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
        return "DefaultReplyMenuItem(itemId=" + this.itemId + ", name=" + this.name + ", subTitleName=" + this.subTitleName + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", tagList=" + this.tagList + ", selectedName=" + this.selectedName + ", subscribeConfig=" + this.subscribeConfig + ", modelItemKey=" + this.modelItemKey + ", conversationModeList=" + this.conversationModeList + ", defaultConversationMode=" + this.defaultConversationMode + ')';
    }

    public final ModelItemIdentity getIdentity() {
        String r100 = this.modelItemKey;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L15;
        if (this.itemId != null) goto L15;
        return null;
    L15:
        return new ModelItemIdentity(this.modelItemKey, this.itemId);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
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

    public final DefaultReplyMenuItemIcon getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSelectedName() {
        return this.selectedName;
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

    public DefaultReplyMenuItem(Integer r100, String r101, String r102, DefaultReplyMenuItemIcon r103, DefaultReplyMenuItemIcon r104, List<DefaultReplyMenuItemTag> r105, String r106, z1 r107, String r108, List<String> r110, String r111) {
        this.itemId = r100;
        this.name = r101;
        this.subTitleName = r102;
        this.icon = r103;
        this.darkModeIcon = r104;
        this.tagList = r105;
        this.selectedName = r106;
        this.subscribeConfig = r107;
        this.modelItemKey = r108;
        this.conversationModeList = r110;
        this.defaultConversationMode = r111;
    }

    public /* synthetic */ DefaultReplyMenuItem(Integer r110, String r111, String r112, DefaultReplyMenuItemIcon r113, DefaultReplyMenuItemIcon r114, List r115, String r116, z1 r210, String r211, List r212, String r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 1) == 0) goto L5;
        Integer r100 = 0;
    L6:
        String r101 = "";
        if ((r214 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = "";
    L14:
        String r104 = null;
        if ((r214 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r105 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r106 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        List r107 = null;
    L27:
        if ((r214 & 64) != 0) goto L31;
        r101 = r116;
    L31:
        if ((r214 & 128) == 0) goto L33;
        z1 r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        List r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r104 = r213;
    L46:
        this(r100, r102, r103, r105, r106, r107, r101, r108, r117, r118, r104);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L25:
        r107 = r115;
        goto L27
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
        r100 = r110;
        goto L6
    }
}
