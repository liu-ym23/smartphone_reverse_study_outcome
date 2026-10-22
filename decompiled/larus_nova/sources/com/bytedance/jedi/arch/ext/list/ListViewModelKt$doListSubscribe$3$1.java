package com.bytedance.jedi.arch.ext.list;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class ListViewModelKt$doListSubscribe$3$1 extends PropertyReference1 {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ListViewModelKt$doListSubscribe$3$1();
    }

    public ListViewModelKt$doListSubscribe$3$1() {
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "isEmpty";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(ListViewModelKt.class, "ext_list_release");
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
