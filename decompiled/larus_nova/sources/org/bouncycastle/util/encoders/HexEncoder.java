package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
public class HexEncoder implements Encoder {
    protected final byte[] decodingTable;
    protected final byte[] encodingTable;

    public HexEncoder() {
        this.encodingTable = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        this.decodingTable = new byte[128];
        initialiseDecodingTable();
    }

    private static boolean ignore(char r100) {
        if (r100 != '\n') goto L5;
    L12:
        return true;
    L5:
        if (r100 == '\r') goto L12;
        if (r100 == '\t') goto L12;
        if (r100 == ' ') goto L12;
        return false;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(String r110, OutputStream r111) throws IOException {
        byte[] r100 = new byte[36];
        int r101 = r110.length();
    L3:
        if (r101 <= 0) goto L8;
        if (ignore(r110.charAt(r101 - 1)) == false) goto L8;
        r101 = r101 - 1;
    L8:
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L9:
        if (r102 >= r101) goto L28;
    L10:
        if (r102 >= r101) goto L14;
        if (ignore(r110.charAt(r102)) == false) goto L14;
        r102 = r102 + 1;
    L14:
        int r105 = r102 + 1;
        byte r106 = this.decodingTable[r110.charAt(r102)];
    L15:
        if (r105 >= r101) goto L19;
        if (ignore(r110.charAt(r105)) == false) goto L19;
        r105 = r105 + 1;
    L19:
        int r107 = r105 + 1;
        byte r108 = this.decodingTable[r110.charAt(r105)];
        if ((r106 | r108) < 0) goto L27;
        int r109 = r103 + 1;
        r100[r103] = (byte) ((r106 << 4) | r108);
        if (r109 != 36) goto L24;
        r111.write(r100);
        r103 = 0;
    L25:
        r104 = r104 + 1;
        r102 = r107;
        goto L9
    L24:
        r103 = r109;
        goto L25
    L27:
        throw new IOException("invalid characters encountered in Hex string");
    L28:
        if (r103 <= 0) goto L30;
        r111.write(r100, 0, r103);
    L30:
        return r104;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(byte[] r100, int r110, int r111, OutputStream r112) throws IOException {
        byte[] r101 = new byte[36];
        int r113 = r111 + r110;
    L3:
        if (r113 <= r110) goto L8;
        if (ignore((char) r100[r113 - 1]) == false) goto L8;
        r113 = r113 - 1;
    L8:
        int r102 = 0;
        int r103 = 0;
    L9:
        if (r110 >= r113) goto L28;
    L10:
        if (r110 >= r113) goto L14;
        if (ignore((char) r100[r110]) == false) goto L14;
        r110 = r110 + 1;
    L14:
        int r104 = r110 + 1;
        byte r114 = this.decodingTable[r100[r110]];
    L15:
        if (r104 >= r113) goto L19;
        if (ignore((char) r100[r104]) == false) goto L19;
        r104 = r104 + 1;
    L19:
        int r105 = r104 + 1;
        byte r106 = this.decodingTable[r100[r104]];
        if ((r114 | r106) < 0) goto L27;
        int r107 = r102 + 1;
        r101[r102] = (byte) ((r114 << 4) | r106);
        if (r107 != 36) goto L24;
        r112.write(r101);
        r102 = 0;
    L25:
        r103 = r103 + 1;
        r110 = r105;
        goto L9
    L24:
        r102 = r107;
        goto L25
    L27:
        throw new IOException("invalid characters encountered in Hex data");
    L28:
        if (r102 <= 0) goto L30;
        r112.write(r101, 0, r102);
    L30:
        return r103;
    }

    public byte[] decodeStrict(String r100, int r101, int r102) throws IOException {
        if (r100 == null) goto L22;
        if (r101 < 0) goto L20;
        if (r102 < 0) goto L20;
        if (r101 > (r100.length() - r102)) goto L20;
        if ((r102 & 1) != 0) goto L18;
        int r103 = r102 >>> 1;
        byte[] r104 = new byte[r103];
        int r105 = 0;
    L10:
        if (r105 >= r103) goto L16;
        int r106 = r101 + 1;
        byte r107 = this.decodingTable[r100.charAt(r101)];
        int r108 = r106 + 1;
        int r109 = r107 << 4;
        int r110 = r109 | this.decodingTable[r100.charAt(r106)];
        if (r110 < 0) goto L15;
        r104[r105] = (byte) r110;
        r105 = r105 + 1;
        r101 = r108;
        goto L10
    L15:
        throw new IOException("invalid characters encountered in Hex string");
    L16:
        return r104;
    L18:
        throw new IOException("a hexadecimal encoding must have an even number of characters");
    L20:
        throw new IndexOutOfBoundsException("invalid offset and/or length specified");
    L22:
        throw new NullPointerException("'str' cannot be null");
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int encode(byte[] r100, int r110, int r111, OutputStream r112) throws IOException {
        byte[] r101 = new byte[72];
    L3:
        if (r111 <= 0) goto L6;
        int r102 = Math.min(36, r111);
        r112.write(r101, 0, encode(r100, r110, r102, r101, 0));
        r110 = r110 + r102;
        r111 = r111 - r102;
        goto L3
    L6:
        return r111 * 2;
    }

    public int encode(byte[] r100, int r101, int r102, byte[] r103, int r110) throws IOException {
        int r104 = r102 + r101;
        int r105 = r110;
    L3:
        if (r101 >= r104) goto L6;
        int r106 = r101 + 1;
        int r107 = r100[r101] & UByte.MAX_VALUE;
        int r108 = r105 + 1;
        byte[] r109 = this.encodingTable;
        r103[r105] = r109[r107 >>> 4];
        r105 = r108 + 1;
        r103[r108] = r109[r107 & 15];
        r101 = r106;
        goto L3
    L6:
        return r105 - r110;
    }

    public void initialiseDecodingTable() {
        int r100 = 0;
        int r101 = 0;
    L3:
        byte[] r102 = this.decodingTable;
        if (r101 >= r102.length) goto L6;
        r102[r101] = -1;
        r101 = r101 + 1;
    L6:
        byte[] r103 = this.encodingTable;
        if (r100 >= r103.length) goto L9;
        this.decodingTable[r103[r100]] = (byte) r100;
        r100 = r100 + 1;
        goto L6
    L9:
        byte[] r104 = this.decodingTable;
        r104[65] = r104[97];
        r104[66] = r104[98];
        r104[67] = r104[99];
        r104[68] = r104[100];
        r104[69] = r104[101(0x65, float:1.42E-43)];
        r104[70] = r104[102(0x66, float:1.43E-43)];
    }
}
