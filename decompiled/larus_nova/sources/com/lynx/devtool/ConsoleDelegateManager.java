package com.lynx.devtool;

import com.lynx.react.bridge.Callback;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes32.dex */
public class ConsoleDelegateManager {
    private static AtomicInteger nextCallbackId;
    private com.lynx.devtoolwrapper.LynxInspectorConsoleDelegate mConsoleDelegate;
    private HashMap<Integer, Callback> mConsoleObjectCallback;

    static {
        nextCallbackId = new AtomicInteger(0);
    }

    public ConsoleDelegateManager() {
        this.mConsoleDelegate = null;
        this.mConsoleObjectCallback = null;
    }

    public void onConsoleMessage(String r100) {
        com.lynx.devtoolwrapper.LynxInspectorConsoleDelegate r101 = this.mConsoleDelegate;
        if (r101 == null) goto L6;
        r101.onConsoleMessage(r100);
        return;
    }

    public void onConsoleObject(String r100, int r101) {
        HashMap<Integer, Callback> r102 = this.mConsoleObjectCallback;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.containsKey(Integer.valueOf(r101)) == false) goto L12;
        Callback r103 = this.mConsoleObjectCallback.get(Integer.valueOf(r101));
        if (r103 == null) goto L9;
        r103.invoke(new Object[]{r100});
    L9:
        this.mConsoleObjectCallback.remove(Integer.valueOf(r101));
        return;
    }

    public void setLynxInspectorConsoleDelegate(Object r100, DevToolPlatformAndroidDelegate r101, long r102) {
        if ((r100 instanceof com.lynx.devtoolwrapper.LynxInspectorConsoleDelegate) == false) goto L10;
        this.mConsoleDelegate = (com.lynx.devtoolwrapper.LynxInspectorConsoleDelegate) r100;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r102 == 0) goto L12;
        r101.nativeFlushConsoleMessages(r102);
        return;
    L12:
        return;
    }

    public void getConsoleObject(String r100, boolean r101, Callback r110, DevToolPlatformAndroidDelegate r111, long r112) {
        if (r111 != null) goto L4;
        return;
    L4:
        if (r112 != 0) goto L6;
        return;
    L6:
        if (this.mConsoleObjectCallback != null) goto L8;
        this.mConsoleObjectCallback = new HashMap();
    L8:
        int r102 = nextCallbackId.decrementAndGet();
        this.mConsoleObjectCallback.put(Integer.valueOf(r102), r110);
        r111.nativeGetConsoleObject(r112, r100, r101, r102);
    }
}
