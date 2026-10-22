package com.bytedance.ee.bear.bitable.homepage.chart.home.datasource;

import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes15.dex */
public final class ChartListDataCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f212519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f212520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f212521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f212522d;

    public static final class a {
    }

    static {
    }

    public ChartListDataCache() {
        this.f212519a = new Gson();
        this.f212520b = LazyKt.lazy(ChartListDataCache$timeoutSeconds$2.INSTANCE);
        this.f212522d = new Handler(Looper.getMainLooper());
    }

    public final void a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "chartList");
        this.f212522d.post(new com.bytedance.ee.bear.bitable.homepage.chart.home.datasource.a(this, r100));
    }

    public final Object b(Continuation<? super d> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ChartListDataCache$fetchLocal$2(this, null), r100);
    }
}
