package kotlinx.serialization.modules;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import juc.n;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<KClass<?>, a> f505474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<KClass<?>, Map<KClass<?>, juc.d<?>>> f505475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<KClass<?>, Function1<?, n<?>>> f505476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<KClass<?>, Map<String, juc.d<?>>> f505477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<KClass<?>, Function1<String, juc.c<?>>> f505478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f505479f;

    @Override // kotlinx.serialization.modules.d
    public final boolean d() {
        return this.f505479f;
    }

    @Override // kotlinx.serialization.modules.d
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "collector");
        Iterator<Map.Entry<KClass<?>, a>> r101 = this.f505474a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<KClass<?>, a> r102 = r101.next();
        KClass<?> r103 = r102.getKey();
        a r104 = r102.getValue();
        if ((r104 instanceof a.C6593a) == true) goto L7;
        if ((r104 instanceof a.b) == false) goto L12;
        r100.a(r103, ((a.b) r104).f505469a);
        goto L4
    L12:
        throw new NoWhenBranchMatchedException();
    L7:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        juc.d<?> r105 = ((a.C6593a) r104).f505468a;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        r100.b(r103, r105);
        goto L4
    L13:
        Iterator<Map.Entry<KClass<?>, Map<KClass<?>, juc.d<?>>>> r106 = this.f505475b.entrySet().iterator();
    L15:
        if (r106.hasNext() == false) goto L20;
        Map.Entry<KClass<?>, Map<KClass<?>, juc.d<?>>> r107 = r106.next();
        KClass<?> r108 = r107.getKey();
        Iterator<Map.Entry<KClass<?>, juc.d<?>>> r109 = r107.getValue().entrySet().iterator();
    L18:
        if (r109.hasNext() == false) goto L15;
        Map.Entry<KClass<?>, juc.d<?>> r110 = r109.next();
        KClass<?> r111 = r110.getKey();
        juc.d<?> r112 = r110.getValue();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        r100.e(r108, r111, r112);
        goto L18
    L20:
        Iterator<Map.Entry<KClass<?>, Function1<?, n<?>>>> r113 = this.f505476c.entrySet().iterator();
    L22:
        if (r113.hasNext() == false) goto L24;
        Map.Entry<KClass<?>, Function1<?, n<?>>> r114 = r113.next();
        KClass<?> r115 = r114.getKey();
        Function1<?, n<?>> r116 = r114.getValue();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
        r100.d(r115, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r116, 1));
        goto L22
    L24:
        Iterator<Map.Entry<KClass<?>, Function1<String, juc.c<?>>>> r117 = this.f505478e.entrySet().iterator();
    L26:
        if (r117.hasNext() == false) goto L28;
        Map.Entry<KClass<?>, Function1<String, juc.c<?>>> r118 = r117.next();
        KClass<?> r119 = r118.getKey();
        Function1<String, juc.c<?>> r120 = r118.getValue();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
        r100.c(r119, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r120, 1));
        goto L26
    }

    @Override // kotlinx.serialization.modules.d
    public final <T> juc.d<T> b(KClass<T> r100, List<? extends juc.d<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, "typeArgumentsSerializers");
        a r102 = this.f505474a.get(r100);
        if (r102 == null) goto L5;
        juc.d<?> r103 = r102.a(r101);
    L7:
        if ((r103 instanceof juc.d) == true) goto L9;
        return null;
    L9:
        return (juc.d<T>) r103;
    L5:
        r103 = null;
        goto L7
    }

    @Override // kotlinx.serialization.modules.d
    public final <T> juc.c<T> e(KClass<? super T> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Map<String, juc.d<?>> r102 = this.f505477d.get(r100);
        if (r102 == null) goto L5;
        juc.d<?> r103 = r102.get(r101);
    L7:
        if ((r103 instanceof juc.d) == true) goto L10;
        r103 = null;
    L10:
        if (r103 != null) goto L12;
        Function1<String, juc.c<?>> r104 = this.f505478e.get(r100);
        if (TypeIntrinsics.isFunctionOfArity(r104, 1) == false) goto L16;
        Function1<String, juc.c<?>> r105 = r104;
    L17:
        if (r105 != null) goto L19;
        return null;
    L19:
        return (juc.c) r105.invoke(r101);
    L16:
        r105 = null;
        goto L17
    L12:
        return r103;
    L5:
        r103 = null;
        goto L7
    }

    @Override // kotlinx.serialization.modules.d
    public final <T> n<T> f(KClass<? super T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (r100.isInstance(r101) == true) goto L5;
        return null;
    L5:
        Map<KClass<?>, juc.d<?>> r102 = this.f505475b.get(r100);
        if (r102 == null) goto L8;
        juc.d<?> r103 = r102.get(Reflection.getOrCreateKotlinClass(r101.getClass()));
    L10:
        if ((r103 instanceof n) == false) goto L12;
        juc.d<?> r104 = r103;
    L13:
        if (r104 == null) goto L15;
        return r104;
    L15:
        Function1<?, n<?>> r105 = this.f505476c.get(r100);
        if (TypeIntrinsics.isFunctionOfArity(r105, 1) == false) goto L18;
        Function1<?, n<?>> r106 = r105;
    L19:
        if (r106 != null) goto L21;
        return null;
    L21:
        return (n) r106.invoke(r101);
    L18:
        r106 = null;
        goto L19
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Map<KClass<?>, ? extends a> r100, Map<KClass<?>, ? extends Map<KClass<?>, ? extends juc.d<?>>> r101, Map<KClass<?>, ? extends Function1<?, ? extends n<?>>> r102, Map<KClass<?>, ? extends Map<String, ? extends juc.d<?>>> r103, Map<KClass<?>, ? extends Function1<? super String, ? extends juc.c<?>>> r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(r101, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(r102, "polyBase2DefaultSerializerProvider");
        Intrinsics.checkNotNullParameter(r103, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(r104, "polyBase2DefaultDeserializerProvider");
        this.f505474a = r100;
        this.f505475b = r101;
        this.f505476c = r102;
        this.f505477d = r103;
        this.f505478e = r104;
        this.f505479f = r105;
    }
}
