package com.bytedance.relax.ttmlstatic;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f267222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f267223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<Object, Unit> f267224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s87.d f267225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f267226e;

    public c(long r100, String r101, Function1<Object, Unit> r102, s87.d r103) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "options");
        this.f267226e = true;
        this.f267222a = r100;
        this.f267223b = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f267224c = r102;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f267225d = r103;
    }
}
