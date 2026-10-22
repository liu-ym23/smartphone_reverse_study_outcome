package vt3;

import androidx.camera.video.AudioStats;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f557197a;

    public static boolean a(ut3.c r100, double r110, boolean r111) {
        if (r111 == false) goto L30;
        if (r100.f551643h.isEmpty() == true) goto L19;
        Iterator<String> r112 = st3.a.b().f543560a.iterator();
        double r101 = 0.0d;
    L8:
        if (r112.hasNext() == false) goto L21;
        String r102 = r112.next();
        if (r100.f551643h.containsKey(r102) == false) goto L8;
        double r103 = r100.f551643h.get(r102).doubleValue();
        if (r103 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        if (r101 > r103) goto L8;
        r101 = r103;
    L21:
        if (r101 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L25;
        r101 = r100.f551638c;
    L25:
        if (r110 > r101) goto L72;
        return false;
    L72:
        return true;
    L19:
        r101 = 0.0d;
        goto L21
    L30:
        if (r100.f551644i.isEmpty() == true) goto L44;
        Iterator<String> r113 = st3.a.b().f543560a.iterator();
        double r104 = 0.0d;
    L33:
        if (r113.hasNext() == false) goto L46;
        String r105 = r113.next();
        if (r100.f551644i.containsKey(r105) == false) goto L33;
        double r106 = r100.f551644i.get(r105).doubleValue();
        if (r106 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
        if (r104 > r106) goto L33;
        r104 = r106;
    L46:
        if (r104 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L50;
        r104 = r100.f551639d;
    L50:
        if (r110 > r104) goto L73;
        return false;
    L73:
        return true;
    L44:
        r104 = 0.0d;
        goto L46
    }
}
