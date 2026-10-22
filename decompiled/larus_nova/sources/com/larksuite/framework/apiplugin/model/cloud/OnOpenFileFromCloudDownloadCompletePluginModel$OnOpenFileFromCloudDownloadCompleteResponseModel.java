package com.larksuite.framework.apiplugin.model.cloud;

import com.alibaba.fastjson.annotation.JSONField;
import com.heytap.mcssdk.constant.b;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;

/* JADX INFO: loaded from: classes24.dex */
public class OnOpenFileFromCloudDownloadCompletePluginModel$OnOpenFileFromCloudDownloadCompleteResponseModel extends LKBaseResponseModel {

    @JSONField(name = "fileName")
    @LKRequiredParam
    public String fileName;

    @JSONField(name = "fileToken")
    @LKRequiredParam
    public String fileToken;

    @JSONField(name = "fileType")
    @LKRequiredParam
    public String fileType;

    @JSONField(name = "size")
    @LKRequiredParam
    public int size;

    @JSONField(name = b.f276354d)
    @LKRequiredParam
    public String taskID;

    public OnOpenFileFromCloudDownloadCompletePluginModel$OnOpenFileFromCloudDownloadCompleteResponseModel() {
    }
}
