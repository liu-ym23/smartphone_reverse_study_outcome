package up3;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013R\u001a\u0010(\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0016\u001a\u0004\b6\u0010\u0018R\u001c\u00107\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0016\u001a\u0004\b8\u0010\u0018¨\u00069"}, d2 = {"Lup3/f;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "videoCover", "Lcom/bytedance/android/ec/model/ECUrlModel;", ce.f26396k, "()Lcom/bytedance/android/ec/model/ECUrlModel;", "videoPlayAddr", "l", "Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "product", "Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "f", "()Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "", "Lup3/b;", "commentTags", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "shopName", "Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/String;", "shopBrandIcon", "getShopBrandIcon", "Lup3/d;", "comments", "c", "Lup3/c;", "productCommentButton", "Lup3/c;", ce.f26391f, "()Lup3/c;", "recommendTag", "h", "description", "e", "", "type", "I", "getType", "()I", "Lup3/e;", "buyButton", "Lup3/e;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lup3/e;", "buyShareId", "Ljava/lang/Integer;", "getBuyShareId", "()Ljava/lang/Integer;", "title", ce.f26395j, "content", "d", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("buy_button")
    private final e buyButton;

    @SerializedName("buy_share_id")
    private final Integer buyShareId;

    @SerializedName("comment_tags")
    private final List<b> commentTags;

    @SerializedName("comments")
    private final List<d> comments;

    @SerializedName("content")
    private final String content;

    @SerializedName("description")
    private final List<String> description;

    @SerializedName("product")
    private final WindowV2ProductItemDTO product;

    @SerializedName("product_comment_button")
    private final c productCommentButton;

    @SerializedName("recommend_tag")
    private final List<String> recommendTag;

    @SerializedName("shop_brand_icon")
    private final ECUrlModel shopBrandIcon;

    @SerializedName("shop_name")
    private final String shopName;

    @SerializedName("title")
    private final String title;

    @SerializedName("type")
    private final int type;

    @SerializedName("video_cover")
    private final ECUrlModel videoCover;

    @SerializedName("video_play_addr")
    private final ECUrlModel videoPlayAddr;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L36;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.videoCover, r101.videoCover) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.videoPlayAddr, r101.videoPlayAddr) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.product, r101.product) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commentTags, r101.commentTags) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shopName, r101.shopName) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopBrandIcon, r101.shopBrandIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.comments, r101.comments) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.productCommentButton, r101.productCommentButton) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.recommendTag, r101.recommendTag) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L26;
        return false;
    L26:
        if (this.type == r101.type) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.buyButton, r101.buyButton) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.buyShareId, r101.buyShareId) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.videoCover;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.videoPlayAddr;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        WindowV2ProductItemDTO r107 = this.product;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<b> r110 = this.commentTags;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.shopName;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ECUrlModel r116 = this.shopBrandIcon;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<d> r119 = this.comments;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        c r122 = this.productCommentButton;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<String> r125 = this.recommendTag;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        List<String> r128 = this.description;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (((r127 + r129) * 31) + this.type) * 31;
        e r131 = this.buyButton;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.buyShareId;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.title;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.content;
        if (r140 == null) goto L58;
        r101 = r140.hashCode();
    L58:
        return r139 + r101;
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
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
        return "ECShopInnerFlowVideoDTO(videoCover=" + this.videoCover + ", videoPlayAddr=" + this.videoPlayAddr + ", product=" + this.product + ", commentTags=" + this.commentTags + ", shopName=" + this.shopName + ", shopBrandIcon=" + this.shopBrandIcon + ", comments=" + this.comments + ", productCommentButton=" + this.productCommentButton + ", recommendTag=" + this.recommendTag + ", description=" + this.description + ", type=" + this.type + ", buyButton=" + this.buyButton + ", buyShareId=" + this.buyShareId + ", title=" + this.title + ", content=" + this.content + ")";
    }

    public f() {
        this.videoCover = null;
        this.videoPlayAddr = null;
        this.product = null;
        this.commentTags = null;
        this.shopName = null;
        this.shopBrandIcon = null;
        this.comments = null;
        this.productCommentButton = null;
        this.recommendTag = null;
        this.description = null;
        this.type = 0;
        this.buyButton = null;
        this.buyShareId = null;
        this.title = null;
        this.content = null;
    }

    public final e a() {
        return this.buyButton;
    }

    public final List<b> b() {
        return this.commentTags;
    }

    public final List<d> c() {
        return this.comments;
    }

    public final String d() {
        return this.content;
    }

    public final List<String> e() {
        return this.description;
    }

    public final WindowV2ProductItemDTO f() {
        return this.product;
    }

    public final c g() {
        return this.productCommentButton;
    }

    public final int getType() {
        return this.type;
    }

    public final List<String> h() {
        return this.recommendTag;
    }

    public final String i() {
        return this.shopName;
    }

    public final String j() {
        return this.title;
    }

    public final ECUrlModel k() {
        return this.videoCover;
    }

    public final ECUrlModel l() {
        return this.videoPlayAddr;
    }
}
