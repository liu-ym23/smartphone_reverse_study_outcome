package com.bytedance.ee.bear.middleground.permission.setting.manager;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class CheckLockResult extends Result<Serializable> {
    private boolean needLock;

    public CheckLockResult() {
    }

    public boolean isNeedLock() {
        return this.needLock;
    }

    public CheckLockResult(boolean r100) {
        this.needLock = r100;
    }

    public void setNeedLock(boolean r100) {
        this.needLock = r100;
    }
}
