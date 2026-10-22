package j63;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AdInfoStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SeckillInfo;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardLiveStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardProductStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardUserStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.LynxCommonCard;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b1\u00102R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010(\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lj63/c;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/VOIdentifier;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardLiveStruct;", "liveStruct", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardLiveStruct;", "b", "()Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardLiveStruct;", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardProductStruct;", "productStruct", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardProductStruct;", "d", "()Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardProductStruct;", "Lcom/bytedance/android/ec/model/response/anchorv3/SeckillInfo;", "secKillActivity", "Lcom/bytedance/android/ec/model/response/anchorv3/SeckillInfo;", ce.f26391f, "()Lcom/bytedance/android/ec/model/response/anchorv3/SeckillInfo;", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardUserStruct;", "userStruct", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardUserStruct;", "getUserStruct", "()Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardUserStruct;", "", "requestId", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "promotion", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "e", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "Lcom/bytedance/android/ec/model/response/anchorv3/AdInfoStruct;", "adInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/AdInfoStruct;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/anchorv3/AdInfoStruct;", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/LynxCommonCard;", "lynxCommonCard", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/LynxCommonCard;", "c", "()Lcom/bytedance/android/shopping/anchorv3/guessulike/model/LynxCommonCard;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c extends VOIdentifier {

    @SerializedName("ad")
    private final AdInfoStruct adInfo;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f497513b;

    @SerializedName("live")
    private final ItemCardLiveStruct liveStruct;

    @SerializedName("lynx_common_card")
    private final LynxCommonCard lynxCommonCard;

    @SerializedName("product")
    private final ItemCardProductStruct productStruct;

    @SerializedName("promotion")
    private final PromotionProductStruct promotion;

    @SerializedName("request_id")
    private String requestId;

    @SerializedName("sec_kill_activity")
    private final SeckillInfo secKillActivity;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("user")
    private final ItemCardUserStruct userStruct;

    public static final class a {
    }

    static {
    }

    public final ECUrlModel f() {
        Integer r100 = this.type;
        if (r100 != null) goto L6;
    L28:
        ItemCardProductStruct r101 = this.productStruct;
        if (r101 != null) goto L31;
        return null;
    L31:
        return r101.getCover();
    L6:
        if (r100.intValue() != 2) goto L28;
        ItemCardProductStruct r102 = this.productStruct;
        if (r102 == null) goto L25;
        ECUrlModel r103 = r102.getCoverRecommend();
        if (r103 == null) goto L25;
        List<String> r104 = r103.getUrlList();
        if (r104 != null) goto L14;
    L17:
        boolean r105 = true;
    L19:
        if ((!r105) == true) goto L22;
        r103 = null;
    L22:
        if (r103 == null) goto L25;
        return r103;
    L14:
        if (r104.isEmpty() == true) goto L17;
        r105 = false;
    L25:
        ItemCardProductStruct r106 = this.productStruct;
        if (r106 != null) goto L34;
        return null;
    L34:
        return r106.getCover();
    }

    public final String h() {
        ECUrlModel r100 = f();
        ItemCardProductStruct r101 = this.productStruct;
        if (r101 == null) goto L5;
        ECUrlModel r102 = r101.getCoverRecommend();
    L7:
        if (Intrinsics.areEqual(r100, r102) == false) goto L9;
        return "1";
    L9:
        return "0";
    L5:
        r102 = null;
        goto L7
    }

    public c() {
    }

    public final AdInfoStruct a() {
        return this.adInfo;
    }

    public final ItemCardLiveStruct b() {
        return this.liveStruct;
    }

    public final LynxCommonCard c() {
        return this.lynxCommonCard;
    }

    public final ItemCardProductStruct d() {
        return this.productStruct;
    }

    public final PromotionProductStruct e() {
        return this.promotion;
    }

    public final SeckillInfo g() {
        return this.secKillActivity;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setRequestId(String r100) {
        this.requestId = r100;
    }
}
