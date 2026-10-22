package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2BidInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ECV2InteractionData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCampaignInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCommentaryVideoInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCouponInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedGroupInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedProductInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedSkuInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Deprecated(message = "use live.ProductRefreshMessage instead")
@ProtoMessage("live.ProductUpdateMessage")
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lsi2/f0;", "Lsg2/a;", "", "", "productIds", "Ljava/util/List;", "", "updateType", "I", "", "soldOut", "Z", "canSold", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedProductInfo;", "productInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedProductInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedCouponInfo;", "couponInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedCouponInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedCampaignInfo;", "campaignInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedCampaignInfo;", "timeStamp", "J", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedSkuInfo;", "updatedSkuInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedSkuInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedCommentaryVideoInfo;", "updatedCommentaryVideoInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedCommentaryVideoInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedGroupInfo;", "updatedGroupInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedGroupInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2HotAtmosphere;", "hotAtmosphere", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2HotAtmosphere;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData;", "promotionHeaderInteraction", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2BidInfo;", "bidInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2BidInfo;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f0 extends sg2.a {

    @SerializedName("bid_info")
    public ECV2BidInfo bidInfo;

    @SerializedName("updated_campaign_info")
    public ECV2UpdatedCampaignInfo campaignInfo;

    @SerializedName("can_sold")
    public boolean canSold;

    @SerializedName("updated_coupon_info")
    public ECV2UpdatedCouponInfo couponInfo;

    @SerializedName("hot_atmosphere")
    public ECV2HotAtmosphere hotAtmosphere;

    @SerializedName("updated_product_ids")
    public List<Long> productIds;

    @SerializedName("updated_product_info")
    public ECV2UpdatedProductInfo productInfo;

    @SerializedName("promotion_header_interaction")
    public ECV2InteractionData promotionHeaderInteraction;

    @SerializedName("sold_out")
    public boolean soldOut;

    @SerializedName("update_timestamp")
    public long timeStamp;

    @SerializedName("update_type")
    public int updateType;

    @SerializedName("updated_commentary_video_info")
    public ECV2UpdatedCommentaryVideoInfo updatedCommentaryVideoInfo;

    @SerializedName("updated_group_info")
    public ECV2UpdatedGroupInfo updatedGroupInfo;

    @SerializedName("update_sku_info")
    public ECV2UpdatedSkuInfo updatedSkuInfo;

    @Override // sg2.a
    public final String toJsonString() {
        return new Gson().toJson(this);
    L5:
        return toString();
    }

    public f0() {
    }
}
