package com.google.common.base;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v.a f274735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f274736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f274737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f274738d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f274739a = null;

        static {
            int[] r100 = new int[TimeUnit.values().length];
            f274739a = r100;
            r100[TimeUnit.NANOSECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f274739a[TimeUnit.MICROSECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f274739a[TimeUnit.MILLISECONDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f274739a[TimeUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f274739a[TimeUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f274739a[TimeUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f274739a[TimeUnit.DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public final void b() {
        this.f274735a.getClass();
        long r100 = System.nanoTime();
        m.p(this.f274736b, "This stopwatch is already stopped.");
        this.f274736b = false;
        this.f274737c += r100 - this.f274738d;
    }

    public final String toString() {
        if (this.f274736b == false) goto L5;
        this.f274735a.getClass();
        long r100 = (System.nanoTime() - this.f274738d) + this.f274737c;
    L6:
        TimeUnit r101 = TimeUnit.DAYS;
        TimeUnit r102 = TimeUnit.NANOSECONDS;
        if (r101.convert(r100, r102) > 0) goto L25;
        r101 = TimeUnit.HOURS;
        if (r101.convert(r100, r102) > 0) goto L25;
        r101 = TimeUnit.MINUTES;
        if (r101.convert(r100, r102) > 0) goto L25;
        r101 = TimeUnit.SECONDS;
        if (r101.convert(r100, r102) > 0) goto L25;
        r101 = TimeUnit.MILLISECONDS;
        if (r101.convert(r100, r102) > 0) goto L25;
        r101 = TimeUnit.MICROSECONDS;
        if (r101.convert(r100, r102) > 0) goto L25;
        r101 = r102;
    L25:
        double r103 = r100 / r102.convert(1, r101);
        StringBuilder r104 = new StringBuilder();
        l.a r105 = l.f274724a;
        r104.append(String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(r103)}));
        r104.append(" ");
        switch(a.f274739a[r101.ordinal()]) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            case 7: goto L29;
            default: goto L28;
        };
    L29:
        String r106 = "d";
    L36:
        r104.append(r106);
        return r104.toString();
    L30:
        r106 = "h";
        goto L36
    L31:
        r106 = BitableFieldEditAnalytic.ProgressFieldEditScene.MIN;
        goto L36
    L32:
        r106 = "s";
        goto L36
    L33:
        r106 = "ms";
        goto L36
    L34:
        r106 = "μs";
        goto L36
    L35:
        r106 = "ns";
        goto L36
    L28:
        throw new AssertionError();
    L5:
        r100 = this.f274737c;
        goto L6
    }

    public r() {
        this.f274735a = v.f274741a;
    }

    public final long a(TimeUnit r100) {
        if (this.f274736b == false) goto L5;
        this.f274735a.getClass();
        long r101 = (System.nanoTime() - this.f274738d) + this.f274737c;
    L7:
        return r100.convert(r101, TimeUnit.NANOSECONDS);
    L5:
        r101 = this.f274737c;
        goto L7
    }
}
