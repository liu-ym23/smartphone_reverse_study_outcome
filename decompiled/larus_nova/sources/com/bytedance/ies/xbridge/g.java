package com.bytedance.ies.xbridge;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f249496c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f249497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<XBridgePlatformType, ConcurrentHashMap<String, Class<? extends IDLXBridgeMethod>>> f249498b;

    public static final class a {
    }

    static {
    }

    public g() {
        this.f249497a = "DEFAULT";
        this.f249498b = new LinkedHashMap();
    }
}
