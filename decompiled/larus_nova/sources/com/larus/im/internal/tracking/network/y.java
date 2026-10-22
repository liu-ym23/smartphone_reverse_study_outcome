package com.larus.im.internal.tracking.network;

import androidx.camera.video.AudioStats;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z f350447c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f350448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f350449b;

    public static final class a {
    }

    static {
        f350447c = new z();
    }

    public static boolean a(double r100) {
        if (Double.isInfinite(r100) == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return false;
    L10:
        if (AudioStats.AUDIO_AMPLITUDE_NONE <= r100) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L19;
        return true;
    L19:
        return false;
    L12:
        if (r100 > 1.0d) goto L14;
        r102 = true;
        goto L15
    L5:
        if (Double.isNaN(r100) == true) goto L7;
        r101 = true;
        goto L8
    }

    public y(z r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "random");
        this.f350448a = r101;
        if (a(r100.f350450a) == false) goto L19;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, Double>> r103 = r100.f350451b.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L20;
        Map.Entry<String, Double> r104 = r103.next();
        String r105 = r104.getKey();
        double r106 = r104.getValue().doubleValue();
        if (a(r106) == false) goto L19;
        if (r105.length() != 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == true) goto L19;
        if (r102.put(r105, Double.valueOf(r106)) == null) goto L7;
    L14:
        r107 = false;
        goto L15
    L20:
        z r108 = new z(r100.f350450a, MapsKt.toMap(r102));
    L21:
        if (r108 != null) goto L23;
        r108 = f350447c;
    L23:
        this.f350449b = r108;
        return;
    L19:
        r108 = null;
        goto L21
    }
}
