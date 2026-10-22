package com.bytedance.locallife.biz.prefetch.newsdk;

import com.bytedance.retrofit2.SsResponse;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.ugc.aweme.prefetch.newsdk.PrefetchType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f256940b;

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final boolean b() {
        return false;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final Function0<Unit> c() {
        return null;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final Function0<Unit> e() {
        return null;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final void f() {
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final Function0<Unit> g() {
        return null;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final void h() {
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final Function0<Unit> j() {
        return null;
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
    public final String i() {
        String r100 = this.f256940b;
        if (r100 != null) goto L6;
        return "default";
    L6:
        return r100;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final e k() {
        return new e("PERFECT_MATCH", SetsKt.emptySet());
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final Function2<SsResponse<?>, String, Unit> d() {
        return IPrefetchConfig$getDataCallBack$1.INSTANCE;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final String getScene() {
        return this.f256939a;
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.c
    public final PrefetchType m() {
        return PrefetchType.INTERCEPTOR_PREFETCH;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, NativeDownloadModel.JsonKey.SCENE);
        this.f256939a = r100;
        this.f256940b = null;
    }
}
