package he5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static volatile String a;

    /* JADX INFO: renamed from: he5.a$a, reason: collision with other inner class name */
    public static final class C0240a implements uqb.b {
        public final uqb.b a;

        /* JADX INFO: renamed from: he5.a$a$a, reason: collision with other inner class name */
        public static final class C0241a implements uqb.a {
            public final /* synthetic */ uqb.a a;

            public C0241a(uqb.a r1) {
                this.a = r1;
            }

            public final void a(uqb.c r2) {
                Intrinsics.checkNotNullParameter(r2, "templateInfo");
                String r0 = a.a;
                a.a = r2.b;
                this.a.a(r2);
            }

            public final void onFailed(Throwable r2) {
                Intrinsics.checkNotNullParameter(r2, "throwable");
                this.a.onFailed(r2);
            }
        }

        public C0240a(uqb.b r2) {
            Intrinsics.checkNotNullParameter(r2, "delegate");
            this.a = r2;
        }

        public final void a(String r3, uqb.a r4) {
            Intrinsics.checkNotNullParameter(r3, "templatePath");
            Intrinsics.checkNotNullParameter(r4, "resourceCallBack");
            this.a.a(r3, new C0241a(r4));
        }
    }

    static {
    }
}
