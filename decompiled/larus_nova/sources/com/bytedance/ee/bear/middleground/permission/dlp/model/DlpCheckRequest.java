package com.bytedance.ee.bear.middleground.permission.dlp.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class DlpCheckRequest implements NonProguard {

    @JSONField(name = "entityOperateList")
    private ArrayList<String> entityOperateList;

    @JSONField(name = "entityType")
    private String entityType;

    @JSONField(name = "token")
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

    public void setEntityOperateList(ArrayList<String> r100) {
        this.entityOperateList = r100;
    }

    public void setEntityType(String r100) {
        this.entityType = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}
