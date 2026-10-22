package oz6;

import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends f<Integer> {
    public e(List<xz6.a<Integer>> r100) {
        super(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // oz6.a
    public final Object f(xz6.a r100, float r101) {
        if (r100.f565527b == 0) goto L14;
        if (r100.f565528c == 0) goto L14;
        xz6.c<A> r102 = this.f527200e;
        if (r102 == 0) goto L11;
        r100.f565531f.floatValue();
        T r103 = r100.f565527b;
        T r104 = r100.f565528c;
        d();
        Integer r105 = (Integer) r102.a(r103, r104);
        if (r105 == null) goto L11;
        return r105;
    L11:
        int r106 = ((Integer) r100.f565527b).intValue();
        return Integer.valueOf((int) (r106 + (r101 * (((Integer) r100.f565528c).intValue() - r106))));
    L14:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
