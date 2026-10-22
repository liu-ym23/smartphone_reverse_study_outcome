package juc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.InternalSerializationApi;
import nuc.a1;
import nuc.a2;
import nuc.c1;
import nuc.i1;
import nuc.n2;
import nuc.o0;
import nuc.q0;
import nuc.w1;
import nuc.z1;
import nuc.z2;

/* JADX INFO: loaded from: classes5.dex */
public final class v {
    public static final d<Object> c(KType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return d(kotlinx.serialization.modules.i.f505488a, r100);
    }

    @InternalSerializationApi
    public static final <T> d<T> e(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        d<T> r101 = z1.a(r100, new d[0]);
        if (r101 != null) goto L6;
        Map<KClass<? extends Object>, d<? extends Object>> r102 = n2.f520740a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (d) n2.f520740a.get(r100);
    L6:
        return r101;
    }

    public static final d<?> a(kotlinx.serialization.modules.d r100, KClass<?> r101) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "kClass");
        d<?> r102 = kotlinx.serialization.modules.d.c(r100, r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        a2.d(r101);
        throw null;
    }

    public static final d<Object> d(kotlinx.serialization.modules.d r100, KType r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "type");
        d<Object> r102 = x.a(r100, r101, true);
        if (r102 == null) goto L5;
        return r102;
    L5:
        KClass<Object> r103 = a2.c(r101);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        a2.d(r103);
        throw null;
    }

    public static final d<? extends Object> b(KClass<Object> r100, List<? extends d<Object>> r101, Function0<? extends KClassifier> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "serializers");
        Intrinsics.checkNotNullParameter(r102, "elementClassifierIfArray");
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Collection.class)) == false) goto L5;
    L47:
        d<? extends Object> r103 = new nuc.f((d) ListProtector.get(r101, 0));
    L48:
        if (r103 != null) goto L51;
        d[] r104 = (d[]) r101.toArray(new d[0]);
        return z1.a(r100, (d[]) Arrays.copyOf(r104, r104.length));
    L51:
        return r103;
    L5:
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(List.class)) == true) goto L47;
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(List.class)) == true) goto L47;
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(ArrayList.class)) == true) goto L47;
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(HashSet.class)) == false) goto L15;
        r103 = new q0((d) ListProtector.get(r101, 0));
        goto L48
    L15:
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Set.class)) == false) goto L17;
    L46:
        r103 = new c1((d) ListProtector.get(r101, 0));
        goto L48
    L17:
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Set.class)) == true) goto L46;
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(LinkedHashSet.class)) == true) goto L46;
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(HashMap.class)) == false) goto L25;
        r103 = new o0((d) ListProtector.get(r101, 0), (d) ListProtector.get(r101, 1));
        goto L48
    L25:
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Map.class)) == false) goto L27;
    L45:
        r103 = new a1((d) ListProtector.get(r101, 0), (d) ListProtector.get(r101, 1));
        goto L48
    L27:
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Map.class)) == true) goto L45;
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(LinkedHashMap.class)) == true) goto L45;
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Map.Entry.class)) == false) goto L36;
        d r105 = (d) ListProtector.get(r101, 0);
        d r106 = (d) ListProtector.get(r101, 1);
        Intrinsics.checkNotNullParameter(r105, "keySerializer");
        Intrinsics.checkNotNullParameter(r106, "valueSerializer");
        d<? extends Object> r107 = new i1(r105, r106);
    L34:
        r103 = r107;
        goto L48
    L36:
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Pair.class)) == false) goto L39;
        d r108 = (d) ListProtector.get(r101, 0);
        d r109 = (d) ListProtector.get(r101, 1);
        Intrinsics.checkNotNullParameter(r108, "keySerializer");
        Intrinsics.checkNotNullParameter(r109, "valueSerializer");
        r107 = new w1(r108, r109);
        goto L34
    L39:
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Triple.class)) == false) goto L41;
        d r110 = (d) ListProtector.get(r101, 0);
        d r111 = (d) ListProtector.get(r101, 1);
        d r112 = (d) ListProtector.get(r101, 2);
        Intrinsics.checkNotNullParameter(r110, "aSerializer");
        Intrinsics.checkNotNullParameter(r111, "bSerializer");
        Intrinsics.checkNotNullParameter(r112, "cSerializer");
        r103 = new z2(r110, r111, r112);
        goto L48
    L41:
        Intrinsics.checkNotNullParameter(r100, "rootClass");
        if (JvmClassMappingKt.getJavaClass(r100).isArray() == false) goto L44;
        KClassifier r113 = r102.invoke();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        r103 = kuc.a.a((KClass) r113, (d) ListProtector.get(r101, 0));
        goto L48
    L44:
        r103 = null;
        goto L48
    }

    public static final List<d<Object>> f(kotlinx.serialization.modules.d r100, List<? extends KType> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeArguments");
        if (r102 == false) goto L8;
        List<? extends KType> r103 = r101;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L16;
        r104.add(d(r100, (KType) r105.next()));
    L16:
        return r104;
    L8:
        List<? extends KType> r106 = r101;
        r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r107 = r106.iterator();
    L10:
        if (r107.hasNext() == false) goto L16;
        KType r108 = (KType) r107.next();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r108, "type");
        d<Object> r109 = x.a(r100, r108, false);
        if (r109 == null) goto L13;
        r104.add(r109);
        goto L10
    L13:
        return null;
    }
}
