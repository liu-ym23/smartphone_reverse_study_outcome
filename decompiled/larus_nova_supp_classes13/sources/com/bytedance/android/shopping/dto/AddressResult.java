package com.bytedance.android.shopping.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/dto/AddressResult;", "Ljava/io/Serializable;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "addressInfo", "Lcom/bytedance/android/shopping/dto/PromotionAddressInfo;", "getAddressInfo", "()Lcom/bytedance/android/shopping/dto/PromotionAddressInfo;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddressResult implements Serializable {

    @SerializedName("action")
    private final String action;

    @SerializedName("data")
    private final PromotionAddressInfo addressInfo;

    public AddressResult() {
    }

    public final String getAction() {
        return this.action;
    }

    public final PromotionAddressInfo getAddressInfo() {
        return this.addressInfo;
    }
}
