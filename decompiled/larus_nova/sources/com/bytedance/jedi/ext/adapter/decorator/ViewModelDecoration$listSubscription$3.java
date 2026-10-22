package com.bytedance.jedi.ext.adapter.decorator;

import com.bytedance.jedi.arch.ext.list.IListState;
import com.bytedance.jedi.arch.ext.list.ListViewModelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class ViewModelDecoration$listSubscription$3 extends PropertyReference1 {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ViewModelDecoration$listSubscription$3();
    }

    public ViewModelDecoration$listSubscription$3() {
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "isEmpty";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(ListViewModelKt.class, "ext_adapter_release");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "isEmpty(Lcom/bytedance/jedi/arch/ext/list/IListState;)Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;";
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ListViewModelKt.isEmpty((IListState) r100);
    }
}
