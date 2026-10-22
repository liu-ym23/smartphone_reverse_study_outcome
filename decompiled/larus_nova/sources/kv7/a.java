package kv7;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f506288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f506289e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f506290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f506291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f506292c;

    public static a b() {
        a r100 = new a(System.nanoTime());
        f506289e = r100;
        return r100;
    }

    public a(long r100) {
        this.f506290a = r100;
        f506288d++;
    }

    public final void a(int r100) {
        long r101 = System.nanoTime();
        int r102 = (r100 * 2) + 2;
        int r103 = this.f506292c;
        if (r102 <= r103) goto L5;
        this.f506292c = r103 + 1;
    L5:
        long r104 = this.f506291b;
        if (r104 != 0) goto L8;
        long r105 = r101 - this.f506290a;
        TimeUnit.NANOSECONDS.toMillis(r105);
    L9:
        this.f506291b = r101;
        return;
    L8:
        TimeUnit r106 = TimeUnit.NANOSECONDS;
        r106.toMillis(r101 - r104);
        r106.toMillis(r101 - this.f506290a);
        goto L9
    }
}
