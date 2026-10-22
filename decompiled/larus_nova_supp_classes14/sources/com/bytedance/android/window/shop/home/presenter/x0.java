package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.ec.window.base.floatlayout.WindowFloatLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x0<T> implements Observer {
    public final /* synthetic */ ECWindowFloatLayerPresenter a;

    public x0(ECWindowFloatLayerPresenter r1) {
        this.a = r1;
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
    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        ECWindowFloatLayerPresenter r5 = this.a;
        int r0 = ECWindowFloatLayerPresenter.r;
        if (r5.T() == false) goto L5;
        int r1 = 0;
    L6:
        WindowFloatLayout r2 = r5.o;
        if (r2 == null) goto L9;
        r2.setVisibility(r1);
    L9:
        WindowFloatLayout r6 = r5.n;
        if (r6 == null) goto L13;
        r6.setVisibility(r1);
        return;
    L13:
        return;
    L5:
        r1 = 4;
        goto L6
    }
}
