package j0;

import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class b extends f<Integer> {
    public b(List<v0.a<Integer>> r100) {
        super(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // j0.a
    public final Object h(v0.a r110, float r111) {
        T r100 = r110.f552275b;
        if (r100 == 0) goto L12;
        if (r110.f552276c == 0) goto L12;
        int r101 = ((Integer) r100).intValue();
        int r102 = ((Integer) r110.f552276c).intValue();
        v0.c<A> r103 = this.f496750f;
        if (r103 == 0) goto L10;
        return (Integer) r103.b(r110.f552278e, r110.f552279f.floatValue(), Integer.valueOf(r101), Integer.valueOf(r102), r111, e(), this.f496749e);
    L10:
        return Integer.valueOf(u0.b.c(r111, r101, r102));
    L12:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
