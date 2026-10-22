package com.bytedance.lighten.loader;

import com.bytedance.lighten.core.ScaleType;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes20.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScalingUtils.ScaleType f254790a = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f254791a = null;

        static {
            int[] r100 = new int[ScaleType.values().length];
            f254791a = r100;
            r100[ScaleType.FIT_XY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f254791a[ScaleType.FIT_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f254791a[ScaleType.FIT_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f254791a[ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f254791a[ScaleType.CENTER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f254791a[ScaleType.CENTER_CROP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f254791a[ScaleType.CENTER_INSIDE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f254791a[ScaleType.FOCUS_CROP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        f254790a = ScalingUtils.ScaleType.CENTER_CROP;
    }

    public static ScalingUtils.ScaleType a(ScaleType r100) {
        ScalingUtils.ScaleType r101 = f254790a;
        switch(a.f254791a[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            default: goto L21;
        };
    L21:
        return r101;
    L14:
        return ScalingUtils.ScaleType.FOCUS_CROP;
    L15:
        return ScalingUtils.ScaleType.CENTER_INSIDE;
    L16:
        return ScalingUtils.ScaleType.CENTER_CROP;
    L17:
        return ScalingUtils.ScaleType.CENTER;
    L18:
        return ScalingUtils.ScaleType.FIT_CENTER;
    L19:
        return ScalingUtils.ScaleType.FIT_END;
    L20:
        return ScalingUtils.ScaleType.FIT_START;
    L13:
        return ScalingUtils.ScaleType.FIT_XY;
    }
}
