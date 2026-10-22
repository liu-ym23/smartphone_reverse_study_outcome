package com.ss.android.vesdk.model;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class b {
    long duration;
    double speed;

    public static int calculateRealTime(int r100, double r101) {
        return (int) ((((double) r100) * 1.0d) / r101);
    }

    public static long calculateRealTime(long r100, double r101) {
        return (long) ((r100 * 1.0d) / r101);
    }

    public long getDuration() {
        return this.duration;
    }

    public double getSpeed() {
        return this.speed;
    }

    public static int calculateRealTime(List<? extends b> r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L11:
        return r101;
    L5:
        if (r100.size() <= 0) goto L11;
        Iterator<? extends b> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        b r103 = r102.next();
        r101 = (int) (((long) r101) + calculateRealTime(r103.duration, r103.speed));
        goto L9
    }

    public void setDuration(long r100) {
        this.duration = r100;
    }

    public void setSpeed(float r100) {
        this.speed = r100;
    }

    public b(long r100, double r101) {
        this.duration = r100;
        this.speed = r101;
    }
}
