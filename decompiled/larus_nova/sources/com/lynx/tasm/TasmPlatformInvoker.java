package com.lynx.tasm;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public class TasmPlatformInvoker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<NativeFacade> f381767a;

    private void onRunPipelineFinished() {
        NativeFacade r100 = this.f381767a.get();
        if (r100 != null) goto L6;
        LLog.i("TasmPlatformInvoker", "OnRunPipelineFinished failed, NativeFacade has been released.");
        return;
    L6:
        r100.onRunPipelineFinished();
    }

    public TasmPlatformInvoker(NativeFacade r100) {
        this.f381767a = new WeakReference(r100);
    }

    private void onPageConfigDecoded(ReadableMap r100) {
        NativeFacade r101 = this.f381767a.get();
        if (r101 != null) goto L6;
        LLog.i("TasmPlatformInvoker", "onPageConfigDecoded failed, NativeFacade has been released.");
        return;
    L6:
        r101.onPageConfigDecoded(r100);
    }

    private void getI18nResourceByNative(String r100, String r101) {
        NativeFacade r102 = this.f381767a.get();
        if (r102 != null) goto L6;
        LLog.i("TasmPlatformInvoker", "getI18nResourceByNative failed, NativeFacade has been released.");
        return;
    L6:
        r102.getI18nResourceByNative(r100, r101);
    }

    private String translateResourceForTheme(String r100, String r101) {
        NativeFacade r102 = this.f381767a.get();
        if (r102 != null) goto L7;
        LLog.i("TasmPlatformInvoker", "translateResourceForTheme failed, NativeFacade has been released.");
        return null;
    L7:
        return r102.translateResourceForTheme(r100, r101);
    }

    private ByteBuffer triggerLepusBridge(String r100, Object r101) {
        NativeFacade r102 = this.f381767a.get();
        if (r102 != null) goto L7;
        LLog.i("TasmPlatformInvoker", "triggerLepusBridge failed, NativeFacade has been released.");
        return null;
    L7:
        return r102.triggerLepusBridge(r100, r101);
    }

    private void triggerLepusBridgeAsync(String r100, Object r101) {
        NativeFacade r102 = this.f381767a.get();
        if (r102 != null) goto L6;
        LLog.i("TasmPlatformInvoker", "triggerLepusBridgeAsync failed, NativeFacade has been released.");
        return;
    L6:
        r102.triggerLepusBridgeAsync(r100, r101);
    }
}
