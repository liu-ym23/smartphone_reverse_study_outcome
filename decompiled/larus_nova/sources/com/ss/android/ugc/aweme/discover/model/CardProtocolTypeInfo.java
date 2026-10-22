package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CardProtocolTypeInfo;", "Ljava/io/Serializable;", "()V", "cardType", "", "getCardType", "()Ljava/lang/String;", "setCardType", "(Ljava/lang/String;)V", "enterMethod", "getEnterMethod", "setEnterMethod", "guideTabText", "getGuideTabText", "setGuideTabText", "switchName", "getSwitchName", "setSwitchName", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardProtocolTypeInfo implements Serializable {

    @SerializedName(a.KEY_CARD_TYPE)
    private String cardType;

    @SerializedName("enter_method")
    private String enterMethod;

    @SerializedName("guide_tab_text")
    private String guideTabText;

    @SerializedName("switch_name")
    private String switchName;

    public CardProtocolTypeInfo() {
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getGuideTabText() {
        return this.guideTabText;
    }

    public final String getSwitchName() {
        return this.switchName;
    }

    public final void setCardType(String r100) {
        this.cardType = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setGuideTabText(String r100) {
        this.guideTabText = r100;
    }

    public final void setSwitchName(String r100) {
        this.switchName = r100;
    }
}
