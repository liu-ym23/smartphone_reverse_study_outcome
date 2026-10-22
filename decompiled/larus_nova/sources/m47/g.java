package m47;

import com.google.gson.JsonObject;
import java.util.Objects;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f511862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n47.a f511863b;

    public /* synthetic */ g(o r100, n47.a r101) {
        this.f511862a = r100;
        this.f511863b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [m47.l] */
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
    @Override // java.lang.Runnable
    public final void run() {
        final o r100 = this.f511862a;
        final n47.a r101 = this.f511863b;
        r100.f511890f = r101;
        com.bytedance.pia.core.utils.a<JsonObject> r102 = r100.f511889e;
        Objects.requireNonNull(r101);
        r102.c(new k(r101));
        r101.a(new l(r100));
    }
}
