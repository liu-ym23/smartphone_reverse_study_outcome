package sj3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.repository.dto.ShopListHeaderSettingDTO;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R*\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$¨\u0006'"}, d2 = {"Lsj3/b;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "id", "getId", "Lcom/bytedance/android/ec/model/ECUrlModel;", "picUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getPicUrl", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "promotionPicUrl", "getPromotionPicUrl", "textColor", "getTextColor", "promotionTextColor", "getPromotionTextColor", "listPageUrl", "getListPageUrl", "rank", "I", "getRank", "()I", "", "Lcom/bytedance/android/shopping/store/repository/dto/ShopListHeaderSettingDTO;", "shopListHeaderSettings", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "logExtra", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f542276id;

    @SerializedName("list_page_url")
    private final String listPageUrl;

    @SerializedName("log_extra")
    private final Map<String, String> logExtra;

    @SerializedName("name")
    private final String name;

    @SerializedName("title_pic_url")
    private final ECUrlModel picUrl;

    @SerializedName("title_promotion_pic_url")
    private final ECUrlModel promotionPicUrl;

    @SerializedName("title_promotion_text_color")
    private final String promotionTextColor;

    @SerializedName("rank")
    private final int rank;

    @SerializedName("shoplist_header_settings")
    private final Map<String, ShopListHeaderSettingDTO> shopListHeaderSettings;

    @SerializedName("title_text_color")
    private final String textColor;

    @SerializedName("type")
    private final Integer type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L28;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f542276id, r101.f542276id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.picUrl, r101.picUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.promotionPicUrl, r101.promotionPicUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.promotionTextColor, r101.promotionTextColor) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.listPageUrl, r101.listPageUrl) == true) goto L22;
        return false;
    L22:
        if (this.rank == r101.rank) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shopListHeaderSettings, r101.shopListHeaderSettings) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f542276id;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECUrlModel r110 = this.picUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ECUrlModel r113 = this.promotionPicUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.textColor;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.promotionTextColor;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.listPageUrl;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (((r121 + r123) * 31) + this.rank) * 31;
        Map<String, ShopListHeaderSettingDTO> r125 = this.shopListHeaderSettings;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.logExtra;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECShopListInfoModuleDTO(type=" + this.type + ", name=" + this.name + ", id=" + this.f542276id + ", picUrl=" + this.picUrl + ", promotionPicUrl=" + this.promotionPicUrl + ", textColor=" + this.textColor + ", promotionTextColor=" + this.promotionTextColor + ", listPageUrl=" + this.listPageUrl + ", rank=" + this.rank + ", shopListHeaderSettings=" + this.shopListHeaderSettings + ", logExtra=" + this.logExtra + ")";
    }

    public b() {
        this.type = null;
        this.name = null;
        this.f542276id = null;
        this.picUrl = null;
        this.promotionPicUrl = null;
        this.textColor = null;
        this.promotionTextColor = null;
        this.listPageUrl = null;
        this.rank = 0;
        this.shopListHeaderSettings = null;
        this.logExtra = null;
    }

    public final Map<String, String> a() {
        return this.logExtra;
    }

    public final Map<String, ShopListHeaderSettingDTO> b() {
        return this.shopListHeaderSettings;
    }

    public final Integer getType() {
        return this.type;
    }
}
