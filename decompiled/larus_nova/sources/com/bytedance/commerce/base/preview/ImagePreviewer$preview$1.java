package com.bytedance.commerce.base.preview;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class ImagePreviewer$preview$1 extends MutablePropertyReference0 {
    public ImagePreviewer$preview$1(a r100) {
        super(r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "transferConfig";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(a.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getTransferConfig()Lcom/bytedance/commerce/base/preview/transfer/TransferConfig;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        xf4.a r100 = ((a) this.receiver).f202803a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("transferConfig");
    L5:
        return r100;
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        xf4.a r101 = (xf4.a) r100;
        ((a) this.receiver).f202803a = r101;
    }
}
