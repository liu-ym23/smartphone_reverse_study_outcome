package si2;

import com.bytedance.android.livesdk.livecommerce.model.AtmosphereInfo;
import com.bytedance.android.livesdk.livecommerce.model.AuctionAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ProductInfo;
import com.bytedance.android.livesdk.livecommerce.model.RequestInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.ProductRefreshMessage")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lsi2/e0;", "Lsg2/a;", "", "promotionId", "J", "channelType", RemoteMessageConst.Notification.CHANNEL_ID, "", ReportConstant.COMMON_ACTION_TYPE, "I", "Lcom/bytedance/android/livesdk/livecommerce/model/RequestInfo;", "requestInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/RequestInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ProductInfo;", "productInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ProductInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2HotAtmosphere;", "hotAtmosphere", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2HotAtmosphere;", "Lcom/bytedance/android/livesdk/livecommerce/model/AuctionInfo;", "auctionInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/AuctionInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/AuctionAtmosphere;", "auctionAtmosphere", "Lcom/bytedance/android/livesdk/livecommerce/model/AuctionAtmosphere;", "Lcom/bytedance/android/livesdk/livecommerce/model/AtmosphereInfo;", "atmosphereInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/AtmosphereInfo;", "updateTs", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 extends sg2.a {

    @SerializedName("action_type")
    public int actionType;

    @SerializedName("atmosphere_info")
    public AtmosphereInfo atmosphereInfo;

    @SerializedName("auction_atmosphere")
    public AuctionAtmosphere auctionAtmosphere;

    @SerializedName("auction_info")
    public AuctionInfo auctionInfo;

    @SerializedName("channel_id")
    public long channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    public long channelType;

    @SerializedName("hot_atmosphere")
    public ECV2HotAtmosphere hotAtmosphere;

    @SerializedName("product_info")
    public ProductInfo productInfo;

    @SerializedName("promotion_id")
    public long promotionId;

    @SerializedName("request_info")
    public RequestInfo requestInfo;

    @SerializedName("update_ts")
    public long updateTs;

    @Override // sg2.a
    public final String toJsonString() {
        return new Gson().toJson(this);
    L5:
        return toString();
    }

    public e0() {
    }
}
