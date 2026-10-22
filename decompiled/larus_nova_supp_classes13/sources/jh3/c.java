package jh3;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements u83.a {
    public c() {
    }

    @Override // u83.a
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "productId");
    }

    @Override // u83.a
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "productId");
        Intrinsics.checkNotNullParameter(r3, "tracker");
    }

    @Override // u83.a
    public final void c(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // u83.a
    public final void d(String r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "productId");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }
}
