package com.bytedance.android.shopping.feed.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/feed/model/FeedVideoStruct;", "Ljava/io/Serializable;", "()V", "addr", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getAddr", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "getCover", "extra", "", "", "getExtra", "()Ljava/util/Map;", "id", "getId", "()Ljava/lang/String;", "itemId", "getItemId", "link", "getLink", "linkWithProduct", "getLinkWithProduct", "recReason", "Lcom/bytedance/android/shopping/feed/model/RecReason;", "getRecReason", "()Lcom/bytedance/android/shopping/feed/model/RecReason;", "seconds", "", "getSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "uid", "getUid", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedVideoStruct implements Serializable {

    @SerializedName("addr")
    private final ECUrlModel addr;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("id")
    private final String id;

    @SerializedName(PdpOpenThirdParam.KEY_ITEM_ID)
    private final String itemId;

    @SerializedName("link")
    private final String link;

    @SerializedName("link_with_product")
    private final String linkWithProduct;

    @SerializedName("rec_reason")
    private final RecReason recReason;

    @SerializedName("seconds")
    private final Long seconds;

    @SerializedName("uid")
    private final String uid;

    public FeedVideoStruct() {
    }

    public final ECUrlModel getAddr() {
        return this.addr;
    }

    public final ECUrlModel getCover() {
        return this.cover;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getId() {
        return this.id;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getLinkWithProduct() {
        return this.linkWithProduct;
    }

    public final RecReason getRecReason() {
        return this.recReason;
    }

    public final Long getSeconds() {
        return this.seconds;
    }

    public final String getUid() {
        return this.uid;
    }
}
