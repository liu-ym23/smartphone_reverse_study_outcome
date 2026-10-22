package com.ss.android.lark.flow.chat.message.profile;

import com.ss.android.lark.chat.entity.message.content.ProfileContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowProfileContentVO extends v5b.a<ProfileContent> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f422655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f422656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f422657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f422658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f422659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f422660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f422661h;

    public FlowProfileContentVO(final ProfileContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f422655b = LazyKt.lazy(new FlowProfileContentVO$id$2(r100));
        this.f422656c = LazyKt.lazy(new FlowProfileContentVO$displayName$2(r100));
        this.f422657d = LazyKt.lazy(new FlowProfileContentVO$chatterType$2(r100));
        this.f422658e = LazyKt.lazy(new FlowProfileContentVO$avatarKey$2(r100));
        this.f422659f = LazyKt.lazy(new FlowProfileContentVO$description$2(r100));
        this.f422660g = LazyKt.lazy(new FlowProfileContentVO$isProfileEnable$2(r100));
        this.f422661h = LazyKt.lazy(new FlowProfileContentVO$tenantId$2(r100));
    }
}
