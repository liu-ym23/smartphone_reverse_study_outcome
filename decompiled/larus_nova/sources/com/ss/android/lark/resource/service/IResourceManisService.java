package com.ss.android.lark.resource.service;

import com.ss.android.lark.manis.annotation.RemoteService;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import ee.android.framework.manis.interfaces.IHookInterface;

/* JADX INFO: loaded from: classes37.dex */
@RemoteService
public interface IResourceManisService extends IHookInterface {
    String getAvatarPath(String r100, String r101, int r102, float r103);

    Resource getEncryptImage(String r100, String r101, String r102, String r103, String r104, boolean r105);

    Resource getEncryptImage(String r100, String r101, String r102, String r103, String r104, boolean r105, int r106);
}
