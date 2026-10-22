package com.larksuite.framework.apiplugin.model.ui.window;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.validator.format.StringEnum;

/* JADX INFO: loaded from: classes24.dex */
public class SetPageOrientationPluginModel$SetPageOrientationRequestModel extends LKBaseRequestModel {

    @JSONField(name = "orientation")
    @LKRequiredParam
    @StringEnum(values = {"portrait", "landscape", "auto"})
    public String orientation;

    public SetPageOrientationPluginModel$SetPageOrientationRequestModel() {
    }
}
