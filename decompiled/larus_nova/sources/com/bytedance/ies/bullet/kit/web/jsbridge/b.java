package com.bytedance.ies.bullet.kit.web.jsbridge;

import android.app.Application;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.kit.web.download.WebResourceDownloader;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(biz = "bullet", name = "bullet.cancelDownloadWeb")
public final class b extends com.bytedance.ies.bullet.core.kit.bridge.c implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBridgeMethod.Access f247043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f247044d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f247043c;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return this.f247044d;
    }

    public b(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        super(r100);
        this.f247043c = IBridgeMethod.Access.PRIVATE;
        this.f247044d = "bullet.cancelDownloadWeb";
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r110, IBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Application r100 = i.f246825b;
        Unit r101 = null;
        if (r100 != null) goto L5;
    L26:
        if (r101 != null) goto L34;
        JSONObject r112 = new JSONObject();
        r112.put("code", 0);
        r111.onComplete(r112);
        return;
    L34:
        return;
    L5:
        if (new PolarisFileWrapper(r100.getCacheDir(), "rl_resource_offline").exists() == true) goto L8;
        JSONObject r113 = new JSONObject();
        r113.put("code", 0);
        r111.onComplete(r113);
        return;
    L8:
        JSONArray r114 = r110.optJSONArray("urls");
        if (r114 != null) goto L11;
    L24:
        JSONObject r115 = new JSONObject();
        r115.put("code", 0);
        r111.onComplete(r115);
        return;
    L11:
        if (r114.length() == 0) goto L24;
        int r102 = r114.length();
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L23;
        String r104 = JSONArrayProtectorUtils.getString(r114, r103);
        ExecutorService r105 = BulletLogger.f247763a;
        BulletLogger.k(this.f247044d + " start cancel " + r104, null, "XPreload", 2);
        WebResourceDownloader r106 = WebResourceDownloader.f246955d.getValue();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r104, "url");
        PolarisFileWrapper r107 = r106.f246957b;
        if (r107 == null) goto L22;
        String r108 = WebResourceDownloader.b(r104);
        if (r108 == null) goto L22;
        PolarisFileWrapper r116 = new PolarisFileWrapper(r107, r108);
        if (r116.exists() == false) goto L22;
        BulletLogger.k("WebResourceDownloader: delete cache of url=" + r104 + " from destination=" + r116, null, "XPreload", 2);
        r116.delete();
    L22:
        r103 = r103 + 1;
        goto L14
    L23:
        JSONObject r117 = new JSONObject();
        r117.put("code", 1);
        r111.onComplete(r117);
        r101 = Unit.INSTANCE;
        goto L26
    }
}
