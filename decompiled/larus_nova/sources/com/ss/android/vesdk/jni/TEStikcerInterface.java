package com.ss.android.vesdk.jni;

import com.ss.android.ttve.nativePort.NativeCallbacks;
import com.ss.android.vesdk.VEListener;
import com.ss.android.vesdk.filterparam.VEStickerPinAreaParam;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class TEStikcerInterface {
    private native int nativeAddInfoSticker(long r100, String r101, String[] r102);

    private native int nativeAddInfoStickerWithBuffer(long r100);

    private native int nativeAddSubTrack(long r100, String[] r101, String[] r102, int[] r103, int[] r104, int[] r105, int[] r106, double r107, double r110, double r111, double r112, int r113, int r114);

    private native int nativeBegin2DBrush(long r100);

    private native int nativeBeginInfoStickerPin(long r100, int r101);

    private native int nativeCancelInfoStickerPin(long r100, int r101);

    private native int nativeControlInfoStickerAnimationPreview(long r100, boolean r101, int r102, int r103);

    private native int nativeDeleteSubTrack(long r100, int r101);

    private native int nativeEnd2DBrush(long r100, String r101);

    private native int nativeGet2DBrushStrokeCount(long r100);

    private native float[] nativeGetInfoStickerBoundingBox(long r100, int r101);

    private native float[] nativeGetInfoStickerBoundingBoxWithoutRotate(long r100, int r101);

    private native int nativeGetInfoStickerFlip(long r100, int r101, boolean[] r102);

    private native boolean nativeGetInfoStickerIsDynamic(long r100, int r101);

    private native int nativeGetInfoStickerPinData(long r100, int r101, ByteBuffer[] r102);

    private native int nativeGetInfoStickerPinState(long r100, int r101);

    private native int nativeGetInfoStickerPosition(long r100, int r101, float[] r102);

    private native float nativeGetInfoStickerRotate(long r100, int r101);

    private native float nativeGetInfoStickerScale(long r100, int r101);

    private native String nativeGetInfoStickerTemplateParam(long r100, int r101);

    private native String nativeGetInfoStickerTemplateParamWithPath(long r100, String r101);

    private native boolean nativeGetInfoStickerVisible(long r100, int r101);

    private native int nativeGetSrtInfoStickerInitPosition(long r100, int r101, float[] r102);

    private native int nativeGetSubTrackFilter(long r100, int r101);

    private native int nativeGetTextContentCallback(long r100, NativeCallbacks.OnARTextContentCallback r101);

    private native int nativeGetTextLimitCount(long r100);

    private native boolean nativeIsInfoStickerAnimatable(long r100, int r101);

    private native int nativeNotifyHideKeyBoard(long r100, boolean r101);

    private native int nativePauseEffectAudio(long r100, boolean r101);

    private native int nativePauseInfoStickerAnimation(long r100, boolean r101);

    private native int nativeRemoveInfoSticker(long r100, int r101);

    private native int nativeRemoveInfoStickerWithBuffer(long r100, int r101);

    private native int nativeRestoreInfoStickerPinWithJson(long r100, int r101, ByteBuffer r102, int r103);

    private native int nativeSet2DBrushCanvasColor(long r100, float r101);

    private native int nativeSet2DBrushColor(long r100, float r101, float r102, float r103, float r104);

    private native int nativeSet2DBrushSize(long r100, float r101);

    private native int nativeSetEffectBgmEnable(long r100, boolean r101);

    private native int nativeSetEffectFontPath(long r100, String r101, int r102);

    private native int nativeSetEffectInputText(long r100, String r101, int r102, int r103, String r104);

    private native int nativeSetInfoStickerAnimationParam(long r100, int r101, boolean r102, String r103, int r104, String r105, int r106, String r107, int r110, int r111, int r112);

    private native int nativeSetInfoStickerAnimationPreview(long r100, int r101, boolean r102);

    private native int nativeSetInfoStickerBufferCallback(long r100, VEListener.VEInfoStickerBufferListener r101);

    private native int nativeSetInfoStickerCallSync(long r100, boolean r101);

    private native int nativeSetInfoStickerFlip(long r100, int r101, boolean r102, boolean r103);

    private native int nativeSetInfoStickerRestoreMode(long r100, int r101);

    private native float nativeSetInfoStickerScale(long r100, int r101, float r102);

    private native int nativeSetLanguage(long r100, String r101);

    private native int nativeSetStickerPinArea(long r100, int r101, VEStickerPinAreaParam r102);

    private native int nativeSetTextBitmapCallback(long r100, NativeCallbacks.OnARTextBitmapCallback r101);

    private native int nativeStopInfoStickerPin(long r100, int r101);

    private native int nativeUndo2DBrush(long r100);

    private native int nativeUpdateTextSticker(long r100, int r101, String r102);
}
