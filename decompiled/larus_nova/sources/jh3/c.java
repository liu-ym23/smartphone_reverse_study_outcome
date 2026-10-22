package jh3;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements u83.a {
    public c() {
    }

    @Override // u83.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "productId");
    }

    @Override // u83.a
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
    }

    @Override // u83.a
    public final void c(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // u83.a
    public final void d(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }
}
