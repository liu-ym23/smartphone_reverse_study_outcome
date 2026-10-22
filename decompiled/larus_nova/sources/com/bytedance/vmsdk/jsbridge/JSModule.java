package com.bytedance.vmsdk.jsbridge;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JSModule {
    protected Context mContext;
    protected Object mParam;

    public JSModule(Context r100) {
        this(r100, null);
    }

    public JSModule(Context r100, Object r101) {
        this.mContext = r100;
        this.mParam = r101;
    }
}
