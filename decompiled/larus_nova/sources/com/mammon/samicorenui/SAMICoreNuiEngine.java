package com.mammon.samicorenui;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class SAMICoreNuiEngine {
    private native int Native_createAsrContext(long r100, Object r101);

    private native int Native_createVadWithJson(long r100, String r101);

    private native int Native_initEngine(long r100, String r101);

    public native long Native_createEngine();

    public native void Native_destroyEngine(long r100);

    public native int Native_resetVad(long r100);

    public native int Native_sendAudioData(long r100, byte[] r101, int r102);

    public native int Native_sendAudioDataWithRef(long r100, byte[] r101, int r102, byte[] r103, int r104);

    public native int Native_sendDirective(long r100, int r101, String r102);

    public native int Native_setParameterBool(long r100, int r101, boolean r102);

    public native int Native_setParameterByteArray(long r100, int r101, byte[] r102);

    public native int Native_setParameterFloat(long r100, int r101, float r102);

    public native int Native_setParameterInt(long r100, int r101, int r102);

    public native int Native_setParameterString(long r100, int r101, String r102);

    public native int Native_setParameterString(long r100, String r101, String r102);

    static {
        Intrinsics.checkNotNullParameter(BuildConfig.LIBNAME, "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> audioeffect");
        a.c(BuildConfig.LIBNAME);
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> audioeffect");
    }

    public SAMICoreNuiEngine() {
    }
}
