package com.lynx.tasm.ui.image;

import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class o {
    public o() {
    }

    public static ScalingUtils.ScaleType a(ScalingUtils.ScaleType r100) {
        if (r100 != ScalingUtils.ScaleType.FIT_CENTER) goto L7;
        return h0.f384003d;
    L7:
        if (r100 != ScalingUtils.ScaleType.CENTER_CROP) goto L11;
        return h0.f384002c;
    L11:
        if (r100 != ScalingUtils.ScaleType.CENTER) goto L15;
        return h0.f384001b;
    L15:
        if (r100 == ScalingUtils.ScaleType.FIT_XY) goto L17;
        return r100;
    L17:
        return h0.f384000a;
    }

    public static ScalingUtils.ScaleType b(String r100) {
        if ("aspectFit".equals(r100) == false) goto L7;
        return ScalingUtils.ScaleType.FIT_CENTER;
    L7:
        if ("aspectFill".equals(r100) == false) goto L11;
        return ScalingUtils.ScaleType.CENTER_CROP;
    L11:
        if ("scaleToFill".equals(r100) == false) goto L15;
        return ScalingUtils.ScaleType.FIT_XY;
    L15:
        if ("center".equals(r100) == true) goto L17;
        if (r100 == null) goto L27;
        if (r100.equals("none") == true) goto L27;
        if (r100.length() == 0) goto L27;
        throw new RuntimeException("Invalid resize mode: '" + r100 + "'");
    L27:
        return ScalingUtils.ScaleType.FIT_XY;
    L17:
        return ScalingUtils.ScaleType.CENTER;
    }
}
