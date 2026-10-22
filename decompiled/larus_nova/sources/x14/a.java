package x14;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bA\u0010BR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR$\u0010;\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR$\u0010>\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\b¨\u0006C"}, d2 = {"Lx14/a;", "", "", "shareUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setShareUrl", "(Ljava/lang/String;)V", "shareWeiboDesc", "getShareWeiboDesc", "setShareWeiboDesc", "shareTitle", "c", "setShareTitle", "shareDesc", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setShareDesc", "shareLinkDesc", "b", "setShareLinkDesc", "Lt14/a;", "imageUrls", "Lt14/a;", "getImageUrls", "()Lt14/a;", "setImageUrls", "(Lt14/a;)V", "qrCodeUrls", "getQrCodeUrls", "setQrCodeUrls", "shareSignatureDesc", "getShareSignatureDesc", "setShareSignatureDesc", "shareSignatureUrl", "getShareSignatureUrl", "setShareSignatureUrl", "shareQuote", "getShareQuote", "setShareQuote", "goodsRecUrl", "getGoodsRecUrl", "setGoodsRecUrl", "goodsManagerUrl", "getGoodsManagerUrl", "setGoodsManagerUrl", "", "boolPersist", "I", "getBoolPersist", "()I", "setBoolPersist", "(I)V", "shareTitleMyself", "getShareTitleMyself", "setShareTitleMyself", "shareTitleOther", "getShareTitleOther", "setShareTitleOther", "shareToutiaoDesc", "getShareToutiaoDesc", "setShareToutiaoDesc", "whatsappShareDesc", "getWhatsappShareDesc", "setWhatsappShareDesc", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    @SerializedName("bool_persist")
    private int boolPersist;

    @SerializedName("manage_goods_url")
    private String goodsManagerUrl;

    @SerializedName("goods_rec_url")
    private String goodsRecUrl;

    @SerializedName("share_image_url")
    private t14.a imageUrls;

    @SerializedName("share_qrcode_url")
    private t14.a qrCodeUrls;

    @SerializedName("share_desc")
    private String shareDesc;

    @SerializedName("share_link_desc")
    private String shareLinkDesc;

    @SerializedName("share_quote")
    private String shareQuote;

    @SerializedName("share_signature_desc")
    private String shareSignatureDesc;

    @SerializedName("share_signature_url")
    private String shareSignatureUrl;

    @SerializedName("share_title")
    private String shareTitle;

    @SerializedName("share_title_myself")
    private String shareTitleMyself;

    @SerializedName("share_title_other")
    private String shareTitleOther;

    @SerializedName("share_toutiao_desc")
    private String shareToutiaoDesc;

    @SerializedName("share_url")
    private String shareUrl;

    @SerializedName("share_weibo_desc")
    private String shareWeiboDesc;

    @SerializedName("whatsapp_desc")
    private String whatsappShareDesc;

    public a() {
    }

    public final String a() {
        return this.shareDesc;
    }

    public final String b() {
        return this.shareLinkDesc;
    }

    public final String c() {
        return this.shareTitle;
    }

    public final String d() {
        return this.shareUrl;
    }
}
