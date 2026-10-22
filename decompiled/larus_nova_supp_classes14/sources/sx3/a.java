package sx3;

import androidx.fragment.app.Fragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T extends Fragment> implements b {
    public final Function0<Class<? extends T>> a;
    public final Function1<Class<? extends T>, T> b;

    @Override // sx3.b
    public final Fragment create() {
        Class r0 = (Class) this.a.invoke();
        return (Fragment) this.b.invoke(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends Class<? extends T>> r2, Function1<? super Class<? extends T>, ? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "typeBuilder");
        Intrinsics.checkNotNullParameter(r3, "creator");
        this.a = r2;
        this.b = r3;
    }
}
