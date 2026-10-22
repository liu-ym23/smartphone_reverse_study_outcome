package com.bytedance.ee.bear.contract.net;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class NetServiceExpandResult<T extends Serializable> extends Result<T> {
    public Throwable exception;
    public Serializable failData;

    public boolean isSuccess() {
        if (this.code != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public NetServiceExpandResult() {
    }

    public Throwable getException() {
        return this.exception;
    }

    public <E> E getFailDataOrNull(Class<E> r2) {
        Serializable r0 = this.failData;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r2.isAssignableFrom(r0.getClass()) == true) goto L7;
        return null;
    L7:
        return (E) this.failData;
    }

    public void setException(Throwable r1) {
        this.exception = r1;
    }

    public void setFailData(Serializable r1) {
        this.failData = r1;
    }
}
