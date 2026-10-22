package com.bytedance.salamander.anniex;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f268149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f268150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f268151c;

    public j0(String r100, String r101, g r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "barItemName");
        Intrinsics.checkNotNullParameter(r101, "iconImage");
        Intrinsics.checkNotNullParameter(r102, "iconColor");
        Intrinsics.checkNotNullParameter(r103, "barItemAction");
        this.f268149a = "";
        this.f268149a = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f268150b = r102;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f268151c = r103;
    }
}
