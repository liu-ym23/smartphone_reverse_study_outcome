package com.bytedance.ee.bear.document.offline.file;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import yu5.c;

/* JADX INFO: loaded from: classes16.dex */
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

        public void setPencilKitToken(String r100) {
            this.pencilKitToken = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }

        public void setUploadType(int r100) {
            this.uploadType = r100;
        }

        public void setUrl(String r100) {
            this.url = r100;
        }

        public Data(String r100, String r101, int r102) {
            this.url = r100;
            this.token = r101;
            this.uploadType = r102;
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

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setData(Data r100) {
        this.data = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setShowQuotaAlert(boolean r100) {
        this.showQuotaAlert = r100;
    }

    public void setUuid(String r100) {
        this.uuid = r100;
    }
}
