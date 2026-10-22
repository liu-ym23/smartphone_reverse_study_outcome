package zb9;

import com.baidu.platform.comapi.map.MapController;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements u<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a<Object> f571181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d<Object> f571182b;

    @Override // zb9.u
    public final void a(k<i<Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        a<Object> r101 = this.f571181a;
        String r102 = this.f571182b.a();
        Object r103 = r101.f571166d;
        monitor-enter(r103);
        r101.f571168f.put(r102, r101.f571163a.d(CollectionsKt.emptyList(), r100.f571195a, r101.f571170h));     // Catch: Throwable -> L17
        r101.f571167e.put(r102, Boolean.valueOf(r100.f571196b));     // Catch: Throwable -> L17
        String r104 = r100.f571197c;     // Catch: Throwable -> L17
        if (r104 == null) goto L7;
        r101.f571169g.put(r102, r104);     // Catch: Throwable -> L17
    L8:
        long r105 = r101.f571171i + 1;     // Catch: Throwable -> L17
        r101.f571171i = r105;     // Catch: Throwable -> L17
        if (r101.f571177o == false) goto L11;
        a.C8438a<Object> r106 = null;
    L12:
        monitor-exit(r103);
        if (r106 == null) goto L22;
        r101.i(r106);
        return;
    L22:
        return;
    L11:
        r106 = new a.C8438a(r105, r101.c());     // Catch: Throwable -> L17
        goto L12
    L7:
        r101.f571169g.remove(r102);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
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
    @Override // zb9.u
    public final void b(i<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        a<Object> r101 = this.f571181a;
        String r102 = this.f571182b.a();
        Object r103 = r101.f571166d;
        monitor-enter(r103);
        Object r104 = r101.f571163a.c(r100);     // Catch: Throwable -> L49
        List<i<Object>> r105 = (List) ((LinkedHashMap) r101.f571168f).get(r102);     // Catch: Throwable -> L49
        if (r105 != null) goto L7;
        r105 = CollectionsKt.emptyList();     // Catch: Throwable -> L49
    L7:
        List<i<Object>> r106 = r105;     // Catch: Throwable -> L49
        if ((r106 instanceof Collection) == true) goto L10;
    L12:
        Iterator r107 = r106.iterator();     // Catch: Throwable -> L49
    L14:
        if (r107.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(r101.f571163a.c((i) r107.next()), r104) == false) goto L14;
        boolean r108 = false;
    L19:
        if (r108 == false) goto L22;
        monitor-exit(r103);
        return;
    L22:
        r101.f571168f.put(r102, r101.f571163a.d(r105, CollectionsKt.listOf(r100), r101.f571170h));     // Catch: Throwable -> L49
        r101.f571171i++;     // Catch: Throwable -> L49
        Ref.ObjectRef r109 = new Ref.ObjectRef();     // Catch: Throwable -> L49
        Iterator<T> r110 = r101.f571165c.iterator();     // Catch: Throwable -> L49
    L24:
        if (r110.hasNext() == false) goto L43;
        d r111 = (d) r110.next();     // Catch: Throwable -> L49
        List r112 = (List) ((LinkedHashMap) r101.f571168f).get(r111.a());     // Catch: Throwable -> L49
        if (r112 == null) goto L24;
        Iterator r113 = r112.iterator();     // Catch: Throwable -> L49
    L29:
        if (r113.hasNext() == false) goto L33;
        Object r114 = r113.next();     // Catch: Throwable -> L49
        if (Intrinsics.areEqual(r101.f571163a.c((i) r114), r104) == false) goto L29;
    L34:
        i<Object> r115 = (i) r114;     // Catch: Throwable -> L49
        if (r115 == null) goto L24;
        i<Object> r116 = (i) r109.element;     // Catch: Throwable -> L49
        T r117 = r115;
        if (r116 == null) goto L42;
        i<Object> r118 = r101.f571163a.b((i<ITEM>) r116, r115);     // Catch: Throwable -> L49
        if (r118 != null) goto L41;
        r117 = r115;
        goto L42
    L41:
        r117 = r118;
    L42:
        r109.element = r117;     // Catch: Throwable -> L49
        goto L24
    L33:
        r114 = null;
        goto L34
    L43:
        i<Object> r119 = (i) r109.element;     // Catch: Throwable -> L49
        monitor-exit(r103);
        if (r119 == null) goto L68;
        r101.f571172j.c(r119);
        return;
    L68:
        return;
    L18:
        r108 = true;
        goto L19
    L10:
        if (r106.isEmpty() == false) goto L12;
    L49:
        th = move-exception;
        throw th;
    }

    public b(a<Object> r100, d<Object> r101) {
        this.f571181a = r100;
        this.f571182b = r101;
    }
}
