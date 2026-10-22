package j0;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class j extends f<PointF> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PointF f496771k;

    public j(List<v0.a<PointF>> r100) {
        super(r100);
        this.f496771k = new PointF();
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
        T r101 = r110.f552276c;
        if (r101 == 0) goto L12;
        PointF r102 = (PointF) r100;
        PointF r103 = (PointF) r101;
        v0.c<A> r104 = this.f496750f;
        if (r104 != 0) goto L13;
        PointF r112 = this.f496771k;
        float r105 = r102.x;
        float r106 = r105 + ((r103.x - r105) * r111);
        float r107 = r102.y;
        r112.set(r106, r107 + (r111 * (r103.y - r107)));
        return this.f496771k;
    L13:
        return (PointF) r104.b(r110.f552278e, r110.f552279f.floatValue(), r102, r103, r111, e(), this.f496749e);
    L12:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
