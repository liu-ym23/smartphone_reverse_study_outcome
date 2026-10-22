package com.larksuite.framework.apiplugin.model.cloud;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;

/* JADX INFO: loaded from: classes24.dex */
public class DownloadFileFromCloudPluginModel$DownloadFileFromCloudResponseModel extends LKBaseResponseModel {

    @JSONField(name = "tempFilePath")
    @LKRequiredParam
    public String tempFilePath;

    public DownloadFileFromCloudPluginModel$DownloadFileFromCloudResponseModel() {
    }
}
