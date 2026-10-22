package com.bytedance.sdk.open.aweme.base.openentity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class PublishTitleMarker {

    @SerializedName("start")
    public int start;

    public PublishTitleMarker() {
        this.start = -1;
    }

    public boolean checkArgs() {
        return true;
    }
}
