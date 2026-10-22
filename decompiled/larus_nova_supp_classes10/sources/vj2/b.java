package vj2;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.ec.model.live.ECPromotionListTopData;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.b1;
import com.bytedance.android.ec.model.response.w;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionListABConfig;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageBottomData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageCategoryData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageDynamicOpenRegion;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageHeaderData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageHintData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageListTop;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import mj2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\b¢\u0006\u0005\b\u0099\u0001\u0010'R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R*\u0010#\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b#\u0010\u001b\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR*\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR*\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR*\u0010.\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\"\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007R\"\u00105\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u00106\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010[\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010b\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR$\u0010i\u001a\u0004\u0018\u00010h8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010p\u001a\u0004\u0018\u00010o8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010w\u001a\u0004\u0018\u00010v8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R(\u0010~\u001a\u0004\u0018\u00010}8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R,\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R,\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R*\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001¨\u0006\u009a\u0001"}, d2 = {"Lvj2/b;", "Lcom/bytedance/android/ec/model/g;", "", "Lcom/bytedance/android/ec/model/response/ECPromotion;", "promotionList", "Ljava/util/List;", "l", "()Ljava/util/List;", "setPromotionList", "(Ljava/util/List;)V", "Lcom/bytedance/android/ec/model/response/w;", "promotionListV2", "m", "setPromotionListV2", "targetPromotion", "getTargetPromotion", "setTargetPromotion", "targetPromotionV2", "r", "setTargetPromotionV2", "topPromotion", "Lcom/bytedance/android/ec/model/response/ECPromotion;", "getTopPromotion", "()Lcom/bytedance/android/ec/model/response/ECPromotion;", "setTopPromotion", "(Lcom/bytedance/android/ec/model/response/ECPromotion;)V", "topPromotionV2", "Lcom/bytedance/android/ec/model/response/w;", "s", "()Lcom/bytedance/android/ec/model/response/w;", "setTopPromotionV2", "(Lcom/bytedance/android/ec/model/response/w;)V", "relatedPromotion", "getRelatedPromotion", "setRelatedPromotion", "relatedPromotionV2", "o", "setRelatedPromotionV2", "getRelatedPromotionV2$annotations", "()V", "relatedPromotionsV2", "p", "setRelatedPromotionsV2", "recommendPromotions", "getRecommendPromotions", "setRecommendPromotions", "recommendPromotionsV2", "n", "setRecommendPromotionsV2", "Lrl/a;", "dynamicSlots", "e", "", LBSLightLocationTraceLogger.TOTAL, "I", "t", "()I", "setTotal", "(I)V", "nextOffset", "i", "setNextOffset", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageRoomInfo;", "roomInfo", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageRoomInfo;", "q", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageRoomInfo;", "setRoomInfo", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageRoomInfo;)V", "Lmj2/f;", "pageSkin", "Lmj2/f;", "j", "()Lmj2/f;", "setPageSkin", "(Lmj2/f;)V", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionListABConfig;", "abConfig", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionListABConfig;", "a", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionListABConfig;", "setAbConfig", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionListABConfig;)V", "Lcom/bytedance/android/ec/model/live/ECPromotionListTopData;", "vibeData", "Lcom/bytedance/android/ec/model/live/ECPromotionListTopData;", "u", "()Lcom/bytedance/android/ec/model/live/ECPromotionListTopData;", "setVibeData", "(Lcom/bytedance/android/ec/model/live/ECPromotionListTopData;)V", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageHeaderData;", "headerData", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageHeaderData;", "f", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageHeaderData;", "setHeaderData", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageHeaderData;)V", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageHintData;", "hintData", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageHintData;", "g", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageHintData;", "setHintData", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageHintData;)V", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageCategoryData;", "categoryData", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageCategoryData;", "c", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageCategoryData;", "setCategoryData", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageCategoryData;)V", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageBottomData;", "bottomData", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageBottomData;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageBottomData;", "setBottomData", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageBottomData;)V", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageListTop;", "listTop", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageListTop;", "h", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageListTop;", "setListTop", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageListTop;)V", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageDynamicOpenRegion;", "dynamicOpenRegion", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageDynamicOpenRegion;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageDynamicOpenRegion;", "setDynamicOpenRegion", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageDynamicOpenRegion;)V", "Lcom/bytedance/android/ec/model/response/b1;", "promotionLayout", "Lcom/bytedance/android/ec/model/response/b1;", "k", "()Lcom/bytedance/android/ec/model/response/b1;", "setPromotionLayout", "(Lcom/bytedance/android/ec/model/response/b1;)V", "", "requestLogId", "Ljava/lang/String;", "getRequestLogId", "()Ljava/lang/String;", "setRequestLogId", "(Ljava/lang/String;)V", "", "serverTime", "J", "getServerTime", "()J", "setServerTime", "(J)V", "<init>", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends g {

    @SerializedName("page_ab_config")
    private LivePromotionListABConfig abConfig;

    @SerializedName("page_bottom")
    private LivePromotionPageBottomData bottomData;

    @SerializedName("page_category")
    private LivePromotionPageCategoryData categoryData;

    @SerializedName("list_dynamic_open_region")
    private LivePromotionPageDynamicOpenRegion dynamicOpenRegion;

    @SerializedName("dynamic_slots")
    private final List<rl.a> dynamicSlots;

    @SerializedName("page_header")
    private LivePromotionPageHeaderData headerData;

    @SerializedName("page_hint")
    private LivePromotionPageHintData hintData;

    @SerializedName("list_top")
    private LivePromotionPageListTop listTop;

    @SerializedName("next_offset")
    private int nextOffset;

    @SerializedName("page_skin")
    private f pageSkin;

    @SerializedName("promotion_layout")
    private b1 promotionLayout;

    @SerializedName("promotions")
    private List<? extends ECPromotion> promotionList;

    @SerializedName("promotions_v2")
    private List<w> promotionListV2;

    @SerializedName("recommend_promotions")
    private List<? extends ECPromotion> recommendPromotions;

    @SerializedName("recommend_promotions_v2")
    private List<w> recommendPromotionsV2;

    @SerializedName("related_promotion")
    private ECPromotion relatedPromotion;

    @SerializedName("related_promotion_v2")
    private w relatedPromotionV2;

    @SerializedName("related_promotions_v2")
    private List<w> relatedPromotionsV2;

    @SerializedName("log_id")
    private String requestLogId;

    @SerializedName("page_room_info")
    private LivePromotionPageRoomInfo roomInfo;

    @SerializedName("server_time")
    private long serverTime;

    @SerializedName("target_promotions")
    private List<? extends ECPromotion> targetPromotion;

    @SerializedName("target_promotions_v2")
    private List<w> targetPromotionV2;

    @SerializedName("top_promotion")
    private ECPromotion topPromotion;

    @SerializedName("top_promotion_v2")
    private w topPromotionV2;

    @SerializedName(LBSLightLocationTraceLogger.TOTAL)
    private int total;

    @SerializedName("page_vibe")
    private ECPromotionListTopData vibeData;

    public final String getLogId() {
        String r0 = a2.d(this.requestLogId);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.getLogId();
    }

    public final boolean v() {
        List<w> r0 = this.promotionListV2;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isEmpty() == true) goto L8;
        return false;
    }

    public b() {
    }

    public final LivePromotionListABConfig a() {
        return this.abConfig;
    }

    public final LivePromotionPageBottomData b() {
        return this.bottomData;
    }

    public final LivePromotionPageCategoryData c() {
        return this.categoryData;
    }

    public final LivePromotionPageDynamicOpenRegion d() {
        return this.dynamicOpenRegion;
    }

    public final List<rl.a> e() {
        return this.dynamicSlots;
    }

    public final LivePromotionPageHeaderData f() {
        return this.headerData;
    }

    public final LivePromotionPageHintData g() {
        return this.hintData;
    }

    public final LivePromotionPageListTop h() {
        return this.listTop;
    }

    public final int i() {
        return this.nextOffset;
    }

    public final f j() {
        return this.pageSkin;
    }

    public final b1 k() {
        return this.promotionLayout;
    }

    public final List<ECPromotion> l() {
        return this.promotionList;
    }

    public final List<w> m() {
        return this.promotionListV2;
    }

    public final List<w> n() {
        return this.recommendPromotionsV2;
    }

    public final w o() {
        return this.relatedPromotionV2;
    }

    public final List<w> p() {
        return this.relatedPromotionsV2;
    }

    public final LivePromotionPageRoomInfo q() {
        return this.roomInfo;
    }

    public final List<w> r() {
        return this.targetPromotionV2;
    }

    public final w s() {
        return this.topPromotionV2;
    }

    public final int t() {
        return this.total;
    }

    public final ECPromotionListTopData u() {
        return this.vibeData;
    }

    public final void w(b r2) {
        if (r2 == null) goto L5;
        this.promotionList = r2.promotionList;
        this.promotionListV2 = r2.promotionListV2;
        this.nextOffset = r2.nextOffset;
        return;
    }
}
