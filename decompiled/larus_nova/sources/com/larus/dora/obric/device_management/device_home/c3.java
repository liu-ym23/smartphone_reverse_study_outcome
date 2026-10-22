package com.larus.dora.obric.device_management.device_home;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f339198a = 0;

    static {
    }

    public static d3 a(f3 r100, z2 r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "event");
        if ((r101 instanceof z2.b) == false) goto L6;
        return new d3(r100, new y2.a(((z2.b) r101).f339403a));
    L6:
        if ((r101 instanceof z2.a) == false) goto L9;
        DoraObricGlassesMode r102 = ((z2.a) r101).f339402a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "selectedMode");
        return new d3(new f3(r102), null);
    L9:
        if (Intrinsics.areEqual(r101, z2.c.f339404a) == false) goto L13;
        return new d3(r100, y2.b.f339391a);
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
