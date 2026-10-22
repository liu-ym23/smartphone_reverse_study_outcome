package com.bytedance.ee.bear.middleground.permission.dlp.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DlpCheckRequest implements NonProguard {

    @JSONField(name = "entityOperateList")
    private ArrayList<String> entityOperateList;

    @JSONField(name = "entityType")
    private String entityType;

    @JSONField(name = ResourceData.KEY_TOKEN)
    private String token;

    public DlpCheckRequest() {
    }

    public ArrayList<String> getEntityOperateList() {
        return this.entityOperateList;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public String getToken() {
        return this.token;
    }

    public void setEntityOperateList(ArrayList<String> r1) {
        this.entityOperateList = r1;
    }

    public void setEntityType(String r1) {
        this.entityType = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }
}
