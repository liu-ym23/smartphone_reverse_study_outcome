package com.bytedance.android.shopping.api.ultimate;

import com.bytedance.android.ec.model.sku.SkuParams;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000eR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyParams;", "Ljava/io/Serializable;", "orderExParams", "Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyOrderExParams;", "skuExParams", "", "", "", "ultimateBuyType", "", "isSingleSku", "skuParams", "Lcom/bytedance/android/ec/model/sku/SkuParams;", "ultimateBuyVersion", "(Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyOrderExParams;Ljava/util/Map;IILcom/bytedance/android/ec/model/sku/SkuParams;Ljava/lang/Integer;)V", "()I", "getOrderExParams", "()Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyOrderExParams;", "getSkuExParams", "()Ljava/util/Map;", "setSkuExParams", "(Ljava/util/Map;)V", "getSkuParams", "()Lcom/bytedance/android/ec/model/sku/SkuParams;", "getUltimateBuyType", "getUltimateBuyVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class UltimateBuyParams implements Serializable {

    @SerializedName("is_single_sku")
    private final int isSingleSku;

    @SerializedName("order_ex_params")
    private final UltimateBuyOrderExParams orderExParams;

    @SerializedName("sku_ex_params")
    private Map<String, Object> skuExParams;

    @SerializedName("sku_params")
    private final SkuParams skuParams;

    @SerializedName("ultimate_buy_type")
    private final int ultimateBuyType;

    @SerializedName("ultimate_buy_version")
    private final Integer ultimateBuyVersion;

    public final UltimateBuyOrderExParams getOrderExParams() {
        return this.orderExParams;
    }

    public final Map<String, Object> getSkuExParams() {
        return this.skuExParams;
    }

    public final SkuParams getSkuParams() {
        return this.skuParams;
    }

    public final int getUltimateBuyType() {
        return this.ultimateBuyType;
    }

    public final Integer getUltimateBuyVersion() {
        return this.ultimateBuyVersion;
    }

    public final int isSingleSku() {
        return this.isSingleSku;
    }

    public final void setSkuExParams(Map<String, Object> r1) {
        this.skuExParams = r1;
    }

    public UltimateBuyParams(UltimateBuyOrderExParams r1, Map<String, Object> r2, int r3, int r4, SkuParams r5, Integer r6) {
        this.orderExParams = r1;
        this.skuExParams = r2;
        this.ultimateBuyType = r3;
        this.isSingleSku = r4;
        this.skuParams = r5;
        this.ultimateBuyVersion = r6;
    }

    public /* synthetic */ UltimateBuyParams(UltimateBuyOrderExParams r10, Map r11, int r12, int r13, SkuParams r14, Integer r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L5;
        UltimateBuyOrderExParams r3 = null;
    L7:
        if ((r16 & 2) == 0) goto L9;
        Map r4 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        SkuParams r7 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        Integer r8 = 0;
    L18:
        this(r3, r4, r12, r13, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }
}
