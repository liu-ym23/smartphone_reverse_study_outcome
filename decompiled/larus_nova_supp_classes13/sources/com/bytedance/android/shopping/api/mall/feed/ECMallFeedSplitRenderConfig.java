package com.bytedance.android.shopping.api.mall.feed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010$J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J\u001f\u0010&\u001a\u0004\u0018\u00010\u00102\b\u0010'\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020\u0004¢\u0006\u0002\u0010(R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R,\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\u001eR,\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000e¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/feed/ECMallFeedSplitRenderConfig;", "Ljava/io/Serializable;", "()V", "cachePendingRenderEnable", "", "getCachePendingRenderEnable", "()Z", "cacheSizeMap", "", "", "", "getCacheSizeMap", "()Ljava/util/Map;", "setCacheSizeMap", "(Ljava/util/Map;)V", "combinedCardType", "", "getCombinedCardType", "()I", "setCombinedCardType", "(I)V", "pendingRenderCardTypes", "", "getPendingRenderCardTypes", "()Ljava/util/List;", "pendingRenderEnable", "getPendingRenderEnable", "secondaryDataPostImmediately", "getSecondaryDataPostImmediately", "setSecondaryDataPostImmediately", "(Z)V", "sizeMap", "getSizeMap", "setSizeMap", "isPendingRenderCardTypeMatch", "cardType", "(Ljava/lang/Integer;)Z", "isCache", "sizeOf", "pageName", "(Ljava/lang/String;Z)Ljava/lang/Integer;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallFeedSplitRenderConfig implements Serializable {

    @SerializedName("cache_pending_render_enable")
    private final boolean cachePendingRenderEnable;

    @SerializedName("cache_size_map")
    private Map<String, ? extends Object> cacheSizeMap;

    @SerializedName("combined_card_type")
    private int combinedCardType;

    @SerializedName("pending_render_card_types")
    private final List<Integer> pendingRenderCardTypes;

    @SerializedName("pending_render_enable")
    private final boolean pendingRenderEnable;

    @SerializedName("secondary_data_post_immediately")
    private boolean secondaryDataPostImmediately;

    @SerializedName("size_map")
    private Map<String, ? extends Object> sizeMap;

    public ECMallFeedSplitRenderConfig() {
        this.secondaryDataPostImmediately = true;
        this.combinedCardType = 51019;
    }

    public final boolean getCachePendingRenderEnable() {
        return this.cachePendingRenderEnable;
    }

    public final Map<String, Object> getCacheSizeMap() {
        return this.cacheSizeMap;
    }

    public final int getCombinedCardType() {
        return this.combinedCardType;
    }

    public final List<Integer> getPendingRenderCardTypes() {
        return this.pendingRenderCardTypes;
    }

    public final boolean getPendingRenderEnable() {
        return this.pendingRenderEnable;
    }

    public final boolean getSecondaryDataPostImmediately() {
        return this.secondaryDataPostImmediately;
    }

    public final Map<String, Object> getSizeMap() {
        return this.sizeMap;
    }

    public final boolean isPendingRenderCardTypeMatch(Integer r4) {
        if (r4 == null) goto L16;
        r4.intValue();
        List<Integer> r1 = this.pendingRenderCardTypes;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
    L14:
        return true;
    L13:
        if (this.pendingRenderCardTypes.contains(r4) == true) goto L14;
        return false;
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
        goto L11
    L16:
        return false;
    }

    public final boolean pendingRenderEnable(boolean r1) {
        if (r1 == false) goto L5;
        return this.cachePendingRenderEnable;
    L5:
        return this.pendingRenderEnable;
    }

    public final void setCacheSizeMap(Map<String, ? extends Object> r1) {
        this.cacheSizeMap = r1;
    }

    public final void setCombinedCardType(int r1) {
        this.combinedCardType = r1;
    }

    public final void setSecondaryDataPostImmediately(boolean r1) {
        this.secondaryDataPostImmediately = r1;
    }

    public final void setSizeMap(Map<String, ? extends Object> r1) {
        this.sizeMap = r1;
    }

    public final Integer sizeOf(String r5, boolean r6) {
        if (r6 == false) goto L4;
        Map<String, ? extends Object> r7 = this.cacheSizeMap;
    L6:
        if (r7 == null) goto L36;
        boolean r2 = true;
        if ((!r7.isEmpty()) == false) goto L10;
        Map<String, ? extends Object> r1 = r7;
    L11:
        if (r1 == null) goto L39;
        if (r5 != null) goto L15;
        return null;
    L15:
        if (r5.length() <= 0) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L20;
        String r4 = r5;
    L21:
        if (r4 == null) goto L40;
        Object r8 = r7.get(r5);
        if ((r8 instanceof Number) == true) goto L26;
        r8 = null;
    L26:
        Number r9 = (Number) r8;
        if (r9 != null) goto L29;
        return null;
    L29:
        Integer r10 = Integer.valueOf(r9.intValue());
        if (r10.intValue() > 0) goto L33;
        r2 = false;
    L33:
        if (r2 == true) goto L35;
        return null;
    L35:
        return r10;
    L40:
        return null;
    L20:
        r4 = null;
        goto L21
    L17:
        r3 = false;
        goto L18
    L39:
        return null;
    L10:
        r1 = null;
        goto L11
    L36:
        return null;
    L4:
        r7 = this.sizeMap;
        goto L6
    }
}
