package com.bytedance.ee.docsdk.impl.document.plugins.codeblock;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class DiffObserver<T> implements Observer<T> {
    private T mLastData;

    public DiffObserver() {
    }

    public abstract void onChange(T r1);

    public void onChanged(T r2) {
        if (r2 != null) goto L7;
        if (this.mLastData == null) goto L10;
        onChange(null);
        this.mLastData = null;
        return;
    L10:
        return;
    L7:
        if (r2.equals(this.mLastData) == true) goto L12;
        onChange(r2);
        this.mLastData = r2;
        return;
    }
}
