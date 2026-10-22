package j0;

import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class k extends f<v0.d> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final v0.d f496772k;

    public k(List<v0.a<v0.d>> r100) {
        super(r100);
        if (r0.c.a.f535397a == false) goto L5;
        this.f496772k = new v0.d();
        return;
    L5:
        this.f496772k = null;
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
        if (r100 == 0) goto L17;
        T r101 = r110.f552276c;
        if (r101 == 0) goto L17;
        v0.d r102 = (v0.d) r100;
        v0.d r103 = (v0.d) r101;
        v0.c<A> r104 = this.f496750f;
        if (r104 == 0) goto L10;
        return (v0.d) r104.b(r110.f552278e, r110.f552279f.floatValue(), r102, r103, r111, e(), this.f496749e);
    L10:
        if (r0.c.a.f535397a == false) goto L14;
        v0.d r112 = this.f496772k;
        if (r112 == null) goto L14;
        float r105 = r102.f552293a;
        float r106 = r103.f552293a;
        u0.e.a r107 = u0.e.f548111a;
        float r108 = r105 + ((r106 - r105) * r111);
        float r109 = r102.f552294b;
        float r113 = r109 + (r111 * (r103.f552294b - r109));
        r112.f552293a = r108;
        r112.f552294b = r113;
        return r112;
    L14:
        float r114 = r102.f552293a;
        float r115 = r103.f552293a;
        u0.e.a r116 = u0.e.f548111a;
        float r117 = r114 + ((r115 - r114) * r111);
        float r118 = r102.f552294b;
        return new v0.d(r117, r118 + (r111 * (r103.f552294b - r118)));
    L17:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
