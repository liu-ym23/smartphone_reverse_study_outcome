package com.bytedance.awemeopen.domain.follow;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f198402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<String> f198403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Function1<? super String, Unit>, Unit> f198404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super String, Unit> f198405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super q34.b, Unit> f198406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super String, Unit> f198407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function2<? super String, ? super Integer, Unit> f198408g;

    public a() {
    }

    public final Function0<String> a() {
        Function0<String> r100 = this.f198403b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("userHolder");
        return null;
    }
}
