package com.bytedance.ee.bear.notification.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class Notification implements NonProguard {
    private boolean close;
    private ContentBean content;
    private long end_time;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f235104id;
    private List<String> products;
    private long start_time;
    private int status;
    private List<VersionBean> version;

    public static class ContentBean implements NonProguard {

        /* JADX INFO: renamed from: en, reason: collision with root package name */
        private String f235105en;

        /* JADX INFO: renamed from: ja, reason: collision with root package name */
        private String f235106ja;

        /* JADX INFO: renamed from: zh, reason: collision with root package name */
        private String f235107zh;

        public ContentBean() {
        }

        public String toString() {
            return "ContentBean{en='" + this.f235105en + "', ja='" + this.f235106ja + "', zh='" + this.f235107zh + "'}";
        }

        public String getEn() {
            return this.f235105en;
        }

        public String getJa() {
            return this.f235106ja;
        }

        public String getZh() {
            return this.f235107zh;
        }

        public void setEn(String r100) {
            this.f235105en = r100;
        }

        public void setJa(String r100) {
            this.f235106ja = r100;
        }

        public void setZh(String r100) {
            this.f235107zh = r100;
        }
    }

    public static class VersionBean implements NonProguard {
        private String end;
        private String start;

        public VersionBean() {
        }

        public String getEnd() {
            return this.end;
        }

        public String getStart() {
            return this.start;
        }

        public void setEnd(String r100) {
            this.end = r100;
        }

        public void setStart(String r100) {
            this.start = r100;
        }
    }

    public String toString() {
        return "Notification{id='" + this.f235104id + "', content=" + this.content + '}';
    }

    public Notification() {
        this.f235104id = "";
    }

    public int hashCode() {
        return getId().hashCode();
    }

    public ContentBean getContent() {
        return this.content;
    }

    public long getEnd_time() {
        return this.end_time;
    }

    public String getId() {
        return this.f235104id;
    }

    public List<String> getProducts() {
        return this.products;
    }

    public long getStart_time() {
        return this.start_time;
    }

    public int getStatus() {
        return this.status;
    }

    public List<VersionBean> getVersion() {
        return this.version;
    }

    public boolean isClose() {
        return this.close;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Notification) == true) goto L10;
        return false;
    L10:
        return getId().equals(((Notification) r100).getId());
    }

    public void setClose(boolean r100) {
        this.close = r100;
    }

    public void setContent(ContentBean r100) {
        this.content = r100;
    }

    public void setEnd_time(long r100) {
        this.end_time = r100;
    }

    public void setId(String r100) {
        this.f235104id = r100;
    }

    public void setProducts(List<String> r100) {
        this.products = r100;
    }

    public void setStart_time(long r100) {
        this.start_time = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    public void setVersion(List<VersionBean> r100) {
        this.version = r100;
    }
}
