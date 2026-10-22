package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f192783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f192784b;

    public p(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        this.f192783a = r100.optInt("backoff_ratio", 0);
        this.f192784b = r100.optInt("max_request_frequency", 10);
    }
}
