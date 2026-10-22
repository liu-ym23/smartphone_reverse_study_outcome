package up3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013R\u001a\u0010(\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0016\u001a\u0004\b6\u0010\u0018R\u001c\u00107\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0016\u001a\u0004\b8\u0010\u0018¨\u00069"}, d2 = {"Lup3/f;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "videoCover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "k", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "videoPlayAddr", "l", "Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "product", "Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "f", "()Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "", "Lup3/b;", "commentTags", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "shopName", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "shopBrandIcon", "getShopBrandIcon", "Lup3/d;", "comments", "c", "Lup3/c;", "productCommentButton", "Lup3/c;", "g", "()Lup3/c;", "recommendTag", "h", "description", "e", "", "type", "I", "getType", "()I", "Lup3/e;", "buyButton", "Lup3/e;", "a", "()Lup3/e;", "buyShareId", "Ljava/lang/Integer;", "getBuyShareId", "()Ljava/lang/Integer;", "title", "j", "content", "d", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L36;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.videoCover, r4.videoCover) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.videoPlayAddr, r4.videoPlayAddr) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.product, r4.product) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commentTags, r4.commentTags) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shopName, r4.shopName) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopBrandIcon, r4.shopBrandIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.comments, r4.comments) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.productCommentButton, r4.productCommentButton) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.recommendTag, r4.recommendTag) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.description, r4.description) == true) goto L26;
        return false;
    L26:
        if (this.type == r4.type) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.buyButton, r4.buyButton) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.buyShareId, r4.buyShareId) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.content, r4.content) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.videoCover;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.videoPlayAddr;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        WindowV2ProductItemDTO r7 = this.product;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<b> r10 = this.commentTags;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.shopName;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        ECUrlModel r16 = this.shopBrandIcon;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        List<d> r19 = this.comments;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        c r22 = this.productCommentButton;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        List<String> r25 = this.recommendTag;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        List<String> r28 = this.description;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (((r27 + r29) * 31) + this.type) * 31;
        e r31 = this.buyButton;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.buyShareId;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.title;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.content;
        if (r40 == null) goto L58;
        r1 = r40.hashCode();
    L58:
        return r39 + r1;
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
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
