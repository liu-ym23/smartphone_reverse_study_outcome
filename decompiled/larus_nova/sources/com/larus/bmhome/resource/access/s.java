package com.larus.bmhome.resource.access;

import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StateFlowImpl f313730a = null;

    static {
        f313730a = j1.a(MapsKt.emptyMap());
    }

    public static final boolean a(ResourceInputType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != ResourceInputType.TOS_KEY) goto L5;
    L8:
        return true;
    L5:
        if (r100 == ResourceInputType.REMOTE_URL) goto L8;
        return false;
    }

    public static final boolean b(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof a0.d) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r100 instanceof a0.c) == true) goto L10;
        if ((r100 instanceof a0.a) == true) goto L10;
        return false;
    }

    public static final mr9.l c(f0 r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        mr9.l r100 = r110.f313647e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = r110.f313645c;
        boolean r102 = true;
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L23;
        String r104 = r110.f313646d;
        if (r104 != null) goto L16;
    L19:
        if (r102 == false) goto L23;
        return null;
    L16:
        if (r104.length() == 0) goto L19;
        r102 = false;
    L23:
        return new mr9.l(r110.f313645c, null, r110.f313646d, null, null, false, null, 122);
    L8:
        if (r101.length() == 0) goto L11;
        r103 = false;
        goto L12
    }
}
