package org.bouncycastle.math.ec.custom.sec;

import com.ss.ttm.player.MediaPlayer;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WTauNafMultiplier;
import org.bouncycastle.math.raw.Nat320;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecT283K1Curve extends ECCurve.AbstractF2m {
    private static final ECFieldElement[] SECT283K1_AFFINE_ZS = null;
    private static final int SECT283K1_DEFAULT_COORDS = 6;
    protected SecT283K1Point infinity;

    static {
        SECT283K1_AFFINE_ZS = new ECFieldElement[]{new SecT283FieldElement(ECConstants.ONE)};
    }

    public SecT283K1Curve() {
        super(MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5, 7, 12);
        this.infinity = new SecT283K1Point(this, null, null);
        this.f525423a = fromBigInteger(BigInteger.valueOf(0));
        this.f525424b = fromBigInteger(BigInteger.valueOf(1));
        this.order = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61"));
        this.cofactor = BigInteger.valueOf(4);
        this.coord = 6;
    }

    public static /* synthetic */ ECFieldElement[] access$000() {
        return SECT283K1_AFFINE_ZS;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECCurve cloneCurve() {
        return new SecT283K1Curve();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] r100, int r101, final int r102) {
        final long[] r103 = new long[(r102 * 5) * 2];
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L6;
        ECPoint r106 = r100[r101 + r104];
        Nat320.copy64(((SecT283FieldElement) r106.getRawXCoord()).f525476x, 0, r103, r105);
        int r107 = r105 + 5;
        Nat320.copy64(((SecT283FieldElement) r106.getRawYCoord()).f525476x, 0, r103, r107);
        r105 = r107 + 5;
        r104 = r104 + 1;
        goto L3
    L6:
        return new AnonymousClass1(this, r102, r103);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECMultiplier createDefaultMultiplier() {
        return new WTauNafMultiplier();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101) {
        return new SecT283K1Point(this, r100, r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101, ECFieldElement[] r102) {
        return new SecT283K1Point(this, r100, r101, r102);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger r100) {
        return new SecT283FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public int getFieldSize() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 5;
    }

    public int getK2() {
        return 7;
    }

    public int getK3() {
        return 12;
    }

    public int getM() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS;
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractF2m
    public boolean isKoblitz() {
        return true;
    }

    public boolean isTrinomial() {
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public boolean supportsCoordinateSystem(int r100) {
        if (r100 == 6) goto L6;
        return false;
    L6:
        return true;
    }
}
