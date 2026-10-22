package com.bytedance.android.livesdk.live.model;

import com.bytedance.android.livesdkapi.model.UserLiveStatusModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class UserLiveStatusResponse {

    @SerializedName("scene_id")
    public long sceneId;

    @SerializedName("user_live")
    public List<UserLiveStatusModel> userLiveStatus;

    public UserLiveStatusResponse() {
        this.sceneId = 0;
    }
}
