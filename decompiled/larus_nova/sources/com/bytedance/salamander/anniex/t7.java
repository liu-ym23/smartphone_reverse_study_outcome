package com.bytedance.salamander.anniex;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes20.dex */
public final class t7 extends u5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Object> f268396c;

    public t7() {
        this.f268396c = new LinkedHashMap();
    }

    @Override // com.bytedance.salamander.anniex.u5
    public final SLEventType a() {
        return SLEventType.RES_LOADER_ERROR_TEMPLATE;
    }
}
