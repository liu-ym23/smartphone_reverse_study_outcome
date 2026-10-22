package com.dtf.face.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;

/* JADX INFO: loaded from: classes22.dex */
public class SceneEnv {

    @JSONField(name = "sceneCode")
    public String sceneCode;

    @JSONField(name = SignCounterLaunchArgs.EXTRA_SCENE_TYPE)
    public String sceneType;

    @JSONField(name = "sysTime")
    public String sysTime;

    public SceneEnv() {
        this.sceneCode = "";
        this.sceneType = "normal";
    }
}
