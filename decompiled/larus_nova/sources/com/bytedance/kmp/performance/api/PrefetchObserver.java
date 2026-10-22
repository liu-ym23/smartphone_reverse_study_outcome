package com.bytedance.kmp.performance.api;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchObserver;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\b\u0010%\u001a\u00020#H\u0002J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'J\u0018\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0005H\u0016J \u0010,\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u000bH\u0016J \u0010/\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u000bH\u0016J \u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018¨\u00064"}, d2 = {"Lcom/bytedance/kmp/performance/api/PrefetchObserver;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchObserver;", "<init>", "()V", "reachMaxMissCount", "", "getReachMaxMissCount", "()Z", "setReachMaxMissCount", "(Z)V", "averagePrecomposeTime", "", "getAveragePrecomposeTime", "()J", "setAveragePrecomposeTime", "(J)V", "averagePremeasureTime", "getAveragePremeasureTime", "setAveragePremeasureTime", "precomposeInvalidCount", "", "getPrecomposeInvalidCount", "()I", "setPrecomposeInvalidCount", "(I)V", "precomposeSuccessCount", "getPrecomposeSuccessCount", "setPrecomposeSuccessCount", "premeasureInvalidCount", "getPremeasureInvalidCount", "setPremeasureInvalidCount", "premeasureSuccessCount", "getPremeasureSuccessCount", "setPremeasureSuccessCount", "start", "", "stop", BasicTestActionHandler.TEST_ACTION_RESET, "fillMetrics", "Lcom/bytedance/kmp/performance/model/PerformanceMetrics;", "metrics", "onPrefetchRequestInvalid", "index", "hasPrecompose", "onPrecomposeItem", "executed", "averageTime", "onPreMeasureItem", "onReachLimitTime", "limitTime", "averageComposeTime", "averagePreMeasureTime", "performance_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrefetchObserver implements LazyLayoutPrefetchObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f252596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f252597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f252598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f252599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f252600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f252601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f252602g;

    public PrefetchObserver() {
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchObserver
    public final void onPrefetchRequestInvalid(final int r100, final boolean r101) {
        ld6.a.a(ld6.b.f508697a, new w(r100, r101));
        this.f252601f++;
        if (r101 == true) goto L6;
        this.f252599d++;
        return;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchObserver
    public final void onPreMeasureItem(final int r100, final boolean r101, final long r102) {
        ld6.a.a(ld6.b.f508697a, new y(r100, r101, r102));
        if (r101 == false) goto L5;
        this.f252602g++;
    L5:
        this.f252598c = r102;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchObserver
    public final void onPrecomposeItem(final int r100, final boolean r101, final long r102) {
        ld6.a.a(ld6.b.f508697a, new x(r100, r101, r102));
        if (r101 == false) goto L5;
        this.f252600e++;
    L5:
        this.f252597b = r102;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchObserver
    public final void onReachLimitTime(final int r100, final long r110, final long r111) {
        ld6.a.a(ld6.b.f508697a, new z(r100, r110, r111));
        this.f252596a = true;
        this.f252597b = r110;
        this.f252598c = r111;
    }
}
