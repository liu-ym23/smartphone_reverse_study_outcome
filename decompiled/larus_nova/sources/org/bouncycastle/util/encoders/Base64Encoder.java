package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
public class Base64Encoder implements Encoder {
    protected final byte[] decodingTable;
    protected final byte[] encodingTable;
    protected byte padding;

    public Base64Encoder() {
        this.encodingTable = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        this.padding = kotlin.io.encoding.Base64.padSymbol;
        this.decodingTable = new byte[128];
        initialiseDecodingTable();
    }

    private int decodeLastBlock(OutputStream r100, char r101, char r102, char r103, char r104) throws IOException {
        char r105 = this.padding;
        if (r103 != r105) goto L13;
        if (r104 != r105) goto L12;
        byte[] r106 = this.decodingTable;
        byte r107 = r106[r101];
        byte r108 = r106[r102];
        if ((r107 | r108) < 0) goto L10;
        r100.write((r107 << 2) | (r108 >> 4));
        return 1;
    L10:
        throw new IOException("invalid characters encountered at end of base64 data");
    L12:
        throw new IOException("invalid characters encountered at end of base64 data");
    L13:
        if (r104 != r105) goto L20;
        byte[] r109 = this.decodingTable;
        byte r110 = r109[r101];
        byte r111 = r109[r102];
        byte r112 = r109[r103];
        if (((r110 | r111) | r112) < 0) goto L19;
        r100.write((r110 << 2) | (r111 >> 4));
        r100.write((r111 << 4) | (r112 >> 2));
        return 2;
    L19:
        throw new IOException("invalid characters encountered at end of base64 data");
    L20:
        byte[] r113 = this.decodingTable;
        byte r114 = r113[r101];
        byte r115 = r113[r102];
        byte r116 = r113[r103];
        byte r117 = r113[r104];
        if ((((r114 | r115) | r116) | r117) < 0) goto L25;
        r100.write((r114 << 2) | (r115 >> 4));
        r100.write((r115 << 4) | (r116 >> 2));
        r100.write((r116 << 6) | r117);
        return 3;
    L25:
        throw new IOException("invalid characters encountered at end of base64 data");
    }

    private boolean ignore(char r100) {
        if (r100 != '\n') goto L5;
    L12:
        return true;
    L5:
        if (r100 == '\r') goto L12;
        if (r100 == '\t') goto L12;
        if (r100 == ' ') goto L12;
        return false;
    }

    private int nextI(String r100, int r101, int r102) {
    L2:
        if (r101 >= r102) goto L6;
        if (ignore(r100.charAt(r101)) == false) goto L6;
        r101 = r101 + 1;
    L6:
        return r101;
    }

    private int nextI(byte[] r100, int r101, int r102) {
    L2:
        if (r101 >= r102) goto L6;
        if (ignore((char) r100[r101]) == false) goto L6;
        r101 = r101 + 1;
    L6:
        return r101;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(String r110, OutputStream r111) throws IOException {
        byte[] r100 = new byte[54];
        int r101 = r110.length();
    L3:
        if (r101 <= 0) goto L9;
        if (ignore(r110.charAt(r101 - 1)) == false) goto L9;
        r101 = r101 - 1;
    L9:
        if (r101 != 0) goto L11;
        return 0;
    L11:
        int r102 = r101;
        int r103 = 0;
    L12:
        if (r102 <= 0) goto L19;
        if (r103 == 4) goto L19;
        if (ignore(r110.charAt(r102 - 1)) == true) goto L18;
        r103 = r103 + 1;
    L18:
        r102 = r102 - 1;
    L19:
        int r104 = nextI(r110, 0, r102);
        int r105 = 0;
        int r112 = 0;
    L20:
        if (r104 >= r102) goto L29;
        int r113 = r104 + 1;
        byte r106 = this.decodingTable[r110.charAt(r104)];
        int r114 = nextI(r110, r113, r102);
        int r115 = r114 + 1;
        byte r116 = this.decodingTable[r110.charAt(r114)];
        int r117 = nextI(r110, r115, r102);
        int r118 = r117 + 1;
        byte r119 = this.decodingTable[r110.charAt(r117)];
        int r120 = nextI(r110, r118, r102);
        int r121 = r120 + 1;
        byte r122 = this.decodingTable[r110.charAt(r120)];
        if ((((r106 | r116) | r119) | r122) < 0) goto L28;
        int r123 = r105 + 1;
        r100[r105] = (byte) ((r106 << 2) | (r116 >> 4));
        int r107 = r123 + 1;
        r100[r123] = (byte) ((r116 << 4) | (r119 >> 2));
        r105 = r107 + 1;
        r100[r107] = (byte) ((r119 << 6) | r122);
        r112 = r112 + 3;
        if (r105 != 54) goto L26;
        r111.write(r100);
        r105 = 0;
    L26:
        r104 = nextI(r110, r121, r102);
        goto L20
    L28:
        throw new IOException("invalid characters encountered in base64 data");
    L29:
        if (r105 <= 0) goto L31;
        r111.write(r100, 0, r105);
    L31:
        int r108 = nextI(r110, r104, r101);
        int r109 = nextI(r110, r108 + 1, r101);
        int r124 = nextI(r110, r109 + 1, r101);
        return r112 + decodeLastBlock(r111, r110.charAt(r108), r110.charAt(r109), r110.charAt(r124), r110.charAt(nextI(r110, r124 + 1, r101)));
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(byte[] r110, int r111, int r210, OutputStream r211) throws IOException {
        byte[] r100 = new byte[54];
        int r101 = r111 + r210;
    L3:
        if (r101 <= r111) goto L9;
        if (ignore((char) r110[r101 - 1]) == false) goto L9;
        r101 = r101 - 1;
    L9:
        if (r101 != 0) goto L11;
        return 0;
    L11:
        int r102 = r101;
        int r103 = 0;
    L12:
        if (r102 <= r111) goto L19;
        if (r103 == 4) goto L19;
        if (ignore((char) r110[r102 - 1]) == true) goto L18;
        r103 = r103 + 1;
    L18:
        r102 = r102 - 1;
    L19:
        int r104 = nextI(r110, r111, r102);
        int r105 = 0;
        int r112 = 0;
    L20:
        if (r104 >= r102) goto L29;
        int r113 = r104 + 1;
        byte r106 = this.decodingTable[r110[r104]];
        int r114 = nextI(r110, r113, r102);
        int r115 = r114 + 1;
        byte r116 = this.decodingTable[r110[r114]];
        int r117 = nextI(r110, r115, r102);
        int r118 = r117 + 1;
        byte r119 = this.decodingTable[r110[r117]];
        int r120 = nextI(r110, r118, r102);
        int r121 = r120 + 1;
        byte r122 = this.decodingTable[r110[r120]];
        if ((((r106 | r116) | r119) | r122) < 0) goto L28;
        int r123 = r105 + 1;
        r100[r105] = (byte) ((r106 << 2) | (r116 >> 4));
        int r107 = r123 + 1;
        r100[r123] = (byte) ((r116 << 4) | (r119 >> 2));
        r105 = r107 + 1;
        r100[r107] = (byte) ((r119 << 6) | r122);
        if (r105 != 54) goto L26;
        r211.write(r100);
        r105 = 0;
    L26:
        r112 = r112 + 3;
        r104 = nextI(r110, r121, r102);
        goto L20
    L28:
        throw new IOException("invalid characters encountered in base64 data");
    L29:
        if (r105 <= 0) goto L31;
        r211.write(r100, 0, r105);
    L31:
        int r108 = nextI(r110, r104, r101);
        int r109 = nextI(r110, r108 + 1, r101);
        int r124 = nextI(r110, r109 + 1, r101);
        return r112 + decodeLastBlock(r211, (char) r110[r108], (char) r110[r109], (char) r110[r124], (char) r110[nextI(r110, r124 + 1, r101)]);
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int encode(byte[] r100, int r110, int r111, OutputStream r112) throws IOException {
        byte[] r101 = new byte[72];
    L3:
        if (r111 <= 0) goto L6;
        int r102 = Math.min(54, r111);
        r112.write(r101, 0, encode(r100, r110, r102, r101, 0));
        r110 = r110 + r102;
        r111 = r111 - r102;
        goto L3
    L6:
        return ((r111 + 2) / 3) * 4;
    }

    public int encode(byte[] r110, int r111, int r112, byte[] r113, int r114) throws IOException {
        int r100 = (r111 + r112) - 2;
        int r101 = r111;
        int r102 = r114;
    L3:
        if (r101 >= r100) goto L5;
        int r103 = r101 + 1;
        byte r104 = r110[r101];
        int r105 = r103 + 1;
        int r106 = r110[r103] & UByte.MAX_VALUE;
        int r107 = r105 + 1;
        int r108 = r110[r105] & UByte.MAX_VALUE;
        int r109 = r102 + 1;
        byte[] r115 = this.encodingTable;
        r113[r102] = r115[(r104 >>> 2) & 63];
        int r116 = r109 + 1;
        r113[r109] = r115[((r104 << 4) | (r106 >>> 4)) & 63];
        int r117 = r116 + 1;
        r113[r116] = r115[((r106 << 2) | (r108 >>> 6)) & 63];
        r102 = r117 + 1;
        r113[r117] = r115[r108 & 63];
        r101 = r107;
        goto L3
    L5:
        int r118 = r112 - (r101 - r111);
        if (r118 == 1) goto L10;
        if (r118 != 2) goto L12;
        int r119 = r110[r101] & UByte.MAX_VALUE;
        int r120 = r110[r101 + 1] & UByte.MAX_VALUE;
        int r121 = r102 + 1;
        byte[] r122 = this.encodingTable;
        r113[r102] = r122[(r119 >>> 2) & 63];
        int r123 = r121 + 1;
        r113[r121] = r122[((r119 << 4) | (r120 >>> 4)) & 63];
        int r124 = r123 + 1;
        r113[r123] = r122[(r120 << 2) & 63];
        r102 = r124 + 1;
        r113[r124] = this.padding;
    L12:
        return r102 - r114;
    L10:
        int r125 = r110[r101] & UByte.MAX_VALUE;
        int r126 = r102 + 1;
        byte[] r127 = this.encodingTable;
        r113[r102] = r127[(r125 >>> 2) & 63];
        int r128 = r126 + 1;
        r113[r126] = r127[(r125 << 4) & 63];
        int r129 = r128 + 1;
        byte r130 = this.padding;
        r113[r128] = r130;
        r102 = r129 + 1;
        r113[r129] = r130;
        goto L12
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
    }
}
