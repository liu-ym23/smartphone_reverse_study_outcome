package com.ttnet.org.chromium.net;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes41.dex */
public class NetworkTrafficAnnotationTag {
    public static final NetworkTrafficAnnotationTag MISSING_TRAFFIC_ANNOTATION = null;
    public static final NetworkTrafficAnnotationTag NO_TRAFFIC_ANNOTATION_YET = null;
    public static final NetworkTrafficAnnotationTag TRAFFIC_ANNOTATION_FOR_TESTS = null;
    private final int mHashCode;

    static {
        NO_TRAFFIC_ANNOTATION_YET = createComplete("undefined", "Nothing here yet.");
        MISSING_TRAFFIC_ANNOTATION = createComplete("undefined", "Function called without traffic annotation.");
        TRAFFIC_ANNOTATION_FOR_TESTS = createComplete(EffectConstants.CHANNEL_TEST, "Traffic annotation for unit, browser and other tests");
    }

    public int getHashCode() {
        return this.mHashCode;
    }

    private NetworkTrafficAnnotationTag(String r100) {
        this.mHashCode = iterativeHash(r100);
    }

    public static int iterativeHash(String r100) {
        byte[] r101 = r100.getBytes(StandardCharsets.UTF_8);
        int r102 = r101.length;
        long r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L6;
        r103 = ((r103 * 31) + ((long) r101[r104])) % 138003713;
        r104 = r104 + 1;
        goto L3
    L6:
        return (int) r103;
    }

    public static NetworkTrafficAnnotationTag createComplete(String r100, String r101) {
        return new NetworkTrafficAnnotationTag(r100);
    }
}
