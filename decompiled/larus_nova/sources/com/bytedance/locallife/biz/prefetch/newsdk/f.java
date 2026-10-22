package com.bytedance.locallife.biz.prefetch.newsdk;

import com.ss.android.ugc.aweme.prefetch.newsdk.PrefetchType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f256945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f256946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f256947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f256948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f256949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f256950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f256951h;

    public f(String r100, c r101, long r102) {
        PrefetchType r103 = PrefetchType.INTERCEPTOR_PREFETCH;
        Intrinsics.checkNotNullParameter(r100, "prefetchKey");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r103, "prefetchType");
        this.f256944a = r100;
        this.f256945b = r101;
        this.f256946c = null;
        this.f256947d = null;
        this.f256948e = r102;
        this.f256949f = null;
        this.f256950g = -1;
        this.f256951h = false;
    }
}
