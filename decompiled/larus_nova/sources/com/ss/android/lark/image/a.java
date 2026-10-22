package com.ss.android.lark.image;

import com.suite.lark.platform.service.resourcerepository.api.Resource;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.lark.image.a$a, reason: collision with other inner class name */
    public interface InterfaceC5041a {
        String getDeviceId();

        String getUserId();
    }

    String findResource(String r100);

    String getAvatarDir();

    Resource getEncryptImage(String r100, String r101, String r102, ByteString r103, String r104, boolean r105, int r106);

    InterfaceC5041a getPassPortDependency();

    boolean isReportImageLoad(int r100, int r101);
}
