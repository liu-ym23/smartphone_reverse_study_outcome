package com.larksuite.framework.apiplugin.model.cloud;

import com.alibaba.fastjson.annotation.JSONField;
import com.heytap.mcssdk.constant.b;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: classes24.dex */
public class UploadFileToCloudAbortPluginModel$UploadFileToCloudAbortRequestModel extends LKBaseRequestModel {

    @JSONField(name = b.f276354d)
    @LKRequiredParam
    public String taskID;

    public UploadFileToCloudAbortPluginModel$UploadFileToCloudAbortRequestModel() {
    }
}
