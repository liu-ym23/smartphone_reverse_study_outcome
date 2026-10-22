package com.bytedance.locallife.groupon.struct.tabnotice;

import com.bytedance.locallife.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/tabnotice/TabNoticeResponse;", "Lcom/bytedance/locallife/model/response/BaseResponse;", "groupon_feed_insert_cards", "Lcom/bytedance/locallife/groupon/struct/tabnotice/GrouponFeedInsertCards;", "serverLatency", "", "(Lcom/bytedance/locallife/groupon/struct/tabnotice/GrouponFeedInsertCards;Ljava/lang/String;)V", "getGroupon_feed_insert_cards", "()Lcom/bytedance/locallife/groupon/struct/tabnotice/GrouponFeedInsertCards;", "getServerLatency", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TabNoticeResponse extends BaseResponse {

    @SerializedName("groupon_feed_insert_cards")
    private final GrouponFeedInsertCards groupon_feed_insert_cards;

    @SerializedName("server_latency")
    private final String serverLatency;

    /* JADX WARN: Multi-variable type inference failed */
    public TabNoticeResponse() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TabNoticeResponse copy$default(TabNoticeResponse r100, GrouponFeedInsertCards r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.groupon_feed_insert_cards;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.serverLatency;
    L9:
        return r100.copy(r101, r102);
    }

    public final GrouponFeedInsertCards component1() {
        return this.groupon_feed_insert_cards;
    }

    public final String component2() {
        return this.serverLatency;
    }

    public final TabNoticeResponse copy(GrouponFeedInsertCards r100, String r101) {
        return new TabNoticeResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TabNoticeResponse) == true) goto L8;
        return false;
    L8:
        TabNoticeResponse r101 = (TabNoticeResponse) r100;
        if (Intrinsics.areEqual(this.groupon_feed_insert_cards, r101.groupon_feed_insert_cards) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.serverLatency, r101.serverLatency) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        GrouponFeedInsertCards r100 = this.groupon_feed_insert_cards;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.serverLatency;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    @Override // com.bytedance.locallife.model.response.BaseResponse
    public String toString() {
        return "TabNoticeResponse(groupon_feed_insert_cards=" + this.groupon_feed_insert_cards + ", serverLatency=" + this.serverLatency + ')';
    }

    public final GrouponFeedInsertCards getGroupon_feed_insert_cards() {
        return this.groupon_feed_insert_cards;
    }

    public final String getServerLatency() {
        return this.serverLatency;
    }

    public TabNoticeResponse(GrouponFeedInsertCards r100, String r101) {
        this.groupon_feed_insert_cards = r100;
        this.serverLatency = r101;
    }

    public /* synthetic */ TabNoticeResponse(GrouponFeedInsertCards r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
