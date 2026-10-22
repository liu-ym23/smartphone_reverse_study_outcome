package com.ss.android.socialbase.appdownloader.util.package_info;

import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public class StringBlock {
    private int[] m_stringOffsets;
    private int[] m_strings;

    private StringBlock() {
    }

    public static StringBlock read(IntReader r100) throws IOException {
        ChunkUtil.readCheckType(r100, 1835009);
        int r101 = r100.readInt();
        int r102 = r100.readInt();
        int r103 = r100.readInt();
        r100.readInt();
        int r104 = r100.readInt();
        int r105 = r100.readInt();
        StringBlock r106 = new StringBlock();
        r106.m_stringOffsets = r100.readIntArray(r102);
        if (r103 == 0) goto L5;
        r100.readIntArray(r103);
    L5:
        if (r105 != 0) goto L7;
        int r107 = r101;
    L8:
        int r108 = r107 - r104;
        if ((r108 % 4) != 0) goto L19;
        r106.m_strings = r100.readIntArray(r108 / 4);
        if (r105 == 0) goto L17;
        int r109 = r101 - r105;
        if ((r109 % 4) != 0) goto L16;
        r100.readIntArray(r109 / 4);
        goto L17
    L16:
        throw new IOException("Style data size is not multiple of 4 (" + r109 + ").");
    L17:
        return r106;
    L19:
        throw new IOException("String data size is not multiple of 4 (" + r108 + ").");
    L7:
        r107 = r105;
        goto L8
    }

    public int find(String r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        int r101 = 0;
    L6:
        int[] r102 = this.m_stringOffsets;
        if (r101 == r102.length) goto L19;
        int r103 = r102[r101];
        int r104 = getShort(this.m_strings, r103);
        if (r104 != r100.length()) goto L18;
        int r105 = 0;
    L11:
        if (r105 == r104) goto L16;
        r103 = r103 + 2;
        if (r100.charAt(r105) != getShort(this.m_strings, r103)) goto L16;
        r105 = r105 + 1;
    L16:
        if (r105 != r104) goto L18;
        return r101;
    L18:
        r101 = r101 + 1;
        goto L6
    L19:
        return -1;
    }

    public String getString(int r100) {
        if (r100 < 0) goto L12;
        int[] r101 = this.m_stringOffsets;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 >= r101.length) goto L16;
        int r102 = r101[r100];
        int r103 = getShort(this.m_strings, r102);
        StringBuilder r104 = new StringBuilder(r103);
    L8:
        if (r103 == 0) goto L11;
        r102 = r102 + 2;
        r104.append((char) getShort(this.m_strings, r102));
        r103 = r103 - 1;
        goto L8
    L11:
        return r104.toString();
    L16:
        return null;
    L12:
        return null;
    }

    private static final int getShort(int[] r100, int r101) {
        int r102 = r100[r101 / 4];
        if (((r101 % 4) / 2) != 0) goto L6;
        return r102 & 65535;
    L6:
        return r102 >>> 16;
    }
}
