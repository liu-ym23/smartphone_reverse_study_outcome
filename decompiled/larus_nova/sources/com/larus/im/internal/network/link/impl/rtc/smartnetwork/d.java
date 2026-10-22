package com.larus.im.internal.network.link.impl.rtc.smartnetwork;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<a> f349389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<a> f349390b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<a> f349391c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f349392d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f349393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f349394b;

        public a(long r100, int r101) {
            this.f349393a = r100;
            this.f349394b = r101;
        }
    }

    static {
        f349389a = new ArrayList();
        f349390b = new ArrayList();
        f349391c = new ArrayList();
    }

    public static int b(ArrayList r110) {
        if (r110.size() == 1) goto L5;
        int r100 = r110.size();
        Iterator r101 = r110.iterator();
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r103 = 0.0d;
        double r104 = 0.0d;
        double r105 = 0.0d;
    L8:
        if (r101.hasNext() == false) goto L10;
        a r111 = (a) r101.next();
        long r112 = r111.f349393a;
        r103 = r103 + r112;
        int r113 = r111.f349394b;
        r104 = r104 + ((double) r113);
        r102 = r102 + (((long) r113) * r112);
        r105 = r105 + (r112 * r112);
        goto L8
    L10:
        double r106 = r100;
        double r107 = ((r102 * r106) - (r103 * r104)) / ((r105 * r106) - (r103 * r103));
        return (int) ((r107 * (((a) CollectionsKt.last(r110)).f349393a + ((long) 3))) + ((r104 - (r103 * r107)) / r106));
    L5:
        return ((a) ListProtector.get(r110, 0)).f349394b;
    }

    public static String c(ArrayList r100) {
        Iterator r101 = r100.iterator();
        String r102 = " ";
    L4:
        if (r101.hasNext() == false) goto L7;
        a r103 = (a) r101.next();
        r102 = r102 + '(' + r103.f349393a + ", " + r103.f349394b + "), ";
        goto L4
    L7:
        return r102 + ' ';
    }

    public static void a(ArrayList r100, int r101) {
        if (r100.size() < 5) goto L5;
        ListProtector.remove(r100, 0);
    L5:
        r100.add(new a(f349392d, r101));
    }
}
