package com.bytedance.android.shopping.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u000f\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/dto/PromotionAddressInfo;", "Ljava/io/Serializable;", "()V", "area", "", "getArea", "()Ljava/lang/String;", "city", "getCity", "cityId", "getCityId", "detail", "getDetail", "id", "getId", "isDefault", "", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "mobile", "getMobile", "name", "getName", "prov", "getProv", "provId", "getProvId", "tag", "getTag", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionAddressInfo implements Serializable {

    @SerializedName("area")
    private final String area;

    @SerializedName("city")
    private final String city;

    @SerializedName("city_id")
    private final String cityId;

    @SerializedName("detail")
    private final String detail;

    @SerializedName("id")
    private final String id;

    @SerializedName("is_default")
    private final Integer isDefault;

    @SerializedName("mobile")
    private final String mobile;

    @SerializedName("name")
    private final String name;

    @SerializedName("prov")
    private final String prov;

    @SerializedName("prov_id")
    private final String provId;

    @SerializedName("tag")
    private final String tag;

    public PromotionAddressInfo() {
    }

    public final String getArea() {
        return this.area;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCityId() {
        return this.cityId;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProv() {
        return this.prov;
    }

    public final String getProvId() {
        return this.provId;
    }

    public final String getTag() {
        return this.tag;
    }

    public final Integer isDefault() {
        return this.isDefault;
    }
}
