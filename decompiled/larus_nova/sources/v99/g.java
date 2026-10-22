package v99;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g implements wxa.b {
    public g() {
    }

    public static final w99.a b(Lazy r100) {
        return (w99.a) r100.getValue();
    }

    @Override // wxa.b
    public final f a(final Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        return new f(LazyKt.lazy(new e(r100)), r100);
    }
}
