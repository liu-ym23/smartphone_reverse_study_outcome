package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f192795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f192796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f192797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f192798d;

    public s(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        long r101 = r100.optLong("max_event_size");
        if (r101 > 0) goto L6;
        r101 = 1048576;
    L6:
        this.f192795a = r101;
        long r102 = r100.optLong("max_request_body_size");
        if (r102 > 0) goto L10;
        r102 = 3145728;
    L10:
        this.f192796b = r102;
        int r103 = r100.optInt("max_request_event_count");
        if (r103 > 0) goto L14;
        r103 = 2000;
    L14:
        this.f192797c = r103;
        long r104 = r100.optLong("event_ttl");
        if (r104 > 0) goto L18;
        r104 = 604800;
    L18:
        this.f192798d = r104;
    }
}
