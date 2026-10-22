package com.bytedance.ee.bear.middleground.permission.batchauthorize.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.obric.capabilitykit.EntityProvider;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class BatchAuthorizeRequest implements Serializable {

    @JSONField(name = "authorize_pair_list")
    private ArrayList<BatchRequestNode> data;

    public static class BatchRequestNode implements Serializable {

        @JSONField(name = "collaborator")
        private Collabrator collabrator;

        @JSONField(name = EntityProvider.KEY_ENTITY_TYPE)
        private String entityType;

        @JSONField(name = "token")
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

        public void setCollabrator(Collabrator r100) {
            this.collabrator = r100;
        }

        public void setEntityType(String r100) {
            this.entityType = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }
    }

    public static class Collabrator implements Serializable {

        @JSONField(name = "type")
        private long entityType;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @JSONField(name = "id")
        private long f233130id;

        @JSONField(name = "role")
        private long role;

        public Collabrator() {
        }

        public long getEntityType() {
            return this.entityType;
        }

        public long getId() {
            return this.f233130id;
        }

        public long getRole() {
            return this.role;
        }

        public void setEntityType(long r100) {
            this.entityType = r100;
        }

        public void setId(long r100) {
            this.f233130id = r100;
        }

        public void setRole(long r100) {
            this.role = r100;
        }
    }

    public BatchAuthorizeRequest() {
    }

    public ArrayList<BatchRequestNode> getData() {
        return this.data;
    }

    public void setData(ArrayList<BatchRequestNode> r100) {
        this.data = r100;
    }
}
