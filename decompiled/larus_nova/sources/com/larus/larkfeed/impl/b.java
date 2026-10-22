package com.larus.larkfeed.impl;

import com.ss.android.lark.feed.molten.cache.FeedItemsMoltenLocalCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements com.larus.platform.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ttb.a f355139a;

    public b(FeedItemsMoltenLocalCache.b r100) {
        this.f355139a = r100;
    }

    @Override // com.larus.platform.api.b
    public final void a(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f355139a.a(r100.f364876b);
    }

    @Override // com.larus.platform.api.b
    public final void b(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f355139a.b(r100.f364876b);
    }
}
