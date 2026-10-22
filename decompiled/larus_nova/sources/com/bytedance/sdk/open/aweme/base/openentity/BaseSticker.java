package com.bytedance.sdk.open.aweme.base.openentity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseSticker {
    public static final int CUSTOM_STICKER_TYPE = 3;
    public static final int HASHTAG_STICKER_TYPE = 1;
    public static final int MENTION_STICKER_TYPE = 2;
    public static final int POI_STICKER_TYPE = 4;
    public static final int QUICK_FLASH_STICKER_TYPE = 5;

    @SerializedName("layer_weight")
    public int layerWeight;

    @SerializedName("normalized_size_x")
    public float normalizedSizeX;

    @SerializedName("normalized_size_y")
    public float normalizedSizeY;

    @SerializedName("offset_x")
    public float offsetX;

    @SerializedName("offset_y")
    public float offsetY;

    @SerializedName("rotate")
    public float rotate;

    @SerializedName("scale")
    public float scale;

    public BaseSticker() {
        this.layerWeight = 0;
        this.normalizedSizeX = -1.0f;
        this.normalizedSizeY = -1.0f;
        this.scale = 1.0f;
        this.rotate = 0.0f;
        this.offsetX = 0.5f;
        this.offsetY = 0.5f;
    }

    public boolean checkArg() {
        return true;
    }

    public abstract int getType();
}
