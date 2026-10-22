package tsc;

import com.ss.ttvideoengine.superresolution.SRStrategy;

/* JADX INFO: loaded from: classes5.dex */
public final class g {
    public g() {
    }

    public static String a(m r100) {
        String r101 = r100.f547459a;
        if (SRStrategy.MEDIAINFO_KEY_BITRATE.equals(r101) == false) goto L6;
        return "\n";
    L6:
        if ("img".equals(r101) == false) goto L13;
        String r102 = r100.b().get("alt");
        if (r102 != null) goto L10;
    L11:
        return "￼";
    L10:
        if (r102.length() == 0) goto L11;
        return r102;
    L13:
        if ("iframe".equals(r101) == false) goto L15;
        return " ";
    L15:
        return null;
    }
}
