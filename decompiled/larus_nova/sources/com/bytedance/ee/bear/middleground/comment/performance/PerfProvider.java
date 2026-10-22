package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.bear.middleground.comment.uitls.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class PerfProvider implements af5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f232042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f232043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f232044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f232045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f232046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PerfConfig f232047f;

    public static final class a {
    }

    static {
    }

    @Override // af5.b
    public final c a() {
        if (this.f232047f.getFps_collection_enable() == true) goto L7;
        return null;
    L7:
        return (c) this.f232043b.getValue();
    }

    @Override // af5.b
    public final d b() {
        if (this.f232047f.getSend_comment_enable() == true) goto L7;
        return null;
    L7:
        return (d) this.f232046e.getValue();
    }

    @Override // af5.b
    public final b c() {
        if (this.f232047f.getLoad_cost_enable() == true) goto L7;
        return null;
    L7:
        return (b) this.f232044c.getValue();
    }

    @Override // af5.b
    public final com.bytedance.ee.bear.middleground.comment.performance.a d() {
        if (this.f232047f.getEditable_cost_enable() == true) goto L7;
        return null;
    L7:
        return (com.bytedance.ee.bear.middleground.comment.performance.a) this.f232045d.getValue();
    }

    public PerfProvider(p r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f232042a = r100;
        this.f232043b = LazyKt.lazy(new PerfProvider$mScrollFpsTracker$2(this));
        this.f232044c = LazyKt.lazy(new PerfProvider$mLoadCostTracker$2(this));
        this.f232045d = LazyKt.lazy(new PerfProvider$mEditableCostTracker$2(this));
        this.f232046e = LazyKt.lazy(new PerfProvider$mSendCommentTracker$2(this));
        PerfConfig r101 = (PerfConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c(PerfConfig.KEY, PerfConfig.class, new PerfConfig());
        this.f232047f = r101;
        tt5.a.h("Comment#PerfProvider", "PerfProvider init, perfConfig = " + r101);
    }
}
