package a95;

import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import jdb.g;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int d = 0;
    public final vo5.a a;
    public final UserSession b;
    public final g c;

    /* JADX INFO: renamed from: a95.a$a, reason: collision with other inner class name */
    public static final class C0003a implements vo5.a {
        public C0003a() {
        }

        public final UserSession b() {
            return ((com.ss.android.lark.passportc.convention.a) k.a(LarkContext.getApplication(), com.ss.android.lark.passportc.convention.a.class)).b();
        }

        public final <T> T a(Class<T> r4) {
            Intrinsics.checkNotNullParameter(r4, "userScopeApi");
            UserSession r0 = b();
            return (T) k.b(((v) k.a(LarkContext.getApplication(), v.class)).c(r0), r4);
        }
    }

    public static final class b {
        @JvmStatic
        public static a a(a r2) {
            if (r2 != null) goto L4;
            tt5.a.d("DriveUserComponentAbility", "provideUserComponent empty ability");
        L4:
            if (r2 == null) goto L6;
            return r2;
        L6:
            return new a();
        }
    }

    static {
    }

    public a() {
        this(new C0003a());
    }

    public a(vo5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentDelegate");
        this.a = r2;
        this.b = r2.b();
        this.c = ((dn4.a) a(dn4.a.class)).a();
    }

    public final <T> T a(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "userScopeApi");
        return (T) this.a.a(r2);
    }
}
