package com.bytedance.android.shopping.new_cart.widgets;

import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements Runnable {
    public final /* synthetic */ ECCartErrorView a;

    public e(ECCartErrorView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.FrameLayout, com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2] */
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
    @Override // java.lang.Runnable
    public final void run() {
        ?? r0 = this.a.d;     // Catch: Throwable -> L11
        if (r0 == 0) goto L5;
        r0.setOuterHeight(r0.getHeight());     // Catch: Throwable -> L11
    L5:
        CartLinkedScrollViewV2 r1 = this.a.d;     // Catch: Throwable -> L11
        if (r1 == null) goto L14;
        CartGULView r2 = r1.getGul();     // Catch: Throwable -> L11
        if (r2 == null) goto L18;
        r2.i();     // Catch: Throwable -> L11
        com.bytedance.android.shopping.new_cart.utils.a.e(5, new b(r2));     // Catch: Throwable -> L11
        return;
    L18:
        return;
    L14:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
