package gm2;

import androidx.camera.video.AudioStats;
import java.text.SimpleDateFormat;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f481658a = null;

    static {
        f481658a = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static String a(int r100, String r101, String r102, String r103, String r104) {
        StringBuilder r105 = new StringBuilder(r101);
        if (r100 != 1) goto L5;
        r105.append(r103);
        r105.append(r102);
    L19:
        return r105.toString();
    L5:
        if (r100 != 2) goto L7;
        r105.append(r102);
        goto L19
    L7:
        if (r100 != 3) goto L9;
        r105.append(r103);
        r105.append(r104);
        goto L19
    L9:
        if (r100 != 4) goto L11;
        r105.append(r104);
        goto L19
    L11:
        if (r100 != 5) goto L19;
        r105.append(r103);
        goto L19
    }

    public static void b(Map r100, String r101, String r110, String r111, String r112) {
        String r102 = a(1, r101, r110, r111, r112);
        Object r103 = r100.get(r102);
        Object r104 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (r103 != null) goto L5;
        r103 = r104;
    L5:
        double r105 = 1;
        r100.put(r102, Double.valueOf(((Number) r103).doubleValue() + r105));
        String r106 = a(2, r101, r110, r111, r112);
        Object r107 = r100.get(r106);
        if (r107 != null) goto L8;
        r107 = r104;
    L8:
        r100.put(r106, Double.valueOf(((Number) r107).doubleValue() + r105));
        String r108 = a(3, r101, r110, r111, r112);
        Object r109 = r100.get(r108);
        if (r109 != null) goto L11;
        r109 = r104;
    L11:
        r100.put(r108, Double.valueOf(((Number) r109).doubleValue() + r105));
        String r113 = a(4, r101, r110, r111, r112);
        Object r114 = r100.get(r113);
        if (r114 != null) goto L14;
        r114 = r104;
    L14:
        r100.put(r113, Double.valueOf(((Number) r114).doubleValue() + r105));
        String r115 = a(5, r101, r110, r111, r112);
        Object r116 = r100.get(r115);
        if (r116 != null) goto L17;
        r116 = r104;
    L17:
        r100.put(r115, Double.valueOf(((Number) r116).doubleValue() + r105));
        String r117 = a(6, r101, r110, r111, r112);
        Object r118 = r100.get(r117);
        if (r118 == null) goto L21;
        r104 = r118;
    L21:
        r100.put(r117, Double.valueOf(((Number) r104).doubleValue() + r105));
    }
}
