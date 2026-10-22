package com.dtf.face.config;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class SDKAction {

    @JSONField(name = "actionName")
    public String actionName;

    @JSONField(name = "actionOrder")
    public int actionOrder;

    @JSONField(name = "actionParam")
    public Map<String, String> actionParam;

    public SDKAction() {
    }
}
