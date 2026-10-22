package o98;

import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f522486a;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            d.f522486a = "";
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            d.f522486a = "";
        }
    }

    static {
        f522486a = "";
        AccountService.f365697a.E(new a());
    }
}
