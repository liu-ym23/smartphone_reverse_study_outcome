package com.larksuite.framework.apiplugin.model.web.container;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public class GetCookieFromURLPluginModel$DataItemModel implements Serializable {

    @JSONField(name = "domain")
    public String domain;

    @JSONField(name = "expires")
    public String expires;

    @JSONField(name = "httpOnly")
    public String httpOnly;

    @JSONField(name = "key")
    @LKRequiredParam
    public String key;

    @JSONField(name = "maxAge")
    public String maxAge;

    @JSONField(name = "path")
    public String path;

    @JSONField(name = "sameSite")
    public String sameSite;

    @JSONField(name = "secure")
    public String secure;

    @JSONField(name = "value")
    @LKRequiredParam
    public String value;

    public GetCookieFromURLPluginModel$DataItemModel() {
    }
}
