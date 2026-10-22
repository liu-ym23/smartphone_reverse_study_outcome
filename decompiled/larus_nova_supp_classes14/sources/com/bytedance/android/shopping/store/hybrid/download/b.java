package com.bytedance.android.shopping.store.hybrid.download;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.home.event.ECIsvComponentLoadEvent;
import com.bytedance.android.shopping.store.utils.h;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements k7a.a {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    public final void loadDynamicComponent(final String r18, final k7a.a.a r19) {
        String r0 = ISVDownloadManager.a;
        final long r12 = System.currentTimeMillis();
        if (r18 == null) goto L25;
        if (r19 == null) goto L25;
        final Context r14 = ECAppInfoService.e.getApplicationContext();
        if (r14 != null) goto L9;
        dm.a.a("ISVDownloadManager").b("loadDynamicComponent failed as app context is null", null);
        return;
    L9:
        Uri r2 = UriProtector.parse(r18);
        String r3 = UriProtector.getQueryParameter(r2, "version");
        if (r3 != null) goto L12;
        r3 = CommentScene.COMMENTSCENE_NO_AWEME;
    L12:
        final ECIsvComponentLoadEvent r15 = new ECIsvComponentLoadEvent();
        String r9 = r2.buildUpon().clearQuery().build().toString();
        final String r4 = ISVDownloadManager.c(r9, r3);
        PolarisFileWrapper r5 = new PolarisFileWrapper(r14.getFilesDir(), "ecommerce");
        ISVDownloadManager.b = r5.toString();
        if (r5.exists() == true) goto L15;
        r5.mkdir();
    L15:
        PolarisFileWrapper r6 = new PolarisFileWrapper(ISVDownloadManager.b, "ec_isv");
        String r7 = UriProtector.getQueryParameter(r2, "log_isv_extra");
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        r15.setLogIsvExtra(r7);
        final PolarisFileWrapper r8 = new PolarisFileWrapper(r6, r4 + ".js");
        r15.setCdnUrl(r9);
        if (ISVDownloadManager.d(r14, r8, r4, r3) == true) goto L24;
        r19.a(FilesKt.readBytes(r8), null);
        h r10 = ISVDownloadManager.c;
        if (r10 == null) goto L23;
        Intrinsics.checkNotNullParameter(r4, "element");
        r10.f.remove(r4);
        r10.f.add(r4);
        r10.c = true;
    L23:
        dm.a.a("ISVDownloadManager").i("loadDynamicComponent hit local file, url: " + r18 + ", timeCost: " + (System.currentTimeMillis() - r12));
        r15.setExpired(Boolean.FALSE);
        r15.setHitVersion(ISVDownloadManager.a);
        r15.setTimeCost(Long.valueOf(System.currentTimeMillis() - r12));
        r15.post(null, null);
        return;
    L24:
        r15.setExpired(Boolean.TRUE);
        r15.setHitVersion(ISVDownloadManager.a);
        final String r11 = r3;
        ISVDownloadManager.b(r9, r8, r14, new ISVDownloadManager$loadDynamicComponent$1(r4, r11, r14, r19, r8, r18, r12, r15), new ISVDownloadManager$loadDynamicComponent$2(r19, r18, r12, r15));
        return;
    L25:
        dm.a.a("ISVDownloadManager").b("loadDynamicComponent failed, url: " + r18 + ", handler: " + r19, null);
    }
}
