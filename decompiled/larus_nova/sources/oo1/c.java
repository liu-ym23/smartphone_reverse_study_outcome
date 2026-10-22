package oo1;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public final class c {
    public static void a(ByteBuffer r100, ByteBuffer r101) {
        float r102 = r100.getFloat();
        if (r102 >= (-1.0f)) goto L6;
        r102 = -1.0f;
    L8:
        r101.putShort((short) (r102 * 32767.0f));
        return;
    L6:
        if (r102 <= 1.0f) goto L8;
        r102 = 1.0f;
        goto L8
    }
}
