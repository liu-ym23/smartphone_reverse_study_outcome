package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;

/* JADX INFO: loaded from: classes5.dex */
public final class NullabilityAnnotationStatesImpl<T> implements NullabilityAnnotationStates<T> {
    private final MemoizedFunctionToNullable<FqName, T> cache;
    private final Map<FqName, T> states;
    private final LockBasedStorageManager storageManager;

    public static /* synthetic */ Object accessor$NullabilityAnnotationStatesImpl$lambda0(NullabilityAnnotationStatesImpl r100, FqName r101) {
        return cache$lambda$0(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NullabilityAnnotationStatesImpl(Map<FqName, ? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "states");
        this.states = r100;
        LockBasedStorageManager r101 = new LockBasedStorageManager("Java nullability annotation states");
        this.storageManager = r101;
        this.cache = r101.createMemoizedFunctionWithNullableValues(new NullabilityAnnotationStatesImpl$$Lambda$0(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates
    public T get(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        return this.cache.invoke(r100);
    }

    private static final Object cache$lambda$0(NullabilityAnnotationStatesImpl r100, FqName r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Intrinsics.checkNotNull(r101);
        return FqNamesUtilKt.findValueForMostSpecificFqname(r101, r100.states);
    }
}
