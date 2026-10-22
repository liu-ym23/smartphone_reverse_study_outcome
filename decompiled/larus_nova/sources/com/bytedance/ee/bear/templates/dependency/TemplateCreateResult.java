package com.bytedance.ee.bear.templates.dependency;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
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

    public void setTemplateId(String r100) {
        this.templateId = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public TemplateCreateResult(String r100, int r101, String r102) {
        this.token = r100;
        this.type = r101;
        this.templateId = r102;
    }
}
