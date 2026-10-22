package com.google.common.cache;

import com.google.common.base.t;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class CacheLoader<K, V> {

    public static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.g<K, V> computingFunction;

        public FunctionToCacheLoader(com.google.common.base.g<K, V> r100) {
            r100.getClass();
            this.computingFunction = r100;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K r100) {
            com.google.common.base.g<K, V> r101 = this.computingFunction;
            r100.getClass();
            return r101.apply(r100);
        }
    }

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String r100) {
            super(r100);
        }
    }

    public static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final t<V> computingSupplier;

        public SupplierToCacheLoader(t<V> r100) {
            r100.getClass();
            this.computingSupplier = r100;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object r100) {
            r100.getClass();
            return this.computingSupplier.get();
        }
    }

    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        public UnsupportedLoadingOperationException() {
        }
    }

    public class a extends CacheLoader<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CacheLoader f274764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f274765b;

        @Override // com.google.common.cache.CacheLoader
        public final V load(K r100) throws Exception {
            return (V) this.f274764a.load(r100);
        }

        @Override // com.google.common.cache.CacheLoader
        public final Map<K, V> loadAll(Iterable<? extends K> r100) throws Exception {
            return this.f274764a.loadAll(r100);
        }

        public a(CacheLoader r100, Executor r101) {
            this.f274764a = r100;
            this.f274765b = r101;
        }

        @Override // com.google.common.cache.CacheLoader
        public final ListenableFuture<V> reload(final K r100, final V r101) {
            final CacheLoader r102 = this.f274764a;
            ListenableFutureTask r103 = ListenableFutureTask.create(new d(r102, r100, r101));
            this.f274765b.execute(r103);
            return r103;
        }
    }

    public CacheLoader() {
    }

    public abstract V load(K r100) throws Exception;

    public static <K, V> CacheLoader<K, V> from(com.google.common.base.g<K, V> r100) {
        return new FunctionToCacheLoader(r100);
    }

    public Map<K, V> loadAll(Iterable<? extends K> r100) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    public static <V> CacheLoader<Object, V> from(t<V> r100) {
        return new SupplierToCacheLoader(r100);
    }

    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> r100, Executor r101) {
        r100.getClass();
        r101.getClass();
        return new a(r100, r101);
    }

    public ListenableFuture<V> reload(K r100, V r101) throws Exception {
        r100.getClass();
        r101.getClass();
        return Futures.immediateFuture(load(r100));
    }
}
