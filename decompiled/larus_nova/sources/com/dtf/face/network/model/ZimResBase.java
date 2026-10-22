package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larus.network.http.ServiceType;

/* JADX INFO: loaded from: classes22.dex */
public class ZimResBase {

    @JSONField(name = "Code")
    public String Code;

    @JSONField(name = ServiceType.IM)
    public String Message;

    @JSONField(name = "RequestId")
    public String RequestId;

    public ZimResBase() {
    }
}
