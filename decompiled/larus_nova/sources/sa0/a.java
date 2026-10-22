package sa0;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import pa0.e;
import pa0.k;

/* JADX INFO: loaded from: classes45.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f541138a;

    public a(c r100) {
        this.f541138a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        e r101 = (e) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return this.f541138a.a((k) r101);
    }
}
