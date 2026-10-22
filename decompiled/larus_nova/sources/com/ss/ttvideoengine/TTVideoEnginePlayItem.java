package com.ss.ttvideoengine;

/* JADX INFO: loaded from: classes34.dex */
public class TTVideoEnginePlayItem {
    public long expire;
    public String playURL;
    public Resolution resolution;
    public String vid;

    public TTVideoEnginePlayItem() {
    }

    public boolean isExpired() {
        if ((System.currentTimeMillis() / 1000) <= this.expire) goto L6;
        return true;
    L6:
        return false;
    }
}
