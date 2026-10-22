package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class AnnieXSalamanderAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267859a = 0;

    public static final class a {
    }

    static {
    }

    public static s a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
        e2 r101 = e2.f268044b;
        AnnieXBaseViewModel r102 = e2.a.a().a(r100);
        if ((r102 instanceof AnnieXCommonUIViewModel) == false) goto L5;
        final AnnieXCommonUIViewModel r103 = (AnnieXCommonUIViewModel) r102;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        return new s(r103.f().a().getContext(), new AnnieXSalamanderAbility$createErrorViewContext$1(r103));
    L5:
        r103 = null;
        goto L6
    }
}
