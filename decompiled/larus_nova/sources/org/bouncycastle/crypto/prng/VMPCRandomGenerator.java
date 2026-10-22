package org.bouncycastle.crypto.prng;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class VMPCRandomGenerator implements RandomGenerator {
    private byte[] P;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte f525337n;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private byte f525338s;

    public VMPCRandomGenerator() {
        this.f525337n = 0;
        this.P = new byte[]{-69, 44, 98, ByteCompanionObject.MAX_VALUE, -75, -86, -44, HTTP.CR, -127, -2, -78, -126, -53, -96, -95, 8, 24, 113, 86, -24, 73, 2, 16, -60, -34, 53, -91, -20, ByteCompanionObject.MIN_VALUE, 18, -72, 105, -38, 47, 117, -52, -94, 9, 54, 3, 97, 45, -3, -32, -35, 5, 67, -112, -83, -56, -31, -81, 87, -101, 76, -40, 81, -82, 80, -123, 60, 10, -28, -13, -100, 38, 35, 83, -55, -125, -105, 70, -79, -103, 100, 49, 119, -43, 29, -42, 120, -67, 94, -80, -118, 34, 56, -8, 104, 43, 42, -59, -45, -9, PSSSigner.TRAILER_IMPLICIT, 111, -33, 4, -27, -107, 62, 37, -122, -90, 11, -113, -15, 36, 14, -41, 64, -77, -49, 126, 6, 21, -102, 77, 28, -93, -37, 50, -110, 88, 17, 39, -12, 89, -48, 78, 106, 23, 91, -84, -1, 7, -64, 101, 121, -4, -57, -51, 118, 66, 93, -25, 58, 52, 122, 48, 40, 15, 115, 1, -7, -47, -46, 25, -23, -111, -71, 90, -19, 65, 109, -76, -61, -98, -65, 99, -6, 31, 51, 96, 71, -119, -16, -106, 26, 95, -109, Base64.padSymbol, 55, 75, -39, -88, -63, 27, -10, 57, -117, -73, 12, 32, -50, -120, 110, -74, 116, -114, -115, 22, 41, -14, -121, -11, -21, 112, -29, -5, 85, -97, -58, 68, 74, 69, 125, -30, 107, 92, 108, 102, -87, -116, -18, -124, 19, -89, 30, -99, -36, 103, 72, -70, 46, -26, -92, -85, 124, -108, 0, 33, -17, -22, -66, -54, 114, 79, 82, -104, 63, -62, 20, 123, 59, 84};
        this.f525338s = -66;
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(long r100) {
        addSeedMaterial(Pack.longToBigEndian(r100));
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        byte[] r102 = this.P;
        byte r103 = this.f525338s;
        byte r104 = this.f525337n;
        byte r105 = r102[((r103 + r102[r104 & UByte.MAX_VALUE]) + r100[r101]) & 255];
        this.f525338s = r105;
        byte r106 = r102[r104 & UByte.MAX_VALUE];
        r102[r104 & UByte.MAX_VALUE] = r102[r105 & UByte.MAX_VALUE];
        r102[r105 & UByte.MAX_VALUE] = r106;
        this.f525337n = (byte) ((r104 + 1) & 255);
        r101 = r101 + 1;
        goto L4
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] r100) {
        nextBytes(r100, 0, r100.length);
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] r100, int r101, int r110) {
        byte[] r102 = this.P;
        monitor-enter(r102);
        int r111 = r110 + r101;
    L5:
        if (r101 == r111) goto L7;
        byte[] r103 = this.P;     // Catch: Throwable -> L9
        byte r104 = this.f525338s;     // Catch: Throwable -> L9
        byte r105 = this.f525337n;     // Catch: Throwable -> L9
        byte r106 = r103[(r104 + r103[r105 & UByte.MAX_VALUE]) & 255];     // Catch: Throwable -> L9
        this.f525338s = r106;     // Catch: Throwable -> L9
        r100[r101] = r103[(r103[r103[r106 & UByte.MAX_VALUE] & UByte.MAX_VALUE] + 1) & 255];     // Catch: Throwable -> L9
        byte r107 = r103[r105 & UByte.MAX_VALUE];     // Catch: Throwable -> L9
        r103[r105 & UByte.MAX_VALUE] = r103[r106 & UByte.MAX_VALUE];     // Catch: Throwable -> L9
        r103[r106 & UByte.MAX_VALUE] = r107;     // Catch: Throwable -> L9
        this.f525337n = (byte) ((r105 + 1) & 255);     // Catch: Throwable -> L9
        r101 = r101 + 1;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
    }
}
