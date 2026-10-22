package xi2;

import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class k extends com.bytedance.android.ec.model.g {

    @SerializedName("campaigns")
    public List<ECPromotionCampaign> campaignList;

    @SerializedName("server_time")
    public long serverTime;

    public k() {
    }
}
