package com.ss.videoarch.liveplayer.log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f459394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f459395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f459396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f459397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<C5512a> f459398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<C5512a> f459399f;

    /* JADX INFO: renamed from: com.ss.videoarch.liveplayer.log.a$a, reason: collision with other inner class name */
    public static class C5512a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f459400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f459401b;

        public boolean equals(Object r100) {
            if ((r100 instanceof C5512a) == false) goto L9;
            C5512a r101 = (C5512a) r100;
            if (this.f459400a != r101.f459400a) goto L9;
            if (this.f459401b != r101.f459401b) goto L9;
            return true;
        L9:
            return false;
        }

        public C5512a(long r100, long r101) {
            this.f459400a = r100;
            this.f459401b = r101;
        }
    }

    public void clear() {
        this.f459394a = -1;
        this.f459395b = -1;
        this.f459396c = -1;
        this.f459397d = -1;
        List<C5512a> r100 = this.f459398e;
        monitor-enter(r100);
        this.f459398e.clear();     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        List<C5512a> r101 = this.f459399f;
        monitor-enter(r101);
        this.f459399f.clear();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean isEnable() {
        if (this.f459394a > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f459395b <= 0) goto L7;
        return true;
    }

    public a() {
        this.f459394a = -1;
        this.f459395b = -1;
        this.f459396c = -1;
        this.f459397d = -1;
        this.f459398e = new ArrayList();
        this.f459399f = new ArrayList();
    }

    public int getCountThreshold() {
        return this.f459396c;
    }

    public int getPeriod() {
        return this.f459395b;
    }

    public long getTimeThreshold() {
        return this.f459397d;
    }

    public void config(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f459394a = r100.optInt("enable", -1);
        this.f459395b = r100.optInt("period", -1);
        this.f459396c = r100.optInt("count", -1);
        this.f459397d = r100.optLong("time", -1);
    }

    public int getRenderStallCount(boolean r100) {
        int r101 = this.f459395b;
        if (r101 > 0) goto L6;
        return 0;
    L6:
        if (r100 == false) goto L8;
        List<C5512a> r102 = this.f459398e;
    L10:
        return getStallCount(r102, r101);
    L8:
        r102 = this.f459399f;
        goto L10
    }

    public long getRenderStallTime(boolean r100) {
        int r101 = this.f459395b;
        if (r101 > 0) goto L6;
        return 0;
    L6:
        if (r100 == false) goto L8;
        List<C5512a> r102 = this.f459398e;
    L10:
        return getStallTime(r102, r101);
    L8:
        r102 = this.f459399f;
        goto L10
    }

    public a(ArrayList<C5512a> r100, ArrayList<C5512a> r101) {
        this.f459394a = -1;
        this.f459395b = -1;
        this.f459396c = -1;
        this.f459397d = -1;
        this.f459398e = r100;
        this.f459399f = r101;
    }

    private static int getStallCount(List<C5512a> r100, int r110) {
        long r101 = System.currentTimeMillis();
        Objects.requireNonNull(r100);
        List<C5512a> r102 = r100;
        monitor-enter(r102);
        Iterator<C5512a> r103 = r100.iterator();     // Catch: Throwable -> L12
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L10;
        if ((r101 - r103.next().f459401b) > r110) goto L6;
        r104 = r104 + 1;     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return r104;
    L12:
        th = move-exception;
        throw th;
    }

    private static long getStallTime(List<C5512a> r110, int r111) {
        long r100 = System.currentTimeMillis();
        Objects.requireNonNull(r110);
        List<C5512a> r101 = r110;
        monitor-enter(r101);
        Iterator<C5512a> r112 = r110.iterator();     // Catch: Throwable -> L12
        long r102 = 0;
    L6:
        if (r112.hasNext() == false) goto L10;
        C5512a r103 = r112.next();     // Catch: Throwable -> L12
        if ((r100 - r103.f459401b) > r111) goto L6;
        r102 = r102 + r103.f459400a;     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L12:
        th = move-exception;
        throw th;
    }

    private static void clearStallRecord(List<C5512a> r100, long r101, int r102) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        ListIterator<C5512a> r103 = r100.listIterator(r100.size());
    L7:
        if (r103.hasPrevious() == false) goto L11;
        if ((r101 - r103.previous().f459401b) <= r102) goto L14;
        r103.remove();
        goto L7
    L14:
        return;
    }

    public void addStallRecord(long r100, long r101, boolean r102) {
        if (this.f459395b > 0) goto L5;
        return;
    L5:
        if (r102 == false) goto L14;
        List<C5512a> r103 = this.f459398e;
        monitor-enter(r103);
        clearStallRecord(this.f459398e, r101, this.f459395b);     // Catch: Throwable -> L11
        this.f459398e.add(new C5512a(r100, r101));     // Catch: Throwable -> L11
        monitor-exit(r103);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        List<C5512a> r104 = this.f459399f;
        monitor-enter(r104);
        clearStallRecord(this.f459399f, r101, this.f459395b);     // Catch: Throwable -> L19
        this.f459399f.add(new C5512a(r100, r101));     // Catch: Throwable -> L19
        monitor-exit(r104);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
