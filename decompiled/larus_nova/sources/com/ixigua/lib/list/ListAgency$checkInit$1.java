package com.ixigua.lib.list;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
final /* synthetic */ class ListAgency$checkInit$1 extends MutablePropertyReference0 {
    public ListAgency$checkInit$1(ListAgency r100) {
        super(r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "appContext";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ListAgency.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getAppContext()Landroid/content/Context;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        ((ListAgency) this.receiver).getClass();
        Context r100 = ListAgency.f278496c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
    L5:
        return r100;
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ((ListAgency) this.receiver).getClass();
        ListAgency.f278496c = (Context) r100;
    }
}
