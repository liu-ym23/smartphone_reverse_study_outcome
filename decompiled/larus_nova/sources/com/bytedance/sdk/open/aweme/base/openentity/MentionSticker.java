package com.bytedance.sdk.open.aweme.base.openentity;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes22.dex */
public class MentionSticker extends Sticker {

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    public String openId;

    public MentionSticker() {
    }

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public final int getType() {
        return 2;
    }
}
