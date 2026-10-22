package com.bytedance.ies.sve_list;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class ListWidget$onUpdate$1 extends PropertyReference1 {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ListWidget$onUpdate$1();
    }

    public ListWidget$onUpdate$1() {
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "list";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(b.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getList()Ljava/util/List;";
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ((b) r100).f248727a;
    }
}
