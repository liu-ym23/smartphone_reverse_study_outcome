package com.obric.assistant.component;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricCameraAutoSendComponent", f = "ObricCameraAutoSendComponent.kt", i = {}, l = {122}, m = "waitSendDependenciesReady", n = {}, s = {})
public final class ObricCameraAutoSendComponent$waitSendDependenciesReady$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricCameraAutoSendComponent this$0;

    public ObricCameraAutoSendComponent$waitSendDependenciesReady$1(ObricCameraAutoSendComponent r100, Continuation<? super ObricCameraAutoSendComponent$waitSendDependenciesReady$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ObricCameraAutoSendComponent r101 = this.this$0;
        int r102 = ObricCameraAutoSendComponent.f387982o;
        return r101.h3(this);
    }
}
