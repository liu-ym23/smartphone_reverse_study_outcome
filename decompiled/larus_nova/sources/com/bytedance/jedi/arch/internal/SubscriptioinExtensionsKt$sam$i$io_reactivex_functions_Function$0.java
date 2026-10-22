package com.bytedance.jedi.arch.internal;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 176)
public final class SubscriptioinExtensionsKt$sam$i$io_reactivex_functions_Function$0 implements Function {
    private final /* synthetic */ Function1 function;

    public SubscriptioinExtensionsKt$sam$i$io_reactivex_functions_Function$0(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        this.function = r100;
    }

    @Override // io.reactivex.functions.Function
    public final /* synthetic */ Object apply(Object r100) {
        return this.function.invoke(r100);
    }
}
