package com.ss.android.bytedcert.callback;

/* JADX INFO: loaded from: classes34.dex */
public interface PhotoCallback {

    public interface PickCallback {
        void onPick(int r100, ResultCallBack r101);
    }

    public interface ResultCallBack {
        void onResult(String[] r100, int r101, String r102);
    }
}
