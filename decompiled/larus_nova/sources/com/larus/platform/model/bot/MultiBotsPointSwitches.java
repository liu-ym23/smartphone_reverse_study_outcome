package com.larus.platform.model.bot;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jm\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\nHÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006,"}, d2 = {"Lcom/larus/platform/model/bot/MultiBotsPointSwitches;", "", "hideSidebarBotAsset", "", "hideBottomTabDiscovery", "disableBotCreateEntry", "hideCreatePermissionEntry", "disableBotDescPolish", "hideProfileBotTab", "profileBotTabVisibility", "", "disableBotShare", "disableBotLinkLanding", "disableBotLikeCommentActionbar", "<init>", "(ZZZZZZIZZZ)V", "getHideSidebarBotAsset", "()Z", "getHideBottomTabDiscovery", "getDisableBotCreateEntry", "getHideCreatePermissionEntry", "getDisableBotDescPolish", "getHideProfileBotTab", "getProfileBotTabVisibility", "()I", "getDisableBotShare", "getDisableBotLinkLanding", "getDisableBotLikeCommentActionbar", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiBotsPointSwitches {

    @SerializedName("disable_bot_create_entry")
    private final boolean disableBotCreateEntry;

    @SerializedName("disable_bot_desc_polish")
    private final boolean disableBotDescPolish;

    @SerializedName("disable_bot_like_comment_actionbar")
    private final boolean disableBotLikeCommentActionbar;

    @SerializedName("disable_bot_link_landing")
    private final boolean disableBotLinkLanding;

    @SerializedName("disable_bot_share")
    private final boolean disableBotShare;

    @SerializedName("hide_bottom_tab_discovery")
    private final boolean hideBottomTabDiscovery;

    @SerializedName("hide_create_permission_entry")
    private final boolean hideCreatePermissionEntry;

    @SerializedName("hide_profile_bot_tab")
    private final boolean hideProfileBotTab;

    @SerializedName("hide_sidebar_bot_asset")
    private final boolean hideSidebarBotAsset;

    @SerializedName("profile_bot_tab_visibility")
    private final int profileBotTabVisibility;

    public MultiBotsPointSwitches() {
        this(false, false, false, false, false, false, 0, false, false, false, 1023, null);
    }

    public static /* synthetic */ MultiBotsPointSwitches copy$default(MultiBotsPointSwitches r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, int r117, boolean r118, boolean r210, boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        boolean r100 = r110.hideSidebarBotAsset;
    L7:
        if ((r212 & 2) == 0) goto L9;
        boolean r101 = r110.hideBottomTabDiscovery;
    L11:
        if ((r212 & 4) == 0) goto L13;
        boolean r102 = r110.disableBotCreateEntry;
    L15:
        if ((r212 & 8) == 0) goto L17;
        boolean r103 = r110.hideCreatePermissionEntry;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r104 = r110.disableBotDescPolish;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r105 = r110.hideProfileBotTab;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r106 = r110.profileBotTabVisibility;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r107 = r110.disableBotShare;
    L35:
        if ((r212 & 256) == 0) goto L37;
        boolean r119 = r110.disableBotLinkLanding;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r108 = r110.disableBotLikeCommentActionbar;
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

    public final boolean component1() {
        return this.hideSidebarBotAsset;
    }

    public final boolean component10() {
        return this.disableBotLikeCommentActionbar;
    }

    public final boolean component2() {
        return this.hideBottomTabDiscovery;
    }

    public final boolean component3() {
        return this.disableBotCreateEntry;
    }

    public final boolean component4() {
        return this.hideCreatePermissionEntry;
    }

    public final boolean component5() {
        return this.disableBotDescPolish;
    }

    public final boolean component6() {
        return this.hideProfileBotTab;
    }

    public final int component7() {
        return this.profileBotTabVisibility;
    }

    public final boolean component8() {
        return this.disableBotShare;
    }

    public final boolean component9() {
        return this.disableBotLinkLanding;
    }

    public final MultiBotsPointSwitches copy(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, int r116, boolean r210, boolean r211, boolean r212) {
        return new MultiBotsPointSwitches(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MultiBotsPointSwitches) == true) goto L8;
        return false;
    L8:
        MultiBotsPointSwitches r101 = (MultiBotsPointSwitches) r100;
        if (this.hideSidebarBotAsset == r101.hideSidebarBotAsset) goto L12;
        return false;
    L12:
        if (this.hideBottomTabDiscovery == r101.hideBottomTabDiscovery) goto L15;
        return false;
    L15:
        if (this.disableBotCreateEntry == r101.disableBotCreateEntry) goto L18;
        return false;
    L18:
        if (this.hideCreatePermissionEntry == r101.hideCreatePermissionEntry) goto L21;
        return false;
    L21:
        if (this.disableBotDescPolish == r101.disableBotDescPolish) goto L24;
        return false;
    L24:
        if (this.hideProfileBotTab == r101.hideProfileBotTab) goto L27;
        return false;
    L27:
        if (this.profileBotTabVisibility == r101.profileBotTabVisibility) goto L30;
        return false;
    L30:
        if (this.disableBotShare == r101.disableBotShare) goto L33;
        return false;
    L33:
        if (this.disableBotLinkLanding == r101.disableBotLinkLanding) goto L36;
        return false;
    L36:
        if (this.disableBotLikeCommentActionbar == r101.disableBotLikeCommentActionbar) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.hideSidebarBotAsset == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.hideBottomTabDiscovery == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.disableBotCreateEntry == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.hideCreatePermissionEntry == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.disableBotDescPolish == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.hideProfileBotTab == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (((r110 + r111) * 31) + this.profileBotTabVisibility) * 31;
        if (this.disableBotShare == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.disableBotLinkLanding == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (r114 + r115) * 31;
        if (this.disableBotLikeCommentActionbar == true) goto L39;
        r100 = 1237;
    L39:
        return r116 + r100;
    L33:
        r115 = 1237;
        goto L34
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "MultiBotsPointSwitches(hideSidebarBotAsset=" + this.hideSidebarBotAsset + ", hideBottomTabDiscovery=" + this.hideBottomTabDiscovery + ", disableBotCreateEntry=" + this.disableBotCreateEntry + ", hideCreatePermissionEntry=" + this.hideCreatePermissionEntry + ", disableBotDescPolish=" + this.disableBotDescPolish + ", hideProfileBotTab=" + this.hideProfileBotTab + ", profileBotTabVisibility=" + this.profileBotTabVisibility + ", disableBotShare=" + this.disableBotShare + ", disableBotLinkLanding=" + this.disableBotLinkLanding + ", disableBotLikeCommentActionbar=" + this.disableBotLikeCommentActionbar + ')';
    }

    public final boolean getDisableBotCreateEntry() {
        return this.disableBotCreateEntry;
    }

    public final boolean getDisableBotDescPolish() {
        return this.disableBotDescPolish;
    }

    public final boolean getDisableBotLikeCommentActionbar() {
        return this.disableBotLikeCommentActionbar;
    }

    public final boolean getDisableBotLinkLanding() {
        return this.disableBotLinkLanding;
    }

    public final boolean getDisableBotShare() {
        return this.disableBotShare;
    }

    public final boolean getHideBottomTabDiscovery() {
        return this.hideBottomTabDiscovery;
    }

    public final boolean getHideCreatePermissionEntry() {
        return this.hideCreatePermissionEntry;
    }

    public final boolean getHideProfileBotTab() {
        return this.hideProfileBotTab;
    }

    public final boolean getHideSidebarBotAsset() {
        return this.hideSidebarBotAsset;
    }

    public final int getProfileBotTabVisibility() {
        return this.profileBotTabVisibility;
    }

    public MultiBotsPointSwitches(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, int r106, boolean r107, boolean r108, boolean r110) {
        this.hideSidebarBotAsset = r100;
        this.hideBottomTabDiscovery = r101;
        this.disableBotCreateEntry = r102;
        this.hideCreatePermissionEntry = r103;
        this.disableBotDescPolish = r104;
        this.hideProfileBotTab = r105;
        this.profileBotTabVisibility = r106;
        this.disableBotShare = r107;
        this.disableBotLinkLanding = r108;
        this.disableBotLikeCommentActionbar = r110;
    }

    public /* synthetic */ MultiBotsPointSwitches(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, int r116, boolean r117, boolean r210, boolean r211, int r212, DefaultConstructorMarker r213) {
        boolean r100 = true;
        if ((r212 & 1) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r212 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r212 & 4) == 0) goto L13;
        boolean r103 = true;
    L15:
        if ((r212 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r106 = true;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r107 = 2;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r108 = true;
    L35:
        if ((r212 & 256) == 0) goto L37;
        boolean r118 = true;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
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
