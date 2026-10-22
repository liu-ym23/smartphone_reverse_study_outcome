package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class MemoryChunkUtil {
    public MemoryChunkUtil() {
    }

    public static int adjustByteCount(int r100, int r101, int r102) {
        return Math.min(Math.max(0, r102 - r100), r101);
    }

    public static void checkBounds(int r100, int r101, int r102, int r103, int r104) {
        boolean r105 = true;
        if (r103 < 0) goto L5;
        boolean r106 = true;
    L6:
        Preconditions.checkArgument(r106);
        if (r100 < 0) goto L9;
        boolean r107 = true;
    L10:
        Preconditions.checkArgument(r107);
        if (r102 < 0) goto L13;
        boolean r108 = true;
    L14:
        Preconditions.checkArgument(r108);
        if ((r100 + r103) > r104) goto L17;
        boolean r109 = true;
    L18:
        Preconditions.checkArgument(r109);
        if ((r102 + r103) <= r101) goto L22;
        r105 = false;
    L22:
        Preconditions.checkArgument(r105);
        return;
    L17:
        r109 = false;
        goto L18
    L13:
        r108 = false;
        goto L14
    L9:
        r107 = false;
        goto L10
    L5:
        r106 = false;
        goto L6
    }
}
