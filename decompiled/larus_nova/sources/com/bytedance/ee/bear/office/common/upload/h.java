package com.bytedance.ee.bear.office.common.upload;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235372a = 0;

    static {
    }

    public static String a(b r100) {
        if ((r100 instanceof b.a) == false) goto L6;
        return "available";
    L6:
        if ((r100 instanceof b.c) == false) goto L9;
        return "hidden:" + ((b.c) r100).f235340a.name();
    L9:
        if ((r100 instanceof b.C3378b) == false) goto L12;
        return "disabled:" + ((b.C3378b) r100).f235339a.name();
    L12:
        if ((r100 instanceof b.d) == false) goto L16;
        return "permission_action:" + ((b.d) r100).f235341a.getDenySource().getUiType();
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public static String b(g0 r100) {
        if (Intrinsics.areEqual(r100, g0.b.f235371a) == false) goto L6;
        return "root_mine";
    L6:
        if ((r100 instanceof g0.a) == false) goto L10;
        return "folder_hash=" + ((g0.a) r100).f235370a.hashCode();
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
