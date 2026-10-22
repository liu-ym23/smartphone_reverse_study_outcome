package org.bouncycastle.crypto.engines;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes42.dex */
public class CamelliaLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int MASK8 = 255;
    private static final byte[] SBOX1 = null;
    private static final int[] SIGMA = null;
    private boolean _keyis128;
    private boolean initialized;

    /* JADX INFO: renamed from: ke, reason: collision with root package name */
    private int[] f525172ke;

    /* JADX INFO: renamed from: kw, reason: collision with root package name */
    private int[] f525173kw;
    private int[] state;
    private int[] subkey;

    static {
        SIGMA = new int[]{-1600231809, 1003262091, -1233459112, 1286239154, -957401297, -380665154, 1426019237, -237801700, 283453434, -563598051, -1336506174, -1276722691};
        SBOX1 = new byte[]{112, -126, 44, -20, -77, 39, -64, -27, -28, -123, 87, 53, -22, 12, -82, 65, 35, -17, 107, -109, 69, 25, -91, 33, -19, 14, 79, 78, 29, 101, -110, -67, -122, -72, -81, -113, 124, -21, 31, -50, 62, 48, -36, 95, 94, -59, 11, 26, -90, -31, 57, -54, -43, 71, 93, Base64.padSymbol, -39, 1, 90, -42, 81, 86, 108, 77, -117, HTTP.CR, -102, 102, -5, -52, -80, 45, 116, 18, 43, 32, -16, -79, -124, -103, -33, 76, -53, -62, 52, 126, 118, 5, 109, -73, -87, 49, -47, 23, 4, -41, 20, 88, 58, 97, -34, 27, 17, 28, 50, 15, -100, 22, 83, 24, -14, 34, -2, 68, -49, -78, -61, -75, 122, -111, 36, 8, -24, -88, 96, -4, 105, 80, -86, -48, -96, 125, -95, -119, 98, -105, 84, 91, 30, -107, -32, -1, 100, -46, 16, -60, 0, 72, -93, -9, 117, -37, -118, 3, -26, -38, 9, 63, -35, -108, -121, 92, -125, 2, -51, 74, -112, 51, 115, 103, -10, -13, -99, ByteCompanionObject.MAX_VALUE, -65, -30, 82, -101, -40, 38, -56, 55, -58, 59, -127, -106, 111, 75, 19, -66, 99, 46, -23, 121, -89, -116, -97, 110, PSSSigner.TRAILER_IMPLICIT, -114, 41, -11, -7, -74, 47, -3, -76, 89, 120, -104, 6, 106, -25, 70, 113, -70, -44, 37, -85, 66, -120, -94, -115, -6, 114, 7, -71, 85, -8, -18, -84, 10, 54, 73, 42, 104, 60, 56, -15, -92, 64, 40, -45, 123, -69, -55, 67, -63, 21, -29, -83, -12, 119, -57, ByteCompanionObject.MIN_VALUE, -98};
    }

    public CamelliaLightEngine() {
        this.subkey = new int[96];
        this.f525173kw = new int[8];
        this.f525172ke = new int[12];
        this.state = new int[4];
    }

    private int bytes2int(byte[] r100, int r101) {
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= 4) goto L6;
        r103 = (r103 << 8) + (r100[r102 + r101] & UByte.MAX_VALUE);
        r102 = r102 + 1;
        goto L4
    L6:
        return r103;
    }

    private void camelliaF2(int[] r110, int[] r111, int r112) {
        int r100 = r110[0] ^ r111[r112 + 0];
        int r101 = (sbox4(r100 & 255) | (sbox3((r100 >>> 8) & 255) << 8)) | (sbox2((r100 >>> 16) & 255) << 16);
        byte[] r102 = SBOX1;
        int r103 = ((r102[(r100 >>> 24) & 255] & UByte.MAX_VALUE) << 24) | r101;
        int r104 = r110[1] ^ r111[r112 + 1];
        int r105 = ((r102[r104 & 255] & UByte.MAX_VALUE) | (sbox4((r104 >>> 8) & 255) << 8)) | (sbox3((r104 >>> 16) & 255) << 16);
        int r106 = leftRotate((sbox2((r104 >>> 24) & 255) << 24) | r105, 8);
        int r107 = r103 ^ r106;
        int r108 = leftRotate(r106, 8) ^ r107;
        int r109 = rightRotate(r107, 8) ^ r108;
        int r113 = r110[2];
        r110[2] = (leftRotate(r108, 16) ^ r109) ^ r113;
        int r114 = r110[3];
        r110[3] = leftRotate(r109, 8) ^ r114;
        int r115 = r110[2] ^ r111[r112 + 2];
        int r116 = (sbox4(r115 & 255) | (sbox3((r115 >>> 8) & 255) << 8)) | (sbox2((r115 >>> 16) & 255) << 16);
        int r117 = ((r102[(r115 >>> 24) & 255] & UByte.MAX_VALUE) << 24) | r116;
        int r118 = r110[3];
        int r119 = r111[r112 + 3] ^ r118;
        int r120 = ((r102[r119 & 255] & UByte.MAX_VALUE) | (sbox4((r119 >>> 8) & 255) << 8)) | (sbox3((r119 >>> 16) & 255) << 16);
        int r121 = leftRotate((sbox2((r119 >>> 24) & 255) << 24) | r120, 8);
        int r122 = r117 ^ r121;
        int r123 = leftRotate(r121, 8) ^ r122;
        int r124 = rightRotate(r122, 8) ^ r123;
        int r125 = r110[0];
        r110[0] = (leftRotate(r123, 16) ^ r124) ^ r125;
        r110[1] = r110[1] ^ leftRotate(r124, 8);
    }

    private void camelliaFLs(int[] r100, int[] r101, int r102) {
        int r103 = r100[1] ^ leftRotate(r100[0] & r101[r102 + 0], 1);
        r100[1] = r103;
        int r104 = r100[0];
        r100[0] = (r103 | r101[r102 + 1]) ^ r104;
        int r105 = r100[2];
        int r106 = r101[r102 + 3];
        int r107 = r100[3];
        int r108 = r105 ^ (r106 | r107);
        r100[2] = r108;
        r100[3] = leftRotate(r101[r102 + 2] & r108, 1) ^ r107;
    }

    private static void decroldq(int r100, int[] r110, int r111, int[] r112, int r113) {
        int r101 = r113 + 2;
        int r102 = r111 + 0;
        int r103 = r111 + 1;
        int r104 = 32 - r100;
        r112[r101] = (r110[r102] << r100) | (r110[r103] >>> r104);
        int r105 = r113 + 3;
        int r106 = r111 + 2;
        r112[r105] = (r110[r103] << r100) | (r110[r106] >>> r104);
        int r107 = r113 + 0;
        int r114 = r111 + 3;
        r112[r107] = (r110[r106] << r100) | (r110[r114] >>> r104);
        int r115 = r113 + 1;
        r112[r115] = (r110[r114] << r100) | (r110[r102] >>> r104);
        r110[r102] = r112[r101];
        r110[r103] = r112[r105];
        r110[r106] = r112[r107];
        r110[r114] = r112[r115];
    }

    private static void decroldqo32(int r100, int[] r110, int r111, int[] r112, int r113) {
        int r101 = r113 + 2;
        int r102 = r111 + 1;
        int r103 = r100 - 32;
        int r104 = r111 + 2;
        int r105 = 64 - r100;
        r112[r101] = (r110[r102] << r103) | (r110[r104] >>> r105);
        int r106 = r113 + 3;
        int r107 = r111 + 3;
        r112[r106] = (r110[r104] << r103) | (r110[r107] >>> r105);
        int r108 = r113 + 0;
        int r114 = r111 + 0;
        r112[r108] = (r110[r107] << r103) | (r110[r114] >>> r105);
        int r115 = r113 + 1;
        r112[r115] = (r110[r102] >>> r105) | (r110[r114] << r103);
        r110[r114] = r112[r101];
        r110[r102] = r112[r106];
        r110[r104] = r112[r108];
        r110[r107] = r112[r115];
    }

    private void int2bytes(int r100, byte[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 >= 4) goto L6;
        r101[(3 - r103) + r102] = (byte) r100;
        r100 = r100 >>> 8;
        r103 = r103 + 1;
        goto L4
    }

    private byte lRot8(byte r100, int r101) {
        int r102 = r100 << r101;
        return (byte) (((r100 & 255) >>> (8 - r101)) | r102);
    }

    private static int leftRotate(int r100, int r101) {
        return (r100 << r101) + (r100 >>> (32 - r101));
    }

    private int processBlock128(byte[] r100, int r110, byte[] r111, int r112) {
        int r101 = 0;
    L4:
        if (r101 >= 4) goto L6;
        this.state[r101] = bytes2int(r100, (r101 * 4) + r110);
        int[] r102 = this.state;
        r102[r101] = r102[r101] ^ this.f525173kw[r101];
        r101 = r101 + 1;
        goto L4
    L6:
        camelliaF2(this.state, this.subkey, 0);
        camelliaF2(this.state, this.subkey, 4);
        camelliaF2(this.state, this.subkey, 8);
        camelliaFLs(this.state, this.f525172ke, 0);
        camelliaF2(this.state, this.subkey, 12);
        camelliaF2(this.state, this.subkey, 16);
        camelliaF2(this.state, this.subkey, 20);
        camelliaFLs(this.state, this.f525172ke, 4);
        camelliaF2(this.state, this.subkey, 24);
        camelliaF2(this.state, this.subkey, 28);
        camelliaF2(this.state, this.subkey, 32);
        int[] r103 = this.state;
        int r104 = r103[2];
        int[] r105 = this.f525173kw;
        int r106 = r105[4] ^ r104;
        r103[2] = r106;
        r103[3] = r103[3] ^ r105[5];
        r103[0] = r103[0] ^ r105[6];
        int r107 = r103[1];
        r103[1] = r105[7] ^ r107;
        int2bytes(r106, r111, r112);
        int2bytes(this.state[3], r111, r112 + 4);
        int2bytes(this.state[0], r111, r112 + 8);
        int2bytes(this.state[1], r111, r112 + 12);
        return 16;
    }

    private int processBlock192or256(byte[] r100, int r110, byte[] r111, int r112) {
        int r101 = 0;
    L4:
        if (r101 >= 4) goto L6;
        this.state[r101] = bytes2int(r100, (r101 * 4) + r110);
        int[] r102 = this.state;
        r102[r101] = r102[r101] ^ this.f525173kw[r101];
        r101 = r101 + 1;
        goto L4
    L6:
        camelliaF2(this.state, this.subkey, 0);
        camelliaF2(this.state, this.subkey, 4);
        camelliaF2(this.state, this.subkey, 8);
        camelliaFLs(this.state, this.f525172ke, 0);
        camelliaF2(this.state, this.subkey, 12);
        camelliaF2(this.state, this.subkey, 16);
        camelliaF2(this.state, this.subkey, 20);
        camelliaFLs(this.state, this.f525172ke, 4);
        camelliaF2(this.state, this.subkey, 24);
        camelliaF2(this.state, this.subkey, 28);
        camelliaF2(this.state, this.subkey, 32);
        camelliaFLs(this.state, this.f525172ke, 8);
        camelliaF2(this.state, this.subkey, 36);
        camelliaF2(this.state, this.subkey, 40);
        camelliaF2(this.state, this.subkey, 44);
        int[] r103 = this.state;
        int r104 = r103[2];
        int[] r105 = this.f525173kw;
        int r106 = r104 ^ r105[4];
        r103[2] = r106;
        r103[3] = r103[3] ^ r105[5];
        r103[0] = r103[0] ^ r105[6];
        int r107 = r103[1];
        r103[1] = r105[7] ^ r107;
        int2bytes(r106, r111, r112);
        int2bytes(this.state[3], r111, r112 + 4);
        int2bytes(this.state[0], r111, r112 + 8);
        int2bytes(this.state[1], r111, r112 + 12);
        return 16;
    }

    private static int rightRotate(int r100, int r101) {
        return (r100 >>> r101) + (r100 << (32 - r101));
    }

    private static void roldq(int r100, int[] r110, int r111, int[] r112, int r113) {
        int r101 = r113 + 0;
        int r102 = r111 + 0;
        int r103 = r111 + 1;
        int r104 = 32 - r100;
        r112[r101] = (r110[r102] << r100) | (r110[r103] >>> r104);
        int r105 = r113 + 1;
        int r106 = r111 + 2;
        r112[r105] = (r110[r103] << r100) | (r110[r106] >>> r104);
        int r107 = r113 + 2;
        int r114 = r111 + 3;
        r112[r107] = (r110[r106] << r100) | (r110[r114] >>> r104);
        int r115 = r113 + 3;
        r112[r115] = (r110[r114] << r100) | (r110[r102] >>> r104);
        r110[r102] = r112[r101];
        r110[r103] = r112[r105];
        r110[r106] = r112[r107];
        r110[r114] = r112[r115];
    }

    private static void roldqo32(int r100, int[] r110, int r111, int[] r112, int r113) {
        int r101 = r113 + 0;
        int r102 = r111 + 1;
        int r103 = r100 - 32;
        int r104 = r111 + 2;
        int r105 = 64 - r100;
        r112[r101] = (r110[r102] << r103) | (r110[r104] >>> r105);
        int r106 = r113 + 1;
        int r107 = r111 + 3;
        r112[r106] = (r110[r104] << r103) | (r110[r107] >>> r105);
        int r108 = r113 + 2;
        int r114 = r111 + 0;
        r112[r108] = (r110[r107] << r103) | (r110[r114] >>> r105);
        int r115 = r113 + 3;
        r112[r115] = (r110[r102] >>> r105) | (r110[r114] << r103);
        r110[r114] = r112[r101];
        r110[r102] = r112[r106];
        r110[r104] = r112[r108];
        r110[r107] = r112[r115];
    }

    private int sbox2(int r100) {
        return lRot8(SBOX1[r100], 1) & UByte.MAX_VALUE;
    }

    private int sbox3(int r100) {
        return lRot8(SBOX1[r100], 7) & UByte.MAX_VALUE;
    }

    private int sbox4(int r100) {
        return SBOX1[lRot8((byte) r100, 1) & UByte.MAX_VALUE] & UByte.MAX_VALUE;
    }

    private void setKey(boolean r210, byte[] r211) {
        int[] r100 = new int[8];
        int[] r101 = new int[4];
        int[] r102 = new int[4];
        int[] r103 = new int[4];
        int r104 = r211.length;
        if (r104 == 16) goto L11;
        if (r104 == 24) goto L9;
        if (r104 != 32) goto L8;
        r100[0] = bytes2int(r211, 0);
        r100[1] = bytes2int(r211, 4);
        r100[2] = bytes2int(r211, 8);
        r100[3] = bytes2int(r211, 12);
        r100[4] = bytes2int(r211, 16);
        r100[5] = bytes2int(r211, 20);
        r100[6] = bytes2int(r211, 24);
        r100[7] = bytes2int(r211, 28);
    L10:
        this._keyis128 = false;
    L12:
        int r105 = 0;
    L13:
        if (r105 >= 4) goto L15;
        r101[r105] = r100[r105] ^ r100[r105 + 4];
        r105 = r105 + 1;
        goto L13
    L15:
        camelliaF2(r101, SIGMA, 0);
        int r106 = 0;
    L16:
        if (r106 >= 4) goto L18;
        r101[r106] = r101[r106] ^ r100[r106];
        r106 = r106 + 1;
        goto L16
    L18:
        camelliaF2(r101, SIGMA, 4);
        if (this._keyis128 == false) goto L24;
        int[] r107 = this.f525173kw;
        if (r210 == false) goto L23;
        r107[0] = r100[0];
        r107[1] = r100[1];
        r107[2] = r100[2];
        r107[3] = r100[3];
        roldq(15, r100, 0, this.subkey, 4);
        roldq(30, r100, 0, this.subkey, 12);
        roldq(15, r100, 0, r103, 0);
        int[] r108 = this.subkey;
        r108[18] = r103[2];
        r108[19] = r103[3];
        roldq(17, r100, 0, this.f525172ke, 4);
        roldq(17, r100, 0, this.subkey, 24);
        roldq(17, r100, 0, this.subkey, 32);
        int[] r109 = this.subkey;
        r109[0] = r101[0];
        r109[1] = r101[1];
        r109[2] = r101[2];
        r109[3] = r101[3];
        roldq(15, r101, 0, r109, 8);
        roldq(15, r101, 0, this.f525172ke, 0);
        roldq(15, r101, 0, r103, 0);
        int[] r110 = this.subkey;
        r110[16] = r103[0];
        r110[17] = r103[1];
        roldq(15, r101, 0, r110, 20);
        roldqo32(34, r101, 0, this.subkey, 28);
        roldq(17, r101, 0, this.f525173kw, 4);
        return;
    L23:
        r107[4] = r100[0];
        r107[5] = r100[1];
        r107[6] = r100[2];
        r107[7] = r100[3];
        decroldq(15, r100, 0, this.subkey, 28);
        decroldq(30, r100, 0, this.subkey, 20);
        decroldq(15, r100, 0, r103, 0);
        int[] r111 = this.subkey;
        r111[16] = r103[0];
        r111[17] = r103[1];
        decroldq(17, r100, 0, this.f525172ke, 0);
        decroldq(17, r100, 0, this.subkey, 8);
        decroldq(17, r100, 0, this.subkey, 0);
        int[] r112 = this.subkey;
        r112[34] = r101[0];
        r112[35] = r101[1];
        r112[32] = r101[2];
        r112[33] = r101[3];
        decroldq(15, r101, 0, r112, 24);
        decroldq(15, r101, 0, this.f525172ke, 4);
        decroldq(15, r101, 0, r103, 0);
        int[] r113 = this.subkey;
        r113[18] = r103[2];
        r113[19] = r103[3];
        decroldq(15, r101, 0, r113, 12);
        decroldqo32(34, r101, 0, this.subkey, 4);
        roldq(17, r101, 0, this.f525173kw, 0);
        return;
    L24:
        int r114 = 0;
    L25:
        if (r114 >= 4) goto L27;
        r102[r114] = r101[r114] ^ r100[r114 + 4];
        r114 = r114 + 1;
        goto L25
    L27:
        camelliaF2(r102, SIGMA, 8);
        int[] r115 = this.f525173kw;
        if (r210 == false) goto L30;
        r115[0] = r100[0];
        r115[1] = r100[1];
        r115[2] = r100[2];
        r115[3] = r100[3];
        roldqo32(45, r100, 0, this.subkey, 16);
        roldq(15, r100, 0, this.f525172ke, 4);
        roldq(17, r100, 0, this.subkey, 32);
        roldqo32(34, r100, 0, this.subkey, 44);
        roldq(15, r100, 4, this.subkey, 4);
        roldq(15, r100, 4, this.f525172ke, 0);
        roldq(30, r100, 4, this.subkey, 24);
        roldqo32(34, r100, 4, this.subkey, 36);
        roldq(15, r101, 0, this.subkey, 8);
        roldq(30, r101, 0, this.subkey, 20);
        int[] r116 = this.f525172ke;
        r116[8] = r101[1];
        r116[9] = r101[2];
        r116[10] = r101[3];
        r116[11] = r101[0];
        roldqo32(49, r101, 0, this.subkey, 40);
        int[] r117 = this.subkey;
        r117[0] = r102[0];
        r117[1] = r102[1];
        r117[2] = r102[2];
        r117[3] = r102[3];
        roldq(30, r102, 0, r117, 12);
        roldq(30, r102, 0, this.subkey, 28);
        roldqo32(51, r102, 0, this.f525173kw, 4);
        return;
    L30:
        r115[4] = r100[0];
        r115[5] = r100[1];
        r115[6] = r100[2];
        r115[7] = r100[3];
        decroldqo32(45, r100, 0, this.subkey, 28);
        decroldq(15, r100, 0, this.f525172ke, 4);
        decroldq(17, r100, 0, this.subkey, 12);
        decroldqo32(34, r100, 0, this.subkey, 0);
        decroldq(15, r100, 4, this.subkey, 40);
        decroldq(15, r100, 4, this.f525172ke, 8);
        decroldq(30, r100, 4, this.subkey, 20);
        decroldqo32(34, r100, 4, this.subkey, 8);
        decroldq(15, r101, 0, this.subkey, 36);
        decroldq(30, r101, 0, this.subkey, 24);
        int[] r118 = this.f525172ke;
        r118[2] = r101[1];
        r118[3] = r101[2];
        r118[0] = r101[3];
        r118[1] = r101[0];
        decroldqo32(49, r101, 0, this.subkey, 4);
        int[] r119 = this.subkey;
        r119[46] = r102[0];
        r119[47] = r102[1];
        r119[44] = r102[2];
        r119[45] = r102[3];
        decroldq(30, r102, 0, r119, 32);
        decroldq(30, r102, 0, this.subkey, 16);
        roldqo32(51, r102, 0, this.f525173kw, 0);
        return;
    L8:
        throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
    L9:
        r100[0] = bytes2int(r211, 0);
        r100[1] = bytes2int(r211, 4);
        r100[2] = bytes2int(r211, 8);
        r100[3] = bytes2int(r211, 12);
        r100[4] = bytes2int(r211, 16);
        int r120 = bytes2int(r211, 20);
        r100[5] = r120;
        r100[6] = ~r100[4];
        r100[7] = ~r120;
        goto L10
    L11:
        this._keyis128 = true;
        r100[0] = bytes2int(r211, 0);
        r100[1] = bytes2int(r211, 4);
        r100[2] = bytes2int(r211, 8);
        r100[3] = bytes2int(r211, 12);
        r100[7] = 0;
        r100[6] = 0;
        r100[5] = 0;
        r100[4] = 0;
        goto L12
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Camellia";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        setKey(r100, ((KeyParameter) r101).getKey());
        this.initialized = true;
        return;
    L7:
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws IllegalStateException {
        if (this.initialized == false) goto L19;
        if ((r101 + 16) > r100.length) goto L17;
        if ((r103 + 16) > r102.length) goto L15;
        if (this._keyis128 == false) goto L13;
        return processBlock128(r100, r101, r102, r103);
    L13:
        return processBlock192or256(r100, r101, r102, r103);
    L15:
        throw new OutputLengthException("output buffer too short");
    L17:
        throw new DataLengthException("input buffer too short");
    L19:
        throw new IllegalStateException("Camellia is not initialized");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
