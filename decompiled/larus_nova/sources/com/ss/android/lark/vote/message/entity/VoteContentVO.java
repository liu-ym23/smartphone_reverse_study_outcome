package com.ss.android.lark.vote.message.entity;

import com.ss.android.lark.vote.message.content.VoteContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v5b.a;

/* JADX INFO: loaded from: classes38.dex */
public final class VoteContentVO extends a<VoteContent> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f445241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f445242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f445243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f445244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f445245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f445246g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f445247h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f445248i;

    public VoteContentVO(final VoteContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f445241b = LazyKt.lazy(new VoteContentVO$topic$2(r100));
        this.f445242c = LazyKt.lazy(new VoteContentVO$minPickNum$2(r100));
        this.f445243d = LazyKt.lazy(new VoteContentVO$maxPickNum$2(r100));
        this.f445244e = LazyKt.lazy(new VoteContentVO$realName$2(r100));
        this.f445245f = LazyKt.lazy(new VoteContentVO$finished$2(r100));
        this.f445246g = LazyKt.lazy(new VoteContentVO$expectVoteNum$2(r100));
        this.f445247h = LazyKt.lazy(new VoteContentVO$actualVoteNum$2(r100));
        this.f445248i = LazyKt.lazy(new VoteContentVO$options$2(r100));
    }
}
