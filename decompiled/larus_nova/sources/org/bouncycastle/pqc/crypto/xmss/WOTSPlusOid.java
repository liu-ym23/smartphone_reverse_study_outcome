package org.bouncycastle.pqc.crypto.xmss;

import com.ss.ttm.player.MediaPlayer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
final class WOTSPlusOid implements XMSSOid {
    private static final Map<String, WOTSPlusOid> oidLookupTable = null;
    private final int oid;
    private final String stringRepresentation;

    static {
        HashMap r100 = new HashMap();
        r100.put(createKey("SHA-256", 32, 16, 67), new WOTSPlusOid(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, "WOTSP_SHA2-256_W16"));
        r100.put(createKey("SHA-512", 64, 16, 131), new WOTSPlusOid(33554434, "WOTSP_SHA2-512_W16"));
        r100.put(createKey("SHAKE128", 32, 16, 67), new WOTSPlusOid(50331651, "WOTSP_SHAKE128_W16"));
        r100.put(createKey("SHAKE256", 64, 16, 131), new WOTSPlusOid(67108868, "WOTSP_SHAKE256_W16"));
        oidLookupTable = Collections.unmodifiableMap(r100);
    }

    private WOTSPlusOid(int r100, String r101) {
        this.oid = r100;
        this.stringRepresentation = r101;
    }

    private static String createKey(String r100, int r101, int r102, int r103) {
        if (r100 == null) goto L6;
        return r100 + "-" + r101 + "-" + r102 + "-" + r103;
    L6:
        throw new NullPointerException("algorithmName == null");
    }

    public static WOTSPlusOid lookup(String r100, int r101, int r102, int r103) {
        if (r100 == null) goto L6;
        return oidLookupTable.get(createKey(r100, r101, r102, r103));
    L6:
        throw new NullPointerException("algorithmName == null");
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    public int getOid() {
        return this.oid;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    public String toString() {
        return this.stringRepresentation;
    }
}
