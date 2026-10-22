package com.bytedance.locallife.biz.prefetch.newsdk;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f256943b;

    public e(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "matchMod");
        Intrinsics.checkNotNullParameter(r101, "matchRule");
        this.f256942a = r100;
        this.f256943b = r101;
    }
}
