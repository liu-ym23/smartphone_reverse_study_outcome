package com.mammon.speechaudiosdk.jni;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import com.mammon.audiosdk.SAMICore;
import com.mammon.speechaudiosdk.jni.callback.SpeechNativeCallback;
import com.mammon.speechaudiosdk.jni.callback.SpeechNativeRecorderAudioConsumerCallback;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeBlock;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeProperty;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeRecorderAudioConsumerCallbackData;
import com.mammon.speechaudiosdk.session.callback.SpeechSessionEventCallback;
import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionDownlinkCallbackParam;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class SpeechNativeCore {
    private boolean enableSyncInterface;
    private int identify;
    private SpeechNativeCallback nativeCallback;
    private long nativeHandle;
    private final ReentrantReadWriteLock readWriteLock;
    private SpeechNativeRecorderAudioConsumerCallback recorderConsumerCallback;
    private SAMICore samiCore;
    private SpeechSessionEventCallback sessionEventCallback;

    private native long Native_SpeechCreateHandle(int r100, Object r101, int[] r102);

    private native int Native_SpeechDestroyHandle(long r100);

    private native int Native_SpeechGetProperty(long r100, int r101, SpeechNativeProperty r102);

    private native int Native_SpeechProcess(long r100, int r101, SpeechNativeBlock r102, SpeechNativeBlock r103);

    private native int Native_SpeechSetProperty(long r100, SpeechNativeProperty r101);

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    static {
        INVOKESTATIC_com_mammon_speechaudiosdk_jni_SpeechNativeCore_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(BuildConfig.LIBNAME);     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        Objects.requireNonNull(e.getLocalizedMessage());
    }

    public void destroyHandle() {
        if (this.enableSyncInterface == false) goto L17;
        this.readWriteLock.writeLock().lock();
    L17:
        long r100 = this.nativeHandle;     // Catch: Throwable -> L12
        if (r100 == 0) goto L9;
        Native_SpeechDestroyHandle(r100);     // Catch: Throwable -> L12
        this.nativeHandle = 0;     // Catch: Throwable -> L12
    L9:
        if (this.enableSyncInterface == false) goto L19;
        this.readWriteLock.writeLock().unlock();
        return;
    L19:
        return;
    L12:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L16;
        this.readWriteLock.writeLock().unlock();
    L16:
        throw th;
    }

    public SpeechNativeCore() {
        this.samiCore = new SAMICore();
        this.enableSyncInterface = false;
        this.readWriteLock = new ReentrantReadWriteLock();
        this.nativeHandle = 0;
    }

    public long getNativeHandle() {
        return this.nativeHandle;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_mammon_speechaudiosdk_jni_SpeechNativeCore_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public void onDownlinkCallback(SpeechHostInjectionDownlinkCallbackParam r100) {
        SpeechNativeCallback r101 = this.nativeCallback;
        if (r101 == null) goto L6;
        r101.onDownlinkCallback(r100);
        return;
    }

    public void setEnableSyncInterface(boolean r100) {
        this.enableSyncInterface = r100;
    }

    public int setProperty(SpeechNativeProperty r100) {
        if (this.enableSyncInterface == false) goto L19;
        this.readWriteLock.readLock().lock();
    L19:
        long r101 = this.nativeHandle;     // Catch: Throwable -> L14
        if (r101 == 0) goto L9;
        int r102 = Native_SpeechSetProperty(r101, r100);     // Catch: Throwable -> L14
    L11:
        if (this.enableSyncInterface == false) goto L13;
        this.readWriteLock.readLock().unlock();
    L13:
        return r102;
    L9:
        r102 = 100010;
    L14:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L18;
        this.readWriteLock.readLock().unlock();
    L18:
        throw th;
    }

    public void setRecorderAudioConsumerCallback(SpeechNativeRecorderAudioConsumerCallback r100) {
        this.recorderConsumerCallback = r100;
    }

    public void setSessionEventCallback(SpeechSessionEventCallback r100) {
        this.sessionEventCallback = r100;
    }

    public void setSpeechNativeCallback(SpeechNativeCallback r100) {
        this.nativeCallback = r100;
    }

    public int createHandle(int r100, Object r101) {
        if (this.enableSyncInterface == false) goto L5;
        this.readWriteLock.readLock().lock();
    L5:
        this.identify = r100;
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

    public int getProperty(int r100, SpeechNativeProperty r101) {
        return Native_SpeechGetProperty(this.nativeHandle, r100, r101);
    }

    public void onEvent(int r100, String r101) {
        SpeechSessionEventCallback r102 = this.sessionEventCallback;
        if (r102 == null) goto L6;
        r102.onEvent(r100, r101);
        return;
    }

    public int process(SpeechNativeBlock r100, SpeechNativeBlock r101) {
        if (this.enableSyncInterface == false) goto L19;
        this.readWriteLock.readLock().lock();
    L19:
        long r102 = this.nativeHandle;     // Catch: Throwable -> L14
        if (r102 == 0) goto L9;
        int r103 = Native_SpeechProcess(r102, this.identify, r100, r101);     // Catch: Throwable -> L14
    L11:
        if (this.enableSyncInterface == false) goto L13;
        this.readWriteLock.readLock().unlock();
    L13:
        return r103;
    L9:
        r103 = 0;
    L14:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L18;
        this.readWriteLock.readLock().unlock();
    L18:
        throw th;
    }

    public void onRecorderAudioConsumerCallback(int r100, String r101, SpeechNativeRecorderAudioConsumerCallbackData r102) {
        SpeechNativeRecorderAudioConsumerCallback r103 = this.recorderConsumerCallback;
        if (r103 == null) goto L6;
        r103.onCallback(r100, r101, r102);
        return;
    }
}
