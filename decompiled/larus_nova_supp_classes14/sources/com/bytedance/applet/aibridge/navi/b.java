package com.bytedance.applet.aibridge.navi;

import android.app.Application;
import com.bytedance.ai.api.navi.IAppletNaviService;
import com.larus.common.apphost.AppHost;
import f3.h;
import k3.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements IAppletNaviService.a {
    public final /* synthetic */ h<AbsStartThirdNaviOrPlanMethodIDL.b> a;
    public final /* synthetic */ String b;
    public final /* synthetic */ StartThirdNaviOrPlanMethod c;
    public final /* synthetic */ String d;

    public final void onResult(int r7, String r8) {
        h<AbsStartThirdNaviOrPlanMethodIDL.b> r0 = this.a;
        Intrinsics.checkNotNullParameter(AbsStartThirdNaviOrPlanMethodIDL.b.class, "<this>");
        AbsStartThirdNaviOrPlanMethodIDL.b r1 = c.a(AbsStartThirdNaviOrPlanMethodIDL.b.class);
        String r2 = this.b;
        StartThirdNaviOrPlanMethod r3 = this.c;
        String r4 = this.d;
        AbsStartThirdNaviOrPlanMethodIDL.b r5 = r1;
        r5.setResult(r7);
        r5.setAppName(r8);
        AppHost.Companion r9 = AppHost.a;
        r5.setBackground(r9.a().isAppBackground() ? 1 : 0);
        if (r2 != null) goto L17;
        int r10 = StartThirdNaviOrPlanMethod.b;
        r3.getClass();
        xv3.h r11 = xv3.h.a;
        Application r6 = r9.getApplication();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        if (xv3.h.b(r6, "com.autonavi.minimap") == false) goto L7;
        r2 = ",amap";
    L8:
        Application r12 = r9.getApplication();
        Intrinsics.checkNotNullParameter(r12, "context");
        if (xv3.h.b(r12, "com.baidu.BaiduMap") == false) goto L12;
        r2 = r2.concat(",baidu");
    L12:
        if (r2.length() <= 0) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == false) goto L17;
        r2 = r2.substring(1);
        goto L17
    L14:
        r13 = false;
        goto L15
    L7:
        r2 = "";
    L17:
        r5.setAvailableApps(r2);
        r5.setSelectedApp(r4);
        h.a.b(r0, r1);
    }

    public b(h<AbsStartThirdNaviOrPlanMethodIDL.b> r1, String r2, StartThirdNaviOrPlanMethod r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
