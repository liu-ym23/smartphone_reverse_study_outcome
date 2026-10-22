package com.facebook.yoga;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public class YogaNative {
    public YogaNative() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native void jni_YGConfigFreeJNI(long r100);

    public static native int jni_YGConfigGetErrataJNI(long r100);

    public static native long jni_YGConfigNewJNI();

    public static native void jni_YGConfigSetErrataJNI(long r100, int r101);

    public static native void jni_YGConfigSetExperimentalFeatureEnabledJNI(long r100, int r101, boolean r102);

    public static native void jni_YGConfigSetLoggerJNI(long r100, YogaLogger r101);

    public static native void jni_YGConfigSetPointScaleFactorJNI(long r100, float r101);

    public static native void jni_YGConfigSetUseWebDefaultsJNI(long r100, boolean r101);

    public static native void jni_YGNodeCalculateLayoutJNI(long r100, float r101, float r102, long[] r103, YogaNodeJNIBase[] r104);

    public static native long jni_YGNodeCloneJNI(long r100);

    public static native void jni_YGNodeCopyStyleJNI(long r100, long r101);

    public static native void jni_YGNodeFinalizeJNI(long r100);

    public static native void jni_YGNodeInsertChildJNI(long r100, long r101, int r102);

    public static native boolean jni_YGNodeIsDirtyJNI(long r100);

    public static native boolean jni_YGNodeIsReferenceBaselineJNI(long r100);

    public static native void jni_YGNodeMarkDirtyJNI(long r100);

    public static native long jni_YGNodeNewJNI();

    public static native long jni_YGNodeNewWithConfigJNI(long r100);

    public static native void jni_YGNodeRemoveAllChildrenJNI(long r100);

    public static native void jni_YGNodeRemoveChildJNI(long r100, long r101);

    public static native void jni_YGNodeResetJNI(long r100);

    public static native void jni_YGNodeSetAlwaysFormsContainingBlockJNI(long r100, boolean r101);

    public static native void jni_YGNodeSetHasBaselineFuncJNI(long r100, boolean r101);

    public static native void jni_YGNodeSetHasMeasureFuncJNI(long r100, boolean r101);

    public static native void jni_YGNodeSetIsReferenceBaselineJNI(long r100, boolean r101);

    public static native void jni_YGNodeSetStyleInputsJNI(long r100, float[] r101, int r102);

    public static native int jni_YGNodeStyleGetAlignContentJNI(long r100);

    public static native int jni_YGNodeStyleGetAlignItemsJNI(long r100);

    public static native int jni_YGNodeStyleGetAlignSelfJNI(long r100);

    public static native float jni_YGNodeStyleGetAspectRatioJNI(long r100);

    public static native float jni_YGNodeStyleGetBorderJNI(long r100, int r101);

    public static native int jni_YGNodeStyleGetBoxSizingJNI(long r100);

    public static native int jni_YGNodeStyleGetDirectionJNI(long r100);

    public static native int jni_YGNodeStyleGetDisplayJNI(long r100);

    public static native long jni_YGNodeStyleGetFlexBasisJNI(long r100);

    public static native int jni_YGNodeStyleGetFlexDirectionJNI(long r100);

    public static native float jni_YGNodeStyleGetFlexGrowJNI(long r100);

    public static native float jni_YGNodeStyleGetFlexJNI(long r100);

    public static native float jni_YGNodeStyleGetFlexShrinkJNI(long r100);

    public static native int jni_YGNodeStyleGetFlexWrapJNI(long r100);

    public static native float jni_YGNodeStyleGetGapJNI(long r100, int r101);

    public static native long jni_YGNodeStyleGetHeightJNI(long r100);

    public static native int jni_YGNodeStyleGetJustifyContentJNI(long r100);

    public static native long jni_YGNodeStyleGetMarginJNI(long r100, int r101);

    public static native long jni_YGNodeStyleGetMaxHeightJNI(long r100);

    public static native long jni_YGNodeStyleGetMaxWidthJNI(long r100);

    public static native long jni_YGNodeStyleGetMinHeightJNI(long r100);

    public static native long jni_YGNodeStyleGetMinWidthJNI(long r100);

    public static native int jni_YGNodeStyleGetOverflowJNI(long r100);

    public static native long jni_YGNodeStyleGetPaddingJNI(long r100, int r101);

    public static native long jni_YGNodeStyleGetPositionJNI(long r100, int r101);

    public static native int jni_YGNodeStyleGetPositionTypeJNI(long r100);

    public static native long jni_YGNodeStyleGetWidthJNI(long r100);

    public static native void jni_YGNodeStyleSetAlignContentJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetAlignItemsJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetAlignSelfJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetAspectRatioJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetBorderJNI(long r100, int r101, float r102);

    public static native void jni_YGNodeStyleSetBoxSizingJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetDirectionJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetDisplayJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetFlexBasisAutoJNI(long r100);

    public static native void jni_YGNodeStyleSetFlexBasisJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetFlexBasisPercentJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetFlexDirectionJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetFlexGrowJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetFlexJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetFlexShrinkJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetFlexWrapJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetGapJNI(long r100, int r101, float r102);

    public static native void jni_YGNodeStyleSetGapPercentJNI(long r100, int r101, float r102);

    public static native void jni_YGNodeStyleSetHeightAutoJNI(long r100);

    public static native void jni_YGNodeStyleSetHeightJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetHeightPercentJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetJustifyContentJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetMarginAutoJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetMarginJNI(long r100, int r101, float r102);

    public static native void jni_YGNodeStyleSetMarginPercentJNI(long r100, int r101, float r102);

    public static native void jni_YGNodeStyleSetMaxHeightJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetMaxHeightPercentJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetMaxWidthJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetMaxWidthPercentJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetMinHeightJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetMinHeightPercentJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetMinWidthJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetMinWidthPercentJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetOverflowJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetPaddingJNI(long r100, int r101, float r102);

    public static native void jni_YGNodeStyleSetPaddingPercentJNI(long r100, int r101, float r102);

    public static native void jni_YGNodeStyleSetPositionAutoJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetPositionJNI(long r100, int r101, float r102);

    public static native void jni_YGNodeStyleSetPositionPercentJNI(long r100, int r101, float r102);

    public static native void jni_YGNodeStyleSetPositionTypeJNI(long r100, int r101);

    public static native void jni_YGNodeStyleSetWidthAutoJNI(long r100);

    public static native void jni_YGNodeStyleSetWidthJNI(long r100, float r101);

    public static native void jni_YGNodeStyleSetWidthPercentJNI(long r100, float r101);

    public static native void jni_YGNodeSwapChildJNI(long r100, long r101, int r102);

    static {
        INVOKESTATIC_com_facebook_yoga_YogaNative_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("yoga");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_facebook_yoga_YogaNative_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
