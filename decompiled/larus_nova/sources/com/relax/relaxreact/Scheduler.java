package com.relax.relaxreact;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.relax.relaxreact.shared.TaskScheduler;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<d> f405430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<d> f405431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z0 f405432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Long, Unit> f405433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f405434e;

    public final TaskScheduler c() {
        z0 r100 = this.f405432c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r100 = null;
    L6:
        return r100.v();
    }

    public Scheduler(RenderFnRenderer r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f405432c = r100;
        this.f405430a = new ArrayList();
        this.f405431b = new ArrayList();
        this.f405434e = false;
    }

    public static void a(ArrayList r100) {
        Intrinsics.checkNotNullParameter(r100, "commitQueue");
        int r101 = 0;
    L3:
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.size();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r101 >= r103) goto L13;
        d r104 = (d) ListProtector.get(r100, r101);
        c r105 = r104.f405477d;
        if (r105 == null) goto L12;
        Intrinsics.checkNotNull(r105);
        ArrayList<n> r106 = r105.f405471c;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("layoutEffects");
        r106 = null;
    L11:
        c1.a(r106);
        c r107 = r104.f405477d;
        Intrinsics.checkNotNull(r107);
        ArrayList<n> r108 = new ArrayList();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f405471c = r108;
    L12:
        r101 = r101 + 1;
        goto L3
    }

    public final void b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "c");
        if (r100.f405475b == true) goto L6;
        return;
    L6:
        if (r100.f405476c == true) goto L20;
        r100.f405476c = true;
        ArrayList<d> r101 = this.f405430a;
        ArrayList<d> r102 = null;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dirtyComponents");
        r101 = null;
    L10:
        com.bytedance.rts.kmp.foundation.i.f(r101, r100);
        if (this.f405434e == true) goto L21;
        ArrayList<d> r103 = this.f405430a;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("dirtyComponents");
    L17:
        if (com.bytedance.rts.kmp.foundation.i.a(r102) != 1) goto L22;
        c().b(new Scheduler$enqueueRender$1(this));
        return;
    L22:
        return;
    L15:
        r102 = r103;
        goto L17
    L21:
        return;
    }
}
