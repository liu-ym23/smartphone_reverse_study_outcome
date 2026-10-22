package com.bytedance.sdk.open.aweme.base.openentity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class HashtagTitleMarker extends PublishTitleMarker {

    @SerializedName("name")
    public String name;

    public HashtagTitleMarker() {
    }

    @Override // com.bytedance.sdk.open.aweme.base.openentity.PublishTitleMarker
    public boolean checkArgs() {
        return !TextUtils.isEmpty(this.name);
    }
}
