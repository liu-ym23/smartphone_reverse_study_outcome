package zg4;

import com.bytedance.crash.monitor.j;
import com.bytedance.crash.p;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f572085a = 8000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f572086b = 500;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f572087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static p f572088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f572089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f572090f;

    public static class a implements p {
        public a() {
        }
    }

    static {
        f572088d = new a();
        f572089e = true;
        f572090f = true;
    }

    public static boolean a() {
        if (f572087c == true) goto L5;
    L7:
        return false;
    L5:
        if (b() == false) goto L7;
        return true;
    }

    public static boolean b() {
        com.bytedance.crash.monitor.a r100 = j.f203315a;
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.b();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.contains("test_crash") == false) goto L12;
        return true;
    L12:
        return false;
    }
}
