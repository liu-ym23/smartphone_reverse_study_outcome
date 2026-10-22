package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003Js\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/larus/platform/model/SaasShareConfig;", "", "ecomDetailCopyLink", "", "ecomDetailDesc", "lifeDetailCopyLink", "lifeDetailDesc", "lifePoiCopyLink", "lifePoiDesc", "liveCopyDesc", "liveCopyLink", "shortUrlCreateTimeoutMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getEcomDetailCopyLink", "()Ljava/lang/String;", "getEcomDetailDesc", "getLifeDetailCopyLink", "getLifeDetailDesc", "getLifePoiCopyLink", "getLifePoiDesc", "getLiveCopyDesc", "getLiveCopyLink", "getShortUrlCreateTimeoutMs", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h4 {

    @SerializedName("ecom_detail_copy_link")
    private final String ecomDetailCopyLink;

    @SerializedName("ecom_detail_desc")
    private final String ecomDetailDesc;

    @SerializedName("life_detail_copy_link")
    private final String lifeDetailCopyLink;

    @SerializedName("life_detail_desc")
    private final String lifeDetailDesc;

    @SerializedName("life_poi_copy_link")
    private final String lifePoiCopyLink;

    @SerializedName("life_poi_desc")
    private final String lifePoiDesc;

    @SerializedName("live_copy_desc")
    private final String liveCopyDesc;

    @SerializedName("live_copy_link")
    private final String liveCopyLink;

    @SerializedName("short_url_create_timeout_ms")
    private final long shortUrlCreateTimeoutMs;

    public h4() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h4) == true) goto L8;
        return false;
    L8:
        h4 r101 = (h4) r100;
        if (Intrinsics.areEqual(this.ecomDetailCopyLink, r101.ecomDetailCopyLink) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ecomDetailDesc, r101.ecomDetailDesc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lifeDetailCopyLink, r101.lifeDetailCopyLink) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lifeDetailDesc, r101.lifeDetailDesc) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lifePoiCopyLink, r101.lifePoiCopyLink) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lifePoiDesc, r101.lifePoiDesc) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.liveCopyDesc, r101.liveCopyDesc) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.liveCopyLink, r101.liveCopyLink) == true) goto L33;
        return false;
    L33:
        if (this.shortUrlCreateTimeoutMs == r101.shortUrlCreateTimeoutMs) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.ecomDetailCopyLink;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.ecomDetailDesc;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lifeDetailCopyLink;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.lifeDetailDesc;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.lifePoiCopyLink;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.lifePoiDesc;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.liveCopyDesc;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.liveCopyLink;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        int r123 = (r121 + r101) * 31;
        long r124 = this.shortUrlCreateTimeoutMs;
        return r123 + ((int) (r124 ^ (r124 >>> 32)));
    L29:
        r120 = r119.hashCode();
        goto L30
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

    public final String toString() {
        return "SaasShareConfig(ecomDetailCopyLink=" + this.ecomDetailCopyLink + ", ecomDetailDesc=" + this.ecomDetailDesc + ", lifeDetailCopyLink=" + this.lifeDetailCopyLink + ", lifeDetailDesc=" + this.lifeDetailDesc + ", lifePoiCopyLink=" + this.lifePoiCopyLink + ", lifePoiDesc=" + this.lifePoiDesc + ", liveCopyDesc=" + this.liveCopyDesc + ", liveCopyLink=" + this.liveCopyLink + ", shortUrlCreateTimeoutMs=" + this.shortUrlCreateTimeoutMs + ')';
    }

    public final String a() {
        return this.ecomDetailCopyLink;
    }

    public final String b() {
        return this.ecomDetailDesc;
    }

    public final String c() {
        return this.lifeDetailCopyLink;
    }

    public final String d() {
        return this.lifeDetailDesc;
    }

    public final String e() {
        return this.lifePoiCopyLink;
    }

    public final String f() {
        return this.lifePoiDesc;
    }

    public final String g() {
        return this.liveCopyDesc;
    }

    public final String h() {
        return this.liveCopyLink;
    }

    public final long i() {
        return this.shortUrlCreateTimeoutMs;
    }

    public h4(int r100) {
        this.ecomDetailCopyLink = "【豆包】%s %s 【点击链接查看商品详情】";
        this.ecomDetailDesc = "买前问豆包，避坑省钱又省心";
        this.lifeDetailCopyLink = "【豆包】 %s %s 【点击链接查看商品详情】";
        this.lifeDetailDesc = "出行问豆包，避坑省钱又省心";
        this.lifePoiCopyLink = "【豆包】 %s %s 【点击链接查看店铺详情】";
        this.lifePoiDesc = "出行问豆包，避坑省钱又省心";
        this.liveCopyDesc = "直播中！快来看看有哪些商品正在讲解~";
        this.liveCopyLink = "【%s】正在直播，来和我一起支持Ta吧。复制下方链接 %s，打开【豆包】，直接观看直播！";
        this.shortUrlCreateTimeoutMs = 5000;
    }
}
