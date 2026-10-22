package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionSuccess;
import com.bytedance.android.livesdk.livecommerce.model.ECV2CouponInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2LotteryInfoList;
import com.bytedance.android.livesdk.livecommerce.model.ECV2RedpackActivityInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2TaskInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2WinLotteryInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.LiveMarketingMessage")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lsi2/z;", "Lsg2/a;", "", "msgType", "I", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionSuccess;", "auctionSuccess", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionSuccess;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionInfo;", "auctionInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2RedpackActivityInfo;", "redpackActivityInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2RedpackActivityInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2WinLotteryInfo;", "winLotteryInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2WinLotteryInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2LotteryInfoList;", "lotteryInfoList", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2LotteryInfoList;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2CouponInfo;", "couponInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2CouponInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2TaskInfo;", "taskInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2TaskInfo;", "", "", "productIds", "Ljava/util/List;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z extends sg2.a {

    @SerializedName("auction_info")
    public ECV2AuctionInfo auctionInfo;

    @SerializedName("auction_success")
    public ECV2AuctionSuccess auctionSuccess;

    @SerializedName("coupon_info")
    public ECV2CouponInfo couponInfo;

    @SerializedName("lottery_info_list")
    public ECV2LotteryInfoList lotteryInfoList;

    @SerializedName("msg_type")
    public int msgType;

    @SerializedName("product_ids")
    public List<Long> productIds;

    @SerializedName("redpack_activity_info")
    public ECV2RedpackActivityInfo redpackActivityInfo;

    @SerializedName("task_info")
    public ECV2TaskInfo taskInfo;

    @SerializedName("win_lotteryinfo")
    public ECV2WinLotteryInfo winLotteryInfo;

    @Override // sg2.a
    public final String toJsonString() {
        return new Gson().toJson(this);
    L5:
        return toString();
    }

    public z() {
        this.msgType = 4;
    }
}
