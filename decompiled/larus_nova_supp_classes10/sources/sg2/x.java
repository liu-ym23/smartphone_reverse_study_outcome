package sg2;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface x {
    public static final a a = null;

    public static final class a {
        public static final C0172a a = null;
        public static final /* synthetic */ a b = null;

        /* JADX INFO: renamed from: sg2.x$a$a, reason: collision with other inner class name */
        public static final class C0172a implements x {
            public C0172a() {
            }

            @Override // sg2.x
            public final void a() {
            }

            @Override // sg2.x
            public final void b(Context r1, Function2 r2) {
                Intrinsics.checkNotNullParameter(r2, "callback");
                Boolean r3 = Boolean.FALSE;
                r2.invoke(r3, r3);
            }
        }

        public a() {
        }

        static {
            b = new a();
            a = new C0172a();
        }
    }

    static {
        a = a.b;
    }

    void a();

    void b(Context r1, Function2 r2);
}
