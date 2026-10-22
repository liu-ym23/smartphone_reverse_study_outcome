package com.ss.android.ugc.aweme.discover.model.commodity.aladdin;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/CapsuleStyle;", "Ljava/io/Serializable;", "()V", "buttonBgColor", "", "getButtonBgColor", "()Ljava/lang/String;", "setButtonBgColor", "(Ljava/lang/String;)V", "buttonText", "getButtonText", "setButtonText", "buttonTextColor", "getButtonTextColor", "setButtonTextColor", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CapsuleStyle implements Serializable {

    @SerializedName("button_bgcolor")
    private String buttonBgColor;

    @SerializedName("button_text")
    private String buttonText;

    @SerializedName("button_textcolor")
    private String buttonTextColor;

    public CapsuleStyle() {
    }

    public final String getButtonBgColor() {
        return this.buttonBgColor;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getButtonTextColor() {
        return this.buttonTextColor;
    }

    public final void setButtonBgColor(String r100) {
        this.buttonBgColor = r100;
    }

    public final void setButtonText(String r100) {
        this.buttonText = r100;
    }

    public final void setButtonTextColor(String r100) {
        this.buttonTextColor = r100;
    }
}
