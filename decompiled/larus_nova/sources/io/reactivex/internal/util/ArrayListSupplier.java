package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final enum ArrayListSupplier extends Enum<ArrayListSupplier> implements Callable<List<Object>>, Function<Object, List<Object>> {
    public static final ArrayListSupplier INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArrayListSupplier[] f495038a = null;

    static {
        ArrayListSupplier r100 = new ArrayListSupplier();
        INSTANCE = r100;
        f495038a = new ArrayListSupplier[]{r100};
    }

    public ArrayListSupplier() {
        super("INSTANCE", 0);
    }

    public static ArrayListSupplier[] values() {
        return (ArrayListSupplier[]) f495038a.clone();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<Object> call2() throws Exception {
        return new ArrayList();
    }

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> Function<O, List<T>> asFunction() {
        return INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<Object> call() throws Exception {
        return call2();
    }

    public static ArrayListSupplier valueOf(String r100) {
        return (ArrayListSupplier) r27.a.a(ArrayListSupplier.class, r100);
    }

    @Override // io.reactivex.functions.Function
    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public List<Object> apply2(Object r100) throws Exception {
        return new ArrayList();
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ List<Object> apply(Object r100) throws Exception {
        return apply2(r100);
    }
}
