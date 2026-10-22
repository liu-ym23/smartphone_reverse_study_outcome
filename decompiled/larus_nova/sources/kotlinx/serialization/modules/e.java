package kotlinx.serialization.modules;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import juc.n;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import nuc.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<KClass<?>, a> f505480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<KClass<?>, Map<KClass<?>, juc.d<?>>> f505481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<KClass<?>, Function1<?, n<?>>> f505482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<KClass<?>, Map<String, juc.d<?>>> f505483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<KClass<?>, Function1<String, juc.c<?>>> f505484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f505485f;

    public final c f() {
        return new c(this.f505480a, this.f505481b, this.f505482c, this.f505483d, this.f505484e, this.f505485f);
    }

    public e() {
        this.f505480a = new HashMap();
        this.f505481b = new HashMap();
        this.f505482c = new HashMap();
        this.f505483d = new HashMap();
        this.f505484e = new HashMap();
    }

    @Override // kotlinx.serialization.modules.g
    public final <T> void a(KClass<T> r100, Function1<? super List<? extends juc.d<?>>, ? extends juc.d<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        j(r100, new a.b(r101), false);
    }

    @Override // kotlinx.serialization.modules.g
    public final <T> void b(KClass<T> r100, juc.d<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, "serializer");
        j(r100, new a.C6593a(r101), false);
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base> void c(KClass<Base> r100, Function1<? super String, ? extends juc.c<? extends Base>> r101) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "defaultDeserializerProvider");
        g(r100, r101, false);
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base> void d(KClass<Base> r100, Function1<? super Base, ? extends n<? super Base>> r101) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "defaultSerializerProvider");
        h(r100, r101, false);
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base, Sub extends Base> void e(KClass<Base> r100, KClass<Sub> r101, juc.d<Sub> r102) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "actualClass");
        Intrinsics.checkNotNullParameter(r102, "actualSerializer");
        i(r100, r101, r102, false);
    }

    public final <Base> void g(KClass<Base> r100, Function1<? super String, ? extends juc.c<? extends Base>> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "defaultDeserializerProvider");
        Function1 r103 = (Function1) ((HashMap) this.f505484e).get(r100);
        if (r103 != null) goto L5;
    L10:
        ((HashMap) this.f505484e).put(r100, r101);
        return;
    L5:
        if (Intrinsics.areEqual(r103, r101) == true) goto L10;
        if (r102 == true) goto L10;
        throw new IllegalArgumentException("Default deserializers provider for " + r100 + " is already registered: " + r103);
    }

    public final <Base> void h(KClass<Base> r100, Function1<? super Base, ? extends n<? super Base>> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "defaultSerializerProvider");
        Function1 r103 = (Function1) ((HashMap) this.f505482c).get(r100);
        if (r103 != null) goto L5;
    L10:
        ((HashMap) this.f505482c).put(r100, r101);
        return;
    L5:
        if (Intrinsics.areEqual(r103, r101) == true) goto L10;
        if (r102 == true) goto L10;
        throw new IllegalArgumentException("Default serializers provider for " + r100 + " is already registered: " + r103);
    }

    public final <T> void j(KClass<T> r100, a r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "forClass");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        if (r102 == true) goto L11;
        a r103 = (a) ((HashMap) this.f505480a).get(r100);
        if (r103 == null) goto L11;
        if (Intrinsics.areEqual(r103, r101) == true) goto L11;
        throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + r100 + " already registered in this module");
    L11:
        ((HashMap) this.f505480a).put(r100, r101);
        if (z1.c(r100) == false) goto L15;
        this.f505485f = true;
        return;
    }

    public final <Base, Sub extends Base> void i(KClass<Base> r100, KClass<Sub> r101, juc.d<Sub> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "concreteClass");
        Intrinsics.checkNotNullParameter(r102, "concreteSerializer");
        String r104 = r102.getDescriptor().f();
        HashMap r105 = (HashMap) this.f505481b;
        Object r106 = r105.get(r100);
        if (r106 != null) goto L5;
        r106 = new HashMap();
        r105.put(r100, r106);
    L5:
        Map r107 = (Map) r106;
        juc.d r108 = (juc.d) r107.get(r101);
        HashMap r109 = (HashMap) this.f505483d;
        Object r110 = r109.get(r100);
        if (r110 != null) goto L8;
        r110 = new HashMap();
        r109.put(r100, r110);
    L8:
        Map r111 = (Map) r110;
        if (r103 == false) goto L14;
        if (r108 == null) goto L12;
        r111.remove(r108.getDescriptor().f());
    L12:
        r107.put(r101, r102);
        r111.put(r104, r102);
        return;
    L14:
        if (r108 != null) goto L16;
    L20:
        juc.d r112 = (juc.d) r111.get(r104);
        if (r112 == null) goto L34;
        Object r113 = ((HashMap) this.f505481b).get(r100);
        Intrinsics.checkNotNull(r113);
        Iterator r114 = MapsKt.asSequence((Map) r113).iterator();
    L24:
        if (r114.hasNext() == false) goto L31;
        Object r115 = r114.next();
        if (((Map.Entry) r115).getValue() != r112) goto L28;
        boolean r116 = true;
    L29:
        if (r116 == false) goto L24;
    L33:
        throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + r100 + "' have the same serial name '" + r104 + "': '" + r101 + "' and '" + ((Map.Entry) r115) + '\'');
    L28:
        r116 = false;
        goto L29
    L31:
        r115 = null;
        goto L33
    L34:
        r107.put(r101, r102);
        r111.put(r104, r102);
        return;
    L16:
        if (Intrinsics.areEqual(r108, r102) == false) goto L19;
        juc.d r117 = (juc.d) r111.remove(r108.getDescriptor().f());
        goto L20
    L19:
        throw new SerializerAlreadyRegisteredException(r100, r101);
    }
}
