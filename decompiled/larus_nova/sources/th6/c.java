package th6;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
public interface c {
    <T> void getResAsync(String r100, KClass<T> r101, Function1<? super T, Unit> r102, Function1<? super Throwable, Unit> r103);
}
