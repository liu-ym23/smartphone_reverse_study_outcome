package com.bytedance.kmp.livesdk.gift.platform.resourcemanager;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f252411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.e f252412b;

    public final List<c> b() {
        return CollectionsKt.toList(this.f252411a);
    }

    public f(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f252412b = r100;
        this.f252411a = new CopyOnWriteArrayList();
    }

    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        ((CopyOnWriteArrayList) this.f252411a).add(r100);
    }
}
