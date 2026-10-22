package dagger.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public final class SetFactory<T> implements Factory<Set<T>> {
    private static final Factory<Set<Object>> EMPTY_FACTORY = null;
    private final List<Provider<Collection<T>>> collectionProviders;
    private final List<Provider<T>> individualProviders;

    /* JADX INFO: renamed from: dagger.internal.SetFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Provider<Collection<T>>> collectionProviders;
        private final List<Provider<T>> individualProviders;

        public SetFactory<T> build() {
            return new SetFactory(this.individualProviders, this.collectionProviders, null);
        }

        static {
        }

        public Builder<T> addCollectionProvider(javax.inject.Provider<? extends Collection<? extends T>> r100) {
            return addCollectionProvider(Providers.asDaggerProvider(r100));
        }

        public Builder<T> addProvider(javax.inject.Provider<? extends T> r100) {
            return addProvider(Providers.asDaggerProvider(r100));
        }

        public Builder<T> addCollectionProvider(Provider<? extends Collection<? extends T>> r100) {
            this.collectionProviders.add(r100);
            return this;
        }

        public Builder<T> addProvider(Provider<? extends T> r100) {
            this.individualProviders.add(r100);
            return this;
        }

        private Builder(int r100, int r101) {
            this.individualProviders = DaggerCollections.presizedList(r100);
            this.collectionProviders = DaggerCollections.presizedList(r101);
        }

        public /* synthetic */ Builder(int r100, int r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    @Override // javax.inject.Provider
    public Set<T> get() {
        int r100 = this.individualProviders.size();
        ArrayList r101 = new ArrayList(this.collectionProviders.size());
        int r102 = this.collectionProviders.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        Collection r105 = (Collection) ((Provider) ListProtector.get(this.collectionProviders, r104)).get();
        r100 = r100 + r105.size();
        r101.add(r105);
        r104 = r104 + 1;
        goto L3
    L5:
        HashSet r106 = DaggerCollections.newHashSetWithExpectedSize(r100);
        int r107 = this.individualProviders.size();
        int r108 = 0;
    L6:
        if (r108 >= r107) goto L8;
        r106.add(Preconditions.checkNotNull(((Provider) ListProtector.get(this.individualProviders, r108)).get()));
        r108 = r108 + 1;
        goto L6
    L8:
        int r109 = r101.size();
    L9:
        if (r103 >= r109) goto L16;
        Iterator r110 = ((Collection) ListProtector.get(r101, r103)).iterator();
    L12:
        if (r110.hasNext() == false) goto L14;
        r106.add(Preconditions.checkNotNull(r110.next()));
        goto L12
    L14:
        r103 = r103 + 1;
        goto L9
    L16:
        return Collections.unmodifiableSet(r106);
    }

    static {
        EMPTY_FACTORY = InstanceFactory.create(Collections.emptySet());
    }

    public static <T> Factory<Set<T>> empty() {
        return (Factory<Set<T>>) EMPTY_FACTORY;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    private SetFactory(List<Provider<T>> r100, List<Provider<Collection<T>>> r101) {
        this.individualProviders = r100;
        this.collectionProviders = r101;
    }

    public static <T> Builder<T> builder(int r100, int r101) {
        return new Builder(r100, r101, null);
    }

    public /* synthetic */ SetFactory(List r100, List r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
