package com.larus.home.impl.sdk;

import com.larus.platform.api.d5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l0 implements n38.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d5 f346197a;

    public l0(d5 r100) {
        this.f346197a = r100;
    }

    @Override // n38.r
    public final void a(boolean r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "clientKey");
        Intrinsics.checkNotNullParameter(r102, "scope");
        Intrinsics.checkNotNullParameter(r103, "state");
        this.f346197a.a(r100, r101, r102, r103);
    }
}
