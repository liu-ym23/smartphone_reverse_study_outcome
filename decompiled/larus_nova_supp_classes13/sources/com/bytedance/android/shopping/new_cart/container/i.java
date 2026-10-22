package com.bytedance.android.shopping.new_cart.container;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements View.OnLayoutChangeListener {
    public final /* synthetic */ CartDialogFragment a;
    public final /* synthetic */ View b;

    public i(CartDialogFragment r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        CartDialogFragment r10 = this.a;
        UserInteractFrameLayout r11 = r10.D;
        if (r11 == null) goto L6;
        r11.setTranslationY(r10.Z90());
        return;
    }
}
