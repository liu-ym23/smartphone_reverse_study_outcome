package com.bytedance.assem.arch.reused;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, TextExtraStruct.TYPE_GROUP_CHAT})
final /* synthetic */ class ReusedUISlotAssem$onInActive$1 extends MutablePropertyReference0 {
    public ReusedUISlotAssem$onInActive$1(ReusedUISlotAssem r1) {
        super(r1);
    }

    public String getName() {
        return "contentView";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ReusedUISlotAssem.class);
    }

    public String getSignature() {
        return "getContentView()Landroid/view/View;";
    }

    public Object get() {
        View r0 = ((ReusedUISlotAssem) ((CallableReference) this).receiver).A;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        return r0;
    }

    public void set(Object r2) {
        View r3 = (View) r2;
        ((ReusedUISlotAssem) ((CallableReference) this).receiver).A = r3;
    }
}
