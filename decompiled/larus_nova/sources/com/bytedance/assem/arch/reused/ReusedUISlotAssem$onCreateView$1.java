package com.bytedance.assem.arch.reused;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class ReusedUISlotAssem$onCreateView$1 extends MutablePropertyReference0 {
    public ReusedUISlotAssem$onCreateView$1(ReusedUISlotAssem r100) {
        super(r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "contentView";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ReusedUISlotAssem.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getContentView()Landroid/view/View;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        View r100 = ((ReusedUISlotAssem) this.receiver).A;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        return r100;
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        View r101 = (View) r100;
        ((ReusedUISlotAssem) this.receiver).A = r101;
    }
}
