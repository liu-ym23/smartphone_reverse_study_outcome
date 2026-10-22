package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
final /* synthetic */ class CommandMoltenServiceWrapper$invoke$2 extends FunctionReferenceImpl implements Function2<com.bytedance.lark.lark_rust_sdk_integrator_android.b, Continuation<Object>, Object>, SuspendFunction {
    public CommandMoltenServiceWrapper$invoke$2(Object r100) {
        super(2, r100, Intrinsics.Kotlin.class, "suspendConversion0", "invoke_gIAlu_s$suspendConversion0(Lkotlin/jvm/functions/Function1;Lcom/bytedance/lark/lark_rust_sdk_integrator_android/CommandMoltenService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.bytedance.lark.lark_rust_sdk_integrator_android.b r100, Continuation<Object> r101) {
        return ((Function1) this.receiver).invoke(r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(com.bytedance.lark.lark_rust_sdk_integrator_android.b r100, Continuation<Object> r101) {
        return invoke2(r100, r101);
    }
}
