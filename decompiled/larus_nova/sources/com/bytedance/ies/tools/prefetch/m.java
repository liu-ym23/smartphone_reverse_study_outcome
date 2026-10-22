package com.bytedance.ies.tools.prefetch;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface m {

    public static class a implements m {
        public a() {
        }

        @Override // com.bytedance.ies.tools.prefetch.m
        public void a(JSONObject r100) {
        }

        @Override // com.bytedance.ies.tools.prefetch.m
        public void onFailed(Throwable r100) {
        }

        public void b(i.b r100) {
            a(r100.b());
        }
    }

    void a(JSONObject r100);

    void onFailed(Throwable r100);
}
