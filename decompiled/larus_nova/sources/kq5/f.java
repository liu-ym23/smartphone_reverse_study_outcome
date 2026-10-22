package kq5;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T, R> f505593a = null;

    static {
        f505593a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.f241920h != 2) goto L5;
        boolean r102 = true;
    L7:
        return Boolean.valueOf(r102);
    L5:
        r102 = false;
        goto L7
    }
}
