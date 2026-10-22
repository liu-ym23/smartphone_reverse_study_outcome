package com.bytedance.lark.policy.model;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ne6.a f253856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ne6.c f253857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ne6.e f253858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ne6.d f253859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ne6.d f253860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ne6.b f253861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Boolean> f253862g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Boolean> f253863h;

    public p(Function1<? super PolicyConfigBuilder, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "initBlock");
        PolicyConfigBuilder r101 = new PolicyConfigBuilder();
        r100.invoke(r101);
        this.f253856a = r101.f253832a;
        this.f253857b = r101.f253833b;
        this.f253858c = r101.f253834c;
        this.f253859d = r101.f253835d;
        this.f253860e = r101.f253836e;
        this.f253861f = r101.f253837f;
        this.f253862g = r101.f253838g;
        this.f253863h = r101.f253839h;
    }
}
