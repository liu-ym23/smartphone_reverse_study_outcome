package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;

/* JADX INFO: loaded from: classes24.dex */
public class OpenPlatform$Requests$ConvertFilePathToTTFile extends LKBaseRequestModel {

    @JSONField(name = "filePath")
    @LKRequiredParam
    public String mFilePath;

    public OpenPlatform$Requests$ConvertFilePathToTTFile() {
    }
}
