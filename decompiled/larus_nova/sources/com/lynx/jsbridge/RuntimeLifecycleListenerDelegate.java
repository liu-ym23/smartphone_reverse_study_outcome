package com.lynx.jsbridge;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.CallStackUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public class RuntimeLifecycleListenerDelegate implements g {
    private static final String TAG = "RuntimeListenerDelegate";
    private g mListener;
    private final WeakReference<LynxContext> mLynxContextWeak;

    @Override // com.lynx.jsbridge.g
    public void onRuntimeDetach() {
        g r100 = this.mListener;
        if (r100 == null) goto L11;
        r100.onRuntimeDetach();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        onError(e);
        return;
    }

    private void onError(Exception r100) {
        LLog.e(TAG, r100.toString());
        LynxContext r101 = this.mLynxContextWeak.get();
        if (r101 == null) goto L6;
        String r102 = CallStackUtil.a(r100);
        LynxError r103 = new LynxError(20301, r100.getMessage());
        r103.setCallStack(r102);
        r101.handleLynxError(r103);
        return;
    }

    public RuntimeLifecycleListenerDelegate(WeakReference<LynxContext> r100, g r101) {
        this.mLynxContextWeak = r100;
        this.mListener = r101;
    }

    @Override // com.lynx.jsbridge.g
    public void onRuntimeAttach(long r100, String r101) {
        g r102 = this.mListener;
        if (r102 == null) goto L11;
        r102.onRuntimeAttach(r100, r101);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        onError(e);
        return;
    }
}
