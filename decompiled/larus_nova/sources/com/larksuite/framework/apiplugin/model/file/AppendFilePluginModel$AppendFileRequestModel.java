package com.larksuite.framework.apiplugin.model.file;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: classes24.dex */
public class AppendFilePluginModel$AppendFileRequestModel extends LKBaseRequestModel {

    @JSONField(name = "data")
    public String data;

    @JSONField(name = "encoding")
    public String encoding;

    @JSONField(name = "filePath")
    @LKRequiredParam
    public String filePath;

    public AppendFilePluginModel$AppendFileRequestModel() {
        this.encoding = "utf8";
    }
}
