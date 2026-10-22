package com.bytedance.assem.arch.core;

import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, TextExtraStruct.TYPE_GROUP_CHAT})
final /* synthetic */ class Assem$checkSupervisorPrepared$1 extends MutablePropertyReference0 {
    public Assem$checkSupervisorPrepared$1(Assem r1) {
        super(r1);
    }

    public String getName() {
        return "supervisor";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Assem.class);
    }

    public String getSignature() {
        return "getSupervisor()Lcom/bytedance/assem/arch/core/AssemSupervisor;";
    }

    public Object get() {
        return ((Assem) ((CallableReference) this).receiver).j();
    }

    public void set(Object r2) {
        AssemSupervisor r3 = (AssemSupervisor) r2;
        ((Assem) ((CallableReference) this).receiver).d = r3;
    }
}
