package com.bytedance.sysoptimizer.javahook;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyViewRootImpl {
    private static final String TAG = "ProxyViewRootImpl";

    public ProxyViewRootImpl(Context r100, Display r101) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_VIEWROOTIMPL_INIT, this, new Object[]{r100, r101});
        AHook.getCallback().e(TAG, "ProxyViewRootImpl() called with: context = [" + r100 + "], display = [" + r101 + "]", new Throwable());
    }

    public ProxyViewRootImpl(Context r100, Display r101, Object r102) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_VIEWROOTIMPL_INIT_2, this, new Object[]{r100, r101, r102});
        AHook.getCallback().e(TAG, "ProxyViewRootImpl() called with: context = [" + r100 + "], display = [" + r101 + "], session = [" + r102 + "]", new Throwable());
    }

    public ProxyViewRootImpl(Context r100, Display r101, Object r102, boolean r103) throws Throwable {
        int r104 = 0;
        AHook.callOrigin(OriginMethodKey.KEY_VIEWROOTIMPL_INIT_3, this, new Object[]{r100, r101, r102, Boolean.valueOf(r103)});
        String r105 = "ProxyViewRootImpl() called with: context = [" + r100 + "], display = [" + r101 + "], session = [" + r102 + "], b = [" + r103 + "]";
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L6;
        r105 = r105 + ", ContextWrapper" + r104 + " = " + r100;
        r100 = ((ContextWrapper) r100).getBaseContext();
        r104 = r104 + 1;
        goto L4
    L6:
        AHook.getCallback().e(TAG, r105, new Throwable());
    }

    public ProxyViewRootImpl(Context r100, Display r101, Object r102, Object r103) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_VIEWROOTIMPL_INIT_1, this, new Object[]{r100, r101, r102, r103});
        AHook.getCallback().e(TAG, "ProxyViewRootImpl() called with: context = [" + r100 + "], display = [" + r101 + "], session = [" + r102 + "], windowLayout = [" + r103 + "]", new Throwable());
    }
}
