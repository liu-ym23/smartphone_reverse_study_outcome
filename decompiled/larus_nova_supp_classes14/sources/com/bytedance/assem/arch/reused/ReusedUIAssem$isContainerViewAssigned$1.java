package com.bytedance.assem.arch.reused;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, TextExtraStruct.TYPE_GROUP_CHAT})
final /* synthetic */ class ReusedUIAssem$isContainerViewAssigned$1 extends MutablePropertyReference0 {
    public ReusedUIAssem$isContainerViewAssigned$1(ReusedUIAssem r1) {
        super(r1);
    }

    public String getName() {
        return "containerView";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ReusedUIAssem.class);
    }

    public String getSignature() {
        return "getContainerView()Landroid/view/View;";
    }

    public Object get() {
        return ((ReusedUIAssem) ((CallableReference) this).receiver).r();
    }

    public void set(Object r2) {
        View r3 = (View) r2;
        ((ReusedUIAssem) ((CallableReference) this).receiver).h = r3;
    }
}
