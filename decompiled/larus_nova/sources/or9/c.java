package or9;

import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J£\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\bHÆ\u0001J\u0013\u0010:\u001a\u00020\u00032\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\bHÖ\u0001J\t\u0010=\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0016\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0016\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0016\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0016\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0016\u0010\u0013\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0016\u0010\u0014\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001d¨\u0006>"}, d2 = {"Lcom/larus/platform/model/video/business/VideoFeedConfig;", "", "shouldRefreshFallsAfterSendMsg", "", "fallsTabImageOnlyAspectFixed", "fallsTabImageAspectRatio", "", "fallsTabRefreshInterval", "", "coldStartMessagingPagerLandingTab", "", "enterMessagingPagerLandingTab", "prefetchExpiredInterval", "fallsPreLoadMoreItemCount", "fallsLayoutPadding", "fallsLayoutBlurRadius", "fallsLayoutPaddingWcb", "fallsLayoutBlurRadiusWcb", "doubleTabLazyAttachMainTabComponent", "unreadReplaceInterval", "awemeContainerScrollThreshold", "<init>", "(ZZFILjava/lang/String;Ljava/lang/String;IIIFIFZII)V", "getShouldRefreshFallsAfterSendMsg", "()Z", "getFallsTabImageOnlyAspectFixed", "getFallsTabImageAspectRatio", "()F", "getFallsTabRefreshInterval", "()I", "getColdStartMessagingPagerLandingTab", "()Ljava/lang/String;", "getEnterMessagingPagerLandingTab", "getPrefetchExpiredInterval", "getFallsPreLoadMoreItemCount", "getFallsLayoutPadding", "getFallsLayoutBlurRadius", "getFallsLayoutPaddingWcb", "getFallsLayoutBlurRadiusWcb", "getDoubleTabLazyAttachMainTabComponent", "getUnreadReplaceInterval", "getAwemeContainerScrollThreshold", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("aweme_container_scroll_threshold")
    private final int awemeContainerScrollThreshold;

    @SerializedName("cold_start_messaging_pager_landing_tab")
    private final String coldStartMessagingPagerLandingTab;

    @SerializedName("double_tab_lazy_attach_main_tab_component")
    private final boolean doubleTabLazyAttachMainTabComponent;

    @SerializedName("enter_messaging_pager_landing_tab")
    private final String enterMessagingPagerLandingTab;

    @SerializedName("falls_layout_blur_radius")
    private final float fallsLayoutBlurRadius;

    @SerializedName("falls_layout_blur_radius_wcb")
    private final float fallsLayoutBlurRadiusWcb;

    @SerializedName("falls_layout_padding")
    private final int fallsLayoutPadding;

    @SerializedName("falls_layout_padding_wcb")
    private final int fallsLayoutPaddingWcb;

    @SerializedName("falls_pre_load_more_item_count")
    private final int fallsPreLoadMoreItemCount;

    @SerializedName("falls_tab_image_aspect_ratio")
    private final float fallsTabImageAspectRatio;

    @SerializedName("falls_tab_image_only_aspect_fixed")
    private final boolean fallsTabImageOnlyAspectFixed;

    @SerializedName("falls_tab_refresh_interval")
    private final int fallsTabRefreshInterval;

    @SerializedName("prefetch_expired_interval")
    private final int prefetchExpiredInterval;

    @SerializedName("should_refresh_falls_after_send_msg")
    private final boolean shouldRefreshFallsAfterSendMsg;

    @SerializedName("unread_replace_interval")
    private final int unreadReplaceInterval;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.shouldRefreshFallsAfterSendMsg == r101.shouldRefreshFallsAfterSendMsg) goto L12;
        return false;
    L12:
        if (this.fallsTabImageOnlyAspectFixed == r101.fallsTabImageOnlyAspectFixed) goto L15;
        return false;
    L15:
        if (Float.compare(this.fallsTabImageAspectRatio, r101.fallsTabImageAspectRatio) == 0) goto L18;
        return false;
    L18:
        if (this.fallsTabRefreshInterval == r101.fallsTabRefreshInterval) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.coldStartMessagingPagerLandingTab, r101.coldStartMessagingPagerLandingTab) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enterMessagingPagerLandingTab, r101.enterMessagingPagerLandingTab) == true) goto L27;
        return false;
    L27:
        if (this.prefetchExpiredInterval == r101.prefetchExpiredInterval) goto L30;
        return false;
    L30:
        if (this.fallsPreLoadMoreItemCount == r101.fallsPreLoadMoreItemCount) goto L33;
        return false;
    L33:
        if (this.fallsLayoutPadding == r101.fallsLayoutPadding) goto L36;
        return false;
    L36:
        if (Float.compare(this.fallsLayoutBlurRadius, r101.fallsLayoutBlurRadius) == 0) goto L39;
        return false;
    L39:
        if (this.fallsLayoutPaddingWcb == r101.fallsLayoutPaddingWcb) goto L42;
        return false;
    L42:
        if (Float.compare(this.fallsLayoutBlurRadiusWcb, r101.fallsLayoutBlurRadiusWcb) == 0) goto L45;
        return false;
    L45:
        if (this.doubleTabLazyAttachMainTabComponent == r101.doubleTabLazyAttachMainTabComponent) goto L48;
        return false;
    L48:
        if (this.unreadReplaceInterval == r101.unreadReplaceInterval) goto L51;
        return false;
    L51:
        if (this.awemeContainerScrollThreshold == r101.awemeContainerScrollThreshold) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.shouldRefreshFallsAfterSendMsg == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.fallsTabImageOnlyAspectFixed == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((((r102 + r103) * 31) + Float.floatToIntBits(this.fallsTabImageAspectRatio)) * 31) + this.fallsTabRefreshInterval) * 31;
        String r105 = this.coldStartMessagingPagerLandingTab;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        String r109 = this.enterMessagingPagerLandingTab;
        if (r109 == null) goto L18;
        r106 = r109.hashCode();
    L18:
        int r110 = (((((((((((((r108 + r106) * 31) + this.prefetchExpiredInterval) * 31) + this.fallsPreLoadMoreItemCount) * 31) + this.fallsLayoutPadding) * 31) + Float.floatToIntBits(this.fallsLayoutBlurRadius)) * 31) + this.fallsLayoutPaddingWcb) * 31) + Float.floatToIntBits(this.fallsLayoutBlurRadiusWcb)) * 31;
        if (this.doubleTabLazyAttachMainTabComponent == true) goto L23;
        r100 = 1237;
    L23:
        return ((((r110 + r100) * 31) + this.unreadReplaceInterval) * 31) + this.awemeContainerScrollThreshold;
    L13:
        r107 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VideoFeedConfig(shouldRefreshFallsAfterSendMsg=" + this.shouldRefreshFallsAfterSendMsg + ", fallsTabImageOnlyAspectFixed=" + this.fallsTabImageOnlyAspectFixed + ", fallsTabImageAspectRatio=" + this.fallsTabImageAspectRatio + ", fallsTabRefreshInterval=" + this.fallsTabRefreshInterval + ", coldStartMessagingPagerLandingTab=" + this.coldStartMessagingPagerLandingTab + ", enterMessagingPagerLandingTab=" + this.enterMessagingPagerLandingTab + ", prefetchExpiredInterval=" + this.prefetchExpiredInterval + ", fallsPreLoadMoreItemCount=" + this.fallsPreLoadMoreItemCount + ", fallsLayoutPadding=" + this.fallsLayoutPadding + ", fallsLayoutBlurRadius=" + this.fallsLayoutBlurRadius + ", fallsLayoutPaddingWcb=" + this.fallsLayoutPaddingWcb + ", fallsLayoutBlurRadiusWcb=" + this.fallsLayoutBlurRadiusWcb + ", doubleTabLazyAttachMainTabComponent=" + this.doubleTabLazyAttachMainTabComponent + ", unreadReplaceInterval=" + this.unreadReplaceInterval + ", awemeContainerScrollThreshold=" + this.awemeContainerScrollThreshold + ')';
    }

    public final int a() {
        return this.awemeContainerScrollThreshold;
    }

    public final float b() {
        return this.fallsLayoutBlurRadius;
    }

    public final float c() {
        return this.fallsLayoutBlurRadiusWcb;
    }

    public final int d() {
        return this.fallsLayoutPadding;
    }

    public final int e() {
        return this.fallsLayoutPaddingWcb;
    }

    public final int f() {
        return this.fallsPreLoadMoreItemCount;
    }

    public final float g() {
        return this.fallsTabImageAspectRatio;
    }

    public final boolean h() {
        return this.fallsTabImageOnlyAspectFixed;
    }

    public final int i() {
        return this.fallsTabRefreshInterval;
    }

    public final int j() {
        return this.prefetchExpiredInterval;
    }

    public c(int r100) {
        this.shouldRefreshFallsAfterSendMsg = false;
        this.fallsTabImageOnlyAspectFixed = false;
        this.fallsTabImageAspectRatio = 1.15f;
        this.fallsTabRefreshInterval = AnnouncementViewModel.HOUR_DURATION;
        this.coldStartMessagingPagerLandingTab = null;
        this.enterMessagingPagerLandingTab = null;
        this.prefetchExpiredInterval = AnnouncementViewModel.HOUR_DURATION;
        this.fallsPreLoadMoreItemCount = 8;
        this.fallsLayoutPadding = 5;
        this.fallsLayoutBlurRadius = 3.0f;
        this.fallsLayoutPaddingWcb = 12;
        this.fallsLayoutBlurRadiusWcb = 6.0f;
        this.doubleTabLazyAttachMainTabComponent = true;
        this.unreadReplaceInterval = 5;
        this.awemeContainerScrollThreshold = 120;
    }
}
