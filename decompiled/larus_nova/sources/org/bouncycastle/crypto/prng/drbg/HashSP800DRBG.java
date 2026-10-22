package org.bouncycastle.crypto.prng.drbg;

import com.ss.ttm.player.MediaPlayer;
import java.util.Hashtable;
import kotlin.UByte;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class HashSP800DRBG implements SP80090DRBG {
    private static final int MAX_BITS_REQUEST = 262144;
    private static final byte[] ONE = null;
    private static final long RESEED_MAX = 140737488355328L;
    private static final Hashtable seedlens = null;
    private byte[] _C;
    private byte[] _V;
    private Digest _digest;
    private EntropySource _entropySource;
    private long _reseedCounter;
    private int _securityStrength;
    private int _seedLength;

    static {
        ONE = new byte[]{1};
        Hashtable r100 = new Hashtable();
        seedlens = r100;
        r100.put("SHA-1", Integers.valueOf(440));
        r100.put(McElieceCCA2KeyGenParameterSpec.SHA224, Integers.valueOf(440));
        r100.put("SHA-256", Integers.valueOf(440));
        r100.put(SPHINCSKeyParameters.SHA512_256, Integers.valueOf(440));
        r100.put("SHA-512/224", Integers.valueOf(440));
        r100.put(McElieceCCA2KeyGenParameterSpec.SHA384, Integers.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION));
        r100.put("SHA-512", Integers.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION));
    }

    public HashSP800DRBG(Digest r100, int r101, EntropySource r102, byte[] r103, byte[] r104) {
        if (r101 > Utils.getMaxSecurityStrength(r100)) goto L11;
        if (r102.entropySize() < r101) goto L9;
        this._digest = r100;
        this._entropySource = r102;
        this._securityStrength = r101;
        this._seedLength = ((Integer) seedlens.get(r100.getAlgorithmName())).intValue();
        byte[] r105 = Arrays.concatenate(getEntropy(), r104, r103);
        byte[] r106 = Utils.hash_df(this._digest, r105, this._seedLength);
        this._V = r106;
        byte[] r107 = new byte[r106.length + 1];
        System.arraycopy(r106, 0, r107, 1, r106.length);
        this._C = Utils.hash_df(this._digest, r107, this._seedLength);
        this._reseedCounter = 1;
        return;
    L9:
        throw new IllegalArgumentException("Not enough entropy for security strength required");
    L11:
        throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
    }

    private void addTo(byte[] r100, byte[] r101) {
        int r102 = 1;
        int r103 = 0;
    L4:
        if (r102 > r101.length) goto L10;
        int r104 = ((r100[r100.length - r102] & UByte.MAX_VALUE) + (r101[r101.length - r102] & UByte.MAX_VALUE)) + r103;
        if (r104 <= 255) goto L8;
        r103 = 1;
    L9:
        r100[r100.length - r102] = (byte) r104;
        r102 = r102 + 1;
        goto L4
    L8:
        r103 = 0;
        goto L9
    L10:
        int r105 = r101.length + 1;
    L12:
        if (r105 > r100.length) goto L18;
        int r106 = (r100[r100.length - r105] & UByte.MAX_VALUE) + r103;
        if (r106 <= 255) goto L16;
        r103 = 1;
    L17:
        r100[r100.length - r105] = (byte) r106;
        r105 = r105 + 1;
        goto L12
    L16:
        r103 = 0;
        goto L17
    }

    private void doHash(byte[] r100, byte[] r101) {
        this._digest.update(r100, 0, r100.length);
        this._digest.doFinal(r101, 0);
    }

    private byte[] getEntropy() {
        byte[] r100 = this._entropySource.getEntropy();
        if (r100.length < ((this._securityStrength + 7) / 8)) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private byte[] hash(byte[] r100) {
        byte[] r101 = new byte[this._digest.getDigestSize()];
        doHash(r100, r101);
        return r101;
    }

    private byte[] hashgen(byte[] r100, int r110) {
        int r111 = r110 / 8;
        int r101 = r111 / this._digest.getDigestSize();
        byte[] r102 = new byte[r100.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        byte[] r103 = new byte[r111];
        int r104 = this._digest.getDigestSize();
        byte[] r105 = new byte[r104];
        int r106 = 0;
    L3:
        if (r106 > r101) goto L8;
        doHash(r102, r105);
        int r107 = r106 * r104;
        int r108 = r111 - r107;
        if (r108 <= r104) goto L7;
        r108 = r104;
    L7:
        System.arraycopy(r105, 0, r103, r107, r108);
        addTo(r102, ONE);
        r106 = r106 + 1;
        goto L3
    L8:
        return r103;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] r110, byte[] r111, boolean r112) {
        int r100 = r110.length * 8;
        if (r100 > 262144) goto L16;
        if (this._reseedCounter <= RESEED_MAX) goto L8;
        return -1;
    L8:
        if (r112 == false) goto L11;
        reseed(r111);
        r111 = null;
    L11:
        if (r111 == null) goto L13;
        byte[] r101 = this._V;
        byte[] r102 = new byte[(r101.length + 1) + r111.length];
        r102[0] = 2;
        System.arraycopy(r101, 0, r102, 1, r101.length);
        System.arraycopy(r111, 0, r102, this._V.length + 1, r111.length);
        addTo(this._V, hash(r102));
    L13:
        byte[] r113 = hashgen(this._V, r100);
        byte[] r103 = this._V;
        byte[] r104 = new byte[r103.length + 1];
        System.arraycopy(r103, 0, r104, 1, r103.length);
        r104[0] = 3;
        addTo(this._V, hash(r104));
        addTo(this._V, this._C);
        long r105 = this._reseedCounter;
        addTo(this._V, new byte[]{(byte) (r105 >> 24), (byte) (r105 >> 16), (byte) (r105 >> 8), (byte) r105});
        this._reseedCounter++;
        System.arraycopy(r113, 0, r110, 0, r110.length);
        return r100;
    L16:
        throw new IllegalArgumentException("Number of bits per request limited to 262144");
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int getBlockSize() {
        return this._digest.getDigestSize() * 8;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] r100) {
        byte[] r101 = getEntropy();
        byte[] r102 = Arrays.concatenate(ONE, this._V, r101, r100);
        byte[] r103 = Utils.hash_df(this._digest, r102, this._seedLength);
        this._V = r103;
        byte[] r104 = new byte[r103.length + 1];
        r104[0] = 0;
        System.arraycopy(r103, 0, r104, 1, r103.length);
        this._C = Utils.hash_df(this._digest, r104, this._seedLength);
        this._reseedCounter = 1;
    }
}
