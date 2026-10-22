package com.bytedance.android.shopping.store.tabkit.mixframe;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR,\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R,\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/mixframe/ECTabKitMixFrameResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "bizConfig", "Lcom/bytedance/android/shopping/store/tabkit/mixframe/BizConfig;", "getBizConfig", "()Lcom/bytedance/android/shopping/store/tabkit/mixframe/BizConfig;", "setBizConfig", "(Lcom/bytedance/android/shopping/store/tabkit/mixframe/BizConfig;)V", "cursor", "", "getCursor", "()J", "setCursor", "(J)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "hybridList", "Lcom/bytedance/android/shopping/store/moments/dto/HybridListDTO;", "getHybridList", "()Lcom/bytedance/android/shopping/store/moments/dto/HybridListDTO;", "setHybridList", "(Lcom/bytedance/android/shopping/store/moments/dto/HybridListDTO;)V", "logExtra", "", "", "getLogExtra", "()Ljava/util/Map;", "setLogExtra", "(Ljava/util/Map;)V", "passThroughParams", "getPassThroughParams", "setPassThroughParams", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitMixFrameResponse extends CommerceBaseResponse {

    @SerializedName("biz_config")
    private BizConfig bizConfig;

    @SerializedName("cursor")
    private long cursor;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("hybrid_list")
    private HybridListDTO hybridList;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    @SerializedName("pass_through_params")
    private Map<String, String> passThroughParams;

    public ECTabKitMixFrameResponse() {
    }

    public final BizConfig getBizConfig() {
        return this.bizConfig;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final HybridListDTO getHybridList() {
        return this.hybridList;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final Map<String, String> getPassThroughParams() {
        return this.passThroughParams;
    }

    public final void setBizConfig(BizConfig r1) {
        this.bizConfig = r1;
    }

    public final void setCursor(long r1) {
        this.cursor = r1;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setHybridList(HybridListDTO r1) {
        this.hybridList = r1;
    }

    public final void setLogExtra(Map<String, String> r1) {
        this.logExtra = r1;
    }

    public final void setPassThroughParams(Map<String, String> r1) {
        this.passThroughParams = r1;
    }
}
