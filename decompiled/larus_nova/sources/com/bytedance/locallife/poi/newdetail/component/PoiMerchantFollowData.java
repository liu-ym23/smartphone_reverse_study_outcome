package com.bytedance.locallife.poi.newdetail.component;

import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003Je\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0007HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R \u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R \u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R \u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R \u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019¨\u00063"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/PoiMerchantFollowData;", "Ljava/io/Serializable;", "avatarUrl", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "certified", "", "content", "", "followed", "merchantPage", "merchantUserid", "merchantAccountId", "name", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "setAvatarUrl", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;)V", "getCertified", "()Z", "setCertified", "(Z)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getFollowed", "setFollowed", "getMerchantAccountId", "setMerchantAccountId", "getMerchantPage", "setMerchantPage", "getMerchantUserid", "setMerchantUserid", "getName", "setName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiMerchantFollowData implements Serializable {

    @SerializedName("avatar_url")
    private UrlModel avatarUrl;

    @SerializedName("certified")
    private boolean certified;

    @SerializedName("content")
    private String content;

    @SerializedName("followed")
    private boolean followed;

    @SerializedName("merchant_account_id")
    private String merchantAccountId;

    @SerializedName("merchant_page")
    private String merchantPage;

    @SerializedName("merchant_user_id")
    private String merchantUserid;

    @SerializedName("name")
    private String name;

    public PoiMerchantFollowData() {
        this(null, false, null, false, null, null, null, null, 255, null);
    }

    public static /* synthetic */ PoiMerchantFollowData copy$default(PoiMerchantFollowData r100, UrlModel r110, boolean r111, String r112, boolean r113, String r114, String r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        UrlModel r101 = r100.avatarUrl;
    L7:
        if ((r118 & 2) == 0) goto L9;
        boolean r102 = r100.certified;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.content;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.followed;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.merchantPage;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.merchantUserid;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.merchantAccountId;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.name;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final UrlModel component1() {
        return this.avatarUrl;
    }

    public final boolean component2() {
        return this.certified;
    }

    public final String component3() {
        return this.content;
    }

    public final boolean component4() {
        return this.followed;
    }

    public final String component5() {
        return this.merchantPage;
    }

    public final String component6() {
        return this.merchantUserid;
    }

    public final String component7() {
        return this.merchantAccountId;
    }

    public final String component8() {
        return this.name;
    }

    public final PoiMerchantFollowData copy(UrlModel r110, boolean r111, String r112, boolean r113, String r114, String r115, String r116, String r117) {
        return new PoiMerchantFollowData(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiMerchantFollowData) == true) goto L8;
        return false;
    L8:
        PoiMerchantFollowData r101 = (PoiMerchantFollowData) r100;
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L12;
        return false;
    L12:
        if (this.certified == r101.certified) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (this.followed == r101.followed) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.merchantPage, r101.merchantPage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.merchantUserid, r101.merchantUserid) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.merchantAccountId, r101.merchantAccountId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        UrlModel r100 = this.avatarUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.certified == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.content;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.followed == true) goto L18;
        r104 = 1237;
    L18:
        int r110 = (r109 + r104) * 31;
        String r111 = this.merchantPage;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        String r114 = this.merchantUserid;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.merchantAccountId;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        String r120 = this.name;
        if (r120 == null) goto L35;
        r101 = r120.hashCode();
    L35:
        return r119 + r101;
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiMerchantFollowData(avatarUrl=" + this.avatarUrl + ", certified=" + this.certified + ", content=" + this.content + ", followed=" + this.followed + ", merchantPage=" + this.merchantPage + ", merchantUserid=" + this.merchantUserid + ", merchantAccountId=" + this.merchantAccountId + ", name=" + this.name + ')';
    }

    public final UrlModel getAvatarUrl() {
        return this.avatarUrl;
    }

    public final boolean getCertified() {
        return this.certified;
    }

    public final String getContent() {
        return this.content;
    }

    public final boolean getFollowed() {
        return this.followed;
    }

    public final String getMerchantAccountId() {
        return this.merchantAccountId;
    }

    public final String getMerchantPage() {
        return this.merchantPage;
    }

    public final String getMerchantUserid() {
        return this.merchantUserid;
    }

    public final String getName() {
        return this.name;
    }

    public final void setAvatarUrl(UrlModel r100) {
        this.avatarUrl = r100;
    }

    public final void setCertified(boolean r100) {
        this.certified = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setFollowed(boolean r100) {
        this.followed = r100;
    }

    public final void setMerchantAccountId(String r100) {
        this.merchantAccountId = r100;
    }

    public final void setMerchantPage(String r100) {
        this.merchantPage = r100;
    }

    public final void setMerchantUserid(String r100) {
        this.merchantUserid = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public PoiMerchantFollowData(UrlModel r100, boolean r101, String r102, boolean r103, String r104, String r105, String r106, String r107) {
        this.avatarUrl = r100;
        this.certified = r101;
        this.content = r102;
        this.followed = r103;
        this.merchantPage = r104;
        this.merchantUserid = r105;
        this.merchantAccountId = r106;
        this.name = r107;
    }

    public /* synthetic */ PoiMerchantFollowData(UrlModel r110, boolean r111, String r112, boolean r113, String r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        UrlModel r101 = null;
    L6:
        boolean r102 = false;
        if ((r118 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r118 & 8) != 0) goto L19;
        r102 = r113;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r103, r104, r102, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
