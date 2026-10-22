package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f339354a = 0;

    static {
    }

    public static u a(s1 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "usageEvidence");
        boolean r102 = r100.f339356a;
        boolean r103 = r100.f339357b;
        if (r100.f339359d == false) goto L5;
    L8:
        boolean r104 = true;
    L10:
        return new u(r102, r103, r104, r101);
    L5:
        if (r100.f339358c == true) goto L8;
        r104 = false;
        goto L10
    }
}
