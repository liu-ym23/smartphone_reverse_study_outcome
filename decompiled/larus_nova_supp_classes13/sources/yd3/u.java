package yd3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lyd3/u;", "Lyd3/l;", "", "authorId", "Ljava/lang/String;", "getAuthorId", "()Ljava/lang/String;", "setAuthorId", "(Ljava/lang/String;)V", "authorName", "d", "Lcom/bytedance/android/ec/model/ECUrlModel;", "authorAvatar", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "windowInterest", "g", "", "followStatus", "Z", "e", "()Z", "", "Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", "promotions", "Ljava/util/List;", "f", "()Ljava/util/List;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u extends l {

    @SerializedName("author_avatar")
    private final ECUrlModel authorAvatar;

    @SerializedName("author_id")
    private String authorId;

    @SerializedName("author_name")
    private final String authorName;

    @SerializedName(PdpOpenThirdParam.KEY_FOLLOW_STATUS)
    private final boolean followStatus;

    @SerializedName("promotions")
    private final List<Promotion> promotions;

    @SerializedName("window_interest")
    private final String windowInterest;

    public u() {
    }

    public final ECUrlModel c() {
        return this.authorAvatar;
    }

    public final String d() {
        return this.authorName;
    }

    public final boolean e() {
        return this.followStatus;
    }

    public final List<Promotion> f() {
        return this.promotions;
    }

    public final String g() {
        return this.windowInterest;
    }
}
