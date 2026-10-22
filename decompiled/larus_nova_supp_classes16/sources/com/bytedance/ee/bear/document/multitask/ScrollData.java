package com.bytedance.ee.bear.document.multitask;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ScrollData implements BaseJSModel {
    private String token;
    private int x;
    private int y;

    public ScrollData() {
    }

    public String toString() {
        return "ScrollData{, x=" + this.x + ", y=" + this.y + '}';
    }

    public String getToken() {
        return this.token;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setX(int r1) {
        this.x = r1;
    }

    public void setY(int r1) {
        this.y = r1;
    }
}
