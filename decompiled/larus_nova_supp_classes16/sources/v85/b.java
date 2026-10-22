package v85;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends v85.a {

    public static final class a extends v85.a.C0311a {
        public final int s;
        public boolean t;

        public a() {
            this.s = 1;
        }

        @Override // v85.a.C0311a
        public final int a() {
            return this.s;
        }

        @Override // v85.a.C0311a
        public final boolean b() {
            return this.t;
        }
    }

    public b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        super(r2);
    }
}
