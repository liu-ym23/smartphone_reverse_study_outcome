package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class j8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f268166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValidationAction f268167b;

    public j8(String r100, int r101, ValidationAction r102) {
        Intrinsics.checkNotNullParameter(r100, "field");
        Intrinsics.checkNotNullParameter(r102, "action");
        this.f268166a = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f268167b = r102;
    }
}
