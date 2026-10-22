package com.bytedance.badger.utils;

import androidx.collection.ScatterMapKt;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f199273a = 0;

    static {
    }

    public n() {
    }

    public static int a(byte[] r110) {
        int r100 = r110.length;
        int r101 = r100 >> 2;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r101) goto L6;
        int r105 = r103 << 2;
        int r106 = (((r110[r105 + 3] & UByte.MAX_VALUE) << 24) | (((r110[r105] & UByte.MAX_VALUE) | ((r110[r105 + 1] & UByte.MAX_VALUE) << 8)) | ((r110[r105 + 2] & UByte.MAX_VALUE) << 16))) * ScatterMapKt.MurmurHashC1;
        int r107 = r104 ^ (((r106 >>> 17) | (r106 << 15)) * 461845907);
        r104 = (((r107 >>> 19) | (r107 << 13)) * 5) - 430675100;
        r103 = r103 + 1;
        goto L4
    L6:
        int r108 = r100 & 3;
        if (r108 <= 0) goto L18;
        int r109 = r101 << 2;
        if (r108 == 1) goto L16;
        if (r108 == 2) goto L14;
        if (r108 != 3) goto L17;
        int r111 = (0 ^ ((r110[r109 + 2] & UByte.MAX_VALUE) << 16)) ^ ((r110[r109 + 1] & UByte.MAX_VALUE) << 8);
        byte r112 = r110[r109];
    L15:
        r102 = r111 ^ (r112 & UByte.MAX_VALUE);
    L17:
        int r113 = r102 * ScatterMapKt.MurmurHashC1;
        r104 = r104 ^ (((r113 << 15) | (r113 >>> 17)) * 461845907);
        goto L18
    L14:
        r111 = 0 ^ ((r110[r109 + 1] & UByte.MAX_VALUE) << 8);
        r112 = r110[r109];
        goto L15
    L16:
        r102 = 0 ^ (r110[r109] & UByte.MAX_VALUE);
    L18:
        int r114 = r104 ^ r100;
        int r115 = (r114 ^ (r114 >>> 16)) * ((int) 2246822507L);
        int r116 = (r115 ^ (r115 >>> 13)) * ((int) 3266489909L);
        return r116 ^ (r116 >>> 16);
    }
}
