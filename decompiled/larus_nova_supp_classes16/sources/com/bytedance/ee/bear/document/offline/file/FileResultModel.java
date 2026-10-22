package com.bytedance.ee.bear.document.offline.file;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileResultModel implements NonProguard {
    private int code;
    private Data data;
    private String message;
    private boolean showQuotaAlert;
    private String uuid;

    public static class Data implements NonProguard {
        private String pencilKitToken;
        private String token;
        private int uploadType;
        private String url;

        public String toString() {
            return "Data{url='" + c.j(this.url) + "', token='" + c.j(this.token) + "', pencilKitToken='" + c.j(this.pencilKitToken) + "', uploadType=" + this.uploadType + '}';
        }

        public Data() {
        }

        public String getPencilKitToken() {
            return this.pencilKitToken;
        }

        public String getToken() {
            return this.token;
        }

        public int getUploadType() {
            return this.uploadType;
        }

        public String getUrl() {
            return this.url;
        }

        public void setPencilKitToken(String r1) {
            this.pencilKitToken = r1;
        }

        public void setToken(String r1) {
            this.token = r1;
        }

        public void setUploadType(int r1) {
            this.uploadType = r1;
        }

        public void setUrl(String r1) {
            this.url = r1;
        }

        public Data(String r1, String r2, int r3) {
            this.url = r1;
            this.token = r2;
            this.uploadType = r3;
        }
    }

    public String toString() {
        return "FileResultModel{code=" + this.code + ", showQuotaAlert=" + this.showQuotaAlert + ", message='" + this.message + "', uuid='" + b.k(this.uuid) + "', data=" + this.data + '}';
    }

    public FileResultModel() {
        this.code = 1;
        this.uuid = "";
        this.message = "";
        this.showQuotaAlert = false;
    }

    public int getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isShowQuotaAlert() {
        return this.showQuotaAlert;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setData(Data r1) {
        this.data = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setShowQuotaAlert(boolean r1) {
        this.showQuotaAlert = r1;
    }

    public void setUuid(String r1) {
        this.uuid = r1;
    }
}
