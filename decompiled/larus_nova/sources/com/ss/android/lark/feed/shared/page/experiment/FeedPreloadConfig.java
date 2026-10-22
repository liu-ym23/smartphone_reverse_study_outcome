package com.ss.android.lark.feed.shared.page.experiment;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003JY\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\rR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/experiment/FeedPreloadConfig;", "", "isPreloadAtFeedPrefetch", "", "isPreloadAtNotification", "isPreloadAtShorts", "isPreloadAtFilter", "isPreloadAtFlag", "isPreloadAtTabClick", "isPreloadPriorityEnabled", "isPreloadInterruptable", "<init>", "(ZZZZZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedPreloadConfig {

    @SerializedName("is_preload_at_feed_prefetch")
    private final boolean isPreloadAtFeedPrefetch;

    @SerializedName("is_preload_at_filter")
    private final boolean isPreloadAtFilter;

    @SerializedName("is_preload_at_flag")
    private final boolean isPreloadAtFlag;

    @SerializedName("is_preload_at_notification")
    private final boolean isPreloadAtNotification;

    @SerializedName("is_preload_at_shorts")
    private final boolean isPreloadAtShorts;

    @SerializedName("is_preload_at_tab_click")
    private final boolean isPreloadAtTabClick;

    @SerializedName("is_preload_interruptable")
    private final boolean isPreloadInterruptable;

    @SerializedName("is_preload_priority_enabled")
    private final boolean isPreloadPriorityEnabled;

    public FeedPreloadConfig() {
        this(false, false, false, false, false, false, false, false, 255, null);
    }

    public static /* synthetic */ FeedPreloadConfig copy$default(FeedPreloadConfig r100, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = r100.isPreloadAtFeedPrefetch;
    L7:
        if ((r118 & 2) == 0) goto L9;
        boolean r102 = r100.isPreloadAtNotification;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r103 = r100.isPreloadAtShorts;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.isPreloadAtFilter;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.isPreloadAtFlag;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = r100.isPreloadAtTabClick;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = r100.isPreloadPriorityEnabled;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.isPreloadInterruptable;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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

    public final boolean component1() {
        return this.isPreloadAtFeedPrefetch;
    }

    public final boolean component2() {
        return this.isPreloadAtNotification;
    }

    public final boolean component3() {
        return this.isPreloadAtShorts;
    }

    public final boolean component4() {
        return this.isPreloadAtFilter;
    }

    public final boolean component5() {
        return this.isPreloadAtFlag;
    }

    public final boolean component6() {
        return this.isPreloadAtTabClick;
    }

    public final boolean component7() {
        return this.isPreloadPriorityEnabled;
    }

    public final boolean component8() {
        return this.isPreloadInterruptable;
    }

    public final FeedPreloadConfig copy(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117) {
        return new FeedPreloadConfig(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedPreloadConfig) == true) goto L8;
        return false;
    L8:
        FeedPreloadConfig r101 = (FeedPreloadConfig) r100;
        if (this.isPreloadAtFeedPrefetch == r101.isPreloadAtFeedPrefetch) goto L12;
        return false;
    L12:
        if (this.isPreloadAtNotification == r101.isPreloadAtNotification) goto L15;
        return false;
    L15:
        if (this.isPreloadAtShorts == r101.isPreloadAtShorts) goto L18;
        return false;
    L18:
        if (this.isPreloadAtFilter == r101.isPreloadAtFilter) goto L21;
        return false;
    L21:
        if (this.isPreloadAtFlag == r101.isPreloadAtFlag) goto L24;
        return false;
    L24:
        if (this.isPreloadAtTabClick == r101.isPreloadAtTabClick) goto L27;
        return false;
    L27:
        if (this.isPreloadPriorityEnabled == r101.isPreloadPriorityEnabled) goto L30;
        return false;
    L30:
        if (this.isPreloadInterruptable == r101.isPreloadInterruptable) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isPreloadAtFeedPrefetch == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isPreloadAtNotification == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.isPreloadAtShorts == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.isPreloadAtFilter == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.isPreloadAtFlag == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.isPreloadAtTabClick == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.isPreloadPriorityEnabled == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.isPreloadInterruptable == true) goto L35;
        r100 = 1237;
    L35:
        return r114 + r100;
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
        return "FeedPreloadConfig(isPreloadAtFeedPrefetch=" + this.isPreloadAtFeedPrefetch + ", isPreloadAtNotification=" + this.isPreloadAtNotification + ", isPreloadAtShorts=" + this.isPreloadAtShorts + ", isPreloadAtFilter=" + this.isPreloadAtFilter + ", isPreloadAtFlag=" + this.isPreloadAtFlag + ", isPreloadAtTabClick=" + this.isPreloadAtTabClick + ", isPreloadPriorityEnabled=" + this.isPreloadPriorityEnabled + ", isPreloadInterruptable=" + this.isPreloadInterruptable + ')';
    }

    public final boolean isPreloadAtFeedPrefetch() {
        return this.isPreloadAtFeedPrefetch;
    }

    public final boolean isPreloadAtFilter() {
        return this.isPreloadAtFilter;
    }

    public final boolean isPreloadAtFlag() {
        return this.isPreloadAtFlag;
    }

    public final boolean isPreloadAtNotification() {
        return this.isPreloadAtNotification;
    }

    public final boolean isPreloadAtShorts() {
        return this.isPreloadAtShorts;
    }

    public final boolean isPreloadAtTabClick() {
        return this.isPreloadAtTabClick;
    }

    public final boolean isPreloadInterruptable() {
        return this.isPreloadInterruptable;
    }

    public final boolean isPreloadPriorityEnabled() {
        return this.isPreloadPriorityEnabled;
    }

    public FeedPreloadConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        this.isPreloadAtFeedPrefetch = r100;
        this.isPreloadAtNotification = r101;
        this.isPreloadAtShorts = r102;
        this.isPreloadAtFilter = r103;
        this.isPreloadAtFlag = r104;
        this.isPreloadAtTabClick = r105;
        this.isPreloadPriorityEnabled = r106;
        this.isPreloadInterruptable = r107;
    }

    public /* synthetic */ FeedPreloadConfig(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, int r118, DefaultConstructorMarker r119) {
        boolean r100 = false;
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r118 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = false;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
