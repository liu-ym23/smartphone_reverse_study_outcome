package wj2;

import kotlin.jvm.internal.Intrinsics;
import sl.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class g {

    public static final class a extends g {
        public final String a;
        public final String b;

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "productId");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends g {
        public final k a;

        public b(k r1) {
            this.a = r1;
        }
    }

    public static final class c extends g {
        public final boolean a;
        public final boolean b;

        public c(boolean r2) {
            this.a = true;
            this.b = r2;
        }
    }

    public g() {
    }
}
