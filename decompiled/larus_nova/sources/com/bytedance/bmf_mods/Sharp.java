package com.bytedance.bmf_mods;

import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;

/* JADX INFO: loaded from: classes44.dex */
public class Sharp {
    private long mNativePtr;

    private native long nativeCreateHydraSharp();

    private native int nativeHydraSharpGetResultTexture(long r100);

    private native int nativeHydraSharpProcess(long r100, int r101, int r102, int r103);

    private native int nativeHydraSharpProcessOes(long r100, int r101, int r102, int r103, float[] r104, float[] r105, float[] r106);

    private native int nativeInitHydraSharp(long r100, int r101, int r102, int r103, String r104, float r105, float r106, float r107, boolean r110, float r111, float r112);

    private native int nativeInitHydraSharp2(long r100, int r101, int r102, int r103, int r104, String r105, float r106, float r107, float r110, boolean r111, float r112, float r113);

    private native void nativeReleaseHydraSharp(long r100);

    public void Free() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseHydraSharp(r100);
    }

    public int GetResult() {
        return nativeHydraSharpGetResultTexture(this.mNativePtr);
    }

    public Sharp() {
        this.mNativePtr = 0;
        Logging.d("New Sharp");
    }

    public int ProcessTexture(int r100, int r110, int r111) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r101 = this.mNativePtr;
        if (r101 != 0) goto L9;
        return -1;
    L9:
        return nativeHydraSharpProcess(r101, r100, r110, r111);
    }

    public int ProcessOesTexture(int r110, int r111, int r112, float[] r113, float[] r114, float[] r115) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L8;
        return -1;
    L8:
        if (r113 == null) goto L14;
        if (r114 == null) goto L14;
        return nativeHydraSharpProcessOes(r100, r110, r111, r112, r113, r114, r115);
    L14:
        return nativeHydraSharpProcessOes(r100, r110, r111, r112, new float[0], new float[0], r115);
    }

    public int Init(int r110, int r111, int r112, String r113, float r210, float r211, float r212, boolean r213, float r214, float r215) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = nativeCreateHydraSharp();
        this.mNativePtr = r100;
        if (r100 != 0) goto L9;
        return -1;
    L9:
        return nativeInitHydraSharp(r100, r110, r111, r112, r113, r210, r211, r212, r213, r214, r215);
    }

    public int Init(int r110, int r111, int r112, int r210, String r211, float r212, float r213, float r214, boolean r215, float r216, float r217) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = nativeCreateHydraSharp();
        this.mNativePtr = r100;
        if (r100 != 0) goto L9;
        return -1;
    L9:
        return nativeInitHydraSharp2(r100, r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217);
    }
}
