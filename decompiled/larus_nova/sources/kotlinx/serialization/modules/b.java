package kotlinx.serialization.modules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes42.dex */
public final class b<Base> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<Base> f505470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final juc.d<Base> f505471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<KClass<? extends Base>, juc.d<? extends Base>>> f505472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super String, ? extends juc.c<? extends Base>> f505473d;

    public b(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        this.f505470a = r100;
        this.f505471b = null;
        this.f505472c = new ArrayList();
    }

    public final void a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        juc.d<Base> r101 = this.f505471b;
        if (r101 == null) goto L5;
        KClass<Base> r102 = this.f505470a;
        r100.i(r102, r102, r101, false);
    L5:
        Iterator r103 = ((ArrayList) this.f505472c).iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        Pair r104 = (Pair) r103.next();
        KClass r105 = (KClass) r104.component1();
        juc.d r106 = (juc.d) r104.component2();
        KClass<Base> r107 = this.f505470a;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder.buildTo$lambda$1>");
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        r100.i(r107, r105, r106, false);
        goto L7
    L9:
        Function1<? super String, ? extends juc.c<? extends Base>> r108 = this.f505473d;
        if (r108 == null) goto L14;
        r100.g(this.f505470a, r108, false);
        return;
    }

    public final void b(Function1<? super String, ? extends juc.c<? extends Base>> r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultDeserializerProvider");
        if (this.f505473d != null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        this.f505473d = r100;
        return;
    L10:
        throw new IllegalArgumentException(("Default deserializer provider is already registered for class " + this.f505470a + ": " + this.f505473d).toString());
    L5:
        r101 = false;
        goto L6
    }

    public final <T extends Base> void c(KClass<T> r100, juc.d<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "subclass");
        Intrinsics.checkNotNullParameter(r101, "serializer");
        List<Pair<KClass<? extends Base>, juc.d<? extends Base>>> r102 = this.f505472c;
        ArrayList r103 = (ArrayList) r102;
        r103.add(TuplesKt.to(r100, r101));
    }
}
