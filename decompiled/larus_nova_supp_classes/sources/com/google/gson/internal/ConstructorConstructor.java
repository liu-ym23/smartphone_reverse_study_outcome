package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.ReflectionAccessFilter$FilterResult;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    public String toString() {
        return this.instanceCreators.toString();
    }

    public static String checkInstantiable(Class<?> r2) {
        int r0 = r2.getModifiers();
        if (Modifier.isInterface(r0) == false) goto L7;
        return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(r2.getName());
    L7:
        if (Modifier.isAbstract(r0) == true) goto L9;
        return null;
    L9:
        return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ".concat(r2.getName());
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Class<? super T> r3) {
        if (this.useJdkUnsafe == false) goto L7;
        return new AnonymousClass19(this, r3);
    L7:
        return new 20(this, "Unable to create instance of " + r3 + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> r4) {
        Type r0 = r4.getType();
        Class<? super T> r5 = r4.getRawType();
        InstanceCreator<?> r1 = this.instanceCreators.get(r0);
        if (r1 != null) goto L5;
        InstanceCreator<?> r2 = this.instanceCreators.get(r5);
        if (r2 != null) goto L9;
        ObjectConstructor<T> r3 = newSpecialCollectionConstructor(r0, r5);
        if (r3 == null) goto L13;
        return r3;
    L13:
        ReflectionAccessFilter$FilterResult r6 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r5);
        ObjectConstructor<T> r7 = newDefaultConstructor(r5, r6);
        if (r7 == null) goto L16;
        return r7;
    L16:
        ObjectConstructor<T> r8 = newDefaultImplementationConstructor(r0, r5);
        if (r8 == null) goto L19;
        return r8;
    L19:
        String r9 = checkInstantiable(r5);
        if (r9 == null) goto L24;
        return new 3(this, r9);
    L24:
        if (r6 != ReflectionAccessFilter$FilterResult.ALLOW) goto L28;
        return newUnsafeAllocator(r5);
    L28:
        return new 4(this, "Unable to create instance of " + r5 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    L9:
        return new 2(this, r2, r0);
    L5:
        return new 1(this, r1, r0);
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> r4, ReflectionAccessFilter$FilterResult r5) {
        if (Modifier.isAbstract(r4.getModifiers()) == false) goto L5;
        return null;
    L5:
        boolean r0 = false;
        final Constructor<? super T> r2 = r4.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L26
        ReflectionAccessFilter$FilterResult r3 = ReflectionAccessFilter$FilterResult.ALLOW;
        if (r5 != r3) goto L10;
    L15:
        r0 = true;
    L16:
        if (r0 == false) goto L18;
        if (r5 != r3) goto L25;
        String r6 = ReflectionHelper.tryMakeAccessible(r2);
        if (r6 == null) goto L25;
        return new 8(r6);
    L25:
        return new AnonymousClass9(r2);
    L18:
        return new 7("Unable to invoke no-args constructor of " + r4 + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
    L10:
        if (ReflectionAccessFilterHelper.canAccess(r2, null) == false) goto L16;
        if (r5 != ReflectionAccessFilter$FilterResult.BLOCK_ALL) goto L15;
        if (Modifier.isPublic(r2.getModifiers()) == false) goto L16;
    L26:
        return null;
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type r1, Class<? super T> r2) {
        if (Collection.class.isAssignableFrom(r2) == false) goto L19;
        if (SortedSet.class.isAssignableFrom(r2) == false) goto L9;
        return new 10();
    L9:
        if (Set.class.isAssignableFrom(r2) == false) goto L13;
        return new 11();
    L13:
        if (Queue.class.isAssignableFrom(r2) == false) goto L17;
        return new 12();
    L17:
        return new AnonymousClass13();
    L19:
        if (Map.class.isAssignableFrom(r2) == true) goto L21;
        return null;
    L21:
        if (ConcurrentNavigableMap.class.isAssignableFrom(r2) == false) goto L25;
        return new 14();
    L25:
        if (ConcurrentMap.class.isAssignableFrom(r2) == false) goto L29;
        return new 15();
    L29:
        if (SortedMap.class.isAssignableFrom(r2) == false) goto L33;
        return new 16();
    L33:
        if ((r1 instanceof ParameterizedType) == false) goto L39;
        if (String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) r1).getActualTypeArguments()[0]).getRawType()) == true) goto L39;
        return new 17();
    L39:
        return new AnonymousClass18();
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(Type r1, Class<? super T> r2) {
        if (EnumSet.class.isAssignableFrom(r2) == false) goto L7;
        return new 5(r1);
    L7:
        if (r2 == EnumMap.class) goto L9;
        return null;
    L9:
        return new 6(r1);
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> r1, boolean r2, List<ReflectionAccessFilter> r3) {
        this.instanceCreators = r1;
        this.useJdkUnsafe = r2;
        this.reflectionFilters = r3;
    }
}
