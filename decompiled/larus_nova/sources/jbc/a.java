package jbc;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<T, T, Boolean> f498064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateFlowImpl f498065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b1 f498066c;

    /* JADX WARN: Multi-variable type inference failed */
    public a(T r100, Function2<? super T, ? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "initialValue");
        Intrinsics.checkNotNullParameter(r101, "isTransitionAllowed");
        this.f498064a = r101;
        StateFlowImpl r102 = j1.a(r100);
        this.f498065b = r102;
        this.f498066c = e.b(r102);
    }
}
