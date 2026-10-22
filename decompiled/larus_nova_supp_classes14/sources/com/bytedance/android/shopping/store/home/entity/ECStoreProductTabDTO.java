package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bP\u0010QR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u001c\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001c\u0010'\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0007R\u001c\u0010.\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b/\u0010!R\u001c\u00100\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010(\u001a\u0004\b1\u0010*R\"\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u0005\u001a\u0004\b4\u0010\u0007R(\u00106\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u0001058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R*\u0010;\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u0001058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u00107\u001a\u0004\b<\u00109R\u001c\u0010>\u001a\u0004\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010I\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010(\u001a\u0004\bJ\u0010*\"\u0004\bK\u0010LR$\u0010M\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010(\u001a\u0004\bN\u0010*\"\u0004\bO\u0010L¨\u0006R"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreProductTabDTO;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ec/store/repository/dto/k;", "goodTypes", "Ljava/util/List;", "getGoodTypes", "()Ljava/util/List;", "Lcom/bytedance/android/ec/store/repository/dto/m;", "sortTypes", "getSortTypes", "Lcom/bytedance/android/ec/store/repository/dto/l;", "products", "getProducts", "", "hasMore", "Z", "getHasMore", "()Z", "", "cursor", "J", "getCursor", "()J", "Lsj3/c;", "promotion", "Lsj3/c;", "getPromotion", "()Lsj3/c;", "", "layout", "Ljava/lang/Integer;", "getLayout", "()Ljava/lang/Integer;", "styleType", "getStyleType", "recommendModuleType", "getRecommendModuleType", "", "bottomModuleParams", "Ljava/lang/String;", "getBottomModuleParams", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/store/repository/dto/c;", "selectButtons", "getSelectButtons", "forceProductLayout", "getForceProductLayout", "toast", "getToast", "Lcom/bytedance/android/ec/store/repository/dto/g;", "pickTypes", "getPickTypes", "", "bizExtra", "Ljava/util/Map;", "getBizExtra", "()Ljava/util/Map;", "", "productVideoComponent", "getProductVideoComponent", "Lcom/bytedance/android/shopping/store/home/entity/ECShopHeadInfoBlock;", "productTabComponent", "Lcom/bytedance/android/shopping/store/home/entity/ECShopHeadInfoBlock;", "getProductTabComponent", "()Lcom/bytedance/android/shopping/store/home/entity/ECShopHeadInfoBlock;", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "hybridList", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "getHybridList", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "setHybridList", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;)V", "paginationParams", "getPaginationParams", "setPaginationParams", "(Ljava/lang/String;)V", "hybridParams", "getHybridParams", "setHybridParams", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreProductTabDTO implements Serializable {

    @SerializedName("biz_extra")
    private final Map<String, String> bizExtra;

    @SerializedName("bottom_module_params")
    private final String bottomModuleParams;

    @SerializedName("cursor")
    private final long cursor;

    @SerializedName("force_product_layout")
    private final Integer forceProductLayout;

    @SerializedName("good_types")
    private final List<com.bytedance.android.ec.store.repository.dto.k> goodTypes;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("hybrid_list")
    private ECHybridListDTO hybridList;

    @SerializedName("hybrid_params")
    private String hybridParams;

    @SerializedName("product_layout")
    private final Integer layout;

    @SerializedName("pagination_params")
    private String paginationParams;

    @SerializedName("pick_types")
    private final List<com.bytedance.android.ec.store.repository.dto.g> pickTypes;

    @SerializedName("product_tab_component")
    private final ECShopHeadInfoBlock productTabComponent;

    @SerializedName("product_video_component")
    private final Map<String, Object> productVideoComponent;

    @SerializedName("products")
    private final List<com.bytedance.android.ec.store.repository.dto.l> products;

    @SerializedName("promotion")
    private final sj3.c promotion;

    @SerializedName("bottom_module_type")
    private final Integer recommendModuleType;

    @SerializedName("select_buttons")
    private final List<com.bytedance.android.ec.store.repository.dto.c> selectButtons;

    @SerializedName("sort_types")
    private final List<com.bytedance.android.ec.store.repository.dto.m> sortTypes;

    @SerializedName("product_style_type")
    private final Integer styleType;

    @SerializedName("toast")
    private final String toast;

    public ECStoreProductTabDTO() {
    }

    public final Map<String, String> getBizExtra() {
        return this.bizExtra;
    }

    public final String getBottomModuleParams() {
        return this.bottomModuleParams;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final Integer getForceProductLayout() {
        return this.forceProductLayout;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.k> getGoodTypes() {
        return this.goodTypes;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final ECHybridListDTO getHybridList() {
        return this.hybridList;
    }

    public final String getHybridParams() {
        return this.hybridParams;
    }

    public final Integer getLayout() {
        return this.layout;
    }

    public final String getPaginationParams() {
        return this.paginationParams;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.g> getPickTypes() {
        return this.pickTypes;
    }

    public final ECShopHeadInfoBlock getProductTabComponent() {
        return this.productTabComponent;
    }

    public final Map<String, Object> getProductVideoComponent() {
        return this.productVideoComponent;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.l> getProducts() {
        return this.products;
    }

    public final sj3.c getPromotion() {
        return this.promotion;
    }

    public final Integer getRecommendModuleType() {
        return this.recommendModuleType;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.c> getSelectButtons() {
        return this.selectButtons;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.m> getSortTypes() {
        return this.sortTypes;
    }

    public final Integer getStyleType() {
        return this.styleType;
    }

    public final String getToast() {
        return this.toast;
    }

    public final void setHybridList(ECHybridListDTO r1) {
        this.hybridList = r1;
    }

    public final void setHybridParams(String r1) {
        this.hybridParams = r1;
    }

    public final void setPaginationParams(String r1) {
        this.paginationParams = r1;
    }
}
