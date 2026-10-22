package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes24.dex */
public class GetApiAccessConfig$GetDomainResponse extends LKBaseResponseModel {

    @JSONField(name = "bitType")
    public String mBizType;

    @JSONField(name = "domain")
    public String mDomain;

    @JSONField(name = "scene")
    public String mScene;

    public GetApiAccessConfig$GetDomainResponse() {
    }
}
