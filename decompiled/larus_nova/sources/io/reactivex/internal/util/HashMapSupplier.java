package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final enum HashMapSupplier extends Enum<HashMapSupplier> implements Callable<Map<Object, Object>> {
    public static final HashMapSupplier INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HashMapSupplier[] f495042a = null;

    static {
        HashMapSupplier r100 = new HashMapSupplier();
        INSTANCE = r100;
        f495042a = new HashMapSupplier[]{r100};
    }

    public HashMapSupplier() {
        super("INSTANCE", 0);
    }

    public static HashMapSupplier[] values() {
        return (HashMapSupplier[]) f495042a.clone();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Map<Object, Object> call2() throws Exception {
        return new HashMap();
    }

    public static <K, V> Callable<Map<K, V>> asCallable() {
        return INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Map<Object, Object> call() throws Exception {
        return call2();
    }

    public static HashMapSupplier valueOf(String r100) {
        return (HashMapSupplier) r27.a.a(HashMapSupplier.class, r100);
    }
}
