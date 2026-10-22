package wu5;

import androidx.camera.video.AudioStats;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static String b(Long r100, String r101) {
        if (r100 != null) goto L4;
        return "0";
    L4:
        if (r100.longValue() <= 0) goto L32;
        DecimalFormat r102 = new DecimalFormat("#");
        byte r103 = -1;
        switch(r101.hashCode()) {
            case 66: goto L18;
            case 2391: goto L14;
            case 2453: goto L10;
            default: goto L21;
        };
    L21:
        switch(r103) {
            case 0: goto L29;
            case 1: goto L27;
            case 2: goto L25;
            default: goto L23;
        };
    L23:
        return r102.format(r100);
    L25:
        return r102.format(r100.longValue() / 1024);
    L27:
        return r102.format(r100.longValue() / 1048576);
    L29:
        return r102.format(r100.longValue() / 1073741824);
    L10:
        if (r101.equals("MB") == false) goto L21;
        r103 = 2;
        goto L21
    L14:
        if (r101.equals("KB") == false) goto L21;
        r103 = 1;
        goto L21
    L18:
        if (r101.equals("B") == false) goto L21;
        r103 = 0;
        goto L21
    L32:
        return "0";
    }

    public static String a(Double r100, String r101, DecimalFormat r102) {
        if (r100 != null) goto L4;
    L20:
        return r101;
    L4:
        if (r100.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L20;
        if (r100.doubleValue() >= 1024.0d) goto L11;
        return r102.format(r100) + "B";
    L11:
        if (r100.doubleValue() >= 1048576.0d) goto L15;
        return r102.format(r100.doubleValue() / 1024.0d) + "KB";
    L15:
        if (r100.doubleValue() >= 1.073741824E9d) goto L19;
        return r102.format(r100.doubleValue() / 1048576.0d) + "MB";
    L19:
        return r102.format(r100.doubleValue() / 1.073741824E9d) + "GB";
    }
}
