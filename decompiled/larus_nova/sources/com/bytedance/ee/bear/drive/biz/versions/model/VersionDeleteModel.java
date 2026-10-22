package com.bytedance.ee.bear.drive.biz.versions.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class VersionDeleteModel implements Serializable {
    private DataBean data;

    public static class DataBean implements Serializable {
        private int code;
        private String edit_user_id;
        private int source;
        private String token;
        private String type;
        private String version;

        public DataBean() {
        }

        public int getCode() {
            return this.code;
        }

        public String getEdit_user_id() {
            return this.edit_user_id;
        }

        public int getSource() {
            return this.source;
        }

        public String getToken() {
            return this.token;
        }

        public String getType() {
            return this.type;
        }

        public String getVersion() {
            return this.version;
        }

        public void setCode(int r100) {
            this.code = r100;
        }

        public void setEdit_user_id(String r100) {
            this.edit_user_id = r100;
        }

        public void setSource(int r100) {
            this.source = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }

        public void setType(String r100) {
            this.type = r100;
        }

        public void setVersion(String r100) {
            this.version = r100;
        }
    }

    public VersionDeleteModel() {
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean r100) {
        this.data = r100;
    }
}
