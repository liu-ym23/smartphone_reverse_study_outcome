package com.ss.android.lark.image.impl;

import android.content.Context;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.service.IImageManisService;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;

/* JADX INFO: loaded from: classes36.dex */
@RemoteServiceImpl(service = IImageManisService.class)
public class ImageManisService implements IImageManisService {
    private Context mContext;

    public ImageManisService(Context r100) {
        this.mContext = r100;
    }

    @Override // com.ss.android.lark.image.service.IImageManisService
    public void uploadEncryptImage(String r100, boolean r110, boolean r111, final IImageManisService.a r112) {
        new ImageModule().b(this.mContext, r100, r110, r111, true, null, new AnonymousClass1(this, r112));
    }
}
