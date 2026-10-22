package com.ss.android.lark.integrator.im.impl;

import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.shared.data.LoadState;
import com.ss.android.lark.feed.shared.page.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements q {
    public e() {
    }

    @Override // com.ss.android.lark.feed.shared.page.q
    public final void d() {
    }

    @Override // com.ss.android.lark.feed.shared.page.q
    public final LoadState a() {
        return new LoadState();
    }

    @Override // com.ss.android.lark.feed.shared.page.q
    public final FeedFolder b() {
        return FeedFolderCompat.INSTANCE.getMESSAGE();
    }

    @Override // com.ss.android.lark.feed.shared.page.q
    public final void c(FeedCard.FeedType r100) {
        Intrinsics.checkNotNullParameter(r100, "inbox");
    }
}
