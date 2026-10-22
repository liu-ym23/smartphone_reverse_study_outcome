package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.commodity.api.MarketingComponent;
import com.ss.android.ugc.aweme.discover.commodity.api.SuspensionItemsSection;
import com.ss.android.ugc.aweme.discover.model.ShoppingCart;
import com.ss.android.ugc.aweme.discover.model.globaldoodle.CartContainer;
import com.ss.android.ugc.aweme.discover.model.globaldoodle.FeelGoodInfo;
import com.ss.android.ugc.aweme.discover.model.globaldoodle.ToastInfo;
import com.ss.android.ugc.aweme.discover.model.pushtimecard.PushTimeLynxFeedOutData;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/SuspensionLayer;", "Ljava/io/Serializable;", "()V", "aiInputBox", "", "getAiInputBox", "()Ljava/lang/Object;", "setAiInputBox", "(Ljava/lang/Object;)V", "cartContainer", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/CartContainer;", "getCartContainer", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/CartContainer;", "setCartContainer", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/CartContainer;)V", "chatBot", "Lcom/ss/android/ugc/aweme/discover/model/pushtimecard/PushTimeLynxFeedOutData;", "getChatBot", "()Lcom/ss/android/ugc/aweme/discover/model/pushtimecard/PushTimeLynxFeedOutData;", "setChatBot", "(Lcom/ss/android/ugc/aweme/discover/model/pushtimecard/PushTimeLynxFeedOutData;)V", "feelgoodInfo", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FeelGoodInfo;", "getFeelgoodInfo", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FeelGoodInfo;", "setFeelgoodInfo", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FeelGoodInfo;)V", "marketingComponent", "Lcom/ss/android/ugc/aweme/discover/commodity/api/MarketingComponent;", "getMarketingComponent", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/MarketingComponent;", "setMarketingComponent", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/MarketingComponent;)V", "shoppingCart", "Lcom/ss/android/ugc/aweme/discover/model/ShoppingCart;", "getShoppingCart", "()Lcom/ss/android/ugc/aweme/discover/model/ShoppingCart;", "setShoppingCart", "(Lcom/ss/android/ugc/aweme/discover/model/ShoppingCart;)V", "suspensionItemsSection", "Lcom/ss/android/ugc/aweme/discover/commodity/api/SuspensionItemsSection;", "getSuspensionItemsSection", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/SuspensionItemsSection;", "setSuspensionItemsSection", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/SuspensionItemsSection;)V", "toastInfo", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/ToastInfo;", "getToastInfo", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/ToastInfo;", "setToastInfo", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/ToastInfo;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SuspensionLayer implements Serializable {

    @SerializedName("ai_input_box")
    private Object aiInputBox;

    @SerializedName("cart_container")
    private CartContainer cartContainer;

    @SerializedName("chatbot")
    private PushTimeLynxFeedOutData chatBot;

    @SerializedName("feelgood_msg")
    private FeelGoodInfo feelgoodInfo;

    @SerializedName("marketing_component_container")
    private MarketingComponent marketingComponent;

    @SerializedName("shopping_cart")
    private ShoppingCart shoppingCart;

    @SerializedName("popup")
    private SuspensionItemsSection suspensionItemsSection;

    @SerializedName("toast_info")
    private ToastInfo toastInfo;

    public SuspensionLayer() {
    }

    public final Object getAiInputBox() {
        return this.aiInputBox;
    }

    public final CartContainer getCartContainer() {
        return this.cartContainer;
    }

    public final PushTimeLynxFeedOutData getChatBot() {
        return this.chatBot;
    }

    public final FeelGoodInfo getFeelgoodInfo() {
        return this.feelgoodInfo;
    }

    public final MarketingComponent getMarketingComponent() {
        return this.marketingComponent;
    }

    public final ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    public final SuspensionItemsSection getSuspensionItemsSection() {
        return this.suspensionItemsSection;
    }

    public final ToastInfo getToastInfo() {
        return this.toastInfo;
    }

    public final void setAiInputBox(Object r100) {
        this.aiInputBox = r100;
    }

    public final void setCartContainer(CartContainer r100) {
        this.cartContainer = r100;
    }

    public final void setChatBot(PushTimeLynxFeedOutData r100) {
        this.chatBot = r100;
    }

    public final void setFeelgoodInfo(FeelGoodInfo r100) {
        this.feelgoodInfo = r100;
    }

    public final void setMarketingComponent(MarketingComponent r100) {
        this.marketingComponent = r100;
    }

    public final void setShoppingCart(ShoppingCart r100) {
        this.shoppingCart = r100;
    }

    public final void setSuspensionItemsSection(SuspensionItemsSection r100) {
        this.suspensionItemsSection = r100;
    }

    public final void setToastInfo(ToastInfo r100) {
        this.toastInfo = r100;
    }
}
