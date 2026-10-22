package du9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006&"}, d2 = {"Lcom/larus/settings/provider/chat/ChatNavigatorConfig;", "", "hasUnreadCount", "", "navigatorSimplify", "mainBotUseDrawerBack", "showSearchEntrance", "showRealtimeCallEntrance", "showMoreEntrance", "badgeStyle", "", "enableSideBarRedDot", "<init>", "(ZZZZZZIZ)V", "getHasUnreadCount", "()Z", "getNavigatorSimplify", "getMainBotUseDrawerBack", "getShowSearchEntrance", "getShowRealtimeCallEntrance", "getShowMoreEntrance", "getBadgeStyle", "()I", "getEnableSideBarRedDot", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class w {

    @SerializedName("badge_style")
    private final int badgeStyle;

    @SerializedName("enable_side_bar_unread_count")
    private final boolean enableSideBarRedDot;

    @SerializedName("has_unread_count")
    private final boolean hasUnreadCount;

    @SerializedName("main_bot_use_drawer_back")
    private final boolean mainBotUseDrawerBack;

    @SerializedName("navigator_simplify")
    private final boolean navigatorSimplify;

    @SerializedName("show_more_entrance")
    private final boolean showMoreEntrance;

    @SerializedName("show_realtime_call_entrance")
    private final boolean showRealtimeCallEntrance;

    @SerializedName("show_search_entrance")
    private final boolean showSearchEntrance;

    public w() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (this.hasUnreadCount == r101.hasUnreadCount) goto L12;
        return false;
    L12:
        if (this.navigatorSimplify == r101.navigatorSimplify) goto L15;
        return false;
    L15:
        if (this.mainBotUseDrawerBack == r101.mainBotUseDrawerBack) goto L18;
        return false;
    L18:
        if (this.showSearchEntrance == r101.showSearchEntrance) goto L21;
        return false;
    L21:
        if (this.showRealtimeCallEntrance == r101.showRealtimeCallEntrance) goto L24;
        return false;
    L24:
        if (this.showMoreEntrance == r101.showMoreEntrance) goto L27;
        return false;
    L27:
        if (this.badgeStyle == r101.badgeStyle) goto L30;
        return false;
    L30:
        if (this.enableSideBarRedDot == r101.enableSideBarRedDot) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.hasUnreadCount == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.navigatorSimplify == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.mainBotUseDrawerBack == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.showSearchEntrance == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.showRealtimeCallEntrance == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.showMoreEntrance == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (((r110 + r111) * 31) + this.badgeStyle) * 31;
        if (this.enableSideBarRedDot == true) goto L31;
        r100 = 1237;
    L31:
        return r112 + r100;
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

    public final String toString() {
        return "ChatNavigatorConfig(hasUnreadCount=" + this.hasUnreadCount + ", navigatorSimplify=" + this.navigatorSimplify + ", mainBotUseDrawerBack=" + this.mainBotUseDrawerBack + ", showSearchEntrance=" + this.showSearchEntrance + ", showRealtimeCallEntrance=" + this.showRealtimeCallEntrance + ", showMoreEntrance=" + this.showMoreEntrance + ", badgeStyle=" + this.badgeStyle + ", enableSideBarRedDot=" + this.enableSideBarRedDot + ')';
    }

    public final int a() {
        return this.badgeStyle;
    }

    public final boolean b() {
        return this.enableSideBarRedDot;
    }

    public final boolean c() {
        return this.hasUnreadCount;
    }

    public final boolean d() {
        return this.mainBotUseDrawerBack;
    }

    public final boolean e() {
        return this.navigatorSimplify;
    }

    public final boolean f() {
        return this.showMoreEntrance;
    }

    public final boolean g() {
        return this.showRealtimeCallEntrance;
    }

    public final boolean h() {
        return this.showSearchEntrance;
    }

    public w(int r100) {
        this.hasUnreadCount = true;
        this.navigatorSimplify = true;
        this.mainBotUseDrawerBack = false;
        this.showSearchEntrance = false;
        this.showRealtimeCallEntrance = true;
        this.showMoreEntrance = false;
        this.badgeStyle = 0;
        this.enableSideBarRedDot = false;
    }
}
