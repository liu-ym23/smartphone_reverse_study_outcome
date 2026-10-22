package sj3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.repository.dto.ShopListHeaderSettingDTO;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R*\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$¨\u0006'"}, d2 = {"Lsj3/b;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "id", "getId", "Lcom/bytedance/android/ec/model/ECUrlModel;", "picUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getPicUrl", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "promotionPicUrl", "getPromotionPicUrl", "textColor", "getTextColor", "promotionTextColor", "getPromotionTextColor", "listPageUrl", "getListPageUrl", "rank", "I", "getRank", "()I", "", "Lcom/bytedance/android/shopping/store/repository/dto/ShopListHeaderSettingDTO;", "shopListHeaderSettings", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "logExtra", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("id")
    private final String id;

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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L28;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.picUrl, r4.picUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.promotionPicUrl, r4.promotionPicUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.textColor, r4.textColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.promotionTextColor, r4.promotionTextColor) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.listPageUrl, r4.listPageUrl) == true) goto L22;
        return false;
    L22:
        if (this.rank == r4.rank) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shopListHeaderSettings, r4.shopListHeaderSettings) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.logExtra, r4.logExtra) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.type;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.id;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECUrlModel r10 = this.picUrl;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        ECUrlModel r13 = this.promotionPicUrl;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.textColor;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.promotionTextColor;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.listPageUrl;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (((r21 + r23) * 31) + this.rank) * 31;
        Map<String, ShopListHeaderSettingDTO> r25 = this.shopListHeaderSettings;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Map<String, String> r28 = this.logExtra;
        if (r28 == null) goto L42;
        r1 = r28.hashCode();
    L42:
        return r27 + r1;
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECShopListInfoModuleDTO(type=" + this.type + ", name=" + this.name + ", id=" + this.id + ", picUrl=" + this.picUrl + ", promotionPicUrl=" + this.promotionPicUrl + ", textColor=" + this.textColor + ", promotionTextColor=" + this.promotionTextColor + ", listPageUrl=" + this.listPageUrl + ", rank=" + this.rank + ", shopListHeaderSettings=" + this.shopListHeaderSettings + ", logExtra=" + this.logExtra + ")";
    }

    public b() {
        this.type = null;
        this.name = null;
        this.id = null;
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
