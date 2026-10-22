package rd3;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.model.GuessULikeItemProductStruct;
import com.bytedance.android.shopping.feed.model.GuessULikeUserStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lrd3/i;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "Lcom/bytedance/android/shopping/feed/model/GuessULikeItemProductStruct;", "productStruct", "Lcom/bytedance/android/shopping/feed/model/GuessULikeItemProductStruct;", "getProductStruct", "()Lcom/bytedance/android/shopping/feed/model/GuessULikeItemProductStruct;", "Lcom/bytedance/android/shopping/feed/model/GuessULikeUserStruct;", "userStruct", "Lcom/bytedance/android/shopping/feed/model/GuessULikeUserStruct;", "getUserStruct", "()Lcom/bytedance/android/shopping/feed/model/GuessULikeUserStruct;", "", "requestId", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "promotion", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotion", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("product")
    private final GuessULikeItemProductStruct productStruct;

    @SerializedName("promotion")
    private final PromotionProductStruct promotion;

    @SerializedName("request_id")
    private String requestId;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("user")
    private final GuessULikeUserStruct userStruct;

    public static final class a {
    }

    static {
    }

    public i() {
    }

    public final Integer getType() {
        return this.type;
    }
}
