package juc;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import nuc.r2;
import nuc.y1;

/* JADX INFO: loaded from: classes42.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r2<? extends Object> f500531a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r2<Object> f500532b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y1<? extends Object> f500533c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y1<Object> f500534d = null;

    static {
        Function1 r100 = new o();
        boolean r101 = nuc.o.f520743a;
        Intrinsics.checkNotNullParameter(r100, "factory");
        boolean r102 = nuc.o.f520743a;
        if (r102 == false) goto L5;
        r2<? extends Object> r103 = new nuc.s(r100);
    L6:
        f500531a = r103;
        Function1 r104 = new p();
        Intrinsics.checkNotNullParameter(r104, "factory");
        if (r102 == false) goto L9;
        r2<Object> r105 = new nuc.s(r104);
    L10:
        f500532b = r105;
        Function2 r106 = new q();
        Intrinsics.checkNotNullParameter(r106, "factory");
        if (r102 == false) goto L13;
        y1<? extends Object> r107 = new nuc.t(r106);
    L14:
        f500533c = r107;
        Function2 r108 = new r();
        Intrinsics.checkNotNullParameter(r108, "factory");
        if (r102 == false) goto L17;
        y1<Object> r109 = new nuc.t(r108);
    L18:
        f500534d = r109;
        return;
    L17:
        r109 = new nuc.y(r108);
        goto L18
    L13:
        r107 = new nuc.y(r106);
        goto L14
    L9:
        r105 = new nuc.x(r104);
        goto L10
    L5:
        r103 = new nuc.x(r100);
        goto L6
    }
}
