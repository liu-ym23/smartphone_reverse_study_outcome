package com.larus.account.base.api;

import com.larus.home.impl.sdk.l0;
import kotlin.Metadata;
import n38.q;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/larus/account/base/api/IDouyinAuthService;", "", "startDouyinAuth", "", "clientKey", "", "scope", "state", "isMiniApplication", "callback", "Lcom/larus/account/base/api/IDouyinAuthCallback;", "checkDouyinAuthStatus", "", "Lcom/larus/account/base/api/IDouyinAuthStatusCheckCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDouyinAuthService {
    void a(String r100, String r101, String r102, l0 r103);

    boolean b(String r100, String r101, String r102, boolean r103, q r104);
}
