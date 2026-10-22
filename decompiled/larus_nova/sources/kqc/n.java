package kqc;

import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public final class n {
    public static void a(i r100) throws IOException {
        r100.a(0);
        int r101 = r100.readInt();
        int r102 = r100.readInt();
        int r103 = r100.readInt();
        r100.skipBytes(4);
        int r104 = r100.readInt();
        int r105 = r100.readInt();
        r100.skipBytes(r102 * 4);
        if (r103 == 0) goto L5;
        r100.skipBytes(r103 * 4);
    L5:
        if (r105 != 0) goto L7;
        int r106 = r101;
    L8:
        r100.skipBytes(r106 - r104);
        if (r105 == 0) goto L15;
        int r107 = r101 - r105;
        r100.skipBytes(r107);
        int r108 = r107 % 4;
        if (r108 < 1) goto L17;
    L12:
        int r109 = r108 - 1;
        if (r108 <= 0) goto L18;
        r100.readByte();
        r108 = r109;
        goto L12
    L18:
        return;
    L17:
        return;
    L15:
        return;
    L7:
        r106 = r105;
        goto L8
    }
}
