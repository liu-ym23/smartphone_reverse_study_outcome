package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends com.bytedance.android.shopping.utils.m {
    public final /* synthetic */ AnchorV4DetailLargeImageVH a;
    public final /* synthetic */ String b;

    public final void onFailed(DownloadInfo r1, BaseException r2) {
    }

    public final void onSuccessed(DownloadInfo r3) {
        PolarisFileWrapper r4 = new PolarisFileWrapper(this.b);
        this.a.b.setInputStream(new PolarisFileInputStreamWrapper(r4));
    }

    public h(AnchorV4DetailLargeImageVH r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
