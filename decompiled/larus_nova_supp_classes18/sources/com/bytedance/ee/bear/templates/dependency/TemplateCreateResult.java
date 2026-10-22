package com.bytedance.ee.bear.templates.dependency;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class TemplateCreateResult extends Result<Serializable> {
    private String templateId;
    private String token;
    private int type;

    public TemplateCreateResult() {
        this.token = "";
        this.type = 0;
        this.templateId = "";
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public void setTemplateId(String r1) {
        this.templateId = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public TemplateCreateResult(String r1, int r2, String r3) {
        this.token = r1;
        this.type = r2;
        this.templateId = r3;
    }
}
