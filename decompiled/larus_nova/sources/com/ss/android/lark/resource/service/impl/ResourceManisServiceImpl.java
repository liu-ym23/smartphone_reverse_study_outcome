package com.ss.android.lark.resource.service.impl;

import android.content.Context;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;
import com.ss.android.lark.resource.service.IResourceManisService;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
@RemoteServiceImpl(service = IResourceManisService.class)
public class ResourceManisServiceImpl implements IResourceManisService {
    private Context mContext;
    private ImageService mImageService;

    private ImageService getRealService() {
        if (this.mImageService != null) goto L6;
        this.mImageService = new ImageService();
    L6:
        return this.mImageService;
    }

    public ResourceManisServiceImpl(Context r100) {
        this.mContext = r100;
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public String getAvatarPath(String r100, String r101, int r102, float r103) {
        return getRealService().getAvatarPathInMainProcess(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r100, String r101, String r110, String r111, String r112, boolean r113) {
        return getRealService().getEncryptImageInMainProcess(r100, r101, r110, ByteString.encodeUtf8(r111), r112, r113);
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r100, String r110, String r111, String r112, String r113, boolean r114, int r115) {
        return getRealService().getEncryptImageInMainProcess(r100, r110, r111, ByteString.encodeUtf8(r112), r113, r114, r115);
    }
}
