package nuc;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes42.dex */
public final class s<T> implements r2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<KClass<?>, juc.d<T>> f520766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u<m<T>> f520767b;

    public static final class a implements Function0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f520768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ KClass f520769b;

        public a(s r100, KClass r101) {
            this.f520768a = r100;
            this.f520769b = r101;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return (T) new m(this.f520768a.f520766a.invoke(this.f520769b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(Function1<? super KClass<?>, ? extends juc.d<T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "compute");
        this.f520766a = r100;
        this.f520767b = new u();
    }

    @Override // nuc.r2
    public final juc.d<T> a(KClass<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        l1 r101 = (l1) this.f520767b.get(JvmClassMappingKt.getJavaClass(r100));
        T r102 = r101.reference.get();
        if (r102 != null) goto L7;
        r102 = (T) r101.a(new a(this, r100));
    L7:
        return r102.f520735a;
    }
}
