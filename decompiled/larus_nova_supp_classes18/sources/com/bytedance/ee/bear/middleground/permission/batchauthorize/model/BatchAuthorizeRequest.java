package com.bytedance.ee.bear.middleground.permission.batchauthorize.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BatchAuthorizeRequest implements Serializable {

    @JSONField(name = "authorize_pair_list")
    private ArrayList<BatchRequestNode> data;

    public static class BatchRequestNode implements Serializable {

        @JSONField(name = "collaborator")
        private Collabrator collabrator;

        @JSONField(name = "entity_type")
        private String entityType;

        @JSONField(name = ResourceData.KEY_TOKEN)
        private String token;

        public BatchRequestNode() {
        }

        public Collabrator getCollabrator() {
            return this.collabrator;
        }

        public String getEntityType() {
            return this.entityType;
        }

        public String getToken() {
            return this.token;
        }

        public void setCollabrator(Collabrator r1) {
            this.collabrator = r1;
        }

        public void setEntityType(String r1) {
            this.entityType = r1;
        }

        public void setToken(String r1) {
            this.token = r1;
        }
    }

    public static class Collabrator implements Serializable {

        @JSONField(name = ResourceData.KEY_TYPE)
        private long entityType;

        @JSONField(name = ResourceData.KEY_ID)
        private long id;

        @JSONField(name = "role")
        private long role;

        public Collabrator() {
        }

        public long getEntityType() {
            return this.entityType;
        }

        public long getId() {
            return this.id;
        }

        public long getRole() {
            return this.role;
        }

        public void setEntityType(long r1) {
            this.entityType = r1;
        }

        public void setId(long r1) {
            this.id = r1;
        }

        public void setRole(long r1) {
            this.role = r1;
        }
    }

    public BatchAuthorizeRequest() {
    }

    public ArrayList<BatchRequestNode> getData() {
        return this.data;
    }

    public void setData(ArrayList<BatchRequestNode> r1) {
        this.data = r1;
    }
}
