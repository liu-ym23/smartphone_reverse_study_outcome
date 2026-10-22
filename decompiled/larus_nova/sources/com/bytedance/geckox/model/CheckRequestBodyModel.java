package com.bytedance.geckox.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class CheckRequestBodyModel {

    /* JADX INFO: loaded from: classes3.dex */
    public static class TargetChannel {

        @SerializedName("c")
        public String channelName;

        @SerializedName("from")
        public List<String> from;

        @SerializedName("t_v")
        public Long targetVersion;

        public TargetChannel() {
        }

        public TargetChannel(String r100) {
            this.channelName = r100;
        }

        public TargetChannel(String r100, Long r101) {
            this.channelName = r100;
            this.targetVersion = r101;
        }
    }

    public CheckRequestBodyModel() {
    }
}
