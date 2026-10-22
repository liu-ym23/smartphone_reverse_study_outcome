package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.util.JSONUtilsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class i extends com.bytedance.ies.argus.strategy.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f245748b;

    public i() {
        this(0);
    }

    @Override // com.bytedance.ies.argus.strategy.a
    public final String toString() {
        JSONObject r100 = new JSONObject();
        JSONUtilsKt.d(r100, "new_user_agent", this.f245748b);
        return r100.toString();
    }

    public i(int r100) {
        this.f245748b = null;
    }
}
