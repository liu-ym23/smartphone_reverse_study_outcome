package com.larus.office.card.urlpreview;

import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes29.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361903a = 0;

    static {
    }

    public static void a(int r100, boolean r101, String r102) {
        FLogger.f375446a.i("OfficeUrlPreviewSDK", "native detail prefetch result=" + r101 + ", resourceType=" + r100 + ", resourceId=" + r102);
    }

    public static String b(ArtifactBlock r100, String r101, String r102) {
        return r101 + '-' + r100.getResourceType() + '-' + r100.getArtifactMetaId() + '-' + r100.getResourceVersion() + '-' + r102;
    }
}
