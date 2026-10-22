package com.bytedance.ee.bear.notification.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Notification implements NonProguard {
    private boolean close;
    private ContentBean content;
    private long end_time;
    private String id;
    private List<String> products;
    private long start_time;
    private int status;
    private List<VersionBean> version;

    public static class ContentBean implements NonProguard {
        private String en;
        private String ja;
        private String zh;

        public ContentBean() {
        }

        public String toString() {
            return "ContentBean{en='" + this.en + "', ja='" + this.ja + "', zh='" + this.zh + "'}";
        }

        public String getEn() {
            return this.en;
        }

        public String getJa() {
            return this.ja;
        }

        public String getZh() {
            return this.zh;
        }

        public void setEn(String r1) {
            this.en = r1;
        }

        public void setJa(String r1) {
            this.ja = r1;
        }

        public void setZh(String r1) {
            this.zh = r1;
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

        public void setEnd(String r1) {
            this.end = r1;
        }

        public void setStart(String r1) {
            this.start = r1;
        }
    }

    public String toString() {
        return "Notification{id='" + this.id + "', content=" + this.content + '}';
    }

    public Notification() {
        this.id = "";
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
        return this.id;
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

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof Notification) == true) goto L10;
        return false;
    L10:
        return getId().equals(((Notification) r2).getId());
    }

    public void setClose(boolean r1) {
        this.close = r1;
    }

    public void setContent(ContentBean r1) {
        this.content = r1;
    }

    public void setEnd_time(long r1) {
        this.end_time = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setProducts(List<String> r1) {
        this.products = r1;
    }

    public void setStart_time(long r1) {
        this.start_time = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }

    public void setVersion(List<VersionBean> r1) {
        this.version = r1;
    }
}
