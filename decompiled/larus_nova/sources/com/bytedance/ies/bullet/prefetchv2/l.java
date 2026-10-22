package com.bytedance.ies.bullet.prefetchv2;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f247550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f247551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f247552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f247553e;

    public final String getType() {
        return this.f247549a;
    }

    public l(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        this.f247549a = "";
        this.f247550b = "";
        this.f247552d = "";
        this.f247549a = r100.optString("type");
        this.f247550b = r100.opt("value");
        this.f247551c = r100.optBoolean("enableAppIdIsolation", false);
        this.f247553e = false;
    }

    public l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawValue");
        this.f247549a = "";
        this.f247550b = "";
        this.f247552d = "";
        this.f247552d = r100;
        this.f247553e = true;
    }
}
