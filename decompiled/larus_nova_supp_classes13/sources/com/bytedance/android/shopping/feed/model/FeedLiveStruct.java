package com.bytedance.android.shopping.feed.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001d\u0010\u000fR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u0018\u0010$\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013R\u001a\u0010&\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0013R\u0018\u0010-\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0013R\u001a\u0010/\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b0\u0010\u000fR\u0018\u00101\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0013¨\u00063"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/FeedLiveStruct;", "Ljava/io/Serializable;", "()V", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "extra", "", "", "getExtra", "()Ljava/util/Map;", "likeCount", "", "getLikeCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "link", "getLink", "()Ljava/lang/String;", "linkWithProduct", "getLinkWithProduct", "liveDescription", "getLiveDescription", "liveIcon", "getLiveIcon", "number", "getNumber", "productCount", "getProductCount", "recReason", "Lcom/bytedance/android/shopping/feed/model/RecReason;", "getRecReason", "()Lcom/bytedance/android/shopping/feed/model/RecReason;", "roomId", "getRoomId", "secUid", "getSecUid", "status", "", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "streamData", "getStreamData", "title", "getTitle", "totalNumber", "getTotalNumber", "uid", "getUid", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedLiveStruct implements Serializable {

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("like_count")
    private final Long likeCount;

    @SerializedName("link")
    private final String link;

    @SerializedName("link_with_product")
    private final String linkWithProduct;

    @SerializedName("live_description")
    private final String liveDescription;

    @SerializedName("live_icon")
    private final ECUrlModel liveIcon;

    @SerializedName("number")
    private final Long number;

    @SerializedName("product_count")
    private final Long productCount;

    @SerializedName("rec_reason")
    private final RecReason recReason;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("stream_data")
    private final String streamData;

    @SerializedName("title")
    private final String title;

    @SerializedName("total_number")
    private final Long totalNumber;

    @SerializedName("uid")
    private final String uid;

    public FeedLiveStruct() {
    }

    public final ECUrlModel getCover() {
        return this.cover;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final Long getLikeCount() {
        return this.likeCount;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getLinkWithProduct() {
        return this.linkWithProduct;
    }

    public final String getLiveDescription() {
        return this.liveDescription;
    }

    public final ECUrlModel getLiveIcon() {
        return this.liveIcon;
    }

    public final Long getNumber() {
        return this.number;
    }

    public final Long getProductCount() {
        return this.productCount;
    }

    public final RecReason getRecReason() {
        return this.recReason;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getStreamData() {
        return this.streamData;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getTotalNumber() {
        return this.totalNumber;
    }

    public final String getUid() {
        return this.uid;
    }
}
