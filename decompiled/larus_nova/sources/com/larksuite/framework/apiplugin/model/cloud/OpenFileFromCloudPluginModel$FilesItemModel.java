package com.larksuite.framework.apiplugin.model.cloud;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.validator.format.NotBlank;
import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public class OpenFileFromCloudPluginModel$FilesItemModel implements Serializable {

    @JSONField(name = "extra")
    public JSONObject extra;

    @NotBlank
    @JSONField(name = "fileToken")
    @LKRequiredParam
    public String fileToken;

    @JSONField(name = "mountNodePoint")
    public String mountNodePoint;

    @NotBlank
    @JSONField(name = "mountPoint")
    public String mountPoint;

    public OpenFileFromCloudPluginModel$FilesItemModel() {
    }
}
