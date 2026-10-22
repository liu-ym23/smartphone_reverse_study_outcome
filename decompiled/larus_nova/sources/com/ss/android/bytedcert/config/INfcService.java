package com.ss.android.bytedcert.config;

import android.app.Activity;
import android.content.Context;
import com.ss.android.bytedcert.callback.NfcEventCallback;
import com.ss.android.bytedcert.callback.NfcStatusCallback;

/* JADX INFO: loaded from: classes34.dex */
public interface INfcService {
    boolean caniuseNFC(Context r100, NfcStatusCallback r101);

    void initNFC(Activity r100);

    void startNFC(Activity r100, String r101, NfcEventCallback r102);

    void stopNFC(Activity r100);
}
