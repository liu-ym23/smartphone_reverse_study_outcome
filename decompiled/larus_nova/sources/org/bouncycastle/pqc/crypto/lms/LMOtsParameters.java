package org.bouncycastle.pqc.crypto.lms;

import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public class LMOtsParameters {
    public static final int reserved = 0;
    public static final LMOtsParameters sha256_n32_w1 = null;
    public static final LMOtsParameters sha256_n32_w2 = null;
    public static final LMOtsParameters sha256_n32_w4 = null;
    public static final LMOtsParameters sha256_n32_w8 = null;
    private static final Map<Object, LMOtsParameters> suppliers = null;
    private final ASN1ObjectIdentifier digestOID;

    /* JADX INFO: renamed from: ls, reason: collision with root package name */
    private final int f525526ls;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f525527n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f525528p;
    private final int sigLen;
    private final int type;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f525529w;

    static {
        ASN1ObjectIdentifier r110 = NISTObjectIdentifiers.id_sha256;
        sha256_n32_w1 = new LMOtsParameters(1, 32, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 7, 8516, r110);
        sha256_n32_w2 = new LMOtsParameters(2, 32, 2, 133, 6, 4292, r110);
        sha256_n32_w4 = new LMOtsParameters(3, 32, 4, 67, 4, 2180, r110);
        sha256_n32_w8 = new LMOtsParameters(4, 32, 8, 34, 0, 1124, r110);
        suppliers = new AnonymousClass1();
    }

    public LMOtsParameters(int r100, int r101, int r102, int r103, int r104, int r105, ASN1ObjectIdentifier r106) {
        this.type = r100;
        this.f525527n = r101;
        this.f525529w = r102;
        this.f525528p = r103;
        this.f525526ls = r104;
        this.sigLen = r105;
        this.digestOID = r106;
    }

    public static /* synthetic */ int access$000(LMOtsParameters r100) {
        return r100.type;
    }

    public static LMOtsParameters getParametersForType(int r100) {
        return suppliers.get(Integer.valueOf(r100));
    }

    public ASN1ObjectIdentifier getDigestOID() {
        return this.digestOID;
    }

    public int getLs() {
        return this.f525526ls;
    }

    public int getN() {
        return this.f525527n;
    }

    public int getP() {
        return this.f525528p;
    }

    public int getSigLen() {
        return this.sigLen;
    }

    public int getType() {
        return this.type;
    }

    public int getW() {
        return this.f525529w;
    }
}
