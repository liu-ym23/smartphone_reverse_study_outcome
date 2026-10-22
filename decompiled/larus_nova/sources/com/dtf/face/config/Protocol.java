package com.dtf.face.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes22.dex */
public class Protocol {

    @JSONField(name = "content")
    public String content;

    @JSONField(name = "protocolContent")
    public ProtocolContent protocolContent;

    @JSONField(name = "sign")
    public String sign;

    public boolean isValid() {
        ProtocolContent r100 = this.protocolContent;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isValid();
    }

    public Protocol() {
    }

    public void parse(String r100) {
        ProtocolContent r101 = (ProtocolContent) JSON.parseObject(this.content, ProtocolContent.class);
        this.protocolContent = r101;
        if (r101 == null) goto L6;
        r101.parse(r100);
        this.protocolContent.parseVoiceCfg(r100);
        this.protocolContent.parseDTOSSConfig(r100);
        return;
    }

    public void parseExtParams(String r100) {
        ProtocolContent r101 = this.protocolContent;
        if (r101 == null) goto L6;
        r101.parseExtParams(r100);
        this.protocolContent.mergeExtAlgConfig();
        return;
    }
}
