package com.ss.android.lark.feed.shared.page.experiment;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/experiment/FeedGCFragmentConfigValue;", "", "enableGCFeedFragment", "", "maxRetainedCount", "", "retainedFirstFilter", "<init>", "(ZIZ)V", "getEnableGCFeedFragment", "()Z", "getMaxRetainedCount", "()I", "getRetainedFirstFilter", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedGCFragmentConfigValue {

    @SerializedName("enable_gc_feed_fragment")
    private final boolean enableGCFeedFragment;

    @SerializedName("max_retained_count")
    private final int maxRetainedCount;

    @SerializedName("retained_first_filter")
    private final boolean retainedFirstFilter;

    public FeedGCFragmentConfigValue() {
        this(false, 0, false, 7, null);
    }

    public static /* synthetic */ FeedGCFragmentConfigValue copy$default(FeedGCFragmentConfigValue r100, boolean r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enableGCFeedFragment;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.maxRetainedCount;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.retainedFirstFilter;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.enableGCFeedFragment;
    }

    public final int component2() {
        return this.maxRetainedCount;
    }

    public final boolean component3() {
        return this.retainedFirstFilter;
    }

    public final FeedGCFragmentConfigValue copy(boolean r100, int r101, boolean r102) {
        return new FeedGCFragmentConfigValue(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedGCFragmentConfigValue) == true) goto L8;
        return false;
    L8:
        FeedGCFragmentConfigValue r101 = (FeedGCFragmentConfigValue) r100;
        if (this.enableGCFeedFragment == r101.enableGCFeedFragment) goto L12;
        return false;
    L12:
        if (this.maxRetainedCount == r101.maxRetainedCount) goto L15;
        return false;
    L15:
        if (this.retainedFirstFilter == r101.retainedFirstFilter) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableGCFeedFragment == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.maxRetainedCount) * 31;
        if (this.retainedFirstFilter == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "FeedGCFragmentConfigValue(enableGCFeedFragment=" + this.enableGCFeedFragment + ", maxRetainedCount=" + this.maxRetainedCount + ", retainedFirstFilter=" + this.retainedFirstFilter + ')';
    }

    public final boolean getEnableGCFeedFragment() {
        return this.enableGCFeedFragment;
    }

    public final int getMaxRetainedCount() {
        return this.maxRetainedCount;
    }

    public final boolean getRetainedFirstFilter() {
        return this.retainedFirstFilter;
    }

    public FeedGCFragmentConfigValue(boolean r100, int r101, boolean r102) {
        this.enableGCFeedFragment = r100;
        this.maxRetainedCount = r101;
        this.retainedFirstFilter = r102;
    }

    public /* synthetic */ FeedGCFragmentConfigValue(boolean r100, int r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
