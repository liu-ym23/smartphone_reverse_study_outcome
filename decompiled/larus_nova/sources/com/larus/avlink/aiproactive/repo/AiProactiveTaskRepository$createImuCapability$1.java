package com.larus.avlink.aiproactive.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.aiproactive.repo.AiProactiveTaskRepository", f = "AiProactiveTaskRepository.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3}, l = {44, 46, 51, 53}, m = "createImuCapability", n = {"health", "health", "supportImuSedentary", "health", "sedentaryDurationConfig", "supportImuSedentary", "sedentaryDurationConfig", "supportImuSedentary", "supportImuHeadDown"}, s = {"L$0", "L$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "Z$0", "Z$1"})
public final class AiProactiveTaskRepository$createImuCapability$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiProactiveTaskRepository this$0;

    public AiProactiveTaskRepository$createImuCapability$1(AiProactiveTaskRepository r100, Continuation<? super AiProactiveTaskRepository$createImuCapability$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
