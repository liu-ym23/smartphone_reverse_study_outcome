package com.bytedance.awemeopen.domain.feed.preload;

import com.bytedance.awemeopen.domain.feed.preload.aweme.AosAwemeRequesterImpl;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import r34.f;

/* JADX INFO: loaded from: classes44.dex */
public final class AwemePreloadDomain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AosAwemeRequesterImpl f198324a;

    public AwemePreloadDomain() {
        this.f198324a = new AosAwemeRequesterImpl(true);
    }

    public final void a(final List<String> r100, final f r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "awemeIds");
        AoPool.a(new AwemePreloadDomain$fetchAweme$1(this, r100, r102, r101));
    }
}
