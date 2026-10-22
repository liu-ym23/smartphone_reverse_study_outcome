package com.bytedance.live.zdanmaku.data;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, Class<?>> f255838a;

    public d() {
        this.f255838a = new HashMap();
    }

    public final void a(Class<?> r100, Class<?> r101) {
        ((HashMap) this.f255838a).put(r100, r101);
    }
}
