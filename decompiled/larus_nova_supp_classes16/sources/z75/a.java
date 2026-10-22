package z75;

import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final C0333a a = null;

    /* JADX INFO: renamed from: z75.a$a, reason: collision with other inner class name */
    public static final class C0333a {
        public C0333a() {
        }

        public final VFSPath a(Biz r2, String r3, String r4, UserSession r5) {
            Intrinsics.checkNotNullParameter(r2, "biz");
            Intrinsics.checkNotNullParameter(r3, "relativePath");
            if (r4 != null) goto L9;
            by4.c r6 = c.a(r5);
            if (r6 == null) goto L8;
            VFSPath r7 = r6.a(r2, r3, true);
            if (r7 == null) goto L8;
            return r7;
        L8:
            int r8 = ay4.c.a;
            return ay4.c.a.c(r2, r3, false, 12);
        L9:
            int r9 = ay4.c.a;
            return ay4.c.a.d(r2, r3, r4);
        }

        public final VFSPath b(Biz r2, String r3, String r4, UserSession r5) {
            Intrinsics.checkNotNullParameter(r2, "biz");
            Intrinsics.checkNotNullParameter(r3, "relativePath");
            if (r4 != null) goto L9;
            by4.c r6 = c.a(r5);
            if (r6 == null) goto L8;
            VFSPath r7 = r6.b(r2, r3, true);
            if (r7 == null) goto L8;
            return r7;
        L8:
            int r8 = ay4.c.a;
            return ay4.c.a.f(r2, r3, false, false, 12);
        L9:
            int r9 = ay4.c.a;
            return ay4.c.a.g(r2, r3, r4);
        }
    }

    static {
        a = new C0333a();
    }
}
