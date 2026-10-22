package kq5;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T, R> implements Function {
    public static final f<T, R> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r2) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.h != 2) goto L5;
        boolean r4 = true;
    L7:
        return Boolean.valueOf(r4);
    L5:
        r4 = false;
        goto L7
    }
}
