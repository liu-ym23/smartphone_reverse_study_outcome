package com.relax.relaxreact;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static d f405472k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f405473l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f405474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f405475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f405476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f405477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f405478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t f405479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f405480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x0 f405481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f405482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<Integer, k> f405483j;

    public static final class a {
    }

    static {
    }

    public final f getType() {
        f r100 = this.f405474a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public final o1 a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "vnode");
        f405472k = this;
        f405473l = 0;
        Function1<Object, ? extends o1> r101 = r100.d().f405492a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(ChameleonOpenTracker.Stage.RENDER);
        r101 = null;
    L6:
        o1 r102 = r101.invoke(r100.f405506e);
        f405472k = null;
        f405473l = 0;
        return r102;
    }

    public d(g r100, d r101, x0 r102) {
        Intrinsics.checkNotNullParameter(r100, "vnode");
        Intrinsics.checkNotNullParameter(r102, "reconciler");
        this.f405475b = true;
        this.f405480g = r101;
        this.f405481h = r102;
        f r103 = r100.d();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f405474a = r103;
        if (r101 == null) goto L5;
        Map<Integer, k> r104 = r101.f405483j;
    L6:
        this.f405483j = r104;
        return;
    L5:
        r104 = null;
        goto L6
    }
}
