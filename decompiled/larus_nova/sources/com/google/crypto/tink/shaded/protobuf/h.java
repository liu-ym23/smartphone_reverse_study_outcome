package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public final class h {
    public static String a(ByteString r100) {
        StringBuilder r101 = new StringBuilder(r100.size());
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L30;
        byte r103 = r100.byteAt(r102);
        if (r103 != 34) goto L8;
        r101.append("\\\"");
    L28:
        r102 = r102 + 1;
        goto L4
    L8:
        if (r103 != 39) goto L10;
        r101.append("\\'");
        goto L28
    L10:
        if (r103 == 92) goto L25;
        switch(r103) {
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L18;
            case 13: goto L17;
            default: goto L13;
        };
    L17:
        r101.append("\\r");
        goto L28
    L18:
        r101.append("\\f");
        goto L28
    L19:
        r101.append("\\v");
        goto L28
    L20:
        r101.append("\\n");
        goto L28
    L21:
        r101.append("\\t");
        goto L28
    L22:
        r101.append("\\b");
        goto L28
    L23:
        r101.append("\\a");
        goto L28
    L13:
        if (r103 >= 32) goto L15;
    L24:
        r101.append('\\');
        r101.append((char) (((r103 >>> 6) & 3) + 48));
        r101.append((char) (((r103 >>> 3) & 7) + 48));
        r101.append((char) ((r103 & 7) + 48));
        goto L28
    L15:
        if (r103 > 126) goto L24;
        r101.append((char) r103);
        goto L28
    L25:
        r101.append("\\\\");
        goto L28
    L30:
        return r101.toString();
    }
}
