package com.bytedance.ee.bear.middleground.like;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LikeListJsData implements BaseJSModel {
    private int refer_type;
    private String token;

    public LikeListJsData() {
    }

    public String toString() {
        return "LikeListOpenData{token='" + du5.b.g(this.token) + "', refer_type=" + this.refer_type + '}';
    }

    public int getRefer_type() {
        return this.refer_type;
    }

    public String getToken() {
        return this.token;
    }

    public void setRefer_type(int r1) {
        this.refer_type = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }
}
