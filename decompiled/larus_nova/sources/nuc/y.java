package nuc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes42.dex */
public final class y<T> implements y1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<KClass<Object>, List<? extends KType>, juc.d<T>> f520802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, x1<T>> f520803b;

    /* JADX WARN: Multi-variable type inference failed */
    public y(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends juc.d<T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "compute");
        this.f520802a = r100;
        this.f520803b = new ConcurrentHashMap();
    }

    @Override // nuc.y1
    public final Object a(KClass<Object> r100, List<? extends KType> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "types");
        ConcurrentHashMap<Class<?>, x1<T>> r102 = this.f520803b;
        Class<?> r103 = JvmClassMappingKt.getJavaClass(r100);
        x1<T> r104 = r102.get(r103);
        if (r104 != null) goto L8;
        r104 = new x1();
        x1<T> r105 = r102.putIfAbsent(r103, r104);
        if (r105 == null) goto L8;
        r104 = r105;
    L8:
        x1<T> r106 = r104;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r108 = r101.iterator();
    L10:
        if (r108.hasNext() == false) goto L12;
        r107.add(new x0((KType) r108.next()));
        goto L10
    L12:
        ConcurrentHashMap<List<x0>, Result<juc.d<T>>> r109 = r106.f520800a;
        Result<juc.d<T>> r110 = r109.get(r107);
        if (r110 != null) goto L23;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L16
        Object r112 = Result.m9449constructorimpl(this.f520802a.invoke(r100, r101));     // Catch: Throwable -> L16
    L18:
        r110 = Result.m9448boximpl(r112);
        Result<juc.d<T>> r113 = r109.putIfAbsent(r107, r110);
        if (r113 == null) goto L23;
        r110 = r113;
    L16:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L23:
        return r110.m9458unboximpl();
    }
}
