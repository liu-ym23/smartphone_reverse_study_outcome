package com.bytedance.fresco.nativeheif;

import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.common.memory.Pool;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imageutils.BitmapUtil;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes19.dex */
public class HeifData {
    public final byte[] data;
    public final float displayRatioForFullHdr;
    public final float[] epsilonHdr;
    public final float[] epsilonSdr;
    public final int error;
    public final byte[] gainMapData;
    public final int gainMapHeight;
    public final int gainMapWidth;
    public final float[] gamma;
    public final int height;
    public final boolean isVvif;
    public final float minDisplayRatioForHdrTransition;
    public final float[] ratioMax;
    public final float[] ratioMin;
    public final boolean sizeAbnormal;
    public final int width;

    public HeifData(int r100) {
        this.data = null;
        this.gainMapData = null;
        this.width = 0;
        this.height = 0;
        this.gainMapWidth = 0;
        this.gainMapHeight = 0;
        this.isVvif = false;
        this.error = r100;
        this.sizeAbnormal = false;
        this.gamma = null;
        this.epsilonSdr = null;
        this.epsilonHdr = null;
        this.ratioMax = null;
        this.ratioMin = null;
        this.displayRatioForFullHdr = 0.0f;
        this.minDisplayRatioForHdrTransition = 0.0f;
    }

    public Bitmap newBitmap(Bitmap.Config r100) {
        byte[] r101 = this.data;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.length <= 0) goto L17;
        int r102 = this.width;
        if (r102 <= 0) goto L18;
        int r103 = this.height;
        if (r103 <= 0) goto L19;
        if (r100 != null) goto L13;
        r100 = Bitmap.Config.ARGB_8888;
    L13:
        Bitmap r104 = Bitmap.createBitmap(r102, r103, r100);
        r104.copyPixelsFromBuffer(ByteBuffer.wrap(this.data));
        return r104;
    L19:
        return null;
    L18:
        return null;
    L17:
        return null;
    }

    public CloseableReference<Bitmap> newBitmap(Pool<Bitmap> r100, Bitmap.Config r101) {
        if (r100 == null) goto L4;
        byte[] r102 = this.data;
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r102.length <= 0) goto L20;
        int r103 = this.width;
        if (r103 <= 0) goto L21;
        int r104 = this.height;
        if (r104 <= 0) goto L22;
        if (r101 != null) goto L16;
        r101 = Bitmap.Config.ARGB_8888;
    L16:
        Bitmap r105 = r100.get(BitmapUtil.getSizeInByteForBitmap(r103, r104, r101));
        r105.reconfigure(this.width, this.height, r101);
        r105.copyPixelsFromBuffer(ByteBuffer.wrap(this.data));
        return CloseableReference.of(r105, r100);
    L22:
        return null;
    L21:
        return null;
    L20:
        return null;
    L4:
        return CloseableReference.of(newBitmap(r101), SimpleBitmapReleaser.getInstance());
    }

    public Bitmap newBitmapWithGainMap(Bitmap.Config r110, boolean r111) {
        byte[] r100 = this.data;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length <= 0) goto L32;
        int r101 = this.width;
        if (r101 <= 0) goto L33;
        int r102 = this.height;
        if (r102 > 0) goto L12;
        return null;
    L12:
        if (r111 == false) goto L16;
        Bitmap r112 = GainmapReflectionHelper.createBitmapWithConfig(r101, r102, "RGBA_1010102");
        if (Build.VERSION.SDK_INT < 34) goto L17;
        GainmapReflectionHelper.setBT2020HLGColorSpace(r112);
    L17:
        r112.copyPixelsFromBuffer(ByteBuffer.wrap(this.data));
        int r113 = Build.VERSION.SDK_INT;
        if (r113 < 26) goto L20;
        Objects.toString(r112.getConfig());
        Objects.toString(r112.getColorSpace());
    L20:
        int r103 = this.gainMapWidth;
        if (r103 <= 0) goto L29;
        int r104 = this.gainMapHeight;
        if (r104 <= 0) goto L29;
        if (this.gainMapData == null) goto L29;
        Bitmap r105 = Bitmap.createBitmap(r103, r104, Bitmap.Config.ARGB_8888);
        r105.copyPixelsFromBuffer(ByteBuffer.wrap(this.gainMapData));
        if (r113 < 34) goto L29;
        GainmapReflectionHelper.safeSetGainmap(r112, GainmapReflectionHelper.createGainmapWithMeta(r105, this.gamma, this.epsilonSdr, this.epsilonHdr, this.ratioMax, this.ratioMin, this.displayRatioForFullHdr, this.minDisplayRatioForHdrTransition));
    L29:
        return r112;
    L16:
        r112 = Bitmap.createBitmap(r101, r102, r110);
        goto L17
    L33:
        return null;
    L32:
        return null;
    }

    public CloseableReference<Bitmap> newBitmapWithGainMap(Pool<Bitmap> r110, Bitmap.Config r111, boolean r112) {
        if (r110 == null) goto L4;
        byte[] r100 = this.data;
        if (r100 != null) goto L8;
        return null;
    L8:
        if (r100.length <= 0) goto L36;
        int r101 = this.width;
        if (r101 <= 0) goto L37;
        int r102 = this.height;
        if (r102 > 0) goto L15;
        return null;
    L15:
        if (r112 == false) goto L20;
        Bitmap r113 = GainmapReflectionHelper.createBitmapWithConfig(r101, r102, "RGBA_1010102");
        if (Build.VERSION.SDK_INT < 34) goto L19;
        GainmapReflectionHelper.setBT2020HLGColorSpace(r113);
    L19:
        CloseableReference<Bitmap> r114 = CloseableReference.of(r113, SimpleBitmapReleaser.getInstance());
    L21:
        r113.copyPixelsFromBuffer(ByteBuffer.wrap(this.data));
        int r115 = Build.VERSION.SDK_INT;
        if (r115 < 26) goto L24;
        Objects.toString(r113.getConfig());
        Objects.toString(r113.getColorSpace());
    L24:
        int r103 = this.gainMapWidth;
        if (r103 <= 0) goto L33;
        int r104 = this.gainMapHeight;
        if (r104 <= 0) goto L33;
        if (this.gainMapData == null) goto L33;
        Bitmap r105 = Bitmap.createBitmap(r103, r104, Bitmap.Config.ARGB_8888);
        r105.copyPixelsFromBuffer(ByteBuffer.wrap(this.gainMapData));
        if (r115 < 34) goto L33;
        GainmapReflectionHelper.safeSetGainmap(r113, GainmapReflectionHelper.createGainmapWithMeta(r105, this.gamma, this.epsilonSdr, this.epsilonHdr, this.ratioMax, this.ratioMin, this.displayRatioForFullHdr, this.minDisplayRatioForHdrTransition));
    L33:
        return r114;
    L20:
        Bitmap r116 = r110.get(BitmapUtil.getSizeInByteForBitmap(r101, r102, r111));
        r116.reconfigure(this.width, this.height, r111);
        r114 = CloseableReference.of(r116, r110);
        r113 = r116;
        goto L21
    L37:
        return null;
    L36:
        return null;
    L4:
        return CloseableReference.of(newBitmapWithGainMap(r111, r112), SimpleBitmapReleaser.getInstance());
    }

    public HeifData(byte[] r100, int r101, int r102, boolean r110) {
        this(r100, r101, r102, r110, false);
    }

    public HeifData(byte[] r100, int r101, int r102, boolean r103, boolean r104) {
        this.data = r100;
        this.gainMapData = null;
        this.width = r101;
        this.height = r102;
        this.gainMapWidth = 0;
        this.gainMapHeight = 0;
        this.isVvif = r103;
        this.error = 0;
        this.sizeAbnormal = r104;
        this.gamma = null;
        this.epsilonSdr = null;
        this.epsilonHdr = null;
        this.ratioMax = null;
        this.ratioMin = null;
        this.displayRatioForFullHdr = 0.0f;
        this.minDisplayRatioForHdrTransition = 0.0f;
    }

    public HeifData(byte[] r100, byte[] r101, int r102, int r103, int r104, int r105, boolean r106, float[] r107, float[] r108, float[] r110, float[] r111, float[] r112, float r113, float r114) {
        this.data = r100;
        this.gainMapData = r101;
        this.width = r102;
        this.height = r103;
        this.gainMapWidth = r104;
        this.gainMapHeight = r105;
        this.isVvif = r106;
        this.error = 0;
        this.sizeAbnormal = false;
        this.gamma = r107;
        this.epsilonSdr = r108;
        this.epsilonHdr = r110;
        this.ratioMax = r111;
        this.ratioMin = r112;
        this.displayRatioForFullHdr = r113;
        this.minDisplayRatioForHdrTransition = r114;
    }
}
