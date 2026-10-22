package com.bytedance.ee.bear.middleground.like;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes18.dex */
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

    public void setRefer_type(int r100) {
        this.refer_type = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}
