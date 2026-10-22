package com.bytedance.jedi.arch.ext.list;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class ListViewModelKt$doListSubscribe$1$1 extends PropertyReference1 {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ListViewModelKt$doListSubscribe$1$1();
    }

    public ListViewModelKt$doListSubscribe$1$1() {
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return WsConstants.KEY_PAYLOAD;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(ListViewModelKt.class, "ext_list_release");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getPayload(Lcom/bytedance/jedi/arch/ext/list/IListState;)Lcom/bytedance/jedi/arch/ext/list/Payload;";
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ListViewModelKt.getPayload((IListState) r100);
    }
}
