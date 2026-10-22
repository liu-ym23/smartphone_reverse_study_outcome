package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.account.base.api.ILoginService;

/* JADX INFO: loaded from: classes5.dex */
public final class c implements a {
    public c() {
    }

    @Override // com.obric.assistant.provider.hybrid.a
    public Bundle call(String r100, Bundle r101) {
        Bundle r102 = new Bundle();
        r102.putBoolean("is_login", ILoginService.f286097a.getAccountInfo().f531528a);
        return r102;
    }
}
