package org.bouncycastle.crypto.signers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class ISOTrailers {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA224 = 14540;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_SHA512_224 = 14796;
    public static final int TRAILER_SHA512_256 = 15052;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private static final Map<String, Integer> trailerMap = null;

    static {
        HashMap r100 = new HashMap();
        r100.put("RIPEMD128", Integers.valueOf(13004));
        r100.put("RIPEMD160", Integers.valueOf(12748));
        r100.put("SHA-1", Integers.valueOf(13260));
        r100.put(McElieceCCA2KeyGenParameterSpec.SHA224, Integers.valueOf(14540));
        r100.put("SHA-256", Integers.valueOf(13516));
        r100.put(McElieceCCA2KeyGenParameterSpec.SHA384, Integers.valueOf(14028));
        r100.put("SHA-512", Integers.valueOf(13772));
        r100.put("SHA-512/224", Integers.valueOf(TRAILER_SHA512_224));
        r100.put(SPHINCSKeyParameters.SHA512_256, Integers.valueOf(TRAILER_SHA512_256));
        r100.put("Whirlpool", Integers.valueOf(14284));
        trailerMap = Collections.unmodifiableMap(r100);
    }

    public ISOTrailers() {
    }

    public static Integer getTrailer(Digest r100) {
        return trailerMap.get(r100.getAlgorithmName());
    }

    public static boolean noTrailerAvailable(Digest r100) {
        return !trailerMap.containsKey(r100.getAlgorithmName());
    }
}
