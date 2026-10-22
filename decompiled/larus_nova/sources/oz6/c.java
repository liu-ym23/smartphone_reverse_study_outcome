package oz6;

import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends f<Float> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Float f527202g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Float f527203h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Float f527204i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Float f527205j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Float f527206k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Float f527207l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Float f527208m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Float f527209n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Float f527210o = null;

    static {
        f527202g = Float.valueOf(0.0f);
        f527203h = Float.valueOf(1.0f);
        f527204i = Float.valueOf(30.0f);
        f527205j = Float.valueOf(35.0f);
        f527206k = Float.valueOf(60.0f);
        f527207l = Float.valueOf(90.0f);
        f527208m = Float.valueOf(100.0f);
        f527209n = Float.valueOf(180.0f);
        f527210o = Float.valueOf(197.0f);
    }

    public c(List<xz6.a<Float>> r100) {
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
        if (r100.f565527b == 0) goto L42;
        if (r100.f565528c == 0) goto L42;
        xz6.c<A> r102 = this.f527200e;
        if (r102 == 0) goto L12;
        r100.f565531f.floatValue();
        T r103 = r100.f565527b;
        T r104 = r100.f565528c;
        d();
        Float r105 = (Float) r102.a(r103, r104);
        if (r105 == null) goto L12;
        return r105;
    L12:
        float r106 = ((Float) r100.f565527b).floatValue();
        float r107 = r106 + (r101 * (((Float) r100.f565528c).floatValue() - r106));
        if (r107 != 0.0f) goto L16;
        return f527202g;
    L16:
        if (r107 != 1.0f) goto L19;
        return f527203h;
    L19:
        if (r107 != 30.0f) goto L22;
        return f527204i;
    L22:
        if (r107 != 35.0f) goto L25;
        return f527205j;
    L25:
        if (r107 != 60.0f) goto L28;
        return f527206k;
    L28:
        if (r107 != 90.0f) goto L31;
        return f527207l;
    L31:
        if (r107 != 100.0f) goto L34;
        return f527208m;
    L34:
        if (r107 != 180.0f) goto L37;
        return f527209n;
    L37:
        if (r107 != 197.0f) goto L40;
        return f527210o;
    L40:
        return Float.valueOf(r107);
    L42:
        if (r100.f565526a == null) goto L46;
        throw new IllegalStateException("Missing values for keyframe. and " + r100.toString() + ".Composition is" + r100.f565526a.toString());
    L46:
        throw new IllegalStateException("Missing values for keyframe. and " + r100.toString());
    }
}
