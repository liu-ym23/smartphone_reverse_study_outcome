package oz6;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class i extends f<PointF> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PointF f527216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f527217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f527218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PathMeasure f527219j;

    public i(List<? extends xz6.a<PointF>> r100) {
        super(r100);
        this.f527216g = new PointF();
        this.f527217h = new float[2];
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
        h r102 = (h) r100;
        Path r103 = r102.f527215k;
        if (r103 == null) goto L15;
        xz6.c<A> r104 = this.f527200e;
        if (r104 == 0) goto L11;
        r102.f565531f.floatValue();
        T r105 = r102.f565527b;
        T r106 = r102.f565528c;
        d();
        PointF r107 = (PointF) r104.a(r105, r106);
        if (r107 == null) goto L11;
        return r107;
    L11:
        if (this.f527218i == r102) goto L13;
        this.f527219j = new PathMeasure(r103, false);
        this.f527218i = r102;
    L13:
        PathMeasure r108 = this.f527219j;
        r108.getPosTan(r101 * r108.getLength(), this.f527217h, null);
        PointF r109 = this.f527216g;
        float[] r110 = this.f527217h;
        r109.set(r110[0], r110[1]);
        return this.f527216g;
    L15:
        return (PointF) r100.f565527b;
    }
}
