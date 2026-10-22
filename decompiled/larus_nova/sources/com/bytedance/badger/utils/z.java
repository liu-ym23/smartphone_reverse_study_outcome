package com.bytedance.badger.utils;

import com.bytedance.bd_sec_tee.core.TeeProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class z implements TeeProvider.b {
    public z() {
    }

    @Override // com.bytedance.bd_sec_tee.core.TeeProvider.b
    public final void onEvent(JSONObject r100) {
        com.bytedance.badger.e.d("tee_result_monitor", r100);
    }
}
