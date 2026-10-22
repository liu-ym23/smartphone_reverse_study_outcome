package com.bytedance.sdk.open.aweme.base.openentity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public abstract class Sticker extends BaseSticker {

    @SerializedName("deletable")
    public boolean deletable;

    @SerializedName("interactive")
    public boolean interactive;

    public Sticker() {
        this.deletable = true;
        this.interactive = true;
    }
}
