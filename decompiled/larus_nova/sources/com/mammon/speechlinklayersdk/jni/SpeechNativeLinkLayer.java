package com.mammon.speechlinklayersdk.jni;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import com.mammon.audiosdk.SAMICore;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeBlock;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeProperty;
import com.mammon.speechlinklayersdk.jni.callback.SpeechNativeLinkLayerCallback;
import com.mammon.speechlinklayersdk.param.SpeechLinkLayerUplinkCallbackParam;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class SpeechNativeLinkLayer {
    public static final String TAG = "mammon SpeechNativeLinkLayer";
    private boolean enableSyncInterface;
    private long nativeHandle;
    private SpeechNativeLinkLayerCallback nativeLinkLayerCallback;
    private final ReentrantReadWriteLock readWriteLock;
    private final SAMICore samiCore;

    private native long Native_SpeechCreateHandle(int r100, Object r101, int[] r102);

    private native int Native_SpeechDestroyHandle(long r100);

    private native int Native_SpeechGetProperty(long r100, int r101, SpeechNativeProperty r102);

    private native int Native_SpeechProcess(long r100, SpeechNativeBlock r101, SpeechNativeBlock r102);

    private native int Native_SpeechSetProperty(long r100, SpeechNativeProperty r101);

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    static {
        INVOKESTATIC_com_mammon_speechlinklayersdk_jni_SpeechNativeLinkLayer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(BuildConfig.LIBNAME);     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        Objects.requireNonNull(e.getLocalizedMessage());
    }

    public void destroyHandle() {
        if (this.nativeHandle != 0) goto L6;
        return;
    L6:
        if (this.enableSyncInterface == false) goto L20;
        this.readWriteLock.writeLock().lock();
    L20:
        long r100 = this.nativeHandle;     // Catch: Throwable -> L15
        if (r100 == 0) goto L12;
        Native_SpeechDestroyHandle(r100);     // Catch: Throwable -> L15
        this.nativeHandle = 0;     // Catch: Throwable -> L15
    L12:
        if (this.enableSyncInterface == false) goto L22;
        this.readWriteLock.writeLock().unlock();
        return;
    L22:
        return;
    L15:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L19;
        this.readWriteLock.writeLock().unlock();
    L19:
        throw th;
    }

    public SpeechNativeLinkLayer() {
        this.samiCore = new SAMICore();
        this.enableSyncInterface = false;
        this.readWriteLock = new ReentrantReadWriteLock();
        this.nativeHandle = 0;
    }

    public long getNativeHandle() {
        return this.nativeHandle;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_mammon_speechlinklayersdk_jni_SpeechNativeLinkLayer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public void onUplinkCallback(SpeechLinkLayerUplinkCallbackParam r100) {
        this.nativeLinkLayerCallback.onUplinkCallback(r100);
    }

    public void setEnableSyncInterface(boolean r100) {
        this.enableSyncInterface = r100;
    }

    public void setNativeLinkLayerCallback(SpeechNativeLinkLayerCallback r100) {
        this.nativeLinkLayerCallback = r100;
    }

    public int setProperty(SpeechNativeProperty r100) {
        int r101 = 100010;
        if (this.nativeHandle != 0) goto L6;
        return 100010;
    L6:
        if (this.enableSyncInterface == false) goto L20;
        this.readWriteLock.readLock().lock();
    L20:
        long r102 = this.nativeHandle;     // Catch: Throwable -> L15
        if (r102 == 0) goto L12;
        r101 = Native_SpeechSetProperty(r102, r100);     // Catch: Throwable -> L15
    L12:
        if (this.enableSyncInterface == false) goto L14;
        this.readWriteLock.readLock().unlock();
    L14:
        return r101;
    L15:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L19;
        this.readWriteLock.readLock().unlock();
    L19:
        throw th;
    }

    public int createHandle(int r100, Object r101) {
        if (this.enableSyncInterface == false) goto L5;
        this.readWriteLock.readLock().lock();
    L5:
        int[] r102 = {0};
        this.nativeHandle = Native_SpeechCreateHandle(r100, r101, r102);     // Catch: Throwable -> L12
        if (this.enableSyncInterface == false) goto L11;
        this.readWriteLock.readLock().unlock();
    L11:
        return r102[0];
    L12:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L16;
        this.readWriteLock.readLock().unlock();
    L16:
        throw th;
    }

    public int process(SpeechNativeBlock r100, SpeechNativeBlock r101) {
        if (this.nativeHandle != 0) goto L7;
        return 100010;
    L7:
        if (this.enableSyncInterface == false) goto L23;
        this.readWriteLock.readLock().lock();
    L23:
        long r102 = this.nativeHandle;     // Catch: Throwable -> L18
        if (r102 == 0) goto L13;
        int r103 = Native_SpeechProcess(r102, r100, r101);     // Catch: Throwable -> L18
    L15:
        if (this.enableSyncInterface == false) goto L17;
        this.readWriteLock.readLock().unlock();
    L17:
        return r103;
    L13:
        r103 = 0;
    L18:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L22;
        this.readWriteLock.readLock().unlock();
    L22:
        throw th;
    }
}
