package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class BisBehavLog {

    @JSONField(name = "behavCommon")
    public BisBehavCommon behavCommon;

    @JSONField(name = "behavTask")
    public List<BisBehavTask> behavTask;

    @JSONField(name = "behavToken")
    public BisBehavToken behavToken;

    @JSONField(name = "clientInfo")
    public BisClientInfo clientInfo;

    @JSONField(name = "extAttr")
    public Map<String, String> extAttr;

    public BisBehavLog() {
    }

    public BisBehavCommon getBehavCommon() {
        return this.behavCommon;
    }

    public List<BisBehavTask> getBehavTask() {
        return this.behavTask;
    }

    public BisBehavToken getBehavToken() {
        return this.behavToken;
    }

    public BisClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public Map<String, String> getExtAttr() {
        return this.extAttr;
    }

    public void setBehavCommon(BisBehavCommon r100) {
        this.behavCommon = r100;
    }

    public void setBehavTask(List<BisBehavTask> r100) {
        this.behavTask = r100;
    }

    public void setBehavToken(BisBehavToken r100) {
        this.behavToken = r100;
    }

    public void setClientInfo(BisClientInfo r100) {
        this.clientInfo = r100;
    }

    public void setExtAttr(Map<String, String> r100) {
        this.extAttr = r100;
    }
}
