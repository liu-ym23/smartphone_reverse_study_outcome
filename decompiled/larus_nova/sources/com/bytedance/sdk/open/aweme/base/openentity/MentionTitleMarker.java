package com.bytedance.sdk.open.aweme.base.openentity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes22.dex */
public class MentionTitleMarker extends PublishTitleMarker {

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    public String openId;

    public MentionTitleMarker() {
    }

    @Override // com.bytedance.sdk.open.aweme.base.openentity.PublishTitleMarker
    public boolean checkArgs() {
        return !TextUtils.isEmpty(this.openId);
    }
}
