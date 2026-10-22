package com.larus.im.internal.jni.dependency;

import com.larus.im.FlowRuntime;
import gd9.l;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniAppStateCallByNative;", "Lcom/larus/im/depend/IAppHost$IAppBackgroundListener;", "nativePtr", "", "<init>", "(J)V", "registered", "", "released", "notifyAppEnterBackground", "", "notifyAppBecomeActive", "initialize", "release", "isAppBackground", "onAppLifeCycleChange", "isBackground", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAppStateCallByNative implements l.b {
    private final long nativePtr;
    private volatile boolean registered;
    private volatile boolean released;

    public static /* synthetic */ void a(OmniAppStateCallByNative r100) {
        initialize$lambda$0(r100);
    }

    private final native void notifyAppBecomeActive(long r100);

    private final native void notifyAppEnterBackground(long r100);

    public final void release() {
        monitor-enter(this);
        this.released = true;     // Catch: Throwable -> L11
        if (this.registered == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        com.larus.im.internal.delegate.c.f348197a.q(this);     // Catch: Throwable -> L11
        this.registered = false;     // Catch: Throwable -> L11
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void initialize() {
        if (FlowRuntime.d() == true) goto L7;
        FlowRuntime.e(new a(this));
        if (FlowRuntime.d() == true) goto L7;
        return;
    L7:
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L9:
        if (this.registered == false) goto L11;
    L17:
        monitor-exit(this);
        return;
    L11:
        if (this.released == true) goto L17;
        com.larus.im.internal.delegate.c r100 = com.larus.im.internal.delegate.c.f348197a;     // Catch: Throwable -> L19
        r100.r(this);     // Catch: Throwable -> L19
        this.registered = true;     // Catch: Throwable -> L19
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        onAppLifeCycleChange(!r100.b());
    }

    public final boolean isAppBackground() {
        if (FlowRuntime.d() == true) goto L7;
        return false;
    L7:
        return !com.larus.im.internal.delegate.c.f348197a.b();
    }

    public OmniAppStateCallByNative(long r100) {
        this.nativePtr = r100;
    }

    private static final void initialize$lambda$0(OmniAppStateCallByNative r100) {
        r100.initialize();
    }

    @Override // gd9.l.b
    public void onAppLifeCycleChange(boolean r100) {
        if (this.released == false) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        notifyAppEnterBackground(this.nativePtr);
        return;
    L7:
        notifyAppBecomeActive(this.nativePtr);
    }
}
