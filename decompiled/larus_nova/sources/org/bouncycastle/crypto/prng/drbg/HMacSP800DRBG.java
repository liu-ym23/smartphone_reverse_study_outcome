package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class HMacSP800DRBG implements SP80090DRBG {
    private static final int MAX_BITS_REQUEST = 262144;
    private static final long RESEED_MAX = 140737488355328L;
    private byte[] _K;
    private byte[] _V;
    private EntropySource _entropySource;
    private Mac _hMac;
    private long _reseedCounter;
    private int _securityStrength;

    public HMacSP800DRBG(Mac r100, int r101, EntropySource r102, byte[] r103, byte[] r104) {
        if (r101 > Utils.getMaxSecurityStrength(r100)) goto L11;
        if (r102.entropySize() < r101) goto L9;
        this._securityStrength = r101;
        this._entropySource = r102;
        this._hMac = r100;
        byte[] r105 = Arrays.concatenate(getEntropy(), r104, r103);
        byte[] r106 = new byte[r100.getMacSize()];
        this._K = r106;
        byte[] r107 = new byte[r106.length];
        this._V = r107;
        Arrays.fill(r107, (byte) 1);
        hmac_DRBG_Update(r105);
        this._reseedCounter = 1;
        return;
    L9:
        throw new IllegalArgumentException("Not enough entropy for security strength required");
    L11:
        throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
    }

    private byte[] getEntropy() {
        byte[] r100 = this._entropySource.getEntropy();
        if (r100.length < ((this._securityStrength + 7) / 8)) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private void hmac_DRBG_Update(byte[] r100) {
        hmac_DRBG_Update_Func(r100, (byte) 0);
        if (r100 == null) goto L6;
        hmac_DRBG_Update_Func(r100, (byte) 1);
        return;
    }

    private void hmac_DRBG_Update_Func(byte[] r100, byte r101) {
        this._hMac.init(new KeyParameter(this._K));
        Mac r102 = this._hMac;
        byte[] r103 = this._V;
        r102.update(r103, 0, r103.length);
        this._hMac.update(r101);
        if (r100 == null) goto L5;
        this._hMac.update(r100, 0, r100.length);
    L5:
        this._hMac.doFinal(this._K, 0);
        this._hMac.init(new KeyParameter(this._K));
        Mac r104 = this._hMac;
        byte[] r105 = this._V;
        r104.update(r105, 0, r105.length);
        this._hMac.doFinal(this._V, 0);
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] r100, byte[] r110, boolean r111) {
        int r101 = r100.length * 8;
        if (r101 > 262144) goto L21;
        if (this._reseedCounter <= RESEED_MAX) goto L8;
        return -1;
    L8:
        if (r111 == false) goto L10;
        reseed(r110);
        r110 = null;
    L10:
        if (r110 == null) goto L12;
        hmac_DRBG_Update(r110);
    L12:
        int r112 = r100.length;
        byte[] r102 = new byte[r112];
        int r103 = r100.length / this._V.length;
        this._hMac.init(new KeyParameter(this._K));
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L15;
        Mac r105 = this._hMac;
        byte[] r106 = this._V;
        r105.update(r106, 0, r106.length);
        this._hMac.doFinal(this._V, 0);
        byte[] r107 = this._V;
        System.arraycopy(r107, 0, r102, r107.length * r104, r107.length);
        r104 = r104 + 1;
        goto L13
    L15:
        byte[] r108 = this._V;
        if ((r108.length * r103) >= r112) goto L18;
        this._hMac.update(r108, 0, r108.length);
        this._hMac.doFinal(this._V, 0);
        byte[] r109 = this._V;
        System.arraycopy(r109, 0, r102, r109.length * r103, r112 - (r103 * r109.length));
    L18:
        hmac_DRBG_Update(r110);
        this._reseedCounter++;
        System.arraycopy(r102, 0, r100, 0, r100.length);
        return r101;
    L21:
        throw new IllegalArgumentException("Number of bits per request limited to 262144");
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int getBlockSize() {
        return this._V.length * 8;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] r100) {
        hmac_DRBG_Update(Arrays.concatenate(getEntropy(), r100));
        this._reseedCounter = 1;
    }
}
