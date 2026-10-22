package com.bytedance.ee.docsdk.impl.document.plugins.codeblock;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes18.dex */
public abstract class DiffObserver<T> implements Observer<T> {
    private T mLastData;

    public DiffObserver() {
    }

    public abstract void onChange(T r100);

    @Override // androidx.lifecycle.Observer
    public void onChanged(T r100) {
        if (r100 != null) goto L7;
        if (this.mLastData == null) goto L10;
        onChange(null);
        this.mLastData = null;
        return;
    L10:
        return;
    L7:
        if (r100.equals(this.mLastData) == true) goto L12;
        onChange(r100);
        this.mLastData = r100;
        return;
    }
}
