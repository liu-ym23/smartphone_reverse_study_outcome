package com.ss.android.lark.monitor;

import androidx.core.util.Pair;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f432337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f432338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f432339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f432340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f432341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f432342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f432343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f432344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f432345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final double f432346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<Pair<String, Double>> f432347k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f432348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f432349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f432350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f432351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f432352e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public double f432353f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double f432354g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f432355h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public double f432356i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f432357j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final List<Pair<String, Double>> f432358k;

        public a() {
            this.f432358k = new CopyOnWriteArrayList();
        }
    }

    public final String toString() {
        return "MetricsPayload{startTime=" + this.f432344h + "endTime=" + this.f432345i + "duration=" + this.f432346j + "cpuTime=" + this.f432342f + "mobileKBTx=" + this.f432340d + ", mobileKBRx=" + this.f432341e + ", wifiKBTx=" + this.f432338b + ", wifiKBRx=" + this.f432339c + '}';
    }

    public b(a r100) {
        this.f432337a = r100.f432348a;
        this.f432338b = r100.f432349b;
        this.f432339c = r100.f432350c;
        this.f432340d = r100.f432351d;
        this.f432341e = r100.f432352e;
        this.f432343g = r100.f432355h;
        this.f432342f = r100.f432353f + r100.f432354g;
        double r101 = r100.f432356i;
        this.f432346j = r101;
        long r102 = r100.f432357j;
        this.f432344h = r102 - ((long) (r101 * 1000.0d));
        this.f432345i = r102;
        this.f432347k = r100.f432358k;
    }
}
