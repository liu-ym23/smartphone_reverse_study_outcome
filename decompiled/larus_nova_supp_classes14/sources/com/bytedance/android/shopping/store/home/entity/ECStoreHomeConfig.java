package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeConfig;", "Ljava/io/Serializable;", "", "tmpId", "Ljava/lang/String;", "getTmpId", "()Ljava/lang/String;", "setTmpId", "(Ljava/lang/String;)V", "token", "getToken", "setToken", "shopLogoShrink", "getShopLogoShrink", "setShopLogoShrink", "", "customIdType", "Ljava/lang/Integer;", "getCustomIdType", "()Ljava/lang/Integer;", "setCustomIdType", "(Ljava/lang/Integer;)V", "customIds", "getCustomIds", "setCustomIds", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHomeConfig implements Serializable {
    public static final a Companion = null;

    @SerializedName("custom_id_type")
    private Integer customIdType;

    @SerializedName("custom_ids")
    private String customIds;

    @SerializedName("shop_logo_shrink")
    private String shopLogoShrink;

    @SerializedName("tmp_id")
    private String tmpId;

    @SerializedName("token")
    private String token;

    public static final class a {
        public a() {
        }

        public static ECStoreHomeConfig a(ECStoreParam r2) {
            Intrinsics.checkNotNullParameter(r2, "storeParam");
            ECStoreHomeConfig r0 = new ECStoreHomeConfig();
            r0.setTmpId(r2.getProductBasicRequestParam().getTmpId());
            r0.setToken(r2.getProductBasicRequestParam().getToken());
            r0.setCustomIdType(r2.getProductBasicRequestParam().getCustomIdType());
            r0.setCustomIds(r2.getProductBasicRequestParam().getCustomIds());
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public ECStoreHomeConfig() {
    }

    public final Integer getCustomIdType() {
        return this.customIdType;
    }

    public final String getCustomIds() {
        return this.customIds;
    }

    public final String getShopLogoShrink() {
        return this.shopLogoShrink;
    }

    public final String getTmpId() {
        return this.tmpId;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setCustomIdType(Integer r1) {
        this.customIdType = r1;
    }

    public final void setCustomIds(String r1) {
        this.customIds = r1;
    }

    public final void setShopLogoShrink(String r1) {
        this.shopLogoShrink = r1;
    }

    public final void setTmpId(String r1) {
        this.tmpId = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }
}
