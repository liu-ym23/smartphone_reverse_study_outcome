package com.bytedance.lynx.webview.glue;

import android.os.Bundle;
import i17.d;

/* JADX INFO: loaded from: classes21.dex */
public abstract class TTWebViewPlugin {
    private d mPluginInvokerWrapper;

    public abstract boolean execute(String r100, Bundle r101);

    public abstract Object get(String r100);

    public TTWebViewPlugin(Object r100) {
        this.mPluginInvokerWrapper = new d(r100);
    }

    public Object query(String r100) {
        d r101 = this.mPluginInvokerWrapper;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.query(r100);
    }

    public boolean inform(String r100, Object r101) {
        d r102 = this.mPluginInvokerWrapper;
        if (r102 != null) goto L5;
        return false;
    L5:
        return r102.inform(r100, r101);
    }
}
