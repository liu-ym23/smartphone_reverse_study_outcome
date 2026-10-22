package je2;

import com.bytedance.android.livesdk.ktvimpl.base.sei.h;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class f {

    public static final class a extends f {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends f {
        public final boolean a;

        public b(boolean r1) {
            this.a = r1;
        }
    }

    public static final class c extends f {
        public final String a;

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a = r2;
        }
    }

    public static final class d extends f {
        public final h a;

        public d(h r2) {
            Intrinsics.checkNotNullParameter(r2, "seiModel");
            this.a = r2;
        }
    }

    public static final class e extends f {
        public final Long a;
        public final String b;

        public e() {
            this(null, null);
        }

        public e(Long r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: je2.f$f, reason: collision with other inner class name */
    public static final class C0147f extends f {
        public final KtvMusic a;

        public C0147f(KtvMusic r1) {
            this.a = r1;
        }
    }

    public static final class g extends f {
        public final KtvMusic a;

        public g(KtvMusic r1) {
            this.a = r1;
        }
    }

    public f() {
    }
}
