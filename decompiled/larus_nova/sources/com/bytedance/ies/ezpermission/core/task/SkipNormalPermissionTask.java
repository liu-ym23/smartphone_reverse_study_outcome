package com.bytedance.ies.ezpermission.core.task;

import android.content.Context;
import com.bytedance.ies.ezpermission.EzPermission;
import com.bytedance.ies.ezpermission.core.PermissionResultListener;
import com.bytedance.ies.ezpermission.core.e;
import com.bytedance.ies.ezpermission.core.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class SkipNormalPermissionTask extends BasePermissionTask {
    public SkipNormalPermissionTask(com.bytedance.ies.ezpermission.core.d r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionContext");
        super(r100);
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
    @Override // com.bytedance.ies.ezpermission.core.task.BasePermissionTask
    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof SkipNormalPermissionTask$run$1) == false) goto L7;
        SkipNormalPermissionTask$run$1 r100 = (SkipNormalPermissionTask$run$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L60:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SkipNormalPermissionTask r104 = (SkipNormalPermissionTask) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L22:
        Object r112 = null;
        r100.L$0 = null;
        r100.label = 2;
        Context r105 = r104.f248588b.getContext();
        e r106 = r104.f248588b.b();
        c r107 = r104.f248588b.g();
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r108 = r107.f248590b;
        Iterator<List<com.bytedance.ies.ezpermission.core.permissions.a>> r109 = r108.iterator();
    L24:
        if (r109.hasNext() == false) goto L35;
        List<com.bytedance.ies.ezpermission.core.permissions.a> r113 = r109.next();
        Iterator<com.bytedance.ies.ezpermission.core.permissions.a> r114 = r113.iterator();
    L27:
        if (r114.hasNext() == false) goto L32;
        com.bytedance.ies.ezpermission.core.permissions.a r115 = r114.next();
        if (r115.c(r105) == false) goto L27;
        r114.remove();
        r107.f248589a.add(r115);
        goto L27
    L32:
        if (r113.isEmpty() == false) goto L24;
        r109.remove();
        goto L24
    L35:
        if (r108.isEmpty() == true) goto L37;
    L53:
        r112 = r104.a(r100);
        if (r112 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L57;
        r112 = Unit.INSTANCE;
    L57:
        if (r112 != r102) goto L60;
        return r102;
    L37:
        if (r107.f248591c.isEmpty() == false) goto L53;
        n46.a.f517060b.getClass();
        Intrinsics.checkNotNullParameter("No permissions to be request, callback now", "msg");
        PermissionResultListener r116 = r106.f248579k;
        if (r116 == null) goto L50;
        boolean r117 = r107.f248592d.isEmpty();
        List<com.bytedance.ies.ezpermission.core.permissions.a> r118 = r107.f248589a;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator<T> r120 = r118.iterator();
    L42:
        if (r120.hasNext() == false) goto L44;
        r119.add(((com.bytedance.ies.ezpermission.core.permissions.a) r120.next()).d());
        goto L42
    L44:
        List<com.bytedance.ies.ezpermission.core.permissions.a> r121 = r107.f248592d;
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator<T> r123 = r121.iterator();
    L46:
        if (r123.hasNext() == false) goto L48;
        r122.add(((com.bytedance.ies.ezpermission.core.permissions.a) r123.next()).d());
        goto L46
    L48:
        r116.onResult(r117, r119, r122);
        r112 = Unit.INSTANCE;
    L50:
        if (r112 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L57;
        r112 = Unit.INSTANCE;
        goto L57
    L16:
        ResultKt.throwOnFailure(r111);
        e r124 = this.f248588b.b();
        EzPermission.INSTANCE.getGlobalConfig();
        if (r124.f248575g == null) goto L21;
        r100.L$0 = this;
        r100.label = 1;
        if (c(r100) != r102) goto L21;
        return r102;
    L21:
        r104 = this;
    L7:
        r100 = new SkipNormalPermissionTask$run$1(this, r110);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r12v5, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, com.bytedance.ies.ezpermission.core.permissions.a] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.bytedance.ies.ezpermission.core.a] */
    public final Object c(Continuation<? super Unit> r110) {
        if ((r110 instanceof SkipNormalPermissionTask$makeSkipNormalPermission$1) == false) goto L7;
        SkipNormalPermissionTask$makeSkipNormalPermission$1 r100 = (SkipNormalPermissionTask$makeSkipNormalPermission$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        Object r105 = null;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r100.L$5;
        Iterator<List<com.bytedance.ies.ezpermission.core.permissions.a>> r107 = (Iterator) r100.L$4;
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r108 = (List) r100.L$3;
        Ref.ObjectRef r111 = (Ref.ObjectRef) r100.L$2;
        Ref.ObjectRef r112 = (Ref.ObjectRef) r100.L$1;
        c r113 = (c) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L48:
        boolean r109 = ((Boolean) r102).booleanValue();
    L49:
        Iterator<List<com.bytedance.ies.ezpermission.core.permissions.a>> r114 = r107;
        Ref.ObjectRef r115 = r112;
        if (r109 == true) goto L53;
        r113.f248592d.addAll((List) r106.element);
        r114.remove();
    L53:
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r116 = r108;
        Ref.ObjectRef r117 = r111;
        c r118 = r113;
        Iterator<List<com.bytedance.ies.ezpermission.core.permissions.a>> r119 = r114;
        r105 = null;
    L18:
        if (r119.hasNext() == false) goto L54;
        Ref.ObjectRef r120 = new Ref.ObjectRef();
        ?? r121 = (List) r119.next();
        r120.element = r121;
        if (((f) r115.element) == null) goto L34;
        c r122 = r118;
        Ref.ObjectRef r123 = r115;
        Iterator r124 = ((List) r121).iterator();
        Ref.ObjectRef r125 = r117;
        Ref.ObjectRef r126 = r120;
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r127 = r116;
    L23:
        if (r124.hasNext() == false) goto L33;
        Ref.ObjectRef r128 = new Ref.ObjectRef();
        r128.element = (com.bytedance.ies.ezpermission.core.permissions.a) r124.next();
        r100.L$0 = r122;
        r100.L$1 = r123;
        r100.L$2 = r125;
        r100.L$3 = r127;
        r100.L$4 = r119;
        r100.L$5 = r126;
        r100.L$6 = r124;
        r100.L$7 = r128;
        r100.label = 1;
        SafeContinuation r129 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        f r130 = (f) r123.element;
        ((com.bytedance.ies.ezpermission.core.permissions.a) r128.element).d();
        r130.beforeRequest();
        r102 = r129.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L27:
        if (r102 != r103) goto L30;
        return r103;
    L30:
        if (((Boolean) r102).booleanValue() == true) goto L32;
        r122.f248592d.add((com.bytedance.ies.ezpermission.core.permissions.a) r128.element);
        r124.remove();
        goto L23
    L33:
        r106 = r126;
        r107 = r119;
        r108 = r127;
        r111 = r125;
        r112 = r123;
        r113 = r122;
    L35:
        r109 = !((List) r106.element).isEmpty();
        if (r109 == false) goto L50;
        if (((com.bytedance.ies.ezpermission.core.a) r111.element) == null) goto L49;
    L39:
        r100.L$0 = r113;
        r100.L$1 = r112;
        r100.L$2 = r111;
        r100.L$3 = r108;
        r100.L$4 = r107;
        r100.L$5 = r106;
        r100.L$6 = r105;
        r100.L$7 = r105;
        r100.label = 2;
        SafeContinuation r131 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        com.bytedance.ies.ezpermission.core.a r132 = (com.bytedance.ies.ezpermission.core.a) r111.element;
        List r133 = (List) r106.element;
        ArrayList r134 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r133, 10));
        Iterator r135 = r133.iterator();
    L41:
        if (r135.hasNext() == false) goto L43;
        r134.add(((com.bytedance.ies.ezpermission.core.permissions.a) r135.next()).d());
        goto L41
    L43:
        r132.beforeRequest();
        r102 = r131.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L46:
        if (r102 != r103) goto L48;
        return r103;
    L57:
        if (r102 != r103) goto L48;
        goto L48
    L34:
        r113 = r118;
        r106 = r120;
        r112 = r115;
        r107 = r119;
        r111 = r117;
        r108 = r116;
        goto L35
    L54:
        n46.a r136 = n46.a.f517060b;
        String r137 = "After skip normal permission \n   normal:" + r116 + "\n    skip:" + r118.f248592d;
        r136.getClass();
        n46.a.c(r137);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r128 = (Ref.ObjectRef) r100.L$7;
        r124 = (Iterator) r100.L$6;
        r126 = (Ref.ObjectRef) r100.L$5;
        r119 = (Iterator) r100.L$4;
        r127 = (List) r100.L$3;
        r125 = (Ref.ObjectRef) r100.L$2;
        r123 = (Ref.ObjectRef) r100.L$1;
        r122 = (c) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L30
    L16:
        ResultKt.throwOnFailure(r102);
        e r138 = this.f248588b.b();
        r118 = this.f248588b.g();
        r115 = new Ref.ObjectRef();
        EzPermission.INSTANCE.getGlobalConfig();
        r115.element = null;
        r117 = new Ref.ObjectRef();
        r117.element = r138.f248575g;
        r116 = r118.f248590b;
        r119 = r116.iterator();
    L7:
        r100 = new SkipNormalPermissionTask$makeSkipNormalPermission$1(this, r110);
        goto L8
    }
}
