package j0;

import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class e extends f<Integer> {
    public e(List<v0.a<Integer>> r100) {
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
        v0.c<A> r101 = this.f496750f;
        if (r101 != 0) goto L13;
        int r102 = ((Integer) r100).intValue();
        int r112 = ((Integer) r110.f552276c).intValue();
        u0.e.a r103 = u0.e.f548111a;
        return Integer.valueOf((int) (r102 + (r111 * (r112 - r102))));
    L13:
        return (Integer) r101.b(r110.f552278e, r110.f552279f.floatValue(), r110.f552275b, r110.f552276c, r111, e(), this.f496749e);
    L12:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
