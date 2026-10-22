package com.ss.android.socialbase.appdownloader.util.package_info;

import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public class ChunkUtil {
    public ChunkUtil() {
    }

    public static final void readCheckType(IntReader r100, int r101) throws IOException {
        int r102 = r100.readInt();
        if (r102 != r101) goto L6;
        return;
    L6:
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(r101) + ", read 0x" + Integer.toHexString(r102) + ".");
    }
}
