package com.bytedance.ee.bear.list.makecopy;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CanCopyEvent implements NonProguard {
    private boolean isCanCopy;

    public CanCopyEvent() {
    }

    public boolean isCanCopy() {
        return this.isCanCopy;
    }

    public CanCopyEvent(boolean r1) {
        this.isCanCopy = r1;
    }

    public static CanCopyEvent fromJson(String r1) {
        return (CanCopyEvent) JSON.parseObject(r1, CanCopyEvent.class);
    }

    public static String toJson(CanCopyEvent r0) {
        return JSON.toJSONString(r0);
    }

    public void setCanCopy(boolean r1) {
        this.isCanCopy = r1;
    }
}
