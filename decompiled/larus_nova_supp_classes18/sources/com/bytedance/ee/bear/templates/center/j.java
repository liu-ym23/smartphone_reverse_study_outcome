package com.bytedance.ee.bear.templates.center;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ TemplateCenterView a;

    public j(TemplateCenterView r1) {
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
        Boolean r4 = (Boolean) r3;
        TemplateCenterView r0 = this.a;
        int r1 = 0;
        if (r4 == null) goto L5;
        boolean r5 = r4.booleanValue();
    L6:
        AppCompatTextView r2 = r0.f;
        if (r2 == null) goto L13;
        if (r5 == true) goto L11;
        r1 = 8;
    L11:
        r2.setVisibility(r1);
        return;
    L13:
        return;
    L5:
        r5 = false;
        goto L6
    }
}
