package com.ss.android.lark.flow.feed.action.clearunread;

import aeb.e;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.export.feedcard.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements aeb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f423205a;

    @Override // aeb.c
    public final e i() {
        return new c();
    }

    @Override // aeb.c
    public final aeb.d m() {
        return new FlowClearUnreadActionHandler(this.f423205a);
    }

    @Override // aeb.c
    public final FeedActionType d() {
        return FeedActionType.CLEAR_UNREAD;
    }

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "feedCardContext");
        this.f423205a = r100;
    }
}
