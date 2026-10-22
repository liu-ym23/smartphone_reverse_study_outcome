package com.bytedance.ee.bear.imageviewer;

import android.text.TextUtils;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s3 {
    public s3() {
    }

    public static VFSPath b(String r6, String r7, int r8) {
        ConnectionService.NetworkState r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState();
        if (TextUtils.isEmpty(r6) == false) goto L5;
        String r1 = null;
    L6:
        w85.c r3 = (w85.c) org.koin.java.a.a(w85.c.class);
        w85.a.C0319a r4 = new w85.a.C0319a();
        boolean r5 = false;
        r4.a = false;
        r4.d = r6;
        r4.m = r1;
        r4.b = DownloadRequestInfo.DownloadType.IMG;
        if (r0.a() == false) goto L9;
        r5 = true;
    L9:
        r4.c = r5;
        r4.h = r7;
        r4.i = r8;
        r4.g = ((com.bytedance.ee.bear.f) org.koin.java.a.a(com.bytedance.ee.bear.f.class)).c(r8);
        w85.b r9 = r3.d(new w85.a(r4));
        if (r9.b != null) goto L13;
        return null;
    L13:
        return ay4.d.a().t(r9.b);
    L5:
        r1 = UriProtector.getQueryParameter(UriProtector.parse(r6), "extra");
        goto L6
    }

    public static VFSPath a(RequestManager r2, String r3, String r4, int r5, ImageData.Image r6) {
    L20:
        e = move-exception;
        tt5.a.e("ImageViewerUrlProcessor", "getFileFromUrl(): failed ", e, false);
        return null;
    L4:
        if (((v45.a) org.koin.java.a.a(v45.a.class)).g(r3) == false) goto L7;
        VFSPath r7 = b(r3, r4, r5);     // Catch: Exception -> L20
    L13:
        if (r7 != null) goto L15;
        return r7;
    L15:
        if (r6.getRotation() == null) goto L17;
        float r8 = r6.getRotation().rotation;     // Catch: Exception -> L20
    L18:
        return lu5.a.c(r7, ay4.c.b(Biz.DOCS, "imageViewerCache"), r6.getCrop(), r8);
    L17:
        r8 = 0.0f;
        goto L18
    L7:
        if (com.bytedance.ee.util.io.e.c(r3) == false) goto L12;
        File r9 = (File) r2.load(new BearGlideUrl(r3)).diskCacheStrategy(DiskCacheStrategy.DATA).downloadOnly(ShareItemModel.SRC_TINT_UNDEFINED, ShareItemModel.SRC_TINT_UNDEFINED).get();     // Catch: Exception -> L20
        if (r9 != null) goto L11;
        r7 = null;
        goto L13
    L11:
        r7 = ay4.d.a().t(r9);     // Catch: Exception -> L20
        goto L13
    L12:
        r7 = ay4.d.a().z(r3);     // Catch: Exception -> L20
        goto L13
    }
}
