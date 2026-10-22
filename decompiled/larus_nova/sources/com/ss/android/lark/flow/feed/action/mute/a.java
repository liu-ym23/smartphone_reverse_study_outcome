package com.ss.android.lark.flow.feed.action.mute;

import aeb.e;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.export.feedcard.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements aeb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f423211a;

    @Override // aeb.c
    public final e i() {
        return new c();
    }

    @Override // aeb.c
    public final aeb.d m() {
        return new FlowNoDisturbActionHandler(this.f423211a);
    }

    @Override // aeb.c
    public final FeedActionType d() {
        return FeedActionType.NO_DISTURB;
    }

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "feedContext");
        this.f423211a = r100;
    }
}
