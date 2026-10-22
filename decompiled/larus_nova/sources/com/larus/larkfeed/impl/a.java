package com.larus.larkfeed.impl;

import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.feed.molten.cache.FeedItemsMoltenLocalCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements stb.a {

    /* JADX INFO: renamed from: com.larus.larkfeed.impl.a$a, reason: collision with other inner class name */
    public static final class C4396a {
    }

    static {
    }

    @Override // stb.a
    public final String a() {
        return AccountService.f365697a.getUserId();
    }

    public a() {
        FLogger.f375446a.i("FlowHostUserImpl", "[FlowFeedLog] init");
    }

    @Override // stb.a
    public final void Y0(FeedItemsMoltenLocalCache.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        b r101 = new b(r100);
        AccountService.f365697a.E(r101);
    }
}
