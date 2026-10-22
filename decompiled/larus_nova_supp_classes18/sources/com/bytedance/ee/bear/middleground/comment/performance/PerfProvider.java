package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.bear.middleground.comment.uitls.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class PerfProvider implements af5.b {
    public final p a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final PerfConfig f;

    public static final class a {
    }

    static {
    }

    @Override // af5.b
    public final c a() {
        if (this.f.getFps_collection_enable() == true) goto L7;
        return null;
    L7:
        return (c) this.b.getValue();
    }

    @Override // af5.b
    public final d b() {
        if (this.f.getSend_comment_enable() == true) goto L7;
        return null;
    L7:
        return (d) this.e.getValue();
    }

    @Override // af5.b
    public final b c() {
        if (this.f.getLoad_cost_enable() == true) goto L7;
        return null;
    L7:
        return (b) this.c.getValue();
    }

    @Override // af5.b
    public final com.bytedance.ee.bear.middleground.comment.performance.a d() {
        if (this.f.getEditable_cost_enable() == true) goto L7;
        return null;
    L7:
        return (com.bytedance.ee.bear.middleground.comment.performance.a) this.d.getValue();
    }

    public PerfProvider(p r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        this.a = r4;
        this.b = LazyKt.lazy(new PerfProvider$mScrollFpsTracker$2(this));
        this.c = LazyKt.lazy(new PerfProvider$mLoadCostTracker$2(this));
        this.d = LazyKt.lazy(new PerfProvider$mEditableCostTracker$2(this));
        this.e = LazyKt.lazy(new PerfProvider$mSendCommentTracker$2(this));
        PerfConfig r5 = (PerfConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(PerfConfig.KEY, PerfConfig.class, new PerfConfig());
        this.f = r5;
        tt5.a.h("Comment#PerfProvider", "PerfProvider init, perfConfig = " + r5);
    }
}
