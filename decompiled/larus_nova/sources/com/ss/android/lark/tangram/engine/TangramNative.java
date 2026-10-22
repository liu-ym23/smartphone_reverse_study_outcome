package com.ss.android.lark.tangram.engine;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import s6c.a;
import s6c.b;

/* JADX INFO: loaded from: classes38.dex */
public class TangramNative {
    public static final ConcurrentHashMap<String, a> hashMap = null;

    public TangramNative() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native float[] calculateLayout(long r100, float r101, float r102);

    public static native void deepFreeNode(long r100);

    public static native void freeNode(long r100);

    public static native long[] getNodeChildren(long r100);

    public static native float[] getNodeFrame(long r100);

    public static native long newFlexLayoutNode();

    public static native long newLinearLayoutNode();

    public static native long newTLNodeNative();

    public static native void setFlexLayoutPropsAlign(long r100, int r101);

    public static native void setFlexLayoutPropsCrossAxisSpace(long r100, float r101);

    public static native void setFlexLayoutPropsFlexWrap(long r100, int r101);

    public static native void setFlexLayoutPropsJustify(long r100, int r101);

    public static native void setFlexLayoutPropsMainAxisSpace(long r100, float r101);

    public static native void setFlexLayoutPropsOrientation(long r100, int r101);

    public static native void setFlexLayoutPropsPadding(long r100, float r101, float r102, float r103, float r104);

    public static native void setLayoutFunc(long r100, String r101);

    public static native void setLinearLayoutPropsAlign(long r100, int r101);

    public static native void setLinearLayoutPropsDirection(long r100, int r101);

    public static native void setLinearLayoutPropsJustify(long r100, int r101);

    public static native void setLinearLayoutPropsOrientation(long r100, int r101);

    public static native void setLinearLayoutPropsPadding(long r100, float r101, float r102, float r103, float r104);

    public static native void setLinearLayoutPropsSpace(long r100, float r101);

    public static native void setLinearLayoutPropsWrapWidth(long r100, float r101);

    public static native void setNodeChildren(long r100, long[] r101, int r102);

    public static native void setStyleAlign(long r100, int r101);

    public static native void setStyleAspectRatio(long r100, float r101);

    public static native void setStyleGrowWeight(long r100, int r101);

    public static native void setStyleHeight(long r100, float r101, int r102);

    public static native void setStyleMaxHeight(long r100, float r101, int r102);

    public static native void setStyleMaxWidth(long r100, float r101, int r102);

    public static native void setStyleMinHeight(long r100, float r101, int r102);

    public static native void setStyleMinWidth(long r100, float r101, int r102);

    public static native void setStyleShrinkWeight(long r100, int r101);

    public static native void setStyleWidth(long r100, float r101, int r102);

    static {
        INVOKESTATIC_com_ss_android_lark_tangram_engine_TangramNative_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");
        INVOKESTATIC_com_ss_android_lark_tangram_engine_TangramNative_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("tangram");
        hashMap = new ConcurrentHashMap();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_android_lark_tangram_engine_TangramNative_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static float callBackHeight(String r100, float r101, float r102) {
        a r103 = hashMap.get(r100);
        if (r103 != null) goto L5;
        return 0.0f;
    L5:
        if (r103.f540887h == true) goto L7;
        return 0.0f;
    L7:
        return r103.l(new b.a(r101, r102)).f540896b;
    }

    public static float callBackWidth(String r100, float r101, float r102) {
        a r103 = hashMap.get(r100);
        if (r103 != null) goto L5;
        return 0.0f;
    L5:
        if (r103.f540887h == true) goto L7;
        return 0.0f;
    L7:
        return r103.l(new b.a(r101, r102)).f540895a;
    }
}
