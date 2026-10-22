package com.bytedance.caijing.sdk.infra.base.api.container;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import cd4.c;
import cd4.e;
import cd4.f;
import cd4.q;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u001aJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0013H&J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/IBulletService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Lcd4/e;", "getBulletHelper", "Lcd4/c;", "getAnnieXRouterHelper", "Landroid/net/Uri;", "schema", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "cacheTime", "Lcd4/f;", "callback", "", "preRender", "", "Landroid/app/Activity;", "activity", "Lcom/bytedance/caijing/sdk/infra/base/api/container/IBulletService$a;", "Landroid/app/Application;", "application", "bid", "anniexDispatchFlow", "Lcd4/q;", "getStorageHelper", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface IBulletService extends ICJService {

    /* JADX INFO: loaded from: classes15.dex */
    public interface a {
        void onFail(String r100);

        void onSuccess();
    }

    String anniexDispatchFlow(Application r100, String r101, Uri r102);

    c getAnnieXRouterHelper();

    e getBulletHelper();

    q getStorageHelper();

    void preRender(Uri r100, Context r101, long r102, f r103);

    void preRender(String r100, Activity r101, long r102, a r103);
}
