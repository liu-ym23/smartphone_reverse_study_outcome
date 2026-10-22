package com.relax;

import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class BackendWorkerJNI {
    private static final String TAG = "BackendWorkerJNI";
    protected long mBackendWorkerPtr;
    protected boolean mDelayInit;
    protected p mErrorReceiver;
    protected long mPlatformShellPtr;
    private RuntimeType mRuntimeType;

    private native void nativeAddEventListener(long r100, String r101, Object r102, Object r103);

    private native byte[] nativeCallRTSFunction(long r100, String r101, Object r102);

    private native void nativeFireEvent(long r100, String r101, byte[] r102);

    private native long nativeGetRawWorker(long r100);

    private native long nativeInitWorker(BackendWorkerJNI r100, int r101);

    private native boolean nativeLoadBytecode(long r100, byte[] r101, String r102);

    private native boolean nativeLoadFile(long r100, byte[] r101, String r102);

    private native boolean nativeLoadScript(long r100, String r101, String r102);

    private native void nativeOnDestroy(long r100);

    private native void nativeRemoveEventListener(long r100, String r101, Object r102);

    private native void nativeSetExtraLibDir(long r100, String r101);

    private native void nativeSetGlobalProps(long r100, Object r101);

    public void onDestroy() {
        nativeOnDestroy(this.mPlatformShellPtr);
    }

    public long getBackendWorkerPtr() {
        return this.mBackendWorkerPtr;
    }

    public BackendWorkerJNI(RuntimeType r100) {
        this.mPlatformShellPtr = 0;
        this.mBackendWorkerPtr = 0;
        this.mErrorReceiver = null;
        this.mDelayInit = false;
        this.mRuntimeType = RuntimeType.RuntimeTypeVM;
        long r101 = nativeInitWorker(this, r100.ordinal());
        this.mPlatformShellPtr = r101;
        this.mBackendWorkerPtr = nativeGetRawWorker(r101);
        this.mRuntimeType = r100;
    }

    public void delayInit(long r100) {
        if (this.mDelayInit == false) goto L6;
        this.mPlatformShellPtr = r100;
        this.mBackendWorkerPtr = nativeGetRawWorker(r100);
        return;
    }

    public void onReceivedError(ByteBuffer r100) {
        if (this.mErrorReceiver == null) goto L29;
        Map r101 = (Map) ipa.c.a(r100);
        new HashMap();
        if (r101.containsKey("code") == false) goto L8;
        ((Integer) r101.get("code")).intValue();
    L8:
        if (r101.containsKey("msg") == false) goto L11;
        String r102 = (String) r101.get("msg");
    L11:
        if (r101.containsKey("stack") == false) goto L13;
        String r103 = (String) r101.get("stack");
    L15:
        if (r101.containsKey("level") == false) goto L18;
        String r104 = (String) r101.get("level");
    L18:
        if (r101.containsKey("type") == false) goto L21;
        ((Integer) r101.get("type")).intValue();
    L21:
        if (r101.containsKey("custom_info") == false) goto L23;
        Map r105 = (Map) r101.get("custom_info");
    L23:
        TextUtils.isEmpty(r103);
        RelaxView r106 = ((RelaxView.l) this.mErrorReceiver).f404606a;
        v r107 = r106.f404564d;
        hpa.c r108 = r106.f404566f;
        if (r108 == null) goto L30;
        hpa.a r109 = r108.f486488a;
        if (r109 == null) goto L31;
        r109.onReceivedError();
        return;
    L31:
        return;
    L30:
        return;
    L13:
        r103 = "";
        goto L15
    }

    public void setErrorReceiver(p r100) {
        this.mErrorReceiver = r100;
    }

    public void setExtraLibDir(String r100) {
        nativeSetExtraLibDir(this.mPlatformShellPtr, r100);
    }

    public void setGlobalProps(ByteBuffer r100) {
        nativeSetGlobalProps(this.mPlatformShellPtr, r100);
    }

    public BackendWorkerJNI(boolean r100, RuntimeType r101) {
        this.mPlatformShellPtr = 0;
        this.mBackendWorkerPtr = 0;
        this.mErrorReceiver = null;
        this.mDelayInit = false;
        RuntimeType r102 = RuntimeType.RuntimeTypeVM;
        this.mDelayInit = true;
        this.mRuntimeType = r101;
    }

    public byte[] callRTSFunction(String r100, ByteBuffer r101) {
        return nativeCallRTSFunction(this.mPlatformShellPtr, r100, r101);
    }

    public void fireEvent(String r100, byte[] r101) {
        nativeFireEvent(this.mPlatformShellPtr, r100, r101);
    }

    public boolean loadBytecode(byte[] r100, String r101) {
        return nativeLoadBytecode(this.mPlatformShellPtr, r100, r101);
    }

    public boolean loadFile(byte[] r100, String r101) {
        return nativeLoadFile(this.mPlatformShellPtr, r100, r101);
    }

    public boolean loadScript(String r100, String r101) {
        return nativeLoadScript(this.mPlatformShellPtr, r100, r101);
    }

    public void removeEventListener(String r100, RelaxEventListener r101) {
        nativeRemoveEventListener(this.mPlatformShellPtr, r100, r101);
    }

    public void addEventListener(String r100, RelaxEventListener r101, RelaxEventListener r102) {
        nativeAddEventListener(this.mPlatformShellPtr, r100, r101, r102);
    }
}
