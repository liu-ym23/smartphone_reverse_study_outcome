package s14;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Ls14/a;", "", "", "showType", "Ljava/lang/Integer;", "getShowType", "()Ljava/lang/Integer;", "setShowType", "(Ljava/lang/Integer;)V", "businessType", "getBusinessType", "setBusinessType", "Ls14/f;", "wikipediaInfo", "Ls14/f;", "getWikipediaInfo", "()Ls14/f;", "setWikipediaInfo", "(Ls14/f;)V", "Ls14/e;", "shopLinkStruct", "Ls14/e;", "getShopLinkStruct", "()Ls14/e;", "setShopLinkStruct", "(Ls14/e;)V", "Ls14/b;", "anchorInfo", "Ls14/b;", "getAnchorInfo", "()Ls14/b;", "setAnchorInfo", "(Ls14/b;)V", "", "anchorId", "Ljava/lang/String;", "getAnchorId", "()Ljava/lang/String;", "setAnchorId", "(Ljava/lang/String;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    @SerializedName("anchor_id")
    private String anchorId;

    @SerializedName("anchor_info")
    private b anchorInfo;

    @SerializedName("business_type")
    private Integer businessType;

    @SerializedName("shop_link")
    private e shopLinkStruct;

    @SerializedName("show_type")
    private Integer showType;

    @SerializedName("wikipedia_info")
    private f wikipediaInfo;

    public a() {
        this.showType = 0;
        this.businessType = 0;
    }
}
