package com.ss.android.cert.manager.api;

import android.content.Context;
import com.ss.android.cert.manager.callback.UserIdentityResultCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface IByteUserIdentity {
    void startFlow(Context r100, Map<String, String> r101, UserIdentityResultCallback r102);
}
