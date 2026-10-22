package dagger.android;

import dagger.internal.DaggerCollections;
import dagger.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class DispatchingAndroidInjector<T> implements AndroidInjector<T> {
    private static final String NO_SUPERTYPES_BOUND_FORMAT = "No injector factory bound for Class<%s>";
    private static final String SUPERTYPES_BOUND_FORMAT = "No injector factory bound for Class<%1$s>. Injector factories were bound for supertypes of %1$s: %2$s. Did you mean to bind an injector factory for the subtype?";
    private final Map<String, Provider<AndroidInjector.Factory<?>>> injectorFactories;

    public static final class InvalidInjectorBindingException extends RuntimeException {
        public InvalidInjectorBindingException(String r100, ClassCastException r101) {
            super(r100, r101);
        }
    }

    private String errorMessageSuggestions(T r100) {
        ArrayList r101 = new ArrayList();
        Class<?> r102 = r100.getClass();
    L3:
        if (r102 == null) goto L9;
        if (this.injectorFactories.containsKey(r102.getCanonicalName()) == false) goto L7;
        r101.add(r102.getCanonicalName());
    L7:
        r102 = r102.getSuperclass();
        goto L3
    L9:
        if (r101.isEmpty() == false) goto L12;
        return String.format(NO_SUPERTYPES_BOUND_FORMAT, new Object[]{r100.getClass().getCanonicalName()});
    L12:
        return String.format(SUPERTYPES_BOUND_FORMAT, new Object[]{r100.getClass().getCanonicalName(), r101});
    }

    @Override // dagger.android.AndroidInjector
    public void inject(T r100) {
        if (maybeInject(r100) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(errorMessageSuggestions(r100));
    }

    public boolean maybeInject(T r100) {
        Provider<AndroidInjector.Factory<?>> r101 = this.injectorFactories.get(r100.getClass().getName());
        if (r101 != null) goto L5;
        return false;
    L5:
        AndroidInjector.Factory<?> r102 = r101.get();
        ((AndroidInjector) Preconditions.checkNotNull(r102.create(r100), "%s.create(I) should not return null.", r102.getClass())).inject(r100);     // Catch: ClassCastException -> L8
        return true;
    L8:
        e = move-exception;
        throw new InvalidInjectorBindingException(String.format("%s does not implement AndroidInjector.Factory<%s>", new Object[]{r102.getClass().getCanonicalName(), r100.getClass().getCanonicalName()}), e);
    }

    @Inject
    public DispatchingAndroidInjector(Map<Class<?>, Provider<AndroidInjector.Factory<?>>> r100, Map<String, Provider<AndroidInjector.Factory<?>>> r101) {
        this.injectorFactories = merge(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <C, V> Map<String, Provider<AndroidInjector.Factory<?>>> merge(Map<Class<? extends C>, V> r100, Map<String, V> r101) {
        if (r100.isEmpty() == false) goto L5;
        return r101;
    L5:
        LinkedHashMap r102 = DaggerCollections.newLinkedHashMapWithExpectedSize(r100.size() + r101.size());
        r102.putAll(r101);
        Iterator<Map.Entry<Class<? extends C>, V>> r103 = r100.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<Class<? extends C>, V> r104 = r103.next();
        r102.put(r104.getKey().getName(), r104.getValue());
        goto L7
    L10:
        return Collections.unmodifiableMap(r102);
    }
}
