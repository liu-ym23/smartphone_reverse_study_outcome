package com.bytedance.sdk.open.aweme.base.openentity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class PoiSticker extends Sticker {

    @SerializedName("poi_id")
    public String poiId;

    public PoiSticker() {
    }

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public final int getType() {
        return 4;
    }
}
