package com.bytedance.ee.bear.middleground.permission.dlp.cache;

import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpCheckResult;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class DlpCacheModel implements Serializable {
    private CopyOnWriteArrayList<NodeData> data;

    public static class NodeData implements Serializable {
        private DlpCheckResult checkResult;
        private String entityType;
        private DlpPolicyModel policyModel;
        private String token;

        public NodeData() {
        }

        public DlpCheckResult getCheckResult() {
            return this.checkResult;
        }

        public String getEntityType() {
            return this.entityType;
        }

        public DlpPolicyModel getPolicyModel() {
            return this.policyModel;
        }

        public String getToken() {
            return this.token;
        }

        public void setCheckResult(DlpCheckResult r100) {
            this.checkResult = r100;
        }

        public void setEntityType(String r100) {
            this.entityType = r100;
        }

        public void setPolicyModel(DlpPolicyModel r100) {
            this.policyModel = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }
    }

    public DlpCacheModel() {
        this.data = new CopyOnWriteArrayList();
    }

    public CopyOnWriteArrayList<NodeData> getData() {
        return this.data;
    }

    public void setData(CopyOnWriteArrayList<NodeData> r100) {
        this.data = r100;
    }
}
