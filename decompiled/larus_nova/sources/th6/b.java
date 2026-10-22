package th6;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements c {
    public b() {
    }

    @Override // th6.c
    public final <T> void getResAsync(String r100, KClass<T> r101, Function1<? super T, Unit> r102, Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "onFail");
        r103.invoke(new Error("empty"));
    }
}
