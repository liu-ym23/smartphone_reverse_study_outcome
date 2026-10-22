package com.ss.android.lark.chameleon.bridge;

import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes35.dex */
public interface CallBackFunction {

    public static class Simple implements CallBackFunction {
        public Simple() {
        }

        @Override // com.ss.android.lark.chameleon.bridge.CallBackFunction
        public void onCallBack(JsonObject r100) {
        }

        @Override // com.ss.android.lark.chameleon.bridge.CallBackFunction
        public void onCallBack(NonProguard r100) {
        }

        @Override // com.ss.android.lark.chameleon.bridge.CallBackFunction
        public void onCallBack(String r100) {
        }
    }

    void onCallBack(JsonObject r100);

    void onCallBack(NonProguard r100);

    void onCallBack(String r100);
}
