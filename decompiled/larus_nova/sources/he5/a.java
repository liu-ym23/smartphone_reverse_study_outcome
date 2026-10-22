package he5;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f484864a;

    /* JADX INFO: renamed from: he5.a$a, reason: collision with other inner class name */
    public static final class C6129a implements uqb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final uqb.b f484865a;

        /* JADX INFO: renamed from: he5.a$a$a, reason: collision with other inner class name */
        public static final class C6130a implements uqb.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ uqb.a f484866a;

            public C6130a(uqb.a r100) {
                this.f484866a = r100;
            }

            @Override // uqb.a
            public final void a(uqb.c r100) {
                Intrinsics.checkNotNullParameter(r100, "templateInfo");
                String r101 = a.f484864a;
                a.f484864a = r100.f551353b;
                this.f484866a.a(r100);
            }

            @Override // uqb.a
            public final void onFailed(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
                this.f484866a.onFailed(r100);
            }
        }

        public C6129a(uqb.b r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            this.f484865a = r100;
        }

        @Override // uqb.b
        public final void a(String r100, uqb.a r101) {
            Intrinsics.checkNotNullParameter(r100, "templatePath");
            Intrinsics.checkNotNullParameter(r101, "resourceCallBack");
            this.f484865a.a(r100, new C6130a(r101));
        }
    }

    static {
    }
}
