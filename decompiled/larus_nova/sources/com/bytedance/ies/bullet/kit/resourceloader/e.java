package com.bytedance.ies.bullet.kit.resourceloader;

import com.bytedance.geckox.GeckoClient;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Map<String, GeckoClient>> f246811a;

    public e() {
        this.f246811a = new HashMap();
    }

    public final void a(String r100, String r101, GeckoClient r102) {
        Intrinsics.checkNotNullParameter(r100, "accessKey");
        Intrinsics.checkNotNullParameter(r101, "bid");
        HashMap<String, Map<String, GeckoClient>> r103 = this.f246811a;
        monitor-enter(r103);
        Map<String, GeckoClient> r104 = this.f246811a.get(r101);     // Catch: Throwable -> L10
        if (r104 != null) goto L7;
        r104 = new LinkedHashMap();     // Catch: Throwable -> L10
    L7:
        r104.put(r100, r102);     // Catch: Throwable -> L10
        this.f246811a.put(r101, r104);     // Catch: Throwable -> L10
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r103);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
