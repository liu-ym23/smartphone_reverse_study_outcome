package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/BiddingInformation;", "Ljava/io/Serializable;", "()V", "backgroundColor", "Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;", "getBackgroundColor", "()Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;", "setBackgroundColor", "(Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;)V", "backgroundImage", "Lcom/ss/android/ugc/aweme/discover/model/PicConfig;", "getBackgroundImage", "()Lcom/ss/android/ugc/aweme/discover/model/PicConfig;", "setBackgroundImage", "(Lcom/ss/android/ugc/aweme/discover/model/PicConfig;)V", "icon", "getIcon", "setIcon", "radius", "", "getRadius", "()Ljava/lang/Integer;", "setRadius", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "text", "Lcom/ss/android/ugc/aweme/discover/model/TextConfig;", "getText", "()Lcom/ss/android/ugc/aweme/discover/model/TextConfig;", "setText", "(Lcom/ss/android/ugc/aweme/discover/model/TextConfig;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BiddingInformation implements Serializable {

    @SerializedName("bg_color")
    private ColorConfig backgroundColor;

    @SerializedName("bg_image")
    private PicConfig backgroundImage;

    @SerializedName("icon_url")
    private PicConfig icon;

    @SerializedName("radius")
    private Integer radius;

    @SerializedName("text")
    private TextConfig text;

    public BiddingInformation() {
        this.radius = 10;
    }

    public final ColorConfig getBackgroundColor() {
        return this.backgroundColor;
    }

    public final PicConfig getBackgroundImage() {
        return this.backgroundImage;
    }

    public final PicConfig getIcon() {
        return this.icon;
    }

    public final Integer getRadius() {
        return this.radius;
    }

    public final TextConfig getText() {
        return this.text;
    }

    public final void setBackgroundColor(ColorConfig r100) {
        this.backgroundColor = r100;
    }

    public final void setBackgroundImage(PicConfig r100) {
        this.backgroundImage = r100;
    }

    public final void setIcon(PicConfig r100) {
        this.icon = r100;
    }

    public final void setRadius(Integer r100) {
        this.radius = r100;
    }

    public final void setText(TextConfig r100) {
        this.text = r100;
    }
}
