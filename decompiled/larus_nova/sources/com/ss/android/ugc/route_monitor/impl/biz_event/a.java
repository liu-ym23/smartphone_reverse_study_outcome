package com.ss.android.ugc.route_monitor.impl.biz_event;

import androidx.camera.core.RetryPolicy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f454416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f454417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f454418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f454419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f454420e;

    public a() {
        this(null);
    }

    public final String toString() {
        return "{enable = " + this.f454416a + ", bizEventCacheListCapacity = " + this.f454417b + ", beforeRouteTimeWindow = " + this.f454418c + ", afterRouteTimeWindow = " + this.f454419d + ", canRecordBizEventMap = " + this.f454420e + '}';
    }

    public a(Object r100) {
        HashMap r101 = new HashMap();
        this.f454416a = false;
        this.f454417b = 200;
        this.f454418c = RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
        this.f454419d = RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
        this.f454420e = r101;
    }
}
