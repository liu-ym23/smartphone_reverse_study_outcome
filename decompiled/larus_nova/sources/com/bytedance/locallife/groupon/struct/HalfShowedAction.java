package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/HalfShowedAction;", "", "liveWindowAction", "Lcom/bytedance/locallife/groupon/struct/NearbyLiveWindowStruct;", "stayFeedPlay", "", "(Lcom/bytedance/locallife/groupon/struct/NearbyLiveWindowStruct;Ljava/lang/Integer;)V", "getLiveWindowAction", "()Lcom/bytedance/locallife/groupon/struct/NearbyLiveWindowStruct;", "getStayFeedPlay", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Lcom/bytedance/locallife/groupon/struct/NearbyLiveWindowStruct;Ljava/lang/Integer;)Lcom/bytedance/locallife/groupon/struct/HalfShowedAction;", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class HalfShowedAction {

    @SerializedName("live_screen")
    private final NearbyLiveWindowStruct liveWindowAction;

    @SerializedName("stay_feed_play")
    private final Integer stayFeedPlay;

    /* JADX WARN: Multi-variable type inference failed */
    public HalfShowedAction() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HalfShowedAction copy$default(HalfShowedAction r100, NearbyLiveWindowStruct r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.liveWindowAction;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.stayFeedPlay;
    L9:
        return r100.copy(r101, r102);
    }

    public final NearbyLiveWindowStruct component1() {
        return this.liveWindowAction;
    }

    public final Integer component2() {
        return this.stayFeedPlay;
    }

    public final HalfShowedAction copy(NearbyLiveWindowStruct r100, Integer r101) {
        return new HalfShowedAction(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HalfShowedAction) == true) goto L8;
        return false;
    L8:
        HalfShowedAction r101 = (HalfShowedAction) r100;
        if (Intrinsics.areEqual(this.liveWindowAction, r101.liveWindowAction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stayFeedPlay, r101.stayFeedPlay) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        NearbyLiveWindowStruct r100 = this.liveWindowAction;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.stayFeedPlay;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "HalfShowedAction(liveWindowAction=" + this.liveWindowAction + ", stayFeedPlay=" + this.stayFeedPlay + ')';
    }

    public final NearbyLiveWindowStruct getLiveWindowAction() {
        return this.liveWindowAction;
    }

    public final Integer getStayFeedPlay() {
        return this.stayFeedPlay;
    }

    public HalfShowedAction(NearbyLiveWindowStruct r100, Integer r101) {
        this.liveWindowAction = r100;
        this.stayFeedPlay = r101;
    }

    public /* synthetic */ HalfShowedAction(NearbyLiveWindowStruct r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
