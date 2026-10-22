package com.lynx.devtoolwrapper;

import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public class DevToolLifecycle {
    private static final String TAG = "DevToolLifecycle";
    private static volatile DevToolLifecycle sInstance;
    private volatile DevToolState mState;

    private native void nativeSyncStateToNative(int r100);

    public synchronized void onConnected() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mState != DevToolState.INITIALIZED) goto L6;
        LLog.i(TAG, "DevTool client connected. Transitioning to CONNECTED.");     // Catch: Throwable -> L8
        this.mState = DevToolState.CONNECTED;     // Catch: Throwable -> L8
        syncStateToNative();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized void onDisabled() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mState != DevToolState.ENABLED) goto L6;
    L9:
        LLog.i(TAG, "DevTool disabled. Transitioning to ATTACHED.");     // Catch: Throwable -> L12
        this.mState = DevToolState.ATTACHED;     // Catch: Throwable -> L12
        syncStateToNative();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        if (this.mState == DevToolState.INITIALIZED) goto L9;
        if (this.mState != DevToolState.CONNECTED) goto L10;
        goto L9
    }

    public synchronized void onDisconnected() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mState != DevToolState.CONNECTED) goto L6;
        LLog.i(TAG, "DevTool client disconnected. Transitioning to INITIALIZED.");     // Catch: Throwable -> L8
        this.mState = DevToolState.INITIALIZED;     // Catch: Throwable -> L8
        syncStateToNative();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized void onInitialized() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mState != DevToolState.ENABLED) goto L6;
        LLog.i(TAG, "DevTool env initialized. Transitioning to INITIALIZED.");     // Catch: Throwable -> L8
        this.mState = DevToolState.INITIALIZED;     // Catch: Throwable -> L8
        syncStateToNative();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public static DevToolLifecycle getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(DevToolLifecycle.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DevToolLifecycle();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DevToolLifecycle.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private synchronized void syncStateToNative() {
        monitor-enter(this);
        nativeSyncStateToNative(this.mState.ordinal());     // Catch: Throwable -> L6 UnsatisfiedLinkError -> L8
    L9:
        monitor-exit(this);
        return;
    L8:
        LLog.w(TAG, "UnsatisfiedLinkError! Trying to sync state [" + this.mState + "] before native library is loaded.");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public boolean isAttached() {
        if (this.mState.ordinal() < DevToolState.ATTACHED.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isConnected() {
        if (this.mState.ordinal() < DevToolState.CONNECTED.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEnabled() {
        if (this.mState.ordinal() < DevToolState.ENABLED.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInitialized() {
        if (this.mState.ordinal() < DevToolState.INITIALIZED.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public synchronized void onAttached() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != DevToolState.UNAVAILABLE) goto L7;
        LLog.i(TAG, "DevTool attached. Transitioning to ATTACHED.");     // Catch: Throwable -> L10
        this.mState = DevToolState.ATTACHED;     // Catch: Throwable -> L10
        syncStateToNative();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L7:
        LLog.w(TAG, "onAttached() called but state is " + this.mState);     // Catch: Throwable -> L10
        goto L8
    }

    public synchronized void onEnabled() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != DevToolState.ATTACHED) goto L8;
        LLog.i(TAG, "DevTool enabled. Transitioning to ENABLED.");     // Catch: Throwable -> L13
        this.mState = DevToolState.ENABLED;     // Catch: Throwable -> L13
        syncStateToNative();     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L8:
        if (this.mState != DevToolState.UNAVAILABLE) goto L10;
        LLog.w(TAG, "Cannot enable DevTool because it is " + this.mState);     // Catch: Throwable -> L13
        goto L11
    L10:
        LLog.d(TAG, "onEnabled() called but state is " + this.mState);     // Catch: Throwable -> L13
        goto L11
    }

    public void reset() {
        this.mState = DevToolState.UNAVAILABLE;
    }

    private DevToolLifecycle() {
        this.mState = DevToolState.UNAVAILABLE;
    }

    public DevToolState getState() {
        return this.mState;
    }

    private static synchronized void syncStateFromNative(int r100) {
        monitor-enter(DevToolLifecycle.class);
        DevToolLifecycle r101 = getInstance();     // Catch: Throwable -> L14
        DevToolState r102 = r101.mState;     // Catch: Throwable -> L14
        DevToolState r103 = DevToolState.values()[r100];     // Catch: ArrayIndexOutOfBoundsException -> L11 Throwable -> L14
    L7:
        if (r101.mState == r103) goto L9;
        LLog.i(TAG, "SyncStateFromNative: Transitioning from " + r101.mState + " to " + r103);     // Catch: Throwable -> L14
        r101.mState = r103;     // Catch: Throwable -> L14
    L9:
        monitor-exit(DevToolLifecycle.class);
        return;
    L11:
        LLog.e(TAG, "Invalid value during state sync. The definition of states in Android platform and native are not identical");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
