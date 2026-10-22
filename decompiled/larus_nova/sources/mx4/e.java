package mx4;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f516219a = null;

    static {
        f516219a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        tt5.a.e("DocAutoTestImpl2", "timeoutCalc err. ", r101, false);
    }
}
