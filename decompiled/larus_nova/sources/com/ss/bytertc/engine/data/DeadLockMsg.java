package com.ss.bytertc.engine.data;

import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes40.dex */
public class DeadLockMsg {
    public String blockPaths;
    public String blockSessionId;
    public boolean isCritical;

    public String toString() {
        return "DeadLockMsg{blockSessionId:" + this.blockSessionId + "blockPths:" + this.blockPaths + "isCritical" + this.isCritical + i.f25855d;
    }

    public DeadLockMsg(String r100, String r101, boolean r102) {
        this.blockSessionId = r100;
        this.blockPaths = r101;
        this.isCritical = r102;
    }
}
