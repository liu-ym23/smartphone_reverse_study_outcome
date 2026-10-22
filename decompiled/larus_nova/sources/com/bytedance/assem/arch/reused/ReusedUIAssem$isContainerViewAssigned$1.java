package com.bytedance.assem.arch.reused;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class ReusedUIAssem$isContainerViewAssigned$1 extends MutablePropertyReference0 {
    public ReusedUIAssem$isContainerViewAssigned$1(ReusedUIAssem r100) {
        super(r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "containerView";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ReusedUIAssem.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getContainerView()Landroid/view/View;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return ((ReusedUIAssem) this.receiver).r();
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        View r101 = (View) r100;
        ((ReusedUIAssem) this.receiver).f192984h = r101;
    }
}
