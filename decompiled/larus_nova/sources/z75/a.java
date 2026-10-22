package z75;

import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C8426a f570666a = null;

    /* JADX INFO: renamed from: z75.a$a, reason: collision with other inner class name */
    public static final class C8426a {
        public C8426a() {
        }

        public final VFSPath a(Biz r100, String r101, String r102, UserSession r103) {
            Intrinsics.checkNotNullParameter(r100, "biz");
            Intrinsics.checkNotNullParameter(r101, "relativePath");
            if (r102 != null) goto L9;
            by4.c r104 = c.a(r103);
            if (r104 == null) goto L8;
            VFSPath r105 = r104.a(r100, r101, true);
            if (r105 == null) goto L8;
            return r105;
        L8:
            int r106 = ay4.c.f16749a;
            return ay4.c.a.c(r100, r101, false, 12);
        L9:
            int r107 = ay4.c.f16749a;
            return ay4.c.a.d(r100, r101, r102);
        }

        public final VFSPath b(Biz r100, String r101, String r102, UserSession r103) {
            Intrinsics.checkNotNullParameter(r100, "biz");
            Intrinsics.checkNotNullParameter(r101, "relativePath");
            if (r102 != null) goto L9;
            by4.c r104 = c.a(r103);
            if (r104 == null) goto L8;
            VFSPath r105 = r104.b(r100, r101, true);
            if (r105 == null) goto L8;
            return r105;
        L8:
            int r106 = ay4.c.f16749a;
            return ay4.c.a.f(r100, r101, false, false, 12);
        L9:
            int r107 = ay4.c.f16749a;
            return ay4.c.a.g(r100, r101, r102);
        }
    }

    static {
        f570666a = new C8426a();
    }
}
