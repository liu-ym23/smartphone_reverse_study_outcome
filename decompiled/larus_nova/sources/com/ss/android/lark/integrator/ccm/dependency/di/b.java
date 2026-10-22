package com.ss.android.lark.integrator.ccm.dependency.di;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements xw4.a {
    public b() {
    }

    @Override // xw4.a
    public final void sendEvent(String r100, JSONObject r101) {
        com.ss.android.lark.statistics.b.b(r100, r101);
    }
}
