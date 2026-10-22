package com.bytedance.locallife.dito.common.log;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.utils.l;
import en6.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import lq6.a;
import rq6.c;

/* JADX INFO: loaded from: classes21.dex */
public final class DitoCommonLog implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DitoCommonLog f257357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f257358b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f257359c = null;

    public DitoCommonLog() {
    }

    static {
        f257357a = new DitoCommonLog();
        f257358b = LazyKt.lazy(DitoCommonLog$onlineLogOpen$2.INSTANCE);
        f257359c = LazyKt.lazy(DitoCommonLog$onlineLogLevel$2.INSTANCE);
    }

    public static int e() {
        return ((Number) f257359c.getValue()).intValue();
    }

    public static boolean f() {
        return ((Boolean) f257358b.getValue()).booleanValue();
    }

    @Override // rq6.c
    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (f() == true) goto L5;
        return;
    L5:
        if (4 < e()) goto L15;
        Dito r102 = Dito.f257280a;
        a r103 = l.g();
        if (r103 == null) goto L16;
        if (r101 == null) goto L11;
        String r104 = r101.toString();
        if (r104 == null) goto L11;
    L12:
        ((e) r103).c(r100, r104);
        return;
    L11:
        r104 = "";
        goto L12
    L16:
        return;
    }

    @Override // rq6.c
    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (f() == true) goto L5;
    L13:
        if (r101 == null) goto L18;
        r101.toString();
        return;
    L18:
        return;
    L5:
        if (6 < e()) goto L13;
        Dito r102 = Dito.f257280a;
        a r103 = l.g();
        if (r103 == null) goto L16;
        if (r101 == null) goto L11;
        String r104 = r101.toString();
        if (r104 == null) goto L11;
    L12:
        ((e) r103).b(r100, r104);
        return;
    L11:
        r104 = "";
        goto L12
    }

    @Override // rq6.c
    public final void c(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (f() == true) goto L5;
        return;
    L5:
        if (3 < e()) goto L15;
        Dito r102 = Dito.f257280a;
        a r103 = l.g();
        if (r103 == null) goto L16;
        if (r101 == null) goto L11;
        String r104 = r101.toString();
        if (r104 == null) goto L11;
    L12:
        ((e) r103).a(r100, r104);
        return;
    L11:
        r104 = "";
        goto L12
    L16:
        return;
    }

    @Override // rq6.c
    public final void d(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (f() == true) goto L5;
        return;
    L5:
        if (5 < e()) goto L15;
        Dito r102 = Dito.f257280a;
        a r103 = l.g();
        if (r103 == null) goto L16;
        if (r101 == null) goto L11;
        String r104 = r101.toString();
        if (r104 == null) goto L11;
    L12:
        ((e) r103).d(r100, r104);
        return;
    L11:
        r104 = "";
        goto L12
    L16:
        return;
    }
}
