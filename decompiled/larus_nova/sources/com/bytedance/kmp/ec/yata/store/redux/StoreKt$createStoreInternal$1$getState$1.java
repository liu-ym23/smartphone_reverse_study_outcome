package com.bytedance.kmp.ec.yata.store.redux;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
public /* synthetic */ class StoreKt$createStoreInternal$1$getState$1 extends FunctionReferenceImpl implements Function0<Object> {
    final /* synthetic */ Ref.ObjectRef<Object> $currentState;

    public StoreKt$createStoreInternal$1$getState$1(Ref.ObjectRef<Object> r100) {
        this.$currentState = r100;
        super(0, Intrinsics.Kotlin.class, "getState", "createStoreInternal$getState(Lkotlin/jvm/internal/Ref$ObjectRef;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.$currentState.element;
    }
}
