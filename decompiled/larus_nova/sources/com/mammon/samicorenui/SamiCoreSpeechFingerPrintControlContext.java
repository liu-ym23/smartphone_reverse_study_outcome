package com.mammon.samicorenui;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class SamiCoreSpeechFingerPrintControlContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient long f384369a;

    public native void Native_deleteSamiCoreSpeechFingerPrintControlContext(long r100);

    public native int Native_init(long r100, String r101);

    public native long Native_newSamiCoreSpeechFingerPrintControlContext();

    public native int Native_toggle(long r100, int r101);

    public synchronized void delete() {
        monitor-enter(this);
        long r100 = this.f384369a;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        Native_deleteSamiCoreSpeechFingerPrintControlContext(r100);     // Catch: Throwable -> L8
        this.f384369a = 0;     // Catch: Throwable -> L8
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

    public SamiCoreSpeechFingerPrintControlContext() {
        this.f384369a = 0;
        this.f384369a = Native_newSamiCoreSpeechFingerPrintControlContext();
    }
}
