package com.bytedance.lynx.service.security.decrypt;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b!\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/bytedance/lynx/service/security/decrypt/DecryptErrorCode;", "", "", "code", "I", "getCode", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ok", "NotEncryptedArtifact", "InvalidArguments", "DecryptConfigNotSet", "NoncePrkFailed", "AeadInitFailed", "InvalidMagic", "UnsupportedAlgorithm", "InvalidKeyId", "InvalidWrappedDekLen", "InvalidWrappedDek", "InvalidHeaderCipherLen", "HeaderHashFailed", "InvalidHeaderCipher", "InvalidHeaderTag", "NonceDeriveFailed", "HeaderDecryptFailed", "InvalidHeaderPlaintext", "InvalidHeaderFields", "InvalidChunkSize", "InvalidChunkCipher", "InvalidChunkTag", "ChunkDecryptFailed", "InvalidChunkPlaintext", "TrailingBytes", "DecompressFailed", "LynxDecrypt_noasanRelease"}, k = 1, mv = {1, 6, 0})
public final enum DecryptErrorCode extends Enum<DecryptErrorCode> {
    public static final DecryptErrorCode AeadInitFailed = null;
    public static final DecryptErrorCode ChunkDecryptFailed = null;
    public static final a Companion = null;
    public static final DecryptErrorCode DecompressFailed = null;
    public static final DecryptErrorCode DecryptConfigNotSet = null;
    public static final DecryptErrorCode HeaderDecryptFailed = null;
    public static final DecryptErrorCode HeaderHashFailed = null;
    public static final DecryptErrorCode InvalidArguments = null;
    public static final DecryptErrorCode InvalidChunkCipher = null;
    public static final DecryptErrorCode InvalidChunkPlaintext = null;
    public static final DecryptErrorCode InvalidChunkSize = null;
    public static final DecryptErrorCode InvalidChunkTag = null;
    public static final DecryptErrorCode InvalidHeaderCipher = null;
    public static final DecryptErrorCode InvalidHeaderCipherLen = null;
    public static final DecryptErrorCode InvalidHeaderFields = null;
    public static final DecryptErrorCode InvalidHeaderPlaintext = null;
    public static final DecryptErrorCode InvalidHeaderTag = null;
    public static final DecryptErrorCode InvalidKeyId = null;
    public static final DecryptErrorCode InvalidMagic = null;
    public static final DecryptErrorCode InvalidWrappedDek = null;
    public static final DecryptErrorCode InvalidWrappedDekLen = null;
    public static final DecryptErrorCode NonceDeriveFailed = null;
    public static final DecryptErrorCode NoncePrkFailed = null;
    public static final DecryptErrorCode NotEncryptedArtifact = null;
    public static final DecryptErrorCode Ok = null;
    public static final DecryptErrorCode TrailingBytes = null;
    public static final DecryptErrorCode UnsupportedAlgorithm = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, DecryptErrorCode> f264934a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ DecryptErrorCode[] f264935b = null;
    private final int code;

    public static final class a {
        public a() {
        }
    }

    public static DecryptErrorCode valueOf(String r100) {
        return (DecryptErrorCode) r27.a.a(DecryptErrorCode.class, r100);
    }

    public static DecryptErrorCode[] values() {
        return (DecryptErrorCode[]) f264935b.clone();
    }

    static {
        DecryptErrorCode r100 = new DecryptErrorCode("Ok", 0, 0);
        Ok = r100;
        DecryptErrorCode r101 = new DecryptErrorCode("NotEncryptedArtifact", 1, 1);
        NotEncryptedArtifact = r101;
        DecryptErrorCode r102 = new DecryptErrorCode("InvalidArguments", 2, 2);
        InvalidArguments = r102;
        DecryptErrorCode r103 = new DecryptErrorCode("DecryptConfigNotSet", 3, 3);
        DecryptConfigNotSet = r103;
        DecryptErrorCode r104 = new DecryptErrorCode("NoncePrkFailed", 4, 4);
        NoncePrkFailed = r104;
        DecryptErrorCode r105 = new DecryptErrorCode("AeadInitFailed", 5, 5);
        AeadInitFailed = r105;
        DecryptErrorCode r110 = new DecryptErrorCode("InvalidMagic", 6, 6);
        InvalidMagic = r110;
        DecryptErrorCode r111 = new DecryptErrorCode("UnsupportedAlgorithm", 7, 7);
        UnsupportedAlgorithm = r111;
        DecryptErrorCode r112 = new DecryptErrorCode("InvalidKeyId", 8, 8);
        InvalidKeyId = r112;
        DecryptErrorCode r113 = new DecryptErrorCode("InvalidWrappedDekLen", 9, 9);
        InvalidWrappedDekLen = r113;
        DecryptErrorCode r114 = new DecryptErrorCode("InvalidWrappedDek", 10, 10);
        InvalidWrappedDek = r114;
        DecryptErrorCode r115 = new DecryptErrorCode("InvalidHeaderCipherLen", 11, 11);
        InvalidHeaderCipherLen = r115;
        DecryptErrorCode r106 = new DecryptErrorCode("HeaderHashFailed", 12, 12);
        HeaderHashFailed = r106;
        DecryptErrorCode r107 = new DecryptErrorCode("InvalidHeaderCipher", 13, 13);
        InvalidHeaderCipher = r107;
        DecryptErrorCode r108 = new DecryptErrorCode("InvalidHeaderTag", 14, 14);
        InvalidHeaderTag = r108;
        DecryptErrorCode r109 = new DecryptErrorCode("NonceDeriveFailed", 15, 15);
        NonceDeriveFailed = r109;
        DecryptErrorCode r116 = new DecryptErrorCode("HeaderDecryptFailed", 16, 16);
        HeaderDecryptFailed = r116;
        DecryptErrorCode r117 = new DecryptErrorCode("InvalidHeaderPlaintext", 17, 17);
        InvalidHeaderPlaintext = r117;
        DecryptErrorCode r118 = new DecryptErrorCode("InvalidHeaderFields", 18, 18);
        InvalidHeaderFields = r118;
        DecryptErrorCode r119 = new DecryptErrorCode("InvalidChunkSize", 19, 19);
        InvalidChunkSize = r119;
        DecryptErrorCode r120 = new DecryptErrorCode("InvalidChunkCipher", 20, 20);
        InvalidChunkCipher = r120;
        DecryptErrorCode r121 = new DecryptErrorCode("InvalidChunkTag", 21, 21);
        InvalidChunkTag = r121;
        DecryptErrorCode r122 = new DecryptErrorCode("ChunkDecryptFailed", 22, 22);
        ChunkDecryptFailed = r122;
        DecryptErrorCode r123 = new DecryptErrorCode("InvalidChunkPlaintext", 23, 23);
        InvalidChunkPlaintext = r123;
        DecryptErrorCode r124 = new DecryptErrorCode("TrailingBytes", 24, 24);
        TrailingBytes = r124;
        DecryptErrorCode r125 = new DecryptErrorCode("DecompressFailed", 25, 25);
        DecompressFailed = r125;
        f264935b = new DecryptErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
        Companion = new a();
        DecryptErrorCode[] r126 = values();
        LinkedHashMap r127 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r126.length), 16));
        int r128 = r126.length;
        int r129 = 0;
    L3:
        if (r129 >= r128) goto L5;
        DecryptErrorCode r130 = r126[r129];
        r127.put(Integer.valueOf(r130.code), r130);
        r129 = r129 + 1;
        goto L3
    L5:
        f264934a = r127;
    }

    public static final /* synthetic */ Map access$getCODE_MAP$cp() {
        return f264934a;
    }

    public final int getCode() {
        return this.code;
    }

    @JvmStatic
    public static final DecryptErrorCode fromCode(int r100) {
        Companion.getClass();
        DecryptErrorCode r101 = (DecryptErrorCode) access$getCODE_MAP$cp().get(Integer.valueOf(r100));
        if (r101 == null) goto L5;
        return r101;
    L5:
        return InvalidArguments;
    }

    public DecryptErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
