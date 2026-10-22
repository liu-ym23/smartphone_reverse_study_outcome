package j0;

import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class c extends f<Float> {
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
    public final float l() {
        v0.a<Float> r100 = b();
        float r101 = d();
        if (r100.f552275b == null) goto L20;
        if (r100.f552276c == null) goto L20;
        v0.c<A> r102 = this.f496750f;
        if (r102 == 0) goto L12;
        Float r103 = (Float) r102.b(r100.f552278e, r100.f552279f.floatValue(), r100.f552275b, r100.f552276c, r101, e(), this.f496749e);
        if (r103 == null) goto L12;
        return r103.floatValue();
    L12:
        if (r100.f552280g != (-3987645.8f)) goto L14;
        r100.f552280g = r100.f552275b.floatValue();
    L14:
        float r104 = r100.f552280g;
        if (r100.f552281h != (-3987645.8f)) goto L17;
        r100.f552281h = r100.f552276c.floatValue();
    L17:
        float r105 = r100.f552281h;
        u0.e.a r106 = u0.e.f548111a;
        return r104 + (r101 * (r105 - r104));
    L20:
        throw new IllegalStateException("Missing values for keyframe.");
    }

    public c(List<v0.a<Float>> r100) {
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
        float r102 = ((Float) r100).floatValue();
        float r112 = ((Float) r110.f552276c).floatValue();
        u0.e.a r103 = u0.e.f548111a;
        return Float.valueOf(r102 + (r111 * (r112 - r102)));
    L13:
        return (Float) r101.b(r110.f552278e, r110.f552279f.floatValue(), r110.f552275b, r110.f552276c, r111, e(), this.f496749e);
    L12:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
