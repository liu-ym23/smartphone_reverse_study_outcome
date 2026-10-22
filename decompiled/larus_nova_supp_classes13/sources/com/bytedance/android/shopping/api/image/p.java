package com.bytedance.android.shopping.api.image;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class p implements q, o, r {
    public final /* synthetic */ r a;

    @Override // com.bytedance.android.shopping.api.image.s
    public final int a() {
        return this.a.a();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String c() {
        return this.a.c();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final int e() {
        return this.a.e();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final boolean f(String r2, String r3) {
        return this.a.f(r2, r3);
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getDomain() {
        return this.a.getDomain();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getFlag() {
        return this.a.getFlag();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getImageUri() {
        return this.a.getImageUri();
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final u getQuery() {
        return this.a.getQuery();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getServiceId() {
        return this.a.getServiceId();
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final Pair<Integer, Integer> h() {
        return this.a.h();
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final boolean isHierarchical() {
        return this.a.isHierarchical();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final boolean j() {
        return this.a.j();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String l() {
        return this.a.l();
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final t n() {
        return this.a.n();
    }

    public abstract void o(String r1);

    public p(r r2) {
        Intrinsics.checkNotNullParameter(r2, "proxy");
        this.a = r2;
    }
}
