package m74;

import com.bytedance.bdinstall.p0;
import com.bytedance.bdinstall.t;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static u74.b f512332a;

    public static void a(String r100) {
        u74.b r101 = f512332a;
        if (r101 == null) goto L6;
        ((p0.a) r101).getClass();
        t.a("[dt] " + r100);
        return;
    }

    public static void b(String r100) {
        u74.b r101 = f512332a;
        if (r101 == null) goto L6;
        ((p0.a) r101).getClass();
        t.c("[dt] " + r100, null);
        return;
    }

    public static void c(String r100, Throwable r101) {
        if (f512332a == null) goto L6;
        t.c("[dt] ".concat(r100), r101);
        return;
    }
}
