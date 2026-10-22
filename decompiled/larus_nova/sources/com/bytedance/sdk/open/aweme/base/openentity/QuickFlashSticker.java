package com.bytedance.sdk.open.aweme.base.openentity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class QuickFlashSticker extends Sticker {

    @SerializedName("sticker_id")
    public String stickerId;

    @SerializedName("text_info")
    public String textInfo;

    public QuickFlashSticker() {
    }

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public boolean checkArg() {
        if (super.checkArg() == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.textInfo) == true) goto L7;
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public int getType() {
        return 5;
    }
}
