package com.ss.android.lark.message.vote.message;

import com.ss.android.lark.chat.entity.message.content.CardContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class VoteContentVO extends v5b.a<CardContent> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f432293b;

    public VoteContentVO(final CardContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f432293b = LazyKt.lazy(new VoteContentVO$richText$2(r100));
    }
}
