package com.ss.android.lark.dynamicconfig.service.impl;

import android.content.Context;
import com.ss.android.lark.dynamicconfig.interfaces.IDynamicManisService;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;
import jcb.b;

/* JADX INFO: loaded from: classes35.dex */
@RemoteServiceImpl(service = IDynamicManisService.class)
public class DynamicManisServiceImpl implements IDynamicManisService {
    private Context mContext;

    public DynamicManisServiceImpl(Context r100) {
        this.mContext = r100;
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDynamicManisService
    public String getDynamicDomain(String r100) {
        return b.c().a(r100);
    }
}
