package com.bytedance.ee.bear.bitable.statistic.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f215629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f215630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f215631g;

    @Override // com.bytedance.ee.bear.bitable.statistic.common.b
    public final boolean b() {
        return this.f215630f;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.b
    public final boolean c() {
        return this.f215631g;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.b
    public final String e() {
        return this.f215629e;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.b
    public final String f() {
        return this.f215629e;
    }

    public f(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f215629e = r100;
        this.f215630f = r101;
        this.f215631g = r102;
    }
}
