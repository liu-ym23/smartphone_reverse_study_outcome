package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes5.dex */
public final class LazyWrappedType extends WrappedType {
    private final Function0<KotlinType> computation;
    private final NotNullLazyValue<KotlinType> lazyValue;
    private final StorageManager storageManager;

    public static /* synthetic */ KotlinType accessor$LazyWrappedType$lambda0(KotlinTypeRefiner r100, LazyWrappedType r101) {
        return refine$lambda$0(r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public KotlinType getDelegate() {
        return this.lazyValue.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public boolean isComputed() {
        return this.lazyValue.isComputed();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public LazyWrappedType refine(final KotlinTypeRefiner r100) {
        Intrinsics.checkNotNullParameter(r100, "kotlinTypeRefiner");
        return new LazyWrappedType(this.storageManager, new LazyWrappedType$$Lambda$0(r100, this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r100) {
        return refine(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(StorageManager r100, Function0<? extends KotlinType> r101) {
        Intrinsics.checkNotNullParameter(r100, "storageManager");
        Intrinsics.checkNotNullParameter(r101, "computation");
        this.storageManager = r100;
        this.computation = r101;
        this.lazyValue = r100.createLazyValue(r101);
    }

    private static final KotlinType refine$lambda$0(KotlinTypeRefiner r100, LazyWrappedType r101) {
        Intrinsics.checkNotNullParameter(r100, "$kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(r101, "this$0");
        return r100.refineType(r101.computation.invoke());
    }
}
