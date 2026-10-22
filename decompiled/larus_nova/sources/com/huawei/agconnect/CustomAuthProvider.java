package com.huawei.agconnect;

import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;

/* JADX INFO: loaded from: classes23.dex */
public interface CustomAuthProvider {
    Task<Token> getTokens(boolean r100);

    String getUid();
}
