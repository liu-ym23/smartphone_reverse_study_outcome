package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;

/* JADX INFO: loaded from: classes16.dex */
public class CopyUrlTemplateBean implements NonProguard {
    private String template;

    public CopyUrlTemplateBean() {
    }

    public String toString() {
        return "CopyUrlTemplateBean{template=" + b.f(this.template) + '}';
    }

    public String getTemplate() {
        return this.template;
    }

    public void setTemplate(String r100) {
        this.template = r100;
    }
}
