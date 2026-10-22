package com.lynx.tasm.behavior.ui.krypton;

import com.lynx.jsbridge.d;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c;

/* JADX INFO: loaded from: classes32.dex */
public class LynxKryptonModule extends d {
    public static final String TAG = "LynxKryptonModule";
    private LynxKryptonHelper mKryptonHelper;
    private long mNativePtr;

    private native long nativeCreate();

    private native void nativeDestroy(long r100);

    private native long nativeGetExtensionDelegatePtr(long r100, long r101);

    @Override // com.lynx.jsbridge.d
    public void destroy() {
        this.mKryptonHelper.deInit();
        nativeDestroy(this.mNativePtr);
        this.mNativePtr = 0;
    }

    @Override // com.lynx.jsbridge.d
    public long getExtensionDelegatePtr() {
        if (this.mNativePtr != 0) goto L6;
        LLog.e(TAG, "native ptr is 0");
        return 0;
    L6:
        CanvasRuntimeMediator r100 = new CanvasRuntimeMediator(this.mContext);
        this.mKryptonHelper.registerCanvasRuntimeMediator(r100);
        long r101 = r100.getNativePtr();
        if (r101 != 0) goto L10;
        LLog.e(TAG, "mediator ptr is 0");
        return 0;
    L10:
        long r102 = nativeGetExtensionDelegatePtr(this.mNativePtr, r101);
        r100.resetNativePtr(r101);
        return r102;
    }

    @Override // com.lynx.jsbridge.d
    public void setUp() {
        LynxGroup r100 = this.mGroup;
        if (r100 == null) goto L10;
        if (r100.enableCanvas() == false) goto L10;
        LLog.i(TAG, "LynxKryptonModule setup success with LynxGroup id: " + this.mGroup.getID() + " current url: " + this.mContext.getTemplateUrl());
        this.mKryptonHelper.setupCanvasIfEnableCanvas();
        return;
    L10:
        if (this.mGroup != null) goto L12;
        LLog.e(TAG, "LynxKryptonModule setup failed because LynxGroup is null, current url: " + this.mContext.getTemplateUrl());
        return;
    L12:
        LLog.e(TAG, "LynxKryptonModule setup failed because LynxGroup id: " + this.mGroup.getID() + " is not enable canvas, current url: " + this.mContext.getTemplateUrl());
    }

    public LynxKryptonHelper getLynxKryptonHelper() {
        return this.mKryptonHelper;
    }

    @Override // com.lynx.jsbridge.d
    public void onTemplateLoad(String r100) {
        LLog.i(TAG, "LynxKryptonModule onTemplateLoad " + r100 + " this: " + this);
        this.mKryptonHelper.onTemplateLoad(r100);
    }

    public LynxKryptonModule(LynxContext r100, LynxGroup r101, c r102) {
        super(r100, r101, r102);
        this.mNativePtr = 0;
        this.mKryptonHelper = new LynxKryptonHelper(r102);
        this.mNativePtr = nativeCreate();
        LLog.i(TAG, "LynxKryptonModule create");
    }
}
