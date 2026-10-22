package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class ObjMetaBean implements NonProguard {

    @JSONField(name = "doc_type")
    private int docType;

    @JSONField(name = "title")
    private String title;

    public ObjMetaBean() {
    }

    public int getDocType() {
        return this.docType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDocType(int r100) {
        this.docType = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
