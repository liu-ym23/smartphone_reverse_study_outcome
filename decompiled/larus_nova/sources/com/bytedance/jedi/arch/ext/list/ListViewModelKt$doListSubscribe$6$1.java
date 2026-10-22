package com.bytedance.jedi.arch.ext.list;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class ListViewModelKt$doListSubscribe$6$1 extends PropertyReference1 {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ListViewModelKt$doListSubscribe$6$1();
    }

    public ListViewModelKt$doListSubscribe$6$1() {
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "list";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(ListViewModelKt.class, "ext_list_release");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getList(Lcom/bytedance/jedi/arch/ext/list/IListState;)Ljava/util/List;";
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ListViewModelKt.getList((IListState) r100);
    }
}
