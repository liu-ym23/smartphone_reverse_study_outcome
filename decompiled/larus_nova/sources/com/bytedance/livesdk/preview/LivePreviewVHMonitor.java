package com.bytedance.livesdk.preview;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes20.dex */
public final class LivePreviewVHMonitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f256396c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Object> f256397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Object> f256398b;

    public static final class a {
    }

    static {
        f256396c = LazyKt.lazy(LivePreviewVHMonitor$Companion$singleInstance$2.INSTANCE);
    }

    public LivePreviewVHMonitor() {
        this.f256397a = new LinkedHashMap();
        this.f256398b = new LinkedHashMap();
    }
}
