package sx3;

import androidx.fragment.app.Fragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a<T extends Fragment> implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Class<? extends T>> f543813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Class<? extends T>, T> f543814b;

    @Override // sx3.b
    public final Fragment create() {
        Class<? extends T> r100 = this.f543813a.invoke();
        return this.f543814b.invoke(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends Class<? extends T>> r100, Function1<? super Class<? extends T>, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "typeBuilder");
        Intrinsics.checkNotNullParameter(r101, "creator");
        this.f543813a = r100;
        this.f543814b = r101;
    }
}
