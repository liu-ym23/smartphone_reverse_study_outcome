package eh7;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements com.bytedance.timon.result.a<String[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<String> f472662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f472663b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.timon.result.a
    public final void invoke(String[] r100) {
        String[] r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        if (this.f472662a.size() != r101.length) goto L11;
        Function3<Boolean, String[], String[], Unit> r102 = this.f472663b.f472664a.f472669e;
        if (r102 == 0) goto L18;
        Boolean r103 = Boolean.TRUE;
        Object[] r104 = this.f472662a.toArray(new String[0]);
        if (r104 == null) goto L10;
        r102.invoke(r103, r104, new String[0]);
        return;
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L18:
        return;
    L11:
        this.f472662a.removeAll(ArraysKt.toSet(r101));
        Function3<Boolean, String[], String[], Unit> r105 = this.f472663b.f472664a.f472669e;
        if (r105 == 0) goto L20;
        Boolean r106 = Boolean.FALSE;
        Object[] r107 = this.f472662a.toArray(new String[0]);
        if (r107 == null) goto L17;
        r105.invoke(r106, r101, r107);
        return;
    L17:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public b(List<String> r100, c r101) {
        this.f472662a = r100;
        this.f472663b = r101;
    }
}
