package com.bytedance.lark.molten_livequery_wrapper.adapter;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f253389d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.molten_livequery_wrapper.f.a<T> f253390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f253391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<? extends com.bytedance.lark.molten_livequery_wrapper.d> f253392c;

    public static final class a {
        public static d a(long r100, com.bytedance.lark.lark_biz_feed_android_wrapper.d r101) {
            Intrinsics.checkNotNullParameter(r101, "decoder");
            Map<Long, f> r102 = com.bytedance.lark.molten_livequery_wrapper.adapter.a.f253383a;
            return new d(r101, (f) BuildersKt.runBlocking$default(null, new LiveQueryHubRegistryAdapter$getOrCreate$1(r100, null), 1, null));
        }
    }

    static {
    }

    public final c a() {
        LiveQueryListWrapperFactoryAdapter$createDataStore$mainExecutor$1 r100 = LiveQueryListWrapperFactoryAdapter$createDataStore$mainExecutor$1.INSTANCE;
        Function0 r101 = this.f253392c;
        if (r101 != null) goto L5;
        r101 = LiveQueryListWrapperFactoryAdapter$createDataStore$logger$1.INSTANCE;
    L5:
        Function0 r102 = r101;
        return new c(new LiveQuerySubscriber(this.f253390a, this.f253391b.f253394b, new LiveQueryListWrapperFactoryAdapter$createDataStore$store$1(this), r102, new LiveQueryListWrapperFactoryAdapter$createDataStore$store$2(this), r100));
    }

    public d(com.bytedance.lark.molten_livequery_wrapper.f.a<T> r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r101, "hub");
        this.f253390a = r100;
        this.f253391b = r101;
    }
}
