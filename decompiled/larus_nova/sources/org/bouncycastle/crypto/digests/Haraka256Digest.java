package org.bouncycastle.crypto.digests;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.lang.reflect.Array;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Haraka256Digest extends HarakaBase {
    private static final byte[][] RC = null;
    private final byte[] buffer;
    private int off;

    static {
        RC = new byte[][]{new byte[]{6, -124, 112, 76, -26, 32, -64, 10, -78, -59, -2, -16, 117, -127, 123, -99}, new byte[]{-117, 102, -76, -31, -120, -13, -96, 107, 100, 15, 107, -92, 47, 8, -9, 23}, new byte[]{52, 2, -34, 45, 83, -14, -124, -104, -49, 2, -99, 96, -97, 2, -111, 20}, new byte[]{14, -42, -22, -26, 46, 123, 79, 8, -69, -13, PSSSigner.TRAILER_IMPLICIT, -81, -3, 91, 79, 121}, new byte[]{-53, -49, -80, -53, 72, 114, 68, -117, 121, -18, -51, 28, -66, 57, 112, 68}, new byte[]{126, -22, -51, -18, 110, -112, 50, -73, -115, 83, 53, -19, 43, -118, 5, 123}, new byte[]{103, -62, -113, 67, 94, 46, 124, -48, -30, 65, 39, 97, -38, 79, -17, 27}, new byte[]{41, 36, -39, -80, -81, -54, -52, 7, 103, 95, -3, -30, 31, -57, 11, 59}, new byte[]{-85, 77, 99, -15, -26, -122, ByteCompanionObject.MAX_VALUE, -23, -20, -37, -113, -54, -71, -44, 101, -18}, new byte[]{28, 48, -65, -124, -44, -73, -51, 100, 91, 42, 64, 79, -83, 3, 126, 51}, new byte[]{-78, -52, 11, -71, -108, 23, 35, -65, 105, 2, -117, 46, -115, -10, -104, 0}, new byte[]{-6, 4, 120, -90, -34, 111, 85, 114, 74, -86, -98, -56, 92, -99, 45, -118}, new byte[]{-33, -76, -97, 43, 107, 119, 42, 18, 14, -6, 79, 46, 41, 18, -97, -44}, new byte[]{30, -95, 3, 68, -12, 73, -94, 54, 50, -42, 17, -82, -69, 106, 18, -18}, new byte[]{-81, 4, 73, -120, 75, 5, 0, -124, 95, -106, 0, -55, -100, -88, -20, -90}, new byte[]{33, 2, 94, -40, -99, 25, -100, 79, 120, -94, -57, -29, 39, -27, -109, -20}, new byte[]{-65, 58, -86, -8, -89, 89, -55, -73, -71, 40, 46, -51, -126, -44, 1, 115}, new byte[]{98, 96, 112, HTTP.CR, 97, -122, -80, 23, 55, -14, -17, -39, 16, 48, 125, 107}, new byte[]{90, -54, 69, -62, 33, 48, 4, 67, -127, -62, -111, 83, -10, -4, -102, -58}, new byte[]{-110, 35, -105, 60, 34, 107, 104, -69, 44, -81, -110, -24, 54, -47, -108, 58}};
    }

    public Haraka256Digest() {
        this.buffer = new byte[32];
    }

    public Haraka256Digest(Haraka256Digest r100) {
        this.buffer = Arrays.clone(r100.buffer);
        this.off = r100.off;
    }

    private int haraka256256(byte[] r110, byte[] r111, int r112) {
        Class r100 = Byte.TYPE;
        byte[][] r101 = (byte[][]) Array.newInstance(r100, new int[]{2, 16});
        Class r102 = Byte.TYPE;
        byte[][] r103 = (byte[][]) Array.newInstance(r102, new int[]{2, 16});
        System.arraycopy(r110, 0, r101[0], 0, 16);
        System.arraycopy(r110, 16, r101[1], 0, 16);
        byte[] r104 = r101[0];
        byte[][] r105 = RC;
        r101[0] = HarakaBase.aesEnc(r104, r105[0]);
        r101[1] = HarakaBase.aesEnc(r101[1], r105[1]);
        r101[0] = HarakaBase.aesEnc(r101[0], r105[2]);
        r101[1] = HarakaBase.aesEnc(r101[1], r105[3]);
        mix256(r101, r103);
        r101[0] = HarakaBase.aesEnc(r103[0], r105[4]);
        r101[1] = HarakaBase.aesEnc(r103[1], r105[5]);
        r101[0] = HarakaBase.aesEnc(r101[0], r105[6]);
        r101[1] = HarakaBase.aesEnc(r101[1], r105[7]);
        mix256(r101, r103);
        r101[0] = HarakaBase.aesEnc(r103[0], r105[8]);
        r101[1] = HarakaBase.aesEnc(r103[1], r105[9]);
        r101[0] = HarakaBase.aesEnc(r101[0], r105[10]);
        r101[1] = HarakaBase.aesEnc(r101[1], r105[11]);
        mix256(r101, r103);
        r101[0] = HarakaBase.aesEnc(r103[0], r105[12]);
        r101[1] = HarakaBase.aesEnc(r103[1], r105[13]);
        r101[0] = HarakaBase.aesEnc(r101[0], r105[14]);
        r101[1] = HarakaBase.aesEnc(r101[1], r105[15]);
        mix256(r101, r103);
        r101[0] = HarakaBase.aesEnc(r103[0], r105[16]);
        r101[1] = HarakaBase.aesEnc(r103[1], r105[17]);
        r101[0] = HarakaBase.aesEnc(r101[0], r105[18]);
        r101[1] = HarakaBase.aesEnc(r101[1], r105[19]);
        mix256(r101, r103);
        r101[0] = HarakaBase.xor(r103[0], r110, 0);
        r101[1] = HarakaBase.xor(r103[1], r110, 16);
        System.arraycopy(r101[0], 0, r111, r112, 16);
        System.arraycopy(r101[1], 0, r111, r112 + 16, 16);
        return 32;
    }

    private void mix256(byte[][] r100, byte[][] r101) {
        System.arraycopy(r100[0], 0, r101[0], 0, 4);
        System.arraycopy(r100[1], 0, r101[0], 4, 4);
        System.arraycopy(r100[0], 4, r101[0], 8, 4);
        System.arraycopy(r100[1], 4, r101[0], 12, 4);
        System.arraycopy(r100[0], 8, r101[1], 0, 4);
        System.arraycopy(r100[1], 8, r101[1], 4, 4);
        System.arraycopy(r100[0], 12, r101[1], 8, 4);
        System.arraycopy(r100[1], 12, r101[1], 12, 4);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        if (this.off != 32) goto L11;
        if ((r100.length - r101) < 32) goto L9;
        int r102 = haraka256256(this.buffer, r100, r101);
        reset();
        return r102;
    L9:
        throw new IllegalArgumentException("output too short to receive digest");
    L11:
        throw new IllegalStateException("input must be exactly 32 bytes");
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "Haraka-256";
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.off = 0;
        Arrays.clear(this.buffer);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        int r101 = this.off;
        if ((r101 + 1) > 32) goto L7;
        byte[] r102 = this.buffer;
        this.off = r101 + 1;
        r102[r101] = r100;
        return;
    L7:
        throw new IllegalArgumentException("total input cannot be more than 32 bytes");
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
        int r103 = this.off;
        if ((r103 + r102) > 32) goto L7;
        System.arraycopy(r100, r101, this.buffer, r103, r102);
        this.off += r102;
        return;
    L7:
        throw new IllegalArgumentException("total input cannot be more than 32 bytes");
    }
}
