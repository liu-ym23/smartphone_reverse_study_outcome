package com.bytedance.applet.impl;

import android.app.Application;
import android.content.Context;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements IHostContextDepend {
    public m() {
    }

    public final String getAppUaName() {
        return "Doubao";
    }

    public final int getAppId() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 != null) goto L7;
        String r1 = mx7.c.a;
        return mx7.c.c;
    L7:
        return r0.getAppId();
    }

    public final String getAppName() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 == null) goto L6;
        String r1 = r0.getAppName();
        if (r1 == null) goto L6;
        return r1;
    L6:
        String r2 = mx7.c.a;
        return mx7.c.b;
    }

    public final Application getApplication() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 == null) goto L7;
        Application r1 = r0.getApplication();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return mx7.c.b();
    }

    public final String getChannel() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 == null) goto L6;
        String r1 = r0.getChannel();
        if (r1 == null) goto L6;
        return r1;
    L6:
        String r2 = mx7.c.a;
        return mx7.c.h;
    }

    public final String getClientDid() {
        return com.larus.platform.service.o.a.getClientDid();
    }

    public final String getCurrentTelcomCarrier() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentTelcomCarrier();
    }

    public final String getDeviceId() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 == null) goto L6;
        String r1 = r0.getDeviceId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        String r2 = mx7.c.a;
        return mx7.c.j;
    }

    public final String getLanguage() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 == null) goto L6;
        String r1 = r0.getLanguage();
        if (r1 == null) goto L6;
    L8:
        if (AppHost.a.isOversea() == true) goto L11;
        String r2 = com.larus.utils.b0.a;
        return com.larus.utils.b0.e(Locale.CHINA.getLanguage());
    L11:
        Intrinsics.checkNotNull(r1);
        return r1;
    L6:
        r1 = Locale.getDefault().getLanguage();
        goto L8
    }

    public final String getPackageName() {
        return AppHost.a.getApplication().getPackageName();
    }

    public final String getSkinName() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 == null) goto L7;
        String r1 = r0.getSkinName();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return mx7.c.a();
    }

    public final String getUpdateVersion() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 == null) goto L6;
        String r1 = r0.getUpdateVersion();
        if (r1 == null) goto L6;
        return r1;
    L6:
        String r2 = mx7.c.a;
        return mx7.c.f;
    }

    public final String getVersionName() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 == null) goto L6;
        String r1 = r0.getVersionName();
        if (r1 == null) goto L6;
        return r1;
    L6:
        String r2 = mx7.c.a;
        return mx7.c.d;
    }

    public final boolean isBaseMode() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.isBaseMode();
    }

    public final boolean isTeenMode() {
        XBaseRuntime.a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r0 = XBaseRuntime.f;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isTeenMode();
    }

    public final Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public final String getHttpEnv() {
        if (HttpExtKt.e().a == false) goto L6;
        return HttpExtKt.e().b;
    L6:
        if (HttpExtKt.e().c == true) goto L11;
        return null;
    L11:
        return HttpExtKt.e().d;
    }
}
