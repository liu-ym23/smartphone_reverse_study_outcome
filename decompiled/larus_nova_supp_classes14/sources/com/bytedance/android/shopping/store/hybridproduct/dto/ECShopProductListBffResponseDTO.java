package com.bytedance.android.shopping.store.hybridproduct.dto;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R,\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR \u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010&\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopProductListBffResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "bizExtra", "", "", "getBizExtra", "()Ljava/util/Map;", "setBizExtra", "(Ljava/util/Map;)V", "cursor", "", "getCursor", "()J", "setCursor", "(J)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "hybridList", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "getHybridList", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "setHybridList", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;)V", "isDynamicInsert", "setDynamicInsert", "logExtra", "getLogExtra", "setLogExtra", "paginationParams", "getPaginationParams", "()Ljava/lang/String;", "setPaginationParams", "(Ljava/lang/String;)V", "toast", "getToast", "setToast", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopProductListBffResponseDTO extends CommerceBaseResponse {

    @SerializedName("biz_extra")
    private Map<String, String> bizExtra;

    @SerializedName("cursor")
    private long cursor;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("hybrid_list")
    private ECHybridListDTO hybridList;
    private boolean isDynamicInsert;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    @SerializedName("pagination_params")
    private String paginationParams;

    @SerializedName("toast")
    private String toast;

    public ECShopProductListBffResponseDTO() {
    }

    public final Map<String, String> getBizExtra() {
        return this.bizExtra;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final ECHybridListDTO getHybridList() {
        return this.hybridList;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final String getPaginationParams() {
        return this.paginationParams;
    }

    public final String getToast() {
        return this.toast;
    }

    public final boolean isDynamicInsert() {
        return this.isDynamicInsert;
    }

    public final void setBizExtra(Map<String, String> r1) {
        this.bizExtra = r1;
    }

    public final void setCursor(long r1) {
        this.cursor = r1;
    }

    public final void setDynamicInsert(boolean r1) {
        this.isDynamicInsert = r1;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setHybridList(ECHybridListDTO r1) {
        this.hybridList = r1;
    }

    public final void setLogExtra(Map<String, String> r1) {
        this.logExtra = r1;
    }

    public final void setPaginationParams(String r1) {
        this.paginationParams = r1;
    }

    public final void setToast(String r1) {
        this.toast = r1;
    }
}
