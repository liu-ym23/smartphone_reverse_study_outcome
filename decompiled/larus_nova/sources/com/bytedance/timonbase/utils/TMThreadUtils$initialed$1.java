package com.bytedance.timonbase.utils;

import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class TMThreadUtils$initialed$1 extends MutablePropertyReference0 {
    public TMThreadUtils$initialed$1(TMThreadUtils r100) {
        super(r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "ioExecutor";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(TMThreadUtils.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getIoExecutor()Ljava/util/concurrent/ExecutorService;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        ((TMThreadUtils) this.receiver).getClass();
        ExecutorService r100 = TMThreadUtils.f270904b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ioExecutor");
    L5:
        return r100;
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ((TMThreadUtils) this.receiver).getClass();
        TMThreadUtils.f270904b = (ExecutorService) r100;
    }
}
