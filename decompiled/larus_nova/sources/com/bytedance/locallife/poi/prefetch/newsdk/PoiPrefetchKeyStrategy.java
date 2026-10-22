package com.bytedance.locallife.poi.prefetch.newsdk;

import com.bytedance.locallife.biz.prefetch.newsdk.c;
import com.bytedance.locallife.biz.prefetch.newsdk.e;
import com.bytedance.locallife.biz.prefetch.newsdk.l;
import com.bytedance.locallife.poi.settings.IPoiSetting;
import com.bytedance.retrofit2.SsResponse;
import com.ss.android.ugc.aweme.prefetch.newsdk.PrefetchType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiPrefetchKeyStrategy implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f264207a;

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final void f() {
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final String getScene() {
        return "poi_detail";
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final void h() {
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final String i() {
        return "default";
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final boolean l() {
        return true;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final Map<String, String> a() {
        return new LinkedHashMap();
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final Function2<SsResponse<?>, String, Unit> d() {
        l r100 = this.f264207a;
        if (r100 == null) goto L7;
        Function2<SsResponse<?>, String, Unit> r101 = r100.f256964e;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return c.a.a();
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final e k() {
        l r100 = this.f264207a;
        return new e("PERFECT_MATCH", SetsKt.emptySet());
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final PrefetchType m() {
        l r100 = this.f264207a;
        if (r100 == null) goto L7;
        PrefetchType r101 = r100.f256961b;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return PrefetchType.INTERCEPTOR_PREFETCH;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final boolean b() {
        return IPoiSetting.a().u();
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final Function0<Unit> c() {
        return PoiPrefetchKeyStrategy$onPrefetchResult$1.INSTANCE;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final Function0<Unit> e() {
        return PoiPrefetchKeyStrategy$onFetchStart$1.INSTANCE;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final Function0<Unit> g() {
        return PoiPrefetchKeyStrategy$onPrefetchStart$1.INSTANCE;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final Function0<Unit> j() {
        return PoiPrefetchKeyStrategy$onFetchResult$1.INSTANCE;
    }

    public PoiPrefetchKeyStrategy(l r100) {
        this.f264207a = r100;
    }
}
