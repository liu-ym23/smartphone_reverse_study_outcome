package si2;

import com.bytedance.android.livesdk.livecommerce.model.EndTimeRefreshInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.AuctionUpdateMessage")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000b¨\u0006\u0013"}, d2 = {"Lsi2/a;", "Lsg2/a;", "", "productId", "J", "auctionId", "", ReportConstant.COMMON_ACTION_TYPE, "I", "", "jumpSchema", "Ljava/lang/String;", "Lcom/bytedance/android/livesdk/livecommerce/model/EndTimeRefreshInfo;", "endTimeRefreshInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/EndTimeRefreshInfo;", "priceRefreshInfo", "preBidRefreshInfo", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends sg2.a {

    @SerializedName("action_type")
    public int actionType;

    @SerializedName("auction_id")
    public long auctionId;

    @SerializedName("end_time_refresh_info")
    public EndTimeRefreshInfo endTimeRefreshInfo;

    @SerializedName("jump_schema")
    public String jumpSchema;

    @SerializedName("pre_bid_refresh_info")
    public String preBidRefreshInfo;

    @SerializedName("price_refresh_info")
    public String priceRefreshInfo;

    @SerializedName("product_id")
    public long productId;

    @Override // sg2.a
    public final String toJsonString() {
        return new Gson().toJson(this);
    L5:
        return toString();
    }

    public a() {
    }
}
