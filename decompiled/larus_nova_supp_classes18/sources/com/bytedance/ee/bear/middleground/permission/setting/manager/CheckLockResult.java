package com.bytedance.ee.bear.middleground.permission.setting.manager;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CheckLockResult extends Result<Serializable> {
    private boolean needLock;

    public CheckLockResult() {
    }

    public boolean isNeedLock() {
        return this.needLock;
    }

    public CheckLockResult(boolean r1) {
        this.needLock = r1;
    }

    public void setNeedLock(boolean r1) {
        this.needLock = r1;
    }
}
