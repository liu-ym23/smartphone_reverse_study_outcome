package com.mammon.audiosdk.audiometrics;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class AudioMetricsLite {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public synchronized void delete() {
        monitor-enter(this);
        long r100 = this.swigCPtr;     // Catch: Throwable -> L11
        if (r100 != 0) goto L6;
    L9:
        monitor-exit(this);
        return;
    L6:
        if (this.swigCMemOwn == false) goto L8;
        this.swigCMemOwn = false;     // Catch: Throwable -> L11
        AduioMetricLiteModuleJNI.delete_AudioMetricsLite(r100);     // Catch: Throwable -> L11
    L8:
        this.swigCPtr = 0;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    static {
        INVOKESTATIC_com_mammon_audiosdk_audiometrics_AudioMetricsLite_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(BuildConfig.LIBNAME);
    }

    public String get_result() {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_get_result__SWIG_1(this.swigCPtr, this);
    }

    public int init() {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_init(this.swigCPtr, this);
    }

    public int process_tail() {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_process_tail(this.swigCPtr, this);
    }

    public void release() {
        AduioMetricLiteModuleJNI.AudioMetricsLite_release(this.swigCPtr, this);
    }

    public int reset() {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_reset(this.swigCPtr, this);
    }

    public String version() {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_version(this.swigCPtr, this);
    }

    public AudioMetricsLite() {
        this(AduioMetricLiteModuleJNI.new_AudioMetricsLite(), true);
    }

    public void finalize() {
        delete();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_mammon_audiosdk_audiometrics_AudioMetricsLite_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static long getCPtr(AudioMetricsLite r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.swigCPtr;
    }

    public static long swigRelease(AudioMetricsLite r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        if (r100.swigCMemOwn == false) goto L7;
        long r101 = r100.swigCPtr;
        r100.swigCMemOwn = false;
        r100.delete();
        return r101;
    L7:
        throw new RuntimeException("Cannot release ownership as memory is not owned");
    }

    public String get_result(int r100) {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_get_result__SWIG_0(this.swigCPtr, this, r100);
    }

    public int prepare(String r100) {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_prepare(this.swigCPtr, this, r100);
    }

    public AudioMetricsLite(long r100, boolean r101) {
        this.swigCMemOwn = r101;
        this.swigCPtr = r100;
    }

    public int process(float[] r100, int r101, int r102) {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_process__SWIG_1(this.swigCPtr, this, r100, r101, r102);
    }
}
