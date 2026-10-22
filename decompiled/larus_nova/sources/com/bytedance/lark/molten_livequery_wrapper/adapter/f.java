package com.bytedance.lark.molten_livequery_wrapper.adapter;

import com.bytedance.lark.molten_livequery_wrapper.SerialExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.molten_livequery.c f253393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.lark.molten_livequery_wrapper.c f253395c;

    public f() {
        throw null;
    }

    public f(com.bytedance.lark.molten_livequery.c r100, long r101) {
        SerialExecutor r102 = new SerialExecutor();
        LiveQueryUpdateHubAdapter$1 r103 = LiveQueryUpdateHubAdapter$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r102, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(r103, "loggerProvider");
        this.f253393a = r100;
        this.f253394b = r101;
        this.f253395c = r102;
    }
}
