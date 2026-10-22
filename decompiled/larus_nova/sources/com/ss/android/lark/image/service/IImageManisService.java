package com.ss.android.lark.image.service;

import com.ss.android.lark.image.entity.EncryptImageData;
import com.ss.android.lark.manis.annotation.RemoteCallback;
import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;

/* JADX INFO: loaded from: classes36.dex */
@RemoteService
public interface IImageManisService extends IHookInterface {

    @RemoteCallback
    public interface a {
        void onError(ErrorResultWrapper r100);

        void onSuccess(EncryptImageData r100);
    }

    void uploadEncryptImage(String r100, boolean r101, boolean r102, a r103);
}
