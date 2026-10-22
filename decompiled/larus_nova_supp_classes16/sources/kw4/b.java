package kw4;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T, R> implements Function {
    public static final b<T, R> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "throwable");
        tt5.a.k("CreateLocationSelector", "getCommonSettings:onErrorResumeNext: " + r4);
        return Flowable.just(com.bytedance.ee.bear.content.creation.location.a.b("", "my_document_library", "", 0));
    }
}
