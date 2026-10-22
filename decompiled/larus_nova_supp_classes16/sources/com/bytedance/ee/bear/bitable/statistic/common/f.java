package com.bytedance.ee.bear.bitable.statistic.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends b {
    public final String e;
    public final boolean f;
    public final boolean g;

    @Override // com.bytedance.ee.bear.bitable.statistic.common.b
    public final boolean b() {
        return this.f;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.b
    public final boolean c() {
        return this.g;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.b
    public final String e() {
        return this.e;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.b
    public final String f() {
        return this.e;
    }

    public f(String r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.e = r2;
        this.f = r3;
        this.g = r4;
    }
}
