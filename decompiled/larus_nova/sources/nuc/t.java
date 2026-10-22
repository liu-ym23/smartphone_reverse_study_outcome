package nuc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes42.dex */
public final class t<T> implements y1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<KClass<Object>, List<? extends KType>, juc.d<T>> f520775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u<x1<T>> f520776b;

    public static final class a implements Function0<T> {
        public a() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return (T) new x1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends juc.d<T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "compute");
        this.f520775a = r100;
        this.f520776b = new u();
    }

    @Override // nuc.y1
    public final Object a(KClass<Object> r100, List<? extends KType> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "types");
        l1 r102 = (l1) this.f520776b.get(JvmClassMappingKt.getJavaClass(r100));
        T r103 = r102.reference.get();
        if (r103 != null) goto L6;
        r103 = (T) r102.a(new a());
    L6:
        x1 r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r106 = r101.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        r105.add(new x0((KType) r106.next()));
        goto L8
    L10:
        ConcurrentHashMap<List<x0>, Result<juc.d<T>>> r107 = r104.f520800a;
        Result<juc.d<T>> r108 = r107.get(r105);
        if (r108 != null) goto L21;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L14
        Object r110 = Result.m9449constructorimpl(this.f520775a.invoke(r100, r101));     // Catch: Throwable -> L14
    L16:
        r108 = Result.m9448boximpl(r110);
        Result<juc.d<T>> r111 = r107.putIfAbsent(r105, r108);
        if (r111 == null) goto L21;
        r108 = r111;
    L14:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        return r108.m9458unboximpl();
    }
}
