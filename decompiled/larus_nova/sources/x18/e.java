package x18;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f562146a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f562147a = null;

        static {
            f562147a = new e();
        }
    }

    public e() {
        b.a r100 = new b.a();
        TimeUnit r101 = TimeUnit.MILLISECONDS;
        r100.f562137d = 15000;
        r100.f562138e = r101;
        r100.f562139f = 10000;
        r100.f562140g = r101;
        TimeUnit r102 = TimeUnit.MICROSECONDS;
        r100.f562141h = 30000;
        r100.f562142i = r102;
        this.f562146a = new d(r100);
    }
}
