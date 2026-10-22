package com.relax.relaxframework;

import com.byted.cast.common.Constants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class k0<T> implements o7, y1, z1, n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t7 f405157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s7 f405158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ComputedState f405159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<? extends T> f405160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f405161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f405162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<Integer> f405163g;

    @Override // com.relax.relaxframework.z1
    public final int a() {
        ComputedState r100 = this.f405159c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_state");
        r100 = null;
    L6:
        if (r100 == ComputedState.Clean) goto L8;
    L9:
        h();
    L11:
        return this.f405162f;
    L8:
        if (i() == true) goto L11;
        goto L9
    }

    public final T h() {
        if (RelaxFrameworkKt.f404872b == false) goto L5;
        Intrinsics.checkNotNullParameter("Cannot read computed in frozen state", "message");
    L5:
        ComputedState r100 = this.f405159c;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("_state");
        r100 = null;
    L9:
        if (r100 != ComputedState.Computing) goto L11;
        Intrinsics.checkNotNullParameter("Circular dependency in computed", "message");
    L11:
        n0 r101 = RelaxFrameworkKt.f404871a;
        ComputedState r102 = this.f405159c;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("_state");
        r102 = null;
    L14:
        boolean r103 = false;
        if (r102 != ComputedState.Dirty) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == true) goto L39;
        ComputedState r105 = this.f405159c;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("_state");
        r105 = null;
    L23:
        if (r105 != ComputedState.Checked) goto L25;
    L26:
        RelaxFrameworkKt.f404871a = null;
        ArrayList<z1> r106 = this.f405158b.f405267a;
        IntCompanionObject r107 = IntCompanionObject.INSTANCE;
        int r108 = com.bytedance.rts.foundation.j.d(r106);
        com.bytedance.rts.foundation.k.c(r107, r108);
        int r109 = com.bytedance.rts.foundation.j.d(this.f405163g);
        com.bytedance.rts.foundation.k.c(r107, r109);
        if (r108 != r109) goto L38;
        int r110 = 0;
    L29:
        IntCompanionObject r111 = IntCompanionObject.INSTANCE;
        int r112 = com.bytedance.rts.foundation.j.d(r106);
        com.bytedance.rts.foundation.k.c(r111, r112);
        if (r110 >= r112) goto L39;
        int r113 = com.bytedance.rts.foundation.d.f267577a;
        int r114 = ((z1) ListProtector.get(r106, r110)).a();
        Integer r115 = (Integer) ListProtector.get(this.f405163g, r110);
        if (r115 == null) goto L38;
        if (r114 != r115.intValue()) goto L38;
        r110 = r110 + 1;
    L38:
        r104 = true;
        goto L39
    L25:
        if (i() == false) goto L26;
    L39:
        if (r104 == false) goto L60;
        RelaxFrameworkKt.f404871a = this;
        s7 r116 = this.f405158b;
        ArrayList<z1> r117 = r116.f405267a;
        ArrayList<Integer> r118 = r116.f405268b;
        int r119 = 0;
    L41:
        IntCompanionObject r120 = IntCompanionObject.INSTANCE;
        int r121 = com.bytedance.rts.foundation.j.d(r117);
        com.bytedance.rts.foundation.k.c(r120, r121);
        if (r119 >= r121) goto L47;
        int r122 = com.bytedance.rts.foundation.d.f267577a;
        int r123 = ((Number) ListProtector.get(r118, r119)).intValue();
        if (r123 < 0) goto L46;
        ((z1) ListProtector.get(r117, r119)).b(r123);
        ListProtector.set(r118, r119, -1);
    L46:
        r119 = r119 + 1;
        goto L41
    L47:
        s7 r124 = this.f405158b;
        r124.getClass();
        r124.f405267a = com.bytedance.rts.foundation.j.k(new z1[0]);
        r124.f405268b = com.bytedance.rts.foundation.j.k(new Integer[0]);
        this.f405163g = com.bytedance.rts.foundation.j.k(new Integer[0]);
        this.f405159c = ComputedState.Computing;
        T r125 = this.f405161e;
        Function0<? extends T> r126 = this.f405160d;
        if (r126 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("_cb");
        r126 = null;
    L50:
        T r127 = r126.invoke();
        int r128 = this.f405162f;
        if (r128 != 0) goto L53;
        this.f405162f = r128 + 1;
    L59:
        this.f405161e = r127;
        goto L60
    L53:
        if (r125 != null) goto L55;
        r125 = null;
    L55:
        if (r125 != r127) goto L57;
        r103 = true;
    L57:
        if (r103 == true) goto L59;
        this.f405162f = r128 + 1;
    L60:
        this.f405159c = ComputedState.Clean;
        if (r101 == null) goto L63;
        r101.g(this, this.f405162f);
    L63:
        RelaxFrameworkKt.f404871a = r101;
        T r129 = this.f405161e;
        if (r129 != null) goto L66;
        return null;
    L66:
        Intrinsics.checkNotNull(r129);
        return r129;
    L17:
        r104 = false;
        goto L18
    }

    public final boolean i() {
        IntCompanionObject r100 = IntCompanionObject.INSTANCE;
        int r101 = com.bytedance.rts.foundation.j.d(this.f405157a.f405284a);
        com.bytedance.rts.foundation.k.c(r100, r101);
        if (r101 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.relax.relaxframework.z1
    public final t7 c() {
        return this.f405157a;
    }

    @Override // com.relax.relaxframework.y1
    public final s7 f() {
        return this.f405158b;
    }

    public k0(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.f405157a = new t7();
        this.f405158b = new s7();
        this.f405163g = com.bytedance.rts.foundation.j.k(new Integer[0]);
        this.f405160d = r100;
        this.f405159c = ComputedState.Dirty;
    }

    @Override // com.relax.relaxframework.z1
    public final void b(int r100) {
        this.f405157a.c(r100);
        if (i() == true) goto L8;
        s7 r101 = this.f405158b;
        ArrayList<z1> r102 = r101.f405267a;
        ArrayList<Integer> r103 = r101.f405268b;
        int r104 = 0;
    L5:
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        int r106 = com.bytedance.rts.foundation.j.d(r102);
        com.bytedance.rts.foundation.k.c(r105, r106);
        if (r104 >= r106) goto L10;
        int r107 = com.bytedance.rts.foundation.d.f267577a;
        ((z1) ListProtector.get(r102, r104)).b(((Number) ListProtector.get(r103, r104)).intValue());
        ListProtector.set(r103, r104, -1);
        r104 = r104 + 1;
        goto L5
    L10:
        return;
    }

    @Override // com.relax.relaxframework.z1
    public final int e(y1 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        int r102 = this.f405157a.a(r100, r101);
        if (r102 != 0) goto L8;
        s7 r103 = this.f405158b;
        ArrayList<z1> r104 = r103.f405267a;
        ArrayList<Integer> r105 = r103.f405268b;
        int r106 = 0;
    L5:
        IntCompanionObject r107 = IntCompanionObject.INSTANCE;
        int r108 = com.bytedance.rts.foundation.j.d(r104);
        com.bytedance.rts.foundation.k.c(r107, r108);
        if (r106 >= r108) goto L8;
        int r109 = com.bytedance.rts.foundation.d.f267577a;
        ListProtector.set(r105, r106, Integer.valueOf(((z1) ListProtector.get(r104, r106)).e(this, r106)));
        r106 = r106 + 1;
    L8:
        return r102;
    }

    @Override // com.relax.relaxframework.n0
    public final void g(z1 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f405158b.a(r100, this, i());
        com.bytedance.rts.foundation.j.j(this.f405163g, Integer.valueOf(r101));
    }

    @Override // com.relax.relaxframework.y1
    public final void d(z1 r100, boolean r101, ArrayList<e2> r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r102, "pendingWatchers");
        ComputedState r103 = this.f405159c;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_state");
        r103 = null;
    L6:
        if (r103 != ComputedState.Clean) goto L8;
        boolean r104 = true;
    L9:
        if (r101 == false) goto L11;
        this.f405159c = ComputedState.Dirty;
    L12:
        if (r104 == false) goto L15;
        this.f405157a.b(this, false, r102);
        return;
    L15:
        return;
    L11:
        this.f405159c = ComputedState.Checked;
        goto L12
    L8:
        r104 = false;
        goto L9
    }
}
