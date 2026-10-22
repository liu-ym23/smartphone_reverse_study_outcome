package com.obric.aiagent.messenger.stub;

import android.os.SystemClock;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f384885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f384886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f384887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f384888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f384889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f384890f;

    public final Map<String, Object> a() {
        Pair[] r100 = new Pair[5];
        r100[0] = TuplesKt.to("encrypt_cost_ms", Long.valueOf(this.f384888d));
        r100[1] = TuplesKt.to("total_prepare_cost_ms", Long.valueOf(SystemClock.elapsedRealtime() - this.f384886b));
        if (this.f384889e == false) goto L5;
        long r101 = 1;
    L6:
        r100[2] = TuplesKt.to("feature_heif", Long.valueOf(r101));
        r100[3] = TuplesKt.to("screenshot_size", Long.valueOf(this.f384890f));
        r100[4] = TuplesKt.to("flow_received_elapsed_ms", Long.valueOf(this.f384885a));
        return MapsKt.mapOf(r100);
    L5:
        r101 = 0;
        goto L6
    }

    public f(long r100) {
        this.f384885a = r100;
        this.f384886b = SystemClock.elapsedRealtime();
    }
}
