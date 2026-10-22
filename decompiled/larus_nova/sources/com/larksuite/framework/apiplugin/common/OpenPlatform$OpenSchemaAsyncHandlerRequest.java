package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;

/* JADX INFO: loaded from: classes24.dex */
public class OpenPlatform$OpenSchemaAsyncHandlerRequest extends LKBaseRequestModel {

    @JSONField(name = "external")
    public boolean mExternal;

    @JSONField(name = "schema")
    @LKRequiredParam
    public String mSchema;

    public OpenPlatform$OpenSchemaAsyncHandlerRequest() {
        this.mExternal = false;
    }
}
