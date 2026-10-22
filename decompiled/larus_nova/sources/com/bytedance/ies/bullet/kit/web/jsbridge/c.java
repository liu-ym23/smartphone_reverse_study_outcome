package com.bytedance.ies.bullet.kit.web.jsbridge;

import com.bytedance.ies.bullet.kit.web.download.WebResourceDownloader;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(biz = "bullet", name = "bullet.downloadWebContent")
public final class c extends com.bytedance.ies.bullet.core.kit.bridge.c implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBridgeMethod.Access f247045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f247046d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f247045c;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return this.f247046d;
    }

    public c(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        super(r100);
        this.f247045c = IBridgeMethod.Access.PRIVATE;
        this.f247046d = "bullet.downloadWebContent";
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r110, IBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        JSONArray r100 = r110.optJSONArray("urls");
        if (r100 != null) goto L5;
    L30:
        JSONObject r101 = new JSONObject();
        r101.put("code", 0);
        r111.onComplete(r101);
        return;
    L5:
        if (r100.length() == 0) goto L30;
        int r102 = r100.length();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L28;
        String r104 = JSONArrayProtectorUtils.getString(r100, r103);
        ExecutorService r105 = BulletLogger.f247763a;
        BulletLogger.k(this.f247046d + " start download " + r104, null, "XPreload", 2);
        WebResourceDownloader r106 = WebResourceDownloader.f246955d.getValue();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r104, "url");
        PolarisFileWrapper r112 = r106.f246957b;
        if (r112 == null) goto L27;
        String r113 = WebResourceDownloader.b(r104);
        if (r113 == null) goto L27;
        PolarisFileWrapper r114 = new PolarisFileWrapper(r112, r113);
        if (r114.exists() == false) goto L17;
        r114.delete();
    L17:
        DownloadTask r107 = Downloader.with(r106.f246956a).url(r104).name(r113).savePath(r112.getPath()).addListenerToSameTask(true).addTTNetCommonParam(Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r104), "need_common_params"), "1")).deleteCacheIfCheckFailed(true).retryCount(0).autoSetHashCodeForSameTask(true).ttnetProtectTimeout(20000).expiredRedownload(true).expiredHttpCheck(Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r104), "cdn_negotiate"), "1")).mainThreadListener(new com.bytedance.ies.bullet.kit.web.download.a(r106, r104)).monitorScene("XWeb");
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L24
        Method r109 = WebResourceDownloader.f246954c;     // Catch: Throwable -> L24
        if (r109 == null) goto L21;
        Object r115 = r109.invoke(r107, new Object[]{1209600L});     // Catch: Throwable -> L24
    L22:
        Result.m9449constructorimpl(r115);     // Catch: Throwable -> L24
    L26:
        r107.asyncDownload(null);
        goto L27
    L21:
        r115 = null;
    L24:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L27:
        r103 = r103 + 1;
        goto L9
    L28:
        JSONObject r117 = new JSONObject();
        r117.put("code", 1);
        r111.onComplete(r117);
    }
}
