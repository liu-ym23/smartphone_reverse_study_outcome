package com.bytedance.ee.bear.document.multitask;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes16.dex */
public class ScrollData implements BaseJSModel {
    private String token;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f220388x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f220389y;

    public ScrollData() {
    }

    public String toString() {
        return "ScrollData{, x=" + this.f220388x + ", y=" + this.f220389y + '}';
    }

    public String getToken() {
        return this.token;
    }

    public int getX() {
        return this.f220388x;
    }

    public int getY() {
        return this.f220389y;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setX(int r100) {
        this.f220388x = r100;
    }

    public void setY(int r100) {
        this.f220389y = r100;
    }
}
