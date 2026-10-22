package com.ss.android.lark.integrator.ccm.config.manis;

import android.content.Context;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;

/* JADX INFO: loaded from: classes36.dex */
@RemoteServiceImpl(service = IDocManisService.class)
public class DocManisServiceImpl implements IDocManisService {
    private Context mContext;

    public DocManisServiceImpl(Context r100) {
        this.mContext = r100;
    }

    @Override // com.ss.android.lark.integrator.ccm.config.manis.IDocManisService
    public void onDocInitReady(IDocManisService.a r100) {
        r100.a();
    }
}
