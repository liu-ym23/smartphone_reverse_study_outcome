package com.bytedance.ee.bear.drive.biz.versions.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VersionUploadModel implements Serializable {
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

        public void setCode(int r1) {
            this.code = r1;
        }

        public void setEdit_user_id(String r1) {
            this.edit_user_id = r1;
        }

        public void setSource(int r1) {
            this.source = r1;
        }

        public void setToken(String r1) {
            this.token = r1;
        }

        public void setType(String r1) {
            this.type = r1;
        }

        public void setVersion(String r1) {
            this.version = r1;
        }
    }

    public VersionUploadModel() {
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean r1) {
        this.data = r1;
    }
}
