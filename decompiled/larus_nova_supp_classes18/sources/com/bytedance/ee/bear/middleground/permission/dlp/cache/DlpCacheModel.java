package com.bytedance.ee.bear.middleground.permission.dlp.cache;

import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpCheckResult;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

        public void setCheckResult(DlpCheckResult r1) {
            this.checkResult = r1;
        }

        public void setEntityType(String r1) {
            this.entityType = r1;
        }

        public void setPolicyModel(DlpPolicyModel r1) {
            this.policyModel = r1;
        }

        public void setToken(String r1) {
            this.token = r1;
        }
    }

    public DlpCacheModel() {
        this.data = new CopyOnWriteArrayList();
    }

    public CopyOnWriteArrayList<NodeData> getData() {
        return this.data;
    }

    public void setData(CopyOnWriteArrayList<NodeData> r1) {
        this.data = r1;
    }
}
