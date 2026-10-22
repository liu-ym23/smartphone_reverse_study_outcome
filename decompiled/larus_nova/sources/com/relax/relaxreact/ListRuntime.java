package com.relax.relaxreact;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class ListRuntime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, Map<Long, SnapshotInstance>> f405413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Long, Map<String, Map<Long, SnapshotInstance>>> f405414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s0 f405415c;

    public ListRuntime() {
        this.f405413a = new LinkedHashMap();
        this.f405414b = new LinkedHashMap();
        this.f405415c = new s0();
    }

    public final void e(long r100) {
        if (com.bytedance.rts.kmp.foundation.j.d(this.f405413a, Long.valueOf(r100)) == true) goto L6;
        com.bytedance.rts.kmp.foundation.j.e(this.f405413a, Long.valueOf(r100), new LinkedHashMap());
    L6:
        if (com.bytedance.rts.kmp.foundation.j.d(this.f405414b, Long.valueOf(r100)) == true) goto L9;
        com.bytedance.rts.kmp.foundation.j.e(this.f405414b, Long.valueOf(r100), new LinkedHashMap());
        return;
    }

    public final boolean g(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "holderObject");
        SnapshotInstance r101 = (SnapshotInstance) r100;
        s0 r102 = this.f405415c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "parent");
        Map<Long, j0> r103 = r102.f405565a;
        if (r103 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNull(r103);
        return com.bytedance.rts.kmp.foundation.j.d(r103, Long.valueOf(r101.f405437a));
    }

    public final void j(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        s0 r101 = this.f405415c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "cb");
        Map<Long, j0> r102 = r101.f405565a;
        r101.f405565a = null;
        r100.invoke();     // Catch: Throwable -> L6
        r101.f405565a = r102;
        return;
    L6:
        th = move-exception;
        r101.f405565a = r102;
        throw th;
    }

    public final void c(final z0 r110, Object r111) {
        Intrinsics.checkNotNullParameter(r110, "renderer");
        Intrinsics.checkNotNullParameter(r111, "holderObject");
        SnapshotInstance r112 = (SnapshotInstance) r111;
        if (r112.f405441e != null) goto L5;
        return;
    L5:
        final p r100 = r112.f405440d;
        if (r100 != null) goto L8;
        return;
    L8:
        final long r101 = r110.f(r100);
        e(r101);
        final ArrayList<SnapshotInstance> r113 = h0.b(r112);
        Function3<Integer, Long, Boolean, Integer> r114 = new ListRuntime$bindHolderCallbacks$componentAtIndex$1(this, r113, r110, r100, r101);
        Function4<ArrayList<Integer>, ArrayList<Long>, Boolean, Boolean, Unit> r115 = new ListRuntime$bindHolderCallbacks$componentAtIndexes$1(this, r110, r101, r100, r113);
        Function1<Long, Unit> r116 = new ListRuntime$bindHolderCallbacks$enqueueComponent$1(this, r101);
        r110.j(r100, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r114, 3), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r116, 1), (Function4) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r115, 4));
    }

    public final void d(final z0 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        Intrinsics.checkNotNullParameter(r101, "nodeObject");
        SnapshotInstance r102 = (SnapshotInstance) r101;
        if (r102.i() == true) goto L5;
        return;
    L5:
        if (r102.f405441e == null) goto L16;
        p r103 = r102.f405440d;
        if (r103 == null) goto L17;
        long r104 = r100.f(r103);
        Map r105 = (Map) com.bytedance.rts.kmp.foundation.j.c(this.f405414b, Long.valueOf(r104));
        if (r105 == null) goto L13;
        com.bytedance.rts.kmp.foundation.j.b(r105, new ListRuntime$destroyHolder$1(r100));
    L13:
        com.bytedance.rts.kmp.foundation.j.a(this.f405413a, Long.valueOf(r104));
        com.bytedance.rts.kmp.foundation.j.a(this.f405414b, Long.valueOf(r104));
        return;
    L17:
        return;
    }

    public final void f(z0 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        Intrinsics.checkNotNullParameter(r101, "holderObject");
        SnapshotInstance r102 = (SnapshotInstance) r101;
        s0 r103 = this.f405415c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "renderer");
        Intrinsics.checkNotNullParameter(this, "runtime");
        Intrinsics.checkNotNullParameter(r102, "parent");
        r103.a(r100, this, r102.f405437a);
    }

    public final void h(Object r100, SnapshotInstance r101) {
        Intrinsics.checkNotNullParameter(r100, "holderObject");
        Intrinsics.checkNotNullParameter(r101, "newNodeObject");
        SnapshotInstance r102 = (SnapshotInstance) r100;
        s0 r103 = this.f405415c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r101, "newNode");
        if (r103.f405565a == null) goto L7;
        j0 r104 = r103.b(r102);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, "_newNode");
        r104.f405526c = true;
        return;
    }

    public static final SnapshotInstance a(ListRuntime r100, ArrayList r101, int r102) {
        r100.getClass();
        if (r102 < 0) goto L8;
        IntCompanionObject r103 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        int r104 = r101.size();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r102 >= r104) goto L8;
        return (SnapshotInstance) ListProtector.get(r101, r102);
    L8:
        int r105 = com.bytedance.rts.kmp.foundation.r.f267614a;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        com.bytedance.rts.kmp.foundation.r.a.a(new Object[]{"[Relax][React][ListRuntime] componentAtIndex received an out-of-range index.", Integer.valueOf(r102), Integer.valueOf(r101.size())});
        return null;
    }

    public static final void b(ListRuntime r100, long r101, SnapshotInstance r102) {
        Map r103 = (Map) com.bytedance.rts.kmp.foundation.j.c(r100.f405413a, Long.valueOf(r101));
        Map r104 = (Map) com.bytedance.rts.kmp.foundation.j.c(r100.f405414b, Long.valueOf(r101));
        if (r103 == null) goto L7;
        if (r104 == null) goto L7;
        int r105 = com.bytedance.rts.kmp.foundation.r.f267614a;
        com.bytedance.rts.kmp.foundation.r.a.a(new Object[]{"[Relax][React][ListRuntime] <list-item> is missing `item-key` during list materialization.", Long.valueOf(r102.f405437a), Long.valueOf(r101)});
        return;
    L7:
        int r106 = com.bytedance.rts.kmp.foundation.r.f267614a;
        com.bytedance.rts.kmp.foundation.r.a.a(new Object[]{"[Relax][React][ListRuntime] componentAtIndex called on a removed list.", Long.valueOf(r101)});
    }

    public final void i(z0 r100, SnapshotInstance r101, SnapshotInstance r102) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        Intrinsics.checkNotNullParameter(r101, "holderObject");
        Intrinsics.checkNotNullParameter(r102, "nodeObject");
        s0 r103 = this.f405415c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "node");
        if (r103.f405565a == null) goto L7;
        j0 r104 = r103.b(r101);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "_child");
        r104.f405526c = true;
    L7:
        if (r101.f405441e != null) goto L9;
        return;
    L9:
        if (r102.f405441e != null) goto L11;
        return;
    L11:
        if (r102.f405440d == null) goto L23;
        p r105 = r101.f405440d;
        if (r105 == null) goto L24;
        long r106 = r100.f(r105);
        Map r107 = (Map) com.bytedance.rts.kmp.foundation.j.c(this.f405413a, Long.valueOf(r106));
        p r108 = r102.f405440d;
        Intrinsics.checkNotNull(r108);
        long r109 = r100.f(r108);
        if (r107 == null) goto L22;
        com.bytedance.rts.kmp.foundation.j.a(r107, Long.valueOf(r109));
        return;
    L22:
        return;
    L24:
        return;
    }
}
