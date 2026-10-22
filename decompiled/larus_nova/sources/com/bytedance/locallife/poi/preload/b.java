package com.bytedance.locallife.poi.preload;

import android.os.SystemClock;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f264212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f264213b;

    public b() {
        this.f264212a = new LinkedHashMap();
        this.f264213b = SystemClock.elapsedRealtime();
    }
}
