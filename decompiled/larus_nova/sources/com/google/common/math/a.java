package com.google.common.math;

import androidx.camera.video.AudioStats;
import com.google.common.base.m;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f275624a = 0;

    /* JADX INFO: renamed from: com.google.common.math.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C3859a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275625a = null;

        static {
            int[] r100 = new int[RoundingMode.values().length];
            f275625a = r100;
            r100[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f275625a[RoundingMode.FLOOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f275625a[RoundingMode.CEILING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f275625a[RoundingMode.DOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f275625a[RoundingMode.UP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f275625a[RoundingMode.HALF_EVEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f275625a[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f275625a[RoundingMode.HALF_DOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        Math.log(2.0d);
    }

    public static boolean a(double r100) {
        if (b.a(r100) == true) goto L5;
    L13:
        return false;
    L5:
        if (r100 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        m.c(b.a(r100), "not a normal value");
        int r101 = Math.getExponent(r100);
        long r102 = Double.doubleToRawLongBits(r100) & 4503599627370495L;
        if (r101 != (-1023)) goto L9;
        long r103 = r102 << 1;
    L11:
        if ((52 - Long.numberOfTrailingZeros(r103)) > Math.getExponent(r100)) goto L13;
        return true;
    L9:
        r103 = 4503599627370496L | r102;
        goto L11
    L15:
        return true;
    }
}
