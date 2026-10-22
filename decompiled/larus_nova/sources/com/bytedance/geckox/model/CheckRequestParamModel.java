package com.bytedance.geckox.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class CheckRequestParamModel {

    @SerializedName("group_name")
    private String group;

    @SerializedName("target_channels")
    private List<CheckRequestBodyModel.TargetChannel> targetChannels;

    public String getGroup() {
        return this.group;
    }

    public List<CheckRequestBodyModel.TargetChannel> getTargetChannels() {
        return this.targetChannels;
    }

    public CheckRequestParamModel(String r100) {
        this.group = r100;
    }

    public void setGroup(String r100) {
        this.group = r100;
    }

    public void setTargetChannels(List<CheckRequestBodyModel.TargetChannel> r100) {
        this.targetChannels = r100;
    }

    public CheckRequestParamModel(String r100, List<CheckRequestBodyModel.TargetChannel> r101) {
        this.group = r100;
        this.targetChannels = r101;
    }
}
