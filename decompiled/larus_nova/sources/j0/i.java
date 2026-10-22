package j0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class i extends f<PointF> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PointF f496767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float[] f496768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f496769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PathMeasure f496770n;

    public i(List<? extends v0.a<PointF>> r100) {
        super(r100);
        this.f496767k = new PointF();
        this.f496768l = new float[2];
        if (r0.c.a.f535397a == false) goto L6;
        this.f496770n = new PathMeasure();
        return;
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
    public final Object h(v0.a r100, float r110) {
        h r101 = (h) r100;
        Path r102 = r101.f496765o;
        if (r102 == null) goto L19;
        v0.c<A> r103 = this.f496750f;
        if (r103 == 0) goto L9;
        return (PointF) r103.b(r101.f552278e, r101.f552279f.floatValue(), r101.f552275b, r101.f552276c, e(), r110, this.f496749e);
    L9:
        if (this.f496769m != r101) goto L11;
    L17:
        PathMeasure r104 = this.f496770n;
        r104.getPosTan(r110 * r104.getLength(), this.f496768l, null);
        PointF r105 = this.f496767k;
        float[] r111 = this.f496768l;
        r105.set(r111[0], r111[1]);
        return this.f496767k;
    L11:
        if (r0.c.a.f535397a == false) goto L15;
        PathMeasure r106 = this.f496770n;
        if (r106 == null) goto L15;
        r106.setPath(r102, false);
    L16:
        this.f496769m = r101;
    L15:
        this.f496770n = new PathMeasure(r102, false);
        goto L16
    L19:
        return (PointF) r100.f552275b;
    }
}
