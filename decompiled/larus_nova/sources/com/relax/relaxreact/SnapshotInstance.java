package com.relax.relaxreact;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class SnapshotInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f405437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d1 f405438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f405439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f405440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<p> f405441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<Object> f405442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f405443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f405444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<String> f405445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g0 f405446j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, r> f405447k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<String, Function0<Unit>> f405448l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SnapshotInstance f405449m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SnapshotInstance f405450n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SnapshotInstance f405451o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SnapshotInstance f405452p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SnapshotInstance f405453q;

    public final ArrayList<p> c() {
        final ArrayList<p> r100 = com.bytedance.rts.kmp.foundation.i.b(new p[0]);
        final Set r101 = com.bytedance.rts.kmp.foundation.l.a(new Long[0]);
        q(new SnapshotInstance$collectMaterializedElementRefs$1(this, r101, r100));
        return r100;
    }

    public final void r() {
        d1 r100 = null;
        this.f405441e = null;
        this.f405440d = null;
        d1 r101 = this.f405438b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
    L7:
        if (r100.f405491h == false) goto L9;
        return;
    L9:
        SnapshotInstance r102 = this.f405450n;
    L10:
        if (r102 == null) goto L12;
        r102.r();
        r102 = r102.f405453q;
        goto L10
    L12:
        return;
    L5:
        r100 = r101;
        goto L7
    }

    public final boolean i() {
        d1 r100 = this.f405438b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r100 = null;
    L6:
        return r100.f405491h;
    }

    public final SnapshotInstance p() {
        d1 r100 = this.f405438b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r100 = null;
    L5:
        SnapshotInstance r101 = new SnapshotInstance(r100, this.f405439c);
        r101.f405437a = this.f405437a;
        r101.f405442f = this.f405442f;
        r101.f405443g = this.f405443g;
        r101.f405444h = this.f405444h;
        if (this.f405445i == null) goto L12;
        int r102 = 0;
        ArrayList<String> r103 = com.bytedance.rts.kmp.foundation.i.b(new String[0]);
    L8:
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        ArrayList<String> r105 = this.f405445i;
        Intrinsics.checkNotNull(r105);
        int r106 = com.bytedance.rts.kmp.foundation.i.a(r105);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (r102 >= r106) goto L11;
        ArrayList<String> r107 = this.f405445i;
        Intrinsics.checkNotNull(r107);
        com.bytedance.rts.kmp.foundation.i.f(r103, ListProtector.get(r107, r102));
        r102 = r102 + 1;
        goto L8
    L11:
        r101.f405445i = r103;
    L12:
        r101.f405446j = this.f405446j;
        r101.f405441e = this.f405441e;
        r101.f405440d = this.f405440d;
        SnapshotInstance r108 = this.f405450n;
    L13:
        if (r108 == null) goto L15;
        r101.a(r108.p(), null);
        r108 = r108.f405453q;
        goto L13
    L15:
        this.f405441e = null;
        this.f405440d = null;
        return r101;
    }

    public final void b(SnapshotInstance r100) {
        if (r100.f405449m == this) goto L6;
        int r101 = com.relax.relaxreact.shared.b.f405582a;
        com.relax.relaxreact.shared.b.a.a(new String[]{"[Relax][React][Snapshot]", "The node is not a child of this instance."});
        return;
    L6:
        SnapshotInstance r102 = r100.f405452p;
        if (r102 == null) goto L9;
        Intrinsics.checkNotNull(r102);
        r102.f405453q = r100.f405453q;
    L10:
        SnapshotInstance r103 = r100.f405453q;
        if (r103 == null) goto L13;
        Intrinsics.checkNotNull(r103);
        r103.f405452p = r100.f405452p;
    L14:
        r100.f405449m = null;
        r100.f405452p = null;
        r100.f405453q = null;
        return;
    L13:
        this.f405451o = r100.f405452p;
        goto L14
    L9:
        this.f405450n = r100.f405453q;
        goto L10
    }

    public final void e(final z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        if (this.f405441e == null) goto L5;
        return;
    L5:
        d1 r101 = this.f405438b;
        d1 r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r101 = null;
    L8:
        ArrayList<p> r103 = r101.f405485b.invoke(r100, this);
        this.f405441e = r103;
        Intrinsics.checkNotNull(r103);
        this.f405440d = (p) ListProtector.get(r103, 0);
        d1 r104 = this.f405438b;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
    L13:
        if (r102.f405491h == true) goto L26;
        n(r100);
        l(r100, false);
        SnapshotInstance r105 = this.f405450n;
    L15:
        if (r105 == null) goto L25;
        if (g(r105.f405439c) != 0) goto L19;
        r105.e(r100);
        j(r100, r105.f405439c, r105);
    L24:
        r105 = r105.f405453q;
        goto L15
    L19:
        r105.e(r100);
        p r106 = f(r105.f405439c);
        if (r106 == null) goto L24;
        p r107 = r105.f405440d;
        if (r107 == null) goto L24;
        Intrinsics.checkNotNull(r107);
        r100.k(r106, r107);
        goto L24
    L25:
        return;
    L26:
        ListRuntime r108 = r100.m();
        r108.j(new SnapshotInstance$ensureElements$1(this, r100));
        if (r108.g(this) == true) goto L33;
        SnapshotInstance r109 = this.f405450n;
        if (r109 == null) goto L33;
        Intrinsics.checkNotNull(r109);
    L31:
        if (r109 == null) goto L33;
        r108.h(this, r109);
        r109 = r109.f405453q;
    L33:
        r108.c(r100, this);
        r108.f(r100, this);
        return;
    L11:
        r102 = r104;
        goto L13
    }

    public final p f(int r100) {
        d1 r101 = this.f405438b;
        d1 r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r101 = null;
    L6:
        if (r101.f405490g != null) goto L8;
    L21:
        return null;
    L8:
        if (this.f405441e == null) goto L21;
        d1 r103 = this.f405438b;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r103 = null;
    L12:
        ArrayList<Integer> r104 = r103.f405490g;
        Intrinsics.checkNotNull(r104);
        if (r100 >= com.bytedance.rts.kmp.foundation.i.a(r104)) goto L21;
        d1 r105 = this.f405438b;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
    L19:
        ArrayList<Integer> r106 = r102.f405490g;
        Intrinsics.checkNotNull(r106);
        int r107 = ((Number) ListProtector.get(r106, r100)).intValue() & 16777215;
        ArrayList<p> r108 = this.f405441e;
        Intrinsics.checkNotNull(r108);
        int r109 = com.bytedance.rts.kmp.foundation.c.f267609a;
        return (p) ListProtector.get(r108, r107);
    L18:
        r102 = r105;
        goto L19
    }

    public final int g(int r100) {
        d1 r101 = this.f405438b;
        d1 r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r101 = null;
    L6:
        if (r101.f405490g == null) goto L19;
        d1 r103 = this.f405438b;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r103 = null;
    L10:
        ArrayList<Integer> r104 = r103.f405490g;
        Intrinsics.checkNotNull(r104);
        if (r100 >= com.bytedance.rts.kmp.foundation.i.a(r104)) goto L21;
        d1 r105 = this.f405438b;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
    L17:
        ArrayList<Integer> r106 = r102.f405490g;
        Intrinsics.checkNotNull(r106);
        return ((Number) ListProtector.get(r106, r100)).intValue() & (-16777216);
    L16:
        r102 = r105;
        goto L17
    L21:
        return 16777216;
    L19:
        return 16777216;
    }

    public final void m(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        if (this.f405441e != null) goto L5;
        return;
    L5:
        n(r100);
        l(r100, true);
        d1 r101 = this.f405438b;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r101 = null;
    L9:
        if (r101.f405491h == false) goto L12;
        ListRuntime r102 = r100.m();
        r102.c(r100, this);
        r102.f(r100, this);
        return;
    L12:
        SnapshotInstance r103 = this.f405450n;
    L13:
        if (r103 == null) goto L15;
        r103.m(r100);
        r103 = r103.f405453q;
        goto L13
    }

    public final void n(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        d1 r101 = this.f405438b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r101 = null;
    L5:
        Function2<z0, SnapshotInstance, Unit> r102 = r101.f405488e;
        if (r102 == null) goto L9;
        r102.invoke(r100, this);
        return;
    L9:
        d1 r103 = this.f405438b;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r103 = null;
    L12:
        Function4<z0, SnapshotInstance, Integer, Object, Unit> r104 = r103.f405489f;
        int r105 = 0;
        if (r104 != null) goto L15;
        d1 r106 = this.f405438b;
        if (r106 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r106 = null;
    L28:
        ArrayList<Function4<z0, SnapshotInstance, Integer, Object, Unit>> r107 = r106.f405486c;
        if (r107 != null) goto L31;
        return;
    L31:
        IntCompanionObject r108 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        int r109 = r107.size();
        Intrinsics.checkNotNullParameter(r108, "<this>");
        if (this.f405443g == false) goto L36;
        if (r109 <= 0) goto L48;
        ((Function4) ListProtector.get(r107, 0)).invoke(r100, this, 0, null);
        return;
    L48:
        return;
    L36:
        ArrayList<Object> r110 = this.f405442f;
        if (r110 != null) goto L39;
        return;
    L39:
        Intrinsics.checkNotNull(r110);
        int r111 = com.bytedance.rts.kmp.foundation.i.a(r110);
        Intrinsics.checkNotNullParameter(r108, "<this>");
        if (r111 >= r109) goto L42;
        r109 = r111;
    L42:
        if (r105 >= r109) goto L44;
        Function4 r112 = (Function4) ListProtector.get(r107, r105);
        int r113 = com.bytedance.rts.kmp.foundation.c.f267609a;
        r112.invoke(r100, this, Integer.valueOf(r105), null);
        r105 = r105 + 1;
        goto L42
    L44:
        return;
    L15:
        if (this.f405443g == false) goto L19;
        r104.invoke(r100, this, 0, null);
        return;
    L19:
        if (this.f405442f != null) goto L21;
        return;
    L21:
        IntCompanionObject r114 = IntCompanionObject.INSTANCE;
        ArrayList<Object> r115 = this.f405442f;
        Intrinsics.checkNotNull(r115);
        int r116 = com.bytedance.rts.kmp.foundation.i.a(r115);
        Intrinsics.checkNotNullParameter(r114, "<this>");
        if (r105 >= r116) goto L24;
        int r117 = com.bytedance.rts.kmp.foundation.c.f267609a;
        r104.invoke(r100, this, Integer.valueOf(r105), null);
        r105 = r105 + 1;
        goto L21
    }

    public final void q(Function1<? super SnapshotInstance, Unit> r100) {
        SnapshotInstance r101 = this.f405450n;
    L3:
        if (r101 == null) goto L5;
        r101.q(r100);
        r101 = r101.f405453q;
        goto L3
    L5:
        r100.invoke(this);
    }

    public SnapshotInstance(d1 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        this.f405447k = new LinkedHashMap();
        this.f405448l = new LinkedHashMap();
        new LinkedHashMap();
        long r102 = SnapshotKt.f405455b;
        this.f405437a = r102;
        SnapshotKt.f405455b = r102 + 1;
        this.f405438b = r100;
        this.f405439c = r101;
    }

    public static void d(z0 r100, ArrayList r101) {
        int r102 = 0;
    L3:
        IntCompanionObject r103 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        int r104 = r101.size();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r102 >= r104) goto L6;
        r100.i((p) ListProtector.get(r101, r102));
        r102 = r102 + 1;
        goto L3
    }

    public final void a(SnapshotInstance r100, SnapshotInstance r101) {
        SnapshotInstance r102 = r100.f405449m;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNull(r102);
        r102.b(r100);
    L6:
        if (r101 == null) goto L12;
        SnapshotInstance r103 = r101.f405452p;
        if (r103 == null) goto L10;
        Intrinsics.checkNotNull(r103);
        r103.f405453q = r100;
        SnapshotInstance r104 = r101.f405452p;
        Intrinsics.checkNotNull(r104);
        r100.f405452p = r104;
    L11:
        r101.f405452p = r100;
        r100.f405453q = r101;
        r100.f405449m = this;
        return;
    L10:
        this.f405450n = r100;
        r100.f405452p = null;
        goto L11
    L12:
        SnapshotInstance r105 = this.f405451o;
        if (r105 == null) goto L15;
        Intrinsics.checkNotNull(r105);
        r105.f405453q = r100;
        SnapshotInstance r106 = this.f405451o;
        Intrinsics.checkNotNull(r106);
        r100.f405452p = r106;
    L16:
        this.f405451o = r100;
        r100.f405449m = this;
        r100.f405453q = null;
        return;
    L15:
        this.f405450n = r100;
        r100.f405452p = null;
        goto L16
    }

    public final void k(int r100, p r101) {
        d1 r102 = this.f405438b;
        d1 r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r102 = null;
    L6:
        if (r102.f405490g != null) goto L8;
        return;
    L8:
        if (this.f405441e == null) goto L22;
        d1 r104 = this.f405438b;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r104 = null;
    L12:
        ArrayList<Integer> r105 = r104.f405490g;
        Intrinsics.checkNotNull(r105);
        if (r100 >= com.bytedance.rts.kmp.foundation.i.a(r105)) goto L23;
        d1 r106 = this.f405438b;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
    L19:
        ArrayList<Integer> r107 = r103.f405490g;
        Intrinsics.checkNotNull(r107);
        int r108 = ((Number) ListProtector.get(r107, r100)).intValue() & 16777215;
        ArrayList<p> r109 = this.f405441e;
        Intrinsics.checkNotNull(r109);
        int r110 = com.bytedance.rts.kmp.foundation.c.f267609a;
        ListProtector.set(r109, r108, r101);
        return;
    L18:
        r103 = r106;
        goto L19
    L23:
        return;
    }

    public final void l(z0 r100, boolean r101) {
        d1 r102 = this.f405438b;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r102 = null;
    L6:
        if (r102.f405490g != null) goto L8;
        return;
    L8:
        if (this.f405441e == null) goto L42;
        int r103 = 0;
    L11:
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        d1 r105 = this.f405438b;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r105 = null;
    L14:
        ArrayList<Integer> r106 = r105.f405490g;
        Intrinsics.checkNotNull(r106);
        int r107 = com.bytedance.rts.kmp.foundation.i.a(r106);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (r103 >= r107) goto L43;
        int r108 = com.bytedance.rts.kmp.foundation.c.f267609a;
        if (g(r103) != 67108864) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L35;
        ArrayList<String> r110 = this.f405445i;
        if (r110 == null) goto L28;
        Intrinsics.checkNotNull(r110);
        if (r103 >= com.bytedance.rts.kmp.foundation.i.a(r110)) goto L28;
        ArrayList<String> r111 = this.f405445i;
        Intrinsics.checkNotNull(r111);
        String r112 = (String) ListProtector.get(r111, r103);
    L29:
        if (r112 != null) goto L32;
        if (r101 == false) goto L35;
    L32:
        p r113 = f(r103);
        if (r113 == null) goto L35;
        r100.c(r113, r112);
    L28:
        r112 = null;
    L35:
        r103 = r103 + 1;
        goto L11
    L19:
        r109 = false;
        goto L20
    L43:
        return;
    }

    public final void s(z0 r100, Object r101) {
        d1 r102 = this.f405438b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r102 = null;
    L5:
        ArrayList<Function4<z0, SnapshotInstance, Integer, Object, Unit>> r103 = r102.f405487d;
        if (r103 == null) goto L14;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r103.size() <= 0) goto L16;
        Function4 r104 = (Function4) ListProtector.get(r103, 0);
        if (r104 == null) goto L15;
        r104.invoke(r100, this, 0, r101);
        return;
    L15:
        return;
    L16:
        return;
    }

    public final void t(z0 r110, ArrayList<Object> r111) {
        Intrinsics.checkNotNullParameter(r110, "renderer");
        Intrinsics.checkNotNullParameter(r111, "values");
        d1 r100 = this.f405438b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r100 = null;
    L5:
        ArrayList<Function4<z0, SnapshotInstance, Integer, Object, Unit>> r101 = r100.f405486c;
        ArrayList<Object> r102 = this.f405442f;
        boolean r103 = this.f405443g;
        Object r104 = this.f405444h;
        this.f405442f = r111;
        int r105 = 0;
        this.f405443g = false;
        this.f405444h = null;
        if (this.f405441e != null) goto L9;
        u(r110, r111, r102, r103, r104);
        return;
    L9:
        d1 r106 = this.f405438b;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r106 = null;
    L12:
        Function4<z0, SnapshotInstance, Integer, Object, Unit> r107 = r106.f405489f;
        if (r107 == null) goto L30;
        if (r102 != null) goto L23;
    L15:
        IntCompanionObject r108 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        int r109 = r111.size();
        Intrinsics.checkNotNullParameter(r108, "<this>");
        if (r105 >= r109) goto L22;
        if (r103 == false) goto L20;
        if (r105 != 0) goto L20;
        Object r112 = r104;
    L21:
        int r113 = com.bytedance.rts.kmp.foundation.c.f267609a;
        r107.invoke(r110, this, Integer.valueOf(r105), r112);
        r105 = r105 + 1;
    L20:
        r112 = null;
        goto L21
    L22:
        return;
    L23:
        IntCompanionObject r114 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        int r115 = r111.size();
        Intrinsics.checkNotNullParameter(r114, "<this>");
        if (r105 >= r115) goto L29;
        Object r116 = ListProtector.get(r102, r105);
        if ((!p0.a(r116, ListProtector.get(r111, r105))) == false) goto L28;
        int r117 = com.bytedance.rts.kmp.foundation.c.f267609a;
        r107.invoke(r110, this, Integer.valueOf(r105), r116);
    L28:
        r105 = r105 + 1;
        goto L23
    L29:
        return;
    L30:
        if (r101 != null) goto L32;
        return;
    L32:
        IntCompanionObject r118 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        int r119 = r101.size();
        Intrinsics.checkNotNullParameter(r118, "<this>");
        if (r102 != null) goto L44;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        int r120 = r111.size();
        Intrinsics.checkNotNullParameter(r118, "<this>");
        if (r120 >= r119) goto L37;
        r119 = r120;
    L37:
        if (r105 >= r119) goto L43;
        if (r103 == false) goto L41;
        if (r105 != 0) goto L41;
        Object r121 = r104;
    L42:
        Function4 r122 = (Function4) ListProtector.get(r101, r105);
        int r123 = com.bytedance.rts.kmp.foundation.c.f267609a;
        r122.invoke(r110, this, Integer.valueOf(r105), r121);
        r105 = r105 + 1;
    L41:
        r121 = null;
        goto L42
    L43:
        return;
    L44:
        IntCompanionObject r124 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        int r125 = r111.size();
        Intrinsics.checkNotNullParameter(r124, "<this>");
        if (r105 >= r125) goto L51;
        Object r126 = ListProtector.get(r102, r105);
        if ((!p0.a(r126, ListProtector.get(r111, r105))) == false) goto L50;
        if (r105 >= r119) goto L50;
        Function4 r127 = (Function4) ListProtector.get(r101, r105);
        int r128 = com.bytedance.rts.kmp.foundation.c.f267609a;
        r127.invoke(r110, this, Integer.valueOf(r105), r126);
    L50:
        r105 = r105 + 1;
        goto L44
    }

    public final void h(z0 r100, SnapshotInstance r101, SnapshotInstance r110) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        Intrinsics.checkNotNullParameter(r101, "node");
        d1 r102 = this.f405438b;
        p r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r102 = null;
    L5:
        boolean r104 = true;
        if (r102.f405491h == true) goto L8;
        if (r110 != null) goto L37;
        SnapshotInstance r105 = this.f405451o;
        if (r105 == null) goto L37;
        if (r105.f405439c <= r101.f405439c) goto L37;
        SnapshotInstance r106 = this.f405450n;
        int r107 = -1;
    L23:
        if (r106 == null) goto L30;
        int r108 = r106.f405439c;
        if (r108 <= r101.f405439c) goto L29;
        if (r107 < 0) goto L28;
        if (r108 >= r107) goto L29;
    L28:
        r107 = r108;
    L29:
        r106 = r106.f405453q;
        goto L23
    L30:
        if (r107 < 0) goto L37;
        SnapshotInstance r109 = this.f405450n;
    L32:
        if (r109 == null) goto L37;
        if (r109.f405439c == r107) goto L35;
        r109 = r109.f405453q;
        goto L32
    L35:
        r110 = r109;
    L37:
        SnapshotInstance r111 = r101.f405449m;
        if (r111 == this) goto L40;
    L42:
        if (r111 == this) goto L45;
        r104 = false;
    L45:
        a(r101, r110);
        if (this.f405441e != null) goto L49;
        return;
    L49:
        if (r101.f405441e != null) goto L52;
        r101.e(r100);
    L52:
        if (g(r101.f405439c) != 0) goto L55;
        j(r100, r101.f405439c, r101);
        return;
    L55:
        p r112 = f(r101.f405439c);
        Intrinsics.checkNotNull(r112);
        if (r104 == false) goto L58;
        p r113 = r101.f405440d;
        Intrinsics.checkNotNull(r113);
        r100.g(r112, r113);
    L58:
        if (r110 == null) goto L60;
        r103 = f(r110.f405439c);
    L60:
        if (r110 == null) goto L65;
        if (r103 == null) goto L65;
        if (r103 != r112) goto L65;
        p r114 = r101.f405440d;
        Intrinsics.checkNotNull(r114);
        p r115 = r110.f405440d;
        Intrinsics.checkNotNull(r115);
        r100.t(r112, r114, r115);
        return;
    L65:
        p r116 = r101.f405440d;
        Intrinsics.checkNotNull(r116);
        r100.k(r112, r116);
        return;
    L40:
        if (r101.f405453q != r110) goto L42;
        return;
    L8:
        if (r101.f405449m == this) goto L10;
    L12:
        g0 r117 = r101.f405446j;
        if (r117 != null) goto L15;
        int r118 = com.bytedance.rts.kmp.foundation.r.f267614a;
        com.bytedance.rts.kmp.foundation.r.a.a(new Object[]{"[Relax][React][Snapshot] <list> only accepts <list-item> children.", Long.valueOf(r101.f405437a)});
        return;
    L15:
        Intrinsics.checkNotNull(r117);
        int r119 = com.bytedance.rts.kmp.foundation.r.f267614a;
        com.bytedance.rts.kmp.foundation.r.a.a(new Object[]{"[Relax][React][Snapshot] <list-item> requires `item-key`.", Long.valueOf(r101.f405437a)});
        return;
    L10:
        if (r101.f405453q != r110) goto L12;
    }

    public final void j(z0 r100, int r101, SnapshotInstance r102) {
        p r103 = f(r101);
        p r104 = r102.f405440d;
        if (r103 == null) goto L8;
        if (r104 == null) goto L9;
        r100.l(r104, r103);
        r100.i(r103);
        k(r101, r104);
        return;
    L9:
        return;
    }

    public final void o(z0 r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        ArrayList<String> r103 = this.f405445i;
        if (r103 == null) goto L8;
        Intrinsics.checkNotNull(r103);
        if (r101 >= com.bytedance.rts.kmp.foundation.i.a(r103)) goto L8;
        ArrayList<String> r104 = this.f405445i;
        Intrinsics.checkNotNull(r104);
        String r105 = (String) ListProtector.get(r104, r101);
    L10:
        if (p0.a(r105, r102) == false) goto L13;
        return;
    L13:
        if (this.f405445i != null) goto L34;
        d1 r106 = this.f405438b;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r106 = null;
    L17:
        int r107 = 0;
        if (r106.f405490g == null) goto L23;
        d1 r108 = this.f405438b;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r108 = null;
    L22:
        ArrayList<Integer> r109 = r108.f405490g;
        Intrinsics.checkNotNull(r109);
        int r110 = com.bytedance.rts.kmp.foundation.i.a(r109);
    L24:
        if (r110 < 0) goto L26;
        boolean r111 = true;
    L27:
        if (r111 == false) goto L33;
        ArrayList r112 = new ArrayList(r110);
    L29:
        if (r107 >= r110) goto L31;
        r112.add(null);
        r107 = r107 + 1;
        goto L29
    L31:
        this.f405445i = new ArrayList(r112);
        goto L34
    L33:
        throw new IllegalArgumentException(("Invalid array length: " + r110 + ". Length must be non-negative.").toString());
    L26:
        r111 = false;
        goto L27
    L23:
        r110 = 0;
    L34:
        ArrayList<String> r113 = this.f405445i;
        Intrinsics.checkNotNull(r113);
        if (r101 < com.bytedance.rts.kmp.foundation.i.a(r113)) goto L37;
        return;
    L37:
        ArrayList<String> r114 = this.f405445i;
        Intrinsics.checkNotNull(r114);
        ListProtector.set(r114, r101, r102);
        if (this.f405441e != null) goto L40;
        return;
    L40:
        p r115 = f(r101);
        if (r115 == null) goto L45;
        r100.c(r115, r102);
        return;
    L45:
        return;
    L8:
        r105 = null;
        goto L10
    }

    public final void u(z0 r100, ArrayList<Object> r101, ArrayList<Object> r102, boolean r110, Object r111) {
        d1 r103 = this.f405438b;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r103 = null;
    L5:
        ArrayList<Function4<z0, SnapshotInstance, Integer, Object, Unit>> r104 = r103.f405487d;
        if (r104 != null) goto L8;
        return;
    L8:
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        int r106 = r104.size();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        int r107 = 0;
        if (r102 != null) goto L23;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        int r108 = r101.size();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if (r108 >= r106) goto L13;
        r106 = r108;
    L13:
        if (r107 >= r106) goto L22;
        Function4 r109 = (Function4) ListProtector.get(r104, r107);
        if (r109 == null) goto L21;
        if (r110 == false) goto L19;
        if (r107 != 0) goto L19;
        Object r112 = r111;
    L20:
        int r113 = com.bytedance.rts.kmp.foundation.c.f267609a;
        r109.invoke(r100, this, Integer.valueOf(r107), r112);
    L19:
        r112 = null;
    L21:
        r107 = r107 + 1;
        goto L13
    L22:
        return;
    L23:
        IntCompanionObject r114 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        int r115 = r101.size();
        Intrinsics.checkNotNullParameter(r114, "<this>");
        if (r107 >= r115) goto L33;
        if (r107 >= r106) goto L26;
        Object r116 = ListProtector.get(r102, r107);
        Object r117 = ListProtector.get(r101, r107);
        Function4 r118 = (Function4) ListProtector.get(r104, r107);
        if (r118 == null) goto L32;
        if ((!p0.a(r116, r117)) == false) goto L32;
        int r119 = com.bytedance.rts.kmp.foundation.c.f267609a;
        r118.invoke(r100, this, Integer.valueOf(r107), r116);
    L32:
        r107 = r107 + 1;
        goto L23
    L26:
        return;
    }
}
