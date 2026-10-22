package com.bytedance.ee.bear.middleground.permission.batchauthorize.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.document.setting.DocumentSettingViewModel;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
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

        @JSONField(name = DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE)
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

        public void setObjectToken(String r100) {
            this.objectToken = r100;
        }

        public void setObjectType(int r100) {
            this.objectType = r100;
        }

        public void setPermType(int r100) {
            this.permType = r100;
        }

        public void setPermission(int r100) {
            this.permission = r100;
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

    public void setObjectArrayList(ArrayList<AuthObject> r100) {
        this.objectArrayList = r100;
    }

    public void setOriginToken(String r100) {
        this.originToken = r100;
    }

    public void setOriginType(long r100) {
        this.originType = r100;
    }
}
