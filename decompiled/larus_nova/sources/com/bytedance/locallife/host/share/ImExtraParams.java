package com.bytedance.locallife.host.share;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001eJh\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\rHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00065"}, d2 = {"Lcom/bytedance/locallife/host/share/ImExtraParams;", "Ljava/io/Serializable;", "goodsName", "", "goodsType", "goodsPrice", "discountPrice", "coverUrls", "", "Lcom/bytedance/locallife/host/share/GroupbuyCoverUrl;", "trackParams", "Lcom/bytedance/locallife/host/share/ImExtraTrackParams;", "shareSource", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/locallife/host/share/ImExtraTrackParams;Ljava/lang/Integer;)V", "getCoverUrls", "()Ljava/util/List;", "setCoverUrls", "(Ljava/util/List;)V", "getDiscountPrice", "()Ljava/lang/String;", "setDiscountPrice", "(Ljava/lang/String;)V", "getGoodsName", "setGoodsName", "getGoodsPrice", "setGoodsPrice", "getGoodsType", "setGoodsType", "getShareSource", "()Ljava/lang/Integer;", "setShareSource", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTrackParams", "()Lcom/bytedance/locallife/host/share/ImExtraTrackParams;", "setTrackParams", "(Lcom/bytedance/locallife/host/share/ImExtraTrackParams;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/locallife/host/share/ImExtraTrackParams;Ljava/lang/Integer;)Lcom/bytedance/locallife/host/share/ImExtraParams;", "equals", "", "other", "", "hashCode", "toString", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ImExtraParams implements Serializable {

    @SerializedName("groupbuy_cover_urls")
    private List<GroupbuyCoverUrl> coverUrls;

    @SerializedName("groupbuy_discount_price")
    private String discountPrice;

    @SerializedName("groupbuy_goods_name")
    private String goodsName;

    @SerializedName("groupbuy_price")
    private String goodsPrice;

    @SerializedName("groupbuy_type")
    private String goodsType;

    @SerializedName("share_source")
    private Integer shareSource;

    @SerializedName("groupbuy_track_params")
    private ImExtraTrackParams trackParams;

    public ImExtraParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImExtraParams copy$default(ImExtraParams r100, String r101, String r102, String r103, String r104, List r110, ImExtraTrackParams r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.goodsName;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.goodsType;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.goodsPrice;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.discountPrice;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.coverUrls;
    L17:
        List r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.trackParams;
    L20:
        ImExtraTrackParams r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.shareSource;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.goodsName;
    }

    public final String component2() {
        return this.goodsType;
    }

    public final String component3() {
        return this.goodsPrice;
    }

    public final String component4() {
        return this.discountPrice;
    }

    public final List<GroupbuyCoverUrl> component5() {
        return this.coverUrls;
    }

    public final ImExtraTrackParams component6() {
        return this.trackParams;
    }

    public final Integer component7() {
        return this.shareSource;
    }

    public final ImExtraParams copy(String r110, String r111, String r112, String r113, List<GroupbuyCoverUrl> r114, ImExtraTrackParams r115, Integer r116) {
        return new ImExtraParams(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImExtraParams) == true) goto L8;
        return false;
    L8:
        ImExtraParams r101 = (ImExtraParams) r100;
        if (Intrinsics.areEqual(this.goodsName, r101.goodsName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.goodsType, r101.goodsType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.goodsPrice, r101.goodsPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.discountPrice, r101.discountPrice) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.coverUrls, r101.coverUrls) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.shareSource, r101.shareSource) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.goodsName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.goodsType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.goodsPrice;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.discountPrice;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<GroupbuyCoverUrl> r113 = this.coverUrls;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ImExtraTrackParams r116 = this.trackParams;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.shareSource;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ImExtraParams(goodsName=" + this.goodsName + ", goodsType=" + this.goodsType + ", goodsPrice=" + this.goodsPrice + ", discountPrice=" + this.discountPrice + ", coverUrls=" + this.coverUrls + ", trackParams=" + this.trackParams + ", shareSource=" + this.shareSource + ')';
    }

    public final List<GroupbuyCoverUrl> getCoverUrls() {
        return this.coverUrls;
    }

    public final String getDiscountPrice() {
        return this.discountPrice;
    }

    public final String getGoodsName() {
        return this.goodsName;
    }

    public final String getGoodsPrice() {
        return this.goodsPrice;
    }

    public final String getGoodsType() {
        return this.goodsType;
    }

    public final Integer getShareSource() {
        return this.shareSource;
    }

    public final ImExtraTrackParams getTrackParams() {
        return this.trackParams;
    }

    public final void setCoverUrls(List<GroupbuyCoverUrl> r100) {
        this.coverUrls = r100;
    }

    public final void setDiscountPrice(String r100) {
        this.discountPrice = r100;
    }

    public final void setGoodsName(String r100) {
        this.goodsName = r100;
    }

    public final void setGoodsPrice(String r100) {
        this.goodsPrice = r100;
    }

    public final void setGoodsType(String r100) {
        this.goodsType = r100;
    }

    public final void setShareSource(Integer r100) {
        this.shareSource = r100;
    }

    public final void setTrackParams(ImExtraTrackParams r100) {
        this.trackParams = r100;
    }

    public ImExtraParams(String r100, String r101, String r102, String r103, List<GroupbuyCoverUrl> r104, ImExtraTrackParams r105, Integer r106) {
        this.goodsName = r100;
        this.goodsType = r101;
        this.goodsPrice = r102;
        this.discountPrice = r103;
        this.coverUrls = r104;
        this.trackParams = r105;
        this.shareSource = r106;
    }

    public /* synthetic */ ImExtraParams(String r100, String r101, String r102, String r110, List r111, ImExtraTrackParams r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        List r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        ImExtraTrackParams r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
