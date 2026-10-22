package i8;

import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.util.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sz2.e f488540a = null;

    static {
        f488540a = sz2.e.f543917a;
    }

    public static String e() {
        f488540a.getClass();
        String r100 = n.a();
        nz2.b.f("ContainerStandardApi", "generateIDForContainer [monitorId:" + r100 + ']');
        return r100;
    }

    public static void a(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "key");
        f488540a.getClass();
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "key");
        nz2.b.f("ContainerStandardApi", "addContainerContext [monitorId:" + r100 + "][field:" + r101 + "][value:" + r102 + ']');
        sz2.a r103 = sz2.e.f543918b;
        Integer r104 = Integer.valueOf(r102);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "field");
        Intrinsics.checkNotNullParameter(r104, "value");
        l.p(sz2.a.b(r100), r101, r104);
    }

    public static void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        f488540a.getClass();
        sz2.e.a(r100, r101, r102);
    }

    public static void c(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "field");
        f488540a.getClass();
        sz2.e.e(r100, r101, r102);
    }

    public static void d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "field");
        Intrinsics.checkNotNullParameter(r102, "value");
        f488540a.getClass();
        sz2.e.f(r100, r101, r102);
    }
}
