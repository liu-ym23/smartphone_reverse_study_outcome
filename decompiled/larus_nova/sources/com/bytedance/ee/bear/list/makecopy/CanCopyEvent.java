package com.bytedance.ee.bear.list.makecopy;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class CanCopyEvent implements NonProguard {
    private boolean isCanCopy;

    public CanCopyEvent() {
    }

    public boolean isCanCopy() {
        return this.isCanCopy;
    }

    public CanCopyEvent(boolean r100) {
        this.isCanCopy = r100;
    }

    public static CanCopyEvent fromJson(String r100) {
        return (CanCopyEvent) JSON.parseObject(r100, CanCopyEvent.class);
    }

    public static String toJson(CanCopyEvent r100) {
        return JSON.toJSONString(r100);
    }

    public void setCanCopy(boolean r100) {
        this.isCanCopy = r100;
    }
}
