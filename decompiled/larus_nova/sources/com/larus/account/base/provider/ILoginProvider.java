package com.larus.account.base.provider;

import com.larus.account.base.model.LoginPlatform;
import kotlin.Metadata;
import n38.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/larus/account/base/provider/ILoginProvider;", "", "init", "", "providePlatform", "Lcom/larus/account/base/model/LoginPlatform;", "logout", "forceLogout", "", "callback", "Lcom/larus/account/base/api/IAccountCallback;", "businessScene", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILoginProvider {
    LoginPlatform c();

    void init();

    void o(h r100, String r101);
}
