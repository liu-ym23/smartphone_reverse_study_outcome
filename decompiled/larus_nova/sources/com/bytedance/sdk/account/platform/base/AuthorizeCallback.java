package com.bytedance.sdk.account.platform.base;

import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public interface AuthorizeCallback {
    void onError(AuthorizeErrorResponse r100);

    void onSuccess(Bundle r100);
}
