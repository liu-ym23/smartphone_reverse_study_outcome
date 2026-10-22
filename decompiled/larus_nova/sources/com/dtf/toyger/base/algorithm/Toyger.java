package com.dtf.toyger.base.algorithm;

import android.content.Context;
import com.bytedance.librarian.a;
import com.dtf.toyger.base.ToygerAttr;
import com.dtf.toyger.base.face.ToygerDataInfo;
import com.larus.utils.logger.FLogger;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public class Toyger {
    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native ByteBuffer allocData(long r100);

    public static native ByteBuffer allocDepthFrameData(long r100);

    public static native ByteBuffer allocIRFrameData(long r100);

    public static native ByteBuffer allocRGBFrameData(long r100);

    public static native void config(IToygerDelegate r100, ToygerConfig r101);

    public static native void fetchDepthFrameData(ShortBuffer r100, long r101);

    public static native void fetchIRFrameData(ByteBuffer r100, long r101);

    public static native void fetchRGBFrameData(ByteBuffer r100, long r101);

    public static final native List<ToygerDataInfo> getCollectionData();

    public static native long getCurrentToygerPtr();

    public static native Map<String, String> getRuntimeInfo();

    public static native String getVersion();

    public static native boolean init(Context r100, byte[] r101, String r102, String r103, Map r104);

    public static native boolean loadModel(byte[] r100, int r101);

    public static native void processImage(List<TGFrame> r100, TGDepthFrame r101, ToygerAttr r102);

    public static native void processSensorData(float[] r100, float[] r101, float[] r102, long r103);

    public static native void processSkipImage(TGFrame r100, ByteBuffer r101);

    public static native void release();

    public static native void releaseData(ByteBuffer r100);

    public static native void releaseDepthFrameData(ByteBuffer r100);

    public static native void releaseIRFrameData(ByteBuffer r100);

    public static native void releaseRGBFrameData(ByteBuffer r100);

    public static native void reset();

    public static native void reset(boolean r100);

    public static native boolean tryLoadXnn(long r100, byte[] r101);

    public static native String updateState(String r100, int r101);

    public Toyger() {
    }

    @JvmStatic
    public static void INVOKESTATIC_com_dtf_toyger_base_algorithm_Toyger_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static void loadLibrary(Context r100) {
        INVOKESTATIC_com_dtf_toyger_base_algorithm_Toyger_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("toyger");
    }
}
