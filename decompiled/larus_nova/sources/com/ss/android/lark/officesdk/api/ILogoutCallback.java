package com.ss.android.lark.officesdk.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/api/ILogoutCallback;", "", "onLogoutSuccess", "", "uid", "", "onLogoutError", "error", "", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILogoutCallback {
    void onLogoutError(Throwable r100);

    void onLogoutSuccess(String r100);
}
