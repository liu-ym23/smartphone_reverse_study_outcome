package com.bytedance.ee.bear.notification.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class NotificationPushData implements NonProguard {
    private String business;
    private DataBean data;

    public static class DataBean implements NonProguard {
        private BodyBean body;
        private String operation;

        public static class BodyBean implements NonProguard {
            private String data;

            public BodyBean() {
            }

            public String getData() {
                return this.data;
            }

            public void setData(String r100) {
                this.data = r100;
            }
        }

        public DataBean() {
        }

        public BodyBean getBody() {
            return this.body;
        }

        public String getOperation() {
            return this.operation;
        }

        public void setBody(BodyBean r100) {
            this.body = r100;
        }

        public void setOperation(String r100) {
            this.operation = r100;
        }
    }

    public NotificationPushData() {
    }

    public String getBusiness() {
        return this.business;
    }

    public DataBean getData() {
        return this.data;
    }

    public void setBusiness(String r100) {
        this.business = r100;
    }

    public void setData(DataBean r100) {
        this.data = r100;
    }
}
