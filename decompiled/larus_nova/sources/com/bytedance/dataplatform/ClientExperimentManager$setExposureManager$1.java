package com.bytedance.dataplatform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
final /* synthetic */ class ClientExperimentManager$setExposureManager$1 extends MutablePropertyReference0 {
    public ClientExperimentManager$setExposureManager$1(ClientExperimentManager r100) {
        super(r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "exposureManager";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ClientExperimentManager.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getExposureManager()Lcom/bytedance/dataplatform/ExposureManager;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        ClientExperimentManager r100 = (ClientExperimentManager) this.receiver;
        q r101 = ClientExperimentManager.f204277c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("exposureManager");
    L5:
        return r101;
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ClientExperimentManager r101 = (ClientExperimentManager) this.receiver;
        ClientExperimentManager.f204277c = (q) r100;
    }
}
