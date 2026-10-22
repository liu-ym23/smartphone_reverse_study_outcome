package jd3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Ljd3/b1;", "", "", "authorId", "Ljava/lang/String;", "getAuthorId", "()Ljava/lang/String;", "roomId", "getRoomId", "itemId", "getItemId", "creativeId", "getCreativeId", "cpsTrack", "getCpsTrack", "cBizCombo", "getCBizCombo", "buyinTrack", "getBuyinTrack", "productDetailEnterFrom", "getProductDetailEnterFrom", "entranceInfo", "getEntranceInfo", "ecomSceneId", "getEcomSceneId", "footPrint", "getFootPrint", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b1 {

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BUYIN_TRACK)
    private final String buyinTrack;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_C_BIZ_COMBO)
    private final String cBizCombo;

    @SerializedName("cps_track")
    private final String cpsTrack;

    @SerializedName("creative_id")
    private final String creativeId;

    @SerializedName("ecom_scene_id")
    private final String ecomSceneId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO)
    private final String entranceInfo;

    @SerializedName("pd_track")
    private final String footPrint;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("product_detail_enter_from")
    private final String productDetailEnterFrom;

    @SerializedName("room_id")
    private final String roomId;

    public b1() {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b1) == false) goto L28;
        b1 r101 = (b1) r100;
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creativeId, r101.creativeId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cpsTrack, r101.cpsTrack) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cBizCombo, r101.cBizCombo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.buyinTrack, r101.buyinTrack) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.productDetailEnterFrom, r101.productDetailEnterFrom) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.entranceInfo, r101.entranceInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ecomSceneId, r101.ecomSceneId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.footPrint, r101.footPrint) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        String r100 = this.authorId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.roomId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.itemId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.creativeId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.cpsTrack;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.cBizCombo;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.buyinTrack;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.productDetailEnterFrom;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.entranceInfo;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.ecomSceneId;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.footPrint;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
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
        return "ViewExtraInfo(authorId=" + this.authorId + ", roomId=" + this.roomId + ", itemId=" + this.itemId + ", creativeId=" + this.creativeId + ", cpsTrack=" + this.cpsTrack + ", cBizCombo=" + this.cBizCombo + ", buyinTrack=" + this.buyinTrack + ", productDetailEnterFrom=" + this.productDetailEnterFrom + ", entranceInfo=" + this.entranceInfo + ", ecomSceneId=" + this.ecomSceneId + ", footPrint=" + this.footPrint + ")";
    }

    public b1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111) {
        this.authorId = r100;
        this.roomId = r101;
        this.itemId = r102;
        this.creativeId = r103;
        this.cpsTrack = r104;
        this.cBizCombo = r105;
        this.buyinTrack = r106;
        this.productDetailEnterFrom = r107;
        this.entranceInfo = r108;
        this.ecomSceneId = r110;
        this.footPrint = r111;
    }
}
