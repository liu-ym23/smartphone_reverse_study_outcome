package com.ss.android.lark.log.trace;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f431422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f431423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f431424c;

    public c() {
        this(null);
    }

    public c(Object r100) {
        Map<String, String> r101 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter("", "message");
        Intrinsics.checkNotNullParameter(r101, "extras");
        this.f431422a = true;
        this.f431423b = true;
        this.f431424c = r101;
    }
}
