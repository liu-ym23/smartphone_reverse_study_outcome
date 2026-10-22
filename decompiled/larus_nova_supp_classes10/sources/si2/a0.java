package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2DelayParam;
import com.bytedance.android.livesdk.livecommerce.model.ECV2OpenPriceTriggerInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopMsgProductInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.LivePopMessage")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lsi2/a0;", "Lsg2/a;", "", "msgType", "I", "bubbleType", "", "promotionId", "J", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2DelayParam;", "delayParam", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2DelayParam;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopMsgProductInfo;", "productInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopMsgProductInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2OpenPriceTriggerInfo;", "openPriceTriggerInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2OpenPriceTriggerInfo;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 extends sg2.a {

    @SerializedName("bubble_type")
    public int bubbleType;

    @SerializedName("delay_param")
    public ECV2DelayParam delayParam;

    @SerializedName("msg_type")
    public int msgType;

    @SerializedName("open_price_trigger_info")
    public ECV2OpenPriceTriggerInfo openPriceTriggerInfo;

    @SerializedName("product_info")
    public ECV2PopMsgProductInfo productInfo;

    @SerializedName("promotion_id")
    public long promotionId;

    @Override // sg2.a
    public final String toJsonString() {
        return new Gson().toJson(this);
    L5:
        return toString();
    }

    public a0() {
    }
}
