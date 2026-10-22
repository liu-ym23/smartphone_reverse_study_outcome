package com.huawei.agconnect.core.service.auth;

import com.huawei.hmf.tasks.Task;

/* JADX INFO: loaded from: classes23.dex */
public interface AuthProvider {
    void addTokenListener(OnTokenListener r100);

    Task<Token> getTokens();

    Task<Token> getTokens(boolean r100);

    String getUid();

    void removeTokenListener(OnTokenListener r100);
}
