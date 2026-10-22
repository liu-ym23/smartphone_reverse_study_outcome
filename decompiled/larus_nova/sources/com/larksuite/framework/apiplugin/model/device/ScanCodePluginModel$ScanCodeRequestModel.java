package com.larksuite.framework.apiplugin.model.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class ScanCodePluginModel$ScanCodeRequestModel extends LKBaseRequestModel {

    @JSONField(name = "barCodeInput")
    public boolean barCodeInput;

    @JSONField(name = "onlyFromCamera")
    public boolean onlyFromCamera;

    @JSONField(name = "scanType")
    public ArrayList<String> scanType;

    public ScanCodePluginModel$ScanCodeRequestModel() {
    }
}
