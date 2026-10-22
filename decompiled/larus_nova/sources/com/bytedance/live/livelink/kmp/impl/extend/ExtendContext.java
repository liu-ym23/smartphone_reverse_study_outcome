package com.bytedance.live.livelink.kmp.impl.extend;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ui6.e;

/* JADX INFO: loaded from: classes19.dex */
public final class ExtendContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f255512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ni6.a f255513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final oi6.d f255514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final li6.a f255515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final si6.b f255516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f255517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ui6.d f255518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ti6.d f255519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final hi6.b f255520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final gi6.e f255521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final vi6.a f255522k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final xi6.c f255523l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<fi6.a> f255524m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ji6.c f255525n;

    public ExtendContext(ni6.a r100, oi6.d r101, li6.a r102, si6.b r103, e r104, ui6.d r105, ti6.d r106, hi6.b r107, gi6.e r110, vi6.a r111, xi6.c r112, Function0<fi6.a> r113, ji6.c r114) {
        Intrinsics.checkNotNullParameter(r113, "config");
        this.f255513b = r100;
        this.f255514c = r101;
        this.f255515d = r102;
        this.f255516e = r103;
        this.f255517f = r104;
        this.f255518g = r105;
        this.f255519h = r106;
        this.f255520i = r107;
        this.f255521j = r110;
        this.f255522k = r111;
        this.f255523l = r112;
        this.f255524m = r113;
        this.f255525n = r114;
        this.f255512a = LazyKt.lazy(new ExtendContext$liveCore$2(this));
    }
}
