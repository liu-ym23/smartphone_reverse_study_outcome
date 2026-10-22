package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import faceverify.q;

/* JADX INFO: loaded from: classes22.dex */
public class ValidateContent {

    @JSONField(name = "behavLog")
    public String behavLog;

    @JSONField(name = "behavLogSig")
    public String behavLogSig;

    @JSONField(name = "bisToken")
    public String bisToken;

    @JSONField(name = "content")
    public String content;

    @JSONField(name = q.KEY_CONTENT_SIG)
    public String contentSig;

    public ValidateContent() {
        this.bisToken = "";
        this.content = "";
        this.contentSig = "";
        this.behavLog = "";
        this.behavLogSig = "";
    }
}
