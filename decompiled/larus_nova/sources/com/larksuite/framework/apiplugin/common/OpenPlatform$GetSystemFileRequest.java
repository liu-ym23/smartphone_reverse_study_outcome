package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;

/* JADX INFO: loaded from: classes24.dex */
public final class OpenPlatform$GetSystemFileRequest extends LKBaseRequestModel {

    @JSONField(name = "ttFilePath")
    @LKRequiredParam
    public String mTTFilePath;

    @JSONField(name = "tag")
    @LKRequiredParam
    public String mTag;

    public OpenPlatform$GetSystemFileRequest() {
    }
}
