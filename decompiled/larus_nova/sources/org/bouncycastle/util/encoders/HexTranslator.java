package org.bouncycastle.util.encoders;

/* JADX INFO: loaded from: classes42.dex */
public class HexTranslator implements Translator {
    private static final byte[] hexTable = null;

    static {
        hexTable = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    }

    public HexTranslator() {
    }

    @Override // org.bouncycastle.util.encoders.Translator
    public int decode(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        int r105 = r102 / 2;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L12;
        int r107 = (r106 * 2) + r101;
        byte r108 = r100[r107];
        byte r109 = r100[r107 + 1];
        if (r108 >= 97) goto L7;
        r103[r104] = (byte) ((r108 - 48) << 4);
    L8:
        if (r109 >= 97) goto L10;
        r103[r104] = (byte) (r103[r104] + ((byte) (r109 - 48)));
    L11:
        r104 = r104 + 1;
        r106 = r106 + 1;
        goto L3
    L10:
        r103[r104] = (byte) (r103[r104] + ((byte) ((r109 - 97) + 10)));
        goto L11
    L7:
        r103[r104] = (byte) (((r108 - 97) + 10) << 4);
        goto L8
    L12:
        return r105;
    }

    @Override // org.bouncycastle.util.encoders.Translator
    public int encode(byte[] r100, int r101, int r102, byte[] r103, int r110) {
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L6;
        int r106 = r110 + r105;
        byte[] r107 = hexTable;
        r103[r106] = r107[(r100[r101] >> 4) & 15];
        r103[r106 + 1] = r107[r100[r101] & 15];
        r101 = r101 + 1;
        r104 = r104 + 1;
        r105 = r105 + 2;
        goto L3
    L6:
        return r102 * 2;
    }

    @Override // org.bouncycastle.util.encoders.Translator
    public int getDecodedBlockSize() {
        return 1;
    }

    @Override // org.bouncycastle.util.encoders.Translator
    public int getEncodedBlockSize() {
        return 2;
    }
}
