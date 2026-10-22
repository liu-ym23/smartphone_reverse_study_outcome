package com.dtf.face.config;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes22.dex */
public class VoiceConfig {

    @JSONField(name = "coll")
    private VoiceColl coll;

    @JSONField(name = "navi")
    private NavigatePage navi;

    public VoiceConfig() {
        this.navi = new NavigatePage();
        this.coll = new VoiceColl();
    }

    public VoiceColl getColl() {
        return this.coll;
    }

    public NavigatePage getNavi() {
        return this.navi;
    }

    public void setColl(VoiceColl r100) {
        this.coll = r100;
    }

    public void setNavi(NavigatePage r100) {
        this.navi = r100;
    }
}
