package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Ljd3/b1;", "", "", "authorId", "Ljava/lang/String;", "getAuthorId", "()Ljava/lang/String;", "roomId", "getRoomId", "itemId", "getItemId", "creativeId", "getCreativeId", "cpsTrack", "getCpsTrack", "cBizCombo", "getCBizCombo", "buyinTrack", "getBuyinTrack", "productDetailEnterFrom", "getProductDetailEnterFrom", "entranceInfo", "getEntranceInfo", "ecomSceneId", "getEcomSceneId", "footPrint", "getFootPrint", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b1 {

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName("buyin_track")
    private final String buyinTrack;

    @SerializedName("c_biz_combo")
    private final String cBizCombo;

    @SerializedName("cps_track")
    private final String cpsTrack;

    @SerializedName("creative_id")
    private final String creativeId;

    @SerializedName("ecom_scene_id")
    private final String ecomSceneId;

    @SerializedName("entrance_info")
    private final String entranceInfo;

    @SerializedName("pd_track")
    private final String footPrint;

    @SerializedName(PdpOpenThirdParam.KEY_ITEM_ID)
    private final String itemId;

    @SerializedName("product_detail_enter_from")
    private final String productDetailEnterFrom;

    @SerializedName("room_id")
    private final String roomId;

    public b1() {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b1) == false) goto L28;
        b1 r4 = (b1) r3;
        if (Intrinsics.areEqual(this.authorId, r4.authorId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.itemId, r4.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creativeId, r4.creativeId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cpsTrack, r4.cpsTrack) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cBizCombo, r4.cBizCombo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.buyinTrack, r4.buyinTrack) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.productDetailEnterFrom, r4.productDetailEnterFrom) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.entranceInfo, r4.entranceInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ecomSceneId, r4.ecomSceneId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.footPrint, r4.footPrint) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        String r0 = this.authorId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.roomId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.itemId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.creativeId;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.cpsTrack;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.cBizCombo;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.buyinTrack;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.productDetailEnterFrom;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.entranceInfo;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.ecomSceneId;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.footPrint;
        if (r31 == null) goto L46;
        r1 = r31.hashCode();
    L46:
        return r30 + r1;
    L41:
        r29 = 0;
        goto L42
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
        return "ViewExtraInfo(authorId=" + this.authorId + ", roomId=" + this.roomId + ", itemId=" + this.itemId + ", creativeId=" + this.creativeId + ", cpsTrack=" + this.cpsTrack + ", cBizCombo=" + this.cBizCombo + ", buyinTrack=" + this.buyinTrack + ", productDetailEnterFrom=" + this.productDetailEnterFrom + ", entranceInfo=" + this.entranceInfo + ", ecomSceneId=" + this.ecomSceneId + ", footPrint=" + this.footPrint + ")";
    }

    public b1(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
        this.authorId = r1;
        this.roomId = r2;
        this.itemId = r3;
        this.creativeId = r4;
        this.cpsTrack = r5;
        this.cBizCombo = r6;
        this.buyinTrack = r7;
        this.productDetailEnterFrom = r8;
        this.entranceInfo = r9;
        this.ecomSceneId = r10;
        this.footPrint = r11;
    }
}
