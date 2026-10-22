package com.bytedance.ee.bear.middleground.permission.batchauthorize.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RecordAuthorizeRequest implements Serializable {

    @JSONField(name = "auth_object_list")
    private ArrayList<AuthObject> objectArrayList;

    @JSONField(name = "origin_object_token")
    private String originToken;

    @JSONField(name = "origin_object_type")
    private long originType;

    public static class AuthObject implements Serializable {

        @JSONField(name = "auth_object_token")
        private String objectToken;

        @JSONField(name = "auth_object_type")
        private int objectType;

        @JSONField(name = "perm_type")
        private int permType;

        @JSONField(name = "permission")
        private int permission;

        public AuthObject() {
        }

        public String getObjectToken() {
            return this.objectToken;
        }

        public int getObjectType() {
            return this.objectType;
        }

        public int getPermType() {
            return this.permType;
        }

        public int getPermission() {
            return this.permission;
        }

        public void setObjectToken(String r1) {
            this.objectToken = r1;
        }

        public void setObjectType(int r1) {
            this.objectType = r1;
        }

        public void setPermType(int r1) {
            this.permType = r1;
        }

        public void setPermission(int r1) {
            this.permission = r1;
        }
    }

    public RecordAuthorizeRequest() {
        this.objectArrayList = new ArrayList();
    }

    public ArrayList<AuthObject> getObjectArrayList() {
        return this.objectArrayList;
    }

    public String getOriginToken() {
        return this.originToken;
    }

    public long getOriginType() {
        return this.originType;
    }

    public void setObjectArrayList(ArrayList<AuthObject> r1) {
        this.objectArrayList = r1;
    }

    public void setOriginToken(String r1) {
        this.originToken = r1;
    }

    public void setOriginType(long r1) {
        this.originType = r1;
    }
}
