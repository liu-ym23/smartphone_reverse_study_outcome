package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bM\u0010NR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR$\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R$\u0010;\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0019\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001dR$\u0010>\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0019\u001a\u0004\b?\u0010\u001b\"\u0004\b@\u0010\u001dR$\u0010A\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u00103\u001a\u0004\bB\u00105\"\u0004\bC\u00107R$\u0010D\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0019\u001a\u0004\bE\u0010\u001b\"\u0004\bF\u0010\u001dR\"\u0010G\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006O"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/b;", "", "Lcom/bytedance/android/shopping/store/home/entity/p;", "headerStyleInfo", "Lcom/bytedance/android/shopping/store/home/entity/p;", "getHeaderStyleInfo", "()Lcom/bytedance/android/shopping/store/home/entity/p;", "setHeaderStyleInfo", "(Lcom/bytedance/android/shopping/store/home/entity/p;)V", "Lcom/bytedance/android/shopping/store/home/entity/t;", "hybridTab", "Lcom/bytedance/android/shopping/store/home/entity/t;", "d", "()Lcom/bytedance/android/shopping/store/home/entity/t;", "setHybridTab", "(Lcom/bytedance/android/shopping/store/home/entity/t;)V", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreProductTabDTO;", "productTab", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreProductTabDTO;", "e", "()Lcom/bytedance/android/shopping/store/home/entity/ECStoreProductTabDTO;", "setProductTab", "(Lcom/bytedance/android/shopping/store/home/entity/ECStoreProductTabDTO;)V", "", "tabHintText", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setTabHintText", "(Ljava/lang/String;)V", "", "tabHintDuration", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "setTabHintDuration", "(Ljava/lang/Integer;)V", "toast", "i", "setToast", "", "Lcom/bytedance/android/shopping/store/home/entity/ECShopHeadInfoBlock;", "globalComponents", "Ljava/util/List;", "c", "()Ljava/util/List;", "tabStyleType", "getTabStyleType", "setTabStyleType", "Lcom/bytedance/android/ec/model/ECUrlModel;", "immerseTabIconSelected", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImmerseTabIconSelected", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setImmerseTabIconSelected", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "immerseTabIconUnSelected", "getImmerseTabIconUnSelected", "setImmerseTabIconUnSelected", "benefitType", "b", "setBenefitType", "benefitText", "a", "setBenefitText", "tabIconWithoutBadge", "getTabIconWithoutBadge", "setTabIconWithoutBadge", "tabIndicatorColor", "h", "setTabIndicatorColor", "liveStyle", "I", "getLiveStyle", "()I", "setLiveStyle", "(I)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("benefit_desc")
    private String benefitText;

    @SerializedName("benefit_type")
    private String benefitType;

    @SerializedName("global_components")
    private final List<ECShopHeadInfoBlock> globalComponents;

    @SerializedName("header_style_info")
    private p headerStyleInfo;

    @SerializedName("hybrid_tab")
    private t hybridTab;

    @SerializedName("immerse_tab_icon_selected")
    private ECUrlModel immerseTabIconSelected;

    @SerializedName("immerse_tab_icon_unselected")
    private ECUrlModel immerseTabIconUnSelected;

    @SerializedName("live_style")
    private int liveStyle;

    @SerializedName("product_tab")
    private ECStoreProductTabDTO productTab;

    @SerializedName("tab_hint_duration")
    private Integer tabHintDuration;

    @SerializedName("tab_hint_text")
    private String tabHintText;

    @SerializedName("tab_icon_without_badge")
    private ECUrlModel tabIconWithoutBadge;

    @SerializedName("tab_indicator_color")
    private String tabIndicatorColor;

    @SerializedName("tab_style_type")
    private Integer tabStyleType;

    @SerializedName("toast")
    private String toast;

    public b() {
        this.liveStyle = -1;
    }

    public final String a() {
        return this.benefitText;
    }

    public final String b() {
        return this.benefitType;
    }

    public final List<ECShopHeadInfoBlock> c() {
        return this.globalComponents;
    }

    public final t d() {
        return this.hybridTab;
    }

    public final ECStoreProductTabDTO e() {
        return this.productTab;
    }

    public final Integer f() {
        return this.tabHintDuration;
    }

    public final String g() {
        return this.tabHintText;
    }

    public final String h() {
        return this.tabIndicatorColor;
    }

    public final String i() {
        return this.toast;
    }
}
