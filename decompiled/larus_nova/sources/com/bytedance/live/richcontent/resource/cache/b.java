package com.bytedance.live.richcontent.resource.cache;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f255785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f255786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<V, Integer> f255787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f255788d;

    public static final class a extends com.bytedance.live.richcontent.resource.cache.a<K, c<V>> {
        public a(int r100) {
            super(r100);
        }

        @Override // com.bytedance.live.richcontent.resource.cache.a
        public final int g(Object r100) {
            c r101 = (c) r100;
            Intrinsics.checkNotNullParameter(r101, "value");
            return r101.f255790b;
        }
    }

    public final e c() {
        e r100 = this.f255786b;
        a r101 = this.f255788d;
        monitor-enter(r101);
        int r102 = r101.f255778a.size();     // Catch: Throwable -> L8
        monitor-exit(r101);
        r100.f255795a = r102;
        e r103 = this.f255786b;
        r103.f255796b = this.f255788d.f();
        e r104 = this.f255786b;
        r104.f255797c = this.f255788d.d();
        e r105 = this.f255786b;
        r105.f255798d = this.f255788d.b();
        e r106 = this.f255786b;
        r106.f255799e = this.f255788d.c();
        e r107 = this.f255786b;
        r107.f255800f = this.f255788d.a();
        return this.f255786b;
    L8:
        th = move-exception;
        throw th;
    }

    public final V b(K r100) {
        a r101 = this.f255788d;
        monitor-enter(r101);
        V r102 = r101.f255778a.get(r100);     // Catch: Throwable -> L16
        if (r102 == null) goto L9;
        r101.f255783f++;     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
    L12:
        c r103 = r102;
        if (r103 != null) goto L15;
        return null;
    L15:
        return (V) r103.f255789a;
    L9:
        r101.f255784g++;     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        r102 = (V) null;
    L16:
        th = move-exception;
        throw th;
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
    public final void a(K r100, V r101) {
        a r102 = this.f255788d;
        c r103 = new c(r101, this.f255787c.invoke(r101).intValue());
        r102.getClass();
        monitor-enter(r102);
        r102.f255781d++;     // Catch: Throwable -> L10
        r102.f255779b += r102.e(r100, r103);     // Catch: Throwable -> L10
        V r104 = r102.f255778a.put(r100, r103);     // Catch: Throwable -> L10
        if (r104 == null) goto L7;
        r102.f255779b -= r102.e(r100, r104);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L10
        r102.h(r102.f255780c);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r100, ResourceCache$CacheType r101, ResourceCache$ReferenceType r102, int r103, Function1<? super V, Integer> r104) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "cacheType");
        Intrinsics.checkNotNullParameter(r102, "referenceType");
        Intrinsics.checkNotNullParameter(r104, "getEntitySize");
        d r105 = new d(r100, r101, r102, r103);
        this.f255785a = r105;
        this.f255786b = new e();
        this.f255787c = r104;
        this.f255788d = new a(r105.f255794d);
    }
}
