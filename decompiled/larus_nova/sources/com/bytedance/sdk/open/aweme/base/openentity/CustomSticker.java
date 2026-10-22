package com.bytedance.sdk.open.aweme.base.openentity;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class CustomSticker extends Sticker {

    @SerializedName("end_time")
    public int endTime;

    @SerializedName("path")
    public String path;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public int startTime;

    public CustomSticker() {
        this.startTime = 0;
        this.endTime = 0;
    }

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public boolean checkArg() {
        return !TextUtils.isEmpty(this.path);
    }

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public final int getType() {
        return 3;
    }
}
