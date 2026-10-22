package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* JADX INFO: loaded from: classes.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    public String toString() {
        return this.instanceCreators.toString();
    }

    public static String checkInstantiable(Class<?> r100) {
        int r101 = r100.getModifiers();
        if (Modifier.isInterface(r101) == false) goto L7;
        return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(r100.getName());
    L7:
        if (Modifier.isAbstract(r101) == true) goto L9;
        return null;
    L9:
        return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ".concat(r100.getName());
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Class<? super T> r100) {
        if (this.useJdkUnsafe == true) goto L5;
        final String r101 = "Unable to create instance of " + r100 + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        return new AnonymousClass20(this, r101);
    L5:
        return new AnonymousClass19(this, r100);
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> r100) {
        final Type r101 = r100.getType();
        Class<? super T> r102 = r100.getRawType();
        final InstanceCreator<?> r103 = this.instanceCreators.get(r101);
        if (r103 != null) goto L5;
        final InstanceCreator<?> r104 = this.instanceCreators.get(r102);
        if (r104 != null) goto L9;
        ObjectConstructor<T> r105 = newSpecialCollectionConstructor(r101, r102);
        if (r105 == null) goto L13;
        return r105;
    L13:
        ReflectionAccessFilter.FilterResult r106 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r102);
        ObjectConstructor<T> r107 = newDefaultConstructor(r102, r106);
        if (r107 == null) goto L16;
        return r107;
    L16:
        ObjectConstructor<T> r108 = newDefaultImplementationConstructor(r101, r102);
        if (r108 == null) goto L19;
        return r108;
    L19:
        final String r109 = checkInstantiable(r102);
        if (r109 == null) goto L24;
        return new AnonymousClass3(this, r109);
    L24:
        if (r106 == ReflectionAccessFilter.FilterResult.ALLOW) goto L26;
        final String r110 = "Unable to create instance of " + r102 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return new AnonymousClass4(this, r110);
    L26:
        return newUnsafeAllocator(r102);
    L9:
        return new AnonymousClass2(this, r104, r101);
    L5:
        return new AnonymousClass1(this, r103, r101);
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> r100, ReflectionAccessFilter.FilterResult r101) {
        if (Modifier.isAbstract(r100.getModifiers()) == false) goto L5;
        return null;
    L5:
        boolean r102 = false;
        final Constructor<? super T> r103 = r100.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L26
        ReflectionAccessFilter.FilterResult r104 = ReflectionAccessFilter.FilterResult.ALLOW;
        if (r101 != r104) goto L10;
    L15:
        r102 = true;
    L16:
        if (r102 == true) goto L19;
        final String r105 = "Unable to invoke no-args constructor of " + r100 + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
        return new AnonymousClass7(r105);
    L19:
        if (r101 != r104) goto L25;
        final String r106 = ReflectionHelper.tryMakeAccessible(r103);
        if (r106 == null) goto L25;
        return new AnonymousClass8(r106);
    L25:
        return new AnonymousClass9(r103);
    L10:
        if (ReflectionAccessFilterHelper.canAccess(r103, null) == false) goto L16;
        if (r101 != ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L15;
        if (Modifier.isPublic(r103.getModifiers()) == false) goto L16;
    L26:
        return null;
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type r100, Class<? super T> r101) {
        if (Collection.class.isAssignableFrom(r101) == false) goto L19;
        if (SortedSet.class.isAssignableFrom(r101) == false) goto L9;
        return new AnonymousClass10();
    L9:
        if (Set.class.isAssignableFrom(r101) == false) goto L13;
        return new AnonymousClass11();
    L13:
        if (Queue.class.isAssignableFrom(r101) == false) goto L17;
        return new AnonymousClass12();
    L17:
        return new AnonymousClass13();
    L19:
        if (Map.class.isAssignableFrom(r101) == true) goto L21;
        return null;
    L21:
        if (ConcurrentNavigableMap.class.isAssignableFrom(r101) == false) goto L25;
        return new AnonymousClass14();
    L25:
        if (ConcurrentMap.class.isAssignableFrom(r101) == false) goto L29;
        return new AnonymousClass15();
    L29:
        if (SortedMap.class.isAssignableFrom(r101) == false) goto L33;
        return new AnonymousClass16();
    L33:
        if ((r100 instanceof ParameterizedType) == false) goto L39;
        if (String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) r100).getActualTypeArguments()[0]).getRawType()) == true) goto L39;
        return new AnonymousClass17();
    L39:
        return new AnonymousClass18();
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(final Type r100, Class<? super T> r101) {
        if (EnumSet.class.isAssignableFrom(r101) == false) goto L7;
        return new AnonymousClass5(r100);
    L7:
        if (r101 == EnumMap.class) goto L9;
        return null;
    L9:
        return new AnonymousClass6(r100);
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> r100, boolean r101, List<ReflectionAccessFilter> r102) {
        this.instanceCreators = r100;
        this.useJdkUnsafe = r101;
        this.reflectionFilters = r102;
    }
}
