package com.bytedance.ee.bear.notification.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

            public void setData(String r1) {
                this.data = r1;
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

        public void setBody(BodyBean r1) {
            this.body = r1;
        }

        public void setOperation(String r1) {
            this.operation = r1;
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

    public void setBusiness(String r1) {
        this.business = r1;
    }

    public void setData(DataBean r1) {
        this.data = r1;
    }
}
