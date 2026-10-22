package com.mammon.samicorenui;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class SamiCoreSpeechFingerPrintEnrollContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient long f384370a;

    public static native int Native_SilentEnroll(String r100, int r101);

    public static native int Native_Upload(String r100);

    public native int Native_Cancel(long r100);

    public native int Native_Check(long r100, byte[] r101);

    public native void Native_DeleteSamiCoreSpeechFingerPrintEnrollContext(long r100);

    public native int Native_Enroll(long r100, byte[] r101, int r102);

    public native int Native_Init(long r100, String r101);

    public native long Native_NewSamiCoreSpeechFingerPrintEnrollContext();

    public synchronized void delete() {
        monitor-enter(this);
        long r100 = this.f384370a;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        Native_DeleteSamiCoreSpeechFingerPrintEnrollContext(r100);     // Catch: Throwable -> L8
        this.f384370a = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter(BuildConfig.LIBNAME, "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> audioeffect");
        a.c(BuildConfig.LIBNAME);
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> audioeffect");
    }

    static {
        a();     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.getLocalizedMessage();
        e.printStackTrace();
    }

    public SamiCoreSpeechFingerPrintEnrollContext() {
        this.f384370a = Native_NewSamiCoreSpeechFingerPrintEnrollContext();
    }
}
