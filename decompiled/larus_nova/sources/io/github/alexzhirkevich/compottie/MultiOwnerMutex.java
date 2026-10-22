package io.github.alexzhirkevich.compottie;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes41.dex */
public final class MultiOwnerMutex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutexImpl f490723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Object, d0> f490724b;

    public MultiOwnerMutex() {
        this.f490723a = kotlinx.coroutines.sync.b.a();
        this.f490724b = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v11, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v10, types: [java.lang.Object, kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [io.github.alexzhirkevich.compottie.d0] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.LinkedHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v4, types: [io.github.alexzhirkevich.compottie.d0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v6 */
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
    public final <T> Object a(Object r110, Function1<? super Continuation<? super T>, ? extends Object> r111, Continuation<? super T> r112) {
        if ((r112 instanceof MultiOwnerMutex$withLock$1) == false) goto L7;
        MultiOwnerMutex$withLock$1 r100 = (MultiOwnerMutex$withLock$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r103 = r100.label;
        if (r103 == 0) goto L30;
        if (r103 == 1) goto L29;
        if (r103 == 2) goto L24;
        if (r103 == 3) goto L19;
        if (r103 == 4) goto L18;
        if (r103 != 5) goto L17;
        kotlinx.coroutines.sync.a r114 = (kotlinx.coroutines.sync.a) r100.L$3;
        Throwable th10 = (Throwable) r100.L$2;
        d0 r104 = (d0) r100.L$1;
        Object r105 = r100.L$0;
        ResultKt.throwOnFailure(r113);
        ?? r106 = r105;
        ?? r107 = r104;
    L90:
        int r115 = r107.f490739b - 1;     // Catch: Throwable -> L75
        r107.f490739b = r115;     // Catch: Throwable -> L75
        if (r115 > 0) goto L72;
        this.f490724b.remove(r106);     // Catch: Throwable -> L75
    L72:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L75
        r114.unlock(null);
        throw th10;
    L75:
        th = move-exception;
        r114.unlock(null);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlinx.coroutines.sync.a r117 = (kotlinx.coroutines.sync.a) r100.L$3;
        Object r118 = r100.L$2;
        d0 r108 = (d0) r100.L$1;
        Object r109 = r100.L$0;
        ResultKt.throwOnFailure(r113);
        ?? r119 = r109;
    L85:
        int r120 = r108.f490739b - 1;     // Catch: Throwable -> L56
        r108.f490739b = r120;     // Catch: Throwable -> L56
        if (r120 > 0) goto L53;
        this.f490724b.remove(r119);     // Catch: Throwable -> L56
    L53:
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L56
        r117.unlock(null);
        return r118;
    L56:
        th = move-exception;
        r117.unlock(null);
        throw th;
    L19:
        kotlinx.coroutines.sync.a r122 = (kotlinx.coroutines.sync.a) r100.L$2;
        boolean r123 = (Function1<? super Continuation<? super T>, ? extends Object>) ((d0) r100.L$1);
        Object r124 = r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L22
        r103 = r124;
        r110 = r122;
        r111 = r123;
    L45:
        r110.unlock(r103);     // Catch: Throwable -> L59
        r117 = this.f490723a;
        r100.L$0 = r103;
        r100.L$1 = (Object) r111;
        r100.L$2 = r113;
        r100.L$3 = r117;
        r100.label = 4;
        if (r117.a(null, r100) != r102) goto L49;
        return r102;
    L49:
        r108 = (??[OBJECT, ARRAY]) r111;
        r118 = r113;
        r119 = r103;
        goto L85
    L24:
        kotlinx.coroutines.sync.a r125 = (kotlinx.coroutines.sync.a) r100.L$3;
        d0 r126 = (d0) r100.L$2;
        Function1 r127 = (Function1) r100.L$1;
        Object r128 = r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L27
        ?? r129 = r127;
        ?? r130 = r128;
        ?? r131 = r125;
        ?? r132 = r126;
    L42:
        r100.L$0 = r130;     // Catch: Throwable -> L22
        r100.L$1 = r132;     // Catch: Throwable -> L22
        r100.L$2 = r131;     // Catch: Throwable -> L22
        r100.L$3 = null;     // Catch: Throwable -> L22
        r100.label = 3;     // Catch: Throwable -> L22
        r113 = r129.invoke(r100);     // Catch: Throwable -> L22
        r103 = r130;
        r110 = r131;
        r111 = r132;
        if (r113 != r102) goto L45;
        return r102;
    L27:
        th = move-exception;
        ?? r133 = r126;
        th10 = th;
        ?? r134 = r128;
    L65:
        MutexImpl r135 = this.f490723a;
        r100.L$0 = r134;
        r100.L$1 = r133;
        r100.L$2 = th10;
        r100.L$3 = r135;
        r100.label = 5;
        if (r135.a(null, r100) != r102) goto L68;
        return r102;
    L68:
        r106 = r134;
        r114 = r135;
        r107 = r133;
        goto L90
    L29:
        kotlinx.coroutines.sync.a r136 = (kotlinx.coroutines.sync.a) r100.L$2;
        boolean r137 = (Function1<? super Continuation<? super T>, ? extends Object>) ((Function1) r100.L$1);
        Object r138 = r100.L$0;
        ResultKt.throwOnFailure(r113);
        kotlinx.coroutines.sync.a r139 = r136;
        r134 = r138;
        ?? r140 = r137;
    L81:
        ?? r141 = (LinkedHashMap) this.f490724b;     // Catch: Throwable -> L78
        Object r142 = r141.get(r134);     // Catch: Throwable -> L78
        if (r142 != null) goto L36;
        r142 = new d0(0);     // Catch: Throwable -> L78
        r141.put(r134, r142);     // Catch: Throwable -> L78
    L36:
        ((d0) r142).f490739b++;     // Catch: Throwable -> L78
        r133 = (d0) r142;     // Catch: Throwable -> L78
        r139.unlock(null);
        ?? r143 = r133.f490738a;     // Catch: Throwable -> L64
        r100.L$0 = r134;     // Catch: Throwable -> L64
        r100.L$1 = r140;     // Catch: Throwable -> L64
        r100.L$2 = r133;     // Catch: Throwable -> L64
        r100.L$3 = r143;     // Catch: Throwable -> L64
        r100.label = 2;     // Catch: Throwable -> L64
        if (r143.a(r134, r100) != r102) goto L41;
        return r102;
    L41:
        r130 = r134;
        r131 = r143;
        r129 = r140;
        r132 = r133;
    L64:
        th10 = th;
    L78:
        th = move-exception;
        r139.unlock(null);
        throw th;
    L30:
        ResultKt.throwOnFailure(r113);
        r139 = this.f490723a;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r139;
        r100.label = 1;
        r134 = r110;
        r140 = r111;
        if (r139.a(null, r100) != r102) goto L81;
        return r102;
    L59:
        th = move-exception;
        r133 = r111;
        th10 = th;
        r134 = r103;
    L22:
        th = move-exception;
        r110.unlock(r103);     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L7:
        r100 = new MultiOwnerMutex$withLock$1(this, r112);
        goto L8
    }
}
