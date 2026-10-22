package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.facebook.keyframes.model.KFFeatureEffect;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchBackgroundConfig;", "Ljava/io/Serializable;", "()V", KFFeatureEffect.GRADIENT_JSON_FIELD, "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchGradientBackgroundConfig;", "getGradient", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchGradientBackgroundConfig;", "setGradient", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchGradientBackgroundConfig;)V", "gradientDark", "getGradientDark", "setGradientDark", "image", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchImageBackgroundConfig;", "getImage", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchImageBackgroundConfig;", "setImage", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchImageBackgroundConfig;)V", "imageDark", "getImageDark", "setImageDark", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AiSearchBackgroundConfig implements Serializable {

    @SerializedName("gradient_light")
    private AiSearchGradientBackgroundConfig gradient;

    @SerializedName("gradient_dark")
    private AiSearchGradientBackgroundConfig gradientDark;

    @SerializedName("image_light")
    private AiSearchImageBackgroundConfig image;

    @SerializedName("image_dark")
    private AiSearchImageBackgroundConfig imageDark;

    public AiSearchBackgroundConfig() {
    }

    public final AiSearchGradientBackgroundConfig getGradient() {
        return this.gradient;
    }

    public final AiSearchGradientBackgroundConfig getGradientDark() {
        return this.gradientDark;
    }

    public final AiSearchImageBackgroundConfig getImage() {
        return this.image;
    }

    public final AiSearchImageBackgroundConfig getImageDark() {
        return this.imageDark;
    }

    public final void setGradient(AiSearchGradientBackgroundConfig r100) {
        this.gradient = r100;
    }

    public final void setGradientDark(AiSearchGradientBackgroundConfig r100) {
        this.gradientDark = r100;
    }

    public final void setImage(AiSearchImageBackgroundConfig r100) {
        this.image = r100;
    }

    public final void setImageDark(AiSearchImageBackgroundConfig r100) {
        this.imageDark = r100;
    }
}
