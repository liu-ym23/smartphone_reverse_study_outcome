package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
final /* synthetic */ class CommandMoltenServiceWrapper$invoke$2 extends FunctionReferenceImpl implements Function2<com.bytedance.lark.lark_rust_sdk_integrator_android.b, Continuation<Object>, Object>, SuspendFunction {
    public CommandMoltenServiceWrapper$invoke$2(Object r8) {
        super(2, r8, Intrinsics.Kotlin.class, "suspendConversion0", "invoke_gIAlu_s$suspendConversion0(Lkotlin/jvm/functions/Function1;Lcom/bytedance/lark/lark_rust_sdk_integrator_android/CommandMoltenService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(com.bytedance.lark.lark_rust_sdk_integrator_android.b r1, Continuation<Object> r2) {
        return ((Function1) ((CallableReference) this).receiver).invoke(r1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.bytedance.lark.lark_rust_sdk_integrator_android.b) r1, (Continuation) r2);
    }
}
