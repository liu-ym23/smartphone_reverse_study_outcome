package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.c;

/* JADX INFO: loaded from: classes23.dex */
public class CancellationTokenSource {
    public c impl;

    public CancellationTokenSource() {
        this.impl = new c();
    }

    public void cancel() {
        this.impl.a();
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
