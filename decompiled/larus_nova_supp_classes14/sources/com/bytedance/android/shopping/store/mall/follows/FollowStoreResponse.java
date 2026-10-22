package com.bytedance.android.shopping.store.mall.follows;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.bytedance.android.shopping.store.moments.dto.ItemDTO;
import com.bytedance.android.shopping.store.moments.dto.SectionDTO;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00104\u001a\u00020\u0012R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u001a\u0010\"\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u001a\u0010$\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R,\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR \u0010)\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R,\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\b\"\u0004\b0\u0010\nR\u001a\u00101\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/FollowStoreResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "bizConfig", "", "", "", "getBizConfig", "()Ljava/util/Map;", "setBizConfig", "(Ljava/util/Map;)V", "cursor", "", "getCursor", "()J", "setCursor", "(J)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "hybridList", "Lcom/bytedance/android/shopping/store/moments/dto/HybridListDTO;", "getHybridList", "()Lcom/bytedance/android/shopping/store/moments/dto/HybridListDTO;", "setHybridList", "(Lcom/bytedance/android/shopping/store/moments/dto/HybridListDTO;)V", "initFetch", "getInitFetch", "setInitFetch", "isCache", "setCache", "isFeCache", "setFeCache", "isFirstFrame", "setFirstFrame", "logExtra", "getLogExtra", "setLogExtra", "noFollowFeedToast", "getNoFollowFeedToast", "()Ljava/lang/String;", "setNoFollowFeedToast", "(Ljava/lang/String;)V", "passThroughParams", "getPassThroughParams", "setPassThroughParams", "requestAfterCache", "getRequestAfterCache", "setRequestAfterCache", "isListEmpty", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FollowStoreResponse extends CommerceBaseResponse {

    @SerializedName("biz_config")
    private Map<String, ? extends Object> bizConfig;

    @SerializedName("cursor")
    private long cursor;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("hybrid_list")
    private HybridListDTO hybridList;
    private boolean initFetch;
    private boolean isCache;
    private boolean isFeCache;
    private boolean isFirstFrame;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    @SerializedName("no_follow_feed_toast")
    private String noFollowFeedToast;

    @SerializedName("pass_through_params")
    private Map<String, String> passThroughParams;
    private boolean requestAfterCache;

    public final boolean isListEmpty() {
        HybridListDTO r0 = this.hybridList;
        ArrayList<ItemDTO> r3 = null;
        if (r0 == null) goto L14;
        List<SectionDTO> r1 = r0.getSections();
        if (r1 == null) goto L14;
        if ((!r1.isEmpty()) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L14;
        SectionDTO r2 = (SectionDTO) ListProtector.get(r1, 0);
        if (r2 == null) goto L14;
        r3 = r2.getItems();
    L14:
        if (r3 != null) goto L16;
    L17:
        return true;
    L16:
        if (r3.isEmpty() == true) goto L17;
        return false;
    }

    public FollowStoreResponse() {
    }

    public final Map<String, Object> getBizConfig() {
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

    public final boolean getInitFetch() {
        return this.initFetch;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final String getNoFollowFeedToast() {
        return this.noFollowFeedToast;
    }

    public final Map<String, String> getPassThroughParams() {
        return this.passThroughParams;
    }

    public final boolean getRequestAfterCache() {
        return this.requestAfterCache;
    }

    public final boolean isCache() {
        return this.isCache;
    }

    public final boolean isFeCache() {
        return this.isFeCache;
    }

    public final boolean isFirstFrame() {
        return this.isFirstFrame;
    }

    public final void setBizConfig(Map<String, ? extends Object> r1) {
        this.bizConfig = r1;
    }

    public final void setCache(boolean r1) {
        this.isCache = r1;
    }

    public final void setCursor(long r1) {
        this.cursor = r1;
    }

    public final void setFeCache(boolean r1) {
        this.isFeCache = r1;
    }

    public final void setFirstFrame(boolean r1) {
        this.isFirstFrame = r1;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setHybridList(HybridListDTO r1) {
        this.hybridList = r1;
    }

    public final void setInitFetch(boolean r1) {
        this.initFetch = r1;
    }

    public final void setLogExtra(Map<String, String> r1) {
        this.logExtra = r1;
    }

    public final void setNoFollowFeedToast(String r1) {
        this.noFollowFeedToast = r1;
    }

    public final void setPassThroughParams(Map<String, String> r1) {
        this.passThroughParams = r1;
    }

    public final void setRequestAfterCache(boolean r1) {
        this.requestAfterCache = r1;
    }
}
