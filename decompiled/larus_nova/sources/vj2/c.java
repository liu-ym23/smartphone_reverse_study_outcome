package vj2;

import com.bytedance.android.ec.model.g;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.w;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lvj2/c;", "Lcom/bytedance/android/ec/model/g;", "", "Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", ReportCardMonitorPlugin.CATEGORIES, "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/response/ECPromotion;", "promotion", "Lcom/bytedance/android/ec/model/response/ECPromotion;", "c", "()Lcom/bytedance/android/ec/model/response/ECPromotion;", "Lcom/bytedance/android/ec/model/response/w;", "promotionV2", "Lcom/bytedance/android/ec/model/response/w;", "d", "()Lcom/bytedance/android/ec/model/response/w;", "", "serverTime", "J", "getServerTime", "()J", "", "apiLogId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c extends g {

    @SerializedName("log_id")
    private final String apiLogId;

    @SerializedName(ReportCardMonitorPlugin.CATEGORIES)
    private final List<PromotionCategory> categories;

    @SerializedName("promotion")
    private final ECPromotion promotion;

    @SerializedName("promotion_v2")
    private final w promotionV2;

    @SerializedName("server_time")
    private final long serverTime;

    public c() {
    }

    public final String a() {
        return this.apiLogId;
    }

    public final List<PromotionCategory> b() {
        return this.categories;
    }

    public final ECPromotion c() {
        return this.promotion;
    }

    public final w d() {
        return this.promotionV2;
    }
}
