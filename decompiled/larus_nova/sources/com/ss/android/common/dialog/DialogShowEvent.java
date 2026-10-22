package com.ss.android.common.dialog;

import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class DialogShowEvent implements Serializable {
    private boolean isShow;
    private Object mValue;

    public Object getValue() {
        return this.mValue;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public DialogShowEvent(boolean r100, Object r101) {
        this.isShow = r100;
        this.mValue = r101;
    }
}
