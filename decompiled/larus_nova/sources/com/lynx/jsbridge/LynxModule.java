package com.lynx.jsbridge;

import android.content.Context;
import com.lynx.react.bridge.JavaOnlyArray;

/* JADX INFO: loaded from: classes32.dex */
public abstract class LynxModule {
    protected Context mContext;
    protected Object mExtraData;
    protected Object mParam;

    public interface a {
        boolean a(String r100, String r101, JavaOnlyArray r102);
    }

    public void destroy() {
    }

    public LynxModule(Context r100) {
        this(r100, null);
    }

    public void setExtraData(Object r100) {
        this.mExtraData = r100;
    }

    public LynxModule(Context r100, Object r101) {
        this.mContext = r100;
        this.mParam = r101;
    }
}
