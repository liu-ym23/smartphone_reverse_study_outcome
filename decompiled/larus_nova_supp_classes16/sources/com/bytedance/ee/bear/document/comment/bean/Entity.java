package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class Entity implements NonProguard {
    public String appId;
    public int bizType;
    public String token;
    public int type;

    public Entity() {
    }

    public String toString() {
        return "Entity{token='" + b.g(this.token) + "', type=" + this.type + ", bizType=" + this.bizType + ", appId='" + this.appId + "'}";
    }

    public String getAppId() {
        return this.appId;
    }

    public int getBizType() {
        return this.bizType;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public void setAppId(String r1) {
        this.appId = r1;
    }

    public void setBizType(int r1) {
        this.bizType = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }
}
