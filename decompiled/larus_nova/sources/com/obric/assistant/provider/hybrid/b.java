package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.account.base.api.ILoginService;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements a {
    public b() {
    }

    @Override // com.obric.assistant.provider.hybrid.a
    public Bundle call(String r100, Bundle r101) {
        Bundle r102 = new Bundle();
        ILoginService.Companion r103 = ILoginService.f286097a;
        r102.putBoolean("is_login", r103.getAccountInfo().f531528a);
        r102.putBoolean("is_enterprise", r103.getAccountInfo().f531534g);
        return r102;
    }
}
