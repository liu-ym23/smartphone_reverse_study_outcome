package com.bytedance.android.shopping.prepurchase.arch.container;

import com.bytedance.android.shopping.prepurchase.arch.container.ability.ContainerTrackAbility;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.i;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.k;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.l;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.n;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.p;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.j;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<STATE extends h, STORE> implements c<STATE, STORE> {
    public j<STORE> a;
    public l b;
    public com.bytedance.android.shopping.prepurchase.arch.container.ability.f c;
    public final og3.b<STATE> d;
    public final i e;
    public final com.bytedance.android.shopping.prepurchase.arch.container.ability.j f;
    public final k g;
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.b h;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final l b() {
        l r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("prefAbility");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final j<STORE> d() {
        j<STORE> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentFetchAbility");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final com.bytedance.android.shopping.prepurchase.arch.container.ability.f e() {
        com.bytedance.android.shopping.prepurchase.arch.container.ability.f r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sliceYataAbility");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final i a() {
        return this.e;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final k c() {
        return this.g;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final og3.b<STATE> f() {
        return this.d;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.b getContainerAbility() {
        return this.h;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final com.bytedance.android.shopping.prepurchase.arch.container.ability.j w7() {
        return this.f;
    }

    public d(og3.b r2, ContainerTrackAbility r3, n r4, p r5, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r6) {
        Intrinsics.checkNotNullParameter(r2, "globalStateStore");
        Intrinsics.checkNotNullParameter(r3, "trackAbility");
        Intrinsics.checkNotNullParameter(r4, "logAbility");
        Intrinsics.checkNotNullParameter(r5, "monitorAbility");
        Intrinsics.checkNotNullParameter(r6, "dependencies");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
    }
}
