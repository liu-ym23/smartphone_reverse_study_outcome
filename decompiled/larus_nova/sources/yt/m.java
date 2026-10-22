package yt;

import androidx.camera.video.AudioStats;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes44.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569019a = 0;

    static {
    }

    public static String a(Long r110, boolean r111) {
        String r100 = "";
        if (r110 == null) goto L40;
        long r101 = r110.longValue();
        long r102 = 10000;
        if (r101 >= r102) goto L11;
        StringBuilder r112 = new StringBuilder();
        r112.append(r101);
        if (r111 == false) goto L9;
        r100 = " ";
    L9:
        r112.append(r100);
        return r112.toString();
    L11:
        long r103 = 99999999;
        if (r102 <= r101) goto L15;
    L27:
        long r104 = 100000000;
        if (r101 < r104) goto L40;
        String r105 = "亿";
        if ((r101 / r104) < 1000) goto L35;
        int r113 = (int) Math.ceil(r101 / ((double) 100000000));
        StringBuilder r106 = new StringBuilder();
        r106.append(r113);
        if (r111 == false) goto L34;
        r105 = " 亿";
    L34:
        r106.append(r105);
        return r106.toString();
    L35:
        DecimalFormat r107 = new DecimalFormat();
        r107.setMaximumFractionDigits(1);
        StringBuilder r108 = new StringBuilder();
        r108.append(r107.format(r101 / ((double) 100000000)));
        if (r111 == false) goto L38;
        r100 = " ";
    L38:
        r108.append(r100);
        r108.append("亿");
        return r108.toString();
    L15:
        if (r103 < r101) goto L27;
        String r109 = "万";
        if ((r101 / r102) < 1000) goto L22;
        int r114 = (int) Math.ceil(r101 / ((double) 10000));
        StringBuilder r115 = new StringBuilder();
        r115.append(r114);
        if (r111 == false) goto L21;
        r109 = " 万";
    L21:
        r115.append(r109);
        return r115.toString();
    L22:
        DecimalFormat r116 = new DecimalFormat();
        r116.setMaximumFractionDigits(1);
        StringBuilder r117 = new StringBuilder();
        r117.append(r116.format(r101 / ((double) 10000)));
        if (r111 == false) goto L25;
        r100 = " ";
    L25:
        r117.append(r100);
        r117.append("万");
        return r117.toString();
    L40:
        return "";
    }

    public static double b(double r100, int r101) {
        return new BigDecimal(r100).setScale(r101, 4).doubleValue();
    L5:
        th = move-exception;
        yr.c.b("NumberFormat", "formatDecimals exception " + th.getMessage());
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
