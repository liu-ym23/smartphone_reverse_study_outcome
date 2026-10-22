package com.larksuite.framework.apiplugin.model.media;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.validator.format.Min;

/* JADX INFO: loaded from: classes24.dex */
public class GetVideoInfoPluginModel$GetVideoInfoRequestModel extends LKBaseRequestModel {

    @JSONField(name = "isSupportNetworkURL")
    public boolean isSupportNetworkURL;

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    @Min(include = false, value = AudioStats.AUDIO_AMPLITUDE_NONE)
    @JSONField(name = "src")
    @LKRequiredParam
    public String f285537src;

    public GetVideoInfoPluginModel$GetVideoInfoRequestModel() {
    }
}
