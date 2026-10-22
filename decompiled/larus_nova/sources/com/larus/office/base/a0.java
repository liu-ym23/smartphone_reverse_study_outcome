package com.larus.office.base;

import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class a0 implements itb.a {
    public a0() {
    }

    @Override // itb.a
    public final String i() {
        return AppHost.f326268a.getApplication().getString(R.string.app_string_name);
    }

    @Override // itb.a
    public final boolean i1() {
        return ILoginService.f286097a.getAccountInfo().f531534g;
    }
}
