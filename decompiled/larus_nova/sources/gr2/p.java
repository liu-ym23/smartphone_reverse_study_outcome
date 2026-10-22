package gr2;

import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import fr2.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class p extends p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ti6.j f482327b;

    @Override // fr2.p0, xh6.c
    public final Object getReal() {
        return this.f482327b;
    }

    public p(ti6.j r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f482327b = r100;
    }

    @Override // fr2.o
    public final boolean S(m r100, k r101) {
        boolean r102 = r100 instanceof aj6.d;
        Object r103 = r100;
        if (r102 == true) goto L5;
        r103 = null;
    L5:
        aj6.d r104 = (aj6.d) r103;
        boolean r105 = r101 instanceof aj6.b;
        Object r106 = r101;
        if (r105 == true) goto L8;
        r106 = null;
    L8:
        aj6.b r107 = (aj6.b) r106;
        if (r104 == null) goto L13;
        if (r107 != null) goto L12;
        return false;
    L12:
        return this.f482327b.b(r104, r107);
    L13:
        return false;
    }

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
    @Override // fr2.o
    public final String L3(int r100, int r101, List<? extends IRegion> r102) {
        Intrinsics.checkNotNullParameter(r102, "regions");
        ti6.j r103 = this.f482327b;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L13;
        Object r106 = ((IRegion) r105.next()).getReal();
        if ((r106 instanceof ti6.f) == true) goto L8;
        r106 = null;
    L8:
        ti6.f r107 = (ti6.f) r106;
        if (r107 != null) goto L11;
        r107 = new ti6.f();
    L11:
        r104.add(r107);
        goto L4
    L13:
        return r103.a(r100, r101, r104);
    }
}
