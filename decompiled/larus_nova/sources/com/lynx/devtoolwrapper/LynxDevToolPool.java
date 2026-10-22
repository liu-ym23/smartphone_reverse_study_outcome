package com.lynx.devtoolwrapper;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public class LynxDevToolPool {
    private static final String TAG = "LynxDevToolPool";
    private static int nextContextId;
    private boolean mDebuggable;
    private List<LynxDevtool> mDevtools;
    private long mNativePtr;
    private String mUrl;

    private native long nativeCreateDevToolPool();

    private native void nativeDestroyDevToolPool(long r100);

    public void destroy() {
        if (this.mDevtools.isEmpty() == true) goto L5;
        this.mDevtools.forEach(new b());
        this.mDevtools.clear();
    L5:
        long r100 = this.mNativePtr;
        if (r100 == 0) goto L9;
        nativeDestroyDevToolPool(r100);
        this.mNativePtr = 0;
        return;
    }

    public void popDevTool() {
        if (this.mDevtools.isEmpty() == false) goto L5;
        return;
    L5:
        List<LynxDevtool> r100 = this.mDevtools;
        ((LynxDevtool) ListProtector.get(r100, r100.size() - 1)).destroy();
        List<LynxDevtool> r101 = this.mDevtools;
        ListProtector.remove(r101, r101.size() - 1);
    }

    public void createDevTool() {
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L6;
        this.mDevtools.add(new LynxDevtool(null, this.mDebuggable));
        return;
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    public void onMTSRuntimeCreated(long r100) {
        if (this.mDevtools.isEmpty() == false) goto L5;
        return;
    L5:
        List<LynxDevtool> r101 = this.mDevtools;
        LynxDevtool r102 = (LynxDevtool) ListProtector.get(r101, r101.size() - 1);
        r102.onMTSRuntimeCreated(r100);
        int r103 = nextContextId;
        nextContextId = r103 + 1;
        r102.attachToDebugBridge(String.format("%s - context%d", new Object[]{this.mUrl, Integer.valueOf(r103)}));
    }

    public LynxDevToolPool(String r100, boolean r101) {
        this.mDebuggable = false;
        this.mNativePtr = 0;
        LLog.i(TAG, "create LynxDevToolPool, url: " + r100 + ", debuggable: " + r101);
        this.mDevtools = new ArrayList();
        this.mDebuggable = r101;
        this.mUrl = r100;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.mUrl = "anonymous bundle";
    L5:
        this.mNativePtr = nativeCreateDevToolPool();
    }
}
