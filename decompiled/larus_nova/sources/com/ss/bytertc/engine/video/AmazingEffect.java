package com.ss.bytertc.engine.video;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.ss.bytertc.engine.NativeAmazingEffectFunctions;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class AmazingEffect extends IAmazingEffect {
    private static final String TAG = "AmazingEffect";
    private static boolean mLibraryLoaded = false;
    private static final String sSoLibraryName = "volcenginertc";
    private long mNativeAmazingEffect;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    static {
        INVOKESTATIC_com_ss_bytertc_engine_video_AmazingEffect_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("effect");     // Catch: UnsatisfiedLinkError -> L4
        INVOKESTATIC_com_ss_bytertc_engine_video_AmazingEffect_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("volcenginertc");     // Catch: UnsatisfiedLinkError -> L4
        mLibraryLoaded = true;     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        mLibraryLoaded = false;
    }

    private boolean amazingEffectInvalid() {
        if (this.mNativeAmazingEffect != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String getEffectSDKVersion() {
        if (mLibraryLoaded == true) goto L7;
        return "unkonw";
    L7:
        return NativeAmazingEffectFunctions.nativeGetEffectSDKVersion();
    }

    public void dispose() {
        LogUtil.i(TAG, "dispose amazing effect");
        this.mNativeAmazingEffect = 0;
    }

    public AmazingEffect(long r100) {
        this.mNativeAmazingEffect = r100;
        LogUtil.i(TAG, "create amazing effect");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_bytertc_engine_video_AmazingEffect_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int appendEffectNodes(List<String> r100) {
        if (amazingEffectInvalid() == false) goto L6;
        LogUtil.e(TAG, "invalid, appendEffectNodes failed.");
        return -1006;
    L6:
        if (r100 != null) goto L9;
        LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
        return -1;
    L9:
        String[] r101 = new String[r100.size()];
        r100.toArray(r101);
        return NativeAmazingEffectFunctions.nativeAppendAmazingEffectNodes(this.mNativeAmazingEffect, r101);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int removeEffectNodes(List<String> r100) {
        if (amazingEffectInvalid() == false) goto L6;
        LogUtil.e(TAG, "invalid, removeEffectNodes failed.");
        return -1006;
    L6:
        if (r100 != null) goto L9;
        LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
        return -1;
    L9:
        String[] r101 = new String[r100.size()];
        r100.toArray(r101);
        return NativeAmazingEffectFunctions.nativeRemoveAmazingEffectNodes(this.mNativeAmazingEffect, r101);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int setAlgoModelResourceFinder(IRtcResourceFinder r100) {
        if (amazingEffectInvalid() == false) goto L6;
        LogUtil.e(TAG, "invalid, setAlgoModelResourceFinder failed.");
        return -1006;
    L6:
        EffectResourceFinderAdapter.sFinder = r100;
        return 0;
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int setEffectNodes(List<String> r100) {
        if (amazingEffectInvalid() == false) goto L6;
        LogUtil.e(TAG, "invalid, setEffectNodes failed.");
        return -1006;
    L6:
        if (r100 != null) goto L9;
        LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
        return -1;
    L9:
        String[] r101 = new String[r100.size()];
        r100.toArray(r101);
        return NativeAmazingEffectFunctions.nativeSetAmazingEffectNodes(this.mNativeAmazingEffect, r101);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int replaceEffectNodes(List<String> r100, List<String> r101) {
        if (amazingEffectInvalid() == false) goto L6;
        LogUtil.e(TAG, "invalid, removeEffectNodes failed.");
        return -1006;
    L6:
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        String[] r102 = new String[r100.size()];
        r100.toArray(r102);
        String[] r103 = new String[r101.size()];
        r101.toArray(r103);
        return NativeAmazingEffectFunctions.nativeReplaceAmazingEffectNodes(this.mNativeAmazingEffect, r102, r103);
    L11:
        LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
        return -1;
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public void setVirtualBackgroundFilePath(String r100, int r101) {
        if (amazingEffectInvalid() == false) goto L6;
        LogUtil.e(TAG, "invalid, updateEffectNode failed.");
        return;
    L6:
        NativeAmazingEffectFunctions.nativeSetVirtualBackgroundFilePath(this.mNativeAmazingEffect, r100, r101);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int updateEffectNode(String r100, String r101, float r102) {
        if (amazingEffectInvalid() == false) goto L7;
        LogUtil.e(TAG, "invalid, updateEffectNode failed.");
        return -1006;
    L7:
        return NativeAmazingEffectFunctions.nativeUpdateAmazingEffectNode(this.mNativeAmazingEffect, r100, r101, r102);
    }
}
