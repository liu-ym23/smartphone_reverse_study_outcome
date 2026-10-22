package com.ss.android.lark.passport.signinsdk_api.base;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class BaseStepData implements Serializable {

    @JSONField(name = "back_first")
    public boolean backFirst;
    public String message;

    @JSONField(name = "next_step")
    public String nextStep;

    @JSONField(name = "step_info")
    public JSONObject stepInfo;

    public BaseStepData() {
    }

    public String getNextStep() {
        return this.nextStep;
    }

    public JSONObject getStepInfo() {
        return this.stepInfo;
    }

    public boolean isBackFirst() {
        return this.backFirst;
    }

    public void setBackFirst(boolean r100) {
        this.backFirst = r100;
    }

    public void setNextStep(String r100) {
        this.nextStep = r100;
    }

    public void setStepInfo(JSONObject r100) {
        this.stepInfo = r100;
    }
}
