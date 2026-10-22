package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j0 implements kn4.g.a {
    public final /* synthetic */ HalfScreenCardComment a;

    public final void b() {
    }

    public final void c() {
    }

    public j0(HalfScreenCardComment r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.TextView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(bo4.a r4) {
        CommentEditText r0 = this.a.M;
        ?? r1 = 0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r0 = null;
    L5:
        r0.G(r4);
        HalfScreenCardComment r5 = this.a;
        ?? r2 = r5.L0;
        CommentEditText r6 = r5.M;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
    L9:
        final HalfScreenCardComment r3 = this.a;
        r2.i(r1, true, new HalfScreenCardComment$bindAt$2$onSelectedAt$1(r3));
        return;
    L8:
        r1 = r6;
        goto L9
    }
}
